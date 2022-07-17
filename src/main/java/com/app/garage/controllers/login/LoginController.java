/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.login;

import com.app.garage.App;
import io.github.palexdev.materialfx.controls.MFXTextField;
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
import javafx.stage.Stage;
import javafx.util.Duration;




/**
 *
 * @author USER-M
 */


public class LoginController implements Initializable {
    private final String ownerUser = "Owner",ownerPassword="123456";
    
    private Connection con;
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
        try {
            con = DriverManager.getConnection(App.ip, App.user, App.password);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Connection Failed.");
        }
        firstLabel.opacityProperty().set(0);
        secLabel.opacityProperty().set(0);
        
        Timeline t = new Timeline();
      firstLabel.yProperty().set(-10);
      secLabel.yProperty().set(10);
      
      
      t.getKeyFrames().add(new KeyFrame(
                 Duration.seconds(2) ,
      new KeyValue(secLabel.yProperty() , -5)
       ,new KeyValue(firstLabel.yProperty() , 5)
      ));
              
      
        t.getKeyFrames().add(new KeyFrame(
                Duration.seconds(3) ,
        new KeyValue(secLabel.opacityProperty() , 1.0)
        ,new KeyValue(firstLabel.opacityProperty() , 1.0)
               
        )
        
        );
        
        t.play();
        
    }
    
    private void load(String URL) throws IOException{
       
           FXMLLoader loader = new FXMLLoader(getClass().getResource(URL));
           Parent root = loader.load();
           Stage appStage =  App.getAppStage();
           appStage.hide();
           appStage.setScene(new Scene(root));
           appStage.show();
           return;
    }
    
   @FXML
   public void loginPressed(ActionEvent e) throws IOException{
         String user = userName.getText();
         String password = passField.getText();
       if(user.equals(ownerUser) && password.equals(ownerPassword)){
           System.out.println("Loging to Owner");
           FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/OwnerPage/Owner-form.fxml"));
           Parent root = loader.load();
           Stage appStage =  App.getAppStage();
           appStage.hide();
           appStage.setScene(new Scene(root));
           appStage.show();
           return;
       }
       
       
        try {
          
            String qry=
            "select epassword,etype from employee where IDCARD ="+user;
            
            Statement st = con.createStatement();
            ResultSet loginQry = st.executeQuery(qry);
            loginQry.next();
            String qryPass = loginQry.getString(1);
            System.out.println("qry");
            
            if(qryPass.equals(password)){
                String eType = loginQry.getString(2);
                if(eType.equals("warehouse")){
                    load("/UI/WarehouseManagerPage/warehousemanager-form.fxml");
                    return;
                }
                else if (eType.equals("manager")){
                    load("/UI/DepartmentManagerPage/manager-page.fxml");
                    return;
                }
                else if(eType.equals("cashier")){
                    load("/UI/EmployeePage/employee-page.fxml");
                    return;
                }
            }else{
                     userName.setStyle("-fx-border-color: rgba(248,0,0,0.4);");
                     passField.setStyle("-fx-border-color: rgba(248,0,0,0.4);");
                }
            
            
             
        } catch (SQLException ex) {
            ex.printStackTrace();
         
        }
      
       
       
       
   }
    
    
    
}
