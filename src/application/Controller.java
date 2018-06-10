package application;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import DAO.AluguelDAO;
import DAO.ClienteDAO;
import DAO.VeiculoDAO;
import connection.ConnectionManager;
//Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

import domain.Aluguel;
import domain.Cliente;
import domain.Veiculo;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
//Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
//Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

import javafx.scene.layout.Pane;
import javafx.util.Callback;

public class Controller implements Initializable{

	// Painéis da Home
	@FXML
	private TabPane tabPaneConteudo;
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			


	@FXML
	private Pane paneHome;


	// HOME
	// Tabela e Colunas de Clientes
	@FXML
	TableView<Cliente> tabelaDeClientesHome;
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			


	@FXML
	TableColumn<Cliente, String> colunaNomeHome;

	@FXML
	TableColumn<Cliente, String> colunaCPFHome;
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

	@FXML
	TableView<Veiculo> tabelaDeVeiculosHome;

	@FXML
	TableColumn<Veiculo, String> colunaPlacaVeiculoHome;

	@FXML
	TableColumn<Veiculo, String> colunaNomeVeiculoHome;
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

	@FXML
	private Label labelClienteSelecionadoHome;
	
	@FXML
	private Label labelVeiculoSelecionadoHome;
	
	@FXML
	private Label labelSelecioneUmCliente;
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

	@FXML
	private Label labelSelecioneUmVeiculo;
	
	
	
	// Form de Cadastro de Clientes
	@FXML
	private TextField nomeCliente;
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

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
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

	@FXML
	private Label labelAvisoCadastroCliente;

	
	// Tabela e Colunas de Clientes
	@FXML
	TableView<Cliente> tabelaDeClientes;

	@FXML
	TableColumn<Cliente, String> colunaNome;
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

	@FXML
	TableColumn<Cliente, String> colunaCPF;

	@FXML
	TableColumn<Cliente, String> colunaEndereco;

	@FXML
	TableColumn<Cliente, String> colunaTelefone;
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

	@FXML
	TableColumn<Cliente, String> colunaSexo;

	@FXML
	TableColumn<Cliente, String> colunaDataDeNascimento;



	// Form de Cadastro de Veículos
	@FXML
	private TextField placaVeiculo;
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

	@FXML
	private TextField nomeVeiculo;

	@FXML
	private TextField modeloVeiculo;

	@FXML
	private TextField marcaVeiculo;

	@FXML
	private Slider anoDeFabricacao;
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

	@FXML
	private Label labelSliderAnoDeFabricacao;

	@FXML
	private Slider anoDeVenda;

	@FXML
	private Label labelSliderAnoDeVenda;

	@FXML
	private Button botaoCadastraVeiculo;
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

	@FXML
	private Label labelAvisoCadastroVeiculo;

	// Tabela e Colunas de Veículos
	@FXML
	TableView<Veiculo> tabelaDeVeiculos;

	@FXML
	TableColumn<Veiculo, String> colunaPlacaVeiculo;
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

	@FXML
	TableColumn<Veiculo, String> colunaNomeVeiculo;

	@FXML
	TableColumn<Veiculo, String> colunaModeloVeiculo;

	@FXML
	TableColumn<Veiculo, String> colunaMarcaVeiculo;

	@FXML
	TableColumn<Veiculo, String> colunaAnoDeFabricacao;
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

	@FXML
	TableColumn<Veiculo, String> colunaAnoDeVenda;



	// Form de Cadastro de Aluguel
	@FXML
	private Button botaoAlugaVeiculo;

	@FXML
	private Label labelAvisoCadastroAluguel;

	@FXML
	private DatePicker datePickerDataDeInicio;
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

	@FXML
	private DatePicker datePickerDataDeTermino;

	@FXML
	private RadioButton radioValorDiaria49;
	
	@FXML
	private RadioButton radioValorDiaria59;
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

	@FXML
	private RadioButton radioValorDiaria109;
	
	@FXML
	private ToggleGroup radioValorDiaria;
	
	@FXML
	private TextField kilometragemInicialAluguel;
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

	@FXML
	private Button botaoBuscarClientePorCPF;
	
	@FXML
	private Button botaoBuscarVeiculoPorPlaca;
	
	@FXML
	private TextField textFieldBuscaClientePorCPF;
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

	@FXML
	private TextField textFieldBuscaVeiculoPorPlaca;
	
