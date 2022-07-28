package com.app.garage.controllers.warehouseManager;
import com.app.garage.App;
import com.app.garage.controllers.Owner.DepartmentController;
import com.app.garage.controllers.Owner.Departments;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXRadioButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.util.converter.LongStringConverter;

public class SuppliersController implements Initializable{

    @FXML
    private Pane BirthDatePane;

    @FXML
    private Pane OfficeTelephonePane;

    @FXML
    private Pane GenderPane;

    @FXML
    private Pane HireDatePane;

    @FXML
    private Pane IDCardPane;
    @FXML
    private Label lblContact;
    @FXML
    private AnchorPane slidePane;
    @FXML
    private AnchorPane InfoslidePane;
    @FXML
    private Label lblInfo;
    @FXML
    private TableColumn<Supplier, Long> IDCol;

    @FXML
    private TableColumn<Supplier, Long> telephoneCol;

    @FXML
    private TableColumn<Supplier, String> emailCol;
    @FXML
    private TableColumn<Supplier, String> nameCol;
    @FXML
    private FlowPane flowPane;
    @FXML
    private FlowPane ContactFlow;
 @FXML
    private JFXCheckBox EmailField;
    @FXML
    private JFXCheckBox NameField;
    @FXML
    private AnchorPane ContactPane;
    @FXML
    private Pane InformationPane;

    @FXML
    private TextField txtfieldEmail;
    @FXML
    private TextField txtfieldID;
    @FXML
    private TextField txtfieldName;
    @FXML
    private TextField txtfieldNumber;
    @FXML
    private TableColumn<Supplier, Long> locationIDCol;
    @FXML
    private TableColumn<Supplier, String> countryCol;
    @FXML
    private TableColumn<Supplier, String> cityCol;
    @FXML
    private TableColumn<Supplier, String> streetCol;
    @FXML
    private TableColumn<Supplier, Long> costCol;

    

    @FXML
    private JFXCheckBox salaryField;

    @FXML
    private AnchorPane searchFilter;
    @FXML
    private AnchorPane searchFilterContact;
    @FXML
    private TableView<Supplier> tableView;
    @FXML
    private TableView<Supplier> locationsTable;
     @FXML
    private JFXCheckBox ShipmentField;
     @FXML
    private JFXCheckBox LocationField;
      @FXML
    private JFXCheckBox TelephoneField;
    @FXML
   void clearContactFilter(){
       LocationField.setSelected(false);
       ShipmentField.setSelected(false);
       searchFilterContact.setVisible(false);
       ContactFlow.getChildren().removeAll(ShipmentPane,LocationPane);
   }
     @FXML
    private Pane TelephoneNumberPane;
     @FXML
    private Pane EmailPane;

    
    @FXML
    private Pane NamePane;
     @FXML
    private Pane LocationPane;
     @FXML
     private Pane ShipmentPane;

    @FXML
    void LocationCheck(ActionEvent event) {
     if(((JFXCheckBox)event.getSource()).isSelected())
    ContactFlow.getChildren().add(LocationPane);
    else ContactFlow.getChildren().remove(LocationPane);
    }
     @FXML
    void ShipmentCheck(ActionEvent event) {
     if(((JFXCheckBox)event.getSource()).isSelected())
    ContactFlow.getChildren().add(ShipmentPane);
    else ContactFlow.getChildren().remove(ShipmentPane);
    }
    
    @FXML
    void NameCheck(ActionEvent event) {
     if(((JFXCheckBox)event.getSource()).isSelected())
    flowPane.getChildren().add(NamePane);
    else flowPane.getChildren().remove(NamePane);
    }
    @FXML
    void TelephoneNumberCheck(ActionEvent event) {
     if(((JFXCheckBox)event.getSource()).isSelected())
    flowPane.getChildren().add(TelephoneNumberPane);
    else flowPane.getChildren().remove(TelephoneNumberPane);
    }
    
