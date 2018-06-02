package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	private static Connection connection = null;
	
	private ConnectionManager() {
		
	}

	private static Connection createConnection() {
		Connection connection = null;
		ConnectionConfig connectionConfig = new ConnectionConfig();
		 
		connectionConfig.setDriver("com.mysql.cj.jdbc.Driver");
		connectionConfig.setDatabase("/MEGALOCADORA");
		connectionConfig.setUri("jdbc:mysql://localhost:3306");
		connectionConfig.setUser("root");
		connectionConfig.setPassword("");
		
		try {
			Class.forName(connectionConfig.getDriver());
			connection = (Connection)DriverManager.getConnection(connectionConfig.getUri() +
															     connectionConfig.getDatabase(),
															     connectionConfig.getUser(),
															     connectionConfig.getPassword());
			System.out.println("OK! Conexão ao banco estabelecida.");
		} catch (SQLException e) {
			System.out.println("Erro ao criar conexão com o Connection Manager: Erro ao conectar com o banco de dados!");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Erro ao criar conexão com o Connection Manager: Classe não encontrada!");
			e.printStackTrace();
		}
		return connection;
	}
	
	public static Connection getMysqlConnection()  {
		
		if (connection == null) {
			connection = createConnection();
		}
		
		return connection;
		
	}
}