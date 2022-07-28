/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.Owner;


import com.app.garage.App;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Month;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.scene.input.MouseEvent;

import javafx.util.Duration;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


public class HomePageController implements Initializable {
    private Connection con;
    
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
            
            DataInitilaizer();
            
     
           
            
            
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
                transitionCurr.setDuration(Duration.seconds(0.5));
                transitionCurr.setNode(currentPane);
                transitionCurr.setInterpolator(Interpolator.EASE_BOTH);
                transitionCurr.setByX(+810);
                
                    TranslateTransition transitionNext = new TranslateTransition();
                transitionNext.setDuration(Duration.seconds(0.5));
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
                transitionCurr.setDuration(Duration.seconds(0.5));
                transitionCurr.setNode(currentPane);
                transitionCurr.setInterpolator(Interpolator.EASE_BOTH);
                transitionCurr.setByX(-810);
                
                    TranslateTransition transitionNext = new TranslateTransition();
                transitionNext.setDuration(Duration.seconds(0.5));
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
    
    private long profitCalc(long depId){
        
        //SQL
        
        return 0;
    }
    
    private long profitCalcDay(int depId, int day){
       
        try {
            con = DriverManager.getConnection(App.ip, App.user, App.password );
            Statement st = con.createStatement();
            /*
            select s.dressid, (ds.PRICE-(ds.PRICE* ((select salepercentage from department_dress dd where dd.did=114 AND dd.dressid=s.dressid )/100) ) ) * AMOUNT as SOLD 
            from SELL_RECORD s join Dress ds on s.dressid = ds.dressid 
            where s.depid=114 and s.purchased_date like '%21-JUL%' ; 
            111411 (1,4)
            */
            Date s = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY");
            String currentDate = formatter.format(s);
            
            ResultSet result = st.executeQuery("select (ds.PRICE-(ds.PRICE* ((select salepercentage from department_dress dd where dd.did="+depId+" AND dd.dressid=s.dressid )/100) )-ds.WSPRICE ) * AMOUNT as SOLD " 
                    + " from SELL_RECORD s join Dress ds on s.dressid = ds.dressid "
                    + " where s.depid="+depId+" and s.purchased_date like '"+String.format("%02d", day)+ "-"+currentDate.substring(3,5)+"-"+currentDate.substring(6,10)+"%' ");
            
     
            long sum=0;
            
            
            
            while(result.next()){
                long temp = result.getLong(1);
                sum=sum+temp;
            }
            
            con.close();
            return sum;
        } catch (SQLException ex) {
            
            Alert s = new Alert(Alert.AlertType.ERROR);
            s.setTitle("Something Wrong !");
            s.setContentText("Contact the developers.");
             
            ex.printStackTrace();
          
        }
        return 1;
       
    }
    
   
    private int[] arrDays={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
    private int[] topDep; 
    int i=0;
    private void DataInitilaizer() {
        
        
        determinesTopDep();
        
        for(int i =0 ; i < this.i;i++){
            CardsSlider.cards.get(i).setID(topDep[i]);
            calculateSliderData(CardsSlider.cards.get(i));
            departmentInformationInit(CardsSlider.cards.get(i));
            pieChartCalculation(CardsSlider.cards.get(i));
        }
        
        
    }

    private void calculateSliderData(CardsSlider slide ) {
     
        LineChart ref =  slide.getSlideController().getLineChart();
        XYChart.Series  data = new XYChart.Series();
        
        for(int i=0 ; i<arrDays.length ; i++)
            data.getData().add(new XYChart.Data(Integer.toString(arrDays[i]),profitCalcDay(slide.getID(), arrDays[i])));
        
        ref.getData().add(data);
        
    }

    private void determinesTopDep() {
        topDep= new int[3];
        try {
            con = DriverManager.getConnection(App.ip, App.user, App.password);
            Statement st = con.createStatement();
            ResultSet result = st.executeQuery("select DEPID , SUM(AMOUNT) as aa from SELL_RECORD GROUP BY DEPID ORDER BY aa desc");
            
            i=0;
            while(result.next() && i < 3 ){
                topDep[i]=result.getInt(1);
                i++;
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }

    private void departmentInformationInit(CardsSlider temp) {
        try {
            //SQL QURIES TO GET THE NAME TELEPHONE NUMBER EMAIL...ETC AND ANY THING NOT NUMERIC RELATED TO THE DEPARTMENT
            con = DriverManager.getConnection(App.ip, App.user, App.password);
            Statement inf = con.createStatement();
            ResultSet q = inf.executeQuery("select DNAME, Country,City from Department where DID ="+temp.getID());
            SliderController s = temp.getSlideController();
            if(q.next()){
            
            s.getTextLocationSite().setText(q.getString(2)+", "+q.getString(3));
            s.getHeader().setText(q.getString(1));
            }
            ResultSet Manager = inf.executeQuery("select FIRSTNAME, LASTNAME from Employee where DEPID="+temp.getID()+" AND ETYPE = 'manager'");
           if(Manager.next()) 
            s.getTextManagerName().setText(Manager.getString(1)+" "+Manager.getString(2));
            
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }

    private void pieChartCalculation(CardsSlider get) {
        
        try {
            con = DriverManager.getConnection(App.ip, App.user, App.password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select count(sd.DRESSID) as NUMBEROFDRESS,d.DRESSNAME  from sell_record sd join DRESS d on d.DRESSID=sd.DRESSID where Depid = "+get.getID()+" group by d.DRESSNAME order by count(sd.DRESSID) desc ");
            ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList();
            int i =0;
            while( i < 4 && rs.next()  ){
                pieData.add(new PieChart.Data(rs.getString("DRESSNAME"),rs.getInt("NUMBEROFDRESS") ) );
                i++;
            }
          
          
            get.getSlideController().getPieChart().setData(pieData);
            get.getSlideController().getPieChart().setTitle("Top.4 Dress Amount sold");
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    }

    
 

