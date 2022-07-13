/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.derpartmentmanager;

import com.app.garage.controllers.EmailSender;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


/**
 *
 * @author USER-M
 */
public class ManagerController implements Initializable {
    
    
     @FXML
    private Pane labelDepartment;

    @FXML
    private Pane labelEmployees;

    @FXML
    private Label labelLogout;

    @FXML
    private Pane labelProfits;

    @FXML
    private Pane labelWarehouses;

    @FXML
    private AnchorPane menuPanel;

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
    
    private final String cssPressed = "-fx-border-color: #F8A918; -fx-border-width: 0 0 0 5";
    
    private void clearStyles(){
        labelDepartment.setStyle("");
        labelEmployees.setStyle("");
        labelLogout.setStyle("");
        labelProfits.setStyle("");
        labelWarehouses.setStyle("");
    }
    private boolean [] truer = {false,true,true,true};
    
    private void Arraytruer(){
        for(int i = 0 ; i<truer.length ; i++)
        truer[i]=true;
    }
    
    @FXML
    void Logout(MouseEvent event) {
       
            clearStyles();
            labelLogout.setStyle(cssPressed);
            
        
    }

    @FXML
    void openDepartment(MouseEvent event) {
         if(truer[1]){
             clearStyles();
             labelDepartment.setStyle(cssPressed);
             Arraytruer();
             truer[1]=false;
             
         }
    }

    @FXML
    void openEmployees(MouseEvent event) {
       if(truer[0]){
           clearStyles();
           labelEmployees.setStyle(cssPressed);
           Arraytruer();
           truer[0]=false;
           
       }
        
        
    }

    @FXML
    void openProfits(MouseEvent event) {
         if(truer[2]){
            clearStyles();
            labelProfits.setStyle(cssPressed);
            Arraytruer();
            truer[2]=false;
            
         }
    }

    @FXML
    void openWarehouses(MouseEvent event) {
         if(truer[3]){
             clearStyles();
             labelWarehouses.setStyle(cssPressed);
             Arraytruer();
             truer[3]=false;
             
         }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
             labelEmployees.setStyle(cssPressed);
      
    }
    
    
    
    
}
