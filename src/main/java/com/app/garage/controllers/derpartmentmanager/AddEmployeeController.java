package com.app.garage.controllers.derpartmentmanager;

import com.jfoenix.controls.JFXCheckBox;
import io.github.palexdev.materialfx.controls.MFXButton;

import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.controls.legacy.MFXLegacyComboBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.beans.property.Property;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AddEmployeeController implements Initializable {

    
    private AnchorPane mainPane;
    @FXML
    private AnchorPane secPane;

    @FXML
    private MFXDatePicker birthDate;

    @FXML
    private MFXDatePicker hireDate;
    
    @FXML
    private MFXLegacyComboBox<String> gender;
    @FXML
    private MFXTextField firstName;

    @FXML
    private MFXTextField lastName;

    @FXML
    private MFXTextField middleName;

    @FXML
    private MFXTextField ssn;
    
    
    @FXML
    private AnchorPane currPane;

    @FXML
    private AnchorPane nextPane;
    
    Stage thisStage;
    
    @FXML
    void cancel(ActionEvent event) {
     thisStage = (Stage) (((Node)event.getSource()).getScene().getWindow());
    thisStage.close();
    }
    
    private void getData(){
        
    }
    
    int i = 0;
    private void nextPaneLoad() throws IOException{
      if(i == 2){
     thisStage.close();
      getData();
     return;
     }
      
     
      
     if(i == 1)
         nextBtn.setText("Finish");
  
         
        FXMLLoader loader = new FXMLLoader(getClass().getResource(arrFXML[i]));
        loader.setController(this);
        Parent root = loader.load();
        nextPane.getChildren().clear();
        nextPane.getChildren().add(root);
        
        i++;
    }
     
    private void swap(){
        AnchorPane temp;
        temp = nextPane;
        nextPane=currPane;
        currPane=temp;
        nextPane.setLayoutX(currPane.getLayoutX()+389);
        
    }
    
    private void mistakeBorder (MFXTextField temp , boolean check){
        if(check)
        temp.setStyle("-fx-border-color:rgba(255,0,0,0.4)");
        else temp.setStyle("");
    }
    
    private boolean check (int i){
        if(i == 0){
            boolean ssnLength = (ssn.getText().length()!=10);
            boolean fnameLength = (firstName.getText().length()<=0);
            boolean lnameLength = (lastName.getText().length()<= 0);
          if( ssnLength || fnameLength || lnameLength ){
              
                mistakeBorder(ssn, ssnLength);
                mistakeBorder(firstName, fnameLength);
                mistakeBorder(lastName, lnameLength);
                   
                   
              return false;
          }else{
              try{
                mistakeBorder(firstName, fnameLength);
                mistakeBorder(lastName, lnameLength);
                 Double.parseDouble(ssn.getText());
              }
              catch(Exception e){ 
               ssn.setStyle("-fx-border-color:#FF7F50");
               return false;
              }
              //HERE YOU CAN SAVE THE DATA OF THE FIRST FXML; CONNECTION ETC...
               
          }
        }
        
        else if(i==1){
         
            
        }
        else if(i == 2){
                
            try{
                Double.parseDouble(idCard.getText());
                 mistakeBorder(salary, false);
            }catch(Exception e){
                mistakeBorder(idCard, true);
                try{
                     Double.parseDouble(salary.getText());
                      mistakeBorder(salary, false);
                }catch(Exception ex){
                    mistakeBorder(salary, true);
                }
                return false;
            }
        boolean idCardCheck = idCard.getText().length()!=6;
        if(idCardCheck)
        {
            mistakeBorder(idCard, idCardCheck);
            return false;
        }
        
        
    }
        return true;
    }
    
    private boolean finished = true;
    @FXML
    void next(ActionEvent event) throws IOException {
        thisStage = (Stage) (((Node)event.getSource()).getScene().getWindow());
      
        if(finished && check(i)){
            finished=!finished;
      TranslateTransition transitionCurr = new TranslateTransition();
                transitionCurr.setDuration(Duration.seconds(0.5));
                transitionCurr.setNode(currPane);
                transitionCurr.setInterpolator(Interpolator.EASE_BOTH);
                transitionCurr.setByX(-389);
                
      nextPaneLoad();
      TranslateTransition transitionNextPane = new TranslateTransition();
      transitionNextPane.setDuration(Duration.seconds(0.5));
      transitionNextPane.setNode(nextPane);
      transitionNextPane.setInterpolator(Interpolator.EASE_BOTH);
      transitionNextPane.setByX(-389);
      
      transitionCurr.play();
      transitionNextPane.play();
      transitionNextPane.setOnFinished(e ->{
      finished=!finished;
      swap();
      });
                
        }
    }

     @FXML
    private MFXButton nextBtn;
     
     String [] arrFXML;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        arrFXML = new String[2];
        arrFXML[0]="/UI/DepartmentManagerPage/add_employee/sec_form.fxml";
        arrFXML[1]="/UI/DepartmentManagerPage/add_employee/third_form.fxml";
           
        
     
        
    }
    
    
    
    //THIRD -- FORM -- FXML
    @FXML
    private JFXCheckBox femaleCheckBox;

    @FXML
    private JFXCheckBox maleCheckBox;
    
    @FXML
    void checkBoxSelected(ActionEvent event) {
         if((JFXCheckBox)event.getSource() == femaleCheckBox)
         {
         maleCheckBox.setSelected(false);
         }
         else if((JFXCheckBox)event.getSource() == maleCheckBox)
         {
         femaleCheckBox.setSelected(false);
         }
    }
    
    
    
    @FXML
    private MFXTextField salary;
    
    @FXML
    private MFXTextField idCard;


}
