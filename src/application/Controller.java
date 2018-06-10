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
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

public class Controller implements Initializable{

	// Painéis da Home
	@FXML
	private TabPane tabPaneConteudo;

	@FXML
	private Pane paneHome;


	// HOME
	// Tabela e Colunas de Clientes
	@FXML
	TableView<Cliente> tabelaDeClientesHome;

	@FXML
	TableColumn<Cliente, String> colunaNomeHome;

	@FXML
	TableColumn<Cliente, String> colunaCPFHome;

	@FXML
	TableView<Veiculo> tabelaDeVeiculosHome;

	@FXML
	TableColumn<Veiculo, String> colunaPlacaVeiculoHome;

	@FXML
	TableColumn<Veiculo, String> colunaNomeVeiculoHome;

	@FXML
	private Label labelClienteSelecionadoHome;
	
	@FXML
	private Label labelVeiculoSelecionadoHome;
	
	@FXML
	private Label labelSelecioneUmCliente;
	
	@FXML
	private Label labelSelecioneUmVeiculo;
	
	
	
	// Form de Cadastro de Clientes
	@FXML
	private TextField nomeCliente;

	@FXML
	private TextField cpfCliente;

	@FXML
	private TextArea enderecoCliente;

	@FXML
	private TextField telefoneCliente;

	@FXML
	private ChoiceBox<String> sexoCliente;

	@FXML
	private DatePicker dataDeNascimento;

	@FXML
	private Button botaoCadastraCliente;

	@FXML
	private Label labelAvisoCadastroCliente;

	
	// Tabela e Colunas de Clientes
	@FXML
	TableView<Cliente> tabelaDeClientes;

	@FXML
	TableColumn<Cliente, String> colunaNome;

	@FXML
	TableColumn<Cliente, String> colunaCPF;

	@FXML
	TableColumn<Cliente, String> colunaEndereco;

	@FXML
	TableColumn<Cliente, String> colunaTelefone;

	@FXML
	TableColumn<Cliente, String> colunaSexo;

	@FXML
	TableColumn<Cliente, String> colunaDataDeNascimento;



	// Form de Cadastro de Veículos
	@FXML
	private TextField placaVeiculo;

	@FXML
	private TextField nomeVeiculo;

	@FXML
	private TextField modeloVeiculo;

	@FXML
	private TextField marcaVeiculo;

	@FXML
	private Slider anoDeFabricacao;

	@FXML
	private Label labelSliderAnoDeFabricacao;

	@FXML
	private Slider anoDeVenda;

	@FXML
	private Label labelSliderAnoDeVenda;

	@FXML
	private Button botaoCadastraVeiculo;

	@FXML
	private Label labelAvisoCadastroVeiculo;

	// Tabela e Colunas de Veículos
	@FXML
	TableView<Veiculo> tabelaDeVeiculos;

	@FXML
	TableColumn<Veiculo, String> colunaPlacaVeiculo;

	@FXML
	TableColumn<Veiculo, String> colunaNomeVeiculo;

	@FXML
	TableColumn<Veiculo, String> colunaModeloVeiculo;

	@FXML
	TableColumn<Veiculo, String> colunaMarcaVeiculo;

	@FXML
	TableColumn<Veiculo, String> colunaAnoDeFabricacao;

	@FXML
	TableColumn<Veiculo, String> colunaAnoDeVenda;



	// Form de Cadastro de Aluguel
	@FXML
	private Button botaoAlugaVeiculo;

	@FXML
	private Label labelAvisoCadastroAluguel;

	@FXML
	private DatePicker datePickerDataDeInicio;

	@FXML
	private DatePicker datePickerDataDeTermino;

	@FXML
	private RadioButton radioValorDiaria49;
	
	@FXML
	private RadioButton radioValorDiaria59;
	
	@FXML
	private RadioButton radioValorDiaria109;
	
	@FXML
	private ToggleGroup radioValorDiaria;
	
	@FXML
	private TextField kilometragemInicialAluguel;
	
	@FXML
	private Button botaoBuscarClientePorCPF;
	
	@FXML
	private Button botaoBuscarVeiculoPorPlaca;
	
