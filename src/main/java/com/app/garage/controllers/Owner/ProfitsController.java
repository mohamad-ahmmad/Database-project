/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.Owner;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
    }

    
}
