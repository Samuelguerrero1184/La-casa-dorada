package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class MenuGUI {

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

    @FXML
    void loadClientsMngmt(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("clients.fxml"));
		
		fxmlLoader.setController(this);    	
		Parent addClientPane = fxmlLoader.load();
    	
		mainPane2.getChildren().clear();
    	mainPane2.setTop(addClientPane);
    }

    //Clients window

        @FXML
        private TextField name;

        @FXML
        private TextField phone;

        @FXML
        private TextField comments;

        @FXML
        private TextField address;

        @FXML
        private TextField lastName;

        @FXML
        private TextField identification;

        @FXML
        private Button addclientBtn;

        @FXML
        private Button clearFormBtn;

        @FXML
        private Label addStatus;

        @FXML
        private Button clientListBtn;

        @FXML
        private Button backBtn;

        @FXML
        void addClient2List(ActionEvent event) {

        }

        @FXML
        void back2Menu(ActionEvent event) {

        }

        @FXML
        void clearForm(ActionEvent event) {

        }

        @FXML
        void loadClientList(ActionEvent event) {

        }
}

    
    

