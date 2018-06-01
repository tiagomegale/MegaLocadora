package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.ConnectionManager;
import Domain.Cliente;

public class ClienteDAO {

	private Connection conexao = null;
	private PreparedStatement statement = null;
	private ResultSet rs = null;

	public ClienteDAO() {
		//Connection conexao;
	    this.conexao = ConnectionManager.getMysqlConnection();
	}


	public ClienteDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public ResultSet encontraPorCPF (String CPF) {

		String sql = "select CPF, codigo from CLIENTES where CPF = ?"; 

		try {
			this.statement = this.conexao.prepareStatement(sql);
			this.statement.setString(1, CPF);
			rs = statement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;

	}

	public ResultSet listaTodos() {
		String sql = "select CPF from CLIENTES order by nome";
		
		try {
			this.statement = this.conexao.prepareStatement(sql);
			rs = statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
		
	}

	public void inserirClienteBanco(Cliente cliente) {
		String sql = "insert into CLIENTES (cpf,nome) values (? , ?)";
		
		try {
			this.statement = conexao.prepareStatement(sql);
			this.statement.setString(1, cliente.getCPF());
			this.statement.setString(2, cliente.getNome());
			this.statement.executeUpdate();	
			System.out.println("Insercao ok");
		} catch (SQLException e) {
			System.out.println("Erro ao criar novo cliente: " + e.getMessage());
			e.printStackTrace();
		}
	}



}
