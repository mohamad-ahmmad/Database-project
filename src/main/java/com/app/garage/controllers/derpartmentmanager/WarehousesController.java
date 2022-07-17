/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.derpartmentmanager;

import com.jfoenix.controls.JFXCheckBox;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author USER-M
 */
public class WarehousesController {
    
    
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
    void showLocation(ActionEvent event) {

    }

    @FXML
    void showPreview(ActionEvent event) {

    }
    @FXML
    void clearFilter(){
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
}
