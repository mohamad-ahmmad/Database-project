/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.employee;

import com.jfoenix.controls.JFXCheckBox;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author USER-M
 */
public class ClothesController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      /* dressBrand.setVisible(false);
       dressColor.setVisible(false);
       dressName.setVisible(false);
       dressOPrice.setVisible(false);
       dressPrice.setVisible(false);
       dressSale.setVisible(false);
       dressSize.setVisible(false);
       dressStock.setVisible(false);*/
       
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
    
    
}
