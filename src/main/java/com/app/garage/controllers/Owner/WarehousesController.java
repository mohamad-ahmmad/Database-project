package com.app.garage.controllers.Owner;

import com.app.garage.App;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Date;
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

import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.util.converter.LongStringConverter;
import javax.swing.JOptionPane;


public class WarehousesController implements Initializable{

    @FXML
    private Pane IDPane;

@FXML
    private TableColumn<Warehouses, Long> IDCol;
    @FXML
    private TableColumn<Warehouses, String> nameCol;
    @FXML
    private TableColumn<Warehouses, String> streetCol;
    @FXML
    private TableColumn<Warehouses, String> countryCol;
    @FXML
    private TableColumn<Warehouses, String> cityCol;
    @FXML
    private TableColumn<Warehouses, Long> managerIDCol;           
    @FXML
    private TableColumn<Warehouses, Long> capacityCol;
    @FXML
    private Pane cityPane;

    @FXML
    private Pane countryPane;

    @FXML
    private FlowPane flowPane;

    @FXML
    private Pane managerPane;
    @FXML
    private Pane namePane;

    @FXML
    private Pane CapacityPane;


    @FXML
    private  AnchorPane searchFilter;

    @FXML
    private Pane streetPane;

    @FXML
    private TableView<Warehouses> tableView;
    @FXML
    private TextField enterManagerID;
    @FXML
    private TextField txtFieldCapacity;

    @FXML
    private TextField txtFieldCity;

    @FXML
    private TextField txtFieldCountry;

    @FXML
    private TextField txtFieldManagerId;

    @FXML
    private TextField txtFieldStreet;

    @FXML
    private TextField txtFieldName;
    @FXML
    private TextField txtFieldId;
    @FXML
    private AnchorPane searchPane;
    @FXML
    private void deleteWarehouse(ActionEvent e){
        Delete(tableView.getSelectionModel().getSelectedItem());
    }
    private void Delete(Warehouses w) {
     try{
     Connection con= DriverManager.getConnection(App.ip,App.user,App.password);
    Statement st = con.createStatement();
    st.executeUpdate("Delete from Warehouse Where Wid = " + w.getWID());
    tableView.refresh();
    } catch (SQLException ex) {
    Logger.getLogger(DepartmentController.class.getName()).log(Level.SEVERE, null, ex);
    }
 }
    @FXML
    void clearFilter(ActionEvent event) {
        nameField.setSelected(false);
        countryField.setSelected(false);
        cityField.setSelected(false);
        streetField.setSelected(false);
        managerField.setSelected(false);
        CapacityField.setSelected(false);
        flowPane.getChildren().removeAll(namePane,cityPane,streetPane,countryPane,managerPane,CapacityPane);
    }
    public void clearSearch() throws IOException{
        searchFilter.getChildren().clear();
   }

    Stage stage;
    private Parent root;
   @FXML
    void Done(ActionEvent event) throws IOException {
         searchFilter.setVisible(false);

    }
    
    @FXML
    void showSearchFilter(ActionEvent event) throws IOException {
        searchFilter.setVisible(true);
    }
    

    @FXML
    void cityCheck(ActionEvent event) {
     if(cityField.isSelected())
    flowPane.getChildren().add(cityPane);
    else flowPane.getChildren().remove(cityPane);
    }

    @FXML
    void countryCheck(ActionEvent event) {
    if(countryField.isSelected())
    flowPane.getChildren().add(countryPane);
    else flowPane.getChildren().remove(countryPane);
    }

    @FXML
    void managerIDCheck(ActionEvent event) {
    if(managerField.isSelected())
    flowPane.getChildren().add(managerPane);
    else flowPane.getChildren().remove(managerPane);
    }
       @FXML
    void nameCheck(ActionEvent event) {
    if(nameField.isSelected())
    flowPane.getChildren().add(namePane);
    else flowPane.getChildren().remove(namePane);
    }

    @FXML
    void opencapacityCheck(ActionEvent event) {
    if(CapacityField.isSelected())
    flowPane.getChildren().add(CapacityPane);
    else flowPane.getChildren().remove(CapacityPane);
    }

    @FXML
    void streetCheck(ActionEvent event) {
    if(streetField.isSelected())
    flowPane.getChildren().add(streetPane);
    else flowPane.getChildren().remove(streetPane);
    }
    
