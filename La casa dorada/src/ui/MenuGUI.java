package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Client;
import model.Employee;
import model.Ingredients;
import model.LaCasaDorada;
import model.Product;
import model.User;

public class MenuGUI {
	
	private LaCasaDorada laCasaDorada;
	
	public MenuGUI(LaCasaDorada cd) {
    	laCasaDorada = cd;    	
	}
	
	public void initialize() throws ClassNotFoundException, IOException {
		//laCasaDorada.load();
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
    void loadOrders(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("order.fxml"));
		
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
    
    @FXML
    void loadMenuProducts(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menuProductos.fxml"));
		
		fxmlLoader.setController(this);    	
		Parent addClientPane = fxmlLoader.load();
    	
		borderPane.getChildren().clear();
    	borderPane.setCenter(addClientPane);
    }
    
    @FXML
    void loadIngredientsWindow(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ingredients.fxml"));
		
		fxmlLoader.setController(this);    	
		Parent addClientPane = fxmlLoader.load();
		borderPane.getChildren().clear();
    	borderPane.setCenter(addClientPane);
    }
    
    @FXML
    void loadProductMngmt(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("products.fxml"));
		
		fxmlLoader.setController(this);    	
		Parent addClientPane = fxmlLoader.load();
    	
		borderPane.getChildren().clear();
    	borderPane.setCenter(addClientPane);
    }

    @FXML
    void loadExportandImport(ActionEvent event) throws FileNotFoundException, IOException {
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Open Resource File");
    	Stage stage = new Stage();
    	File file = fileChooser.showOpenDialog(stage);
    	if (file != null) {
            laCasaDorada.importClients(file);
        }
    	else{
    	Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("No File!");
		alert.setHeaderText("No File!");
		alert.setContentText("No File!");
		alert.showAndWait();
    	}
    }
 
    @FXML
    void loadUserTable(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("userList.fxml"));
		
		fxmlLoader.setController(this);    	
		Parent addClientPane = fxmlLoader.load();
    	
		borderPane.getChildren().clear();
    	borderPane.setCenter(addClientPane);
    	initializeTableViewU();
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
        	
