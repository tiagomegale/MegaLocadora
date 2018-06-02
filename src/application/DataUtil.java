package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.ClienteDAO;
import connection.ConnectionManager;
import domain.Cliente;

public abstract class DataUtil {
	
	
	public static ArrayList<Cliente> obterListaDeClientes(){
		
		ArrayList<Cliente> listaDeClientes = new ArrayList<Cliente>();
		Connection conexao;
		
		try {
			conexao = ConnectionManager.getMysqlConnection();
			ClienteDAO clienteDAO = new ClienteDAO(conexao);
			ResultSet resultSet = clienteDAO.listaTodos();
			
			while (resultSet.next()) {
				Cliente cliente = new Cliente(resultSet.getString("CPF"),resultSet.getString("NOME"));
				//cliente.setCPF();
				//cliente.setNome(resultSet.getString("NOME"));
				listaDeClientes.add(cliente);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaDeClientes;
		
	}
	
	

}
