package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
//Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

import connection.ConnectionManager;
import domain.Aluguel;
import domain.Cliente;
import domain.Veiculo;

public class AluguelDAO {
	
	final static LocalDate hoje = LocalDate.now();
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

	private Connection conexao = null;
	private PreparedStatement statement = null;
	private ResultSet rs = null;

	public AluguelDAO() {
		this.conexao = ConnectionManager.getMysqlConnection();
	}
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

	public AluguelDAO(Connection conexao) {
		this.conexao = conexao;
	}

	private ResultSet listaTodos() {
		String sql = "select idAluguel, dataDeInicioAluguel, dataDeTerminoAluguel, quantidadeDeDiarias, valorDiaria, taxas, valorTotal, nomeClienteAluguel, cpfClienteAluguel, placaVeiculoAluguel, nomeVeiculoAluguel, kmPre, kmPos from ALUGUEIS order by dataDeTerminoAluguel";

		try {
			this.statement = this.conexao.prepareStatement(sql);
			rs = statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

		return rs;

	}
	
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
	// Método publico que retorna um Array de Veiculos
	public static ArrayList<Aluguel> obterListaDeAlugueis(){

		ArrayList<Aluguel> listaDeAlugueis = new ArrayList<Aluguel>();
		Connection conexao;

		try {
			conexao = ConnectionManager.getMysqlConnection();
			AluguelDAO aluguelDAO = new AluguelDAO(conexao);
			ResultSet resultSet = aluguelDAO.listaTodos();
			// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

			while (resultSet.next()) {
				Veiculo veiculo = new Veiculo(resultSet.getString("placaVeiculoAluguel"), resultSet.getString("nomeVeiculoAluguel"));
				Cliente cliente = new Cliente(resultSet.getString("nomeClienteAluguel"),resultSet.getString("cpfClienteAluguel"));
				Aluguel aluguel = new Aluguel(resultSet.getInt("idAluguel"),
											  resultSet.getDate("dataDeInicioAluguel").toLocalDate(),
											  resultSet.getDate("dataDeTerminoAluguel").toLocalDate(),
											  resultSet.getInt("quantidadeDeDiarias"),
											// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
											  resultSet.getDouble("valorDiaria"),
											  resultSet.getDouble("taxas"),
											  resultSet.getDouble("valorTotal"),
											  veiculo,
											  cliente,
											  resultSet.getInt("kmPre"),
											  resultSet.getInt("kmPos"));
				listaDeAlugueis.add(aluguel);
			}
			// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaDeAlugueis;

	}	

	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
	public static ArrayList<Aluguel> obterListaDeAlugueisAtivos(){

		ArrayList<Aluguel> listaDeAlugueis = new ArrayList<Aluguel>();
		Connection conexao;

		try {
			conexao = ConnectionManager.getMysqlConnection();
			AluguelDAO aluguelDAO = new AluguelDAO(conexao);
			ResultSet resultSet = aluguelDAO.listaTodos();
			// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

			while (resultSet.next()) {
				Veiculo veiculo = new Veiculo(resultSet.getString("placaVeiculoAluguel"), resultSet.getString("nomeVeiculoAluguel"));
				Cliente cliente = new Cliente(resultSet.getString("nomeClienteAluguel"),resultSet.getString("cpfClienteAluguel"));
				Aluguel aluguel = new Aluguel(resultSet.getInt("idAluguel"),
											  resultSet.getDate("dataDeInicioAluguel").toLocalDate(),
											  resultSet.getDate("dataDeTerminoAluguel").toLocalDate(),
											  resultSet.getInt("quantidadeDeDiarias"),
											  resultSet.getDouble("valorDiaria"),
											// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
											  resultSet.getDouble("taxas"),
											  resultSet.getDouble("valorTotal"),
											  veiculo,
											  cliente,
											  resultSet.getInt("kmPre"),
											  resultSet.getInt("kmPos"));
				
				if (aluguel.getDataDeTerminoAluguel().isEqual(hoje) || aluguel.getDataDeTerminoAluguel().isAfter(hoje)) {
					listaDeAlugueis.add(aluguel);
					// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
			}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaDeAlugueis;

		// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
	}	
	
	
	public boolean alugaVeiculo(Aluguel aluguel) {
		String sql = "insert into ALUGUEIS (dataDeInicioAluguel, dataDeTerminoAluguel, quantidadeDeDiarias, valorDiaria, taxas, valorTotal, nomeClienteAluguel, cpfClienteAluguel, placaVeiculoAluguel, nomeVeiculoAluguel, kmPre, kmPos) values (? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";

		try {
			this.statement = conexao.prepareStatement(sql);
			this.statement.setDate(1, Date.valueOf(aluguel.getDataDeInicioAluguel()));
			// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
			this.statement.setDate(2, Date.valueOf(aluguel.getDataDeTerminoAluguel()));
			this.statement.setInt(3,  aluguel.getQuantidadeDeDiarias());
			this.statement.setDouble(4, aluguel.getValorDiaria());
			this.statement.setDouble(5, aluguel.getTaxas());
			this.statement.setDouble(6, aluguel.getValorTotal());
			this.statement.setString(7, aluguel.getCliente().getNome());
			this.statement.setString(8, aluguel.getCliente().getCPF());
			this.statement.setString(9, aluguel.getVeiculo().getPlacaVeiculo());
			this.statement.setString(10, aluguel.getVeiculo().getNomeVeiculo());
			// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
			this.statement.setInt(11, aluguel.getKmPre());
			this.statement.setInt(12, aluguel.getKmPos());
			this.statement.executeUpdate();
			System.out.println("Insercao de Aluguel ok");
			return true;
		} catch (SQLException e) {
			System.out.println("____ERRO_____Erro ao criar novo Aluguel:____ERRO_____ " + e.getMessage());
			e.printStackTrace();
			return false;
			// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
		}
	}	
	
	public boolean devolveVeiculo(Aluguel aluguel) {
		String sql = "UPDATE ALUGUEIS SET dataDeTerminoAluguel = ?, kmPos = ? WHERE idAluguel = ?";
		
		try {
			this.statement = conexao.prepareStatement(sql);
			this.statement.setDate(1, Date.valueOf(aluguel.getDataDeTerminoAluguel()));
			// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
			this.statement.setInt(2, aluguel.getKmPos());
			this.statement.setInt(3,  aluguel.getIdAluguel());
			this.statement.executeUpdate();
			System.out.println("Atualizacao de Aluguel ok");
			return true;
		} catch (SQLException e) {
			System.out.println("____ERRO_____Erro ao criar novo Aluguel:____ERRO_____ " + e.getMessage());
			e.printStackTrace();
			return false;
			// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
		}
	}	
	
	
	

}
