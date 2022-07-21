package com.app.garage.controllers.Owner;

import com.app.garage.App;
import com.jfoenix.controls.JFXCheckBox;
import io.github.palexdev.materialfx.dialogs.MFXDialogs;
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
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;

import javafx.scene.control.Button;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javax.swing.JOptionPane;


public class DepartmentController implements Initializable{
    @FXML
    private TextField EnterCountry;
    @FXML
    private TextField EnterCity;
    @FXML
    private TextField EnterStreet;
    @FXML
    private TextField EnterID;
    @FXML
    private TextField EnterName;
    @FXML
    private TextField EnterManagerID;

    @FXML
    private Pane IDPane;
    
    @FXML
    private TextField txtfieldID;
        @FXML
    private TextField txtfieldName;
                @FXML
    private TextField txtFieldCountry;
    @FXML
    private TextField txtFieldCity;
    @FXML
    private TextField txtFieldStreet;
    @FXML
    private TextField txtFieldManagerId;
    @FXML
    private TextField txtFieldOpeningDate;

    @FXML
    private TableColumn<Departments, Integer> IDCol;
    @FXML
    private TableColumn<Departments, String> nameCol;
    @FXML
    private TableColumn<Departments, String> streetCol;
    @FXML
    private TableColumn<Departments, String> countryCol;
    @FXML
    private TableColumn<Departments, String> cityCol;
    @FXML
    private TableColumn<Departments, Integer> managerIDCol;
                    
    @FXML
    private TableColumn<?, Date> openingDateCol;

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
    private Pane openingPane;


    @FXML
    private  AnchorPane searchFilter;

    @FXML
    private Pane streetPane;

    @FXML
    private TableView<Departments> tableView;
    
    
    
