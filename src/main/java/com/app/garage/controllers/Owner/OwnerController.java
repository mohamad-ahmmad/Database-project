package com.app.garage.controllers.Owner;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class OwnerController {
      @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnConfirm;

    @FXML
    private Label labelProfits;

    @FXML
    private AnchorPane mainPanel;

    @FXML
    private AnchorPane menuPanel;

    @FXML
    private AnchorPane viewPanel;
    
    private Stage logout;

    @FXML
    void openProfitsPanel(MouseEvent event) throws IOException {
         Timeline t = new Timeline();
        Parent root = FXMLLoader.load(getClass().getResource("/UI/OwnerPage/ProfitsPage.fxml"));
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
    }
    @FXML
    void openHomePanel() throws IOException {
     Timeline t = new Timeline();
        Parent root = FXMLLoader.load(getClass().getResource("/UI/OwnerPage/HomePage.fxml"));
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
    }
    @FXML
    void openDepartmentPanel() throws IOException {
         Timeline t = new Timeline();
        Parent root = FXMLLoader.load(getClass().getResource("/UI/OwnerPage/DepartmentsPage.fxml"));
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
    }
    @FXML
     void openEmployeePanel() throws IOException {
          Timeline t = new Timeline();
        Parent root = FXMLLoader.load(getClass().getResource("/UI/OwnerPage/EmployeesPage.fxml"));
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
    }
     @FXML
      void Logout() throws IOException {
           logout = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/UI/OwnerPage/Logout.fxml"));
            Scene logoutScene = new Scene(root);
            
       logout.setScene(logoutScene);
       logout.show();
       /*   Timeline t = new Timeline();
        Parent root = FXMLLoader.load(getClass().getResource("/UI/OwnerPage/Logout.fxml"));
        root.scaleXProperty().set(0.8);
        root.scaleYProperty().set(0.8);
         t.getKeyFrames().add(new KeyFrame(
                 Duration.seconds(0.3) ,
      new KeyValue(root.scaleXProperty() , 1)
       ,new KeyValue(root.scaleYProperty() , 1)
      ));
         t.play();
        mainPanel.getChildren().add(root);
        Node node = mainPanel.getChildren().get(2);
        node.setTranslateX(400);
        node.setTranslateY(250);*/
    }

     @FXML
    void Cancel(ActionEvent e) throws IOException {
        Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }
        @FXML
    void Confirm(ActionEvent event) throws IOException {
     

    }

    
}
