package ui;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import model.Client;
import model.LaCasaDorada;

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
    	
		borderPane.getChildren().clear();
    	borderPane.setTop(addClientPane);
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
        	addStatus.setText("Added");
        }

        @FXML
        void back2Menu(ActionEvent event) {

        }

        @FXML
        void clearForm(ActionEvent event) {
        	name.clear();
        	lastName.clear();
        	identification.clear();
        	phone.clear();
        	address.clear();
        	comments.clear();
        }
        @FXML
        private ScrollPane tablePane;

        @FXML
        private TableView<Client> tvClientsList;

        @FXML
        private TableColumn<Client, String> tcName;

        @FXML
        private TableColumn<Client, String> tcLastName;

        @FXML
        private TableColumn<Client, String> tcId;

        @FXML
        private TableColumn<Client, String> tcAddress;

        @FXML
        private TableColumn<Client, String> tcPhone;

        @FXML
        private TableColumn<Client, String> tcComments;


        private void initializeTableView() {
        	ObservableList<Client> observableList;
        	observableList = FXCollections.observableArrayList(LaCasaDorada.getClient());
        	
    		tvClientsList.setItems(observableList);
    		tcName.setCellValueFactory(new PropertyValueFactory<Client,String>("name")); //the tableview search for a method called getName
    		tcLastName.setCellValueFactory(new PropertyValueFactory<Client,String>("email")); //the tableview search for a method called getEmail
        }
        
        @FXML
        void loadClientList(ActionEvent event) {

        }
}

    
    