    @FXML
    private AnchorPane searchPane;
    @FXML
    void clearFilter(ActionEvent event) {
        nameField.setSelected(false);
        countryField.setSelected(false);
        cityField.setSelected(false);
        streetField.setSelected(false);
        managerField.setSelected(false);
        odField.setSelected(false);
        txtfieldID.setText("");
        txtfieldName.setText("");
        txtFieldCountry.setText("");
        txtFieldCity.setText("");
        txtFieldStreet.setText("");
        txtFieldManagerId.setText("");
        txtFieldOpeningDate.setText("");
        tableView.setItems(deps);
        flowPane.getChildren().removeAll(namePane,cityPane,streetPane,countryPane,managerPane,openingPane);
        tableView.setItems(deps);
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
    void opendateCheck(ActionEvent event) {
    if(odField.isSelected())
    flowPane.getChildren().add(openingPane);
    else flowPane.getChildren().remove(openingPane);
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
    private JFXCheckBox odField;
    @FXML
    private JFXCheckBox managerField;
    @FXML
    private AnchorPane slidePane;
    
    FXMLLoader loader;
    Long ID,ManagerID;
    String Country,City,Street,Name; 
    @FXML
    void addDepartment(ActionEvent event) throws IOException {
        add=false;//////bolean to stop adding every time stage is open
        loader = new FXMLLoader(getClass().getResource("/UI/OwnerPage/AddDepartment.fxml"));
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
        boolean found = false;//////to know if manager id on the new dep already has a dep
        boolean f = true;
        boolean canAdd = false;
        boolean Continue = true;
        if ((EnterManagerID==null||EnterManagerID.getText().isEmpty()) && i==3)
        {
            EnterManagerID.setStyle("-fx-border-color:RED");
        }
        else
        {
        try{
        Long test = Long.parseLong(EnterManagerID.getText());
        EnterManagerID.setStyle("");
        f= true;
        }
         catch(Exception e){
             System.out.println("test");
             EnterManagerID.setStyle("-fx-border-color:RED");
             f=false;
        }
        if(f)
        {
        ID=Long.parseLong(EnterID.getText());
        Name=EnterName.getText();
        Country=EnterCountry.getText();
        City=EnterCity.getText();
        Street = EnterStreet.getText();
        ManagerID=Long.parseLong(EnterManagerID.getText());
         Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
         Statement stmt = con.createStatement();
         ResultSet s1= stmt.executeQuery("Select SSN, Depid from employee");
         while (s1.next()){
             if (ManagerID!=s1.getLong("SSN"))
             {
                 found = true;
             }
             if(ManagerID == s1.getLong("SSN") && s1.getString("Depid")==null)
             {
                 canAdd=true;
                 break;
             }
         }
         if(found){
         EnterManagerID.setStyle("-fx-border-color:RED"); 
         Continue = false;
         }
         else
         {
         if(canAdd)
         {
             stmt.executeUpdate("insert into Department values (" + ID + ", '" + Country + "', '" + City + "', '" + Street + "',  '" + Name + "', " + ManagerID+", TO_DATE('0003-03-03', 'YYYY-MM-DD'))" );
             stmt.executeUpdate("Update Employee Set Depid = " + ID +" where SSN = " + ManagerID);
             i=0;
         }
         else
         {
         EnterManagerID.setStyle("-fx-border-color:RED"); 
         }
         }      
         if(Continue)
         {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
        deps.clear();
         try {      
         ResultSet rs = stmt.executeQuery("SELECT DID, Dname, Country, City, Street, OpeningDate, ManagerID"
                 + " FROM Department");
        while(rs.next()) {  
            Integer id = rs.getInt("DID");
            String country = rs.getString("Country");
            String city= rs.getString("city");
            String street = rs.getString("street");
            String dname = rs.getString("Dname");        
            Long mid = rs.getLong("ManagerID");
            String date = rs.getString("OpeningDate");
            date=date.replaceAll("-", "/");
            String[] d = date.split(" ");
            System.out.println(d[0]);
            deps.add(new Departments(id, dname, country, city, street, d[0], mid));
        }
            tableView.setItems(deps);
             IDCol.setCellValueFactory(new PropertyValueFactory<>("DID"));
             nameCol.setCellValueFactory(new PropertyValueFactory<>("DName"));
             countryCol.setCellValueFactory(new PropertyValueFactory<>("Country"));
             cityCol.setCellValueFactory(new PropertyValueFactory<>("City"));
             streetCol.setCellValueFactory(new PropertyValueFactory<>("Street"));
             openingDateCol.setCellValueFactory(new PropertyValueFactory<>("OpeningDate"));
             managerIDCol.setCellValueFactory(new PropertyValueFactory<>("ManagerID"));
          }
        catch (SQLException ex) {
              ex.printStackTrace();
          } 
         }
        }
    }   
    }
    @FXML
     private void Cancel(ActionEvent e){
         i=0;
         if(EnterCity!=null)
         EnterCity.setText("");
         if(EnterCountry!=null)
         EnterCountry.setText("");
         if(EnterStreet!=null)
         EnterStreet.setText("");
         if(EnterManagerID!=null)
         EnterManagerID.setText("");
         if(EnterName!=null)
         EnterName.setText("");
         if(EnterID!=null)
         EnterID.setText("");
         Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
         stage.close();
     }
    boolean add=true;
    boolean flag = true;
     @FXML
    void Next(ActionEvent event) throws IOException, SQLException {
        boolean exists=false;
        
        if(EnterID.getText().isEmpty() && i==0)
        {
             EnterID.setStyle("-fx-border-color:RED");
        }
        else if((EnterName==null||EnterName.getText().isEmpty()) && i==1)
        {
            EnterName.setStyle("-fx-border-color:RED");
        }
        else if((EnterCountry==null || EnterCity==null || EnterCountry.getText().isEmpty() || EnterCity.getText().isEmpty())  && i==2)
        {
            if((EnterCountry==null ||EnterCountry.getText().isEmpty()))
            EnterCountry.setStyle("-fx-border-color:RED");
            else
            EnterCity.setStyle("-fx-border-color:RED");  
        }
        else
        {
        try{
        int test = Integer.parseInt(EnterID.getText());
        EnterID.setStyle("");
        flag=true;
        }
         catch(Exception e){
             EnterID.setStyle("-fx-border-color:RED");
             flag = false;    
        }
        if(i==2)
        {
            btnNext.setVisible(false);
            btnDone.setVisible(true);
        }
        if(flag){
            Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
              Statement stmt = con.createStatement();
              
         ResultSet rs = stmt.executeQuery("Select SSN, Depid from Employee");
         while(rs.next()){
             if(Long.parseLong(EnterID.getText())==rs.getLong("Depid"))
             {
                 exists=true;
                 break;
             }
         }
         if(exists)
         EnterID.setStyle("-fx-border-color:RED");
             else
         {
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
        }
    }
    ObservableList<Departments> deps = FXCollections.observableArrayList();
    ObservableList<Departments> searchDeps = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        String name = "/UI/OwnerPage/EnterName.fxml";
        String Location = "/UI/OwnerPage/Location.fxml";
        String ManagerID = "/UI/OwnerPage/ManagerID.fxml";
        next.add(name);
        next.add(Location);
        next.add(ManagerID);
        
        if(add)
        {
         try {      
              Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
              Statement stmt = con.createStatement();
              
         ResultSet rs = stmt.executeQuery("SELECT DID, Dname, Country, City, Street, OpeningDate, ManagerID"
                 + " FROM Department");
        while(rs.next()) {  
            Integer id = rs.getInt("DID");
            String country = rs.getString("Country");
            String city= rs.getString("city");
            String street = rs.getString("street");
            String dname = rs.getString("Dname");        
            Long mid = rs.getLong("ManagerID");
            String date = rs.getString("OpeningDate");
            date=date.replaceAll("-", "/");
            String[] d = date.split(" ");
            System.out.println(d[0]);
            deps.add(new Departments(id, dname, country, city, street, d[0], mid));
        }
        
        
            tableView.setItems(deps);
             IDCol.setCellValueFactory(new PropertyValueFactory<>("DID"));
             nameCol.setCellValueFactory(new PropertyValueFactory<>("DName"));
             countryCol.setCellValueFactory(new PropertyValueFactory<>("Country"));
             cityCol.setCellValueFactory(new PropertyValueFactory<>("City"));
             streetCol.setCellValueFactory(new PropertyValueFactory<>("Street"));
             openingDateCol.setCellValueFactory(new PropertyValueFactory<>("OpeningDate"));
             managerIDCol.setCellValueFactory(new PropertyValueFactory<>("ManagerID"));
          }
         
        catch (SQLException ex) {
              ex.printStackTrace();
          } 
        }

    }
    
        @FXML
    void startSearch(ActionEvent event) throws SQLException {
        String ID="";
        String Name="";
        String cond1="";
      
        searchDeps.clear();
        boolean found = false;
        boolean searchFields[]={true,true,true,true,true,true,true};
        boolean searchFields2[]={true,true,true,true,true,true,true};
        

        Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT *"
        + " FROM Department "
        +"Where DID like '%"+txtfieldID.getText()+ "%' and dname like '%"+txtfieldName.getText()+"%' and country like '%"+txtFieldCountry.getText()+"%' and city like '%"+txtFieldCity.getText()+"%' and street like '%"+txtFieldStreet.getText()+"%' and ManagerID like '%"+txtFieldManagerId.getText() + "%' and OpeningDate like '%"+txtFieldOpeningDate.getText()+"%'");
        
        
             while(rs.next()) {  
            Integer id = rs.getInt("DID");
            String country = rs.getString("Country");
            String city= rs.getString("city");
            String street = rs.getString("street");
            String dname = rs.getString("Dname");        
            Long mid = rs.getLong("ManagerID");
            String date = rs.getString("OpeningDate");
            date=date.replaceAll("-", "/");
            String[] d = date.split(" ");
            System.out.println(d[0]);
            searchDeps.add(new Departments(id, dname, country, city, street, d[0], mid));
        }
         tableView.setItems(searchDeps);     
    }

}
