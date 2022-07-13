/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.employee;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author USER-M
 */
public class ReceiptController implements Initializable  {
    
      @FXML
    private MFXButton addBtn;

    @FXML
    private AnchorPane card;

    @FXML
    private MFXButton deleteBtn;

    @FXML
    private MFXDatePicker dressDate;

    @FXML
    private MFXTextField dressID;

    @FXML
    private MFXTextField dressReceipt;

    @FXML
    private MFXTextField dressSerial;

    @FXML
    private MFXCheckbox enableChecked;

    @FXML
    void addReceipt(ActionEvent event) {

    }

    @FXML
    void deleteReceipt(ActionEvent event) {

    }
    
    private void setEditability(boolean temp){
        temp =!temp;
       dressDate.disableProperty().set(temp);
       dressID.disableProperty().set(temp);
       dressReceipt.disableProperty().set(temp);
       dressSerial.disableProperty().set(temp);
       addBtn.disableProperty().set(temp);
      
      
      
        
        
    }
    
    @FXML
    void enableCheck(ActionEvent event) {
     if( ((MFXCheckbox)event.getSource()).isSelected() )
         setEditability(true);
     else setEditability(false);
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setEditability(false);
        
        
    }
    
}
