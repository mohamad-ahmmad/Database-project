/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.employee;

import com.app.garage.App;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
     private Connection con;
     ArrayList<CardController> conts = new ArrayList<CardController>();
     //ArrayList<Parent> cardArray = new ArrayList<Parent>();
    @FXML
    private Label count;
    
    @FXML
    private MFXButton doneButton;
    
    @FXML
    private AnchorPane view;
    
    @FXML
    private Button btnTest;
   
    private GridPane gridLayout;

    @FXML
    private MFXTextField productID;
    @FXML
    private MFXTextField productAmount;
    @FXML
    private ScrollPane scrollPane;
    
     private String idCard;
    
    private int i,j =0;
    private int counter =0;
    
    //UPDATE THE GRID
    private void update(){
        int i =0,j =0;
         gridLayout.getChildren().clear();
        for(CardController temp : conts)
        {
         gridLayout.add(temp.getCardSkeleton(), j, i);
           
            
            j++;
        if(j == 3){
            i++;
            j=0;
        }
        }
         this.i=i;
         this.j=j;
    }
    
    @FXML
    private void toReceipt() throws IOException{
        //goto receipt
    }
    
    @FXML
    void btnPressed(ActionEvent event) throws IOException, SQLException {
        counter++;
        count.setText(String.valueOf(counter));
        FXMLLoader toload = new FXMLLoader(getClass().getResource("/UI/EmployeePage/dress-card.fxml"));
        Parent temp = toload.load();
        //cardArray.add(temp);
        CardController crd = toload.getController();
        
        Statement st = con.createStatement();
        
       // double ID =Double.parseDouble(productID.getText());
        System.out.println(idCard.substring(1, 4));
        ResultSet dressQry = st.executeQuery(
                "Select d.DRESSID, d.DRESSNAME,d.DRESSSIZE, d.DRESSCOLOR, d.BRANDNAME, d.PRICE, d.PREVIEW, dd.SALEPERCENTAGE,"
                + " dd.DEPARTMENTSTOCK "
                + " from DRESS  d, DEPARTMENT_DRESS  dd "
                + " where d.DRESSID = dd.DRESSID AND dd.DID = "+idCard.substring(1, 4) +" AND dd.DRESSID = "+productID.getText() );//AND
        boolean avaliable = dressQry.next(); 
        
        if(avaliable){
           String amount =productAmount.getText().replace(" ", ""); 
           if(amount.equals(""))
              crd.setAmount("1");
           else
               crd.setAmount(amount);
           
           crd.setColor(dressQry.getString(4));
           crd.setID(dressQry.getDouble(1));
           //crd.setImage(null);
           crd.setName(dressQry.getString(2));
           crd.setPrice(dressQry.getString(6));
           crd.setSale(dressQry.getString(8)+"%");
           crd.setSize(dressQry.getString(3));
           
        }else{
            System.out.println("DOESN'T EXIST.");
        }
        
        
        conts.add(crd);
        
        gridLayout.add((Node)temp , j , i);
        
        j++;
        if(j == 3){
            i++;
            j=0;
        }
    }
    
    @FXML
    void deleteSelectedCards(){
        
       for(int i =conts.size()-1 ; i>=0 ; i--){
           if(conts.get(i).isSelected()){
            conts.remove(i);
            counter--;
            count.setText(String.valueOf(counter));
           }
              
       }
        update();
        
    }
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
             con=DriverManager.getConnection(App.ip, App.user, App.password );
         } catch (SQLException ex) {
             Logger.getLogger(CashierController.class.getName()).log(Level.SEVERE, null, ex);
         }
      
      
// don't set preferred size or anything on gridpane
gridLayout = new GridPane();
// suppose your scroll pane id is scrollPane
scrollPane.setContent(gridLayout);

    }
    
    public void setIdCard(String ID){idCard=ID;}
 
}
