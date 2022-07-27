package com.app.garage.controllers.warehouseManager;
import com.app.garage.App;
import com.app.garage.controllers.Owner.DepartmentController;
import com.app.garage.controllers.Owner.Departments;
import com.app.garage.controllers.login.LoginController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.util.converter.LongStringConverter;

public class ClothesController implements Initializable{

    @FXML
    private JFXCheckBox BrandField;
    @FXML
    private JFXCheckBox TypeField;

    @FXML
    private Pane BrandPane;

    @FXML
    private JFXCheckBox ColorField;

    @FXML
    private Pane ColorPane;

    @FXML
    private FlowPane ContactFlow;

    @FXML
    private AnchorPane ContactPane;

    @FXML
    private Pane IDPane;

    @FXML
    private Pane InformationPane;

    @FXML
    private JFXCheckBox LocationField;

    @FXML
    private Pane NamePane;

    @FXML
    private JFXCheckBox PriceField;

    @FXML
    private Pane PricePane;

    @FXML
    private Pane SSNPane1;

    @FXML
    private JFXCheckBox ShipmentField;

    @FXML
    private JFXCheckBox SizeField;

    @FXML
    private Pane SizePane;

    @FXML
    private JFXCheckBox StockField;

    @FXML
    private Pane StockPane;

    @FXML
    private JFXCheckBox SupplierField;

    @FXML
    private Pane SupplierPane;

    @FXML
    private JFXCheckBox WSField;

    @FXML
    private Pane WSPricePane;
    @FXML
    private Pane TypePane;

    @FXML
    private TableColumn<Clothes, Long> IDCol;

    @FXML
    private TableColumn<Clothes, String> sizeCol;

    @FXML
    private TableColumn<Clothes, String> colorCol;

    @FXML
    private TableColumn<Clothes, String> typeCol;

    @FXML
    private TableColumn<Clothes, String> brandNameCol;

    @FXML
    private TableColumn<Clothes, Long> WSPriceCol;

    @FXML
    private TableColumn<Clothes, Long> priceCol;
    @FXML
    private TableColumn<Clothes, Long> stockCol;
    @FXML
    private TableColumn<Clothes, Long> supplierIDCol;

    @FXML
    private FlowPane flowPane;

    @FXML
    private Label lblContact;

    @FXML
    private Label lblInfo;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private AnchorPane searchFilter;

    @FXML
    private AnchorPane searchFilterContact;

    @FXML
    private TableView<Clothes> tableView;

    @FXML
    void BrandCheck(ActionEvent event) {
     if(((JFXCheckBox)event.getSource()).isSelected())
    flowPane.getChildren().add(BrandPane);
    else flowPane.getChildren().remove(BrandPane);       

    }

    @FXML
    void ColorCheck(ActionEvent event) {
     if(((JFXCheckBox)event.getSource()).isSelected())
    flowPane.getChildren().add(ColorPane);
    else flowPane.getChildren().remove(ColorPane);       
    }

    @FXML
    void Done(ActionEvent event) {
        searchFilter.setVisible(false);
    }

    @FXML
    void PriceCheck(ActionEvent event) {
    if(((JFXCheckBox)event.getSource()).isSelected())
    flowPane.getChildren().add(PricePane);
    else flowPane.getChildren().remove(PricePane);       
    }


    @FXML
    void SizeCheck(ActionEvent event) {
      if(((JFXCheckBox)event.getSource()).isSelected())
    flowPane.getChildren().add(SizePane);
    else flowPane.getChildren().remove(SizePane);              

    }

    @FXML
    void StockCheck(ActionEvent event) {
     if(((JFXCheckBox)event.getSource()).isSelected())
    flowPane.getChildren().add(StockPane);
    else flowPane.getChildren().remove(StockPane);       
    }

    @FXML
    void SupplierCheck(ActionEvent event) {
     if(((JFXCheckBox)event.getSource()).isSelected())
    flowPane.getChildren().add(SupplierPane);
    else flowPane.getChildren().remove(SupplierPane);       
    }

