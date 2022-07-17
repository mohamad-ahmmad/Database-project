package com.app.garage.controllers.derpartmentmanager;

import com.jfoenix.controls.JFXCheckBox;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ClothesController implements Initializable {

    @FXML
    private TextField brandField;

    @FXML
    private Pane brandPane;

    @FXML
    private FlowPane flowPane;
    @FXML
    private TextField colorField;

    @FXML
    private Pane colorPane;

    @FXML
    private TextField dressID;

    @FXML
    private AnchorPane filterPanee;

    @FXML
    private DatePicker historyField;

    @FXML
    private Pane historyPane;

    @FXML
    private TextField idField;

    @FXML
    private Pane idPane;

    @FXML
    private TextField nameField;

    @FXML
    private Pane namePane;

    @FXML
    private TextField priceField;

    @FXML
    private Pane pricePane;

    @FXML
    private TextField quantity;

    @FXML
    private TextField sizeField;

    @FXML
    private Pane sizePane;

    @FXML
    private Pane stockPane;

    @FXML
    private TextField wPriceField;

    @FXML
    private Pane wPricePane;
    
    
    private boolean isSelectedCheckBox(ActionEvent event){
        return ((JFXCheckBox)event.getSource()).isSelected();
    }

    @FXML
    void deleteButton(ActionEvent event) {

    }
    private Parent root;
    private boolean added = false;
    @FXML
    void filterButton(ActionEvent event) throws IOException {
      if(!added)
      {FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/DepartmentManagerPage/SearchFilter.fxml"));
     loader.setController(this);
      root = loader.load();
     filterPanee.getChildren().add(root);
      added=true;
      }else
      {filterPanee.setVisible(true);}    
        
    }
     
   

    @FXML
    void showPreview(ActionEvent event) {

    }

    
    @FXML
    void Done(ActionEvent event) {
       filterPanee.setVisible(false);
    }

   


    @FXML
    void brandCheck(ActionEvent event) {
        if(isSelectedCheckBox(event))
            flowPane.getChildren().add(brandPane);
        else flowPane.getChildren().remove(brandPane);
    }

    @FXML
    void colorCheck(ActionEvent event) {
  if(isSelectedCheckBox(event))
            flowPane.getChildren().add(colorPane);
        else flowPane.getChildren().remove(colorPane);
    }

    @FXML
    void historyCheck(ActionEvent event) {
  if(isSelectedCheckBox(event))
            flowPane.getChildren().add(historyPane);
        else flowPane.getChildren().remove(historyPane);
    }

    @FXML
    void nameCheck(ActionEvent event) {
  if(isSelectedCheckBox(event))
            flowPane.getChildren().add(namePane);
        else flowPane.getChildren().remove(namePane);
    }

    @FXML
    void priceCheck(ActionEvent event) {
  if(isSelectedCheckBox(event))
            flowPane.getChildren().add(pricePane);
        else flowPane.getChildren().remove(pricePane);
        
    }

    @FXML
    void sizeChick(ActionEvent event) {
  if(isSelectedCheckBox(event))
            flowPane.getChildren().add(sizePane);
        else flowPane.getChildren().remove(sizePane);
    }

    @FXML
    void stockCheck(ActionEvent event) {
  if(isSelectedCheckBox(event))
            flowPane.getChildren().add(stockPane);
        else flowPane.getChildren().remove(stockPane);
    }

    @FXML
    void wPriceCheck(ActionEvent event) {
       if(isSelectedCheckBox(event))
            flowPane.getChildren().add(wPricePane);
        else flowPane.getChildren().remove(wPricePane);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }
    
    
    //STAGE ----
     Stage temp;
    @FXML
    void importButton(ActionEvent event) throws IOException {
        
      temp = new Stage();
        
        temp.initModality(Modality.APPLICATION_MODAL);
           temp.initStyle(StageStyle.TRANSPARENT);
        
      FXMLLoader loader =new FXMLLoader(getClass().getResource("/UI/DepartmentManagerPage/import/main_frame.fxml"));
      loader.setController(this);
      Parent root = loader.load();
      Scene s = new Scene(root);
      temp.setScene(s);
      temp.show();
        
    }
    @FXML
    private AnchorPane currPane;

    @FXML
    private MFXTextField clothID;

    @FXML
    private AnchorPane mainPane;

  

    @FXML
    private MFXTextField stockField;

    @FXML
    private MFXTextField wID;

    @FXML
    void cancel(ActionEvent event) {
    temp.close();
    }

    @FXML
    void finish(ActionEvent event) {
    
    }
    
}
