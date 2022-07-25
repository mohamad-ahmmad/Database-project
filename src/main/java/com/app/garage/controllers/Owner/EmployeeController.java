package com.app.garage.controllers.Owner;

import com.app.garage.App;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXRadioButton;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
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
import javafx.util.converter.LongStringConverter;

public class EmployeeController implements Initializable{
    
    
    

    ToggleGroup tg = new ToggleGroup();
    ToggleGroup tg2 = new ToggleGroup();
    
    @FXML
    private TextField EnterSSN;
    @FXML
    private TextField enterEmail;
    @FXML
    private TextField enterPassword;
    @FXML
    private TextField enterFName;
    @FXML 
    private TextField enterMName;
    @FXML
    private TextField enterLName;
    @FXML
    private JFXRadioButton radioBtnFemale;
    
    @FXML
    private JFXRadioButton radioBtnMale;
    @FXML
    private TextField enterSalary;
    @FXML
    private TextField enterIDCard;
    @FXML
    private TextField enterTelephone;
    @FXML
    private MFXDatePicker enterDate;
    @FXML
    private TextField txtFieldSSN;
    @FXML
    private TextField txtFieldName;
    @FXML
    private TextField txtFieldHDate;
    @FXML
    private TextField txtFieldBDate;
    @FXML
    private TextField txtFieldSalary;
    @FXML
    private TextField txtFieldGender;
    @FXML
    private TextField txtFieldIDCard;
    @FXML
    private TextField txtFieldType;
    @FXML
    private TextField txtFieldOfficeTele;
        
    @FXML
    private TextField txtFieldNumber;
    
    @FXML
    private TextField txtFieldID;
    @FXML
    private TextField txtFieldLocation;
    @FXML
    private TableColumn<Employees, Long> IDCardCol;
    
    @FXML
    private TableColumn<Employees, Long> SSNCol;

    @FXML
    private TableColumn<Employees, String> bDateCol;
    @FXML
    private TableColumn<Employees, String> hDateCol;
    @FXML
    private TableColumn<Employees, Long> salaryCol;
    @FXML
    private TableColumn<Employees, Long> officeTelephoneCol;
     @FXML
    private TableColumn<Employees, String> typeCol;
  
    @FXML
    private TableColumn<Employees, String> genderCol;
   
    @FXML
    private TableColumn<Employees, Long> employeeID2Col;
    @FXML
    private TableColumn<Employees, Long> areaCol;
    @FXML
    private TableColumn<Employees, Long> employeeIDCol;
    @FXML
    private TableColumn<Employees, Long> numberCol;
    @FXML
    private TableColumn<Employees, String> countryCol;
    @FXML
    private TableColumn<Employees, String> cityCol;
    @FXML
    private TableColumn<Employees, String> streetCol;
    @FXML
    private TableView<Employees> locationTable;
    @FXML
    private TableView<Employees> numbersTable;   
    @FXML
    private TableColumn<Employees, String> fNameCol;
    @FXML
    private TableColumn<Employees, String> mNameCol;
    @FXML
    private TableColumn<Employees, String> lNameCol;
    @FXML
    private Pane BirthDatePane;
    @FXML
    private Pane OfficeTelephonePane;
    @FXML
    private Pane GenderPane;
    @FXML
    private Pane HireDatePane;
    @FXML
    private Pane IDCardPane;
    @FXML
    private Label lblContact;
    @FXML
    private AnchorPane slidePane;
    @FXML
    private AnchorPane InfoslidePane;
    @FXML
    private AnchorPane locationSlidePane;
    @FXML
    private Label lblInfo;
    @FXML
    private Pane NamePane;

    @FXML
    private Pane TypePane;


    @FXML
    private Pane SalaryPane;


    @FXML
    private JFXCheckBox bdField;

    @FXML
    private FlowPane flowPane;
    @FXML
    private FlowPane ContactFlow;

    @FXML
    private JFXCheckBox nameField;

    @FXML
    private JFXCheckBox genderField;

    @FXML
    private JFXCheckBox hdField;

    @FXML
    private JFXCheckBox idField;

    @FXML
    private JFXCheckBox OfficeTelephoneField;
    @FXML
    private AnchorPane ContactPane;
    @FXML
    private Pane InformationPane;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private JFXCheckBox TypeField;


    @FXML
    private JFXCheckBox salaryField;

    @FXML
    private AnchorPane searchFilter;
    @FXML
    private AnchorPane searchFilterContact;
    @FXML
    private TableView<Employees> tableView;
     @FXML
    private JFXCheckBox LocationField;
     @FXML
    private JFXCheckBox EmailField;
      @FXML
    private JFXCheckBox PhoneField;
    @FXML
   void clearContactFilter(){
       LocationField.setSelected(false);
       PhoneField.setSelected(false);
       searchFilterContact.setVisible(false);
       ContactFlow.getChildren().removeAll(LocationPane,PhonePane);
   }
     @FXML
    private Pane LocationPane;
         @FXML
    private Pane EmailPane;

             @FXML
    private Pane PhonePane;
                 @FXML
     private void Cancel(ActionEvent e){
         i=0;
         Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
         stage.close();
     }
     
