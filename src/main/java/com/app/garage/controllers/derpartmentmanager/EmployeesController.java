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

public class EmployeesController implements Initializable{

    @FXML
    private Pane BirthDatePane;

    @FXML
    private Pane FirstNamePane;

    @FXML
    private Pane GenderPane;

    @FXML
    private Pane HireDatePane;

    @FXML
    private Pane IDCardPane;
    @FXML
    private Label lblContact;

    @FXML
    private Label lblInfo;


    @FXML
    private Pane LastNamePane;

    @FXML
    private Pane MiddleNamePane;

    @FXML
    private TableColumn<?, ?> SSNCol;

    @FXML
    private Pane SSNPane;

    @FXML
    private Pane SalaryPane;

    @FXML
    private TableColumn<?, ?> addressCol;

    @FXML
    private TableColumn<?, ?> bDateCol;

    @FXML
    private JFXCheckBox bdField;

    @FXML
    private FlowPane flowPane;

    @FXML
    private JFXCheckBox fnameField;

    @FXML
    private JFXCheckBox genderField;

    @FXML
    private JFXCheckBox hdField;

    @FXML
    private JFXCheckBox idField;

    @FXML
    private JFXCheckBox lnameField;
    @FXML
    private AnchorPane ContactPane;
    @FXML
    private Pane InformationPane;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private JFXCheckBox mnameField;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TableColumn<?, ?> phoneCol;

    @FXML
    private JFXCheckBox salaryField;

    @FXML
    private AnchorPane searchFilter;

    @FXML
    private TableView<?> tableView;
    
    @FXML
    void clearFilter(ActionEvent event) {
        fnameField.setSelected(false);
        mnameField.setSelected(false);
        lnameField.setSelected(false);
        genderField.setSelected(false);
        salaryField.setSelected(false);
        bdField.setSelected(false);
        hdField.setSelected(false);
        idField.setSelected(false);
        flowPane.getChildren().removeAll(FirstNamePane,MiddleNamePane,LastNamePane,SalaryPane,GenderPane,IDCardPane,HireDatePane,BirthDatePane);
    }
    public void clearSearch() throws IOException{
        searchFilter.getChildren().clear();
   }
    Stage stage;
    private Parent root;
   @FXML
    void Done(ActionEvent event) throws IOException {
         searchFilter.setVisible(false);
    }

    @FXML
    void showSearchFilter(ActionEvent event) throws IOException {
        searchFilter.setVisible(true);
    }
    

    @FXML
    void FirstNameCheck(ActionEvent event) {
     if(fnameField.isSelected())
    flowPane.getChildren().add(FirstNamePane);
    else flowPane.getChildren().remove(FirstNamePane);
    }

    @FXML
    void MiddleNameCheck(ActionEvent event) {
    if(mnameField.isSelected())
    flowPane.getChildren().add(MiddleNamePane);
    else flowPane.getChildren().remove(MiddleNamePane);
    }

    @FXML
    void LastNameCheck(ActionEvent event) {
    if(lnameField.isSelected())
    flowPane.getChildren().add(LastNamePane);
    else flowPane.getChildren().remove(LastNamePane);
    }
       @FXML
    void SalaryCheck(ActionEvent event) {
    if(salaryField.isSelected())
    flowPane.getChildren().add(SalaryPane);
    else flowPane.getChildren().remove(SalaryPane);
    }

    @FXML
    void BirthDateCheck(ActionEvent event) {
    if(bdField.isSelected())
    flowPane.getChildren().add(BirthDatePane);
    else flowPane.getChildren().remove(BirthDatePane);
    }

    @FXML
    void HireDateCheck(ActionEvent event) {
    if(hdField.isSelected())
    flowPane.getChildren().add(HireDatePane);
    else flowPane.getChildren().remove(HireDatePane);
    }
    @FXML
    void IDCardCheck(ActionEvent event) {
    if(idField.isSelected())
    flowPane.getChildren().add(IDCardPane);
    else flowPane.getChildren().remove(IDCardPane);
    }
      @FXML
    void GenderCheck(ActionEvent event) {
    if(genderField.isSelected())
    flowPane.getChildren().add(GenderPane);
    else flowPane.getChildren().remove(GenderPane);
    }
    
 @FXML
    void addDepartment(ActionEvent event) throws IOException {
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource("/UI/OwnerPage/AddDepartment.fxml"));
        Parent root = loader.load();
        
        Stage stage = new Stage(StageStyle.UNDECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(root);
             stage.setScene(scene);
             stage.show();
    }
    int i=0;
    ArrayList<String> next = new ArrayList<>();
    @FXML
    private Button btnNext;
    @FXML
    private Button btnDone;
    @FXML
    void DoneAdding(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
     @FXML
    void Next(ActionEvent event) throws IOException {
       /*
         if(i==2)
        {
            btnNext.setVisible(false);
            btnDone.setVisible(true);
        }
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource(next.get(i)));
        Parent root = loader.load();
        slidePane.getChildren().add(root);
        
        root.translateXProperty().set(500);
        Timeline t = new Timeline();
        t.getKeyFrames().add(new KeyFrame(Duration.seconds(0.2),
                 new KeyValue(root.translateXProperty(),0),
                new KeyValue(slidePane.getChildren().get(0).translateYProperty(),200)));
        t.play();
        t.setOnFinished(e->{
        slidePane.getChildren().remove(0);});
                  i++;*/

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String name = "/UI/OwnerPage/EnterName.fxml";
        String Location = "/UI/OwnerPage/Location.fxml";
        String ManagerID = "/UI/OwnerPage/ManagerID.fxml";
        next.add(name);
        next.add(Location);
        next.add(ManagerID);
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
