/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.employee;

import com.app.garage.App;
import com.app.garage.controllers.login.LoginController;
import com.jfoenix.controls.JFXCheckBox;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.util.converter.LongStringConverter;

/**
 *
 * @author USER-M
 */
public class ClothesController implements Initializable {

    private Connection con; 
    
    private ObservableList<Dress> all = FXCollections.observableArrayList();
    private ObservableList<Dress> search = FXCollections.observableArrayList();
    private void searchAll(){
        all.clear();
                try{

        con = DriverManager.getConnection(App.ip,App.user,App.password);
        Statement search = con.createStatement();
        ResultSet rs = search.executeQuery("select  d.DRESSID , d.DRESSNAME , d.DRESSSIZE , d.DRESSCOLOR , d.BRANDNAME , d.PRICE, dd.SALEPERCENTAGE, dd.DEPARTMENTSTOCK "
                + " from DRESS d join DEPARTMENT_DRESS dd on dd.DID = "+LoginController.currentUser.substring(1,4)+" AND d.DRESSID = dd.DRESSID ");
        while(rs.next()){
           long idDress = rs.getLong(1);
           String dressName = rs.getString(2);
           String dressSize = rs.getString(3);
           String dressColor = rs.getString(4);
           String brandName = rs.getString(5);
           int price = rs.getInt(6);
        
           String sale = rs.getString(7)+"%";
           int priceOffer = price - (price*(Integer.parseInt(rs.getString(7)))/100);
           int stock = rs.getInt(8);
          //Dress(int id, String name, String color, String size, int price, int priceOffer, String brand, String sale, int stock){
         
            all.add(new Dress(idDress, dressName,  dressColor, dressSize,  price, priceOffer, brandName, sale,stock ));
        }
        
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        colorCol.setCellValueFactory(new PropertyValueFactory<>("color"));
        sizeCol.setCellValueFactory(new PropertyValueFactory<>("size"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        priceOfferCol.setCellValueFactory(new PropertyValueFactory<>("priceOffer"));
        brandCol.setCellValueFactory(new PropertyValueFactory<>("brand"));
        saleCol.setCellValueFactory(new PropertyValueFactory<>("sale"));
        stockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        

        
        
        dressTable.setItems(all);
        
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
    }
    
    @FXML 
    private TableView<Dress> dressTable;
    
    @FXML
    private TableColumn<Dress, String> nameCol;

    @FXML
    private TableColumn<Dress, Integer> priceCol;

    @FXML
    private TableColumn<Dress, Integer> priceOfferCol;

    @FXML
    private TableColumn<Dress, String> saleCol;

    @FXML
    private TableColumn<Dress, String> sizeCol;

    @FXML
    private TableColumn<Dress, Integer> stockCol;
    
    
    @FXML
    private TableColumn<Dress, Long> idCol;
      @FXML
    private TableColumn<Dress, String> brandCol;

    @FXML
    private TableColumn<Dress, String> colorCol;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          searchAll();
          idCol.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
          nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        
        
    }
    
  
    
    
    @FXML
    private FlowPane textPane;
    
    @FXML
    private MFXTextField dressBrand;

    @FXML
    private MFXTextField dressColor;

    @FXML
    private MFXTextField dressName;

    @FXML
    private MFXTextField dressOPrice;
    
    @FXML
    private MFXTextField dressPrice;

    @FXML
    private MFXTextField dressSale;

    @FXML
    private MFXTextField dressSize;

    @FXML
    private MFXTextField dressStock;

    @FXML
    private ImageView lens;

    @FXML
    private ImageView lens1;

    @FXML
    private AnchorPane mainAnchor;
    
    @FXML
    private AnchorPane flowPane;
    @FXML
    private TextField dressIDtextField;
    @FXML
    void filterClicked(ActionEvent event) throws IOException {
        if(flowPane==null){FXMLLoader s = new FXMLLoader(getClass().getResource("/UI/EmployeePage/SearchFilter.fxml"));
         s.setController(this);
        Parent searchComponent = s.load();
       
      
      searchComponent.layoutXProperty().set(200);
       searchComponent.layoutYProperty().set(300);
      mainAnchor.getChildren().add(searchComponent);
        }
        else flowPane.setVisible(true);
    
    }

    @FXML
    void searchClicked(ActionEvent event) {
        //(select SALEPERCENTAGE , DEPARTMENTSTOCK FROM DEPARTMENT_DRESS)
        search.clear();
        try{

        con = DriverManager.getConnection(App.ip,App.user,App.password);
        Statement search = con.createStatement();
        ResultSet rs = search.executeQuery("select d.DRESSID , d.DRESSNAME , d.DRESSSIZE , d.DRESSCOLOR , d.BRANDNAME , d.PRICE, dd.SALEPERCENTAGE, dd.DEPARTMENTSTOCK "
                + " from DRESS d join DEPARTMENT_DRESS dd on dd.DID = "+LoginController.currentUser.substring(1,4)+" AND dd.DRESSID=d.DRESSID " +" where dd.DRESSID LIKE '%"+dressIDtextField.getText()+"%' AND d.DRESSNAME LIKE '%" +dressName.getText()+"%' "
                + " AND d.DRESSSIZE LIKE '%"+dressSize.getText()+"%' AND d.DRESSCOLOR LIKE '%"+ dressColor.getText()+ "%' "
                + " AND d.BRANDNAME LIKE '%" + dressBrand.getText() +"%' AND d.PRICE LIKE '%" + dressPrice.getText() + "%' AND dd.SALEPERCENTAGE LIKE '%"+dressSale.getText()+"%' AND dd.DEPARTMENTSTOCK LIKE '%"+dressStock.getText()+"%' ");
       
          while(rs.next()){
           long idDress = rs.getLong(1);
           String dressName = rs.getString(2);
           String dressSize = rs.getString(3);
           String dressColor = rs.getString(4);
           String brandName = rs.getString(5);
           int price = rs.getInt(6);
        
           String sale = rs.getString(7)+"%";
           int priceOffer = price - (price*(Integer.parseInt(rs.getString(7)))/100);
           int stock = rs.getInt(8);
          //Dress(int id, String name, String color, String size, int price, int priceOffer, String brand, String sale, int stock){
         
            this.search.add(new Dress(idDress, dressName,  dressColor, dressSize,  price, priceOffer, brandName, sale,stock ));
        }

        
        dressTable.setItems(this.search);
        
      
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
          
        /*DATABASE THINGS*/
    }
     @FXML
    void Done(ActionEvent event) {
        flowPane.setVisible(false);
    }

    @FXML
    void brandChecked(ActionEvent event) {
       if( ((JFXCheckBox)event.getSource()).isSelected())
        textPane.getChildren().add(dressBrand);
        else
           textPane.getChildren().remove(dressBrand);
        
    }

    @FXML
    void colorChecked(ActionEvent event) {
  if( ((JFXCheckBox)event.getSource()).isSelected())
        textPane.getChildren().add(dressColor);
        else
           textPane.getChildren().remove(dressColor);
    }

    @FXML
    void nameChecked(ActionEvent event) {
      if( ((JFXCheckBox)event.getSource()).isSelected())
        textPane.getChildren().add(dressName);
        else
           textPane.getChildren().remove(dressName);
    }

    @FXML
    void priceChecked(ActionEvent event) {
         if( ((JFXCheckBox)event.getSource()).isSelected())
        textPane.getChildren().add(dressPrice);
        else
           textPane.getChildren().remove(dressPrice);
    }

    @FXML
    void priceOChecked(ActionEvent event) {
  if( ((JFXCheckBox)event.getSource()).isSelected())
        textPane.getChildren().add(dressOPrice);
        else
           textPane.getChildren().remove(dressOPrice);
    }

    @FXML
    void saleChecked(ActionEvent event) {
       if( ((JFXCheckBox)event.getSource()).isSelected())
        textPane.getChildren().add(dressSale);
        else
           textPane.getChildren().remove(dressSale);
    }

    @FXML
    void sizeChecked(ActionEvent event) {
    if( ((JFXCheckBox)event.getSource()).isSelected())
        textPane.getChildren().add(dressSize);
        else
           textPane.getChildren().remove(dressSize);
    }
    
    @FXML
    void stockChecked(ActionEvent event){
        if( ((JFXCheckBox)event.getSource()).isSelected() ){
            textPane.getChildren().add(dressStock);
        }else textPane.getChildren().remove(dressStock);
        
    }
    
    @FXML
    void clearPressed(ActionEvent event){
        
        Object[] s = flowPane.getChildren().toArray();
        
        for(Object temp : s){
            if(temp instanceof JFXCheckBox)
            ((JFXCheckBox)temp).setSelected(false);
            
        }
        Object [] b = textPane.getChildren().toArray();
        
        for(Object temp : b){
            if(temp instanceof MFXTextField){
                ((MFXTextField)temp).setText("");
                textPane.getChildren().remove(temp);
            }
                
        }
        
        
    }
    
}
