/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.Owner;


import com.app.garage.controllers.Department;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import java.awt.event.ItemEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.textfield.TextFields;
import org.controlsfx.control.textfield.AutoCompletionBinding;

/**
 *
 * @author USER-M
 */
public class DepartmentController implements Initializable{
    
    private final ObservableList<Department> data = FXCollections.observableArrayList();
    @FXML
    private MFXComboBox<String> myCombo;
    @FXML
    private TableColumn<?, ?> SSNCol;
    @FXML
    private TableColumn<?, ?> addressCol;
    @FXML
    private TableColumn<?, ?> bDateCol;
    @FXML
    private TableColumn<?, ?> nameCol;
    @FXML
    private TableColumn<?, ?> phoneCol;
    @FXML
    private TextField searchField;
    @FXML
    private TableView<Department> tableView;
    public void search() {ObservableList<String> comboNames = FXCollections.observableArrayList();
        comboNames.add(SSNCol.getText());
        comboNames.add(nameCol.getText());
        comboNames.add(addressCol.getText());
        comboNames.add(bDateCol.getText());
        comboNames.add(phoneCol.getText());
        myCombo.setItems(comboNames);
        SSNCol.setCellValueFactory(new PropertyValueFactory<>("SSN"));
        bDateCol.setCellValueFactory(new PropertyValueFactory<>("Birthdate"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("Address"));
        Department D1=  new Department(122,"Test Name","Test Adress","Birthdate",12345);
        Department D2=  new Department(123,"new NAme","new Adress","new Birthdate",1122233);
        Department D3=  new Department(124,"Name","Adress","4q23412",987645);
        Department D4=  new Department(121,"Test ","Test","12/12/5122",5681332);
        data.addAll(D1,D2,D3,D4);
        FilteredList<Department> filteredlist = new FilteredList<>(data,b->true);
        searchField.textProperty().addListener((observable, oldValue,newValue)-> {
        String st = myCombo.getSelectedItem(); //SSN
        filteredlist.setPredicate(department -> {
        if(newValue==null || newValue.isBlank() || newValue.isEmpty())
            return true;
        String LowerCaseFilter = newValue.toLowerCase();
        if(st==null)
                {
        if(department.getName().toLowerCase().indexOf(LowerCaseFilter)!=-1) return true;
        else if(department.getAddress().toLowerCase().indexOf(LowerCaseFilter)!=-1) return true;
        else  if(department.getBirthdate().toLowerCase().indexOf(LowerCaseFilter)!=-1) return true;
        else  if(String.valueOf(department.getSSN()).toLowerCase().indexOf(LowerCaseFilter)!=-1) return true;
        else  if(String.valueOf(department.getPhone()).toLowerCase().indexOf(LowerCaseFilter)!=-1) return true;
       else return false;
                }
        if(st.equalsIgnoreCase("name") && department.getName().toLowerCase().indexOf(LowerCaseFilter)!=-1) return true;
        else if(st.equalsIgnoreCase("address") && department.getAddress().toLowerCase().indexOf(LowerCaseFilter)!=-1) return true;
        else  if(st.equalsIgnoreCase("Birthdate") && department.getBirthdate().toLowerCase().indexOf(LowerCaseFilter)!=-1) return true;
        else  if(st.equalsIgnoreCase("SSN") && String.valueOf(department.getSSN()).toLowerCase().indexOf(LowerCaseFilter)!=-1) return true;
        else  if(st.equalsIgnoreCase("phonenumber") && String.valueOf(department.getPhone()).toLowerCase().indexOf(LowerCaseFilter)!=-1) return true;
       else return false;
        }); 
        });
        SortedList<Department> sortedList = new SortedList<>(filteredlist);
        sortedList.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedList);
}

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        search();
    }
}
