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
    private AnchorPane mainPanel;

    @FXML
    private AnchorPane menuPanel;

    @FXML
    private AnchorPane viewPanel;

    @FXML
    private Label lblShipments;

    @FXML
    private Label lblSuppliers;

    @FXML
    private Label lblWarehouses;

    @FXML
    void Logout(MouseEvent event) {

    }   
    private void clearStyles(){
        lblShipments.setStyle("");
        lblWarehouses.setStyle("");
        lblSuppliers.setStyle("");
        labelLogout.setStyle("");
    }
    
boolean shipmentsSelected = false;
boolean suppliersSelected = false;
boolean warehousesSelected = false;
    @FXML
    void openShipmentsPanel(MouseEvent event) throws IOException {
        if(!shipmentsSelected)
        {
            Parent root = FXMLLoader.load(getClass().getResource("/UI/WarehouseManagerPage/ShipmentsPage.fxml"));
                clearStyles();
        lblShipments.setStyle("-fx-border-color: #F8A918; -fx-border-width: 0 0 0 5");
         Timeline t = new Timeline();
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
        suppliersSelected = false;
        warehousesSelected = false;
        shipmentsSelected = true;
        }

    }

    @FXML
    void openSuppliersPanel(MouseEvent event) throws IOException {
         if(!suppliersSelected)
        {
            Parent root = FXMLLoader.load(getClass().getResource("/UI/WarehouseManagerPage/SuppliersPage.fxml"));
            clearStyles();
        lblSuppliers.setStyle("-fx-border-color: #F8A918; -fx-border-width: 0 0 0 5");
         Timeline t = new Timeline();
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
        suppliersSelected = true;
        warehousesSelected = false;
        shipmentsSelected = false;
        }

    }

    @FXML
    void openWarehousesPanel(MouseEvent event) throws IOException {
        if(!warehousesSelected)
        {
            Parent root = FXMLLoader.load(getClass().getResource("/UI/WarehouseManagerPage/WarehousesPage.fxml"));
            clearStyles();
        lblWarehouses.setStyle("-fx-border-color: #F8A918; -fx-border-width: 0 0 0 5");
         Timeline t = new Timeline();
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
        suppliersSelected = false;
        warehousesSelected = true;
        shipmentsSelected = false;
        }


    }

}
