package application;

import java.net.URL;
import java.util.ResourceBundle;

import DAO.ClienteDAO;
import DAO.VeiculoDAO;
import connection.ConnectionManager;
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
	private Label botaoAlugaVeiculo;


	@Override
	public void initialize(URL location, ResourceBundle resources) {

		botaoCadastraCliente.setOnAction((e) -> {
			Cliente cliente = new Cliente(cpfCliente.getText(),nomeCliente.getText());
			System.out.println(cliente);
			ClienteDAO clienteDAO = new ClienteDAO(ConnectionManager.getMysqlConnection());
			if (clienteDAO.inserirClienteBanco(cliente)) {
				labelAvisoCadastroCliente.setText("Cliente cadastrado com sucesso!");	
			} else {
				labelAvisoCadastroCliente.setText("Cadastro de cliente falhou.");	
			}
		});

		botaoCadastraVeiculo.setOnAction((e) -> {
			Veiculo veiculo = new Veiculo(placaVeiculo.getText(),marcaVeiculo.getText());
			System.out.println(veiculo);
			VeiculoDAO veiculoDAO = new VeiculoDAO(ConnectionManager.getMysqlConnection());
			if (veiculoDAO.inserirVeiculoBanco(veiculo)) {
				labelAvisoCadastroVeiculo.setText("Veículo cadastrado com sucesso!");	
			} else {
				labelAvisoCadastroVeiculo.setText("Cadastro de veículo falhou.");	
			}
		});

		System.out.println(ClienteDAO.obterListaDeClientes());
		System.out.println(VeiculoDAO.obterListaDeVeiculos());
/*		
		botaoAlugaVeiculo.setOnAction((e) -> {
			Aluguel aluguel = new aluguel("hoje","amanha", veiculo, encontraClientePorCPF(cpfCliente.getText()));
			System.out.println(aluguel);
			AluguelDAO aluguelDAO = new AluguelDAO(ConnectionManager.getMysqlConnection());
			if (aluguelDAO.alugaVeiculo(aluguel)) {
				labelAlugaVeiculo.setText("Aluguel cadastrado com sucesso!");	
			} else {
				labelAlugaVeiculo.setText("Cadastro de aluguel falhou.");	
			}
		});		
*/

	}	



}
