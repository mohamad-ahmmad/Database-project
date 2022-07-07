package com.app.garage.controllers.Owner;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DepartmentController implements Initializable{

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
    private Pane openingPane;

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

    }
    public void clearSearch() throws IOException{
        searchFilter.getChildren().clear();
        
   }
    private Parent filterUI;
   @FXML
    void Done(ActionEvent event) throws IOException { 
       searchPane.setVisible(false);
       
    }
    
    @FXML
    void showSearchFilter(ActionEvent event) throws IOException {
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource("/UI/OwnerPage/SearchFilter.fxml"));
        filterUI = loader.load();
        searchFilter.getChildren().add(filterUI);
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }

}
