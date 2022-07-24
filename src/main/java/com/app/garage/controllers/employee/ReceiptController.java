/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.employee;

import com.app.garage.App;
import com.app.garage.controllers.login.LoginController;
import com.jfoenix.controls.JFXCheckBox;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXTextField;
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
import javafx.application.Platform;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LongStringConverter;
import javax.swing.plaf.basic.BasicTreeUI;

/**
 *
 * @author USER-M
 */
public class ReceiptController implements Initializable  {

    private Connection con;
    
    @FXML
    private MFXTextField dressSearch;
    
    @FXML
    private MFXTextField amountSearch;

    @FXML
    private MFXTextField dateSearch;

    @FXML
    private MFXTextField idSearch;
    
    

     @FXML
    private Pane addPane;
    
      @FXML
    private MFXButton addBtn;



    

    @FXML
    private MFXDatePicker dressDate;

    @FXML
    private MFXTextField dressID;

    @FXML
    private MFXTextField dressReceipt;
    
    @FXML
    private TableColumn<Receipt, Long> idCol;
    
    @FXML
    private TableColumn<Receipt, Integer> amountCol;
    
    @FXML
    private TableColumn<Receipt, String> dateCol;

    @FXML
    private TableColumn<Receipt, Long> dressIDCol;
    
    @FXML
    private TableColumn<Receipt, Long> receiptIDCol;
    
    @FXML
    private TableView<Receipt> receiptTable;
 

    @FXML
    private MFXTextField amount;
    @FXML
    private MFXCheckbox enableChecked;
    
    private boolean running=true;
    private Thread time = new Thread(){
       SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
       public boolean running=true;
        @Override
        public void run(){
            while (running){
               
                 dressDate.setText(formatter.format(new Date()));
                 
            }
              
        }
       
    };
    
    private void setEditability(boolean temp){
        temp =!temp;      
       dressReceipt.disableProperty().set(temp);      
       dressID.disableProperty().set(temp);
       addBtn.disableProperty().set(temp);
       amount.disableProperty().set(temp);
        
    }
    