    @FXML
    private JFXCheckBox IDcheckField;
    @FXML
    private JFXCheckBox nameField;
    @FXML
    private JFXCheckBox countryField;
    @FXML
    private JFXCheckBox cityField;
    @FXML
    private JFXCheckBox streetField;
    @FXML
    private JFXCheckBox CapacityField;
    @FXML
    private JFXCheckBox managerField;
    @FXML
    private AnchorPane slidePane;
    
    FXMLLoader loader;
     @FXML
    void addWarehouse(ActionEvent event) throws IOException {
        add = false;
        loader = new FXMLLoader(getClass().getResource("/UI/OwnerPage/AddWarehouse.fxml"));
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
    @FXML
    private Button btnNext;
    @FXML
    private Button btnDone;
    @FXML
    void DoneAdding(ActionEvent event) throws IOException, SQLException {
        boolean done = true;
        Long ID = Long.parseLong(enterID.getText());
        Long Capacity = Long.parseLong(enterCapacity.getText());
        String Name = enterWHName.getText();
        String Country = enterCountry.getText();
        String City = enterCity.getText();
        String Street = enterStreet.getText();
         Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
         Statement stmt = con.createStatement();
         try{
         Long ManagerID = Long.parseLong(enterManagerID.getText());
         ResultSet s1=  stmt.executeQuery("Select SSN, Etype, WareID from Employee");
         while(s1.next()){
             if((s1.getLong("SSN") == Long.parseLong(enterManagerID.getText())) && (s1.getString("WareID")!=null || !s1.getString("Etype").equals("warehouse")))
             {  
                 System.out.println("test");
                 enterManagerID.setStyle("-fx-border-color:RED");
                 done = false;
                 break;
             }
         }
         if(done){
         stmt.executeUpdate("insert into Warehouse values ("+ ID + ", '" + Country + "', '" + City + "', '" + Street + "',  '" + Name + "', " + ManagerID +", "+ Capacity +")");
         stmt.executeUpdate("Update Employee set wareID = " + ID + " where SSN = " + ManagerID);
         }}
         catch(java.sql.SQLIntegrityConstraintViolationException e){
             enterManagerID.setStyle("-fx-border-color:RED");
             done = false;
         }
         catch(java.lang.NumberFormatException exc){
           enterManagerID.setStyle("-fx-border-color:RED");
           done = false;
         }
        if(done)
        {
        i=0;
        ResultSet rs = stmt.executeQuery("SELECT WID, wname, Country, City, Street, Wcapacity, ManagerID"
                 + " FROM "
                 + "warehouse");
        warehouses.clear();
        while(rs.next()) {  
            Integer id = rs.getInt("WID");
            String country = rs.getString("Country");
            String city= rs.getString("city");
            String street = rs.getString("street");
            String wname = rs.getString("wname");        
            Long mid = rs.getLong("ManagerID");
            Long capacity = rs.getLong("Wcapacity");
            warehouses.add(new Warehouses(id, wname, country, city, street, capacity, mid));
        }
        tableView.refresh();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
        
         }
    }
    @FXML
    private TextField enterCountry;
    @FXML
    private TextField enterCity;
    @FXML
    private TextField enterStreet;
    @FXML
    private TextField enterID;
    @FXML
    private TextField enterWHName;
    @FXML
    private TextField enterCapacity;
    boolean flag = true;
     @FXML
    void Next(ActionEvent event) throws IOException, SQLException {
      
        if(enterID.getText().isEmpty() && i==0)
        {
             enterID.setStyle("-fx-border-color:RED"); flag = false;
        }
        else if((enterWHName==null||enterWHName.getText().isEmpty() || enterCapacity==null || enterCapacity.getText().isEmpty()) && i==1)
        {
            if(enterWHName==null||enterWHName.getText().isEmpty() || enterCapacity==null)
            {enterWHName.setStyle("-fx-border-color:RED"); 
            enterCapacity.setStyle("");
            flag = false;}
            else
            {enterCapacity.setStyle("-fx-border-color:RED"); 
            enterWHName.setStyle("");
            flag = false;}
        }
        else if((enterCountry==null || enterCity==null || enterCity.getText().isEmpty() || enterCountry.getText().isEmpty())  && i==2)
        {
            if((enterCountry==null ||enterCountry.getText().isEmpty()))
            {enterCountry.setStyle("-fx-border-color:RED"); 
            enterCity.setStyle("");
            flag = false;}
            else
            {enterCity.setStyle("-fx-border-color:RED");
            enterCountry.setStyle("");
            flag = false;}
        }
        else if ((enterManagerID==null || enterManagerID.getText().isEmpty()) && i == 3)
        {
            enterManagerID.setStyle("-fx-border-color:RED");
            flag = false;
        }
        else
        {
        try{
        int test = Integer.parseInt(enterID.getText());
        flag = true;
        if(i==1)
        {
        Long t = Long.parseLong(enterCapacity.getText());
        enterCapacity.setStyle("");
        }
        enterID.setStyle("");
       
        
        }
        catch(Exception e){
        enterID.setStyle("-fx-border-color:RED");
        if(i==1){enterCapacity.setStyle("-fx-border-color:RED");}
        flag = false;    
        }
        }
                 if(i==0 && flag)
            {
             Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
             Statement stmt = con.createStatement(); 
             ResultSet s1 = stmt.executeQuery("Select WID from Warehouse");
                while(s1.next())
                {
                   if(Long.parseLong(enterID.getText())==s1.getLong("WID"))
                   {
                       flag=false;
                       enterID.setStyle("-fx-border-color:red");
                       break;
                   }
                }
            }
        
        if(flag)
        {
            
            if(i==2)
        {
            btnNext.setVisible(false);
            btnDone.setVisible(true);
        }
        Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
        Statement stmt = con.createStatement(); 
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
    }
    
        @FXML
     private void Cancel(ActionEvent e){
         i=0;
         if(enterCity!=null)
         enterCity.setText("");
         if(enterCountry!=null)
         enterCountry.setText("");
         if(enterStreet!=null)
         enterStreet.setText("");
         if(enterManagerID!=null)
         enterManagerID.setText("");
         if(enterWHName!=null)
         enterWHName.setText("");
         if(enterID!=null)
         enterID.setText("");
         if(enterCapacity!=null)
         enterCapacity.setText("");
         Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
         stage.close();
     }
    boolean add = true;
    
    @FXML
    private JFXButton btnDeleteWarehouse;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        tableView.setEditable(true);
        String name = "/UI/OwnerPage/EnterWHName.fxml";
        String Location = "/UI/OwnerPage/WHLocation.fxml";
        String ManagerID = "/UI/OwnerPage/WHManagerID.fxml";
        next.add(name);
        next.add(Location);
        next.add(ManagerID);
    tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    @Override
    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
        //Check whether item is selected and set value of selected item to Label
        if(tableView.getSelectionModel().getSelectedItem() != null) 
        {    
           TableViewSelectionModel selectionModel = tableView.getSelectionModel();
           ObservableList selectedCells = selectionModel.getSelectedCells();
           TablePosition tablePosition = (TablePosition) selectedCells.get(0);
           Object val = tablePosition.getTableColumn().getCellData(newValue);
           btnDeleteWarehouse.setDisable(false);
         }
         }
    });
        if(add){
        try {      
              Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
              Statement stmt = con.createStatement();
              
         ResultSet rs = stmt.executeQuery("SELECT WID, wname, Country, City, Street, Wcapacity, ManagerID"
                 + " FROM "
                 + "warehouse");
        while(rs.next()) {  
            Integer id = rs.getInt("WID");
            String country = rs.getString("Country");
            String city= rs.getString("city");
            String street = rs.getString("street");
            String wname = rs.getString("wname");        
            Long mid = rs.getLong("ManagerID");
            Long capacity = rs.getLong("Wcapacity");
            warehouses.add(new Warehouses(id, wname, country, city, street, capacity, mid));
        }
            tableView.setItems(warehouses);
             IDCol.setCellValueFactory(new PropertyValueFactory<>("WID"));
            
             nameCol.setCellValueFactory(new PropertyValueFactory<>("WName"));
             nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
             nameCol.setOnEditCommit(e->{
             Warehouses w = e.getRowValue();
             w.setWName(e.getNewValue());
             Update(w);
             });
             countryCol.setCellValueFactory(new PropertyValueFactory<>("Country"));
             countryCol.setCellFactory(TextFieldTableCell.forTableColumn());
             countryCol.setOnEditCommit(e->{
             Warehouses w = e.getRowValue();
             w.setCountry(e.getNewValue());
             Update(w);
             });             
             cityCol.setCellValueFactory(new PropertyValueFactory<>("City"));
             cityCol.setCellFactory(TextFieldTableCell.forTableColumn());
             cityCol.setOnEditCommit(e->{
             Warehouses w = e.getRowValue();
             w.setCity(e.getNewValue());
             Update(w);
             }); 
             streetCol.setCellValueFactory(new PropertyValueFactory<>("Street"));
             streetCol.setCellFactory(TextFieldTableCell.forTableColumn());
             streetCol.setOnEditCommit(e->{
             Warehouses w = e.getRowValue();
             w.setStreet(e.getNewValue());
             Update(w);
             }); 
             capacityCol.setCellValueFactory(new PropertyValueFactory<>("WCapacity"));
             capacityCol.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
             capacityCol.setOnEditCommit(e->{
             Warehouses w = e.getRowValue();
             w.setWCapacity(e.getNewValue());
             Update(w);
             }); 
             managerIDCol.setCellValueFactory(new PropertyValueFactory<>("ManagerID"));
             managerIDCol.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
             try{
             managerIDCol.setOnEditCommit(e->{
             Warehouses w = e.getRowValue();
             Long old = e.getOldValue();
             w.setManagerID(e.getNewValue());
             try{
                 Statement st = con.createStatement();
               if(e.getNewValue()==null)
               {
                 st.executeUpdate("Update employee set wareID = '' where SSN = " + old);
                 st.executeUpdate("Update warehouse set ManagerID = '' where WID = " + w.getWID());
                 st.executeUpdate("Delete from WDManager where WDSSN = " + old);
                 System.out.println("deleted");
               }
               else
               {
               ResultSet r=st.executeQuery("Select SSN,etype,depid,wareid from employee Where SSN = "+e.getNewValue());
               while(r.next())
               {
                   if((r.getString("etype").equals("warehouse") && (r.getString("Depid")==null && r.getString("wareid")==null)))
                   {
                       st.executeUpdate("Update employee set wareID = '' where SSN = " + old);
                       st.executeUpdate("Delete from WDManager where WDSSN = " + old);
                       st.executeUpdate("insert into WDManager values("+e.getNewValue()+", 'newEmail@Gmail.com', 012457847)");
                       st.executeUpdate("Update warehouse set ManagerID = "+ e.getNewValue()+ " where WID = " + w.getWID());
                       st.executeUpdate("Update employee set wareID = "+w.getWID()+" where SSN = " + e.getNewValue());
                   }
                   else
                   {
                       System.out.println("wrong id");
                   }
               }
               tableView.refresh();
               }
             }
             catch(SQLException ex){
             }
             });
             }
             catch(Exception e){
             JOptionPane.showMessageDialog(null, "Wrong manager ID");
             }
          }
        catch (SQLException ex) {
              ex.printStackTrace();
          } 
        }    
    }
    ObservableList<Warehouses> warehouses = FXCollections.observableArrayList();
    ObservableList<Warehouses> searchWh = FXCollections.observableArrayList();
    private void Connect() throws SQLException{
    Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT *"
        + " FROM Warehouse "
        +"Where WID like '%"+txtFieldId.getText()+ "%' and WName like '%"+txtFieldName.getText()+"%' and country like '%"+txtFieldCountry.getText()+"%' and city like '%"+txtFieldCity.getText()+"%' and (street like '%"+txtFieldStreet.getText()+"%' or street is null) and ManagerID like '%"+txtFieldManagerId.getText() + "%' and WCapacity like '%"+txtFieldCapacity.getText()+"%'");
            while(rs.next()) {  
            Integer id = rs.getInt("WID");
            String country = rs.getString("Country");
            String city= rs.getString("city");
            String street = rs.getString("street");
            String wname = rs.getString("wname");        
            Long mid = rs.getLong("ManagerID");
            Long capacity = rs.getLong("Wcapacity");
            searchWh.add(new Warehouses(id, wname, country, city, street, capacity, mid));
        }
    }
    @FXML
    void startSearch(ActionEvent event) throws SQLException {
        searchWh.clear();
        Connect();
        tableView.setItems(searchWh);
 }

    private void Update(Warehouses w) {
     try{
     Connection con= DriverManager.getConnection(App.ip,App.user,App.password);
    Statement st = con.createStatement();
    st.executeUpdate("Update Warehouse set Country = '"+ w.getCountry() +"', City = '"+ w.getCity()+"', Street = '" + w.getStreet()+"', Wname = '"+w.getWName()+"', managerID = "+w.getManagerID() + ", WCapacity = "+ w.getWCapacity()+" Where WID = " + w.getWID());
    tableView.refresh();
    } catch (SQLException ex) {
    JOptionPane.showMessageDialog(null, "Wrong manager ID");
    tableView.refresh();
    }
    }
}
