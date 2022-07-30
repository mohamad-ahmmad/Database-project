/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.derpartmentmanager;

import com.app.garage.App;
import com.jfoenix.controls.JFXCheckBox;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.util.converter.LongStringConverter;

/**
 *
 * @author USER-M
 */
public class WarehousesController implements Initializable {
    private Connection con;
    private void searchAll(){
        data.clear();
        try {
            
            con = DriverManager.getConnection(App.ip, App.user, App.password);
            Statement st = con.createStatement();
            
            ResultSet rs=  st.executeQuery(" select d.DRESSID, d.DRESSNAME, d.DRESSCOLOR, d.BRANDNAME, d.DRESSSIZE, wd.WAREHOUSE_STOCK, wd.WID, d.WSPRICE, d.PRICE from DRESS d join WAREHOUSE_DRESS wd on d.DRESSID = wd.DRESSID ");
            
            while(rs.next()){
                long dId = rs.getLong(1);
                String dressName = rs.getString(2);
                String dressColor = rs.getString(3);
                String dressBrand = rs.getString(4);
                String dressSize = rs.getString(5);
                int wStock = rs.getInt(6);
                int wId = rs.getInt(7);
                int wPrice = rs.getInt(8);
                int price = rs.getInt(9);
                
                data.add(new Warehouse (dId, dressName, dressSize, dressColor, dressBrand, wStock, wId, wPrice, price));
            }
          
            
            tableView.setItems(data);
            con.close();
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        
        
    }
    private ObservableList<Warehouse> data = FXCollections.observableArrayList();
        @Override
    public void initialize(URL url, ResourceBundle rb) {
          tableId.setCellValueFactory(new PropertyValueFactory<>("dressId"));
            tableName.setCellValueFactory(new PropertyValueFactory<>("name"));
            tableColor.setCellValueFactory(new PropertyValueFactory<>("color"));
            tableSize.setCellValueFactory(new PropertyValueFactory<>("size"));
            tableBrand.setCellValueFactory(new PropertyValueFactory<>("brandName"));
            tableStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
            tableWareId.setCellValueFactory(new PropertyValueFactory<>("warehouseId"));
            tableWPrice.setCellValueFactory(new PropertyValueFactory<>("wprice"));
            tablePrice.setCellValueFactory(new PropertyValueFactory<>("price"));
            
        searchAll();
        tableView.setEditable(true);
        tableId.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
        tableId.setOnEditCommit(e->{tableView.refresh();});
        
    }
    
        @FXML
    private TableColumn<Warehouse, String> tableBrand;

    @FXML
    private TableColumn<Warehouse, String> tableColor;

    @FXML
    private TableColumn<Warehouse, Long> tableId;

    @FXML
    private TableColumn<Warehouse, String> tableName;

    @FXML
    private TableColumn<Warehouse, Integer> tablePrice;

    @FXML
    private TableColumn<Warehouse, String> tableSize;

    @FXML
    private TableColumn<Warehouse, Integer> tableStock;

    @FXML
    private TableView <Warehouse> tableView;

    @FXML
    private TableColumn<Warehouse, Integer> tableWPrice;

    @FXML
    private TableColumn<Warehouse, Integer> tableWareId;
    
        @FXML
    private TextField brandField;

    @FXML
    private Pane brandPane;

    @FXML
    private TextField cityField;

    @FXML
    private Pane cityPane;

    @FXML
    private TextField colorField;

    @FXML
    private Pane colorPane;

    @FXML
    private TextField countryField;

    @FXML
    private Pane countryPane;

    @FXML
    private AnchorPane filterPane;

    @FXML
    private FlowPane flowPane;

    @FXML
    private TextField idField;

    @FXML
    private Pane idPane;

    @FXML
    private TextField nameField;

    @FXML
    private Pane namePane;

    @FXML
    private TextField priceField;

    @FXML
    private Pane pricePane;

    @FXML
    private TextField sizeField;

    @FXML
    private Pane sizePane;

    @FXML
    private TextField stockField;

    @FXML
    private Pane stockPane;

    @FXML
    private TextField streetField;

    @FXML
    private Pane streetPane;

    @FXML
    private TextField wIDField;

    @FXML
    private Pane wIDPane;

    @FXML
    private TextField wPriceField;

    @FXML
    private Pane wPricePane;

    private Parent root;
    private boolean created = false;
    @FXML
    void filterButton(ActionEvent event) throws IOException {
        if(!created){
            created=true;
            FXMLLoader s = new FXMLLoader(getClass().getResource("/UI/DepartmentManagerPage/warehouse-filter.fxml"));
            s.setController(this);
             root= s.load();
            filterPane.getChildren().add(root);
            
        }
        else{root.setVisible(true);}
    }

    @FXML
    void showInfo(ActionEvent event) {

    }

    @FXML
    void clearFilter(){
        idField.setText("");
        nameField.setText("");
        sizeField.setText("");
        countryField.setText("");
        cityField.setText("");
        streetField.setText("");
        priceField.setText("");
        brandField.setText("");
        colorField.setText("");
        nameField.setText("");
        wPriceField.setText("");
        stockField.setText("");
        wIDField.setText("");
        searchAll();
        Object[] arr = filterPane.getChildren().toArray();
        
        for(Object temp : arr){
            
            if(temp instanceof JFXCheckBox)
                ((JFXCheckBox)temp).setSelected(false);
        }
        
        flowPane.getChildren().clear();
        flowPane.getChildren().add(idPane);
    }

    
    
    //FILTER
    private boolean isSelectedEvent(ActionEvent e){
        return ((JFXCheckBox) e.getSource()).isSelected();
    }
    
       @FXML
    void Done(ActionEvent event) {
      root.setVisible(false);
    }
    
    @FXML
    void brandCheck(ActionEvent event) {
          if(isSelectedEvent(event))
              flowPane.getChildren().add(brandPane);
          else flowPane.getChildren().remove(brandPane);
    }

    @FXML
    void colorCheck(ActionEvent event) {
       if(isSelectedEvent(event))
           flowPane.getChildren().add(colorPane);
       else flowPane.getChildren().remove(colorPane);
    }

    @FXML
    void locationCheck(ActionEvent event) {
     if(isSelectedEvent(event)){
         flowPane.getChildren().add(countryPane);
         flowPane.getChildren().add(cityPane);
         flowPane.getChildren().add(streetPane);
     }else{
         flowPane.getChildren().remove(countryPane);
         flowPane.getChildren().remove(cityPane);
         flowPane.getChildren().remove(streetPane);
     }
     
    }

    @FXML
    void nameCheck(ActionEvent event) {
     if(isSelectedEvent(event))
         flowPane.getChildren().add(namePane);
     else flowPane.getChildren().remove(namePane);
    }

    @FXML
    void priceCheck(ActionEvent event) {
        if(isSelectedEvent(event))
         flowPane.getChildren().add(pricePane);
     else flowPane.getChildren().remove(pricePane);
    }

    @FXML
    void sizeChick(ActionEvent event) {
 if(isSelectedEvent(event))
         flowPane.getChildren().add(sizePane);
     else flowPane.getChildren().remove(sizePane);
    }

    @FXML
    void stockCheck(ActionEvent event) {
         if(isSelectedEvent(event))
         flowPane.getChildren().add(stockPane);
     else flowPane.getChildren().remove(stockPane);
    }

    @FXML
    void wPriceCheck(ActionEvent event) { 
         if(isSelectedEvent(event))
         flowPane.getChildren().add(wPricePane);
     else flowPane.getChildren().remove(wPricePane);
    }

    @FXML
    void warehouseCheck(ActionEvent event) {
      if(isSelectedEvent(event))
         flowPane.getChildren().add(wIDPane);
     else flowPane.getChildren().remove(wIDPane);
    }

    @FXML
    private void searchButton(){
         data.clear();
         
        try {
            con = DriverManager.getConnection(App.ip, App.user, App.password);
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery("select d.DRESSID, d.DRESSNAME, d.DRESSCOLOR, d.BRANDNAME, d.DRESSSIZE, wd.WAREHOUSE_STOCK, wd.WID, d.WSPRICE, d.PRICE from DRESS d join WAREHOUSE_DRESS wd on d.DRESSID = wd.DRESSID "
                    + " where d.DRESSID LIKE '%"+idField.getText()+"%' AND d.DRESSNAME LIKE '%"+nameField.getText()+"%' AND d.DRESSCOLOR LIKE '%"+colorField.getText()+"%' AND d.BRANDNAME LIKE '%"+brandField.getText()+"%' "
                    + " AND d.DRESSSIZE LIKE '%"+sizeField.getText()+"%' AND wd.WAREHOUSE_STOCK LIKE '%"+stockField.getText()+"%' AND wd.WID LIKE '%"+wIDField.getText()+"%' AND d.WSPRICE LIKE '%"+wPriceField.getText()+"%' AND d.PRICE LIKE '%"+priceField.getText()+"%' ");
            
                   while(rs.next()){
                long dId = rs.getLong(1);
                String dressName = rs.getString(2);
                String dressColor = rs.getString(3);
                String dressBrand = rs.getString(4);
                String dressSize = rs.getString(5);
                int wStock = rs.getInt(6);
                int wId = rs.getInt(7);
                int wPrice = rs.getInt(8);
                int price = rs.getInt(9);
                
                data.add(new Warehouse (dId, dressName, dressSize, dressColor, dressBrand, wStock, wId, wPrice, price));
            }
                   
                   tableView.setItems(data);
            con.close();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        
    }

}
