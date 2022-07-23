/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.Owner;



import com.app.garage.App;
import com.app.garage.controllers.EmailSender;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.controlsfx.control.HiddenSidesPane;
import org.controlsfx.control.Notifications;

public class SliderController implements Initializable {

    
     @FXML
    private Hyperlink empEmail;
    @FXML
    private Text header;
    @FXML
    private Text locationSite;

    @FXML
    private Text managerName;

    @FXML
    private PieChart pieChart;

    @FXML
    private LineChart lineChart;//

    @FXML
    private Text teleNum;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     
       
        
        
                ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
        new PieChart.Data("Sample 1" ,25 )      
         );
          try {      
              Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
              Statement stmt = con.createStatement();
              String depName;   
              
              
              
         ResultSet rs = stmt.executeQuery("SELECT DName FROM Department");
        
        while(rs.next()) {
        depName = rs.getString("DName");
            pieChartData.add(new PieChart.Data(depName ,25 ) );
        } 
        
        
          }
        catch (SQLException ex) {
              ex.printStackTrace();
          }
       
        pieChart.setTitle("Departments Profits");
        pieChart.setData(pieChartData);
    }

      @FXML 
    void emailClicked(ActionEvent event) throws IOException, URISyntaxException {

         
       Notifications notifications = Notifications.create()
               .title("Email copied").text("Link Copied Succefully")
               .graphic(null)
               .hideAfter(Duration.seconds(3))
               .position(Pos.BOTTOM_RIGHT)
               .onAction(new EventHandler<ActionEvent>(){
               @Override
               public void handle(ActionEvent event){
                   System.out.println("test");
               }
        });
       notifications.darkStyle();
       notifications.showInformation();

       EmailSender.openBrowser(empEmail.getText().split("@")[1]);
       EmailSender.clipBoardText(empEmail.getText());
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
    public LineChart getLineChart(){//MABYE CAUSES PROBLEMS
        
        return lineChart;
    }
    public Text getHeader(){
        return header;
    }
    public Hyperlink getHyperLink(){
        return empEmail;
    }
    
    
}
