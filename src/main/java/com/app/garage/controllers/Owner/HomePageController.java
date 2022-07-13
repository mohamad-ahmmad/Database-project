/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.Owner;


import com.app.garage.controllers.EmailSender;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import com.jfoenix;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class HomePageController implements Initializable {
    
    
    
    
   
    
    @FXML
    AnchorPane nextPane;
    @FXML
    AnchorPane currentPane;
    
    @FXML
    Pane leftArrow;
    @FXML  
    Pane rightArrow;
    
    
    private boolean animationFlag = true;
    private int index = 0;
    private boolean clrFlag = true;
    
    private void clear(){
        currentPane.getChildren().remove(0);
        clrFlag=!clrFlag;
    }
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            SliderInitialize();
            currentPane.getChildren().add(CardsSlider.cards.get(0).getParent());
            
     
           
            
            
        } catch (IOException ex) {
            System.out.println("Problems with loading the home-page-template.fxml");
        }
    
    }
    private void swap(){
        AnchorPane temp;
        temp = nextPane;
        nextPane = currentPane;
        currentPane = temp;
        
    }
        @FXML
    void leftArrowPressed(MouseEvent event) {
      
        if(animationFlag){
            if(index == 0){
                nextPane.getChildren().removeAll(nextPane.getChildren());
                int size=CardsSlider.cards.size()-1;
               nextPane.getChildren().add(CardsSlider.cards.get(size).getParent());
               index = size;
            }else{
                nextPane.getChildren().removeAll(nextPane.getChildren());
                index--;
                nextPane.getChildren().add(CardsSlider.cards.get(index).getParent());
                
            }
            
            
            
            animationFlag = !animationFlag;
        nextPane.setLayoutX(currentPane.getLayoutX()-810);
              TranslateTransition transitionCurr = new TranslateTransition();
                transitionCurr.setDuration(Duration.seconds(1));
                transitionCurr.setNode(currentPane);
                transitionCurr.setInterpolator(Interpolator.EASE_BOTH);
                transitionCurr.setByX(+810);
                
                    TranslateTransition transitionNext = new TranslateTransition();
                transitionNext.setDuration(Duration.seconds(1));
                transitionNext.setNode(nextPane);
                transitionNext.setInterpolator(Interpolator.EASE_BOTH);
                transitionNext.setByX(+810);
                
                transitionCurr.play();
                transitionNext.play();
                
                transitionNext.setOnFinished(e->{
                animationFlag=!animationFlag;
                swap();
                
                
                
                
                });
                
        }
        

    }

    @FXML
    void rightArrowPressed(MouseEvent event) {
      
         if(animationFlag){
              int size=CardsSlider.cards.size()-1;
               
                if(index ==size ){
                  index = 0;
                  nextPane.getChildren().removeAll(nextPane.getChildren());
                  nextPane.getChildren().add(CardsSlider.cards.get(index).getParent());
             
            }else{
                index++;
                nextPane.getChildren().removeAll(nextPane.getChildren());
                nextPane.getChildren().add(CardsSlider.cards.get(index).getParent());
                
            }
                
            animationFlag = !animationFlag;
      nextPane.setLayoutX(currentPane.getLayoutX()+810);
              TranslateTransition transitionCurr = new TranslateTransition();
                transitionCurr.setDuration(Duration.seconds(1));
                transitionCurr.setNode(currentPane);
                transitionCurr.setInterpolator(Interpolator.EASE_BOTH);
                transitionCurr.setByX(-810);
                
                    TranslateTransition transitionNext = new TranslateTransition();
                transitionNext.setDuration(Duration.seconds(1));
                transitionNext.setNode(nextPane);
                transitionNext.setInterpolator(Interpolator.EASE_BOTH);
                transitionNext.setByX(-810);
                
                transitionCurr.play();
                transitionNext.play();
                
                transitionNext.setOnFinished(e->{
                animationFlag=!animationFlag;
                swap();
                });
                
        }
    }
    

    private void SliderInitialize() throws IOException {
        //DATABASE PROCCESSING AND GETTING THE SLIDES IN THE SLIDER READY
        for(int i = 0 ; i < 3 ; i++){
        CardsSlider temp = new CardsSlider((i+1)+". Department Name");
        
    }
        
    }
    
    }

    
 

