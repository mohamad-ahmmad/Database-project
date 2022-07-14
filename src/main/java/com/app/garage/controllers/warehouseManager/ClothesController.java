package com.app.garage.controllers.warehouseManager;

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

public class ClothesController implements Initializable{

    @FXML
    private JFXCheckBox BrandField;
     @FXML
    private JFXCheckBox TypeField;

    @FXML
    private Pane BrandPane;

    @FXML
    private JFXCheckBox ColorField;

    @FXML
    private Pane ColorPane;

    @FXML
    private FlowPane ContactFlow;

    @FXML
    private AnchorPane ContactPane;

    @FXML
    private Pane IDPane;

    @FXML
    private Pane InformationPane;

    @FXML
    private JFXCheckBox LocationField;

    @FXML
    private Pane NamePane;

    @FXML
    private JFXCheckBox PriceField;

    @FXML
    private Pane PricePane;

    @FXML
    private TableColumn<?, ?> SSNCol;

    @FXML
    private Pane SSNPane1;

    @FXML
    private JFXCheckBox ShipmentField;

    @FXML
    private JFXCheckBox SizeField;

    @FXML
    private Pane SizePane;

    @FXML
    private JFXCheckBox StockField;

    @FXML
    private Pane StockPane;

    @FXML
    private JFXCheckBox SupplierField;

    @FXML
    private Pane SupplierPane;

    @FXML
    private JFXCheckBox WSField;

    @FXML
    private Pane WSPricePane;
    @FXML
    private Pane TypePane;

    @FXML
    private TableColumn<?, ?> addressCol;

    @FXML
    private TableColumn<?, ?> bDateCol;

    @FXML
    private TableColumn<?, ?> bDateCol1;

    @FXML
    private TableColumn<?, ?> bDateCol11;

    @FXML
    private TableColumn<?, ?> bDateCol111;

    @FXML
    private TableColumn<?, ?> bDateCol1111;

    @FXML
    private TableColumn<?, ?> bDateCol11111;

    @FXML
    private FlowPane flowPane;

    @FXML
    private Label lblContact;

    @FXML
    private Label lblInfo;

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

    @FXML
    void BrandCheck(ActionEvent event) {
     if(((JFXCheckBox)event.getSource()).isSelected())
    flowPane.getChildren().add(BrandPane);
    else flowPane.getChildren().remove(BrandPane);       

    }

    @FXML
    void ColorCheck(ActionEvent event) {
     if(((JFXCheckBox)event.getSource()).isSelected())
    flowPane.getChildren().add(ColorPane);
    else flowPane.getChildren().remove(ColorPane);       
    }

    @FXML
    void Done(ActionEvent event) {
        searchFilter.setVisible(false);
    }

    @FXML
    void PriceCheck(ActionEvent event) {
    if(((JFXCheckBox)event.getSource()).isSelected())
    flowPane.getChildren().add(PricePane);
    else flowPane.getChildren().remove(PricePane);       
    }


    @FXML
    void SizeCheck(ActionEvent event) {
      if(((JFXCheckBox)event.getSource()).isSelected())
    flowPane.getChildren().add(SizePane);
    else flowPane.getChildren().remove(SizePane);              

    }

    @FXML
    void StockCheck(ActionEvent event) {
     if(((JFXCheckBox)event.getSource()).isSelected())
    flowPane.getChildren().add(StockPane);
    else flowPane.getChildren().remove(StockPane);       
    }

    @FXML
    void SupplierCheck(ActionEvent event) {
     if(((JFXCheckBox)event.getSource()).isSelected())
    flowPane.getChildren().add(SupplierPane);
    else flowPane.getChildren().remove(SupplierPane);       
    }

    @FXML
    void WSCheck(ActionEvent event) {
     if(((JFXCheckBox)event.getSource()).isSelected())
    flowPane.getChildren().add(WSPricePane);
    else flowPane.getChildren().remove(WSPricePane);       
    }
      @FXML
    void TypeCheck(ActionEvent event) {
     if(((JFXCheckBox)event.getSource()).isSelected())
    flowPane.getChildren().add(TypePane);
    else flowPane.getChildren().remove(TypePane);       
    }

    @FXML
    void addClothes(ActionEvent event) throws IOException {
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource("/UI/WarehouseManagerPage/AddClothes.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage(StageStyle.UNDECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void clearFilter(ActionEvent event) {
        SizeField.setSelected(false);
        ColorField.setSelected(false);
        BrandField.setSelected(false);
        WSField.setSelected(false);
        PriceField.setSelected(false);
        TypeField.setSelected(false);
        StockField.setSelected(false);
        SupplierField.setSelected(false);
        flowPane.getChildren().removeAll(NamePane,SizePane,ColorPane,BrandPane,WSPricePane,PricePane,TypePane,StockPane,SupplierPane);
    }

    @FXML
    void openContactPane(MouseEvent event) {
 
        if(InfoSelected)
        {
            InfoSelected=false;
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
        InfoSelected=false;
        });
        }
    }
    boolean InfoSelected=true;
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
      });
        }
    }
    @FXML
    void showSearchFilter(ActionEvent event) {
    searchFilter.setVisible(true);
    }
    
    @FXML
    private AnchorPane InfoslidePane;

    @FXML
    private AnchorPane bigPane;

    @FXML
    private Button btnDoneInfo;

    @FXML
    private Button btnNextInfo;

    @FXML
    void DoneAdding(ActionEvent event) {
   Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
   stage.close();
    }
int i=0;
    @FXML
    void NextInfo(ActionEvent event) throws IOException {
        if(i==3)
        {
            btnNextInfo.setVisible(false);
            btnDoneInfo.setVisible(true);
        }
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource(next.get(i)));
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
        ArrayList<String> next = new ArrayList<>();
        @Override
    public void initialize(URL url, ResourceBundle rb) {
        String size = "/UI/WarehouseManagerPage/EnterSize.fxml";
        String Brand = "/UI/WarehouseManagerPage/EnterBrandName.fxml";
        String Price = "/UI/WarehouseManagerPage/EnterPrice.fxml";
        String Supplier = "/UI/WarehouseManagerPage/EnterSupplier.fxml";
        next.add(size);
        next.add(Brand);
        next.add(Price);
        next.add(Supplier);
        
    }

}