	@FXML
	private TextField textFieldBuscaClientePorCPF;
	
	@FXML
	private TextField textFieldBuscaVeiculoPorPlaca;
	
	
	
	// Tabela e Colunas de Alugueis
	@FXML
	TableView<Aluguel> tabelaDeAlugueis;

	@FXML
	TableColumn<Aluguel, String> colunaIdAluguel;
	
	@FXML
	TableColumn<Aluguel, String> colunaDataDeInicioAluguel;

	@FXML
	TableColumn<Aluguel, String> colunaDataDeTerminoAluguel;

	@FXML
	TableColumn<Aluguel, String> colunaQtdDiariasAluguel;

	@FXML
	TableColumn<Aluguel, String> colunaValorDiariaAluguel;

	@FXML
	TableColumn<Aluguel, String> colunaTaxasAluguel;

	@FXML
	TableColumn<Aluguel, String> colunaTotalAluguel;

	@FXML
	TableColumn<Aluguel, String> colunaNomeClienteAluguel;

	@FXML
	TableColumn<Aluguel, String> colunaCPFClienteluguel;

	@FXML
	TableColumn<Aluguel, String> colunaPlacaVeiculoAluguel;

	@FXML
	TableColumn<Aluguel, String> colunaNomeVeiculoAluguel;

	@FXML
	TableColumn<Aluguel, String> colunaKMPreAluguel;

