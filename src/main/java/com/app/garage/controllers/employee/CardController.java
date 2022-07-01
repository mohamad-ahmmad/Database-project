/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.employee;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author USER-M
 */
public class CardController implements Initializable {
    
    private boolean selected =false;
   
    @FXML
    private AnchorPane cardPane;
    
    @FXML
    private Label amountNum;
    
    @FXML
    private ImageView image;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       image.setImage(new Image(String.valueOf(getClass().getResource("/UI/OwnerPage/HomePageAssets/MSI.jpg"))));
    }
    @FXML
    void paneClicked(MouseEvent event) {
        if(!selected)
        cardPane.setStyle("-fx-border-color:#59bfff");
        else
            cardPane.setStyle("");
        
       selected=!selected;
    }
    public boolean isSelected(){
        
        return selected;
    }
    
}
