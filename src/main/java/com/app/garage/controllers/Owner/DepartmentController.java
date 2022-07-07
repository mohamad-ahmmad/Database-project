package com.app.garage.controllers.Owner;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class DepartmentController {

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
    private AnchorPane mainPane;

    @FXML
    void clearFilter(ActionEvent event) {

    }
    public void clearSearch() throws IOException{
        searchFilter.getChildren().clear();
        
   }
    private Parent root;
   @FXML
    void Done(ActionEvent event) throws IOException {
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource("/UI/OwnerPage/DepartmentsPage.fxml"));
        root = loader.load();
        mainPane = loader.getRoot();
        mainPane.getChildren().clear();
        mainPane.getChildren().setAll(root);

    }

    @FXML
    void showSearchFilter(ActionEvent event) throws IOException {
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource("/UI/OwnerPage/SearchFilter.fxml"));
        Parent root = loader.load();
        searchFilter.getChildren().add(root);
    }

}
