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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;

public class Controller implements Initializable{
	
	// Menu da Aplicação - Menu Items
	
	@FXML
	private MenuItem menuItemHome;
	
	@FXML
	private MenuItem menuItemFechar;
	
	@FXML
	private MenuItem menuItemCadastrarCliente;
	
	@FXML
	private MenuItem menuItemAlterarCliente;
	
	@FXML
	private MenuItem menuItemListarClientes;
	
	@FXML
	private MenuItem menuItemCadastrarVeiculo;
	
	@FXML
	private MenuItem menuItemAlterarVeiculo;
	
	@FXML
	private MenuItem menuItemListarVeiculos;
	
	@FXML
	private MenuItem menuItemAlugarVeiculo;
	
	@FXML
	private MenuItem menuItemDevolverVeiculo;
	
	@FXML
	private MenuItem menuItemAlterarAluguel;
	
	@FXML
	private MenuItem menuItemAlugueisAtivos;
	
	@FXML
	private MenuItem menuItemHistoricoAlugueis;
	
	@FXML
	private MenuItem menuItemDocumentacao;
	
	@FXML
	private MenuItem menuItemSobre;
	
	// Panes da Aplicação
	
	@FXML
	private StackPane stackPanePrincipal;
	
	@FXML 
	private Pane paneHome;
	
	@FXML
	private Pane paneClientes;
	
	@FXML
	private Pane paneVeiculos;
	
	@FXML
	private Pane paneAlugueis;
	
	@FXML
	private Pane paneRelatorios;
	
	@FXML
	private Pane paneSobre;
	
	
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
		final LocalDate hoje = LocalDate.now();
		datePickerDataDeInicio.setValue(hoje);
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

		// Adiciona todos os Panes ao StackPane Pai. Inicia com o paneHome Visível e a medida que os botões são clicados, some com os outros.
		paneHome.setVisible(true);
		paneClientes.setVisible(false);
		paneVeiculos.setVisible(false);
		paneAlugueis.setVisible(false);
		paneRelatorios.setVisible(false);
		paneSobre.setVisible(false);
		
		menuItemHome.setOnAction((e) -> {
			stackPanePrincipal.getChildren().setAll(paneHome);
			paneHome.setVisible(true);
			paneClientes.setVisible(false);
			paneVeiculos.setVisible(false);
			paneAlugueis.setVisible(false);
			paneRelatorios.setVisible(false);
			paneSobre.setVisible(false);
		});
		
		menuItemFechar.setOnAction((e) -> {
		});
				
		menuItemCadastrarCliente.setOnAction((e) -> {
			stackPanePrincipal.getChildren().setAll(paneClientes);
			paneHome.setVisible(false);
			paneClientes.setVisible(true);
			paneVeiculos.setVisible(false);
			paneAlugueis.setVisible(false);
			paneRelatorios.setVisible(false);
			paneSobre.setVisible(false);
		});
		
		menuItemAlterarCliente.setOnAction((e) -> {
			stackPanePrincipal.getChildren().setAll(paneClientes);
			paneHome.setVisible(false);
			paneClientes.setVisible(true);
			paneVeiculos.setVisible(false);
			paneAlugueis.setVisible(false);
			paneRelatorios.setVisible(false);
			paneSobre.setVisible(false);
		});
		
		menuItemListarClientes.setOnAction((e) -> {
			stackPanePrincipal.getChildren().setAll(paneClientes);
			paneHome.setVisible(false);
			paneClientes.setVisible(true);
			paneVeiculos.setVisible(false);
			paneAlugueis.setVisible(false);
			paneRelatorios.setVisible(false);
			paneSobre.setVisible(false);
		});
		
		menuItemCadastrarVeiculo.setOnAction((e) -> {
			stackPanePrincipal.getChildren().setAll(paneVeiculos);
			paneHome.setVisible(false);
			paneClientes.setVisible(false);
			paneVeiculos.setVisible(true);
			paneAlugueis.setVisible(false);
			paneRelatorios.setVisible(false);
			paneSobre.setVisible(false);
		});
		
		menuItemAlterarVeiculo.setOnAction((e) -> {
			stackPanePrincipal.getChildren().setAll(paneVeiculos);
			paneHome.setVisible(false);
			paneClientes.setVisible(false);
			paneVeiculos.setVisible(true);
			paneAlugueis.setVisible(false);
			paneRelatorios.setVisible(false);
			paneSobre.setVisible(false);
		});
		
		menuItemListarVeiculos.setOnAction((e) -> {
			stackPanePrincipal.getChildren().setAll(paneVeiculos);
			paneHome.setVisible(false);
			paneClientes.setVisible(false);
			paneVeiculos.setVisible(true);
			paneAlugueis.setVisible(false);
			paneRelatorios.setVisible(false);
			paneSobre.setVisible(false);
		});
		
		menuItemAlugarVeiculo.setOnAction((e) -> {
			stackPanePrincipal.getChildren().setAll(paneAlugueis);
			paneHome.setVisible(false);
			paneClientes.setVisible(false);
			paneVeiculos.setVisible(false);
			paneAlugueis.setVisible(true);
			paneRelatorios.setVisible(false);
			paneSobre.setVisible(false);
		});
		
		menuItemDevolverVeiculo.setOnAction((e) -> {
			stackPanePrincipal.getChildren().setAll(paneAlugueis);
			paneHome.setVisible(false);
			paneClientes.setVisible(false);
			paneVeiculos.setVisible(false);
			paneAlugueis.setVisible(true);
			paneRelatorios.setVisible(false);
			paneSobre.setVisible(false);
		});
		 
		menuItemAlterarAluguel.setOnAction((e) -> {
			stackPanePrincipal.getChildren().setAll(paneAlugueis);
			paneHome.setVisible(false);
			paneClientes.setVisible(false);
			paneVeiculos.setVisible(false);
			paneAlugueis.setVisible(true);
			paneRelatorios.setVisible(false);
			paneSobre.setVisible(false);
		});
		
		menuItemAlugueisAtivos.setOnAction((e) -> {
			stackPanePrincipal.getChildren().setAll(paneRelatorios);
			paneHome.setVisible(false);
			paneClientes.setVisible(false);
			paneVeiculos.setVisible(false);
			paneAlugueis.setVisible(false);
			paneRelatorios.setVisible(true);
			paneSobre.setVisible(false);
		});
		
		menuItemHistoricoAlugueis.setOnAction((e) -> {
			stackPanePrincipal.getChildren().setAll(paneRelatorios);
			paneHome.setVisible(false);
			paneClientes.setVisible(false);
			paneVeiculos.setVisible(false);
			paneAlugueis.setVisible(false);
			paneRelatorios.setVisible(true);
			paneSobre.setVisible(false);
		});
		
		menuItemDocumentacao.setOnAction((e)-> {
			stackPanePrincipal.getChildren().setAll(paneSobre);
			paneHome.setVisible(false);
			paneClientes.setVisible(false);
			paneVeiculos.setVisible(false);
			paneAlugueis.setVisible(false);
			paneRelatorios.setVisible(false);
			paneSobre.setVisible(true);
		});
		
		menuItemSobre.setOnAction((e) -> {
			stackPanePrincipal.getChildren().setAll(paneSobre);
			paneHome.setVisible(false);
			paneClientes.setVisible(false);
			paneVeiculos.setVisible(false);
			paneAlugueis.setVisible(false);
			paneRelatorios.setVisible(false);
			paneSobre.setVisible(true);
		});
	
		
		
	}	



}