	// Form de Cadastro de Devolução
	// Tabela de Devolução
	@FXML
	TableView<Aluguel> tabelaDevolucao;
	
	@FXML
	TableColumn<Aluguel, String> colunaDataInicioDevolucao;
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

	@FXML
	TableColumn<Aluguel, String> colunaDataTerminoDevolucao;
		
	@FXML
	TableColumn<Aluguel, String> colunaNomeVeiculoDevolucao;
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

	@FXML
	TableColumn<Aluguel, String> colunaPlacaVeiculoDevolucao;
		
	@FXML
	TableColumn<Aluguel, String> colunaNomeClienteDevolucao;
		
	// Form Devolucao
	@FXML
	Label labelSelecioneUmAluguel;
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

	@FXML
	Label labelAluguelSelecionadoDevolucao;
	
	@FXML
	TextField textFieldKilometragemFinalDevolucao;
	
	@FXML
	Button botaoDevolveVeiculo;
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

	
	// Tabela e Colunas de Alugueis
	@FXML
	TableView<Aluguel> tabelaDeAlugueis;

	@FXML
	TableColumn<Aluguel, String> colunaIdAluguel;
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

	@FXML
	TableColumn<Aluguel, String> colunaDataDeInicioAluguel;

	@FXML
	TableColumn<Aluguel, String> colunaDataDeTerminoAluguel;

	@FXML
	TableColumn<Aluguel, String> colunaQtdDiariasAluguel;

	@FXML
	TableColumn<Aluguel, String> colunaValorDiariaAluguel;
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

	@FXML
	TableColumn<Aluguel, String> colunaTaxasAluguel;

	@FXML
	TableColumn<Aluguel, String> colunaTotalAluguel;

	@FXML
	TableColumn<Aluguel, String> colunaNomeClienteAluguel;
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

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
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			


	@Override
	public void initialize(URL location, ResourceBundle resources) {

		final LocalDate hoje = LocalDate.now();
		
		// ABA HOME
			//Tabela de Clientes Home
			ObservableList<Cliente> listaClientesHome = FXCollections.observableArrayList(ClienteDAO.obterListaDeClientes());
			colunaNomeHome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
			colunaCPFHome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("CPF"));
			tabelaDeClientesHome.setItems(listaClientesHome);
			// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
	
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
			// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
		
			tabelaDeVeiculosHome.setOnMouseClicked((e) -> {
				Veiculo veiculoSelecionadoHome = tabelaDeVeiculosHome.getSelectionModel().getSelectedItem();
				labelVeiculoSelecionadoHome.setText(veiculoSelecionadoHome.getMarcaVeiculo() + " " + veiculoSelecionadoHome.getNomeVeiculo() + " de Placa: " + veiculoSelecionadoHome.getPlacaVeiculo());
				labelSelecioneUmVeiculo.setText("Veículo selecionado: ");
			});
			
