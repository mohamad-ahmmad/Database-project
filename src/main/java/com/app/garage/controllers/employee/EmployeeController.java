package com.app.garage.controllers.employee;

import com.app.garage.App;
import com.app.garage.controllers.EmailSender;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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

/**
 *
 * @author USER-M
 */
public class EmployeeController implements Initializable {
    
    
    private Stage currentStage;
      
    @FXML
    private Label labelCashier;

    @FXML
    private Label labelClothes;

    @FXML
    private Label labelEmployees;

    @FXML
    private Label labelLogout;

    @FXML
    private Label labelReceipt;

    private boolean[] locker = {true, false, false};

    @FXML
    private AnchorPane viewPanel;
    
    
    
    private void loadAnimatedPane(String path) throws IOException{
                    Timeline t = new Timeline();
        Parent root = FXMLLoader.load(getClass().getResource(path));
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
    
    private void lockerTruer(){
      for(int i = 0 ; i < locker.length ; i++)
          locker[i]=true;
    }
    private void clearStyles(){
        labelCashier.setStyle("");
        labelClothes.setStyle("");
        labelLogout.setStyle("");
        labelReceipt.setStyle("");
        
    }
    private final String cssPressed = "-fx-border-color: #F8A918; -fx-border-width: 0 0 0 5";
    
        @FXML
    void openCashierPanel(MouseEvent event) throws IOException {
        if(locker[0]){
          clearStyles();
          labelCashier.setStyle(cssPressed);
          loadAnimatedPane("/UI/EmployeePage/cashier-page.fxml");
          lockerTruer();
          locker[0]=false;
          System.out.println(locker[0]+" "+locker[1]+" "+locker[2]);
        }
  
       
       
    }

    @FXML
    void openClothesPanel(MouseEvent event) throws IOException {
        if(locker[1]){
         clearStyles();
         labelClothes.setStyle(cssPressed);
         loadAnimatedPane("/UI/EmployeePage/clothes-page.fxml");
         lockerTruer();
         locker[1]=false;
        }

    }

    @FXML
    void openReceiptPanel(MouseEvent event) throws IOException {
        if(locker[2]){
       clearStyles();
       labelReceipt.setStyle(cssPressed);
       loadAnimatedPane("/UI/EmployeePage/receipt-page.fxml");
       lockerTruer();
       locker[2]=false;
       
        }
      
       
    }
    
    
    
     @FXML
      void Logout(MouseEvent e) throws IOException {
          clearStyles();
        labelLogout.setStyle(cssPressed);
          currentStage = (Stage)((Node) e.getSource()).getScene().getWindow();
           Stage logout = new Stage();
           logout.initModality(Modality.APPLICATION_MODAL);
           logout.initStyle(StageStyle.UNDECORATED);
            Parent root = FXMLLoader.load(getClass().getResource("/UI/OwnerPage/Logout.fxml"));
            Scene logoutScene = new Scene(root);
       logout.setScene(logoutScene);
       logout.show();
   
    }

     @FXML
    void Cancel(ActionEvent e) throws IOException {
         Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
         stage.hide();
        // Parent root = FXMLLoader.load(getClass().getResource("/UI/OwnerPage/Owner-form.fxml"));
        // Scene temp = new Scene(root);
        // App.setMainScene(temp);
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
      
        
          labelCashier.setStyle(cssPressed);
        try {
            loadAnimatedPane("/UI/EmployeePage/cashier-page.fxml");
        } catch (IOException ex) {
         ex.printStackTrace();
        }
        lockerTruer();
          locker[0]=false;

      
          
    }
    

    
}