    @FXML
    void WSCheck(ActionEvent event) {
     if(((JFXCheckBox)event.getSource()).isSelected())
    flowPane.getChildren().add(WSPricePane);
    else flowPane.getChildren().remove(WSPricePane);       
    }
      @FXML
    void TypeCheck(ActionEvent event) {
     if(((JFXCheckBox)event.getSource()).isSelected())
    flowPane.getChildren().add(TypePane);
    else flowPane.getChildren().remove(TypePane);       
    }

    @FXML
    void addClothes(ActionEvent event) throws IOException {
        initial=false;
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource("/UI/WarehouseManagerPage/AddClothes.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        Stage stage = new Stage(StageStyle.UNDECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
     private void Cancel(ActionEvent e){
         i=0;
         Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
         stage.close();
         
     }
    @FXML
    void clearFilter(ActionEvent event) {
        SizeField.setSelected(false);
        ColorField.setSelected(false);
        BrandField.setSelected(false);
        WSField.setSelected(false);
        PriceField.setSelected(false);
        TypeField.setSelected(false);
        StockField.setSelected(false);
        SupplierField.setSelected(false);
        tableView.setItems(Clothes);
        flowPane.getChildren().removeAll(NamePane,SizePane,ColorPane,BrandPane,WSPricePane,PricePane,TypePane,StockPane,SupplierPane);
    }

    @FXML
    void openContactPane(MouseEvent event) {
 
        if(InfoSelected)
        {
            InfoSelected=false;
            lblContact.setStyle("-fx-text-fill: #F8A918");
        lblInfo.setStyle("-fx-text-fill: #aeaeae");
        ContactPane.translateXProperty().set(850);
        ContactPane.setVisible(true);
        Timeline t = new Timeline();
        t.getKeyFrames().add(new KeyFrame(Duration.seconds(0.3),
        new KeyValue(ContactPane.translateXProperty(),0),
        new KeyValue(InformationPane.translateXProperty(),-850)));
        t.play();
         t.setOnFinished(e->{
        InfoSelected=false;
        });
        }
    }
    boolean InfoSelected=true;
    @FXML
    void openInformationPane(MouseEvent event) {
        
        if(!InfoSelected)
        {
        InfoSelected=true;
        lblInfo.setStyle("-fx-text-fill: #F8A918");
        lblContact.setStyle("-fx-text-fill: #aeaeae");
        Timeline t = new Timeline();
        t.getKeyFrames().add(new KeyFrame(Duration.seconds(0.3),
        new KeyValue(InformationPane.translateXProperty(),0),
        new KeyValue(ContactPane.translateXProperty(),850)));
        t.play();
        t.setOnFinished(e->{
        InfoSelected=true;
      });
        }
    }
    @FXML
    void showSearchFilter(ActionEvent event) {
    searchFilter.setVisible(true);
    }
    
    @FXML
    private AnchorPane InfoslidePane;

    @FXML
    private AnchorPane bigPane;

    @FXML
    private Button btnDoneInfo;

    @FXML
    private Button btnNextInfo;

    @FXML
    void DoneAdding(ActionEvent event) {
        boolean cont=true;
        if(enterWSPrice.getText().isEmpty()){
            enterWSPrice.setStyle("-fx-border-color:red");
            enterPrice.setStyle("");
            comboboxSupplierID.setStyle("");cont=false;
        }
        else if(enterPrice.getText().isEmpty()){
            enterWSPrice.setStyle("");
            enterPrice.setStyle("-fx-border-color:red");
            comboboxSupplierID.setStyle("");cont=false;
        }
        else if(comboboxSupplierID.getSelectionModel().getSelectedItem()==null){
            enterWSPrice.setStyle("");
            enterPrice.setStyle("");
            comboboxSupplierID.setStyle("-fx-border-color:red");
            cont=false;
        }
            else{ 
                try{
                Long n = Long.parseLong(enterPrice.getText());
                }
                catch(NumberFormatException e){ enterPrice.setStyle("-fx-border-color:red"); enterWSPrice.setStyle("");cont=false;}
                }
                 try{
                Long n = Long.parseLong(enterWSPrice.getText());
                }
                catch(NumberFormatException e){ enterWSPrice.setStyle("-fx-border-color:red"); enterPrice.setStyle("");cont=false;}
        
        if(cont){
            LocalDate todaysDate = LocalDate.now();
            try{ 
             Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
             Statement stmt = con.createStatement();
             stmt.executeUpdate("Insert into dress values ("+ enterID.getText()
             +", '" + enterType.getText()
             +"', '" + enterSize.getText()
             +"', '" + enterColor.getText()
             +"', '" + enterBrandName.getText()
             +"', '" + enterWSPrice.getText() 
             +"', '" + enterPrice.getText()
             +"', '" + enterStock.getText()
             +"', '" + comboboxSupplierID.getSelectionModel().getSelectedItem()
             +"', 'Default', to_date('" +todaysDate+"','yyyy-mm-dd'))");
              stmt.executeUpdate("Insert into warehouse_dress values ("+LoginController.currentUser.substring(1,4)
              + ", " + enterID.getText()
              + ", "+enterStock.getText()+")");
            insert();
            i=0;
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.close();
            con.close();
            }
            catch(SQLException s){
                s.printStackTrace();
            }
        }
    }
int i=0;
    @FXML
    private TextField enterID;
    
    @FXML
    private TextField enterColor;

    @FXML
    private TextField enterSize;

    @FXML
    private TextField enterType;
    @FXML
    private TextField enterBrandName;

    @FXML
    private TextField enterStock;
     @FXML
    private JFXComboBox<String> comboboxSupplierID;

    @FXML
    private TextField enterPrice;

    @FXML
    private TextField enterWSPrice;
    @FXML
    void Next(ActionEvent event) throws IOException, SQLException {
        boolean cont=true;
        Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
        Statement stmt = con.createStatement();
         try{    
         ResultSet rs = stmt.executeQuery("Select DressID from dress where DressID = '"+ enterID.getText()+"'");
         if(rs.next()||enterID.getText().isEmpty())
         {
             enterID.setStyle("-fx-border-color:red");
         }
        else{
             if(i==1){
                 if(enterType.getText().isEmpty()){
                     enterType.setStyle("-fx-border-color:red");
                     enterSize.setStyle("");
                     enterColor.setStyle("");
                      cont=false;
                 }
                 else if (enterSize.getText().isEmpty()){
                     enterType.setStyle("");
                     enterSize.setStyle("-fx-border-color:red");
                     enterColor.setStyle("");
                      cont=false;
                 }
                 else if (enterColor.getText().isEmpty()){
                     enterType.setStyle("");
                     enterSize.setStyle("");
                     enterColor.setStyle("-fx-border-color:red");
                     cont=false;
                 }
        }
             if(i==2){
                 if (enterBrandName.getText().isEmpty()){
                     enterStock.setStyle("");
                     enterBrandName.setStyle("-fx-border-color:red");
                      cont=false;
                 }
                 else if(enterStock.getText().isEmpty()){
                     enterStock.setStyle("-fx-border-color:red");
                     enterBrandName.setStyle("");
                      cont=false;
                 }
                 else
                 {
                 Long stock=Long.parseLong(""+0);
                 Long overAllStock=Long.parseLong(""+0);
                 try{
                 Long enteredStock=Long.parseLong(enterStock.getText());
                 rs = stmt.executeQuery("Select sum(warehouse_stock) from warehouse_dress where WID = " + LoginController.currentUser.substring(1,4));
                 if(rs.next()) stock = rs.getLong(1);
                 rs = stmt.executeQuery("Select Wcapacity from warehouse where WID = " + LoginController.currentUser.substring(1,4));    
                 if(rs.next()) overAllStock = rs.getLong(1);
                   if(enteredStock>(overAllStock-stock) || enteredStock==0)
                   {
                     enterStock.setStyle("-fx-border-color:red");
                     cont=false;
                   }
                   else {cont=true;}
                 }
                 catch(NumberFormatException ex) {
                     enterStock.setStyle("-fx-border-color:red");
                     cont=false;
                 }
                 }
             }
 
             if(cont){
        if(i==2)
        {
            btnNextInfo.setVisible(false);
            btnDoneInfo.setVisible(true);
        }
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource(next.get(i)));
        loader.setController(this);
        Parent root = loader.load();
        if(i==2)
        {
            rs = stmt.executeQuery("Select SupplierID from supplier"); 
            while(rs.next()){
                comboboxSupplierID.getItems().add(rs.getString("SupplierID"));
            }
        }
        InfoslidePane.getChildren().add(root);
        
        root.translateXProperty().set(500);
        Timeline t = new Timeline();
        t.getKeyFrames().add(new KeyFrame(Duration.seconds(0.2),
                 new KeyValue(root.translateXProperty(),0),
                new KeyValue(InfoslidePane.getChildren().get(0).translateYProperty(),200)));
        t.play();
        t.setOnFinished(e->{
        InfoslidePane.getChildren().remove(0);});
        i++;
        con.close();
             }
          }
         }
         catch(SQLException ex){
             enterID.setStyle("-fx-border-color:red");
         }
    }
        ArrayList<String> next = new ArrayList<>();
        ObservableList<Clothes> Clothes = FXCollections.observableArrayList();
        ObservableList<Clothes> clothesSearch = FXCollections.observableArrayList();
        boolean initial=true;
        @FXML
        private JFXButton deleteClothes;
        @FXML
        private void deleteClothes(ActionEvent e){
            Delete(tableView.getSelectionModel().getSelectedItem());
        }
        @Override
        public void initialize(URL url, ResourceBundle rb) {
        if(initial)
        {
            tableView.setEditable(true);
            tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    @Override
    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
        //Check whether item is selected and set value of selected item to Label
        if(tableView.getSelectionModel().getSelectedItem() != null) 
        {    
           deleteClothes.setDisable(false);
         }
         }
    });
        String size = "/UI/WarehouseManagerPage/EnterSize.fxml";
        String Brand = "/UI/WarehouseManagerPage/EnterBrandName.fxml";
        String Price = "/UI/WarehouseManagerPage/EnterPrice.fxml";
        next.add(size);
        next.add(Brand);
        next.add(Price);
        