    @FXML
    void EmailCheck(ActionEvent event) {
     if(((JFXCheckBox)event.getSource()).isSelected())
    flowPane.getChildren().add(EmailPane);
    else flowPane.getChildren().remove(EmailPane);
    }

    @FXML
    void clearFilter(ActionEvent event) {  
    flowPane.getChildren().removeAll(NamePane,EmailPane,TelephoneNumberPane);
    NameField.setSelected(false);
    TelephoneField.setSelected(false);
    EmailField.setSelected(false);
    searchFilter.setVisible(false);

    }
    @FXML
    void DoneContact(ActionEvent event) throws IOException {
         searchFilterContact.setVisible(false);
    }
   @FXML
    void Done(ActionEvent event) throws IOException {
         searchFilter.setVisible(false);
    }

    
    @FXML
    void showSearchFilter(ActionEvent event) {  
    searchFilter.setVisible(true);
    }
    
     @FXML
    void showContactFilter(ActionEvent event) throws IOException {
        searchFilterContact.setVisible(true);
    }
    @FXML
     void addInfo(ActionEvent event) throws IOException {
         initial=false;
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource("/UI/WarehouseManagerPage/AddInfo.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        Stage stage = new Stage(StageStyle.UNDECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
         
     }
    
 @FXML
    void addSupplier(ActionEvent event) throws IOException {
        initial=false;
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource("/UI/WarehouseManagerPage/AddSupplier.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        Stage stage = new Stage(StageStyle.UNDECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(root);
             stage.setScene(scene);
             stage.show();
    }
    int i=0;
    ArrayList<String> next = new ArrayList<>();
    ArrayList<String> nextInfo = new ArrayList<>();
    @FXML
    private Button btnNext;
    @FXML
    private Button deleteInfo;
    @FXML
    private Button btnDone;
    @FXML
    private Button btnNextInfo;
    @FXML
    private Button btnDoneInfo;
    @FXML
    void deleteInfo(ActionEvent event) throws IOException, SQLException {
    Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
    Statement stmt = con.createStatement(); 
    ResultSet rs =stmt.executeQuery("Delete from Supplier_Location where Country = '" +locationsTable.getSelectionModel().getSelectedItem().getCountry() +"' and City = '"+locationsTable.getSelectionModel().getSelectedItem().getCity()
    + "' and Street = '" +locationsTable.getSelectionModel().getSelectedItem().getStreet() +"' and SupplierID = " + locationsTable.getSelectionModel().getSelectedItem().getSupplierID());
    updateLocations();
    con.close();
    }
    @FXML
    void DoneAddingInfo(ActionEvent event) throws IOException, SQLException {
         boolean name = false; boolean tele = false;boolean email=false;
        Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
        Statement stmt = con.createStatement(); 
        try{
            if(!enterCost.getText().isEmpty())
        stmt.executeUpdate("insert into supplier_Location values ('" + enterSupplierInfo.getText() + "', '" + enterLocCountry.getText() +"', '" + enterLocCity.getText()+"', '"+ enterLocStreet.getText()+"', '" + enterCost.getText()+"')");
        else throw (new SQLException());
        i=0;
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
        updateLocations();
        }
        catch(SQLException ex){
        ex.printStackTrace();
        enterCost.setStyle("-fx-border-color:red");
        }
        con.close();
    }
    @FXML
    void DoneAdding(ActionEvent event) throws IOException, SQLException {
        boolean name = false; boolean tele = false;boolean email=false;
        Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
        Statement stmt = con.createStatement(); 
        try{
        ResultSet rs =stmt.executeQuery("Select Suppliername from Supplier Where Suppliername = '" + enterName.getText()+"'");
        if(rs.next() || enterName.getText().isEmpty()) {name = true; throw new SQLException(); }
        rs =stmt.executeQuery("Select telephone_number from Supplier Where telephone_number = '" + enterTelephone.getText()+"'");
        if(rs.next() || enterTelephone.getText().isEmpty()) { tele = true; throw new SQLException();}
        rs =stmt.executeQuery("Select email from Supplier Where email = '" + enterEmail.getText()+"'");
        if(rs.next() || enterEmail.getText().isEmpty() || !enterEmail.getText().contains("@gmail.com")) { email=true; throw new SQLException(); }
        stmt.executeUpdate("insert into supplier values ('" +enterID.getText() + "', '" + enterTelephone.getText() +"', '" + enterName.getText() + "', '" + enterEmail.getText() + "')");
        Update();
        i=0;
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
        }
        catch(SQLException ex){
            if(name) {enterEmail.setStyle(""); enterName.setStyle("-fx-border-color:red;"); enterTelephone.setStyle("");}
            if(tele) {enterEmail.setStyle(""); enterTelephone.setStyle("-fx-border-color:red;"); enterName.setStyle("");}
            if(email) {enterName.setStyle(""); enterEmail.setStyle("-fx-border-color:red;"); enterTelephone.setStyle("");}
        }
        con.close();
    }
    @FXML
    private TextField enterLocCity;

    @FXML
    private TextField enterLocCountry;

    @FXML
    private TextField enterLocStreet;
    @FXML
    void NextInfo(ActionEvent event) throws IOException, SQLException {
        boolean done = true;
        
      
        Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
        Statement stmt = con.createStatement(); 
        try{
          
            if(i==1){
           if (enterLocCountry.getText().isEmpty())
            {
                enterLocCountry.setStyle("-fx-border-color:red");
                enterLocCity.setStyle(""); 
                enterLocStreet.setStyle("");
                done = false;
            }
            else if (enterLocCity.getText().isEmpty())
            {
                enterLocCity.setStyle("-fx-border-color:red");
                enterLocCountry.setStyle("");
                enterLocStreet.setStyle(""); done = false;
            }
            else if (enterLocStreet.getText().isEmpty())
            {
                enterLocCity.setStyle("");
                enterLocCountry.setStyle("");
                enterLocStreet.setStyle("-fx-border-color:red"); done = false;
            }}
        ResultSet rs =stmt.executeQuery("Select SupplierID from Supplier Where SupplierID = '" + enterSupplierInfo.getText()+"'");
       if(rs.next() && !enterSupplierInfo.getText().isEmpty() && done)
       {
         if(i==1)
        {
            btnNextInfo.setVisible(false);
            btnDoneInfo.setVisible(true);
        }
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource(nextInfo.get(i)));
        loader.setController(this);
        Parent root = loader.load();
        InfoslidePane.getChildren().add(root);
        
        root.translateXProperty().set(500);
        Timeline t = new Timeline();
        t.getKeyFrames().add(new KeyFrame(Duration.seconds(0.2),
                 new KeyValue(root.translateXProperty(),0),
                new KeyValue(InfoslidePane.getChildren().get(0).translateYProperty(),200)));
        t.play();
        t.setOnFinished(e->{
        InfoslidePane.getChildren().remove(0);});
                  i++;

       
       }
        else
       {
           enterSupplierInfo.setStyle("-fx-border-color:red");
       }
       
        }
        catch(SQLException ex) {
            enterSupplierInfo.setStyle("-fx-border-color:red");
        }
        con.close();
    }
    @FXML
    void Cancel(ActionEvent event) {
    i=0;
    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    stage.close();
    }
    @FXML
    private TextField enterSupplierInfo;
    @FXML
    private TextField enterEmail;
    @FXML
    private TextField enterCost;
    @FXML
    private TextField enterName;
    @FXML
    private TextField enterTelephone;
    @FXML
    private TextField enterID;
     @FXML
    void Next(ActionEvent event) throws IOException, SQLException {
        Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
        Statement stmt = con.createStatement(); 
        try{
        ResultSet rs =stmt.executeQuery("Select SupplierID from Supplier Where SupplierID = '" + enterID.getText()+"'");
       if(!rs.next() && !enterID.getText().isEmpty())
       {
         if(i==0)
        {
            btnNext.setVisible(false);
            btnDone.setVisible(true);
        }
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource(next.get(i)));
        loader.setController(this);
        Parent root = loader.load();
        
        slidePane.getChildren().add(root);
        
        root.translateXProperty().set(500);
        Timeline t = new Timeline();
        t.getKeyFrames().add(new KeyFrame(Duration.seconds(0.2),
                 new KeyValue(root.translateXProperty(),0),
                new KeyValue(slidePane.getChildren().get(0).translateYProperty(),200)));
        t.play();
        t.setOnFinished(e->{
        slidePane.getChildren().remove(0);});
         i++;
       }
       else
       {
           enterID.setStyle("-fx-border-color:red");
       }
        }
        catch(SQLException ex) {
            enterID.setStyle("-fx-border-color:red");
        }
        con.close();
    }
    ObservableList<Supplier> suppliers = FXCollections.observableArrayList();
    ObservableList<Supplier> suppliersSearch = FXCollections.observableArrayList();
    ObservableList<Supplier> locationsSearch = FXCollections.observableArrayList();
    ObservableList<Supplier> Locations = FXCollections.observableArrayList();
    boolean initial = true;
     @FXML
    private JFXButton deleteSupplier;
    @FXML
    private TextField txtfieldLcationID;
    @FXML
    private TextField txtfieldLocation;
    @FXML
    private TextField txtfieldCost;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(initial)
        {
            locationsTable.setEditable(true);
            tableView.setEditable(true);
     locationsTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    @Override
    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
        //Check whether item is selected and set value of selected item to Label
        if(locationsTable.getSelectionModel().getSelectedItem() != null) 
        {    
           deleteInfo.setDisable(false);
        }
    }
    });
    tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    @Override
    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
        //Check whether item is selected and set value of selected item to Label
        if(tableView.getSelectionModel().getSelectedItem() != null) 
        {    
           deleteSupplier.setDisable(false);
         }
         }
    });
        String ShipmentCost = "/UI/WarehouseManagerPage/EnterShipmentCost.fxml";
        String Location = "/UI/WarehouseManagerPage/Location.fxml";
        String name = "/UI/WarehouseManagerPage/EnterName.fxml";
        next.add(name);
        nextInfo.add(Location);
        nextInfo.add(ShipmentCost);
        IDCol.setCellValueFactory(new PropertyValueFactory<>("supplierID"));
        IDCol.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
        IDCol.setOnEditCommit(e->{
            Refresh(tableView.getSelectionModel().getSelectedItem());
        });
        nameCol.setCellValueFactory(new PropertyValueFactory<>("supplierName"));
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setOnEditCommit(e->{
        Supplier s = e.getRowValue();
        s.setSupplierName(e.getNewValue());
        Refresh(s);
        });
        emailCol.setCellValueFactory(new PropertyValueFactory<>("emailAddress"));
        emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
        emailCol.setOnEditCommit(e->{
        Supplier s = e.getRowValue();
        s.setEmailAddress(e.getNewValue());
        Refresh(s);
        });
        telephoneCol.setCellValueFactory(new PropertyValueFactory<>("telephoneNumber"));
        telephoneCol.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
        telephoneCol.setOnEditCommit(e->{
        Supplier s = e.getRowValue();
        s.setTelephoneNumber(e.getNewValue());
        Refresh(s);
        });
        locationIDCol.setCellValueFactory(new PropertyValueFactory<>("supplierID"));
        countryCol.setCellValueFactory(new PropertyValueFactory<>("country"));
        countryCol.setCellFactory(TextFieldTableCell.forTableColumn());
        countryCol.setOnEditCommit(e->{
        Supplier s = e.getRowValue();
        s.setCountry(e.getNewValue());
        try {
        Connection con= DriverManager.getConnection(App.ip,App.user,App.password);
        Statement st;
        st = con.createStatement();
        st.executeUpdate("Update Supplier_location set Country = '"+ s.getCountry() +"', City = '"+ s.getCity()+"', Street = '" + s.getStreet()+"', shipment_cost = '"+s.getCost()+"' Where shipment_cost = '" +s.getCost()+ "' and City like '"+s.getCity() +"' and Street like '"+s.getStreet()+"'and supplierID = " + s.getSupplierID());
        tableView.refresh();
        con.close();
        } catch (SQLException ex) {
        System.out.println("Invalid value");
       }
   
        });
        cityCol.setCellValueFactory(new PropertyValueFactory<>("City"));
        cityCol.setCellFactory(TextFieldTableCell.forTableColumn());
        cityCol.setOnEditCommit(e->{
        Supplier s = e.getRowValue();
        s.setCity(e.getNewValue());
        try {
        Connection con= DriverManager.getConnection(App.ip,App.user,App.password);
        Statement st;
        st = con.createStatement();
        st.executeUpdate("Update Supplier_location set Country = '"+ s.getCountry() +"', City = '"+ s.getCity()+"', Street = '" + s.getStreet()+"', shipment_cost = '"+s.getCost()+"' Where Country = '" +s.getCountry() + "' and shipment_Cost like '"+s.getCost()+"' and Street like '"+s.getStreet()+"'and supplierID = " + s.getSupplierID());
        tableView.refresh();
        con.close();
        } catch (SQLException ex) {
       System.out.println("Invalid value");
       }
   
        });
        streetCol.setCellValueFactory(new PropertyValueFactory<>("Street"));
        streetCol.setCellFactory(TextFieldTableCell.forTableColumn());
        streetCol.setOnEditCommit(e->{
        Supplier s = e.getRowValue();
        s.setStreet(e.getNewValue());
        try {
        Connection con= DriverManager.getConnection(App.ip,App.user,App.password);
        Statement st;
        st = con.createStatement();
        st.executeUpdate("Update Supplier_location set Country = '"+ s.getCountry() +"', City = '"+ s.getCity()+"', Street = '" + s.getStreet()+"', shipment_cost = '"+s.getCost()+"' Where Country = '" +s.getCountry() + "' and City like '"+s.getCity() +"' and shipment_cost like '"+s.getCost()+"'and supplierID = " + s.getSupplierID());
        tableView.refresh();
        con.close();
        } catch (SQLException ex) {
       System.out.println("Invalid value");
       }
   
        });
        costCol.setCellValueFactory(new PropertyValueFactory<>("Cost"));
        costCol.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
        costCol.setOnEditCommit(e->{
        Supplier s = e.getRowValue();
        s.setCost(e.getNewValue());
        
        try {
        Connection con= DriverManager.getConnection(App.ip,App.user,App.password);
        Statement st;
        st = con.createStatement();
        st.executeUpdate("Update Supplier_location set Country = '"+ s.getCountry() +"', City = '"+ s.getCity()+"', Street = '" + s.getStreet()+"', shipment_cost = '"+s.getCost()+"' Where Country = '" +s.getCountry() + "' and City like '"+s.getCity() +"' and Street like '"+s.getStreet()+"'and supplierID = " + s.getSupplierID());
        tableView.refresh();
        con.close();
        } catch (SQLException ex) {
            System.out.println("Invalid value");
       }
   
    

        });
        try {   
            Update();
            updateLocations();
        } catch (SQLException ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    public void Refresh(Supplier s){
    try{
    Connection con= DriverManager.getConnection(App.ip,App.user,App.password);
    Statement st = con.createStatement();
    st.executeUpdate("Update Supplier set SupplierName = '"+ s.getSupplierName()+"', Email = '"+ s.getEmailAddress()+"', telephone_number = '" + s.getTelephoneNumber()+"' Where supplierID = " + s.getSupplierID());
    
    tableView.refresh();
    con.close();
    } catch (SQLException ex) {
    Logger.getLogger(DepartmentController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    public void updateLocations() throws SQLException {
        Locations.clear();
        Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
        Statement stmt = con.createStatement(); 
        ResultSet rs =stmt.executeQuery("Select * from Supplier_Location");
        while(rs.next()){
        Locations.add(new Supplier(rs.getLong("SupplierID"),rs.getString("Country"),rs.getString("City"),rs.getString("Street"),rs.getLong("Shipment_Cost")));
       }
        locationsTable.setItems(Locations);
    }
        public void Update() throws SQLException{
            suppliers.clear();
            Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
            Statement stmt = con.createStatement(); 
            ResultSet rs =stmt.executeQuery("Select * from Supplier");
            while(rs.next()){
                suppliers.add(new Supplier(rs.getLong("SupplierID"),rs.getLong("Telephone_number"),rs.getString("SupplierName"),rs.getString("email")));
            }
            tableView.setItems(suppliers);
            con.close();
        }
    @FXML
    private void deleteSupplier(ActionEvent e) throws SQLException{
    Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
    Statement stmt = con.createStatement(); 
     ResultSet rs =stmt.executeQuery("Delete from Supplier where SupplierID = " + tableView.getSelectionModel().getSelectedItem().getSupplierID());
     Update();
     con.close();
    }
    @FXML
    private void startSearchLocations(ActionEvent e) throws SQLException{
        locationsSearch.clear();
         Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
         Statement stmt = con.createStatement(); 
         ResultSet rs =stmt.executeQuery("Select * from Supplier_Location where "
                 + "(country like '%" + txtfieldLocation.getText() +"%' or "
                 + "city like '%" + txtfieldLocation.getText() +"%' or "
                 + "street like '%" + txtfieldLocation.getText() + "%') and "
                 + "supplierID like '%" + txtfieldLcationID.getText() +"%' and "
                 + "shipment_cost like '%" + txtfieldCost.getText() + "%'");
         while(rs.next()){
             locationsSearch.add(new Supplier(rs.getLong("SupplierID"),rs.getString("country"),rs.getString("city"),rs.getString("street"),rs.getLong("shipment_cost")));
         }
         con.close();
         locationsTable.setItems(locationsSearch);
    }
    
    @FXML
    private void startSearch(ActionEvent e) throws SQLException{
         suppliersSearch.clear();
         Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
         Statement stmt = con.createStatement(); 
         ResultSet rs =stmt.executeQuery("Select * from Supplier where "
                 + "SupplierID like '%" + txtfieldID.getText() +"%' and "
                 + "Telephone_Number like '%" + txtfieldNumber.getText() +"%' and "
                 + "Suppliername like '%" + txtfieldName.getText() + "%' and "
                 + "Email like '%" + txtfieldEmail.getText() +"%'");
         while(rs.next()){
             suppliersSearch.add(new Supplier(rs.getLong("SupplierID"),rs.getLong("Telephone_number"),rs.getString("SupplierName"),rs.getString("email")));
         }
         con.close();
         tableView.setItems(suppliersSearch);
    }
     
    
    boolean InfoSelected = false;
    boolean SupplierSelected = false;
        @FXML
    void openContactPane(MouseEvent event) {
       
        if(!SupplierSelected){
        SupplierSelected=true;
        lblContact.setStyle("-fx-text-fill: #F8A918");
        lblInfo.setStyle("-fx-text-fill: #aeaeae");
        ContactPane.translateXProperty().set(850);
        ContactPane.setVisible(true);
        Timeline t = new Timeline();
        t.getKeyFrames().add(new KeyFrame(Duration.seconds(0.3),
        new KeyValue(ContactPane.translateXProperty(),0),
        new KeyValue(InformationPane.translateXProperty(),-850)));
        t.play();
         t.setOnFinished(e->{
        SupplierSelected=true;
        InfoSelected=false;});
        }
    }
        @FXML
    void openInformationPane(MouseEvent event) {
        if(!InfoSelected)
        {
        InfoSelected=true;
        lblInfo.setStyle("-fx-text-fill: #F8A918");
        lblContact.setStyle("-fx-text-fill: #aeaeae");
        Timeline t = new Timeline();
        t.getKeyFrames().add(new KeyFrame(Duration.seconds(0.3),
        new KeyValue(InformationPane.translateXProperty(),0),
        new KeyValue(ContactPane.translateXProperty(),850)));
        t.play();
        t.setOnFinished(e->{
        InfoSelected=true;
        SupplierSelected=false;});
        }
    }

}
