package application;

import java.net.URL;
import java.util.ResourceBundle;

import DAO.AluguelDAO;
import DAO.ClienteDAO;
import DAO.VeiculoDAO;
import connection.ConnectionManager;
import domain.Aluguel;
import domain.Cliente;
import domain.Veiculo;
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
	@FXML
	private TextField marcaVeiculo;

	@FXML
	private TextField placaVeiculo;

	@FXML
	private Button botaoCadastraVeiculo;

	@FXML
	private Label labelAvisoCadastroVeiculo;

	
	// Cadastro de Aluguel
	@FXML
	private Button botaoAlugaVeiculo;
	
	@FXML
	private Label labelAvisoCadastroAluguel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		System.out.println(ClienteDAO.obterListaDeClientes());
		
		System.out.println(VeiculoDAO.obterListaDeVeiculos());
		
		
		botaoCadastraCliente.setOnAction((e) -> {
			Cliente cliente = new Cliente(cpfCliente.getText(),nomeCliente.getText());
			System.out.println(cliente);
			ClienteDAO clienteDAO = new ClienteDAO(ConnectionManager.getMysqlConnection());
			
			if (clienteDAO.inserirClienteBanco(cliente)) {
				labelAvisoCadastroCliente.setText("Cliente cadastrado com sucesso!");	
			} else {
				labelAvisoCadastroCliente.setText("____ERRO_____Cadastro de cliente falhou.____ERRO_____");	
			}
		});

		botaoCadastraVeiculo.setOnAction((e) -> {
			Veiculo veiculo = new Veiculo(placaVeiculo.getText(),marcaVeiculo.getText());
			System.out.println(veiculo);
			VeiculoDAO veiculoDAO = new VeiculoDAO(ConnectionManager.getMysqlConnection());
			
			if (veiculoDAO.inserirVeiculoBanco(veiculo)) {
				labelAvisoCadastroVeiculo.setText("Veículo cadastrado com sucesso!");	
			} else {
				labelAvisoCadastroVeiculo.setText("____ERRO_____Cadastro de veículo falhou.____ERRO_____");	
			}
		});

		botaoAlugaVeiculo.setOnAction((e) -> {
			VeiculoDAO veiculoDAO = new VeiculoDAO();
			ClienteDAO clienteDAO = new ClienteDAO();
			
			Aluguel aluguel = new Aluguel("hoje","amanha", veiculoDAO.encontraVeiculoPorPlaca(placaVeiculo.getText()) , clienteDAO.encontraClientePorCPF(cpfCliente.getText()));
			System.out.println(aluguel);
			AluguelDAO aluguelDAO = new AluguelDAO(ConnectionManager.getMysqlConnection());
			
			if (aluguelDAO.alugaVeiculo(aluguel)) {
				labelAvisoCadastroAluguel.setText("===== Aluguel cadastrado com sucesso!======");	
			} else {
				labelAvisoCadastroAluguel.setText("____ERRO_____Cadastro de aluguel falhou.____ERRO_____");	
			}
		});		

	}	



}
