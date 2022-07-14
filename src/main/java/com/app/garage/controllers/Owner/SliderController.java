/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.Owner;



import com.app.garage.controllers.EmailSender;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
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

      @FXML 
    void emailClicked(ActionEvent event) throws IOException, URISyntaxException {
<<<<<<< HEAD
          Alert temporary = new Alert(Alert.AlertType.INFORMATION);
       temporary.setContentText("Email Succsesfully Copied.");
       temporary.show();
       
          Button s = new Button();
          
        
=======
         
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
>>>>>>> bb44defe1c4cd93635b0be6678cc48bc4b7170a5
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
    public StackedBarChart getStackChart(){//MABYE CAUSES PROBLEMS
        
        return stackChar;
    }
    public Text getHeader(){
        return header;
    }
    
    
}
