/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.employee;

import com.app.garage.App;
import com.app.garage.controllers.login.LoginController;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


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

import javafx.scene.layout.GridPane;


public class CashierController implements Initializable {
     private Connection con;
     ArrayList<CardController> conts = new ArrayList<CardController>();
   
     
    @FXML
    private Label totPrice;
    private int sum;
    
    
    @FXML
    private Label receiptID;
     
    @FXML
    private MFXButton cancelButton;
    
    @FXML
    private MFXButton doneButton;
    
     @FXML
    private MFXButton btnDone;
    
    @FXML
    private MFXButton btnCancel;
     
    @FXML
    private Label count;
    

    
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
        count.setText(String.valueOf(counter));
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
    
    
    private boolean exist(CardController e, int count){
        if(conts.isEmpty())
          return false;
         for(int i =0;i<conts.size();i++)
             if(conts.get(i).getID()==e.getID()){
                 conts.get(i).setAmount(String.valueOf(Integer.parseInt(conts.get(i).getAmount())+count));
                 return true;
             }
         return false;
     }
    
    
    @FXML
    void btnPressed(ActionEvent event) throws IOException,SQLException  {
       
         try {
             con=DriverManager.getConnection(App.ip, App.user, App.password );
         } catch (SQLException ex) {
            ex.printStackTrace();
         }
        
        int toCount = 1;
        
        Statement st = con.createStatement();
         ResultSet dressQry = null ;
       // double ID =Double.parseDouble(productID.getText());
        try{
         dressQry = st.executeQuery(
                "Select d.DRESSID, d.DRESSNAME,d.DRESSSIZE, d.DRESSCOLOR, d.BRANDNAME, d.PRICE, d.PREVIEW, dd.SALEPERCENTAGE,"
                + " dd.DEPARTMENTSTOCK "
                + " from DRESS  d, DEPARTMENT_DRESS  dd "
                + " where d.DRESSID = dd.DRESSID AND dd.DID = "+idCard.substring(1, 4) +" AND dd.DRESSID = "+productID.getText() );//AND
        }catch(SQLException e){
              productID.setStyle("-fx-border-color: rgba(248,0,0,0.6)");  return;
        }
        boolean avaliable = dressQry.next();
        
        if(!avaliable && dressQry.getInt("DEPARTMENTSTOCK")==0){
            productID.setStyle("-fx-border-color: rgba(248,0,0,0.6)");
            return;
        }
        
        if(!productAmount.getText().replace(" ", "").equals("")) 
        try{
           System.out.println("Amount in the textfield"+ productAmount.getText());
           
           toCount= Integer.parseInt(productAmount.getText());

        }catch(Exception e)
        {productAmount.setStyle("-fx-border-color: rgba(248,0,0,0.6);"); return ; }
        
       
        

        if(avaliable){
        counter=counter+toCount;
        count.setText(String.valueOf(counter));//set the number of products

         FXMLLoader toload = new FXMLLoader(getClass().getResource("/UI/EmployeePage/dress-card.fxml"));

         Parent temp = toload.load();

         CardController crd = toload.getController(); 

            


//           String amount =productAmount.getText().replace(" ", ""); 
//           if(amount.equals(""))
//              crd.setAmount("1");
//           else
           
           crd.setAmount( String.valueOf(toCount));
           
           
           crd.setColor(dressQry.getString(4));
           crd.setID(dressQry.getLong(1));
           
           crd.setName(dressQry.getString(2));
           crd.setPrice(dressQry.getString(6));
           crd.setSale(dressQry.getString(8)+"%");
           crd.setSize(dressQry.getString(3));
           
           
           if(!exist(crd,toCount)){
           conts.add(crd);
           gridLayout.add((Node)temp , j , i);
           j++;
           if(j == 3){
           i++;
           j=0;
           }
           }
           //here we add image from resources
           double price = Double.parseDouble(crd.getPrice()); 
           double sale = Double.parseDouble(crd.getSale().replace("%", ""));
           
           price = price - (price*(sale/100) );
            
           sum = sum +( (int)price*toCount);
           totPrice.setText(Integer.toString(sum));
           
           crd.setPrice(String.valueOf((int)price));
          crd.setImage("/IMG/Product_card/"+crd.getID()+"_IMG.jpg");
          btnDone.setDisable(false);
          btnCancel.setDisable(false);
          productAmount.setText("");
          productAmount.setStyle("");
          productID.setStyle("");
        }else{
           productID.setStyle("-fx-border-color: rgba(248,0,0,0.6)");  return;
        }
        
        
     
        
      
    }
    
    
    @FXML
    void deleteSelectedCards(){
        
       for(int i =conts.size()-1 ; i>=0 ; i--){
           if(conts.get(i).isSelected()){
            counter= counter -  Integer.parseInt(conts.get(i).getAmount());
            int amount = Integer.parseInt(conts.get(i).getAmount());
            int price = Integer.parseInt(conts.get(i).getPrice());
            
            sum = sum - (amount*price);
            totPrice.setText(Integer.toString(sum));
            
            conts.remove(i);
            
            
           }
              
       }
        update();
        
    }
    
