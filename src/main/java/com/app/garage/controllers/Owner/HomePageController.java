/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.Owner;


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

    
   /*
    @FXML
    AnchorPane img;
    @FXML
    ImageView prevImg;
    @FXML
    ImageView nextImg;
    @FXML
    Button btn;
    @FXML
    ImageView temp;
    private TranslateTransition translateNext;
    boolean flag = true;

    @FXML
    GridPane grid;

    private double x,y; //The location of temp image.
    private double wid = 1225;
    private ArrayList<Image> imgArr = new ArrayList<Image>();
    private int currentState;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        prevImg.setScaleX(0.85);
        prevImg.setScaleY(0.85);
        temp.setScaleX(0.85);
        temp.setScaleY(0.85);
        nextImg.setScaleX(0.85);
        nextImg.setScaleY(0.85);

        DropShadow imgsDropShadow= (DropShadow) img.getEffect();

        nextImg.setEffect(imgsDropShadow);
        prevImg.setEffect(imgsDropShadow);
        temp.setEffect(imgsDropShadow);



    }

    @FXML
     public void leftArrow(MouseEvent e) throws InterruptedException {
            if(flag) {
                flag=!flag;
                TranslateTransition transition = new TranslateTransition();
                transition.setDuration(Duration.seconds(1));
                transition.setNode(img);
                transition.setInterpolator(Interpolator.EASE_BOTH);
                transition.setByX(-550);

                //Scale Transition to the left and minimize the photo.
                ScaleTransition imgScale = new ScaleTransition(Duration.seconds(1), img);
                imgScale.setToX(0.85);
                imgScale.setToY(0.85);
                //imgScale.setDelay(Duration.seconds(0.05));
                imgScale.setInterpolator(Interpolator.EASE_BOTH);


                //playing the two animations.
                imgScale.play();
                transition.play();


                //animating prevImg
                TranslateTransition translatePrev = new TranslateTransition(Duration.seconds(1), prevImg);
                translatePrev.setByX(-550);
                ScaleTransition prevScale = new ScaleTransition(Duration.seconds(1), prevImg);
                prevScale.setToX(1);
                prevScale.setToY(1);

                translatePrev.play();
                prevScale.play();

                //animating nextImg
                 translateNext = new TranslateTransition(Duration.seconds(1), nextImg);
                translateNext.setByX(-550);
                translateNext.play();

                //animating temp
                TranslateTransition translateTemp = new TranslateTransition(Duration.seconds(1), temp);
                translateTemp.setByX(-550);
                translateTemp.play();

                translateTemp.setOnFinished(es ->{
                    flag=!flag;
                });
                //switching();


            }



    }

    private void switchToRight(){
        ImageView t = prevImg;
        prevImg = img;
        img = nextImg;
        nextImg = temp;
        temp = t;



    }
    private void switching() {
        ImageView t = img;
        img = prevImg;
        prevImg = temp;
        temp = nextImg;
        nextImg = t;

        translateNext.setOnFinished(e->{
            temp.setLayoutX(prevImg.getLayoutX()+550);
            temp.setLayoutY(115);

        });




        //temp.setImage(new Image(String.valueOf(getClass().getResource("/ICONS/right-arrow.png"))));



    }

    public void selectPhotos(MouseEvent mouseEvent) {
        FileChooser fileChooser = new FileChooser();
        Stage temp = new Stage();
        File f = fileChooser.showOpenDialog(temp);
        System.out.println(String.valueOf(f.toURI()));
        if(f == null){
            System.out.println("Please Choose a File !!");
        }else{
            Image imgToAddArr = new Image(String.valueOf(f.toURI()));
            imgArr.add(imgToAddArr);

            if(imgArr.size()==1)
               img.setImage(imgArr.get(0));
            else if (imgArr.size()==2)
               prevImg.setImage(imgArr.get(1));


        }
    }

    public void rightArrow(MouseEvent mouseEvent) {

        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(1));
        transition.setNode(img);
        transition.setInterpolator(Interpolator.EASE_BOTH);
        transition.setByX(550);

        //Scale Transition to the left and minimize the photo.
        ScaleTransition imgScale = new ScaleTransition(Duration.seconds(1) , img);
        imgScale.setToX(0.85);
        imgScale.setToY(0.85);
        //imgScale.setDelay(Duration.seconds(0.05));
        imgScale.setInterpolator(Interpolator.EASE_BOTH);


        //playing the two animations.
        imgScale.play();
        transition.play();


        //animating prevImg
        TranslateTransition translatePrev = new TranslateTransition(Duration.seconds(1) ,prevImg);
        translatePrev.setByX(550);
        ScaleTransition prevScale = new ScaleTransition(Duration.seconds(1),nextImg);
        prevScale.setToX(1);
        prevScale.setToY(1);

        translatePrev.play();
        prevScale.play();

        //animating nextImg
        TranslateTransition translateNext = new TranslateTransition(Duration.seconds(1) , nextImg);
        translateNext.setByX(550);
        translateNext.play();

        //animating temp
        TranslateTransition translateTemp = new TranslateTransition(Duration.seconds(1),temp);
        translateTemp.setByX(550);
        translateTemp.play();

       // switchToRight();
    }
   */


