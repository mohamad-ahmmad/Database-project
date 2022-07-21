package com.app.garage.controllers.Owner;

import com.app.garage.App;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXRadioButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class EmployeeController implements Initializable{
    
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
    private TableColumn<Employees, String> salaryCol;
    @FXML
    private TableColumn<Employees, String> officeTelephoneCol;
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
    private TableColumn<Employees, Long> countryCol;
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
     void addInfo(ActionEvent event) throws IOException {
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
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource("/UI/OwnerPage/AddEmployee.fxml"));
        loader.setController(this);
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
    @FXML
    private Button btnNext;
    @FXML
    private Button btnDone;
    @FXML
    private Button btnNextInfo;
    @FXML
    private Button btnDoneInfo;
    @FXML
    void DoneAdding(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
    @FXML
    void NextInfo(ActionEvent event) throws IOException {
         if(i==1)
        {
            btnNextInfo.setVisible(false);
            btnDoneInfo.setVisible(true);
        }
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource(nextInfo.get(i)));
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

        
    }
     @FXML
    void Next(ActionEvent event) throws IOException {
       
         if(i==3)
        {
            btnNext.setVisible(false);
            btnDone.setVisible(true);
        }
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource(next.get(i)));
        Parent root = loader.load();
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
    ObservableList<Employees> emps = FXCollections.observableArrayList();
    ObservableList<Employees> empsSearch = FXCollections.observableArrayList();    
    ObservableList<Employees> locations = FXCollections.observableArrayList();
    ObservableList<Employees> locationsSearch = FXCollections.observableArrayList();
    ObservableList<Employees> numbers = FXCollections.observableArrayList();
     ObservableList<Employees> numbersSearch = FXCollections.observableArrayList();
    ObservableList<Employees> searchEmps = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String Phone = "/UI/OwnerPage/EnterPhoneNum.fxml";
        String Location = "/UI/OwnerPage/EnterLocation.fxml";
        String name = "/UI/OwnerPage/EnterEmployeeName.fxml";
        String salary = "/UI/OwnerPage/EnterSalary.fxml";
        String hireDate = "/UI/OwnerPage/EnterHireDate.fxml";
        String Idcard = "/UI/OwnerPage/EnterIDCard.fxml";
        String type = "/UI/OwnerPage/type.fxml";
        next.add(name);
        next.add(salary);
        next.add(Idcard);
        next.add(type);
        nextInfo.add(Phone);
        nextInfo.add(Location);
        
        try {      
              Connection con = DriverManager.getConnection(App.ip,App.user,App.password);
              Statement stmt = con.createStatement();
              
         ResultSet rs = stmt.executeQuery("select SSN, firstname, middlename, lastname, hiredate, birthdate, gender, salary, idcard, TELEPHONENUMBER, etype from employee, WDManager"
                 + " Where (employee.ssn = WDManager.WDssn)");
        while(rs.next()) {  
            Long SSN = rs.getLong("SSN");
            System.out.println(SSN);
            String firstName = rs.getString("firstname");
            String middleName= rs.getString("middlename");
            String lastName = rs.getString("lastname");
            String hDate = rs.getString("HireDate");        
            String bDate = rs.getString("BirthDate");
            String Gender = rs.getString("gender");
            Integer Salary = rs.getInt("Salary");
            Long IDCard = rs.getLong("IDCard");
            Long telephoneNumber = rs.getLong("telephoneNumber");
            String Type = rs.getString("EType");
            hDate=hDate.substring(0,10);
            bDate=bDate.substring(0,10);
            emps.add (new Employees(SSN,IDCard,telephoneNumber,firstName,middleName,lastName,Type,hDate,bDate,Gender,Salary));
        }
            tableView.setItems(emps);
             SSNCol.setCellValueFactory(new PropertyValueFactory<>("SSN"));
             fNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
             mNameCol.setCellValueFactory(new PropertyValueFactory<>("middleName"));
             lNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
             hDateCol.setCellValueFactory(new PropertyValueFactory<>("hireDate"));
             bDateCol.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
             genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
             salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));
             IDCardCol.setCellValueFactory(new PropertyValueFactory<>("IDCard"));
             officeTelephoneCol.setCellValueFactory(new PropertyValueFactory<>("officeTelephone"));
             typeCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
             
             rs = stmt.executeQuery("select SSN, phonenumber from Employee_Phonenumber");
             while (rs.next())
             {
                 Long SSN = rs.getLong("SSN");
                 Long phonenumber = rs.getLong("phonenumber");
                 numbers.add(new Employees(SSN,phonenumber));
             }
            employeeIDCol.setCellValueFactory(new PropertyValueFactory<>("SSN"));
            numberCol.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
            numbersTable.setItems(numbers);
            
            rs = stmt.executeQuery("select SSN, Country, city, street from Employee_Location");
             while (rs.next())
             {
                 Long SSN = rs.getLong("SSN");
                 String country = rs.getString("country");
                 String city = rs.getString("city");
                 String street = rs.getString("street");
                 numbersSearch.add(new Employees(SSN,country,city,street));
             }
            employeeID2Col.setCellValueFactory(new PropertyValueFactory<>("SSN"));
            countryCol.setCellValueFactory(new PropertyValueFactory<>("country"));
            cityCol.setCellValueFactory(new PropertyValueFactory<>("city"));
            streetCol.setCellValueFactory(new PropertyValueFactory<>("street"));
            locationTable.setItems(numbersSearch);
          }
        catch (SQLException ex) {
              ex.printStackTrace();
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
              
         ResultSet rs = stmt.executeQuery("select SSN, Country, city, street from Employee_Location Where SSN like '%" + txtFieldID.getText()+"%' and (country like '%"+txtFieldLocation.getText()+ "%' or city like '%" + txtFieldLocation.getText() +"%' or street like '%" + txtFieldLocation.getText()+"%')");
         while(rs.next())
         {
            Long SSN = rs.getLong("SSN");
            String country = rs.getString("country");
            String city = rs.getString("city");
            String street = rs.getString("street");
            locationsSearch.add(new Employees(SSN,country,city,street));  
         }
         locationTable.setItems(locationsSearch);
         rs = stmt.executeQuery("select SSN, phonenumber from employee_phonenumber Where SSN like '%" + txtFieldID.getText()+"%' and phonenumber like '%" + txtFieldNumber.getText() + "%'");
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
                 + " Where (employee.SSN = WDManager.WDSSN) and employee.SSN like '%"+txtFieldSSN.getText()+"%' and (firstname like '%"+txtFieldName.getText() +"%' or middlename like '%" + txtFieldName.getText()+"%' or lastname like '%" + txtFieldName.getText()+"%')"
                 + " and hiredate like '%" + txtFieldHDate.getText() +"%' and birthdate like '%" + txtFieldBDate.getText()+"%' and gender like '%" + txtFieldGender.getText()+"%' and salary like '%"+txtFieldSalary.getText()+"%' and telephoneNumber like '%" + txtFieldOfficeTele.getText()
                 + "%' and idcard like '%" + txtFieldIDCard.getText() + "%' and etype like '%" + txtFieldType.getText() + "%'");
        while(rs.next()) { 
            Long SSN = rs.getLong("SSN");
            String firstName = rs.getString("firstname");
            String middleName= rs.getString("middlename");
            String lastName = rs.getString("lastname");
            String hDate = rs.getString("HireDate");        
            String bDate = rs.getString("BirthDate");
            String Gender = rs.getString("gender");
            Integer Salary = rs.getInt("Salary");
            Long IDCard = rs.getLong("IDCard");
            Long telephoneNumber = rs.getLong("telephoneNumber");
            String Type = rs.getString("EType");
            hDate=hDate.substring(0,10);
            bDate=bDate.substring(0,10);
            empsSearch.add (new Employees(SSN,IDCard,telephoneNumber,firstName,middleName,lastName,Type,hDate,bDate,Gender,Salary));
        }
        tableView.setItems(empsSearch);
         }
         catch(SQLException exc)
         {
             exc.printStackTrace();
         }        
        
    }
    

}
