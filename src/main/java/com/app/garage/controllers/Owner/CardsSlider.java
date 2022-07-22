/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.Owner;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 *
 * @author USER-M
 */
public class CardsSlider {
    public static ArrayList<CardsSlider> cards = new ArrayList<CardsSlider>();
   // final private static URL templateURL = (CardsSlider.class.getClass().getResource("/UI/OwnerPage/HomePageAssets/home-page-template.fxml")) ;
    private SliderController control;
    private Parent cardUI;
    private int id;
  
    public CardsSlider(String Title) throws IOException{
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource("/UI/OwnerPage/HomePageAssets/home-page-template.fxml"));
       
        cardUI = loader.load();
        
        control = loader.getController();
        control.getHeader().setText(Title);
        
        cards.add(this);
        
    }
    public CardsSlider() throws IOException{
        /* FXMLLoader loader;
        loader = new FXMLLoader(templateURL);
        cardUI = loader.load();
        control = loader.getController();
        
        */
        cards.add(this);
    }
    
      public Parent getParent(){
        return cardUI;
    }
    
    public SliderController getSlideController(){
        return control;
    }
    
    public void setID(int id){
        this.id=id;
    }
    
    public int getID(){
        return this.id;
    }
    
}
