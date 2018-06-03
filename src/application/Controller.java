package application;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import DAO.AluguelDAO;
import DAO.ClienteDAO;
import DAO.VeiculoDAO;
import connection.ConnectionManager;
import domain.Aluguel;
import domain.Cliente;
import domain.Veiculo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

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
	
	
	// Tabela e Coluna de Clientes
	@FXML
	TableView<Cliente> tabelaDeClientes;
	
	@FXML
	TableColumn<Cliente, String> colunaCPF;
	
	@FXML
	TableColumn<Cliente, String> colunaNome;
	
	// Tabela e Colunas de Veículos
	@FXML
	TableView<Veiculo> tabelaDeVeiculos;
	
	@FXML
	TableColumn<Veiculo, String> colunaPlaca;
	
	@FXML
	TableColumn<Veiculo, String> colunaMarca;
	
	// Tabela e Colunas de Alugueis
	@FXML
	TableView<Aluguel> tabelaDeAlugueis;
	
	@FXML
	TableColumn<Aluguel, String> colunaDataDeInicio;
	
	@FXML
	TableColumn<Aluguel, String> colunaDataDeTermino;
	
	@FXML
	TableColumn<Aluguel, String> colunaPlacaAluguel;
	
	@FXML
	TableColumn<Aluguel, String> colunaMarcaAluguel;
	
	@FXML
	TableColumn<Aluguel, String> colunaCPFAluguel;
	
	@FXML
	TableColumn<Aluguel, String> colunaNomeAluguel;
	
	
	// Date Picker Aluguel
	@FXML
	private DatePicker datePickerDataDeInicio;
	
	@FXML
	private DatePicker datePickerDataDeTermino;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// Cria Tabela de Clientes
		ObservableList<Cliente> listaClientes = FXCollections.observableArrayList(ClienteDAO.obterListaDeClientes());
		colunaCPF.setCellValueFactory(new PropertyValueFactory<Cliente,String>("CPF"));
		colunaNome.setCellValueFactory(new PropertyValueFactory<Cliente,String>("Nome"));
		tabelaDeClientes.setItems(listaClientes);
		
		// Cria Tabela de Veículos
		ObservableList<Veiculo> listaVeiculos = FXCollections.observableArrayList(VeiculoDAO.obterListaDeVeiculos());
		colunaPlaca.setCellValueFactory(new PropertyValueFactory<Veiculo,String>("Placa"));
		colunaMarca.setCellValueFactory(new PropertyValueFactory<Veiculo,String>("Marca"));
		tabelaDeVeiculos.setItems(listaVeiculos);	
		
		// Cria Tabela de Aluguéis
		ObservableList<Aluguel> listaAlugueis = FXCollections.observableArrayList(AluguelDAO.obterListaDeAlugueis());
		colunaDataDeInicio.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("DataDeInicio"));
		colunaDataDeTermino.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("DataDeTermino"));
		colunaPlacaAluguel.setCellValueFactory(new Callback<CellDataFeatures<Aluguel, String>, ObservableValue<String>>() {
	        @Override
	        public ObservableValue<String> call(CellDataFeatures<Aluguel, String> c) {
	            return new SimpleStringProperty(c.getValue().getVeiculo().getPlaca());                
	        }
		}); 
		colunaMarcaAluguel.setCellValueFactory(new Callback<CellDataFeatures<Aluguel, String>, ObservableValue<String>>() {
	        @Override
	        public ObservableValue<String> call(CellDataFeatures<Aluguel, String> c) {
	            return new SimpleStringProperty(c.getValue().getVeiculo().getMarca());                
	        }
		}); 				
		colunaCPFAluguel.setCellValueFactory(new Callback<CellDataFeatures<Aluguel, String>, ObservableValue<String>>() {
	        @Override
	        public ObservableValue<String> call(CellDataFeatures<Aluguel, String> c) {
	            return new SimpleStringProperty(c.getValue().getCliente().getCPF());                
	        }
	        
		}); 		
		colunaNomeAluguel.setCellValueFactory(new Callback<CellDataFeatures<Aluguel, String>, ObservableValue<String>>() {
	        @Override
	        public ObservableValue<String> call(CellDataFeatures<Aluguel, String> c) {
	            return new SimpleStringProperty(c.getValue().getCliente().getNome());                
	        }
		}); 				
		tabelaDeAlugueis.setItems(listaAlugueis);	

		// Imprime no console a lista para simples verificação
		System.out.println("---- Lista de Clientes:\n" + ClienteDAO.obterListaDeClientes());
		System.out.println("---- Lista de Veiculos:\n" + VeiculoDAO.obterListaDeVeiculos());
		System.out.println("---- Lista de Alugueis:\n" + AluguelDAO.obterListaDeAlugueis());

		
		// Inicia o Date Picker
		
		datePickerDataDeInicio.setValue(LocalDate.now());
		datePickerDataDeTermino.setValue(LocalDate.now().plusDays(1));
		String.valueOf(datePickerDataDeInicio.getValue());
		String.valueOf(datePickerDataDeTermino.getValue());
		
		
		botaoCadastraCliente.setOnAction((e) -> {
			Cliente cliente = new Cliente(cpfCliente.getText(),nomeCliente.getText());
			System.out.println(cliente);
			ClienteDAO clienteDAO = new ClienteDAO(ConnectionManager.getMysqlConnection());
			
			if (clienteDAO.inserirClienteBanco(cliente)) {
				labelAvisoCadastroCliente.setText("Cliente cadastrado com sucesso!");
				
				// Atualiza lista de clientes
				listaClientes.setAll(FXCollections.observableArrayList(ClienteDAO.obterListaDeClientes()));
				colunaCPF.setCellValueFactory(new PropertyValueFactory<Cliente,String>("CPF"));
				colunaNome.setCellValueFactory(new PropertyValueFactory<Cliente,String>("Nome"));
				tabelaDeClientes.setItems(listaClientes);
				System.out.println("Lista de Clientes Atualizada!");
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
				listaVeiculos.setAll(FXCollections.observableArrayList(VeiculoDAO.obterListaDeVeiculos()));
				colunaPlaca.setCellValueFactory(new PropertyValueFactory<Veiculo,String>("Placa"));
				colunaMarca.setCellValueFactory(new PropertyValueFactory<Veiculo,String>("Marca"));
				tabelaDeVeiculos.setItems(listaVeiculos);	
				System.out.println("Lista de Veículos Atualizada!");
			} else {
				labelAvisoCadastroVeiculo.setText("____ERRO_____Cadastro de veículo falhou.____ERRO_____");	
			}
		});

		
		botaoAlugaVeiculo.setOnAction((e) -> {
			VeiculoDAO veiculoDAO = new VeiculoDAO();
			ClienteDAO clienteDAO = new ClienteDAO();
			
			Aluguel aluguel = new Aluguel(String.valueOf(datePickerDataDeInicio.getValue()),String.valueOf(datePickerDataDeTermino.getValue()), veiculoDAO.encontraVeiculoPorPlaca(placaVeiculo.getText()) , clienteDAO.encontraClientePorCPF(cpfCliente.getText()));
			System.out.println(aluguel);
			AluguelDAO aluguelDAO = new AluguelDAO(ConnectionManager.getMysqlConnection());
			
			if (aluguelDAO.alugaVeiculo(aluguel)) {
				labelAvisoCadastroAluguel.setText("===== Aluguel cadastrado com sucesso!======");
				
				// Atualiza Lista de Alugueis
				listaAlugueis.setAll(FXCollections.observableArrayList(AluguelDAO.obterListaDeAlugueis()));
				colunaDataDeInicio.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("DataDeInicio"));
				colunaDataDeTermino.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("DataDeTermino"));
				colunaPlacaAluguel.setCellValueFactory(new Callback<CellDataFeatures<Aluguel, String>, ObservableValue<String>>() {
			        @Override
			        public ObservableValue<String> call(CellDataFeatures<Aluguel, String> c) {
			            return new SimpleStringProperty(c.getValue().getVeiculo().getPlaca());                
			        }
				}); 
				colunaMarcaAluguel.setCellValueFactory(new Callback<CellDataFeatures<Aluguel, String>, ObservableValue<String>>() {
			        @Override
			        public ObservableValue<String> call(CellDataFeatures<Aluguel, String> c) {
			            return new SimpleStringProperty(c.getValue().getVeiculo().getMarca());                
			        }
				}); 		
				colunaCPFAluguel.setCellValueFactory(new Callback<CellDataFeatures<Aluguel, String>, ObservableValue<String>>() {
			        @Override
			        public ObservableValue<String> call(CellDataFeatures<Aluguel, String> c) {
			            return new SimpleStringProperty(c.getValue().getCliente().getCPF());                
			        }
			        
				}); 		
				colunaNomeAluguel.setCellValueFactory(new Callback<CellDataFeatures<Aluguel, String>, ObservableValue<String>>() {
			        @Override
			        public ObservableValue<String> call(CellDataFeatures<Aluguel, String> c) {
			            return new SimpleStringProperty(c.getValue().getCliente().getNome());                
			        }
				}); 				
				tabelaDeAlugueis.setItems(listaAlugueis);
				System.out.println("Lista de Aluguéis Atualizada!");
				
			} else {
				labelAvisoCadastroAluguel.setText("____ERRO_____Cadastro de aluguel falhou.____ERRO_____");	
			}
		});		


		
	}	



}
