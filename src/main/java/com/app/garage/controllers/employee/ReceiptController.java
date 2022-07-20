/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.employee;

import com.app.garage.App;
import com.jfoenix.controls.JFXCheckBox;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author USER-M
 */
public class ReceiptController implements Initializable  {
    
    private Connection con;
    
    @FXML
    private MFXTextField dressSearch;
    
    @FXML
    private MFXTextField amountSearch;

    @FXML
    private MFXTextField dateSearch;

    @FXML
    private MFXTextField idSearch;
    
    

     @FXML
    private Pane addPane;
    
      @FXML
    private MFXButton addBtn;

    @FXML
    private AnchorPane card;

    

    @FXML
    private MFXDatePicker dressDate;

    @FXML
    private MFXTextField dressID;

    @FXML
    private MFXTextField dressReceipt;

    @FXML
    private MFXTextField dressSerial;

    @FXML
    private MFXTextField amount;
    @FXML
    private MFXCheckbox enableChecked;

  
    
    private void setEditability(boolean temp){
        temp =!temp;
       dressDate.disableProperty().set(temp);
       dressID.disableProperty().set(temp);
       dressReceipt.disableProperty().set(temp);
       dressSerial.disableProperty().set(temp);
       addBtn.disableProperty().set(temp);
       amount.disableProperty().set(temp);
      
      
        
        
    }
    
    @FXML
    void enableCheck(ActionEvent event) {
     if( ((JFXCheckBox)event.getSource()).isSelected() ){
         setEditability(true);
         addPane.setStyle("-fx-border-color:#666; -fx-border-radius:5");
     }
         
     else{
         setEditability(false);
         addPane.setStyle("-fx-border-color:#aaa; -fx-border-radius:5");
     }
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setEditability(false);
        
        
    }
    
    @FXML 
    private void search(ActionEvent e) {
        
        try {
            con = DriverManager.getConnection(App.ip, App.user, App.password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    @FXML
    void addReceipt(ActionEvent event) {

    }

    @FXML
    void deleteReceipt(ActionEvent event) {

    }
    
}
