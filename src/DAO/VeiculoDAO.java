package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.ConnectionManager;
import domain.Veiculo;

public class VeiculoDAO {

	private Connection conexao = null;
	private PreparedStatement statement = null;
	private ResultSet rs = null;

	public VeiculoDAO() {
		this.conexao = ConnectionManager.getMysqlConnection();
	}

	public VeiculoDAO(Connection conexao) {
		this.conexao = conexao;
	}

	// Método privado que busca no banco usando Placa
	private ResultSet buscaVeiculoNoBancoPorPlaca(String Placa) {

		String sql = "select placa, nome, modelo, marca, anoDeFabricacao, anoDeVenda from VEICULOS where placa = ?"; 

		try {
			this.statement = this.conexao.prepareStatement(sql);
			this.statement.setString(1, Placa);
			rs = statement.executeQuery();

		} catch (SQLException e) {
			System.err.println("____ERRO_____Erro para gerar o RS buscando pela Placa no Banco.____ERRO_____" + e.getMessage());
			e.printStackTrace();
		}

		return rs;

	}

	// Método Privado que transforma o resultado da busca em um veiculo
	private Veiculo transformaResultSetEmVeiculo(ResultSet rs) {
		ResultSet resultSet = rs;

		try {
			Veiculo veiculoSendoBuscado = null;
			resultSet.next();
			veiculoSendoBuscado = new Veiculo(resultSet.getString("placa"),resultSet.getString("nome"),resultSet.getString("modelo"),resultSet.getString("marca"),resultSet.getDate("anoDeFabricacao").toLocalDate(), resultSet.getDate("anoDeVenda").toLocalDate());
			return veiculoSendoBuscado;

		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("____ERRO_____Erro para transformar RS em Veículo. Retornando NULL.____ERRO_____" + e.getMessage());
			return null;
		}

	}

	// Método publico que vai ser usado pela aplicação
	public Veiculo encontraVeiculoPorPlaca(String Placa) {
		String PlacaSendoBuscada = Placa;
		return transformaResultSetEmVeiculo(buscaVeiculoNoBancoPorPlaca(PlacaSendoBuscada));

	}

	// Método privado que busca no banco a lista de todos oss veiculos
	private ResultSet listaTodos() {
		String sql = "select placa, nome, modelo, marca, anoDeFabricacao, anoDeVenda from VEICULOS order by placa";

		try {
			this.statement = this.conexao.prepareStatement(sql);
			rs = statement.executeQuery();
		} catch (SQLException e) {
			System.err.println("____ERRO_____Erro para buscar Veiculo por Placa. Retornando NULL.____ERRO_____" + e.getMessage());
			e.printStackTrace();
		}

		return rs;

	}

	// Método publico que retorna um Array de Veiculos
	public static ArrayList<Veiculo> obterListaDeVeiculos(){

		ArrayList<Veiculo> listaDeVeiculos = new ArrayList<Veiculo>();
		Connection conexao;

		try {
			conexao = ConnectionManager.getMysqlConnection();
			VeiculoDAO veiculoDAO = new VeiculoDAO(conexao);
			ResultSet resultSet = veiculoDAO.listaTodos();

			while (resultSet.next()) {
				Veiculo veiculo = new Veiculo(resultSet.getString("placa"),resultSet.getString("nome"),resultSet.getString("modelo"),resultSet.getString("marca"),resultSet.getDate("anoDeFabricacao").toLocalDate(), resultSet.getDate("anoDeVenda").toLocalDate());
				listaDeVeiculos.add(veiculo);
			}

		} catch (SQLException e) {
			System.err.println("____ERRO_____Erro para obter lista de veiculos.____ERRO_____" + e.getMessage());
			e.printStackTrace();
		}

		return listaDeVeiculos;

	}

	public boolean inserirVeiculoBanco(Veiculo veiculo) {
		String sql = "insert into VEICULOS (placa, nome, modelo, marca, anoDeFabricacao, anoDeVenda) values (? , ? , ? , ? , ? , ? )";

		try {
			this.statement = conexao.prepareStatement(sql);
			this.statement.setString(1, veiculo.getPlacaVeiculo());
			this.statement.setString(2, veiculo.getNomeVeiculo());
			this.statement.setString(3, veiculo.getModeloVeiculo());
			this.statement.setString(4, veiculo.getMarcaVeiculo());
			this.statement.setDate(5, Date.valueOf(veiculo.getAnoDeFabricacao()));
			this.statement.setDate(6, Date.valueOf(veiculo.getAnoDeVenda()));
			this.statement.executeUpdate();	
			System.out.println("Insercao ok");
			return true;
		} catch (SQLException e) {
			System.out.println("____ERRO_____Erro ao criar novo veículo:____ERRO_____ " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}	







}
