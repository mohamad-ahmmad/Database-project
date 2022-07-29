/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.derpartmentmanager;

import com.app.garage.App;
import com.app.garage.controllers.Owner.LogProfit;
import com.app.garage.controllers.login.LoginController;
import io.github.palexdev.materialfx.controls.MFXTableView;

import io.github.palexdev.materialfx.controls.MFXTableView;
import java.io.IOException;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author USER-M
 */
public class ProfitsController implements Initializable  {

    private Connection con;
    
    @FXML
    private StackedBarChart<?, ?> barChart;

    @FXML
    private TableColumn<LogProfit, Integer> dressAmount;

    @FXML
    private TableColumn<LogProfit, Integer> netProfit;
    
    @FXML
    private TableColumn<LogProfit, String> dressName;

    @FXML
    private LineChart<?, ?> lineChart;

    @FXML
    private PieChart pieChart;

    @FXML
    private TableColumn<LogProfit, Integer> pricePerpiece;

    
    @FXML
    private TableColumn<LogProfit, String> dateCol;
    
    @FXML
    private TextField searchField;

    @FXML
    private TableView<LogProfit> tableView;

    @FXML
    private TableColumn<LogProfit, Integer> totPrice;

    @FXML
    private TableColumn<LogProfit, Integer> wprice;
     
    private ObservableList<LogProfit> list = FXCollections.observableArrayList();
    private void searchAll(int depid) {
        list.clear();
        try {
            con = DriverManager.getConnection(App.ip, App.user, App.password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select d.DRESSNAME, sd.PURCHASED_DATE, sd.AMOUNT, d.WSPRICE, d.PRICE, (d.PRICE * sd.AMOUNT) as TOTALPRICE, (d.PRICE * sd.AMOUNT)-(d.WSPRICE * sd.AMOUNT) AS NETPROFIT  from SELL_RECORD sd join DRESS d on sd.DRESSID =d.DRESSID where sd.DEPID ="+depid);
            
            while(rs.next()){
                String name = rs.getString("DRESSNAME");
                String date = rs.getString("PURCHASED_DATE");
                int amount = rs.getInt("AMOUNT");
                int wsPrice = rs.getInt("WSPRICE");
                int price = rs.getInt("PRICE");
                int totprice = rs.getInt("TOTALPRICE");
                int netprofit = rs.getInt("NETPROFIT");
                
                list.add(new LogProfit(name, date, amount, wsPrice, price, totprice, netprofit));
            }
            
            tableView.setItems(list);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableView.setEditable(true);
        
        dressName.setCellValueFactory(new PropertyValueFactory<>("name"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        dressAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        wprice.setCellValueFactory(new PropertyValueFactory<>("wsprice"));
        pricePerpiece.setCellValueFactory(new PropertyValueFactory<>("price"));
        totPrice.setCellValueFactory(new PropertyValueFactory<>("totPrice"));
        netProfit.setCellValueFactory(new PropertyValueFactory<>("netprofit"));
        

        try {
            //WILL BE HERE FOR EVER.
            con =DriverManager.getConnection(App.ip, App.user, App.password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select DID, SUM(PRICE*AMOUNT) as profit from SELL_RECORD sd join DEPARTMENT on DID=DEPID join DRESS d on d.DRESSID =sd.DRESSID group by DID order by profit  desc");
            XYChart.Series series = new XYChart.Series<>();
            series.setName("Departments");
            int i =0;
            while(rs.next() && i < 4){
                series.getData().add(new XYChart.Data(String.valueOf(rs.getInt("DID")), rs.getInt("profit")));
                
                i++;
            }
            barChart.getData().addAll(series);
            
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
         }
        int depid =Integer.parseInt(LoginController.currentUser.substring(1,4)); 
                    searchAll(depid);
            calculateDepIdLineChart(depid);
            pieChartCalculation(depid);
    }
     
    
    
     private final int[] arrDays={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
     
     private void calculateDepIdLineChart(int depid){

     
        
        XYChart.Series  data = new XYChart.Series();
        
        for(int i=0 ; i<arrDays.length ; i++)
            data.getData().add(new XYChart.Data(Integer.toString(arrDays[i]),profitCalcDay(depid, arrDays[i])));
        
        lineChart.getData().clear();
        lineChart.getData().add(data);
        
    
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
        
            private void pieChartCalculation(int depid) {
        
        try {
            con = DriverManager.getConnection(App.ip, App.user, App.password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select count(sd.DRESSID) as NUMBEROFDRESS,d.DRESSNAME  from sell_record sd join DRESS d on d.DRESSID=sd.DRESSID where Depid = "+depid+" group by d.DRESSNAME order by count(sd.DRESSID) desc ");
            ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList();
            int i =0;
            while( i < 4 && rs.next()  ){
                pieData.add(new PieChart.Data(rs.getString("DRESSNAME"),rs.getInt("NUMBEROFDRESS") ) );
                i++;
            }
          
          
            pieChart.setData(pieData);
            pieChart.setTitle("Top.4 Dress Amount sold");
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
       
        
    }
        
    
}
