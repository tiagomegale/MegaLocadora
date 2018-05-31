package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void connect() {

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
		// launch(args);
		menu();

	}
}