			//Botões de Busca
			botaoBuscarClientePorCPF.setOnAction((e) -> {
				ClienteDAO clienteDAO = new ClienteDAO(ConnectionManager.getMysqlConnection());
				listaClientesHome.setAll(FXCollections.observableArrayList(clienteDAO.encontraClientePorCPF(textFieldBuscaClientePorCPF.getText())));
				colunaNomeHome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
				colunaCPFHome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("CPF"));
				tabelaDeClientesHome.setItems(listaClientesHome);	
			});
			// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
			
			botaoBuscarVeiculoPorPlaca.setOnAction((e) -> {
				VeiculoDAO veiculoDAO = new VeiculoDAO(ConnectionManager.getMysqlConnection());
				listaVeiculosHome.setAll(FXCollections.observableArrayList(veiculoDAO.encontraVeiculoPorPlaca(textFieldBuscaVeiculoPorPlaca.getText())));
				colunaPlacaVeiculoHome.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("placaVeiculo"));
				colunaNomeVeiculoHome.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("nomeVeiculo"));
				tabelaDeVeiculosHome.setItems(listaVeiculosHome);
			});
			
			// Tabela Devolução
			ObservableList<Aluguel> listaAlugueisHome = FXCollections.observableArrayList(AluguelDAO.obterListaDeAlugueisAtivos());
			colunaDataInicioDevolucao.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("dataDeInicioAluguel"));
			colunaDataTerminoDevolucao.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("dataDeTerminoAluguel"));
			colunaNomeVeiculoDevolucao.setCellValueFactory(new Callback<CellDataFeatures<Aluguel, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(CellDataFeatures<Aluguel, String> c) {
					return new SimpleStringProperty(c.getValue().getVeiculo().getNomeVeiculo());                
				}
			});
			colunaPlacaVeiculoDevolucao.setCellValueFactory(new Callback<CellDataFeatures<Aluguel, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(CellDataFeatures<Aluguel, String> c) {
					return new SimpleStringProperty(c.getValue().getVeiculo().getPlacaVeiculo());                
				}
			}); 
			// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

			colunaNomeClienteDevolucao.setCellValueFactory(new Callback<CellDataFeatures<Aluguel, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(CellDataFeatures<Aluguel, String> c) {
					return new SimpleStringProperty(c.getValue().getCliente().getNome());                
				}
			}); 	
			tabelaDevolucao.setItems(listaAlugueisHome);	
			
			tabelaDevolucao.setOnMouseClicked((e) -> {
				Aluguel aluguelSelecionadoDevolucao = tabelaDevolucao.getSelectionModel().getSelectedItem();
				labelAluguelSelecionadoDevolucao.setText(aluguelSelecionadoDevolucao.toString());
				labelSelecioneUmAluguel.setText("Aluguel Selecionado: ");
			});

		// Tela de Clientes

			// Cria Tabela de Clientes
			ObservableList<Cliente> listaClientes = FXCollections.observableArrayList(ClienteDAO.obterListaDeClientes());
			colunaNome.setCellValueFactory(new PropertyValueFactory<Cliente,String>("nome"));
			colunaCPF.setCellValueFactory(new PropertyValueFactory<Cliente,String>("CPF"));
			// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

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
				// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
	
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
					// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
				
					System.out.println("Lista de Clientes na aba clientes Atualizada!");
					
					listaClientesHome.setAll(FXCollections.observableArrayList(ClienteDAO.obterListaDeClientes()));
					colunaNomeHome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
					colunaCPFHome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("CPF"));
					tabelaDeClientesHome.setItems(listaClientesHome);
					
					System.out.println("Lista de Clientes na home Atualizada!");
				} else {
					labelAvisoCadastroCliente.setText("____ERRO_____Cadastro de cliente falhou.____ERRO_____");	
				}
			});

			// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

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
			// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
	
			//Slider
			labelSliderAnoDeFabricacao.textProperty().bind(Bindings.format("%.00f", anoDeFabricacao.valueProperty()));
			labelSliderAnoDeVenda.textProperty().bind(Bindings.format("%.00f", anoDeVenda.valueProperty()));
	
			// Cria Choicebox de sexo do Cliente
			ObservableList<String> opcoesDeSexo = FXCollections.observableArrayList("Masculino", "Feminino");
			sexoCliente.setItems(opcoesDeSexo);
			// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

			// Botão Cadastra Veículo
			botaoCadastraVeiculo.setOnAction((e) -> {
	
				Veiculo veiculo = new Veiculo(placaVeiculo.getText(), nomeVeiculo.getText(), modeloVeiculo.getText(), marcaVeiculo.getText(), (int) anoDeFabricacao.getValue(), (int) anoDeVenda.getValue());
				System.out.println(veiculo);
				VeiculoDAO veiculoDAO = new VeiculoDAO(ConnectionManager.getMysqlConnection());
	
				if (veiculoDAO.inserirVeiculoBanco(veiculo)) {
					labelAvisoCadastroVeiculo.setText("Veículo cadastrado com sucesso!");
					// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
				
					// Atualiza Lista de Veículos na Aba Veículos
					listaVeiculos.setAll(FXCollections.observableArrayList(VeiculoDAO.obterListaDeVeiculos()));
					colunaPlacaVeiculo.setCellValueFactory(new PropertyValueFactory<Veiculo,String>("placaVeiculo"));
					colunaNomeVeiculo.setCellValueFactory(new PropertyValueFactory<Veiculo,String>("nomeVeiculo"));
					colunaModeloVeiculo.setCellValueFactory(new PropertyValueFactory<Veiculo,String>("modeloVeiculo"));
					colunaMarcaVeiculo.setCellValueFactory(new PropertyValueFactory<Veiculo,String>("marcaVeiculo"));
					colunaAnoDeFabricacao.setCellValueFactory(new PropertyValueFactory<Veiculo,String>("anoDeFabricacao"));
					colunaAnoDeVenda.setCellValueFactory(new PropertyValueFactory<Veiculo,String>("anoDeVenda"));
					tabelaDeVeiculos.setItems(listaVeiculos);	
					System.out.println("Lista de Veículos na aba veículos Atualizada!");
					// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
					
					// Atualiza Lista de Veículos na Home
					listaVeiculosHome.setAll(FXCollections.observableArrayList(VeiculoDAO.obterListaDeVeiculos()));
					colunaPlacaVeiculoHome.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("placaVeiculo"));
					colunaNomeVeiculoHome.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("nomeVeiculo"));
					tabelaDeVeiculosHome.setItems(listaVeiculosHome);	
					System.out.println("Lista de Veículos na home Atualizada!");

				} else {
					labelAvisoCadastroVeiculo.setText("____ERRO_____Cadastro de veículo falhou.____ERRO_____");	
				}
			});

			// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

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
				// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
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
				// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
	
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
			// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

			colunaKMPreAluguel.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("kmPre"));
			colunaKMPosAluguel.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("kmPos"));
			tabelaDeAlugueis.setItems(listaAlugueis);	
	
			// Inicia o Date Picker e seta a data de início pra hoje.

			datePickerDataDeInicio.setValue(hoje);
			datePickerDataDeTermino.setValue(LocalDate.now().plusDays(1));
			// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

			// Botão de Aluga Veículos
			botaoAlugaVeiculo.setOnAction((e) -> {
				RadioButton valorDaDiariaSelecionada = (RadioButton) radioValorDiaria.getSelectedToggle();
				String diariaSelecionada = valorDaDiariaSelecionada.getText();
				
				Aluguel aluguel = new Aluguel(datePickerDataDeTermino.getValue(), Double.valueOf(diariaSelecionada), tabelaDeVeiculosHome.getSelectionModel().getSelectedItem() , tabelaDeClientesHome.getSelectionModel().getSelectedItem(), Integer.parseInt(kilometragemInicialAluguel.getText()));
				System.out.println(aluguel);
				AluguelDAO aluguelDAO = new AluguelDAO(ConnectionManager.getMysqlConnection());
				// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
	
				if (aluguelDAO.alugaVeiculo(aluguel)) {
					labelAvisoCadastroAluguel.setText("===== Aluguel cadastrado com sucesso!======");
	
					// Atualiza Lista de Alugueis na Aba Alugueis
					listaAlugueis.setAll(FXCollections.observableArrayList(AluguelDAO.obterListaDeAlugueis()));
					colunaIdAluguel.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("idAluguel"));
					colunaDataDeInicioAluguel.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("dataDeInicioAluguel"));
					colunaDataDeTerminoAluguel.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("dataDeTerminoAluguel"));
					// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

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
						// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
			
					}); 
					colunaPlacaVeiculoAluguel.setCellValueFactory(new Callback<CellDataFeatures<Aluguel, String>, ObservableValue<String>>() {
						@Override
						public ObservableValue<String> call(CellDataFeatures<Aluguel, String> c) {
							return new SimpleStringProperty(c.getValue().getVeiculo().getPlacaVeiculo());                
						}
					}); 
					// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

					colunaNomeVeiculoAluguel.setCellValueFactory(new Callback<CellDataFeatures<Aluguel, String>, ObservableValue<String>>() {
						@Override
						public ObservableValue<String> call(CellDataFeatures<Aluguel, String> c) {
							return new SimpleStringProperty(c.getValue().getVeiculo().getNomeVeiculo());                
						}
					});
					colunaKMPreAluguel.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("kmPre"));
					colunaKMPosAluguel.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("kmPos"));					
					tabelaDeAlugueis.setItems(listaAlugueis);
					System.out.println("Lista de Aluguéis na aba alugueis Atualizada!");
					// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
				
					
					// Atualiza lista de aluguéis na Home
					listaAlugueisHome.setAll(FXCollections.observableArrayList(AluguelDAO.obterListaDeAlugueis()));
					colunaDataInicioDevolucao.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("dataDeInicioAluguel"));
					colunaDataTerminoDevolucao.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("dataDeTerminoAluguel"));
					colunaNomeVeiculoDevolucao.setCellValueFactory(new Callback<CellDataFeatures<Aluguel, String>, ObservableValue<String>>() {
						@Override
						public ObservableValue<String> call(CellDataFeatures<Aluguel, String> c) {
							return new SimpleStringProperty(c.getValue().getVeiculo().getNomeVeiculo());                
						}
					});
					// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

					colunaPlacaVeiculoDevolucao.setCellValueFactory(new Callback<CellDataFeatures<Aluguel, String>, ObservableValue<String>>() {
						@Override
						public ObservableValue<String> call(CellDataFeatures<Aluguel, String> c) {
							return new SimpleStringProperty(c.getValue().getVeiculo().getPlacaVeiculo());                
						}
					}); 
					// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

					colunaNomeClienteDevolucao.setCellValueFactory(new Callback<CellDataFeatures<Aluguel, String>, ObservableValue<String>>() {
						@Override
						public ObservableValue<String> call(CellDataFeatures<Aluguel, String> c) {
							return new SimpleStringProperty(c.getValue().getCliente().getNome());                
						}
					}); 	
					System.out.println("Lista de Aluguéis na Home Atualizada!");

	
				} else {
					labelAvisoCadastroAluguel.setText("____ERRO_____Cadastro de aluguel falhou.____ERRO_____");	
				}
			});		
			
			// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
		
			botaoDevolveVeiculo.setOnAction((e) -> {
				Aluguel aluguelSelecionadoDevolucao = tabelaDevolucao.getSelectionModel().getSelectedItem();
				AluguelDAO aluguelDAO = new AluguelDAO(ConnectionManager.getMysqlConnection());
				aluguelSelecionadoDevolucao.setDataDeTerminoAluguel(hoje);
				aluguelSelecionadoDevolucao.setKmPos(Integer.parseInt(textFieldKilometragemFinalDevolucao.getText()));
				aluguelDAO.devolveVeiculo(aluguelSelecionadoDevolucao);
				labelAluguelSelecionadoDevolucao.setText("Devolução feita com sucesso!");
				// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
				
				// Atualiza Lista de Alugueis na Aba Alugueis
				listaAlugueis.setAll(FXCollections.observableArrayList(AluguelDAO.obterListaDeAlugueis()));
				colunaIdAluguel.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("idAluguel"));
				colunaDataDeInicioAluguel.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("dataDeInicioAluguel"));
				colunaDataDeTerminoAluguel.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("dataDeTerminoAluguel"));
				colunaQtdDiariasAluguel.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("quantidadeDeDiarias"));
				colunaValorDiariaAluguel.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("valorDiaria"));
				colunaTaxasAluguel.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("taxas"));
				colunaTotalAluguel.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("valorTotal"));
				colunaNomeClienteAluguel.setCellValueFactory(new Callback<CellDataFeatures<Aluguel, String>, ObservableValue<String>>() {
					// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

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
				// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

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
				System.out.println("Lista de Aluguéis na aba alugueis Atualizada!");
				// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
				
				
				// Atualiza lista de aluguéis na Home
				listaAlugueisHome.setAll(FXCollections.observableArrayList(AluguelDAO.obterListaDeAlugueisAtivos()));
				colunaDataInicioDevolucao.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("dataDeInicioAluguel"));
				colunaDataTerminoDevolucao.setCellValueFactory(new PropertyValueFactory<Aluguel,String>("dataDeTerminoAluguel"));
				colunaNomeVeiculoDevolucao.setCellValueFactory(new Callback<CellDataFeatures<Aluguel, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Aluguel, String> c) {
						return new SimpleStringProperty(c.getValue().getVeiculo().getNomeVeiculo());                
					}
				});
				colunaPlacaVeiculoDevolucao.setCellValueFactory(new Callback<CellDataFeatures<Aluguel, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Aluguel, String> c) {
						return new SimpleStringProperty(c.getValue().getVeiculo().getPlacaVeiculo());                
					}
				}); 
				colunaNomeClienteDevolucao.setCellValueFactory(new Callback<CellDataFeatures<Aluguel, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Aluguel, String> c) {
						return new SimpleStringProperty(c.getValue().getCliente().getNome());                
					}
				}); 	
				System.out.println("Lista de Aluguéis na Home Atualizada!");
				// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
			
			});
	
		}	

}
