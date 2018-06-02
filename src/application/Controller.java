package application;

import java.net.URL;
import java.util.ResourceBundle;

import DAO.ClienteDAO;
import connection.ConnectionManager;
import domain.Cliente;
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
			Cliente cliente = new Cliente(cpfCliente.getText(),nomeCliente.getText());
			System.out.println(cliente);
			ClienteDAO clienteDAO = new ClienteDAO(ConnectionManager.getMysqlConnection());
			if (clienteDAO.inserirClienteBanco(cliente)) {
				labelAvisoCadastroCliente.setText("Cliente cadastrado com sucesso!");	
			} else {
				labelAvisoCadastroCliente.setText("Cadastro falhou.");	
			}
		}
		
		
		);
		
	}

	
}
