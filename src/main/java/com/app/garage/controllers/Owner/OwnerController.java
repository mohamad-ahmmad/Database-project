package com.app.garage.controllers.Owner;

import com.app.garage.App;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class OwnerController {
      @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnConfirm;
    @FXML
    private Label labelEmployees;
    @FXML
    private Label labelDepartments;
    @FXML
    private Label labelLogout;
    @FXML
    private Label labelProfits;
    @FXML
    private Label labelHome;

    @FXML
    private AnchorPane mainPanel;

    @FXML
    private AnchorPane menuPanel;

    @FXML
    private AnchorPane viewPanel;
    
    
    
    private Stage currentStage;

    @FXML
    void openProfitsPanel(MouseEvent event) throws IOException {
                clearStyles();
        labelProfits.setStyle("-fx-border-color: #F8A918; -fx-border-width: 0 0 0 5");
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
               clearStyles();
        labelHome.setStyle("-fx-border-color: #F8A918; -fx-border-width: 0 0 0 5");
       
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
    private void clearStyles(){
        labelHome.setStyle("");
        labelProfits.setStyle("");
        labelDepartments.setStyle("");
        labelLogout.setStyle("");
        labelEmployees.setStyle("");
    }
    @FXML
    void openDepartmentPanel() throws IOException {
        clearStyles();
        labelDepartments.setStyle("-fx-border-color: #F8A918; -fx-border-width: 0 0 0 5");
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
                 clearStyles();
        labelEmployees.setStyle("-fx-border-color: #F8A918; -fx-border-width: 0 0 0 5");
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
      void Logout(MouseEvent e) throws IOException {
                  clearStyles();
        labelLogout.setStyle("-fx-border-color: #F8A918; -fx-border-width: 0 0 0 5");
          currentStage = (Stage)((Node) e.getSource()).getScene().getWindow();
           Stage logout = new Stage();
           logout.initModality(Modality.APPLICATION_MODAL);
           logout.initStyle(StageStyle.UNDECORATED);
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
         Parent root = FXMLLoader.load(getClass().getResource("/UI/OwnerPage/Owner-form.fxml"));
         Scene temp = new Scene(root);
         App.setMainScene(temp);
    }
        @FXML
    void Confirm(ActionEvent event) throws IOException {
         //Closing Logout Stage
         
         //this method will return the App stage.
       Stage appStage = App.getAppStage();//Method added to the App class 
       
       Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
       appStage.hide();
       stage.close();
       
       
       
       Parent root = FXMLLoader.load(getClass().getResource("/UI/login/login-form.fxml"));
       Scene temp = new Scene(root);
       App.setMainScene(temp);//Method in App class to change the current displaying scene
       appStage.show();
      
    }

    
}
