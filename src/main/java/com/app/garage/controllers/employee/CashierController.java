/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.employee;


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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

import javafx.scene.text.Text;
import javafx.util.Duration;

public class CashierController implements Initializable {
     
     ArrayList<CardController> conts = new ArrayList<CardController>();
     ArrayList<Parent> cardArray = new ArrayList<Parent>();
    @FXML
    private Label count;
     
    @FXML
    private AnchorPane view;
    @FXML
    private Button btnTest;
   
    private GridPane gridLayout;

    @FXML
    private ScrollPane scrollPane;
    
    private int i,j =0;
    private int counter =0;
    
    //UPDATE THE GRID
    private void update(){
        
    }
    
    @FXML
    private void toReceipt() throws IOException{
        //goto receipt
    }
    
    @FXML
    void btnPressed(ActionEvent event) throws IOException {
        counter++;
        count.setText(String.valueOf(counter));
        FXMLLoader toload = new FXMLLoader(getClass().getResource("/UI/EmployeePage/dress-card.fxml"));
        Parent temp = toload.load();
        cardArray.add(temp);
        conts.add(toload.getController());
        
        gridLayout.add((Node)temp , j , i);
        
        j++;
        if(j == 3){
            i++;
            j=0;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
            ColumnConstraints columnConstraints = new ColumnConstraints();
columnConstraints.setHgrow(Priority.NEVER);

// create new constraints for row and set their percentage
RowConstraints rowConstraints = new RowConstraints();
rowConstraints.setVgrow(Priority.NEVER);


// don't set preferred size or anything on gridpane
gridLayout = new GridPane();  
gridLayout.getRowConstraints().add(rowConstraints);
gridLayout.getColumnConstraints().add(columnConstraints);

// suppose your scroll pane id is scrollPane
scrollPane.setContent(gridLayout);

    
   

    }
    

}
