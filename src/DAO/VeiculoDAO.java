package DAO;

import java.sql.Connection;
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

	public ResultSet encontraPorPlaca(String Placa) {

		String sql = "select Placa, Marca from VEICULOS where Placa = ?"; 

		try {
			this.statement = this.conexao.prepareStatement(sql);
			this.statement.setString(1, Placa);
			rs = statement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;

	}

	public ResultSet listaTodos() {
		String sql = "select Placa, Marca from VEICULOS order by Placa";
		
		try {
			this.statement = this.conexao.prepareStatement(sql);
			rs = statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
		
	}
	
	public static ArrayList<Veiculo> obterListaDeVeiculos(){

		ArrayList<Veiculo> listaDeVeiculos = new ArrayList<Veiculo>();
		Connection conexao;

		try {
			conexao = ConnectionManager.getMysqlConnection();
			VeiculoDAO veiculoDAO = new VeiculoDAO(conexao);
			ResultSet resultSet = veiculoDAO.listaTodos();

			while (resultSet.next()) {
				Veiculo veiculo = new Veiculo(resultSet.getString("Placa"),resultSet.getString("Marca"));
				listaDeVeiculos.add(veiculo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaDeVeiculos;

	}

	public boolean inserirVeiculoBanco(Veiculo veiculo) {
		String sql = "insert into VEICULOS (Placa,Marca) values (? , ?)";
		
		try {
			this.statement = conexao.prepareStatement(sql);
			this.statement.setString(1, veiculo.getPlaca());
			this.statement.setString(2, veiculo.getMarca());
			this.statement.executeUpdate();	
			System.out.println("Insercao ok");
			return true;
		} catch (SQLException e) {
			System.out.println("Erro ao criar novo veículo: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}	
	
	

	
	
	
	
}
