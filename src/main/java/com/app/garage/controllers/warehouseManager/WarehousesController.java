package com.app.garage.controllers.warehouseManager;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXRadioButton;
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

public class WarehousesController implements Initializable{

    @FXML
    private Pane BirthDatePane;

    @FXML
    private Pane OfficeTelephonePane;

    @FXML
    private Pane GenderPane;

    @FXML
    private Pane HireDatePane;

    @FXML
    private Pane IDCardPane;
    @FXML
    private Label lblClothes;
    @FXML
    private AnchorPane slidePane;
    @FXML
    private AnchorPane InfoslidePane;
    @FXML
    private Label lblInfo;
    @FXML
    private TableColumn<?, ?> SSNCol;

    @FXML
    private TableColumn<?, ?> addressCol;

    @FXML
    private TableColumn<?, ?> bDateCol;
    @FXML
    private FlowPane flowPane;
    @FXML
    private FlowPane ContactFlow;
    @FXML
    private JFXCheckBox LocationField;
    @FXML
    private JFXCheckBox NameField;
    @FXML
    private JFXCheckBox CapacityField;
    @FXML
    private AnchorPane ContactPane;
    @FXML
    private Pane InformationPane;


    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TableColumn<?, ?> phoneCol;

    @FXML
    private JFXCheckBox salaryField;

    @FXML
    private AnchorPane searchFilter;
    @FXML
    private AnchorPane searchFilterContact;
    @FXML
    private TableView<?> tableView;

    @FXML
    private Pane LocationPane;
    @FXML
    private Pane NamePane;
    @FXML
    private Pane CapacityPane;

    @FXML
    void CapacityCheck(ActionEvent event) {
     if(((JFXCheckBox)event.getSource()).isSelected())
    flowPane.getChildren().add(CapacityPane);
    else flowPane.getChildren().remove(CapacityPane);
    }
     @FXML
    void NameCheck(ActionEvent event) {
     if(((JFXCheckBox)event.getSource()).isSelected())
    flowPane.getChildren().add(NamePane);
    else flowPane.getChildren().remove(NamePane);
    }
    
    @FXML
    void LocationCheck(ActionEvent event) {
     if(((JFXCheckBox)event.getSource()).isSelected())
    flowPane.getChildren().add(LocationPane);
    else flowPane.getChildren().remove(LocationPane);
    }
    @FXML
    void clearFilter(ActionEvent event) {  
    flowPane.getChildren().removeAll(NamePane,LocationPane,CapacityPane);
    NameField.setSelected(false);
    CapacityField.setSelected(false);
    LocationField.setSelected(false);
    searchFilter.setVisible(false);
    }
    @FXML
    void DoneContact(ActionEvent event) throws IOException {
         searchFilterContact.setVisible(false);
    }
   @FXML
    void Done(ActionEvent event) throws IOException {
         searchFilter.setVisible(false);
    }

    
    @FXML
    void showSearchFilter(ActionEvent event) {  
    searchFilter.setVisible(true);
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
 

}
