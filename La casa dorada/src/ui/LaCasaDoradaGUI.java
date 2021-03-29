package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.LaCasaDorada;

public class LaCasaDoradaGUI {
	
	private LaCasaDorada laCasaDorada;
	private MenuGUI menuGUI;
	
	public LaCasaDoradaGUI() {
		laCasaDorada = new LaCasaDorada();
		menuGUI = new MenuGUI(laCasaDorada);
		
	}
	
	public void initialize() {
    	//the method (initialize) is called several times by diferents fxml file loads 
    }

    @FXML
    private BorderPane mainPane;

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField pfPassword;

    @FXML
    void loginUser(ActionEvent event) throws IOException {
    	if(txtUsername.getText().equals("admin")) {
    		if(pfPassword.getText().equals("123")) {
    			//loadMenu();
    			FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("menu.fxml"));
    	    	
    			Stage stage1 = (Stage) mainPane.getScene().getWindow();
    			stage1.close();
    			
    	    	fxmlloader.setController(menuGUI);
    	    	Parent menu = fxmlloader.load();  
    	    	Scene scene = new Scene(menu);
    	    	Stage stage = new Stage();
    	    	stage.setScene(scene);
    	    	stage.setTitle("La casa Dorada");
    	    	stage.setResizable(false);
    	    	stage.show();
    	    	
    	    	
    		}else {
        		Alert alert = new Alert(AlertType.WARNING);
        		alert.setTitle("Wrong username or password");
        		alert.setHeaderText("Wrong username or password");
        		alert.setContentText("Wrong username or password");
        		alert.showAndWait();
        		txtUsername.clear();
        		pfPassword.clear();
        	}
    	}else {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("Wrong username or password");
    		alert.setHeaderText("Wrong username or password");
    		alert.setContentText("Wrong username or password");
    		alert.showAndWait();
    		txtUsername.clear();
    		pfPassword.clear();
    	}
    }
}
  