package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	private LaCasaDoradaGUI laCasaDoradaGUI;
	
	public Main () {
		laCasaDoradaGUI  =new LaCasaDoradaGUI();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("loginUi.fxml"));

		fxmlLoader.setController(laCasaDoradaGUI);
		
		Parent root = fxmlLoader.load();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Contact Manager");
		primaryStage.show();
	}

}