    @FXML
    void LocationCheck(ActionEvent event) {
     if(LocationField.isSelected())
    ContactFlow.getChildren().add(LocationPane);
    else ContactFlow.getChildren().remove(LocationPane);
    }
        @FXML
    void PhoneCheck(ActionEvent event) {
     if(PhoneField.isSelected())
    ContactFlow.getChildren().add(PhonePane);
    else ContactFlow.getChildren().remove(PhonePane);
    }
    @FXML
    void EmailCheck(ActionEvent event) {
     if(EmailField.isSelected())
    ContactFlow.getChildren().add(EmailPane);
    else ContactFlow.getChildren().remove(EmailPane);
    }
    @FXML
    void clearFilter(ActionEvent event) {
        nameField.setSelected(false);
        TypeField.setSelected(false);
        OfficeTelephoneField.setSelected(false);
        genderField.setSelected(false);
        salaryField.setSelected(false);
        bdField.setSelected(false);
        hdField.setSelected(false);
        idField.setSelected(false);
        flowPane.getChildren().removeAll(OfficeTelephonePane,TypePane,NamePane,SalaryPane,GenderPane,IDCardPane,HireDatePane,BirthDatePane);
    }
    public void clearSearch(){
        searchFilter.getChildren().clear();
   }
    Stage stage;
    private Parent root;
     @FXML
    void DoneContact(ActionEvent event) throws IOException {
         searchFilterContact.setVisible(false);
    }
   @FXML
    void Done(ActionEvent event) throws IOException {
         searchFilter.setVisible(false);
    }

    @FXML
    void showSearchFilter(ActionEvent event) throws IOException {
        searchFilter.setVisible(true);
    }
    
     @FXML
    void showContactFilter(ActionEvent event) throws IOException {
        searchFilterContact.setVisible(true);
    }
    
    @FXML
    void NameCheck(ActionEvent event) {
     if(nameField.isSelected())
    flowPane.getChildren().add(NamePane);
    else flowPane.getChildren().remove(NamePane);
    }

    @FXML
    void TypeCheck(ActionEvent event) {
    if(TypeField.isSelected())
    flowPane.getChildren().add(TypePane);
    else flowPane.getChildren().remove(TypePane);
    }

    @FXML
    void OfficeTelephoneCheck(ActionEvent event) {
    if(OfficeTelephoneField.isSelected())
    flowPane.getChildren().add(OfficeTelephonePane);
    else flowPane.getChildren().remove(OfficeTelephonePane);
    }
       @FXML
    void SalaryCheck(ActionEvent event) {
    if(salaryField.isSelected())
    flowPane.getChildren().add(SalaryPane);
    else flowPane.getChildren().remove(SalaryPane);
    }

    @FXML
    void BirthDateCheck(ActionEvent event) {
    if(bdField.isSelected())
    flowPane.getChildren().add(BirthDatePane);
    else flowPane.getChildren().remove(BirthDatePane);
    }

