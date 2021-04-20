package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
	
	public void initialize()  throws ClassNotFoundException, IOException{
		laCasaDorada.load();
    	//the method (initialize) is called several times by diferents fxml file loads 
    }

	
	//login interface
    @FXML
    private BorderPane mainPane;

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField pfPassword;

    @FXML
    void createUser(ActionEvent event) throws IOException {
    	FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("addUserGUI.fxml"));
		
    	fxmlloader.setController(this);
    	Parent menu = fxmlloader.load();  
    	Scene scene = new Scene(menu);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void loginUser(ActionEvent event) throws IOException {
		System.out.println(txtUsername.getText());
    	if(txtUsername.getText().equals(laCasaDorada.searchUserAndname(txtUsername.getText()))) {
    		if(pfPassword.getText().equals(laCasaDorada.searchUserAndPassword(pfPassword.getText()))) {
	
	
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
    	    	//stage.setResizable(false);
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
    //add user interface
    
    @FXML
    private BorderPane addUserPane;

    @FXML
    private TextField userName;

    @FXML
    private TextField userLastname;

    @FXML
    private TextField userId;

    @FXML
    private TextField userPassword;

    @FXML
    private TextField userUser;
    
    @FXML
    private Label statusUser;

    @FXML
    void addUser(ActionEvent event) throws IOException {
      	//add contact in the model        
    	laCasaDorada.addUser(userName.getText(),userLastname.getText(),userId.getText(),userUser.getText(),userPassword.getText());
    	//clean the fields in the gui       
    	userName.setText("");
    	userLastname.setText("");
    	userId.setText("");
    	userUser.setText("");
    	userPassword.setText("");
    	//show the success message
    	statusUser.setText("Agregado!");
    }
}
  