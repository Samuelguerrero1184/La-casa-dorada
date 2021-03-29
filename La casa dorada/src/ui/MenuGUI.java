package ui;

import java.io.IOException;
import java.util.Collections;

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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import model.Client;
import model.Employee;
import model.LaCasaDorada;

public class MenuGUI {
	
	private LaCasaDorada laCasaDorada;
	
	public MenuGUI(LaCasaDorada cd) {
    	laCasaDorada = cd;    	
	}
	
	public void initialize() throws ClassNotFoundException, IOException {
		laCasaDorada.load();
    	//the method (initialize) is called several times by diferents fxml file loads 
    }

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
    	borderPane.setCenter(addClientPane);
    }
    
    @FXML
    void loadEmployeesMngmt(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("employees.fxml"));
		
		fxmlLoader.setController(this);    	
		Parent addClientPane = fxmlLoader.load();
    	
		borderPane.getChildren().clear();
    	borderPane.setCenter(addClientPane);

    }

    //Clients window

        @FXML
        private TextField name;
        
        @FXML
        private TextField lastName;
     
        @FXML
        private TextField identification;

        @FXML
        private TextField address;       
    
        @FXML
        private TextField phone;

        @FXML
        private TextField comments;

        @FXML
        private Button addclientBtn;

        @FXML
        private Button clearFormBtn;

        @FXML
        private Label addStatus;

        @FXML
        private Button clientListBtn;

        @FXML
        void addClient2List(ActionEvent event) throws IOException {
        	//add contact in the model        
        	laCasaDorada.addClient(name.getText(), lastName.getText(), identification.getText(), address.getText(), phone.getText(), comments.getText());
        	//clean the fields in the gui       
        	name.setText("");
        	lastName.setText("");
        	identification.setText("");
        	address.setText("");
        	phone.setText("");
        	comments.setText("");
        	//show the success message
        	addStatus.setText("Agregado!");   
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
        void loadClientList(ActionEvent event) throws IOException {
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("clientsList.fxml"));
    		
    		fxmlLoader.setController(this);    	
    		Parent addClientPane = fxmlLoader.load();
        	
    		borderPane.getChildren().clear();
        	borderPane.setCenter(addClientPane);
        	tvClientsList.setEditable(true);
        	initializeTableView();      	
        }
        
        //Table view
        @FXML
        private Button addContactBtn;
        
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
        	observableList = FXCollections.observableArrayList(laCasaDorada.getClients());
        	
    		tvClientsList.setItems(observableList);
    		tcName.setCellValueFactory(new PropertyValueFactory<Client,String>("name")); //the tableview search for a method called getName
    		tcLastName.setCellValueFactory(new PropertyValueFactory<Client,String>("lastname")); //the tableview search for a method called getEmail
    		tcId.setCellValueFactory(new PropertyValueFactory<Client,String>("id"));
    		tcAddress.setCellValueFactory(new PropertyValueFactory<Client,String>("address"));
    		tcPhone.setCellValueFactory(new PropertyValueFactory<Client,String>("phone"));
    		tcComments.setCellValueFactory(new PropertyValueFactory<Client,String>("comments"));
        }
        @FXML
        void addContact(ActionEvent event) throws IOException {
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("clients.fxml"));
    		
    		fxmlLoader.setController(this);    	
    		Parent addClientPane = fxmlLoader.load();
        	
    		borderPane.getChildren().clear();
        	borderPane.setCenter(addClientPane);
        }          
        
       
        //Employee window 

        @FXML
        private Pane employeePane;
        
        @FXML
        private TextField nameE;

        @FXML
        private TextField lastNameE;

        @FXML
        private TextField identificationE;

        @FXML
        private Button addclientBtnE;

        @FXML
        private Button clearFormBtnE;

        @FXML
        private Label addStatusE;

        @FXML
        private Button EmployeeListBtn;

        @FXML
        void addEmployee2List(ActionEvent event) throws IOException {
          	//add contact in the model        
        	laCasaDorada.addEmployee(nameE.getText(), lastNameE.getText(), identificationE.getText());
        	//clean the fields in the gui       
        	nameE.setText("");
        	lastNameE.setText("");
        	identificationE.setText("");
        	//show the success message
        	addStatusE.setText("Agregado!");
        }

        @FXML
        void clearFormE(ActionEvent event) {

        }

        @FXML
        void loadEmployeeList(ActionEvent event) throws IOException {
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EmployeeList.fxml"));
    		
    		fxmlLoader.setController(this);    	
    		Parent addEmployeePane = fxmlLoader.load();
        	
    		borderPane.getChildren().clear();
        	borderPane.setCenter(addEmployeePane);
        	tvEmployeeList.setEditable(true);
        	initializeTableViewE();      	
        } 
        
        //Employee list
        
        @FXML
        private Label prueba;
        
        @FXML
        private Button addEmployeeBtn;

        @FXML
        private ScrollPane tablePaneE;

        @FXML
        private TableView<Employee> tvEmployeeList;

        @FXML
        private TableColumn<Employee, String> tcNameE;

        @FXML
        private TableColumn<Employee, String> tcLastNameE;

        @FXML
        private TableColumn<Employee, String> tcIdE;
        
        @FXML
        private Button eliminateEmployee;

        @FXML
        private Button cancelE;

        @FXML
        void addEmployee(ActionEvent event) throws IOException {
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("employees.fxml"));
    		
    		fxmlLoader.setController(this);    	
    		Parent addClientPane = fxmlLoader.load();
        	
    		borderPane.getChildren().clear();
        	borderPane.setCenter(addClientPane);
        	
        }
        
        @FXML
        private TextField searchBarE;

        @FXML
        private Button searchE;

        @FXML
        private AnchorPane gestionEmployee;
        
        private void initializeTableViewE() {
        	ObservableList<Employee> observableList;
        	observableList = FXCollections.observableArrayList(laCasaDorada.getEmployee());
        	
    		tvEmployeeList.setItems(observableList);
    		tcNameE.setCellValueFactory(new PropertyValueFactory<Employee, String>("name")); //the tableview search for a method called getName
    		tcLastNameE.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastname")); //the tableview search for a method called getEmail
    		tcIdE.setCellValueFactory(new PropertyValueFactory<Employee, String>("id"));
        }
        
        @FXML
        void searchEmployee(ActionEvent event) {		
        	prueba.setText(laCasaDorada.searchEmployee(searchBarE.getText()));
        	eliminateEmployee.setVisible(true);
        }
        
        @FXML
        void cancelE(ActionEvent event) {
			prueba.setText("");
			searchBarE.clear();
        }

        @FXML
        void deleteEmployee(ActionEvent event) throws NumberFormatException, IOException {
		prueba.setText(laCasaDorada.deleteEmployee(searchBarE.getText()));    	
		 	
        }
}

    
    

