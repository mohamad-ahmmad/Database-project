/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.derpartmentmanager;

import com.jfoenix.controls.JFXCheckBox;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 *
 * @author USER-M
 */
public class AddLocationContactContoller implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        countryTextField.setDisable(true);
        cityTextField.setDisable(true);
        
        streetTextField.setDisable(true);
        phoneNumberTextField.setDisable(true);
    }
    
    @FXML
    private MFXTextField cityTextField;

    @FXML
    private MFXTextField countryTextField;

    @FXML
    private MFXTextField phoneNumberTextField;

    @FXML
    private MFXTextField ssnTextField;

    @FXML
    private MFXTextField streetTextField;

    @FXML
    void Cancel(ActionEvent event) {
      ((Stage)(((Node)event.getSource()).getScene().getWindow())).close();
    }

    private boolean isSelectedCheckBox(ActionEvent e){
        return ((JFXCheckBox)e.getSource()).isSelected();
    }
    
    @FXML
    void ContactSelected(ActionEvent event) {
        if(isSelectedCheckBox(event)){
             phoneNumberTextField.setDisable(false);
        }
           
        else{
            phoneNumberTextField.setDisable(true);
        }
           
    }

    @FXML
    void Done(ActionEvent event) {

    }

    @FXML
    void LocationSelected(ActionEvent event) {
        if(isSelectedCheckBox(event)){
        countryTextField.setDisable(false);
        cityTextField.setDisable(false);  
        streetTextField.setDisable(false);
        }
           
        else{
        countryTextField.setDisable(true);
        cityTextField.setDisable(true); 
        streetTextField.setDisable(true);
        }
        
    }
    
    
}
