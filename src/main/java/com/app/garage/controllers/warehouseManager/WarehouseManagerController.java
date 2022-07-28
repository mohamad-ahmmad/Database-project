package com.app.garage.controllers.warehouseManager;

import com.app.garage.App;
import com.app.garage.controllers.login.LoginController;
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
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class WarehouseManagerController implements Initializable{

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
      void Logout(MouseEvent e) throws IOException {
                  clearStyles();
        labelLogout.setStyle("-fx-border-color: #F8A918; -fx-border-width: 0 0 0 5");
           Stage logout = new Stage();
           logout.initModality(Modality.APPLICATION_MODAL);
           logout.initStyle(StageStyle.TRANSPARENT);
            Parent root = FXMLLoader.load(getClass().getResource("/UI/OwnerPage/Logout.fxml"));
            Scene logoutScene = new Scene(root);
            logoutScene.setFill(Color.TRANSPARENT);
            logout.setOpacity(0.85);
       logout.setScene(logoutScene);
       logout.setX(650);
       logout.setY(220);
       logout.show();
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
    @FXML
    private Label welcomeLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Connection con = DriverManager.getConnection(App.ip, App.user, App.password);
            Statement st = con.createStatement();
            ResultSet result = st.executeQuery("Select firstname from employee where IDCard = " + LoginController.currentUser);
            result.next();
            welcomeLabel.setText("Welcome, " + result.getString("firstname"));
        } catch (SQLException ex) {
            Logger.getLogger(WarehouseManagerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
