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

public class SuppliersController implements Initializable{

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
    private Label lblContact;
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
    private JFXCheckBox EmailField;
    @FXML
    private JFXCheckBox NameField;
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
    private JFXCheckBox ShipmentField;
     @FXML
    private JFXCheckBox LocationField;
      @FXML
    private JFXCheckBox TelephoneField;
    @FXML
   void clearContactFilter(){
       LocationField.setSelected(false);
       ShipmentField.setSelected(false);
       searchFilterContact.setVisible(false);
       ContactFlow.getChildren().removeAll(ShipmentPane,LocationPane);
   }
     @FXML
    private Pane TelephoneNumberPane;
     @FXML
    private Pane EmailPane;

    
    @FXML
    private Pane NamePane;
     @FXML
    private Pane LocationPane;
     @FXML
     private Pane ShipmentPane;

    @FXML
    void LocationCheck(ActionEvent event) {
     if(((JFXCheckBox)event.getSource()).isSelected())
    ContactFlow.getChildren().add(LocationPane);
    else ContactFlow.getChildren().remove(LocationPane);
    }
     @FXML
    void ShipmentCheck(ActionEvent event) {
     if(((JFXCheckBox)event.getSource()).isSelected())
    ContactFlow.getChildren().add(ShipmentPane);
    else ContactFlow.getChildren().remove(ShipmentPane);
    }
    
    @FXML
    void NameCheck(ActionEvent event) {
     if(((JFXCheckBox)event.getSource()).isSelected())
    flowPane.getChildren().add(NamePane);
    else flowPane.getChildren().remove(NamePane);
    }
    @FXML
    void TelephoneNumberCheck(ActionEvent event) {
     if(((JFXCheckBox)event.getSource()).isSelected())
    flowPane.getChildren().add(TelephoneNumberPane);
    else flowPane.getChildren().remove(TelephoneNumberPane);
    }
    
    @FXML
    void EmailCheck(ActionEvent event) {
     if(((JFXCheckBox)event.getSource()).isSelected())
    flowPane.getChildren().add(EmailPane);
    else flowPane.getChildren().remove(EmailPane);
    }

    @FXML
    void clearFilter(ActionEvent event) {  
    flowPane.getChildren().removeAll(NamePane,EmailPane,TelephoneNumberPane);
    NameField.setSelected(false);
    TelephoneField.setSelected(false);
    EmailField.setSelected(false);
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
    
     @FXML
    void showContactFilter(ActionEvent event) throws IOException {
        searchFilterContact.setVisible(true);
    }
    @FXML
     void addInfo(ActionEvent event) throws IOException {
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource("/UI/WarehouseManagerPage/AddInfo.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage(StageStyle.UNDECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
         
     }
    
 @FXML
    void addSupplier(ActionEvent event) throws IOException {
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource("/UI/WarehouseManagerPage/AddSupplier.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage(StageStyle.UNDECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(root);
             stage.setScene(scene);
             stage.show();
    }
    int i=0;
    ArrayList<String> next = new ArrayList<>();
    ArrayList<String> nextInfo = new ArrayList<>();
    @FXML
    private Button btnNext;
    @FXML
    private Button btnDone;
    @FXML
    private Button btnNextInfo;
    @FXML
    private Button btnDoneInfo;
    @FXML
    void DoneAdding(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
    @FXML
    void NextInfo(ActionEvent event) throws IOException {
         if(i==1)
        {
            btnNextInfo.setVisible(false);
            btnDoneInfo.setVisible(true);
        }
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource(nextInfo.get(i)));
        Parent root = loader.load();
        InfoslidePane.getChildren().add(root);
        
        root.translateXProperty().set(500);
        Timeline t = new Timeline();
        t.getKeyFrames().add(new KeyFrame(Duration.seconds(0.2),
                 new KeyValue(root.translateXProperty(),0),
                new KeyValue(InfoslidePane.getChildren().get(0).translateYProperty(),200)));
        t.play();
        t.setOnFinished(e->{
        InfoslidePane.getChildren().remove(0);});
                  i++;

        
    }
     @FXML
    void Next(ActionEvent event) throws IOException {
       
         if(i==0)
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
        String ShipmentCost = "/UI/WarehouseManagerPage/EnterShipmentCost.fxml";
        String Location = "/UI/WarehouseManagerPage/Location.fxml";
        String name = "/UI/WarehouseManagerPage/EnterName.fxml";
        next.add(name);
        nextInfo.add(Location);
        nextInfo.add(ShipmentCost);
    }
    boolean InfoSelected = false;
    boolean SupplierSelected = false;
        @FXML
    void openContactPane(MouseEvent event) {
       
        if(!SupplierSelected){
        SupplierSelected=true;
        lblContact.setStyle("-fx-text-fill: #F8A918");
        lblInfo.setStyle("-fx-text-fill: #aeaeae");
        ContactPane.translateXProperty().set(850);
        ContactPane.setVisible(true);
        Timeline t = new Timeline();
        t.getKeyFrames().add(new KeyFrame(Duration.seconds(0.3),
        new KeyValue(ContactPane.translateXProperty(),0),
        new KeyValue(InformationPane.translateXProperty(),-850)));
        t.play();
         t.setOnFinished(e->{
        SupplierSelected=true;
        InfoSelected=false;});
        }
    }
        @FXML
    void openInformationPane(MouseEvent event) {
        if(!InfoSelected)
        {
        InfoSelected=true;
        lblInfo.setStyle("-fx-text-fill: #F8A918");
        lblContact.setStyle("-fx-text-fill: #aeaeae");
        Timeline t = new Timeline();
        t.getKeyFrames().add(new KeyFrame(Duration.seconds(0.3),
        new KeyValue(InformationPane.translateXProperty(),0),
        new KeyValue(ContactPane.translateXProperty(),850)));
        t.play();
        t.setOnFinished(e->{
        InfoSelected=true;
        SupplierSelected=false;});
        }
    }

}