    		Scene scene = new Scene(addClientPane);
    		Stage stage = new Stage();
    		stage.setScene(scene);
    		stage.setHeight(400);
    		stage.setWidth(1107);
    		stage.show();
        	tvClientsList.setEditable(true);
        	initializeTableView();      	
        }
        
        //Clients Table view
        
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

        @FXML
        private TextField clientSearchBar;
        
        @FXML
        private Label clientLabel;

        @FXML
        private Button clientDeleteBtn;

        @FXML
        void clientDelete(ActionEvent event) throws IOException {
        	clientLabel.setText(laCasaDorada.deleteClients(clientSearchBar.getText()));

        }

        @FXML
        void clientSearchBtn(ActionEvent event) {
        	clientLabel.setText(laCasaDorada.searchClients(clientSearchBar.getText()));
        	clientDeleteBtn.setVisible(true);
        }

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
        	nameE.clear();
        	lastNameE.clear();
        	identificationE.clear();
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
        void deleteEmployee(ActionEvent event) throws  IOException {
		prueba.setText(laCasaDorada.deleteEmployee(searchBarE.getText())); 
		borderPane.getChildren().clear(); 	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EmployeeList.fxml"));
		
		fxmlLoader.setController(this);    	
		Parent addEmployeePane = fxmlLoader.load();
    	borderPane.setCenter(addEmployeePane);
    	tvEmployeeList.setEditable(true);
    	initializeTableViewE();    	
        }
        
        //Menu de productos
        @FXML
        private BorderPane menuPane;
        
        @FXML
        private Button editProducts;

        @FXML
        private TableView<Product> tvMenu;

        @FXML
        private TableColumn<Product, String> tcProduct;

        @FXML
        private TableColumn<Product, String> tcType;

        @FXML
        private TableColumn<Product, String> tcIngredients;

        @FXML
        private TableColumn<Product, String> tcPrice;
        
        @FXML
        void loadProductMngmtWindow(ActionEvent event) throws IOException {
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("products.fxml"));
    		
    		fxmlLoader.setController(this);    	
    		Parent addClientPane = fxmlLoader.load();
        	
    		borderPane.getChildren().clear();
        	borderPane.setCenter(addClientPane);
        }
        @FXML
        void addProductWindow(ActionEvent event) throws IOException {
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("productAddd.fxml"));
    		
    		fxmlLoader.setController(this);    	
    		Parent addClientPane = fxmlLoader.load();
        	
    		borderPane.getChildren().clear();
        	borderPane.setCenter(addClientPane);
        }
        //add new products
        
        @FXML
        private BorderPane menuPaneNewProduct;

        @FXML
        private Button backBtnProd;

        @FXML
        private TextField newProductName;

        @FXML
        private TextField newProductType;

        @FXML
        private TextArea addProdIngredients;
        
        @FXML
        private TextField newProductPrice;

        @FXML
        private Button saveNewProductBtn;

        @FXML
        private Button clearNewProductBtn;

        @FXML
        private Label prodLabel;
        

        @FXML
        void loadProductList(ActionEvent event) throws IOException {
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("productList.fxml"));
    		
    		fxmlLoader.setController(this);    	
    		Parent addClientPane = fxmlLoader.load();
        	
    		borderPane.getChildren().clear();
        	borderPane.setCenter(addClientPane);
        	initializeTableViewP();
        }

        @FXML
        void clearNewProduct(ActionEvent event) {
        	newProductName.clear();
        	newProductType.clear();
        	addProdIngredients.clear();
        	newProductPrice.clear();
        }

        @FXML
        void saveNewProduct(ActionEvent event) throws IOException {
        	String a = newProductName.getText();
        	String b = newProductType.getText();
        	String c = addProdIngredients.getText();
        	String d = newProductPrice.getText();     	
        	//laCasaDorada.addIngredient(a,b,c,d);
        	System.out.println(a+b+c+d);
        }
        
        @FXML
        void backProd(ActionEvent event) throws IOException {
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menuProductos.fxml"));
    		
    		fxmlLoader.setController(this);    	
    		Parent addClientPane = fxmlLoader.load();
        	
    		borderPane.getChildren().clear();
        	borderPane.setCenter(addClientPane);
        }
        
        //product table

        @FXML
        private TableView<Product> tvProducts;

        @FXML
        private TableColumn<Product, String> tcNameProduct;

        @FXML
        private TableColumn<Product, String> tcProductType;

        @FXML
        private TableColumn<Product, Ingredients> tcProductIngredients;

        @FXML
        private TableColumn<Product, String> tcProductSize;
        
        private void initializeTableViewP() {
        	ObservableList<Product> observableList;
        	observableList = FXCollections.observableArrayList(laCasaDorada.getProducts());
        	
    		tvProducts.setItems(observableList);
    		tcNameProduct.setCellValueFactory(new PropertyValueFactory<Product,String>("name")); //the tableview search for a method called getName
    		tcProductType.setCellValueFactory(new PropertyValueFactory<Product,String>("tipo")); //the tableview search for a method called getEmail
    		tcProductIngredients.setCellValueFactory(new PropertyValueFactory<Product,Ingredients>("ingredients"));
    		tcProductSize.setCellValueFactory(new PropertyValueFactory<Product,String>("size"));
        }

        
        //Products gestion
        
        @FXML
        private BorderPane menuPaneProduct;

        @FXML
        private TextField searchBarProduct;

        @FXML
        private Button searchBtnProducts;

        @FXML
        private TextField productName;

        @FXML
        private TextField productType;
        
        @FXML
        private TextArea ingredients4NewProduct;

        @FXML
        private TextField productPrice;

        @FXML
        private Button saveProductBtn;

        @FXML
        private Button clearProductBtn;
        
        @FXML
        private Button deleteProductBtn;
        
        @FXML
        private GridPane gridPane;
        
        @FXML
        void deleteProduct(ActionEvent event) {

        }

        @FXML
        void clearProduct(ActionEvent event) {
        	searchBarProduct.clear();
        	productName.clear();
        	productType.clear();
        	ingredients4NewProduct.clear();
        	productPrice.clear();
        }

        @FXML
        void saveProduct(ActionEvent event) {

        }

        @FXML
        void searchProduct(ActionEvent event) {
        	gridPane.setDisable(false);
        }
        
        //Ingredients
        
        @FXML
        private Button seeIngredients;
        
        @FXML
        private BorderPane menuPaneIngredient;

        @FXML
        private TextField searchBarIngredient;

        @FXML
        private Button searchBtnIngredient;

        @FXML
        private TextField IngredientsName;

        @FXML
        private Button saveProductIngredients;

        @FXML
        private Button clearProductIngredients;

        @FXML
        private Button addNewIngredientBtn;

        @FXML
        private TextField newIngredient;     

        @FXML
        void IngredientsClear(ActionEvent event) {
        	IngredientsName.clear();
        }

        @FXML
        void IngredientsSave(ActionEvent event)  throws IOException {
        	Ingredients a = laCasaDorada.searchIngredientsO(Integer.parseInt(searchBarIngredient.getText()));
			a.setName(IngredientsName.getText());
        }

        @FXML
        void addNewIngredient(ActionEvent event) throws IOException {
        	laCasaDorada.addIngredient(newIngredient.getText());
        	newIngredient.clear();
        }

        @FXML
        void searchIngredients(ActionEvent event) throws NumberFormatException, IOException {
        	IngredientsName.setText(laCasaDorada.searchIngredients(Integer.parseInt(searchBarIngredient.getText())));
        }
        
        @FXML
        void loadIngredients(ActionEvent event) throws IOException {
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ingredientsList.fxml"));
    		
    		fxmlLoader.setController(this);    	
    		Parent addClientPane = fxmlLoader.load();
        	
    		borderPane.getChildren().clear();
        	borderPane.setCenter(addClientPane);
        	initializeTableViewI();
        }

        //Ingredientes table
        
        @FXML
        private Button iBackbtn;
        
        @FXML
        private BorderPane tableIngredients;
        
        @FXML
        private TableView<Ingredients> tvIngredients;

        @FXML
        private TableColumn<Ingredients, String> tcCode;

        @FXML
        private TableColumn<Ingredients, String> tcNameI;
        
        @FXML
        void iBack(ActionEvent event) throws IOException {
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ingredients.fxml"));
    		
    		fxmlLoader.setController(this);    	
    		Parent addClientPane = fxmlLoader.load();
    		borderPane.getChildren().clear();
        	borderPane.setCenter(addClientPane);
        }
        
        private void initializeTableViewI() {
        	ObservableList<Ingredients> observableList;
        	observableList = FXCollections.observableArrayList(laCasaDorada.getIngredients());
        	
    		tvIngredients.setItems(observableList);
    		tcCode.setCellValueFactory(new PropertyValueFactory<Ingredients,String>("code")); //the tableview search for a method called getName
    		tcNameI.setCellValueFactory(new PropertyValueFactory<Ingredients,String>("name")); //the tableview search for a method called getEmail
        }
        
        //ordenar pedidos
        @FXML
        private BorderPane orderPane;

        @FXML
        private TextField searchBarProductAdd;

        @FXML
        private Button addProdOrder;

        @FXML
        private Button saveOrderBtn;

        @FXML
        private Button clearOrderBtn;

        @FXML
        void clearOrder(ActionEvent event) {

        }

        @FXML
        void orderProd(ActionEvent event) {

        }

        @FXML
        void saveOrder(ActionEvent event) {

        }
 
        //User Tableview

        @FXML
        private TableView<User> userTableview;

        @FXML
        private TableColumn<User, String> tvUserName;

        @FXML
        private TableColumn<User, String> tvUserLastname;

        @FXML
        private TableColumn<User, String> tvUserId;

        @FXML
        private TableColumn<User, String> tvUserUser;

        @FXML
        private Label statusSearch;
        
        @FXML
        private TextField searchBarUser;
        
        @FXML
        void searchUser(ActionEvent event) throws IOException {
        	statusSearch.setText(laCasaDorada.searchUser(searchBarUser.getText()));
        }
        
        @FXML
        void deleteUserBtn(ActionEvent event) throws IOException {
        	statusSearch.setText(laCasaDorada.deleteUser(searchBarUser.getText())); 
    		borderPane.getChildren().clear(); 	
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("userList.fxml"));
    		
    		fxmlLoader.setController(this);    	
    		Parent addEmployeePane = fxmlLoader.load();
        	borderPane.setCenter(addEmployeePane);
        	initializeTableViewU();
        }


        private void initializeTableViewU() {
        	ObservableList<User> observableList;
        	observableList = FXCollections.observableArrayList(laCasaDorada.getUserAcc());
        	
    		userTableview.setItems(observableList);
    		tvUserName.setCellValueFactory(new PropertyValueFactory<User, String>("name")); //the tableview search for a method called getName
    		tvUserLastname.setCellValueFactory(new PropertyValueFactory<User, String>("lastname")); //the tableview search for a method called getEmail
    		tvUserId.setCellValueFactory(new PropertyValueFactory<User, String>("id"));
    		tvUserUser.setCellValueFactory(new PropertyValueFactory<User, String>("user"));
    		
        }
        
}

    
    

