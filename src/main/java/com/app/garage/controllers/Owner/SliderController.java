/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.Owner;



import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.text.Text;

public class SliderController implements Initializable {

    @FXML
    private Text header;
    @FXML
    private Text locationSite;

    @FXML
    private Text managerName;

    @FXML
    private PieChart pieChart;

    @FXML
    private StackedBarChart<?, ?> stackChar;//

    @FXML
    private Text teleNum;
    
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
    
    public Text getTextLocationSite(){
        return locationSite;
    }
    public Text getTextManagerName(){
        return managerName;
    }
    public Text getTextTelephoneNumber(){
        return teleNum;
    }
    public PieChart getPieChart(){
        return pieChart;
    }
    public StackedBarChart getStackChart(){//MABYE CAUSES PROBLEMS
        
        return stackChar;
    }
    public Text getHeader(){
        return header;
    }
    
    
}
