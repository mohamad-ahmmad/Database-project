package com.app.garage.controllers.warehouseManager;

import java.io.IOException;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class WarehouseManagerController {

    @FXML
    private Label labelLogout;

    @FXML
    private Label lblShipments;

    @FXML
    private Label lblSuppliers;
    @FXML
    private Label lblClothes;

    @FXML
    private Label lblWarehouses;

    @FXML
    private AnchorPane mainPanel;

    @FXML
    private AnchorPane menuPanel;

    @FXML
    private AnchorPane viewPanel;

    @FXML
    void Logout(MouseEvent event) {

    }
    boolean clothesSelected = false;
    boolean shipmentSelected = false;
    boolean suppliersSelected = false;
    boolean warehousesSelected = false;
    private void clearStyles(){
        lblShipments.setStyle("");
        lblSuppliers.setStyle("");
        lblWarehouses.setStyle("");
        lblClothes.setStyle("");
    }
    @FXML
    void openShipmentsPanel(MouseEvent event) throws IOException {
        
         if(!shipmentSelected)
        {
               clearStyles();
        lblShipments.setStyle("-fx-border-color: #F8A918; -fx-border-width: 0 0 0 5");
        Timeline t = new Timeline();
        Parent root = FXMLLoader.load(getClass().getResource("/UI/WarehouseManagerPage/ShipmentsPage.fxml"));
        root.scaleXProperty().set(0.8);
        root.scaleYProperty().set(0.8);
         t.getKeyFrames().add(new KeyFrame(
                 Duration.seconds(0.3) ,
      new KeyValue(root.scaleXProperty() , 1)
       ,new KeyValue(root.scaleYProperty() , 1)
      ));
         t.play();
        viewPanel.getChildren().clear();
        viewPanel.getChildren().add(root);
        shipmentSelected = true;
        suppliersSelected = false;
        warehousesSelected = false;
        clothesSelected = false;
        }
    }

    @FXML
    void openSuppliersPanel(MouseEvent event) throws IOException {
                
         if(!suppliersSelected)
        {
        clearStyles();
        lblSuppliers.setStyle("-fx-border-color: #F8A918; -fx-border-width: 0 0 0 5");
        Timeline t = new Timeline();
        Parent root = FXMLLoader.load(getClass().getResource("/UI/WarehouseManagerPage/SuppliersPage.fxml"));
        root.scaleXProperty().set(0.8);
        root.scaleYProperty().set(0.8);
         t.getKeyFrames().add(new KeyFrame(
                 Duration.seconds(0.3) ,
      new KeyValue(root.scaleXProperty() , 1)
       ,new KeyValue(root.scaleYProperty() , 1)
      ));
         t.play();
        viewPanel.getChildren().clear();
        viewPanel.getChildren().add(root);
        shipmentSelected = false;
        suppliersSelected = true;
        warehousesSelected = false;
        clothesSelected = false;
        }

    }

    @FXML
    void openWarehousesPanel(MouseEvent event) throws IOException {
                        
         if(!warehousesSelected)
        {
        clearStyles();
        lblWarehouses.setStyle("-fx-border-color: #F8A918; -fx-border-width: 0 0 0 5");
        Timeline t = new Timeline();
        Parent root = FXMLLoader.load(getClass().getResource("/UI/WarehouseManagerPage/WarehousesPage.fxml"));
        root.scaleXProperty().set(0.8);
        root.scaleYProperty().set(0.8);
         t.getKeyFrames().add(new KeyFrame(
         Duration.seconds(0.3) ,
        new KeyValue(root.scaleXProperty() , 1)
       ,new KeyValue(root.scaleYProperty() , 1)
      ));
         t.play();
        viewPanel.getChildren().clear();
        viewPanel.getChildren().add(root);
        shipmentSelected = false;
        suppliersSelected = false;
        warehousesSelected = true;
        clothesSelected = false;
        }
    }
  
    @FXML
    void openClothesPanel(MouseEvent event) throws IOException {
                        
         if(!clothesSelected)
        {
        clearStyles();
        lblClothes.setStyle("-fx-border-color: #F8A918; -fx-border-width: 0 0 0 5");
        Timeline t = new Timeline();
        Parent root = FXMLLoader.load(getClass().getResource("/UI/WarehouseManagerPage/ClothesPage.fxml"));
        root.scaleXProperty().set(0.8);
        root.scaleYProperty().set(0.8);
         t.getKeyFrames().add(new KeyFrame(
         Duration.seconds(0.3) ,
        new KeyValue(root.scaleXProperty() , 1)
       ,new KeyValue(root.scaleYProperty() , 1)
      ));
         t.play();
        viewPanel.getChildren().clear();
        viewPanel.getChildren().add(root);
        shipmentSelected = false;
        suppliersSelected = false;
        warehousesSelected = false;
        clothesSelected = true;
        }

    }

}
