/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.employee;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author USER-M
 */
public class CardController implements Initializable {
    
    public CardController(){
        
    }
    private boolean selected =false;
    
    @FXML
    private AnchorPane cardFrame;
     
    @FXML
    private AnchorPane cardPane;
    
    private long dressID;
    
    @FXML
    private Label amountNum;
    
    @FXML
    private ImageView image;
    
    @FXML
    private Label dressName;
    
    @FXML
    private Label dressColor;
    
    @FXML
    private Label dressSize;
    
    @FXML
    private Label dressPrice;
    
    @FXML
    private Label dressSale;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       cardFrame.opacityProperty().set(0.95);
       //image.setImage(new Image(String.valueOf(getClass().getResource("/UI/OwnerPage/HomePageAssets/MSI.jpg"))));
    }
    
    public void setImage(String url){
       
        image.setImage(new Image(String.valueOf(getClass().getResource(url))));

    }
    public void setAmount(String num){
        amountNum.setText(num);
    }
    
    public void setSelect (boolean temp){
        selected=temp;
    }
    
    @FXML
    void paneClicked(MouseEvent event) {
        if(!selected){
                    cardFrame.opacityProperty().set(1);
                    cardPane.setStyle("-fx-border-color:#F8A918");
        }

        else{
            cardFrame.opacityProperty().set(0.95);
            cardPane.setStyle("");
           
        }

        
       selected=!selected;
    }
    public boolean isSelected(){
        
        return selected;
    }
    public AnchorPane getCardSkeleton(){
        return cardFrame;  
    }
    public void setName(String str){
        this.dressName.setText(str);//The dress name sometimes will act and discribe several things
    }
    public void setColor (String str){
        this.dressColor.setText(str);//No COmment
    }
    public void setSize (String str){
        this.dressSize.setText(str);//NO COMMENTS
    }
    public void setPrice(String str){
        this.dressPrice.setText(str);//the price will be driven from the sale and the real price
    }
      public void setSale(String str){
          this.dressSale.setText(str);//don't forget the % symbol
      }
      
      public void setID (long id){
         dressID = id;
      }
      public long getID(){
          return dressID;
      }
      public String getAmount(){
          return amountNum.getText();
      }
      public String getPrice(){
          return dressPrice.getText();
      }
      public String getSale(){
          return dressSale.getText();
      }
      
}
