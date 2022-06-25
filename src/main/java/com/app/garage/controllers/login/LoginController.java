/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.login;

import com.app.garage.App;
import io.github.palexdev.materialfx.controls.MFXTextField;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;




/**
 *
 * @author USER-M
 */


public class LoginController implements Initializable {
    
    @FXML
    MFXTextField userName;
    @FXML
    MFXTextField passField;

    @FXML
    Text firstLabel;
    @FXML
    Text secLabel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Timeline t = new Timeline();
      firstLabel.yProperty().set(-10);
      secLabel.yProperty().set(10);
      
      
      t.getKeyFrames().add(new KeyFrame(
                 Duration.seconds(1) ,
      new KeyValue(secLabel.yProperty() , -5)
       ,new KeyValue(firstLabel.yProperty() , 5)
      ));
              
      
        t.getKeyFrames().add(new KeyFrame(
                Duration.seconds(2) ,
        new KeyValue(secLabel.opacityProperty() , 1.0)
        ,new KeyValue(firstLabel.opacityProperty() , 1.0)
               
        )
        
        );
        
        t.play();
        
    }
    
   @FXML
   public void loginPressed(ActionEvent e) throws IOException{
       /*
       Parent root = FXMLLoader.load(getClass().getResource("/UI/OwnerPage/Owner-form.fxml"));
       Scene temp = new Scene(root);
       App.stage.setScene(temp);
       */
       
       
       
   }
    
    
    
}
