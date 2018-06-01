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
	

		
	public static void cadastraCliente() {
		Cliente clienteSendoCriado = new Cliente();
	}

	
	
}
