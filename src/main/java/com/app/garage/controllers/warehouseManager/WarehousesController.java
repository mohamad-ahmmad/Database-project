package com.app.garage.controllers.warehouseManager;
import com.app.garage.App;
import com.app.garage.controllers.Owner.Departments;
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

public class WarehousesController implements Initializable{
    @FXML
    private TableColumn<Warehouse, Long> IDCol;

    @FXML
    private TableColumn<Warehouse, String> countryCol;

    @FXML
    private TableColumn<Warehouse, String> cityCol;
    @FXML
    private TableColumn<Warehouse, String> streetCol;
    @FXML
    private TableColumn<Warehouse, Long> capacityCol;
    @FXML
    private FlowPane flowPane;
    @FXML
    private JFXCheckBox LocationField;
    @FXML
    private JFXCheckBox managerIDField;
    @FXML
    private JFXCheckBox NameField;
    @FXML
    private JFXCheckBox CapacityField;



    @FXML
    private TableColumn<Warehouse, String> nameCol;
@FXML
    private TableColumn<Warehouse, String> managerIDCol;

    @FXML
    private JFXCheckBox salaryField;

    @FXML
    private AnchorPane searchFilter;
    @FXML
    private AnchorPane searchFilterContact;
    @FXML
    private TableView<Warehouse> tableView;

    @FXML
    private Pane LocationPane;
    @FXML
    private Pane NamePane;
    @FXML
    private Pane managerIDPane;
    @FXML
    private Pane CapacityPane;
    @FXML
    void ManagerIDCheck(ActionEvent event) {
    if(((JFXCheckBox)event.getSource()).isSelected())
    flowPane.getChildren().add(managerIDPane);
    else flowPane.getChildren().remove(managerIDPane);
    }
    @FXML
    void CapacityCheck(ActionEvent event) {
     if(((JFXCheckBox)event.getSource()).isSelected())
    flowPane.getChildren().add(CapacityPane);
    else flowPane.getChildren().remove(CapacityPane);
    }
     @FXML
    void NameCheck(ActionEvent event) {
     if(((JFXCheckBox)event.getSource()).isSelected())
    flowPane.getChildren().add(NamePane);
    else flowPane.getChildren().remove(NamePane);
    }
    
    @FXML
    void LocationCheck(ActionEvent event) {
     if(((JFXCheckBox)event.getSource()).isSelected())
    flowPane.getChildren().add(LocationPane);
    else flowPane.getChildren().remove(LocationPane);
    }
    @FXML
    void clearFilter(ActionEvent event) {  
    flowPane.getChildren().removeAll(NamePane,LocationPane,CapacityPane);
    NameField.setSelected(false);
    CapacityField.setSelected(false);
    LocationField.setSelected(false);
    searchFilter.setVisible(false);
    managerIDField.setSelected(false);
    txtfieldCapacity.setText("");
    txtfieldID.setText("");
    txtfieldName.setText("");
    txtfieldLocation.setText("");
    txtfieldManagerID.setText("");
    tableView.setItems(Warehouses);
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
    private TextField txtfieldCapacity;
@FXML
    private TextField txtfieldManagerID;
    @FXML
    private TextField txtfieldID;

    @FXML
    private TextField txtfieldLocation;

    @FXML
    private TextField txtfieldName;
    @FXML
    void showSearchFilter(ActionEvent event) {  
    searchFilter.setVisible(true);
    }
    ObservableList<Warehouse> Warehouses = FXCollections.observableArrayList();
    ObservableList<Warehouse> warehousesSearch = FXCollections.observableArrayList();
    boolean initial=true;
    @FXML
    public void startSearch(ActionEvent e) throws SQLException{
        warehousesSearch.clear();
    Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * from Warehouse Where WID like '%" + txtfieldID.getText() + "%' and "
            + "Wname like '%" + txtfieldName.getText() + "%' and "
            + "(country like '%" + txtfieldLocation.getText()+"%' or city like '%" + txtfieldLocation.getText()+ "%' or street like '%" + txtfieldLocation.getText()+"%') and "
            + "Wcapacity like '%" + txtfieldCapacity.getText()+"%' and ManagerID like '%"+ txtfieldManagerID.getText() + "%'");
        while(rs.next()){
            warehousesSearch.add(new Warehouse(rs.getLong("WID"), rs.getLong("WCapacity"), rs.getString("WName"), rs.getString("Country"), rs.getString("City"), rs.getString("Street"),rs.getLong("managerID")));  
        }
        tableView.setItems(warehousesSearch);
    }
    @FXML
    private Button contactManager;
    @FXML
    private TextField emailTXT;

    @FXML
    private TextField nameTXT;

    @FXML
    private TextField officeTXT;
    @FXML
     void Close(ActionEvent e) throws IOException, SQLException {
         Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
         stage.close();
     }
    @FXML
     void contactManager(ActionEvent e) throws IOException, SQLException {
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource("/UI/WarehouseManagerPage/ContactManager.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        Stage stage = new Stage(StageStyle.UNDECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("Select * from WDManager where WDSSN = " + tableView.getSelectionModel().getSelectedItem().getManagerID());
        rs.next();
        emailTXT.setText(rs.getString("email"));
        officeTXT.setText(rs.getString("telephonenumber"));
        rs = stmt.executeQuery("Select firstname,middlename, lastname from employee where SSN = " + tableView.getSelectionModel().getSelectedItem().getManagerID());
        rs.next();
        nameTXT.setText(rs.getString("firstname") + " " + rs.getString("middlename")+ " " + rs.getString("lastname"));
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(initial)
        {
            tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    @Override
    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
        //Check whether item is selected and set value of selected item to Label
        if(tableView.getSelectionModel().getSelectedItem() != null) 
        {    
           contactManager.setDisable(false);
         }
         }
    });
            try{
              Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
              Statement stmt = con.createStatement();
              ResultSet rs = stmt.executeQuery("SELECT * from Warehouse");
              while(rs.next()){
                  Warehouses.add(new Warehouse(rs.getLong("WID"), rs.getLong("WCapacity"), rs.getString("WName"), rs.getString("Country"), rs.getString("City"), rs.getString("Street"),rs.getLong("managerID")));
              }
              tableView.setItems(Warehouses);
              IDCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
              nameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
              managerIDCol.setCellValueFactory(new PropertyValueFactory<>("managerID"));
              countryCol.setCellValueFactory(new PropertyValueFactory<>("country"));
              cityCol.setCellValueFactory(new PropertyValueFactory<>("city"));
              streetCol.setCellValueFactory(new PropertyValueFactory<>("street"));
              capacityCol.setCellValueFactory(new PropertyValueFactory<>("Capacity"));
            }
            catch(SQLException ex){
                
            }
        }

    }

}
