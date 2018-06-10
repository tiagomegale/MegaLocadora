package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

import connection.ConnectionManager;
import domain.Cliente;

public class ClienteDAO {

	private Connection conexao = null;
	private PreparedStatement statement = null;
	private ResultSet rs = null;

	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
	public ClienteDAO() {
		this.conexao = ConnectionManager.getMysqlConnection();
	}

	public ClienteDAO(Connection conexao) {
		this.conexao = conexao;
	}

	// Método Privado que busca no banco usando CPF
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
	private ResultSet buscaClienteNoBancoPorCPF(String CPF) {

		String sql = "select nome, cpf, endereco, telefone, sexo, dataDeNascimento from CLIENTES where cpf = ?"; 

		try {
			this.statement = this.conexao.prepareStatement(sql);
			this.statement.setString(1, CPF);
			rs = statement.executeQuery();

			// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
		} catch (SQLException e) {
			System.err.println("____ERRO_____Erro para gerar o RS buscando por CPF no Banco.____ERRO_____" + e.getMessage());
			e.printStackTrace();
		}

		return rs;

	}

	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
	// Método Privado que transforma o resultado da busca em um cliente
	private Cliente transformaResultSetEmCliente(ResultSet rs) {
		ResultSet resultSet = rs;

		try {
			Cliente clienteSendoBuscado = null;
			resultSet.next();
			clienteSendoBuscado = new Cliente(resultSet.getString("nome"), resultSet.getString("cpf"), resultSet.getString("endereco"), resultSet.getString("telefone"), resultSet.getString("sexo").charAt(0), resultSet.getDate("dataDeNascimento").toLocalDate());
			return clienteSendoBuscado;
			// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

		} catch (SQLException e) {
			System.err.println("____ERRO_____Erro para transformar Result Set em Cliente. Retornando NULL.____ERRO_____" + e.getMessage());
			e.printStackTrace();
			return null;
		}

	}	

	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
	// Método público que vai ser usado pela aplicação
	public Cliente encontraClientePorCPF(String CPF) {
		String CPFSendoBuscado = CPF;
		return transformaResultSetEmCliente(buscaClienteNoBancoPorCPF(CPFSendoBuscado));
	}

	// Método privado que busca no banco a lista de todos os clientes
	private ResultSet listaTodos() {
		String sql = "select nome, cpf, endereco, telefone, sexo, dataDeNascimento from CLIENTES order by nome";
		// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

		try {
			this.statement = this.conexao.prepareStatement(sql);
			rs = statement.executeQuery();
		} catch (SQLException e) {
			System.err.println("____ERRO_____Erro para buscar Cliente por CPF. Retornando NULL.____ERRO_____" + e.getMessage());
			e.printStackTrace();
		}

		// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
		return rs;

	}

	// Método público que retorna um Array de Clientes
	public static ArrayList<Cliente> obterListaDeClientes(){

		ArrayList<Cliente> listaDeClientes = new ArrayList<Cliente>();
		Connection conexao;
		// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

		try {
			conexao = ConnectionManager.getMysqlConnection();
			ClienteDAO clienteDAO = new ClienteDAO(conexao);
			ResultSet resultSet = clienteDAO.listaTodos();

			while (resultSet.next()) {
				Cliente cliente = new Cliente(resultSet.getString("nome"), resultSet.getString("cpf"), resultSet.getString("endereco"), resultSet.getString("telefone"), resultSet.getString("sexo").charAt(0), resultSet.getDate("dataDeNascimento").toLocalDate());
				listaDeClientes.add(cliente);
				// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
			}

		} catch (SQLException e) {
			System.err.println("____ERRO_____Erro para obter lista de clientes.____ERRO_____" + e.getMessage());
			e.printStackTrace();
		}

		return listaDeClientes;
	}	
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

	public boolean inserirClienteBanco(Cliente cliente) {
		String sql = "insert into CLIENTES (nome,cpf,endereco,telefone,sexo,dataDeNascimento) values (? , ? , ? , ? , ? , ?)";

		try {
			this.statement = conexao.prepareStatement(sql);
			this.statement.setString(1, cliente.getNome());
			this.statement.setString(2, cliente.getCPF());
			this.statement.setString(3, cliente.getEndereco());
			// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
			this.statement.setString(4, cliente.getTelefone());
			this.statement.setString(5, String.valueOf(cliente.getSexo()));
			this.statement.setDate(6, Date.valueOf(cliente.getDataDeNascimento()));
			this.statement.executeUpdate();	
			System.out.println("Insercao ok");
			return true;
		} catch (SQLException e) {
			System.out.println("____ERRO_____Erro para criar novo clientes.____ERRO_____ " + e.getMessage());
			e.printStackTrace();
			// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
			return false;
		}
	}







}
