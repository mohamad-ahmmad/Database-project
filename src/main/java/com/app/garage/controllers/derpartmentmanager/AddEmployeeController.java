package com.app.garage.controllers.derpartmentmanager;

import com.app.garage.App;
import com.app.garage.controllers.login.LoginController;
import com.jfoenix.controls.JFXCheckBox;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.controls.legacy.MFXLegacyComboBox;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.scene.control.DatePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AddEmployeeController implements Initializable {

    private Connection con;
    
    
    
    private AnchorPane mainPane;
    
    @FXML
    private Label errorLabel;
    
    @FXML
    private AnchorPane secPane;


    @FXML
    private DatePicker birthDate;

    @FXML
    private DatePicker hireDate;
    
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
    
    private void submitData(){
        try {
            con = DriverManager.getConnection(App.ip, App.user, App.password);
            Statement st = con.createStatement();
//(3901820192, 'Mhammad', 'Azmi','Ahmad',to_date('23-05-2021','dd-mm-yyyy'),to_date('14-02-2002','dd-mm-yyyy'),'m',5500,311403,'warehouse','admin123',null,null);
            String empIdCard = empPass.equals("cash123")?"1":"4";
            String empIdCard2 = empIdCard + LoginController.currentUser.substring(1,4)+String.format("%02d", empCard);
            String type = empPass.equals("cash123")?"cashier":"assistant";
            
            st.executeUpdate("insert into EMPLOYEE values( "+empSsn+" ,'"+empFirst+"', '"+empMiddle
                    +        "', '"+empLast+"', to_date('"+empBirth+"','yyyy-mm-dd'), to_date('"+empHire+"','yyyy-mm-dd') "
                    +        ", '"+empGender+"', "+empSal+", "+empIdCard2+", '"+type+"', '"+empPass+"', null ,"+LoginController.currentUser.substring(1,4)+", null  )");
            
            if(sectionTextField.equals("")){
                
            }else
            {
              st.executeUpdate("insert into EMPLOYEE(SSN, SECTION) values ("+empSsn+", '"+sectionTextField.getText()+"') ");
            }
            
       
            
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    int i = 0;
    private void nextPaneLoad() throws IOException{
      if(i == 2){
     thisStage.close();
      submitData();
     return;
     }
      
     
      
     if(i == 1)
         nextBtn.setText("Done");
  
         
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
    /*DATABASE DATA*/
    private String empSsn;
    private String empFirst;
    private String empMiddle;
    private String empLast;
    
    private String empHire;
    private String empBirth;
    private String empGender;
    private int empCard;
    private String empPass;
    private int empSal;
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
               empSsn = ssn.getText();
               empFirst = firstName.getText();
               empMiddle = middleName.getText();
               empLast = lastName.getText();
          }
        }
        
        else if(i==1){
             
             try{
                           empHire = hireDate.getValue().toString().replace("/", "-");
              empBirth = birthDate.getValue().toString().replace("/", "-");
             } catch(Exception e){
                 errorLabel.setVisible(true);
                 return false;
                 
             }

              
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
        boolean idCardCheck = idCard.getText().length()!=2;
        if(idCardCheck)
        {
            mistakeBorder(idCard, idCardCheck);
            return false;
        }
        empGender = femaleCheckBox.isSelected()? "f":"m";
        empCard = Integer.parseInt(idCard.getText());
        empPass = cashierCheckBox.isSelected()?"cash123":null;
        empSal = Integer.parseInt(salary.getText());
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
           
        
        ssn.setTooltip(new Tooltip("Consist of 10 digits."));
        firstName.setTooltip(new Tooltip("This field can not be empty"));
        lastName.setTooltip(new Tooltip("This field can not be empty"));
        
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
         maleCheckBox.setSelected(!maleCheckBox.isSelected());
         }
         else if((JFXCheckBox)event.getSource() == maleCheckBox)
         {
         femaleCheckBox.setSelected(!femaleCheckBox.isSelected());
         }
    }
    
    @FXML
    private JFXCheckBox cashierCheckBox;
    @FXML
    private MFXTextField sectionTextField;
    
    @FXML
    private JFXCheckBox assistantCheckBox;
    
        @FXML
    void typeCheckBox(ActionEvent event) {
         if((JFXCheckBox)event.getSource() == cashierCheckBox)
         {
         assistantCheckBox.setSelected(!assistantCheckBox.isSelected());
         sectionTextField.setText("");
         sectionTextField.setVisible(false);
         }
         else if((JFXCheckBox)event.getSource() == assistantCheckBox)
         {
         cashierCheckBox.setSelected(!cashierCheckBox.isSelected());
         
         sectionTextField.setVisible(true);
         
         }
    }
    
    
    
    @FXML
    private MFXTextField salary;
    
    @FXML
    private MFXTextField idCard;
    
    
    
    

}
