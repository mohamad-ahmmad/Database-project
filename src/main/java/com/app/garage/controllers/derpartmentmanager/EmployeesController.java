/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.derpartmentmanager;

/**
 *
 * @author USER-M
 */
import com.jfoenix.controls.JFXCheckBox;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import com.jfoenix.controls.JFXCheckBox;

public class EmployeesController implements Initializable{

 
     @FXML
    private Pane BirthDatePane;

    @FXML
    private FlowPane ContactFlow;

    @FXML
    private AnchorPane ContactPane;

    @FXML
    private Pane FirstNamePane;

    @FXML
    private Pane GenderPane;

    @FXML
    private Pane HireDatePane;

    @FXML
    private Pane IDCardPane;

    @FXML
    private Pane InformationPane;

    @FXML
    private Pane LastNamePane;

    @FXML
    private JFXCheckBox LocationField;

    @FXML
    private Pane MiddleNamePane;

    @FXML
    private JFXCheckBox PhoneField;

    @FXML
    private TableColumn<?, ?> SSNCol;

    @FXML
    private Pane SSNPane;

    @FXML
    private Pane SSNPane1;

    @FXML
    private TableColumn<?, ?> SalCol;

    @FXML
    private Pane SalaryPane;

    @FXML
    private TableColumn<?, ?> birthDateCol;

    @FXML
    private FlowPane flowPane;

    @FXML
    private TableColumn<?, ?> genderCol;

    @FXML
    private TableColumn<?, ?> hireDateCol;

    @FXML
    private TableColumn<?, ?> idCol;

    @FXML
    private TableColumn<?, ?> lNameCol;

    @FXML
    private Label lblContact;

    @FXML
    private Label lblInfo;

    @FXML
    private TableColumn<?, ?> mNameCol;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private AnchorPane searchFilter;

    @FXML
    private AnchorPane searchFilterContact;

    @FXML
    private TableView<?> tableView;

    private boolean isSelected (ActionEvent event){
        JFXCheckBox s = (JFXCheckBox)(event.getSource());
        return  s.isSelected();
    }
    
    @FXML
    void BirthDateCheck(ActionEvent event) {
          
        if( isSelected(event) )
            flowPane.getChildren().add(BirthDatePane);
        else
           flowPane.getChildren().remove(BirthDatePane);
        
    }

    @FXML
    void Done(ActionEvent event) {
        searchFilter.setVisible(false);
        searchFilterOpened=!searchFilterOpened;
    }

    

    @FXML
    void FirstNameCheck(ActionEvent event) {
       if( isSelected(event) )
            flowPane.getChildren().add(FirstNamePane);
        else
           flowPane.getChildren().remove(FirstNamePane);
        
    }

    @FXML
    void GenderCheck(ActionEvent event) {
       if( isSelected(event) )
            flowPane.getChildren().add(GenderPane);
        else
           flowPane.getChildren().remove(GenderPane);
        
    }

    @FXML
    void HireDateCheck(ActionEvent event) {
       if( isSelected(event) )
            flowPane.getChildren().add(HireDatePane);
        else
           flowPane.getChildren().remove(HireDatePane);
        
       
    }

    @FXML
    void IDCardCheck(ActionEvent event) {
       if( isSelected(event) )
            flowPane.getChildren().add(IDCardPane);
        else
           flowPane.getChildren().remove(IDCardPane);
        
    }

    @FXML
    void LastNameCheck(ActionEvent event) {
       if( isSelected(event) )
            flowPane.getChildren().add(LastNamePane);
        else
           flowPane.getChildren().remove(LastNamePane);
        
    }

  

    @FXML
    void MiddleNameCheck(ActionEvent event) {
       if( isSelected(event) )
            flowPane.getChildren().add(MiddleNamePane);
        else
           flowPane.getChildren().remove(MiddleNamePane);
        
    }
  

    @FXML
    void SalaryCheck(ActionEvent event) {
       if( isSelected(event) )
            flowPane.getChildren().add(SalaryPane);
        else
           flowPane.getChildren().remove(SalaryPane);
        
    }

    @FXML
    void LocationCheck(ActionEvent event) {

    }
    @FXML
    void PhoneCheck(ActionEvent event) {

    }
@FXML
    void DoneContact(ActionEvent event) {

    }
    @FXML
    void addEmployee(ActionEvent event) throws IOException {

       Stage logout = new Stage();
       logout.initModality(Modality.APPLICATION_MODAL);
       logout.initStyle(StageStyle.UNDECORATED);
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/DepartmentManagerPage/add_employee/main_frame.fxml"));
       Parent root = loader.load();
       
       Scene logoutScene = new Scene(root);
       logout.setScene(logoutScene);
       logout.show();
       

    }
    @FXML
    void deleteEmployee(ActionEvent event) {

    }

    @FXML
    void addInfo(ActionEvent event) {

    }

    @FXML
    void clearContactFilter(ActionEvent event) {

    }

    @FXML
    void clearFilter(ActionEvent event) {
      flowPane.getChildren().clear();
      flowPane.getChildren().add(SSNPane);
    }

    
    @FXML
    void showContactFilter(ActionEvent event) {

    }
     
    private boolean searchFilterOpened =false;
    @FXML
    void showSearchFilter(ActionEvent event) {
        if(!searchFilterOpened)
            searchFilter.setVisible(true);
        else
            searchFilter.setVisible(false);
        
        searchFilterOpened=!searchFilterOpened;
    }

 
 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       /* String Phone = "/UI/OwnerPage/EnterPhoneNum.fxml";
        String Location = "/UI/OwnerPage/EnterLocation.fxml";
        String name = "/UI/OwnerPage/EnterEmployeeName.fxml";
        String salary = "/UI/OwnerPage/EnterSalary.fxml";
        String hireDate = "/UI/OwnerPage/EnterHireDate.fxml";
        String Idcard = "/UI/OwnerPage/EnterIDCard.fxml";
        String type = "/UI/OwnerPage/type.fxml";
        next.add(name);
        next.add(salary);
        next.add(Idcard);
        next.add(type);
        nextInfo.add(Phone);
        nextInfo.add(Location);*/
    }
    
    boolean InfoSelected = true;
        @FXML
    void openContactPane(MouseEvent event) {
        lblContact.setStyle("-fx-text-fill: #F8A918");
        lblInfo.setStyle("-fx-text-fill: #aeaeae");
        if(InfoSelected)
        {
        ContactPane.translateXProperty().set(850);
        ContactPane.setVisible(true);
        Timeline t = new Timeline();
        t.getKeyFrames().add(new KeyFrame(Duration.seconds(0.3),
        new KeyValue(ContactPane.translateXProperty(),0),
        new KeyValue(InformationPane.translateXProperty(),-850)));
        t.play();
         t.setOnFinished(e->{
        InfoSelected=false;});
        }
    }
        @FXML
    void openInformationPane(MouseEvent event) {
        
        lblInfo.setStyle("-fx-text-fill: #F8A918");
        lblContact.setStyle("-fx-text-fill: #aeaeae");
        if(!InfoSelected)
        {
        Timeline t = new Timeline();
        t.getKeyFrames().add(new KeyFrame(Duration.seconds(0.3),
        new KeyValue(InformationPane.translateXProperty(),0),
        new KeyValue(ContactPane.translateXProperty(),850)));
        t.play();
        t.setOnFinished(e->{
        InfoSelected=true;});
        }
    }

}