            try {
                insert();
            } catch (SQLException ex) {
                Logger.getLogger(ClothesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        tableView.setEditable(true);
   
         
         IDCol.setCellValueFactory(new PropertyValueFactory<>("dressID"));
         IDCol.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
             IDCol.setOnEditCommit(e->{
             tableView.refresh();
             });
         sizeCol.setCellValueFactory(new PropertyValueFactory<>("dressSize"));
         sizeCol.setCellFactory(TextFieldTableCell.forTableColumn());
             sizeCol.setOnEditCommit(e->{
             Clothes s = e.getRowValue();
             s.setDressSize(e.getNewValue());
             updateCol(s);
             });
         colorCol.setCellValueFactory(new PropertyValueFactory<>("dressColor"));
         colorCol.setCellFactory(TextFieldTableCell.forTableColumn());
             colorCol.setOnEditCommit(e->{
             Clothes s = e.getRowValue();
             s.setDressColor(e.getNewValue());
             updateCol(s);
             });
         typeCol.setCellValueFactory(new PropertyValueFactory<>("dressName"));
         typeCol.setCellFactory(TextFieldTableCell.forTableColumn());
             typeCol.setOnEditCommit(e->{
             Clothes s = e.getRowValue();
             s.setDressName(e.getNewValue());
             updateCol(s);
             }); 
         brandNameCol.setCellValueFactory(new PropertyValueFactory<>("brandName"));
          brandNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
             brandNameCol.setOnEditCommit(e->{
             Clothes s = e.getRowValue();
             s.setBrandName(e.getNewValue());
             updateCol(s);
             });
          WSPriceCol.setCellValueFactory(new PropertyValueFactory<>("WSPrice"));
          WSPriceCol.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
             WSPriceCol.setOnEditCommit(e->{
             Clothes s = e.getRowValue();
             s.setWSPrice(e.getNewValue());
             updateCol(s);
             });
          priceCol.setCellValueFactory(new PropertyValueFactory<>("Price"));
          priceCol.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
             priceCol.setOnEditCommit(e->{
             Clothes s = e.getRowValue();
             s.setPrice(e.getNewValue());
             updateCol(s);
             });
         stockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
         supplierIDCol.setCellValueFactory(new PropertyValueFactory<>("supplierID"));
           
        }
    }
        
