package com.app.garage.controllers.Owner;

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

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;


public class WarehousesController implements Initializable{

    @FXML
    private Pane IDPane;

    @FXML
    private TableColumn<?, ?> SSNCol;

    @FXML
    private TableColumn<?, ?> addressCol;

    @FXML
    private TableColumn<?, ?> bDateCol;

    @FXML
    private Pane cityPane;

    @FXML
    private Pane countryPane;

    @FXML
    private FlowPane flowPane;

    @FXML
    private Pane managerPane;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private Pane namePane;

    @FXML
    private Pane CapacityPane;

    @FXML
    private TableColumn<?, ?> phoneCol;

    @FXML
    private  AnchorPane searchFilter;

    @FXML
    private Pane streetPane;

    @FXML
    private TableView<?> tableView;
    
    
    
    @FXML
    private AnchorPane searchPane;
    @FXML
    void clearFilter(ActionEvent event) {
        nameField.setSelected(false);
        countryField.setSelected(false);
        cityField.setSelected(false);
        streetField.setSelected(false);
        managerField.setSelected(false);
        CapacityField.setSelected(false);
        flowPane.getChildren().removeAll(namePane,cityPane,streetPane,countryPane,managerPane,CapacityPane);
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
    void cityCheck(ActionEvent event) {
     if(cityField.isSelected())
    flowPane.getChildren().add(cityPane);
    else flowPane.getChildren().remove(cityPane);
    }

    @FXML
    void countryCheck(ActionEvent event) {
    if(countryField.isSelected())
    flowPane.getChildren().add(countryPane);
    else flowPane.getChildren().remove(countryPane);
    }

    @FXML
    void managerIDCheck(ActionEvent event) {
    if(managerField.isSelected())
    flowPane.getChildren().add(managerPane);
    else flowPane.getChildren().remove(managerPane);
    }
       @FXML
    void nameCheck(ActionEvent event) {
    if(nameField.isSelected())
    flowPane.getChildren().add(namePane);
    else flowPane.getChildren().remove(namePane);
    }

    @FXML
    void opencapacityCheck(ActionEvent event) {
    if(CapacityField.isSelected())
    flowPane.getChildren().add(CapacityPane);
    else flowPane.getChildren().remove(CapacityPane);
    }

    @FXML
    void streetCheck(ActionEvent event) {
    if(streetField.isSelected())
    flowPane.getChildren().add(streetPane);
    else flowPane.getChildren().remove(streetPane);
    }
    
    @FXML
    private JFXCheckBox IDcheckField;
    @FXML
    private JFXCheckBox nameField;
    @FXML
    private JFXCheckBox countryField;
    @FXML
    private JFXCheckBox cityField;
    @FXML
    private JFXCheckBox streetField;
    @FXML
    private JFXCheckBox CapacityField;
    @FXML
    private JFXCheckBox managerField;
    @FXML
    private AnchorPane slidePane;
    
    FXMLLoader loader;
     @FXML
    void addWarehouse(ActionEvent event) throws IOException {

        loader = new FXMLLoader(getClass().getResource("/UI/OwnerPage/AddWarehouse.fxml"));
        Parent root = loader.load();
        
        Stage stage = new Stage(StageStyle.UNDECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(root);
             stage.setScene(scene);
             stage.show();
    }
    
 @FXML
    void addDepartment(ActionEvent event) throws IOException {

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
                  i++;


    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        String name = "/UI/OwnerPage/EnterWHName.fxml";
        String Location = "/UI/OwnerPage/WHLocation.fxml";
        String ManagerID = "/UI/OwnerPage/ManagerID.fxml";
        next.add(name);
        next.add(Location);
        next.add(ManagerID);

    }

}