    private void setReceiptNumLABEL(){
         try {
             con = DriverManager.getConnection(App.ip, App.user, App.password);
             Statement rLatest = con.createStatement();
             ResultSet latestReceipt = rLatest.executeQuery("select MAX(RECEPIT_NUM) from SELL_RECORD");
             boolean found = latestReceipt.next();
             
             if(found){
                  long num = latestReceipt.getLong(1)+1;
                  receiptID.setText(Long.toString(num));
             }
                
             
             
         } catch (SQLException ex) {
            ex.printStackTrace();
         }
         
    }
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        idCard = LoginController.currentUser;
        
        setReceiptNumLABEL();
       
        
        btnDone.setDisable(true);
        btnCancel.setDisable(true);
       // don't set preferred size or anything on gridpane
       gridLayout = new GridPane();
       // suppose your scroll pane id is scrollPane
       scrollPane.setContent(gridLayout);

    }
    

 
    @FXML
    private void purchase(ActionEvent e){
            try {
             con=DriverManager.getConnection(App.ip, App.user, App.password );
         } catch (SQLException ex) {
            ex.printStackTrace();
         }
        
          btnDone.setDisable(true);
          btnCancel.setDisable(true);
         try {
           
             //UPDATE STATEMENT WITH INSERT VALUES
             Statement stDone = con.createStatement();
             stDone.executeQuery("select receipt_num.nextval from dual");
             for(CardController temp : conts){
                 Date current = new Date();
                 SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
                 
                 String currentDate = formatter.format(current);
                 String dressID = Long.toString(temp.getID());
                 String depid = this.idCard.substring(1, 4);
                 String amount = temp.getAmount();
                 
    
                 stDone.executeUpdate("insert into sell_record (RID, RECEPIT_NUM, DEPID, DRESSID, PURCHASED_DATE, AMOUNT) values("
                         + " receipt_id.nextval, "
                         + " receipt_num.currval, "
                         + depid+", "
                         + dressID+", '"
                         + currentDate+"', "
                         + amount
                         + " )");
                 
                 stDone.executeUpdate("update DEPARTMENT_DRESS "
                                      + " set DEPARTMENTSTOCK=DEPARTMENTSTOCK-"+temp.getAmount()
                                      + " where DRESSID="+Long.toString(temp.getID())
                                      + " and did = "+idCard.substring(1,4));
                 
             }
             
             con.close();
         } catch (SQLException ex) {
            productID.setStyle("-fx-border-color: rgba(248,0,0,0.6);"); ex.printStackTrace();
         }
        setReceiptNumLABEL();
        selectAllCards();
        deleteSelectedCards();
        update();
         
    }
    
    private void selectAllCards(){
        conts.trimToSize();
        for(int i =0; i<conts.size() ; i++)
          conts.get(i).setSelect(true);
    }
    
    @FXML
    private void cancelPurchase(ActionEvent e){
        //NOTHING RELATED TO SQL OR DB
        totPrice.setText("0");
        btnDone.setDisable(true);
        btnCancel.setDisable(true);
        productAmount.setText("");
        productID.setText("");
        selectAllCards(); 
        deleteSelectedCards();
        update();
    }
    
    @FXML
    public void updateAmountToSelected(ActionEvent e){
        
        
        try {
         Integer.parseInt( productAmount.getText());  
        }catch(Exception ex)
        {
            productAmount.setStyle("-fx-border-color: rgba(248,0,0,0.6);");return;
        }
        for(CardController temp : conts){
            if(temp.isSelected()){

            int prev= Integer.parseInt(temp.getAmount());
            int cur = Integer.parseInt(productAmount.getText());
            
            int updatingAmount = cur-prev;
            int price = Integer.parseInt(temp.getPrice());
            sum = sum + (price*updatingAmount);
            totPrice.setText(Integer.toString(sum));
            
            counter = counter + (updatingAmount);
            count.setText(String.valueOf(counter) );
            temp.setAmount(productAmount.getText());
            
            
            }
        }
    }
    
    
}
