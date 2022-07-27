package com.app.garage.controllers.warehouseManager;

import com.app.garage.App;
import com.jfoenix.controls.JFXCheckBox;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class ShipmentsController implements Initializable{

    @FXML
    private JFXCheckBox CostField;

    @FXML
    private Pane CostPane;

    @FXML
    private JFXCheckBox DateField;

    @FXML
    private Pane DatePane;

    @FXML
    private Pane IDPane;

    @FXML
    private TableColumn<?, ?> SSNCol;

    @FXML
    private JFXCheckBox SupplierField;

    @FXML
    private Pane SupplierPane;

    @FXML
    private TableColumn<?, ?> addressCol;

    @FXML
    private TableColumn<?, ?> addressCol1;

    @FXML
    private FlowPane flowPane;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private AnchorPane searchFilter;

    @FXML
    private TableView<Shipments> tableView;

    @FXML
    void clearFilter(ActionEvent event) {
    tableView.setItems(shipments);
    txtfieldDate.setText("");
    txtfieldSupplierID.setText("");
          
    }
    @FXML
    private TextField txtfieldDate;

    @FXML
    private TextField txtfieldSN;
    @FXML
    private TableColumn<?, ?> shipmentCostcol;

    @FXML
    private TableColumn<?, ?> shipmentDateCol;

    @FXML
    private TableColumn<?, ?> supplierIDCol;

    @FXML
    private TextField txtfieldShipmentCost;
    
    @FXML
    private TextField txtfieldSupplierID;
    @FXML
    void startSearch(ActionEvent e) {
         Long counter=1L;
        shipmentsSearch.clear();
         try {
            Connection con = DriverManager.getConnection(App.ip, App.user, App.password);
            Statement st = con.createStatement();
            Statement st2 = con.createStatement();
            ResultSet result = st.executeQuery("Select buyhistory,SupplierID from dress where buyhistory like '%" + txtfieldDate.getText()+"%' and supplierID like '%" +txtfieldSupplierID.getText()+"%' group by supplierID,buyhistory ");
            while(result.next()){
                ResultSet cost = st2.executeQuery("Select shipment_Cost from supplier_Location where supplierID = " +result.getLong("SupplierID"));
                cost.next();
                shipmentsSearch.add(new Shipments(counter++, result.getLong("SupplierID"), cost.getLong("shipment_Cost"), result.getString("buyhistory").substring(0,10)));
            }
            tableView.setItems(shipmentsSearch);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ShipmentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    ObservableList<Shipments> shipments = FXCollections.observableArrayList();
    ObservableList<Shipments> shipmentsSearch = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Long counter=1L;
        try {
            Connection con = DriverManager.getConnection(App.ip, App.user, App.password);
            Statement st = con.createStatement();
            Statement st2 = con.createStatement();
            ResultSet result = st.executeQuery("Select buyhistory,SupplierID from dress group by supplierID,buyhistory");
            
            while(result.next()){
                ResultSet cost = st2.executeQuery("Select shipment_Cost from supplier_Location where supplierID = " +result.getLong("SupplierID"));
                cost.next();
                shipments.add(new Shipments(counter++, result.getLong("SupplierID"), cost.getLong("shipment_Cost"), result.getString("buyhistory").substring(0,10)));
            }
            tableView.setItems(shipments);
            SSNCol.setCellValueFactory(new PropertyValueFactory<>("SN"));
            supplierIDCol.setCellValueFactory(new PropertyValueFactory<>("supplierID"));
            shipmentDateCol.setCellValueFactory(new PropertyValueFactory<>("shipmentDate"));
            shipmentCostcol.setCellValueFactory(new PropertyValueFactory<>("shipmentCost"));
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ShipmentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
