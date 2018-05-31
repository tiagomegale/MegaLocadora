package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			Parent root = FXMLLoader.load(getClass().getResource("aplicacao.fxml"));
			Scene scene = new Scene(root,1024,768);
			primaryStage.setTitle("MegaLocadora");
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void menu(){

		System.out.println("Início");

		Carro carro = new Carro("Honda", "HMP-0774");
		System.out.println("criado carro: " +  carro);

		Cliente cliente = new Cliente("Tereza", "067.522.516-73");
		System.out.println("criado cliente: " + cliente);

		Aluguel aluguel = new Aluguel("12/04/1984", "15/04,1984", carro, cliente);
		System.out.println("criado aluguel: " + aluguel);

		System.out.println("Fim");
		
	};


	public static void main(String[] args) {
		//	connect();
		launch(args);
	//	menu();

	}
}