    @FXML
    void HireDateCheck(ActionEvent event) {
    if(hdField.isSelected())
    flowPane.getChildren().add(HireDatePane);
    else flowPane.getChildren().remove(HireDatePane);
    }
    @FXML
    void IDCardCheck(ActionEvent event) {
    if(idField.isSelected())
    flowPane.getChildren().add(IDCardPane);
    else flowPane.getChildren().remove(IDCardPane);
    }
      @FXML
    void GenderCheck(ActionEvent event) {
    if(genderField.isSelected())
    flowPane.getChildren().add(GenderPane);
    else flowPane.getChildren().remove(GenderPane);
    }
    @FXML
     void deleteLocation(ActionEvent event) throws IOException {
         try{
     Connection con= DriverManager.getConnection(App.ip,App.user,App.password);
    Statement st = con.createStatement();
    st.executeUpdate("Delete from Employee_Location Where country = '" + locationTable.getSelectionModel().getSelectedItem().getCountry()+ "' and City = '" + locationTable.getSelectionModel().getSelectedItem().getCity() +"' and street = '"+locationTable.getSelectionModel().getSelectedItem().getStreet()+"'");
    locationUpdate();
    } 
    catch (SQLException ex) {
    Logger.getLogger(DepartmentController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
     @FXML
     void deleteNumber(ActionEvent event) throws IOException {
         try{
     Connection con= DriverManager.getConnection(App.ip,App.user,App.password);
    Statement st = con.createStatement();
    st.executeUpdate("Delete from employee_phonenumber Where Phonenumber = " + numbersTable.getSelectionModel().getSelectedItem().getPhoneNumber());
    numbersUpdate();
    } 
    catch (SQLException ex) {
    Logger.getLogger(DepartmentController.class.getName()).log(Level.SEVERE, null, ex);
    }
     }
     @FXML
     void addLocation(ActionEvent event) throws IOException {
         add=false;
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource("/UI/OwnerPage/AddLocation.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        Stage stage = new Stage(StageStyle.UNDECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
     }
    @FXML
     void addNumber(ActionEvent event) throws IOException {
         add=false;
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource("/UI/OwnerPage/AddInfo.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        Stage stage = new Stage(StageStyle.UNDECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
         
     }
    
 @FXML
    void addManager(ActionEvent event) throws IOException {
        add = false;
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource("/UI/OwnerPage/AddEmployee.fxml"));
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
    ArrayList<String> nextInfo = new ArrayList<>();
    ArrayList<String> nextLocation = new ArrayList<>();
    @FXML
    private Button btnNext;
    @FXML
    private Button btnDone;
    @FXML
    private Button btnNextInfo;
    @FXML
    private Button btnNextLocation;
    @FXML
    private Button btnDoneLocation;
    @FXML
    private Button btnDoneInfo;
    @FXML
    private TextField numberSSN;
    @FXML
    private TextField LocationSSN;
    @FXML
    private TextField LocationCountry;
    @FXML
    private TextField LocationStreet;
    @FXML
    private TextField LocationCity;
    @FXML
    private TextField phoneNumber;
    @FXML
    void DoneAddingLocation(ActionEvent event) throws IOException, SQLException {
        boolean done = true;
        if(LocationCountry.getText().isEmpty())
        {   
            LocationCountry.setStyle("-fx-border-color:red");
            LocationCity.setStyle("");
            LocationStreet.setStyle("");
            done=false;
        }
        else if(LocationCity.getText().isEmpty())
        {   
            LocationCity.setStyle("-fx-border-color:red");
            LocationCountry.setStyle("");
            LocationStreet.setStyle("");
            done=false;
        }
        else if(LocationStreet.getText().isEmpty())
        {   
            LocationCity.setStyle("");
            LocationCountry.setStyle("");
            LocationStreet.setStyle("-fx-border-color:red");
            done=false;
        }

        if(done){
         Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
         Statement stmt = con.createStatement();
         stmt.executeQuery("insert into Employee_Location values (" + LocationSSN.getText() + ", '" + LocationCountry.getText()+"', '"+LocationCity.getText()+"', '"+LocationStreet.getText()+"')");
         locationUpdate();
        i=0;
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();}
    }
    @FXML
    void DoneAddingInfo(ActionEvent event) throws IOException, SQLException {
        boolean done = true;
        try{
            if(phoneNumber.getText().isEmpty()) throw new NumberFormatException();
            long test = Long.parseLong(phoneNumber.getText());
            if(String.valueOf(test).length() != 10){throw new NumberFormatException();}
        }
        catch(NumberFormatException e) {
            phoneNumber.setStyle("-fx-border-color:red");
            done = false;
        }
        if(done){
         Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
         Statement stmt = con.createStatement();
         stmt.executeQuery("insert into Employee_phonenumber values (" + numberSSN.getText() + ", " + phoneNumber.getText()+")");
         numbersUpdate();
        i=0;
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();}
    }
    @FXML
    void DoneAdding(ActionEvent event) throws IOException, SQLException {
        LocalDate todaysDate = LocalDate.now();
        
        boolean done = true;
               
        if(enterEmail.getText().isEmpty() || !enterEmail.getText().contains("@gmail.com"))
        {
            enterEmail.setStyle("-fx-border-color:red");
            done=false;
        } 
        else if(enterPassword.getText().isEmpty()){
        enterPassword.setStyle("-fx-border-color:red");
        done=false;
       }      
        if(done){
           Long SSN,Salary,IDCard,telephoneNumber;
           String fName,mName,lName,bDate,Manager;
           Character Gender = 'm';
           SSN=Long.parseLong(EnterSSN.getText());
           Salary=Long.parseLong(enterSalary.getText());
           IDCard=Long.parseLong(enterIDCard.getText());
           fName=enterFName.getText();
           mName=enterMName.getText();
           lName=enterLName.getText();
           bDate=enterDate.getText();
           Manager = "";
           String card = enterIDCard.getText().charAt(0)+"000"+enterIDCard.getText().charAt(4)+enterIDCard.getText().charAt(5);
           if(enterIDCard.getText().startsWith("2"))  Manager = "manager";
           else if(enterIDCard.getText().startsWith("3"))  Manager = "warehouse";
           else if(enterIDCard.getText().startsWith("3")) Manager= "warehouse";
           if(radioBtnFemale.isSelected()) Gender='f';
           else if(radioBtnMale.isSelected()) Gender = 'm';
            System.out.println(bDate);
           String date[] = bDate.split(",");
           date[1]=date[1].replaceAll(" ","");
           String dm[]= date[0].split(" ");    
           String f = "'"+dm[1]+"-"+dm[0]+"-"+date[1]+"'";
         Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
         Statement stmt = con.createStatement();
         stmt.executeQuery("Insert into employee values ("+SSN +", '"+fName+"', '" +mName+"', '" + lName +"', to_date('" +todaysDate+"','yyyy-mm-dd'), " + f + ", '"+Gender+"', "+ Salary +", " + card + ", '" + Manager + "', '"+enterPassword.getText()+"', null, null, null)");
         stmt.executeQuery("Insert into WDManager values (" + SSN + ", '" + enterEmail.getText()  +"', '" + enterTelephone.getText()+"')");
         Update();
         i=0;
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
        }
    }
    
    @FXML
    void NextLocation(ActionEvent event) throws IOException, SQLException{
         boolean found = false;
         boolean go = true;
        if(i==0)      
        {
            try
                {
                    if (LocationSSN.getText().isEmpty()) 
                    throw new NumberFormatException();
                  Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
                  Statement stmt= con.createStatement();
                  ResultSet rs = stmt.executeQuery("Select SSN from employee where etype='manager' or etype ='warehouse'");
                     while (rs.next()){
                         if(Long.parseLong(LocationSSN.getText()) == rs.getLong("SSN"))
                         {
                             found = true;
                             break;
                         }
                     }
                }
            catch(NumberFormatException ex){
                LocationSSN.setStyle("-fx-border-color:red");
                go=false;
            }
            if(found)
            {
                go = true;
            }
            else
            { go=false;
             LocationSSN.setStyle("-fx-border-color:red");
            }
        }
        if(go)
        {
         
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource(nextLocation.get(i)));
        loader.setController(this);
        Parent root = loader.load();
        locationSlidePane.getChildren().add(root);
        
        root.translateXProperty().set(500);
        Timeline t = new Timeline();
        t.getKeyFrames().add(new KeyFrame(Duration.seconds(0.2),
                 new KeyValue(root.translateXProperty(),0),
                new KeyValue(locationSlidePane.getChildren().get(0).translateYProperty(),200)));
        t.play();
        t.setOnFinished(e->{
        locationSlidePane.getChildren().remove(0);});
                  i++;
         if(i==1)
        {
            btnNextLocation.setVisible(false);
            btnDoneLocation.setVisible(true);
        }
        }
        
        
    }
    @FXML
    void NextInfo(ActionEvent event) throws IOException, SQLException {
        boolean found = false;
        boolean go = true;
        if(i==0)
        {
            if (numberSSN.getText().isEmpty())
            {
                numberSSN.setStyle("-fx-border-color:red");
                go=false;
            }
            else
            {
                try
                {
                  Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
                  Statement stmt= con.createStatement();
                  ResultSet rs = stmt.executeQuery("Select SSN, Etype from employee where etype='manager' or etype='warehouse'");
                     while (rs.next()){
                         if(Long.parseLong(numberSSN.getText()) == rs.getLong("SSN"))
                         {
                             found = true;
                             break;
                         }
                     }
                }
            catch(NumberFormatException e){
                numberSSN.setStyle("-fx-border-color:red");
                go=false;
            }
             
            }
            if(found)
            {

                go = true;
            }
            else
            { go=false;
             numberSSN.setStyle("-fx-border-color:red");
            }
        }
        if(go)
        {
         if(i==1)
        {
            btnNextInfo.setVisible(false);
            btnDoneInfo.setVisible(true);
        }
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource(nextInfo.get(i)));
        loader.setController(this);
        Parent root = loader.load();
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
                           if(i==1)
        {
            btnNextInfo.setVisible(false);
            btnDoneInfo.setVisible(true);
        }
        }
        
    }
    
    
    /////////////////////////////////////////
    
    
     @FXML
    void Next(ActionEvent event) throws IOException, SQLException {
        boolean exists = false;
        boolean go = true;
        if(i==0){
            if(EnterSSN.getText().isEmpty() || EnterSSN.getText()==null)
            {
                exists=true;
            }
            else
            {
                try
                {
              Long test = Long.parseLong(EnterSSN.getText());
              Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
              Statement stmt= con.createStatement();
                ResultSet rs = stmt.executeQuery("Select SSN, Etype from Employee");
                while(rs.next()){
                if(Long.parseLong(EnterSSN.getText())==rs.getLong("SSN") && !rs.getString("ETYPE").equals("DELETED"))
                 {
                 exists=true;
                 break;
                 }
                }
                }
                catch(SQLException ex){
               EnterSSN.setStyle("-fx-border-color:Red");
               go = false;   
                }
                catch(NumberFormatException ex){
               EnterSSN.setStyle("-fx-border-color:Red");
               go = false;   
                }
            } 
if(exists)
{
EnterSSN.setStyle("-fx-border-color:Red");
go = false;
}
        }
        
        
        if(i==1)
        {
            if(enterFName.getText().isEmpty() || enterLName.getText().isEmpty() || (!radioBtnFemale.isSelected() && !radioBtnMale.isSelected()) || enterDate.getText().isEmpty())
            {
                if(enterFName.getText().isEmpty())
                {
                   enterFName.setStyle("-fx-border-color:Red");
                   go = false;  
                   enterLName.setStyle("");
                   radioBtnFemale.setStyle("");
                   radioBtnMale.setStyle("");
                   enterDate.setStyle("");
                }
                else if(enterLName.getText().isEmpty())
                {
                   enterLName.setStyle("-fx-border-color:Red");
                   go = false;  
                   enterFName.setStyle("");
                   radioBtnFemale.setStyle("");
                   radioBtnMale.setStyle("");
                   enterDate.setStyle("");
                }     
                else if(!radioBtnFemale.isSelected() && !radioBtnMale.isSelected())
                {
                    
                   radioBtnFemale.setStyle("-fx-border-color:red");
                   radioBtnMale.setStyle("-fx-border-color:red");   
                   go = false;  
                   enterFName.setStyle("");
                   enterLName.setStyle("");
                   enterDate.setStyle("");
                }
                else
                {
                    enterDate.setStyle("-fx-border-color:red");
                    go = false;  
                   enterFName.setStyle("");
                   enterLName.setStyle("");
                   radioBtnFemale.setStyle("");
                   radioBtnMale.setStyle("");
                }
            }
        }
        if(i==2){
            if(enterSalary.getText().isEmpty())
            {   
                enterSalary.setStyle("-fx-border-color:red");
                go=false;
            }
            else
                try{
                    Long l = Long.parseLong(enterSalary.getText());
                }
            catch(NumberFormatException e){
                enterSalary.setStyle("-fx-border-color:red");
                go=false;
            }
        }
        if(i==3){
            if(enterIDCard.getText().isEmpty())
            {
                enterIDCard.setStyle("-fx-border-color:red");
                go = false;
            }
            
            else
            {
                try{
                Long t = Long.parseLong(enterIDCard.getText());
                if ((String.valueOf(t).startsWith("2") || String.valueOf(t).startsWith("3")) && (String.valueOf(t).length()==6) )
                {
                    go = true;
                }
                else { go = false; enterIDCard.setStyle("-fx-border-color:red"); System.out.println("test");}
                Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
                Statement stmt = con.createStatement();
                ResultSet s1= stmt.executeQuery("Select IDcard from employee");
                    while(s1.next()){
                        if(s1.getLong("IDCard")==Long.parseLong(enterIDCard.getText()))
                        {
                         enterIDCard.setStyle("-fx-border-color:red");
                         go = false;
                         break;
                        }

                    }
                }
                catch(NumberFormatException e){
                enterIDCard.setStyle("-fx-border-color:red");
                go = false;
                }
         
        
            }     
        }    
       if(go)
       {
         if(i==3)
        {
            btnNext.setVisible(false);
            btnDone.setVisible(true);
        }
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource(next.get(i)));
        loader.setController(this);
        Parent root = loader.load();
         if(i==0)
        {
        radioBtnFemale.setToggleGroup(tg2);
        radioBtnMale.setToggleGroup(tg2);}
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
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    ObservableList<Employees> emps = FXCollections.observableArrayList();
    ObservableList<Employees> empsSearch = FXCollections.observableArrayList();    
    ObservableList<Employees> locations = FXCollections.observableArrayList();
    ObservableList<Employees> locationsSearch = FXCollections.observableArrayList();
    ObservableList<Employees> numbers = FXCollections.observableArrayList();
    ObservableList<Employees> numbersSearch = FXCollections.observableArrayList();
    ObservableList<Employees> searchEmps = FXCollections.observableArrayList();
boolean add =true;
private void Update() throws SQLException{
          emps.clear();
         Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
              Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select SSN, firstname, middlename, lastname, hiredate, birthdate, gender, salary, idcard, TELEPHONENUMBER, etype from employee, WDManager"
                 + " Where (employee.ssn = WDManager.WDssn)");
        while(rs.next()) {  
            Long SSN = rs.getLong("SSN");
            String firstName = rs.getString("firstname");
            String middleName= rs.getString("middlename");
            String lastName = rs.getString("lastname");
            String hDate = rs.getString("HireDate");        
            String bDate = rs.getString("BirthDate");
            String Gender = rs.getString("gender");
            Long Salary = rs.getLong("Salary");
            Long IDCard = rs.getLong("IDCard");
            Long telephoneNumber = rs.getLong("telephoneNumber");
            String Type = rs.getString("EType");
            hDate=hDate.substring(0,10);
            bDate=bDate.substring(0,10);
            emps.add(new Employees(SSN,IDCard,telephoneNumber,firstName,middleName,lastName,Type,hDate,bDate,Gender,Salary));
        }
             tableView.setItems(emps);
       
}
    
    @FXML
    private JFXButton deleteManager;
    @FXML
    private JFXButton deleteLocation;
    @FXML
    private JFXButton deleteNumber;
    
    @FXML
    private JFXButton showCV;
    @FXML
    private JFXButton editCV;
    @FXML
    private void deleteManager(ActionEvent e){
        try{
     Connection con= DriverManager.getConnection(App.ip,App.user,App.password);
    Statement st = con.createStatement();
    st.executeUpdate("delete from employee Where SSN = " + tableView.getSelectionModel().getSelectedItem().getSSN());
    st.executeUpdate("delete from wdmanager  where wdssn = " + tableView.getSelectionModel().getSelectedItem().getSSN());
    st.executeUpdate("delete from employee_Location  where ssn = " + tableView.getSelectionModel().getSelectedItem().getSSN());
    st.executeUpdate("delete from employee_phonenumber  where ssn = " + tableView.getSelectionModel().getSelectedItem().getSSN());
    Update();
    } 
    catch (SQLException ex) {
    Logger.getLogger(DepartmentController.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableView.setEditable(true);
        locationTable.setEditable(true);
        numbersTable.setEditable(true);
        ChangeListener t = new ChangeListener() {
    @Override
    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
        if(tableView.getSelectionModel().getSelectedItem() != null) 
        {    
           showCV.setDisable(false);
           editCV.setDisable(false);
           deleteManager.setDisable(false);
         }
        else
        {
            showCV.setDisable(true);
           editCV.setDisable(true);
           deleteManager.setDisable(true);
        }
         if(locationTable.getSelectionModel().getSelectedItem() != null) 
        {    
           deleteLocation.setDisable(false);
        }
         else deleteLocation.setDisable(true);
         if(numbersTable.getSelectionModel().getSelectedItem() != null) 
        {    
           deleteNumber.setDisable(false);
         }
         else deleteNumber.setDisable(true);
             
    }
    };
    locationTable.getSelectionModel().selectedItemProperty().addListener(t);
    tableView.getSelectionModel().selectedItemProperty().addListener(t);
    numbersTable.getSelectionModel().selectedItemProperty().addListener(t);
        if(add)
        {
        String Phone = "/UI/OwnerPage/EnterPhoneNum.fxml";
        String name = "/UI/OwnerPage/EnterEmployeeName.fxml";
        String salary = "/UI/OwnerPage/EnterSalary.fxml";
        String country = "/UI/OwnerPage/EnterCountry.fxml";
        String Idcard = "/UI/OwnerPage/EnterIDCard.fxml";
        String type = "/UI/OwnerPage/type.fxml";
        next.add(name);
        next.add(salary);
        next.add(Idcard);
        next.add(type);
        nextInfo.add(Phone);
        nextLocation.add(country);
        
        try {      
              Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
              Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select SSN, firstname, middlename, lastname, hiredate, birthdate, gender, salary, idcard, TELEPHONENUMBER, etype from employee, WDManager"
                 + " Where (employee.ssn = WDManager.WDssn)");
        while(rs.next()) {  
            Long SSN = rs.getLong("SSN");
            String firstName = rs.getString("firstname");
            String middleName= rs.getString("middlename");
            String lastName = rs.getString("lastname");
            String hDate = rs.getString("HireDate");        
            String bDate = rs.getString("BirthDate");
            String Gender = rs.getString("gender");
            Long Salary = rs.getLong("Salary");
            Long IDCard = rs.getLong("IDCard");
            Long telephoneNumber = rs.getLong("telephoneNumber");
            String Type = rs.getString("EType");
            hDate=hDate.substring(0,10);
            bDate=bDate.substring(0,10);
            emps.add(new Employees(SSN,IDCard,telephoneNumber,firstName,middleName,lastName,Type,hDate,bDate,Gender,Salary));
        }
             tableView.setItems(emps);
             SSNCol.setCellValueFactory(new PropertyValueFactory<>("SSN"));
             SSNCol.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
             SSNCol.setOnEditCommit(e->{
                 System.out.println("test");
             });
             
             typeCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
             IDCardCol.setCellValueFactory(new PropertyValueFactory<>("IDCard"));
             fNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
             fNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
             fNameCol.setOnEditCommit(e->{
             Employees s = e.getRowValue();
             s.setFirstName(e.getNewValue());
             colUpdate(s);
             });
             
             mNameCol.setCellValueFactory(new PropertyValueFactory<>("middleName"));
             mNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
             mNameCol.setOnEditCommit(e->{
             Employees s = e.getRowValue();
             s.setMiddleName(e.getNewValue());
             colUpdate(s);
             });
             lNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
             lNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
             lNameCol.setOnEditCommit(e->{
             Employees s = e.getRowValue();
             s.setLastName(e.getNewValue());
             colUpdate(s);
             });
             hDateCol.setCellValueFactory(new PropertyValueFactory<>("hireDate"));
             hDateCol.setCellFactory(TextFieldTableCell.forTableColumn());
             hDateCol.setOnEditCommit(e->{
             Employees s = e.getRowValue();
             s.setHireDate(e.getNewValue());
             colUpdate(s);
             });
             bDateCol.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
             bDateCol.setCellFactory(TextFieldTableCell.forTableColumn());
             bDateCol.setOnEditCommit(e->{
             Employees s = e.getRowValue();
             s.setBirthDate(e.getNewValue());
             colUpdate(s);
             });
             genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
             genderCol.setCellFactory(TextFieldTableCell.forTableColumn());
             genderCol.setOnEditCommit(e->{
             Employees s = e.getRowValue();
             s.setGender(e.getNewValue());
             colUpdate(s);
             });
             salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));
             salaryCol.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
             salaryCol.setOnEditCommit(e->{
             Employees s = e.getRowValue();
             s.setSalary(e.getNewValue());
             colUpdate(s);
             });
             
             
             officeTelephoneCol.setCellValueFactory(new PropertyValueFactory<>("officeTelephone"));
             officeTelephoneCol.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
             officeTelephoneCol.setOnEditCommit(e->{
             Employees s = e.getRowValue();
             s.setOfficeTelephone(e.getNewValue());
             colUpdate(s);
             });
            rs = stmt.executeQuery("select Employee_Phonenumber.SSN, etype, phonenumber from Employee_Phonenumber,employee where  (Etype = 'manager' or Etype = 'warehouse') and Employee_phonenumber.SSN = employee.ssn");
             while (rs.next())
             {
           
                 Long SSN = rs.getLong("SSN");
                 Long phonenumber = rs.getLong("phonenumber");
                 numbers.add(new Employees(SSN,phonenumber));
             }
            employeeIDCol.setCellValueFactory(new PropertyValueFactory<>("SSN"));
            numberCol.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
            numberCol.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
             numberCol.setOnEditCommit(e->{
             Employees s = e.getRowValue();
             s.setPhoneNumber(e.getNewValue());
              try{
    Statement st = con.createStatement();
    st.executeUpdate("Update employee_phonenumber set phonenumber = "+ s.getPhoneNumber() +"Where SSN = " + s.getSSN());
    tableView.refresh();
    } catch (SQLException ex) {
    Logger.getLogger(DepartmentController.class.getName()).log(Level.SEVERE, null, ex);
    }
             });
            numbersTable.setItems(numbers);
            
            rs = stmt.executeQuery("select Employee_Location.SSN, etype, Country, city, street from Employee_Location,employee where (Etype = 'manager' or Etype = 'warehouse') and Employee_Location.SSN = employee.ssn");
             while (rs.next())
             {
                 Long SSN = rs.getLong("SSN");
                 String Country = rs.getString("country");
                 String city = rs.getString("city");
                 String street = rs.getString("street");
                 locations.add(new Employees(SSN,Country,city,street));
             }
            employeeID2Col.setCellValueFactory(new PropertyValueFactory<>("SSN"));
            countryCol.setCellValueFactory(new PropertyValueFactory<>("country"));
            countryCol.setCellFactory(TextFieldTableCell.forTableColumn());
             countryCol.setOnEditCommit(e->{
             Employees s = e.getRowValue();
             s.setCountry(e.getNewValue());
              UpdateCell(s);
             });
             
            cityCol.setCellValueFactory(new PropertyValueFactory<>("city"));
            cityCol.setCellFactory(TextFieldTableCell.forTableColumn());
             cityCol.setOnEditCommit(e->{
             Employees s = e.getRowValue();
             s.setCity(e.getNewValue());
              UpdateCell(s);
             });
             
            streetCol.setCellValueFactory(new PropertyValueFactory<>("street"));
            streetCol.setCellFactory(TextFieldTableCell.forTableColumn());
             streetCol.setOnEditCommit(e->{
             Employees s = e.getRowValue();
             s.setStreet(e.getNewValue());
              UpdateCell(s);
             });
            locationTable.setItems(locations);
          }
        catch (SQLException ex) {
              ex.printStackTrace();
          } 
        }
    }
    boolean InfoSelected = true;
        @FXML
    void openContactPane(MouseEvent event) {
        
        if(InfoSelected && start)
        {
            start = false;
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
         start=true;});
        }
    }
    boolean start = true;
        @FXML
    void openInformationPane(MouseEvent event) {
        
     
        if(!InfoSelected && start)
        {
            start = false;
               lblInfo.setStyle("-fx-text-fill: #F8A918");
        lblContact.setStyle("-fx-text-fill: #aeaeae");
        Timeline t = new Timeline();
        t.getKeyFrames().add(new KeyFrame(Duration.seconds(0.3),
        new KeyValue(InformationPane.translateXProperty(),0),
        new KeyValue(ContactPane.translateXProperty(),850)));
        t.play();
        t.setOnFinished(e->{
        InfoSelected=true;
        start = true;});
        }
    }
    @FXML
    public void searchContact(ActionEvent e){
        locationsSearch.clear();
        numbersSearch.clear();
         try {      
              Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
              Statement stmt = con.createStatement();
              
         ResultSet rs = stmt.executeQuery("select Employee_Location.SSN, etype, Country, city, street from Employee_Location,employee Where (etype = 'manager' or etype = 'warehouse') and (employee_location.SSN=employee.ssn) and Employee_Location.SSN like '%" + txtFieldID.getText()+"%' and (country like '%"+txtFieldLocation.getText()+ "%' or city like '%" + txtFieldLocation.getText() +"%' or street like '%" + txtFieldLocation.getText()+"%')");
         while(rs.next())
         {
            Long SSN = rs.getLong("SSN");
            String country = rs.getString("country");
            String city = rs.getString("city");
            String street = rs.getString("street");
            locationsSearch.add(new Employees(SSN,country,city,street));  
         }
         locationTable.setItems(locationsSearch);
         rs = stmt.executeQuery("select employee_phonenumber.SSN, etype, phonenumber from employee_phonenumber, employee Where (etype = 'manager' or etype = 'warehouse') and (employee_phonenumber.SSN=employee.ssn) and employee_phonenumber.SSN like '%" + txtFieldID.getText()+"%' and phonenumber like '%" + txtFieldNumber.getText() + "%'");
       while(rs.next())
         {
            Long SSN = rs.getLong("SSN");
            Long phonenumber = rs.getLong("phonenumber");
            numbersSearch.add(new Employees(SSN,phonenumber));
            numbersTable.setItems(numbersSearch);
         }
         }
         catch(SQLException exc)
         {
             exc.printStackTrace();
         }
    }
    
    @FXML
    public void startSearch(ActionEvent e){    
        empsSearch.clear();
        try {      
              Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
              Statement stmt = con.createStatement();
              
         ResultSet rs = stmt.executeQuery("select employee.SSN, firstname, middlename, lastname, hiredate, birthdate, gender, salary, idcard, telephoneNumber, etype from employee, WDManager"
                 + " Where (employee.SSN = WDManager.WDSSN) and employee.SSN like '%"+txtFieldSSN.getText()+"%' and (firstname like '%"+txtFieldName.getText() +"%' or (middlename like '%" + txtFieldName.getText()+"%' or middlename is null) or lastname like '%" + txtFieldName.getText()+"%')"
                 + " and hiredate like '%" + txtFieldHDate.getText() +"%' and birthdate like '%" + txtFieldBDate.getText()+"%' and gender like '%" + txtFieldGender.getText()+"%' and salary like '%"+txtFieldSalary.getText()+"%' and (telephoneNumber like '%" + txtFieldOfficeTele.getText()
                 + "%' or telephoneNumber is null)  and idcard like '%" + txtFieldIDCard.getText() + "%' and etype like '%" + txtFieldType.getText() + "%'");
        while(rs.next()) { 
            Long SSN = rs.getLong("SSN");
            String firstName = rs.getString("firstname");
            String middleName= rs.getString("middlename");
            String lastName = rs.getString("lastname");
            String hDate = rs.getString("HireDate");        
            String bDate = rs.getString("BirthDate");
            String Gender = rs.getString("gender");
            Long Salary = rs.getLong("Salary");
            Long IDCard = rs.getLong("IDCard");
            Long telephoneNumber = rs.getLong("telephoneNumber");
            String Type = rs.getString("EType");
            hDate=hDate.substring(0,10);
            bDate=bDate.substring(0,10);
            empsSearch.add(new Employees(SSN,IDCard,telephoneNumber,firstName,middleName,lastName,Type,hDate,bDate,Gender,Salary));
        }
        tableView.setItems(empsSearch);
         }
         catch(SQLException exc)
         {
             exc.printStackTrace();
         }        
        
    }

    private void numbersUpdate() throws SQLException {
        numbers.clear();
        Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("select Employee_Phonenumber.SSN, etype, phonenumber from Employee_Phonenumber,employee where  (Etype = 'manager' or Etype = 'warehouse') and Employee_phonenumber.SSN = employee.ssn");
             while (rs.next())
             {
                 Long SSN = rs.getLong("SSN");
                 Long phonenumber = rs.getLong("phonenumber");
                 numbers.add(new Employees(SSN,phonenumber));
             }
            employeeIDCol.setCellValueFactory(new PropertyValueFactory<>("SSN"));
            numberCol.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
            numbersTable.setItems(numbers);

    }

    private void locationUpdate() throws SQLException {
        locations.clear();
        Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("select Employee_Location.SSN, etype, Country, city, street from Employee_Location,employee where (Etype = 'manager' or Etype = 'warehouse') and Employee_Location.SSN = employee.ssn");
             while (rs.next())
             {
                 Long SSN = rs.getLong("SSN");
                 String Country = rs.getString("country");
                 String city = rs.getString("city");
                 String street = rs.getString("street");
                 locations.add(new Employees(SSN,Country,city,street));
             }
            locationTable.setItems(locations);
    }

    private void UpdateCell(Employees s) {
        try{
         Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
         Statement stmt = con.createStatement();
            Statement st = con.createStatement();
            st.executeUpdate("Update employee_location set COUNTRY = '"+ s.getCountry()+"', City = '" + s.getCity()+"', Street = '"+s.getStreet()+"' Where SSN = " + s.getSSN());
            tableView.refresh();
            } catch (SQLException ex) {
            Logger.getLogger(DepartmentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
    private void colUpdate(Employees s) {
        try{
     Connection con= DriverManager.getConnection(App.ip,App.user,App.password);
    Statement st = con.createStatement();
    st.executeUpdate("Update Employee set firstname= '"+ s.getFirstName()+"', middlename = '" + s.getMiddleName()+"', lastname = '"+s.getLastName()+"', Hiredate = to_date('"+ s.getHireDate()+"','yyyy-mm-dd'), Birthdate = to_date('"+ s.getBirthDate()+"','yyyy-mm-dd'), gender = '" + s.getGender()+"', salary = "+s.getSalary()+", IDCard = "+s.getIDCard()+ ",eType = '" + s.getType() +"' Where SSN = " + s.getSSN());
    tableView.refresh();
    } catch (SQLException ex) {
    Logger.getLogger(DepartmentController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}
