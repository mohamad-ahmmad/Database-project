/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.Owner;
<<<<<<< HEAD
import io.github.palexdev.materialfx.controls.MFXTableView;
=======

import io.github.palexdev.materialfx.controls.MFXTableView;
import java.io.IOException;
>>>>>>> 0f492e2969e648cc86a3e1ffbc48ba06aea211a4
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;

/**
 *
 * @author USER-M
 */
public class ProfitsController implements Initializable  {
    @FXML
    private PieChart pieChart;
<<<<<<< HEAD
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
            ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                    new PieChart.Data("Sample 1" ,25 ),
                    new PieChart.Data("Sample 2" , 25),
                    new PieChart.Data("Sample 3", 25),
                    new PieChart.Data("Sample 4", 25)
            );
            pieChart.setTitle("Example Title");
            pieChart.setData(pieChartData);
=======
    @FXML
    private MFXTableView profitTable;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
        new PieChart.Data("Sample 1" ,25 ),
         new PieChart.Data("Sample 2" , 25),
          new PieChart.Data("Sample 3", 25),
           new PieChart.Data("Sample 4", 25)
         );
        pieChart.setTitle("Example Title");
        pieChart.setData(pieChartData);
>>>>>>> 0f492e2969e648cc86a3e1ffbc48ba06aea211a4
    }
    
}
