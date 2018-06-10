package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("aplicacao.fxml"));
			Scene scene = new Scene(root,1280,768);
			primaryStage.setTitle("MegaLocadora");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

