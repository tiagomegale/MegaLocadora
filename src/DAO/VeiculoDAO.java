package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

	public ResultSet encontraPorPlaca (String Placa) {

		String sql = "select PLACA, codigo from VEICULOS where PLACA = ?"; 

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
		String sql = "select PLACA from CLIENTES order by marca";
		
		try {
			this.statement = this.conexao.prepareStatement(sql);
			rs = statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
		
	}

	public boolean inserirVeiculoBanco(Veiculo veiculo) {
		String sql = "insert into VEICULOS (placa,marca) values (? , ?)";
		
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
