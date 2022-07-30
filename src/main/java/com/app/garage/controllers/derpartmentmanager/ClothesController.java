package com.app.garage.controllers.derpartmentmanager;

import com.app.garage.App;
import com.app.garage.controllers.employee.Dress;
import com.app.garage.controllers.login.LoginController;
import com.jfoenix.controls.JFXCheckBox;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.io.IOException;
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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LongStringConverter;

public class ClothesController implements Initializable {

    
    private Connection con;
    
        @FXML
    private TableView<Cloth> tableView;

    @FXML
    private TableColumn<Cloth, Integer> warehouseIdCol;

    @FXML
    private TableColumn<Cloth, Integer> whPriceCol;
        @FXML
    private TableColumn<Cloth, Integer> stockCol;
        
    @FXML
    private TableColumn<Cloth, String> sizeCol;
        @FXML
    private TableColumn<Cloth, Integer> precentCol;

    @FXML
    private TableColumn<Cloth, Integer> priceCol;
        @FXML
    private TableColumn<Cloth, String> colorCol;
            @FXML
    private TableColumn<Cloth, String> brandNameCol;
            
    @FXML
    private TableColumn<Cloth, Long> dressIdCol;
    
    @FXML
    private TableColumn<Cloth, String> historyCol;
            
    @FXML
    private TableColumn<Cloth, String> nameCol;    

    
    
    @FXML
    private TextField brandField;
    
    @FXML 
    private MFXTextField importDress, importStock, importWID, importPercent;
    
    @FXML
    private Pane brandPane;

    @FXML
    private FlowPane flowPane;
    @FXML
    private TextField colorField;

    @FXML
    private Pane colorPane;

    @FXML
    private TextField dressID;

    @FXML
    private AnchorPane filterPanee;

    @FXML
    private TextField historyField;

    @FXML
    private Pane historyPane;

    @FXML
    private TextField idField;

    @FXML
    private Pane idPane;

    @FXML
    private TextField nameField;

    @FXML
    private Pane namePane;

    @FXML
    private TextField priceField;

    @FXML
    private Pane pricePane;

    @FXML
    private TextField quantity;

    @FXML
    private TextField sizeField;

    @FXML
    private Pane sizePane;

    @FXML
    private Pane stockPane;

    @FXML
    private TextField wPriceField;

    @FXML
    private Pane wPricePane;
    
