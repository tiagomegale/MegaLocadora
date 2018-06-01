package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connection.ConnectionManager;
import DAO.ClienteDAO;

public abstract class DataUtil {
	
	
	public static ArrayList<Cliente> obterListaDeClientes(){
		
		ArrayList<Cliente> listaDeClientes = new ArrayList<Cliente>();
		Connection conexao;
		
		try {
			conexao = ConnectionManager.getMysqlConnection();
			ClienteDAO clienteDAO = new ClienteDAO(conexao);
			ResultSet resultSet = clienteDAO.findAll)();
			
			while (resultSet.next()) {
				Cliente cliente = new Cliente();
				cliente.setCPF(resultSet.getString("CPF"));
				cliente.setNome(resultSet.getString("NOME"));
				listaDeClientes.add(cliente);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaDeClientes;
		
	}
	
	

}
