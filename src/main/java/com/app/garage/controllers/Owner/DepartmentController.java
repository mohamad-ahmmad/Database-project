package com.app.garage.controllers.Owner;

import com.app.garage.App;
import com.app.garage.controllers.login.LoginController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import io.github.palexdev.materialfx.dialogs.MFXDialogs;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
import javafx.util.StringConverter;
import javafx.util.converter.LongStringConverter;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import oracle.jdbc.pool.OracleDataSource;


public class DepartmentController implements Initializable{
    @FXML
    private JFXComboBox<String> comboboxManagerID;
    @FXML
    private TextField EnterCountry;
    @FXML
    private TextField EnterCity;
    @FXML
    private TextField EnterStreet;
    @FXML
    private TextField EnterID;
    @FXML
    private TextField EnterName;
    

    @FXML
    private Pane IDPane;
    
    @FXML
    private TextField txtfieldID;
        @FXML
    private TextField txtfieldName;
    @FXML
    private TextField txtFieldCountry;
    @FXML
    private TextField txtFieldCity;
    @FXML
    private TextField txtFieldStreet;
    @FXML
    private TextField txtFieldManagerId;
    @FXML
    private TextField txtFieldOpeningDate;

    @FXML
    private TableColumn<Departments, Long> IDCol;
    @FXML
    private TableColumn<Departments, String> nameCol;
    @FXML
    private TableColumn<Departments, String> streetCol;
    @FXML
    private TableColumn<Departments, String> countryCol;
    @FXML
    private TableColumn<Departments, String> cityCol;
    @FXML
    private TableColumn<Departments, Long> managerIDCol;
                    
    @FXML
    private TableColumn<Departments, String> openingDateCol;
    
    @FXML
    private JFXButton deleteDep;
    @FXML
    private Pane cityPane;

    @FXML
    private Pane countryPane;

    @FXML
    private FlowPane flowPane;

    @FXML
    private Pane managerPane;



    @FXML
    private Pane namePane;

    @FXML
    private Pane openingPane;


    @FXML
    private  AnchorPane searchFilter;

    @FXML
    private Pane streetPane;

    @FXML
    private TableView<Departments> tableView;
    
    
    
    @FXML
    private AnchorPane searchPane;
    
    
    @FXML
    void deleteDep(ActionEvent event) {
         Delete(tableView.getSelectionModel().getSelectedItem());
    }
    
    @FXML
    void clearFilter(ActionEvent event) {
        nameField.setSelected(false);
        countryField.setSelected(false);
        cityField.setSelected(false);
        streetField.setSelected(false);
        managerField.setSelected(false);
        odField.setSelected(false);
        txtfieldID.setText("");
        txtfieldName.setText("");
        txtFieldCountry.setText("");
        txtFieldCity.setText("");
        txtFieldStreet.setText("");
        txtFieldManagerId.setText("");
        txtFieldOpeningDate.setText("");
        tableView.setItems(deps);
        flowPane.getChildren().removeAll(namePane,cityPane,streetPane,countryPane,managerPane,openingPane);
        tableView.setItems(deps);
    }
    public void clearSearch() throws IOException{
        searchFilter.getChildren().clear();
   }

    Stage stage;
    private Parent root;
   @FXML
    void Done(ActionEvent event) throws IOException {
         searchFilter.setVisible(false);

    }
    
    @FXML
    void showSearchFilter(ActionEvent event) throws IOException {
        searchFilter.setVisible(true);
    }
    

    @FXML
    void cityCheck(ActionEvent event) {
     if(cityField.isSelected())
    flowPane.getChildren().add(cityPane);
    else flowPane.getChildren().remove(cityPane);
    }

    @FXML
    void countryCheck(ActionEvent event) {
    if(countryField.isSelected())
    flowPane.getChildren().add(countryPane);
    else flowPane.getChildren().remove(countryPane);
    }

    @FXML
    void managerIDCheck(ActionEvent event) {
    if(managerField.isSelected())
    flowPane.getChildren().add(managerPane);
    else flowPane.getChildren().remove(managerPane);
    }
       @FXML
    void nameCheck(ActionEvent event) {
    if(nameField.isSelected())
    flowPane.getChildren().add(namePane);
    else flowPane.getChildren().remove(namePane);
    }