    private ObservableList<Cloth> searchList = FXCollections.observableArrayList();
    
    
    private void searchAll(){
                searchList.clear();
        try {
            con = DriverManager.getConnection(App.ip, App.user, App.password);
            Statement st = con.createStatement();
            
            ResultSet rs= st.executeQuery("select d.DRESSID, d.DRESSNAME, d.DRESSSIZE, d.DRESSCOLOR, d.WSPRICE, d.PRICE, dd.DEPARTMENTSTOCK, d.BUYHISTORY, dd.SALEPERCENTAGE, wd.WID, d.BRANDNAME " 
            +"  from DRESS d inner join DEPARTMENT_DRESS dd on d.dressid=dd.dressid AND dd.did="+LoginController.currentUser.substring(1,4)+" join warehouse_dress wd on wd.dressid=dd.dressid ");
            
            while(rs.next()){
                long dressId = rs.getLong(1);
                String dressName = rs.getString(2);
                String dressSize= rs.getString(3);
                String dressColor = rs.getString(4);
                int wsPrice = rs.getInt(5);
                int price = rs.getInt(6);
                String brandName = rs.getString(11);
                int depStock = rs.getInt(7);
                String buyHistory = rs.getString(8);
                int salePercent = rs.getInt(9);
                int wid = rs.getInt(10);
                searchList.add(new Cloth ( dressId, dressName, dressSize, dressColor, brandName, buyHistory, wsPrice, price, depStock, salePercent, wid ) );
            }
            
            dressIdCol.setCellValueFactory(new PropertyValueFactory<>("dressId"));
            nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            sizeCol.setCellValueFactory(new PropertyValueFactory<>("size"));
            colorCol.setCellValueFactory(new PropertyValueFactory<>("color"));
            whPriceCol.setCellValueFactory(new PropertyValueFactory<>("whprice"));
            priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
            brandNameCol.setCellValueFactory(new PropertyValueFactory<>("brandName"));
            stockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
            historyCol.setCellValueFactory(new PropertyValueFactory<>("history"));
            precentCol.setCellValueFactory(new PropertyValueFactory<>("salepercentage"));
            warehouseIdCol.setCellValueFactory(new PropertyValueFactory<>("warehouseId"));
            tableView.setItems(searchList);
            con.close();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }
    
    private void setUpdateEnable(){
    //UPDATING CODE..
    dressIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
    stockCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
  
    precentCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
   
    tableView.setEditable(true);
    
    stockCol.setOnEditCommit(e->{
       Cloth temp = e.getRowValue();
       
        try {
            con = DriverManager.getConnection(App.ip, App.user, App.password);
            Statement st = con.createStatement();
            int delta = e.getNewValue()-e.getOldValue();
            st.executeUpdate("update DEPARTMENT_DRESS set DEPARTMENTSTOCK ="+e.getNewValue()+" where DRESSID ="+temp.getDressId()+" AND DID="+LoginController.currentUser.substring(1,4) );
            st.executeUpdate("update DRESS set stock=stock+"+delta+" where DRESSID="+temp.getDressId());
            st.executeUpdate("update WAREHOUSE_DRESS set WAREHOUSE_STOCK =WAREHOUSE_STOCK -"+delta+" WHERE DRESSID="+temp.getDressId());//TRY IT BEFORE U ABSR SHO
            
            
            
            temp.setStock(e.getNewValue());
            
            tableView.refresh();
            con.close();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        
    });
    precentCol.setOnEditCommit(e->{
       Cloth temp = e.getRowValue();
       
        try {
            con = DriverManager.getConnection(App.ip, App.user, App.password);
            Statement st = con.createStatement();
            
            st.executeUpdate("update DEPARTMENT_DRESS set SALEPERCENTAGE ="+e.getNewValue()+" where DRESSID ="+temp.getDressId()+" AND DID ="+LoginController.currentUser.substring(1,4));
            temp.setSalepercentage(e.getNewValue());
            
            tableView.refresh();
            con.close();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        
    });
    
    
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       searchAll();
       setUpdateEnable();
    }
    
    private boolean isSelectedCheckBox(ActionEvent event){
        return ((JFXCheckBox)event.getSource()).isSelected();
    }

    @FXML
    void deleteButton(ActionEvent event) {
       Cloth temp = tableView.getSelectionModel().getSelectedItem();
        try {
            con = DriverManager.getConnection(App.ip, App.user, App.password);
            Statement st= con.createStatement();
            st.executeUpdate("delete from DEPARTMENT_DRESS where DRESSID="+temp.getDressId()+" AND DID="+LoginController.currentUser.substring(1,4));
            
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
    }
    private Parent root;
    private boolean added = false;
    @FXML
    void filterButton(ActionEvent event) throws IOException {
      if(!added)
      {FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/DepartmentManagerPage/SearchFilter.fxml"));
     loader.setController(this);
      root = loader.load();
     filterPanee.getChildren().add(root);
      added=true;
      }else
      {filterPanee.setVisible(true);}    
        
    }
     

    
    @FXML
    void Done(ActionEvent event) {
       filterPanee.setVisible(false);
    }

   


    @FXML
    void brandCheck(ActionEvent event) {
        if(isSelectedCheckBox(event))
            flowPane.getChildren().add(brandPane);
        else flowPane.getChildren().remove(brandPane);
    }

    @FXML
    void colorCheck(ActionEvent event) {
  if(isSelectedCheckBox(event))
            flowPane.getChildren().add(colorPane);
        else flowPane.getChildren().remove(colorPane);
    }

    @FXML
    void historyCheck(ActionEvent event) {
  if(isSelectedCheckBox(event))
            flowPane.getChildren().add(historyPane);
        else flowPane.getChildren().remove(historyPane);
    }

    @FXML
    void nameCheck(ActionEvent event) {
  if(isSelectedCheckBox(event))
            flowPane.getChildren().add(namePane);
        else flowPane.getChildren().remove(namePane);
    }

    @FXML
    void priceCheck(ActionEvent event) {
  if(isSelectedCheckBox(event))
            flowPane.getChildren().add(pricePane);
        else flowPane.getChildren().remove(pricePane);
        
    }

    @FXML
    void sizeChick(ActionEvent event) {
  if(isSelectedCheckBox(event))
            flowPane.getChildren().add(sizePane);
        else flowPane.getChildren().remove(sizePane);
    }

    @FXML
    void stockCheck(ActionEvent event) {
  if(isSelectedCheckBox(event))
            flowPane.getChildren().add(stockPane);
        else flowPane.getChildren().remove(stockPane);
    }

    @FXML
    void wPriceCheck(ActionEvent event) {
       if(isSelectedCheckBox(event))
            flowPane.getChildren().add(wPricePane);
        else flowPane.getChildren().remove(wPricePane);
    }
    
    

    
    
    //STAGE ----
     Stage temp;
    @FXML
    void importButton(ActionEvent event) throws IOException {
        
      temp = new Stage();
        
        temp.initModality(Modality.APPLICATION_MODAL);
           temp.initStyle(StageStyle.TRANSPARENT);
        
      FXMLLoader loader =new FXMLLoader(getClass().getResource("/UI/DepartmentManagerPage/import/main_frame.fxml"));
      loader.setController(this);
      Parent root = loader.load();
      Scene s = new Scene(root);
      temp.setScene(s);
      temp.show();
        
    }
    @FXML
    private AnchorPane currPane;

    @FXML
    private MFXTextField clothID;

    @FXML
    private AnchorPane mainPane;

  

    @FXML
    private TextField stockField;

    @FXML
    private TextField wID;

    @FXML
    void cancel(ActionEvent event) {
    temp.close();
    }
    @FXML
    private Label errLabel;
private static final String cssErorr = "-fx-border-color:rgba(255,0,0,0.4)";
    @FXML
    void finish(ActionEvent event) {
        String dressId = importDress.getText();
        String stockIm = importStock.getText();
        String wId = importWID.getText();
        String percent = importPercent.getText();
        
           try{
                    Double.parseDouble(dressId);
                }catch(Exception ex){
                    importDress.setStyle(cssErorr);
                    errLabel.setText("Contains only digits.");
                    errLabel.setVisible(true);
                    return;
                }
           
           errLabel.setVisible(false);
        try {
            con = DriverManager.getConnection(App.ip, App.user, App.password);
            Statement st = con.createStatement();
            int quantity ;
            try{
                quantity = Integer.parseInt(stockIm);
               importStock.setStyle("");
            }catch(Exception e){
                importStock.setStyle(cssErorr);
                errLabel.setText("Contains only digits.");
                errLabel.setVisible(true);
                importDress.setStyle("");
                return;
            }
            errLabel.setVisible(false);
            
            ResultSet rs = st.executeQuery("select stock from dress where dressid="+dressId);
            boolean found= rs.next();
            if(!found){
                importDress.setStyle(cssErorr);
                errLabel.setText("This dress doesn't exist.");
                errLabel.setVisible(true);
                return;
            }
            
            errLabel.setVisible(false);
            importDress.setStyle("");
            int wholeQuantity = rs.getInt(1);
            
            if(wholeQuantity >= quantity){
            st.executeUpdate("update DRESS set stock=stock-"+stockIm+" where DRESSID="+dressId);
            st.executeUpdate("update WAREHOUSE_DRESS set WAREHOUSE_STOCK =WAREHOUSE_STOCK -"+stockIm+" WHERE DRESSID="+dressId);//TRY IT BEFORE U ABSR SHO
            st.executeUpdate("insert into DEPARTMENT_DRESS (DRESSID, DID, SALEPERCENTAGE, DEPARTMENTSTOCK) values ( "+dressId+", "+LoginController.currentUser.substring(1,4)+", "+percent+", "+stockIm+" )");
            

            
          }
            else{ 
            importStock.setStyle(cssErorr);
            errLabel.setText("This stock larger than the warehouse stock.");
            errLabel.setVisible(true);
            return; }
            errLabel.setVisible(false);
            
            temp.close();
            con.close();
        } catch (SQLException ex) {
            
        
                 Alert s= new Alert(Alert.AlertType.ERROR);
            s.setContentText("Invalid Inputs.\n The dress already exist or entering invalid warehouse id please check your inputs\nor the dress id does not exist.");
            s.setTitle("Error");
            s.show();
            return;
                        
        }
        
    }
    @FXML
    private void clearFilter(ActionEvent e){
        Object[] arrCheckBox = filterPanee.getChildren().toArray();
        
        if(arrCheckBox.length == 1)
        {
            AnchorPane realFilter = (AnchorPane)arrCheckBox[0];
            Object[] arrJFX = realFilter.getChildren().toArray();
            for(Object temp : arrJFX)
            {
                if(temp instanceof JFXCheckBox){
                    ((JFXCheckBox)temp).setSelected(false);
                }
            }
            
            
        }
       
       flowPane.getChildren().clear();
       flowPane.getChildren().add(idPane);
        
    }
    
    @FXML
    private void searchButton(ActionEvent e){
                 searchList.clear();
        try {
            con = DriverManager.getConnection(App.ip, App.user, App.password);
            Statement st = con.createStatement();
            
            ResultSet rs= st.executeQuery("select d.DRESSID, d.DRESSNAME, d.DRESSSIZE, d.DRESSCOLOR, d.WSPRICE, d.PRICE, dd.DEPARTMENTSTOCK, d.BUYHISTORY, dd.SALEPERCENTAGE, wd.WID, d.BRANDNAME " 
            +"  from DRESS d inner join DEPARTMENT_DRESS dd on d.dressid=dd.dressid AND dd.did="+LoginController.currentUser.substring(1,4)+" join warehouse_dress wd on wd.dressid=dd.dressid "
            + " where d.DRESSID like '%"+idField.getText()+"%' AND d.DRESSNAME like '%"+nameField.getText()+"%' AND d.DRESSSIZE like '%"+sizeField.getText()+"%' AND d.DRESSCOLOR like '%"+colorField.getText()+"%' "
            + " AND WSPRICE like '%"+wPriceField.getText()+"%' AND d.PRICE like '%"+priceField.getText()+"%' AND dd.DEPARTMENTSTOCK like '%"+stockField.getText()+"%' AND d.BUYHISTORY like '%"+historyField.getText()+"%' AND d.BRANDNAME like '%"+brandField.getText()+"%' "
            + " ");
            
            while(rs.next()){
                long dressId = rs.getLong(1);
                String dressName = rs.getString(2);
                String dressSize= rs.getString(3);
                String dressColor = rs.getString(4);
                int wsPrice = rs.getInt(5);
                int price = rs.getInt(6);
                String brandName = rs.getString(11);
                int depStock = rs.getInt(7);
                String buyHistory = rs.getString(8);
                int salePercent = rs.getInt(9);
                int wid = rs.getInt(10);
                searchList.add(new Cloth ( dressId, dressName, dressSize, dressColor, brandName, buyHistory, wsPrice, price, depStock, salePercent, wid ) );
            }
            
            dressIdCol.setCellValueFactory(new PropertyValueFactory<>("dressId"));
            nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            sizeCol.setCellValueFactory(new PropertyValueFactory<>("size"));
            colorCol.setCellValueFactory(new PropertyValueFactory<>("color"));
            whPriceCol.setCellValueFactory(new PropertyValueFactory<>("whprice"));
            priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
            brandNameCol.setCellValueFactory(new PropertyValueFactory<>("brandName"));
            stockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
            historyCol.setCellValueFactory(new PropertyValueFactory<>("history"));
            precentCol.setCellValueFactory(new PropertyValueFactory<>("salepercentage"));
            warehouseIdCol.setCellValueFactory(new PropertyValueFactory<>("warehouseId"));
            tableView.setItems(searchList);
            con.close();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
      
    }
    
}
