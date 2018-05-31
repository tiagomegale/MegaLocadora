package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller implements Initializable{
	
	
	// Cadastro de Clientes
	
	@FXML
	private TextField nomeCliente;
	
	@FXML
	private TextField cpfCliente;
	
	@FXML
	private Button botaoCadastraCliente;
	
	@FXML
	private Label labelAvisoCadastroCliente;
	
	
	// Cadastro de Veículos

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// connectToLocalDatabase();
		
		// Cliente
		botaoCadastraCliente.setOnAction((e) -> {
			labelAvisoCadastroCliente.setText("O nome é: " + nomeCliente.getText() + "\n CPF é: " + cpfCliente.getText());
		});
		

		
		
	}
	
	public static void connectToLocalDatabase() {

		System.out.println("-------- MySQL JDBC Connection Testing ------------");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}

		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;

		try {
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/MEGALOCADORA","root", "");

			String query = "SELECT * FROM VEICULO";

			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet resultSet = ps.executeQuery();

			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
			}


		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}
		
	public static void cadastraCliente() {
		Cliente clienteSendoCriado = new Cliente();
	}

	
	
}