    @FXML
    void opendateCheck(ActionEvent event) {
    if(odField.isSelected())
    flowPane.getChildren().add(openingPane);
    else flowPane.getChildren().remove(openingPane);
    }

    @FXML
    void streetCheck(ActionEvent event) {
    if(streetField.isSelected())
    flowPane.getChildren().add(streetPane);
    else flowPane.getChildren().remove(streetPane);
    }
    
    @FXML
    private JFXCheckBox IDcheckField;
    @FXML
    private JFXCheckBox nameField;
    @FXML
    private JFXCheckBox countryField;
    @FXML
    private JFXCheckBox cityField;
    @FXML
    private JFXCheckBox streetField;
    @FXML
    private JFXCheckBox odField;
    @FXML
    private JFXCheckBox managerField;
    @FXML
    private AnchorPane slidePane;
    
    FXMLLoader loader;
    Long ID,ManagerID;
    String Country,City,Street,Name; 
    @FXML
    void addDepartment(ActionEvent event) throws IOException {
        add=false;//////bolean to stop adding every time stage is open
        loader = new FXMLLoader(getClass().getResource("/UI/OwnerPage/AddDepartment.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        Stage stage = new Stage(StageStyle.UNDECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();         
    }
    int i=0;
    ArrayList<String> next = new ArrayList<>();
    @FXML
    private Button btnNext;
    @FXML
    private Button btnDone;
    @FXML
    void DoneAdding(ActionEvent event) throws IOException, SQLException {
        boolean found = false;//////to know if manager id on the new dep already has a dep
        boolean f = true;
        boolean canAdd = false;
        boolean Continue = true;
        if (comboboxManagerID.getSelectionModel().getSelectedItem()==null && i==3)
        {
            enterValue.setVisible(true);
             digits3.setVisible(false);
             this.exists.setVisible(false);
             wrongID.setVisible(false);
            comboboxManagerID.setStyle("-fx-border-color:RED");
        }
        else
        {
        try{
        Long test = Long.parseLong(comboboxManagerID.getSelectionModel().getSelectedItem());
        comboboxManagerID.setStyle("");
        f= true;
        }
         catch(Exception e){

             comboboxManagerID.setStyle("-fx-border-color:RED");
             f=false;
        }
        if(f)
        {
        ID=Long.parseLong(EnterID.getText());
        Name=EnterName.getText();
        Country=EnterCountry.getText();
        City=EnterCity.getText();
        Street = EnterStreet.getText();
        ManagerID=Long.parseLong(comboboxManagerID.getSelectionModel().getSelectedItem());
         Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
         Statement stmt = con.createStatement();
         ResultSet s1= stmt.executeQuery("Select SSN, Etype, Depid from employee");
         while (s1.next()){
             if(ManagerID == s1.getLong("SSN") && s1.getString("Depid")==null && s1.getString("Etype").equals("manager"))
             {
                 Continue=true;
                 canAdd=true;
                 break;
             }
         }
         if(canAdd)
         {
            s1= stmt.executeQuery("Select IDcard from employee where SSN = "+ ManagerID);
            String s="";
            if(s1.next()) s = s1.getString("IDCard");
            String IDCARD = s.charAt(0)+""+ID+s.charAt(4)+s.charAt(5);
            stmt.executeUpdate("insert into Department values (" + ID + ", '" + Country + "', '" + City + "', '" + Street + "',  '" + Name + "', " + ManagerID+", TO_DATE('0003-03-03', 'YYYY-MM-DD'))" );
            stmt.executeUpdate("Update Employee Set IDCard = " + IDCARD + ", Depid = " + ID +" where SSN = " + ManagerID);
            i=0;
         }
         else
         {
         comboboxManagerID.setStyle("-fx-border-color:RED"); 
         Continue=false;
         }
         if(Continue)
         {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
        deps.clear();
         try {      
         ResultSet rs = stmt.executeQuery("SELECT DID, Dname, Country, City, Street, OpeningDate, ManagerID"
                 + " FROM Department");
        while(rs.next()) {  
            Long id = rs.getLong("DID");
            String country = rs.getString("Country");
            String city= rs.getString("city");
            String street = rs.getString("street");
            String dname = rs.getString("Dname");        
            Long mid = rs.getLong("ManagerID");
            String date = rs.getString("OpeningDate");
            date=date.replaceAll("-", "/");
            String[] d = date.split(" ");
            deps.add(new Departments(id, dname, country, city, street, d[0], mid));
        }
        

            tableView.setItems(deps);
             IDCol.setCellValueFactory(new PropertyValueFactory<>("DID"));
             
             nameCol.setCellValueFactory(new PropertyValueFactory<>("DName"));
             countryCol.setCellValueFactory(new PropertyValueFactory<>("Country"));
             cityCol.setCellValueFactory(new PropertyValueFactory<>("City"));
             streetCol.setCellValueFactory(new PropertyValueFactory<>("Street"));
             openingDateCol.setCellValueFactory(new PropertyValueFactory<>("OpeningDate"));
             managerIDCol.setCellValueFactory(new PropertyValueFactory<>("ManagerID"));
             con.close();
          }
         
        catch (SQLException ex) {
              ex.printStackTrace();
          } 
         }
        }
        
    }
       
    }
    @FXML
     private void Cancel(ActionEvent e){
         i=0;
         Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
         stage.close();
         
     }
    boolean add=true;
    boolean flag = true;
    @FXML
    private Label digits3;

    @FXML
    private Label enterValue;

    @FXML
    private Label exists;

    @FXML
    private Label wrongID;
     @FXML
    void Next(ActionEvent event) throws IOException, SQLException {
        boolean exists=false;
        
        if(EnterID.getText().isEmpty() && i==0 )
        {
             EnterID.setStyle("-fx-border-color:RED");
             enterValue.setVisible(true);
             digits3.setVisible(false);
             this.exists.setVisible(false);
             wrongID.setVisible(false);
        }
        else if (EnterID.getText().length()!=3){
             EnterID.setStyle("-fx-border-color:RED");
             enterValue.setVisible(false);
             digits3.setVisible(true);
             this.exists.setVisible(false);
             wrongID.setVisible(true);
        }
        else if((EnterName==null||EnterName.getText().isEmpty()) && i==1)
        {
            enterValue.setVisible(true);
             digits3.setVisible(false);
             this.exists.setVisible(false);
             wrongID.setVisible(false);
            EnterName.setStyle("-fx-border-color:RED");
        }
        else if((EnterCountry==null || EnterCity==null || EnterCountry.getText().isEmpty() || EnterCity.getText().isEmpty())  && i==2)
        {
             enterValue.setVisible(true);
             digits3.setVisible(false);
             this.exists.setVisible(false);
             wrongID.setVisible(false);
            if((EnterCountry==null ||EnterCountry.getText().isEmpty()))
            {
            EnterCountry.setStyle("-fx-border-color:RED");
            EnterCity.setStyle(""); 
            }
            else
            {
            EnterCity.setStyle("-fx-border-color:RED"); 
            EnterCountry.setStyle("");
            }
        }
        else
        {
        try{
        int test = Integer.parseInt(EnterID.getText());
        EnterID.setStyle("");
        flag=true;
        }
         catch(Exception e){
             EnterID.setStyle("-fx-border-color:RED");
             enterValue.setVisible(false);
             digits3.setVisible(true);
             this.exists.setVisible(false);
             wrongID.setVisible(true);
             flag = false;    
        }
        if(i==2)
        {
            btnNext.setVisible(false);
            btnDone.setVisible(true);
        }
        if(flag){
            Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
              Statement stmt = con.createStatement();
              
         ResultSet rs = stmt.executeQuery("Select SSN, Depid from Employee");
         while(rs.next()){
             if(Long.parseLong(EnterID.getText())==rs.getLong("Depid"))
             {
                 exists=true;
                 break;
             }
         }
         if(exists){
         EnterID.setStyle("-fx-border-color:RED");
             enterValue.setVisible(false);
             digits3.setVisible(false);
             this.exists.setVisible(true);
             wrongID.setVisible(true);
         }
         
             else
         {
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource(next.get(i)));
             enterValue.setVisible(false);
             digits3.setVisible(false);
             this.exists.setVisible(false);
             wrongID.setVisible(false);
        loader.setController(this);
        Parent root = loader.load();
        if(i==2){
            rs= stmt.executeQuery("Select SSN from employee where Depid is null and Etype='manager'");
            ObservableList<String> SSNs = FXCollections.observableArrayList();
            while(rs.next()){
                SSNs.add(rs.getString("SSN"));
            }
            comboboxManagerID.setItems(SSNs);
        
        }
        slidePane.getChildren().add(root);
        root.translateXProperty().set(500);
        Timeline t = new Timeline();
        t.getKeyFrames().add(new KeyFrame(Duration.seconds(0.2),
                 new KeyValue(root.translateXProperty(),0),
                new KeyValue(slidePane.getChildren().get(0).translateYProperty(),200)));
        t.play();
        t.setOnFinished(e->{
        slidePane.getChildren().remove(0);});
                  i++;
         }
         con.close();
        }
        }
    }
    public void Update(Departments s){
     try{
     Connection con= DriverManager.getConnection(App.ip,App.user,App.password);
    Statement st = con.createStatement();
    st.executeUpdate("Update Department set Country = '"+ s.getCountry() +"', City = '"+ s.getCity()+"', Street = '" + s.getStreet()+"', dname = '"+s.getDName()+"', managerID = "+s.getManagerID() + ", OpeningDate = to_date('" + s.getOpeningDate()+"' ,'yyyy/mm/dd') Where DID = " + s.getDID());
    
    tableView.refresh();
    con.close();
    } catch (SQLException ex) {
    Logger.getLogger(DepartmentController.class.getName()).log(Level.SEVERE, null, ex);
    }
}

 
    ObservableList<Departments> deps = FXCollections.observableArrayList();
    ObservableList<Departments> searchDeps = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           
    tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    @Override
    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
        //Check whether item is selected and set value of selected item to Label
        if(tableView.getSelectionModel().getSelectedItem() != null) 
        {    
           TableView.TableViewSelectionModel selectionModel = tableView.getSelectionModel();
           ObservableList selectedCells = selectionModel.getSelectedCells();
           TablePosition tablePosition = (TablePosition) selectedCells.get(0);
           Object val = tablePosition.getTableColumn().getCellData(newValue);
           deleteDep.setDisable(false);
         }
         }
    });

        String name = "/UI/OwnerPage/EnterName.fxml";
        String Location = "/UI/OwnerPage/Location.fxml";
        String ManagerID = "/UI/OwnerPage/ManagerID.fxml";
        next.add(name);
        next.add(Location);
        next.add(ManagerID);
        tableView.setEditable(true);
        if(add)
        {
         try {      
              Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
              Statement stmt = con.createStatement();
              
         ResultSet rs = stmt.executeQuery("SELECT DID, Dname, Country, City, Street, OpeningDate, ManagerID"
                 + " FROM Department");
        while(rs.next()) {  
            Long id = rs.getLong("DID");
            String country = rs.getString("Country");
            String city= rs.getString("city");
            String street = rs.getString("street");
            String dname = rs.getString("Dname");        
            Long mid = rs.getLong("ManagerID");
            String date = rs.getString("OpeningDate");
            date=date.replaceAll("-", "/");
            String[] d = date.split(" ");

            deps.add(new Departments(id, dname, country, city, street, d[0], mid));
            }
             tableView.setItems(deps);
             IDCol.setCellValueFactory(new PropertyValueFactory<>("DID"));
             nameCol.setCellValueFactory(new PropertyValueFactory<>("DName"));
             nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
             nameCol.setOnEditCommit(e->{
             Departments s = e.getRowValue();
             s.setDName(e.getNewValue());
             Update(s);
             });
             countryCol.setCellValueFactory(new PropertyValueFactory<>("Country"));
             countryCol.setCellFactory(TextFieldTableCell.forTableColumn());
             countryCol.setOnEditCommit(e->{
             Departments s = e.getRowValue();
             s.setCountry(e.getNewValue());
             Update(s);
             });
             cityCol.setCellValueFactory(new PropertyValueFactory<>("City"));
             cityCol.setCellFactory(TextFieldTableCell.forTableColumn());
             cityCol.setOnEditCommit(e->{
             Departments s = e.getRowValue();
             s.setCity(e.getNewValue());
             Update(s);
             });
             streetCol.setCellValueFactory(new PropertyValueFactory<>("Street"));
             streetCol.setCellFactory(TextFieldTableCell.forTableColumn());
             streetCol.setOnEditCommit(e->{
             Departments s = e.getRowValue();
             s.setStreet(e.getNewValue());
             Update(s);
             });
             openingDateCol.setCellValueFactory(new PropertyValueFactory<>("OpeningDate"));
             openingDateCol.setCellFactory(TextFieldTableCell.forTableColumn());
             openingDateCol.setOnEditCommit(e->{
             Departments s = e.getRowValue();
             s.setOpeningDate(e.getNewValue());
             Update(s);
             });
             
             managerIDCol.setCellValueFactory(new PropertyValueFactory<>("ManagerID"));
             managerIDCol.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
             try{
             managerIDCol.setOnEditCommit(e->{
             Departments s = e.getRowValue();
             Long old = e.getOldValue();
             s.setManagerID(e.getNewValue());
             String newIDCard = "";
             String id = "";
             try{
               String card;
               Statement st = con.createStatement();
               ResultSet ss = st.executeQuery("Select IDCard from employee where SSN =" + old);
               while(ss.next()){
                id = String.format("%03d",ss.getLong("IDCard"));
                newIDCard = id.charAt(0)+"000"+id.charAt(4)+id.charAt(5);
               }
               if(e.getNewValue()==null)
               {

                 st.executeUpdate("Update employee set DepID = '', IDCard = "+ newIDCard +  " where SSN = " + old);
                 st.executeUpdate("Update Department set ManagerID = '' where DID = " + s.getDID());
               }
               else
               {
               
               ResultSet S = st.executeQuery("Select SSN,etype,depid,wareid, IDCard from employee Where SSN = "+e.getNewValue());
               Statement q= con.createStatement();
               if(S.next())
               {
                  card =  String.format("%03d",S.getLong("IDCard"));
                   if((S.getString("etype").equals("manager") && (S.getString("Depid")==null && S.getString("wareid")==null)))
                   {
                       q.executeUpdate("Update employee set DepID = '', IDCard = "+newIDCard+" where SSN = " + old);
                       q.executeUpdate("Update Department set ManagerID = "+ e.getNewValue()+ " where DID = " + s.getDID());
                       q.executeUpdate("Update employee set IDCard = " +card.charAt(0)+String.format("%03d",s.getDID())+card.charAt(4)+card.charAt(5)+", DepID = "+s.getDID()+" where SSN = " + e.getNewValue());
                   }
                   else
                   {
                   Alert sa = new Alert(Alert.AlertType.ERROR);
                   sa.setTitle("Wrong Manager ID");
                   sa.setContentText("This manager id either does not exists or is alread a manager on another department, please enter a correct manager id, you can find it in employees tab, where ID Card has (000) (2nd,3rd and 4th digits) ");
                   sa.show();
            
                   }
 
               }
               else
               {
                   Alert sa = new Alert(Alert.AlertType.ERROR);
                   sa.setTitle("Wrong Manager ID");
                   sa.setHeaderText("Error, Wrong Manager ID!");
                   sa.setContentText("This manager id either does not exists or is already a manager on another department\nplease enter a correct manager id\nyou can find it in employees tab where ID Card has (000) as 2nd,3rd and 4th digits\n\n\n");
                   sa.show();
               }
               tableView.refresh();
               }
               } catch (SQLException ex) {
                 Alert sa = new Alert(Alert.AlertType.ERROR);
                   sa.setTitle("Wrong Manager ID");
                   sa.setContentText("This manager id either does not exists or is alread a manager on another department, please enter a correct manager id, you can find it in employees tab, where ID Card has (000) (2nd,3rd and 4th digits) ");
                   sa.show();
               }
             });
             }
             catch(Exception e){
                 System.out.println("Something wrong");
             }
             
          }
        catch (SQLException ex) {
              ex.printStackTrace();
          } 
        }
    }
    
    private void loadReport(Departments temp){
        Long id = temp.getDID();
            OracleDataSource ods;
        InputStream input;
        JasperDesign design;
        JasperReport rep;
        JasperPrint jPrint;
        OutputStream output;
        
        try{
          ods = new OracleDataSource();
          ods.setURL(App.ip);
          ods.setUser(App.user);
          ods.setPassword(App.password);
          Connection con = ods.getConnection();
          File f = new File("D:\\DataBase Project\\src\\main\\resources\\Reports\\Deleted_Departments\\Department_Document.jrxml");
          design = JRXmlLoader.load(f);
         
          
          String sql = "SELECT  d.DID, d.COUNTRY, d.CITY, d.STREET, d.DNAME, d.OPENINGDATE, e.SSN, e.FIRSTNAME, e.LASTNAME, e.SALARY, e.ETYPE " +
               " ,(SELECT STREET FROM EMPLOYEE_LOCATION el where el.ssn=e.ssn AND ROWNUM <2)AS LOC_STREET " +
               " ,(SELECT CITY FROM EMPLOYEE_LOCATION el where el.ssn=e.ssn AND ROWNUM <2 ) as LOC_CITY, " +
               " (SELECT PHONENUMBER FROM EMPLOYEE_PHONENUMBER ep where ep.ssn = e.ssn and ROWNUM <2 ) AS ONE_PHONENUMBER  " +
               " FROM DEPARTMENT d JOIN EMPLOYEE e ON d.DID=e.DEPID where d.DID="+id;
         
          JRDesignQuery newQ= new JRDesignQuery();
          newQ.setText(sql);
          design.setQuery(newQ);
          
          rep = JasperCompileManager.compileReport(design);
          jPrint=JasperFillManager.fillReport(rep,null,con);
          output=new FileOutputStream(new File("src/main/resources/Reports/Deleted_Departments/"+temp.getDID()+"_DELETED.pdf"));
          //JasperExportManager.exportReportToPdfStream(jPrint, output);
            
            JasperViewer receiptView = new JasperViewer(jPrint, false);
          receiptView.setVisible(true);
          
        }catch(Exception e){
            System.out.println("shittt");
        e.printStackTrace();
        }
        
        
    }
    
    private void Connect() throws SQLException{
        searchDeps.clear();
        Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT *"
        + " FROM Department "
        +"Where DID like '%"+txtfieldID.getText()+ "%' and dname like '%"+txtfieldName.getText()+"%' and country like '%"+txtFieldCountry.getText()+"%' and city like '%"+txtFieldCity.getText()+"%' and (street like '%"+txtFieldStreet.getText()+"%' or street is null) and ManagerID like '%"+txtFieldManagerId.getText() + "%' and OpeningDate like '%"+txtFieldOpeningDate.getText()+"%'");
             while(rs.next()) {  
            Long id = rs.getLong("DID");
            String country = rs.getString("Country");
            String city= rs.getString("city");
            String street = rs.getString("street");
            String dname = rs.getString("Dname");        
            Long mid = rs.getLong("ManagerID");
            String date = rs.getString("OpeningDate");
            date=date.replaceAll("-", "/");
            String[] d = date.split(" ");
            searchDeps.add(new Departments(id, dname, country, city, street, d[0], mid));       
        }
             con.close();
    }
        @FXML
    void startSearch(ActionEvent event) throws SQLException {
        Connect();
        tableView.setItems(searchDeps);     
    }
    private void Delete(Departments selectedItem) {
     try{
     Connection con= DriverManager.getConnection(App.ip,App.user,App.password);
    Statement st = con.createStatement();
    ResultSet t = st.executeQuery("Select IDCard from employee where Depid = " + selectedItem.getDID());
    String a="";
    String idcard="";
    if(t.next()){ a=t.getString("IDCard");
    idcard=a.charAt(0)+"000"+a.charAt(4)+a.charAt(5);
    }
    
    loadReport( selectedItem);
    
    st.executeUpdate("Delete from Department Where Did = " + selectedItem.getDID());
    
    st.executeUpdate("Update employee set DepID = '', IDCard = " + idcard+ " Where SSN =" + selectedItem.getManagerID());
    Connect();
    tableView.setItems(searchDeps);
    con.close();
    } 
    catch (SQLException ex) {
    Logger.getLogger(DepartmentController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}
