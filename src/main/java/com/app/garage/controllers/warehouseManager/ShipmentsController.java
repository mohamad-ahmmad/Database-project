package com.app.garage.controllers.warehouseManager;

import com.jfoenix.controls.JFXCheckBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class ShipmentsController {

    @FXML
    private JFXCheckBox CostField;

    @FXML
    private Pane CostPane;

    @FXML
    private JFXCheckBox DateField;

    @FXML
    private Pane DatePane;

    @FXML
    private Pane IDPane;

    @FXML
    private TableColumn<?, ?> SSNCol;

    @FXML
    private JFXCheckBox SupplierField;

    @FXML
    private Pane SupplierPane;

    @FXML
    private TableColumn<?, ?> addressCol;

    @FXML
    private TableColumn<?, ?> addressCol1;

    @FXML
    private FlowPane flowPane;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private AnchorPane searchFilter;

    @FXML
    private TableView<?> tableView;

    @FXML
    void CostCheck(ActionEvent event) {
  if(((JFXCheckBox)event.getSource()).isSelected())
    flowPane.getChildren().add(CostPane);
    else flowPane.getChildren().remove(CostPane);
    }

    @FXML
    void DateCheck(ActionEvent event) {
  if(((JFXCheckBox)event.getSource()).isSelected())
    flowPane.getChildren().add(DatePane);
    else flowPane.getChildren().remove(DatePane);
    }

    @FXML
    void Done(ActionEvent event) {
      searchFilter.setVisible(false);
    }

    @FXML
    void SupplierCheck(ActionEvent event) {
  if(((JFXCheckBox)event.getSource()).isSelected())
    flowPane.getChildren().add(SupplierPane);
    else flowPane.getChildren().remove(SupplierPane);
    }

    @FXML
    void clearFilter(ActionEvent event) {
    flowPane.getChildren().removeAll(DatePane,CostPane,SupplierPane);
    SupplierField.setSelected(false);
    DateField.setSelected(false);
    CostField.setSelected(false);
    searchFilter.setVisible(false);
    }

    @FXML
    void showSearchFilter(ActionEvent event) {
    searchFilter.setVisible(true);
    }

}