    private void insert() throws SQLException{
        Clothes.clear();
        Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("Select * From warehouse_Dress wd join DRESS d on d.DRESSID=wd.DRESSID  AND Wid = " + LoginController.currentUser.substring(1,4));
         while(rs.next()){
         Clothes.add(new Clothes(rs.getString("DressName"),
                                 rs.getString("DressSize"),
                                 rs.getString("DressColor"),
                                 rs.getString("brandname"),
                                 "Default URL",
                                 rs.getLong("dressID"),
                                 rs.getLong("WSPrice"),
                                 rs.getLong("Price"),
                                 rs.getLong("Stock"),
                                 rs.getLong("SupplierID")));
         }
         tableView.setItems(Clothes);
    }
    @FXML
    private TextField txtfieldBrandName;

    @FXML
    private TextField txtfieldColor;

    @FXML
    private TextField txtfieldID;
    @FXML
    private TextField txtfieldType;

    @FXML
    private TextField txtfieldPrice;

    @FXML
    private TextField txtfieldSize;

    @FXML
    private TextField txtfieldStock;

    @FXML
    private TextField txtfieldSupplierID;

    @FXML
    private TextField txtfieldWSPrice;
    @FXML
    private void startSearch(ActionEvent e) throws SQLException{
        clothesSearch.clear();
        Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * from dress where Dressid like '%" + txtfieldID.getText() +"%' and "
                + "Dressname like '%" + txtfieldType.getText() +"%' and "
                + "DressSize like '%" + txtfieldSize.getText() +"%' and "
                + "DressColor like '%" + txtfieldColor.getText() +"%' and "
                + "brandName like '%" + txtfieldBrandName.getText() +"%' and "
                + "WSPrice like '%" + txtfieldWSPrice.getText() + "%' and "
                + "Price like '%" + txtfieldPrice.getText() + "%' and "
                + "Stock like '%" + txtfieldStock.getText() + "%' and "
                + "SupplierID like '%" + txtfieldSupplierID.getText() + "%'");
          while(rs.next()){
              clothesSearch.add(new Clothes(rs.getString("DressName"),
                                 rs.getString("DressSize"),
                                 rs.getString("DressColor"),
                                 rs.getString("brandname"),
                                 "Default URL",
                                 rs.getLong("dressID"),
                                 rs.getLong("WSPrice"),
                                 rs.getLong("Price"),
                                 rs.getLong("Stock"),
                                 rs.getLong("SupplierID")));
        }
         tableView.setItems(clothesSearch);
         tableView.refresh();
         con.close();
    }

    private void Delete(Clothes selectedItem) {
        try{
     Connection con= DriverManager.getConnection(App.ip,App.user,App.password);
    Statement st = con.createStatement();
    st.executeUpdate("Delete from Dress Where dressID = " + selectedItem.getDressID());
    st.executeUpdate("Delete from warehouse_dress  Where dressID = " + selectedItem.getDressID()+" and Wid = " + LoginController.currentUser.substring(1,4));
    insert();
    con.close();
    } 
    catch (SQLException ex) {
    Logger.getLogger(DepartmentController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    private void updateCol(Clothes s) {
        try{
     Connection con= DriverManager.getConnection(App.ip,App.user,App.password);
    Statement st = con.createStatement();
    st.executeUpdate("Update Dress set DressNAme = '"+ s.getDressName()+"', dresssize = '"+ s.getDressSize()+"', dresscolor = '" + s.getDressColor()+"', brandname = '"+s.getBrandName()+"', WSPrice = "+s.getWSPrice()+ ", price = " + s.getPrice()+"  Where DressID = " + s.getDressID());
    tableView.refresh();
    con.close();
    } catch (SQLException ex) {
    Logger.getLogger(DepartmentController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
   
}