	@FXML
	TableColumn<Aluguel, String> colunaKMPosAluguel;	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// Imprime no console a lista para simples verificação
		System.out.println("---- Lista de Clientes:\n" + ClienteDAO.obterListaDeClientes());
		System.out.println("---- Lista de Veiculos:\n" + VeiculoDAO.obterListaDeVeiculos());
		System.out.println("---- Lista de Alugueis:\n" + AluguelDAO.obterListaDeAlugueis());

		
		// HOME
			//Tabela de Clientes Home
			ObservableList<Cliente> listaClientesHome = FXCollections.observableArrayList(ClienteDAO.obterListaDeClientes());
			colunaNomeHome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
			colunaCPFHome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("CPF"));
			tabelaDeClientesHome.setItems(listaClientesHome);
		
			//Tabela de Veículos Home
			ObservableList<Veiculo> listaVeiculosHome = FXCollections.observableArrayList(VeiculoDAO.obterListaDeVeiculos());
			colunaPlacaVeiculoHome.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("placaVeiculo"));
			colunaNomeVeiculoHome.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("nomeVeiculo"));
			tabelaDeVeiculosHome.setItems(listaVeiculosHome);	
			
			//Troca os Labels da Home pros valores selecionados nas tabelas de cliente e veículos
			tabelaDeClientesHome.setOnMouseClicked((e) -> {
				Cliente clienteSelecionadoHome = tabelaDeClientesHome.getSelectionModel().getSelectedItem();
				labelClienteSelecionadoHome.setText(clienteSelecionadoHome.getNome() + ". CPF: " + clienteSelecionadoHome.getCPF());
				labelSelecioneUmCliente.setText("Cliente selecionado: ");
			});
			
			tabelaDeVeiculosHome.setOnMouseClicked((e) -> {
				Veiculo veiculoSelecionadoHome = tabelaDeVeiculosHome.getSelectionModel().getSelectedItem();
				labelVeiculoSelecionadoHome.setText(veiculoSelecionadoHome.getMarcaVeiculo() + " " + veiculoSelecionadoHome.getNomeVeiculo() + " de Placa: " + veiculoSelecionadoHome.getPlacaVeiculo());
				labelSelecioneUmVeiculo.setText("Veículo selecionado: ");
			});
			
			botaoBuscarClientePorCPF.setOnAction((e) -> {
					ClienteDAO clienteDAO = new ClienteDAO(ConnectionManager.getMysqlConnection());
					listaClientesHome.setAll(FXCollections.observableArrayList(clienteDAO.encontraClientePorCPF(textFieldBuscaClientePorCPF.getText())));
					colunaNomeHome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
					colunaCPFHome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("CPF"));
					tabelaDeClientesHome.setItems(listaClientesHome);	
			});
			
			botaoBuscarVeiculoPorPlaca.setOnAction((e) -> {
				VeiculoDAO veiculoDAO = new VeiculoDAO(ConnectionManager.getMysqlConnection());
				listaVeiculosHome.setAll(FXCollections.observableArrayList(veiculoDAO.encontraVeiculoPorPlaca(textFieldBuscaVeiculoPorPlaca.getText())));
				colunaPlacaVeiculoHome.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("placaVeiculo"));
				colunaNomeVeiculoHome.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("nomeVeiculo"));
				tabelaDeVeiculosHome.setItems(listaVeiculosHome);	
			});
			

		// Tela de Clientes

			// Cria Tabela de Clientes
			ObservableList<Cliente> listaClientes = FXCollections.observableArrayList(ClienteDAO.obterListaDeClientes());
			colunaNome.setCellValueFactory(new PropertyValueFactory<Cliente,String>("nome"));
			colunaCPF.setCellValueFactory(new PropertyValueFactory<Cliente,String>("CPF"));
			colunaEndereco.setCellValueFactory(new PropertyValueFactory<Cliente,String>("endereco"));
			colunaTelefone.setCellValueFactory(new PropertyValueFactory<Cliente,String>("telefone"));
			colunaSexo.setCellValueFactory(new PropertyValueFactory<Cliente,String>("sexo"));
			colunaDataDeNascimento.setCellValueFactory(new PropertyValueFactory<Cliente,String>("dataDeNascimento"));
			tabelaDeClientes.setItems(listaClientes);
	
			// Botão de Cadastro de Clientes
	
			botaoCadastraCliente.setOnAction((e) -> {
				Cliente cliente = new Cliente(nomeCliente.getText(), cpfCliente.getText(), enderecoCliente.getText(), telefoneCliente.getText(), sexoCliente.getValue().charAt(0), dataDeNascimento.getValue());
				System.out.println(cliente);
				ClienteDAO clienteDAO = new ClienteDAO(ConnectionManager.getMysqlConnection());
	
				if (clienteDAO.inserirClienteBanco(cliente)) {
					labelAvisoCadastroCliente.setText("Cliente cadastrado com sucesso!");
	
					// Atualiza lista de clientes
					listaClientes.setAll(FXCollections.observableArrayList(ClienteDAO.obterListaDeClientes()));
					colunaNome.setCellValueFactory(new PropertyValueFactory<Cliente,String>("nome"));
					colunaCPF.setCellValueFactory(new PropertyValueFactory<Cliente,String>("CPF"));
					colunaEndereco.setCellValueFactory(new PropertyValueFactory<Cliente,String>("endereco"));
					colunaTelefone.setCellValueFactory(new PropertyValueFactory<Cliente,String>("telefone"));
					colunaSexo.setCellValueFactory(new PropertyValueFactory<Cliente,String>("sexo"));
					colunaDataDeNascimento.setCellValueFactory(new PropertyValueFactory<Cliente,String>("dataDeNascimento"));
					tabelaDeClientes.setItems(listaClientes);
	
					System.out.println("Lista de Clientes Atualizada!");
				} else {
					labelAvisoCadastroCliente.setText("____ERRO_____Cadastro de cliente falhou.____ERRO_____");	
				}
			});


		// Tela de Veículos
	
			// Cria Tabela de Veículos
			ObservableList<Veiculo> listaVeiculos = FXCollections.observableArrayList(VeiculoDAO.obterListaDeVeiculos());
			colunaPlacaVeiculo.setCellValueFactory(new PropertyValueFactory<Veiculo,String>("placaVeiculo"));
			colunaNomeVeiculo.setCellValueFactory(new PropertyValueFactory<Veiculo,String>("nomeVeiculo"));
			colunaModeloVeiculo.setCellValueFactory(new PropertyValueFactory<Veiculo,String>("modeloVeiculo"));
			colunaMarcaVeiculo.setCellValueFactory(new PropertyValueFactory<Veiculo,String>("marcaVeiculo"));
			colunaAnoDeFabricacao.setCellValueFactory(new PropertyValueFactory<Veiculo,String>("anoDeFabricacao"));
			colunaAnoDeVenda.setCellValueFactory(new PropertyValueFactory<Veiculo,String>("anoDeVenda"));
			tabelaDeVeiculos.setItems(listaVeiculos);	
	
			//Slider
			labelSliderAnoDeFabricacao.textProperty().bind(Bindings.format("%.00f", anoDeFabricacao.valueProperty()));
			labelSliderAnoDeVenda.textProperty().bind(Bindings.format("%.00f", anoDeVenda.valueProperty()));
	
			// Cria Choicebox de sexo do Cliente
			ObservableList<String> opcoesDeSexo = FXCollections.observableArrayList("Masculino", "Feminino");
			sexoCliente.setItems(opcoesDeSexo);
	
			// Botão Cadastra Veículo
			botaoCadastraVeiculo.setOnAction((e) -> {
	
				Veiculo veiculo = new Veiculo(placaVeiculo.getText(), nomeVeiculo.getText(), modeloVeiculo.getText(), marcaVeiculo.getText(), (int) anoDeFabricacao.getValue(), (int) anoDeVenda.getValue());
				System.out.println(veiculo);
				VeiculoDAO veiculoDAO = new VeiculoDAO(ConnectionManager.getMysqlConnection());
	
				if (veiculoDAO.inserirVeiculoBanco(veiculo)) {
					labelAvisoCadastroVeiculo.setText("Veículo cadastrado com sucesso!");
					listaVeiculos.setAll(FXCollections.observableArrayList(VeiculoDAO.obterListaDeVeiculos()));
					colunaPlacaVeiculo.setCellValueFactory(new PropertyValueFactory<Veiculo,String>("placaVeiculo"));
					colunaNomeVeiculo.setCellValueFactory(new PropertyValueFactory<Veiculo,String>("nomeVeiculo"));
					colunaModeloVeiculo.setCellValueFactory(new PropertyValueFactory<Veiculo,String>("modeloVeiculo"));
					colunaMarcaVeiculo.setCellValueFactory(new PropertyValueFactory<Veiculo,String>("marcaVeiculo"));
					colunaAnoDeFabricacao.setCellValueFactory(new PropertyValueFactory<Veiculo,String>("anoDeFabricacao"));
					colunaAnoDeVenda.setCellValueFactory(new PropertyValueFactory<Veiculo,String>("anoDeVenda"));
					tabelaDeVeiculos.setItems(listaVeiculos);	
					System.out.println("Lista de Veículos Atualizada!");
				} else {
					labelAvisoCadastroVeiculo.setText("____ERRO_____Cadastro de veículo falhou.____ERRO_____");	
				}
			});


		// Tela de Aluguéis	

			// Cria Tabela de Aluguéis
			ObservableList<Aluguel> listaAlugueis = FXCollections.observableArrayList(AluguelDAO.obterListaDeAlugueis());
			colunaIdAluguel.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("idAluguel"));
			colunaDataDeInicioAluguel.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("dataDeInicioAluguel"));
			colunaDataDeTerminoAluguel.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("dataDeTerminoAluguel"));
			colunaQtdDiariasAluguel.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("quantidadeDeDiarias"));
			colunaValorDiariaAluguel.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("valorDiaria"));
			colunaTaxasAluguel.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("taxas"));
			colunaTotalAluguel.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("valorTotal"));
			colunaNomeClienteAluguel.setCellValueFactory(new Callback<CellDataFeatures<Aluguel, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(CellDataFeatures<Aluguel, String> c) {
					return new SimpleStringProperty(c.getValue().getCliente().getNome());                
				}
			}); 	
			colunaCPFClienteluguel.setCellValueFactory(new Callback<CellDataFeatures<Aluguel, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(CellDataFeatures<Aluguel, String> c) {
					return new SimpleStringProperty(c.getValue().getCliente().getCPF());                
				}
	
			}); 
			colunaPlacaVeiculoAluguel.setCellValueFactory(new Callback<CellDataFeatures<Aluguel, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(CellDataFeatures<Aluguel, String> c) {
					return new SimpleStringProperty(c.getValue().getVeiculo().getPlacaVeiculo());                
				}
			}); 
			colunaNomeVeiculoAluguel.setCellValueFactory(new Callback<CellDataFeatures<Aluguel, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(CellDataFeatures<Aluguel, String> c) {
					return new SimpleStringProperty(c.getValue().getVeiculo().getNomeVeiculo());                
				}
			});
			colunaKMPreAluguel.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("kmPre"));
			colunaKMPosAluguel.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("kmPos"));
			tabelaDeAlugueis.setItems(listaAlugueis);	
	
			// Inicia o Date Picker e seta a data de início pra hoje.
			final LocalDate hoje = LocalDate.now();
			datePickerDataDeInicio.setValue(hoje);
			datePickerDataDeTermino.setValue(LocalDate.now().plusDays(1));
	
			// Botão de Aluga Veículos
			botaoAlugaVeiculo.setOnAction((e) -> {
				RadioButton valorDaDiariaSelecionada = (RadioButton) radioValorDiaria.getSelectedToggle();
				String diariaSelecionada = valorDaDiariaSelecionada.getText();
				
				Aluguel aluguel = new Aluguel(datePickerDataDeTermino.getValue(), Double.valueOf(diariaSelecionada), tabelaDeVeiculosHome.getSelectionModel().getSelectedItem() , tabelaDeClientesHome.getSelectionModel().getSelectedItem(), Integer.parseInt(kilometragemInicialAluguel.getText()));
				System.out.println(aluguel);
				AluguelDAO aluguelDAO = new AluguelDAO(ConnectionManager.getMysqlConnection());
	
				if (aluguelDAO.alugaVeiculo(aluguel)) {
					labelAvisoCadastroAluguel.setText("===== Aluguel cadastrado com sucesso!======");
	
					// Atualiza Lista de Alugueis
					listaAlugueis.setAll(FXCollections.observableArrayList(AluguelDAO.obterListaDeAlugueis()));
					colunaIdAluguel.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("idAluguel"));
					colunaDataDeInicioAluguel.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("dataDeInicioAluguel"));
					colunaDataDeTerminoAluguel.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("dataDeTerminoAluguel"));
					colunaQtdDiariasAluguel.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("quantidadeDeDiarias"));
					colunaValorDiariaAluguel.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("valorDiaria"));
					colunaTaxasAluguel.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("taxas"));
					colunaTotalAluguel.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("valorTotal"));
					colunaNomeClienteAluguel.setCellValueFactory(new Callback<CellDataFeatures<Aluguel, String>, ObservableValue<String>>() {
						@Override
						public ObservableValue<String> call(CellDataFeatures<Aluguel, String> c) {
							return new SimpleStringProperty(c.getValue().getCliente().getNome());                
						}
					}); 	
					colunaCPFClienteluguel.setCellValueFactory(new Callback<CellDataFeatures<Aluguel, String>, ObservableValue<String>>() {
						@Override
						public ObservableValue<String> call(CellDataFeatures<Aluguel, String> c) {
							return new SimpleStringProperty(c.getValue().getCliente().getCPF());                
						}
			
					}); 
					colunaPlacaVeiculoAluguel.setCellValueFactory(new Callback<CellDataFeatures<Aluguel, String>, ObservableValue<String>>() {
						@Override
						public ObservableValue<String> call(CellDataFeatures<Aluguel, String> c) {
							return new SimpleStringProperty(c.getValue().getVeiculo().getPlacaVeiculo());                
						}
					}); 
					colunaNomeVeiculoAluguel.setCellValueFactory(new Callback<CellDataFeatures<Aluguel, String>, ObservableValue<String>>() {
						@Override
						public ObservableValue<String> call(CellDataFeatures<Aluguel, String> c) {
							return new SimpleStringProperty(c.getValue().getVeiculo().getNomeVeiculo());                
						}
					});
					colunaKMPreAluguel.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("kmPre"));
					colunaKMPosAluguel.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("kmPos"));					
					tabelaDeAlugueis.setItems(listaAlugueis);
					System.out.println("Lista de Aluguéis Atualizada!");
	
				} else {
					labelAvisoCadastroAluguel.setText("____ERRO_____Cadastro de aluguel falhou.____ERRO_____");	
				}
			});		
	
		}	

}
