package com.app.garage.controllers.Owner;

import com.app.garage.App;
import com.jfoenix.controls.JFXButton;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.Effect;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class OwnerController implements Initializable {
      @FXML
    private JFXButton btnCancel;
    @FXML
    AnchorPane shadowPanel;
    @FXML
    private JFXButton btnConfirm;
    @FXML
    private AnchorPane smallSlide;
    @FXML
    private Label labelEmployees;
    @FXML
    private Label labelDepartments;
    @FXML
    private Label labelLogout;
    @FXML
    private Label labelWarehouses;
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
    
    boolean homeSelected = false;
    boolean profitsSelected = false;
    boolean departmentsSelected = false;
    boolean employeesSelected = false;
    boolean warehousesSelected=false;
    private Stage currentStage;

    @FXML
    void openProfitsPanel(MouseEvent event) throws IOException {
        if(!profitsSelected)
        {
            Parent root = FXMLLoader.load(getClass().getResource("/UI/OwnerPage/ProfitsPage.fxml"));
                clearStyles();
        labelProfits.setStyle("-fx-border-color: #F8A918; -fx-border-width: 0 0 0 5");
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
        profitsSelected = true;
        homeSelected = false;
        departmentsSelected = false;
        employeesSelected = false;
        warehousesSelected=false;
        }
    }
    
    @FXML
    void openMhammadAhamd(MouseEvent event) throws URISyntaxException, IOException {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
         Desktop.getDesktop().browse(new URI("https://www.canva.com/design/DAFGaYUbsgY/CEWQ1FeE1sq1wR12wojVrA/view?utm_content=DAFGaYUbsgY&utm_campaign=designshare&utm_medium=link&utm_source=publishsharelink"));
        }
    }
     @FXML
    void openBdair(MouseEvent event) throws URISyntaxException, IOException {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
         Desktop.getDesktop().browse(new URI("https://www.canva.com/design/DAFGaV6MXEs/UjzuIP4D90_a2he3wDRRcQ/view?utm_content=DAFGaV6MXEs&utm_campaign=designshare&utm_medium=link&utm_source=publishsharelink"));
        }
    }
    @FXML
    void openHomePanel() throws IOException {
        if(!homeSelected)
        {
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
        profitsSelected = false;
        homeSelected = true;
        departmentsSelected = false;
        employeesSelected = false;
        warehousesSelected=false;
        }
        
      
    }
    private void clearStyles(){
        labelHome.setStyle("");
        labelProfits.setStyle("");
        labelDepartments.setStyle("");
        labelLogout.setStyle("");
        labelEmployees.setStyle("");
        labelWarehouses.setStyle("");
    }
    @FXML
    void openDepartmentPanel() throws IOException {
        if(!departmentsSelected)
        {
        clearStyles();
        labelDepartments.setStyle("-fx-border-color: #F8A918; -fx-border-width: 0 0 0 5");
         Timeline t = new Timeline();
         FXMLLoader temp = new FXMLLoader(getClass().getResource("/UI/OwnerPage/DepartmentsPage.fxml"));
        Parent root = temp.load();
       

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
        
        profitsSelected = false;
        homeSelected = false;
        departmentsSelected = true;
        employeesSelected = false;
        warehousesSelected=false;
        }
    }
    @FXML
     void openEmployeePanel() throws IOException {
         if(!employeesSelected)
         {
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
        profitsSelected = false;
        homeSelected = false;
        departmentsSelected = false;
        employeesSelected = true;
        warehousesSelected=false;
        }
    }
         @FXML
    void openWarehousesPanel() throws IOException {
        if(!warehousesSelected)
        {
        clearStyles();
        labelWarehouses.setStyle("-fx-border-color: #F8A918; -fx-border-width: 0 0 0 5");
         Timeline t = new Timeline();
         FXMLLoader temp = new FXMLLoader(getClass().getResource("/UI/OwnerPage/WarehousesPage.fxml"));
        Parent root = temp.load(); 
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
        
        profitsSelected = false;
        homeSelected = false;
        departmentsSelected = false;
        employeesSelected = false;
        warehousesSelected=true;
        }
    }
     
     @FXML
      void Logout(MouseEvent e) throws IOException {
                  clearStyles();
        labelLogout.setStyle("-fx-border-color: #F8A918; -fx-border-width: 0 0 0 5");
          currentStage = (Stage)((Node) e.getSource()).getScene().getWindow();
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
     @FXML
    void Cancel(ActionEvent e) throws IOException {
     Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
         stage.hide();
        
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    
}
