package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LaCasaDoradaGUI {

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
    	    	
    	    	fxmlloader.setController(this);
    	    	
    	    	Parent menu = fxmlloader.load();  
    	    	mainPane.getChildren().clear();
    	    	mainPane.setCenter(menu);
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
    /*public void loadMenu() throws IOException {
    	FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("menu.fxml"));
    	
    	fxmlloader.setController(this);
    	
    	Parent listPane = fxmlloader.load();  
    	mainPane.getChildren().clear();
    	mainPane.setCenter(listPane);
    }
    */
    //MENU
    
    	@FXML
    	private BorderPane mainPane2;
        @FXML
        private MenuItem mMenu;

        @FXML
        private MenuItem mMngmt;

        @FXML
        private MenuItem mClients;

        @FXML
        private MenuItem mEmployees;

        @FXML
        private MenuItem mOrders;

        @FXML
        private MenuItem mMore;

        @FXML
        private BorderPane borderPane;
}
