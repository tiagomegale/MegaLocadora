package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.ConnectionManager;
import domain.Cliente;

public class ClienteDAO {

	private Connection conexao = null;
	private PreparedStatement statement = null;
	private ResultSet rs = null;

	public ClienteDAO() {
		this.conexao = ConnectionManager.getMysqlConnection();
	}

	public ClienteDAO(Connection conexao) {
		this.conexao = conexao;
	}

	// Método Privado que busca no banco usando CPF
	private ResultSet buscaClienteNoBancoPorCPF(String CPF) {

		String sql = "select CPF, nome from CLIENTES where CPF = ?"; 

		try {
			this.statement = this.conexao.prepareStatement(sql);
			this.statement.setString(1, CPF);
			rs = statement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("____ERRO_____Erro para encontrar por CPF.____ERRO_____");
		}

		return rs;

	}

	// Método Privado que transforma o resultado da busca em um cliente
	private Cliente transformaResultSetEmCliente(ResultSet rs) {
		ResultSet resultSet = rs;

		try {
				Cliente clienteSendoBuscado = null;
				
			while (resultSet.next()) {
				clienteSendoBuscado = new Cliente(resultSet.getString("CPF"),resultSet.getString("nome"));
			}
			return clienteSendoBuscado;

		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("____ERRO_____Erro para transformar RS em Cliente. Retornando NULL.____ERRO_____");
			return null;
		}

	}	

	// Método público que vai ser usado pela aplicação
	public Cliente encontraClientePorCPF(String CPF) {
		String CPFSendoBuscado = CPF;
		return transformaResultSetEmCliente(buscaClienteNoBancoPorCPF(CPFSendoBuscado));
	}

	// Método privado que busca no banco a lista de todos os clientes
	private ResultSet listaTodos() {
		String sql = "select CPF, nome from CLIENTES order by nome";

		try {
			this.statement = this.conexao.prepareStatement(sql);
			rs = statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;

	}

	// Método público que retorna um Array de Clientes
	public static ArrayList<Cliente> obterListaDeClientes(){

		ArrayList<Cliente> listaDeClientes = new ArrayList<Cliente>();
		Connection conexao;

		try {
			conexao = ConnectionManager.getMysqlConnection();
			ClienteDAO clienteDAO = new ClienteDAO(conexao);
			ResultSet resultSet = clienteDAO.listaTodos();

			while (resultSet.next()) {
				Cliente cliente = new Cliente(resultSet.getString("CPF"),resultSet.getString("nome"));
				//cliente.setCPF();
				//cliente.setNome(resultSet.getString("NOME"));
				listaDeClientes.add(cliente);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaDeClientes;

	}	
	
	public boolean inserirClienteBanco(Cliente cliente) {
		String sql = "insert into CLIENTES (cpf,nome) values (? , ?)";

		try {
			this.statement = conexao.prepareStatement(sql);
			this.statement.setString(1, cliente.getCPF());
			this.statement.setString(2, cliente.getNome());
			this.statement.executeUpdate();	
			System.out.println("Insercao ok");
			return true;
		} catch (SQLException e) {
			System.out.println("Erro ao criar novo cliente: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}







}