    @FXML
    void enableCheck(ActionEvent event) {
     if( ((JFXCheckBox)event.getSource()).isSelected() ){
         setEditability(true);
         addPane.setStyle("-fx-border-color:#666; -fx-border-radius:5");
          dressDate.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date()));
     }
         
     else{
         setEditability(false);
         addPane.setStyle("-fx-border-color:#aaa; -fx-border-radius:5");
          dressDate.setText("");
     }
        
    }

    private ObservableList<Receipt> initState = FXCollections.observableArrayList();
    private ObservableList<Receipt> search = FXCollections.observableArrayList();
    
    private void searchAllValues(){
        
        
        initState.clear();
        try {
            con= DriverManager.getConnection(App.ip, App.user, App.password);
            Statement st = con.createStatement();
            
            ResultSet all = st.executeQuery("select * from SELL_RECORD where DEPID = "+LoginController.currentUser.substring(1,4));
            
            while(all.next()){
                long id = all.getLong(1);
                long receiptNum = all.getLong(2);
                long dressid = all.getLong(4);
                String date = all.getString(5).replace(".", ":");
                int amount = all.getInt(6);
                
                
                initState.add(new Receipt(id, receiptNum, dressid, date, amount));
            }
            receiptTable.setItems(initState);
            
            idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
            dressIDCol.setCellValueFactory(new PropertyValueFactory<>("dressID"));
            receiptIDCol.setCellValueFactory(new PropertyValueFactory<>("receiptID"));
            amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
            dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        
    }
    @FXML
    private MFXButton deleteBtn;
    private boolean selected =false;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setEditability(false);
        searchAllValues();
        
        dressDate.setDisable(true);
        //time.start();
        
        Stage s = App.getAppStage();
        s.setOnCloseRequest(e->{
            running=false;
            Platform.exit();
            System.exit(0);
        });
        
        deleteBtn.disableProperty().set(true);
        receiptTable.setEditable(true);
        
        receiptIDCol.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
        dressIDCol.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
        amountCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        
    
        
       
        
        amountCol.setOnEditCommit(e->{
           Receipt temp = e.getRowValue();
           int newAmount;
           try{
                newAmount = e.getNewValue();
                
           }catch(Exception ex){
               ((TextFieldTableCell)(e.getSource())).setStyle("-fx-border-color: rgba(248,0,0,0.6)"); return;
           }
          
           
           
           
           temp.setAmount(newAmount);
            try {
                con = DriverManager.getConnection(App.ip,App.user,App.password);
                
                Statement up = con.createStatement();
                up.executeUpdate("update SELL_RECORD set AMOUNT = "+newAmount
                                +" where RID=" +temp.getId());
                
                
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
           
           
           
            
        }
        );
        receiptTable.getSelectionModel().selectedItemProperty().addListener(e->{
            
            if(!selected){
                deleteBtn.disableProperty().set(false);
                selected=!selected;
            }
        });
        
    
        
    }
    
    @FXML 
    private void search(ActionEvent e) {
        search.clear();
        try {
            con = DriverManager.getConnection(App.ip, App.user, App.password);
            
              Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT *"
        + " FROM SELL_RECORD "
        +"Where DEPID like '"+LoginController.currentUser.substring(1,4)+ "' and RECEPIT_NUM like '%"+idSearch.getText()+"%' and DRESSID like '%"+dressSearch.getText()+"%' and PURCHASED_DATE like '%"+dateSearch.getText()+"%' and AMOUNT like '%"+amountSearch.getText()+"%' ");
        
        while(rs.next()){
            long id = rs.getLong(1);
            long receiptNum = rs.getLong(2);
            long dressID = rs.getLong(4);
            String purDate = rs.getString(5).replace(".", ":");
            int amount = rs.getInt(6);
            
            search.add(new Receipt(id, receiptNum, dressID, purDate, amount));
        }
        receiptTable.setItems(search);
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    @FXML
    void addReceipt(ActionEvent event) {
        long receiptID;
        long dressID;
        int amount;
        
        try{
          receiptID = Long.parseLong(dressReceipt.getText());
        }catch(Exception ex){
            dressReceipt.setStyle("-fx-border-color: rgba(248,0,0,0.6)");
            return;
        }
        
        try{
           dressID = Long.parseLong(this.dressID.getText());  
        }catch(Exception ex){
            this.dressID.setStyle("-fx-border-color: rgba(248,0,0,0.6)");
            return;
        }
        
        try{
            amount = Integer.parseInt(this.amount.getText());
        }catch(Exception ex){
            this.amount.setStyle("-fx-border-color: rgba(248,0,0,0.6)");
            return;
        }
      
        
        
        
        try {
            con = DriverManager.getConnection(App.ip, App.user, App.password);
            Statement insert = con.createStatement();
            insert.executeUpdate("insert into SELL_RECORD values( "
                    + " receipt_id.nextval, "
                    + receiptID +", "
                    + LoginController.currentUser.substring(1, 4) +", "
                    + dressID +", "
                    + "substr( current_timestamp , 1 ,18), "
                    + amount
                    + " ) ");
            
            
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
             dressReceipt.setStyle("-fx-border-color: rgba(248,0,0,0.6)");
              this.dressID.setStyle("-fx-border-color: rgba(248,0,0,0.6)");
                 this.amount.setStyle("-fx-border-color: rgba(248,0,0,0.6)");
                 return;
        }
        
          dressReceipt.setStyle("");
           this.dressID.setStyle("");
              this.amount.setStyle("");
        searchAllValues();
     
     
        
        
    }
    
    @FXML
    private JFXCheckBox checkboxAdd;
    
    @FXML
    void deleteReceipt(ActionEvent event) {
      Receipt selectedItem= receiptTable.getSelectionModel().getSelectedItem();
        try {
            con=DriverManager.getConnection(App.ip, App.user, App.password);
            Statement delete = con.createStatement();
            
            delete.executeUpdate("update DEPARTMENT_DRESS set DEPARTMENTSTOCK =DEPARTMENTSTOCK+"+selectedItem.getAmount()
                    + " where DID = "+LoginController.currentUser.substring(1,4)+" AND DRESSID = " +selectedItem.getDressID());
            
            
            delete.executeUpdate("delete from SELL_RECORD where RID="+selectedItem.getId());
            
            con.close();
            searchAllValues();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
      
      
      
    }


    
}
