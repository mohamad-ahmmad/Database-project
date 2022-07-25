/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.derpartmentmanager;

/**
 *
 * @author USER-M
 */
import com.app.garage.App;
import com.app.garage.controllers.login.LoginController;
import com.jfoenix.controls.JFXCheckBox;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import com.jfoenix.controls.JFXCheckBox;
import java.awt.Desktop;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LongStringConverter;

public class EmployeesController implements Initializable{
    
    private Connection con;
    
    @FXML
    private Pane cityPane, countryPane, phonePane, BirthDatePane, FirstNamePane, GenderPane,
            HireDatePane, IDCardPane,InformationPane, LastNamePane, MiddleNamePane, SSNPane,
            SSNPane1, SalaryPane, streetPane;

    @FXML
    private TextField countryField, cityField, streetField, phoneNumberField;
    
    
    /*Employee First Siler From the Slider */
    @FXML
    private DatePicker hirePicker, birthPicker;
    
    @FXML
    private TextField ssnText, firstText, middleText, lastText, salaryText, cardText;
    
    @FXML
    private ComboBox genderCombo;
   
    
    @FXML
    private FlowPane ContactFlow, flowPane;

    @FXML
    private AnchorPane ContactPane;

    
    @FXML
    private AnchorPane filterPopUpPane;

    @FXML
    private TableColumn<Employee, Long> SSNCol;

  
    @FXML
    private TableColumn<Employee, Integer> SalCol;

   
    @FXML
    private TableColumn<Employee, String> birthDateCol;



    @FXML
    private TableColumn<Employee, String> genderCol;

    @FXML
    private TableColumn<Employee, String> hireDateCol;

    @FXML
    private TableColumn<Employee, Integer> idCol;

    @FXML
    private TableColumn<Employee, String> lNameCol;

    @FXML
    private Label lblContact;

    @FXML
    private Label lblInfo;

    @FXML
    private TableColumn<Employee, String> mNameCol;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private TableColumn<Employee, String> nameCol;



    @FXML
    private AnchorPane searchFilterContact;

    @FXML
    private TableView<Employee> tableView;

    private boolean isSelected (ActionEvent event){
        JFXCheckBox s = (JFXCheckBox)(event.getSource());
        return  s.isSelected();
    }
    
    @FXML
    void BirthDateCheck(ActionEvent event) {
          
        if( isSelected(event) )
            flowPane.getChildren().add(BirthDatePane);
        else
           flowPane.getChildren().remove(BirthDatePane);
        
    }

    @FXML
    void Done(ActionEvent event) {
        filterPopUpPane.setVisible(false);
        searchFilterOpened=!searchFilterOpened;
    }

    

    @FXML
    void FirstNameCheck(ActionEvent event) {
       if( isSelected(event) )
            flowPane.getChildren().add(FirstNamePane);
        else
           flowPane.getChildren().remove(FirstNamePane);
        
    }

    @FXML
    void GenderCheck(ActionEvent event) {
       if( isSelected(event) )
            flowPane.getChildren().add(GenderPane);
        else
           flowPane.getChildren().remove(GenderPane);
        
    }

    @FXML
    void HireDateCheck(ActionEvent event) {
       if( isSelected(event) )
            flowPane.getChildren().add(HireDatePane);
        else
           flowPane.getChildren().remove(HireDatePane);
        
       
    }

    @FXML
    void IDCardCheck(ActionEvent event) {
       if( isSelected(event) )
            flowPane.getChildren().add(IDCardPane);
        else
           flowPane.getChildren().remove(IDCardPane);
        
    }

    @FXML
    void LastNameCheck(ActionEvent event) {
       if( isSelected(event) )
            flowPane.getChildren().add(LastNamePane);
        else
           flowPane.getChildren().remove(LastNamePane);
        
    }

  

    @FXML
    void MiddleNameCheck(ActionEvent event) {
       if( isSelected(event) )
            flowPane.getChildren().add(MiddleNamePane);
        else
           flowPane.getChildren().remove(MiddleNamePane);
        
    }
  

    @FXML
    void SalaryCheck(ActionEvent event) {
       if( isSelected(event) )
            flowPane.getChildren().add(SalaryPane);
        else
           flowPane.getChildren().remove(SalaryPane);
        
    }

    @FXML
    void LocationCheck(ActionEvent event) {
        if(isSelected(event)){
        ContactFlow.getChildren().add(streetPane);
        ContactFlow.getChildren().add(cityPane);
        ContactFlow.getChildren().add(countryPane);
            visibleContact(true);
        }else {
            visibleContact(false);
            ContactFlow.getChildren().remove(streetPane);
        ContactFlow.getChildren().remove(cityPane);
        ContactFlow.getChildren().remove(countryPane);
        }
    }
    @FXML
    void PhoneCheck(ActionEvent event) {
         if(isSelected(event)){
             ContactFlow.getChildren().add(phonePane);
            phonePane.setVisible(true);
         }
       
        else {
         ContactFlow.getChildren().remove(phonePane);
         phonePane.setVisible(false);
         }
    }
@FXML
    void DoneContact(ActionEvent event) {
        searchFilterContact.setVisible(false);

    }
    @FXML
    void addEmployee(ActionEvent event) throws IOException {

       Stage logout = new Stage();
       logout.initModality(Modality.APPLICATION_MODAL);
       logout.initStyle(StageStyle.UNDECORATED);
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/DepartmentManagerPage/add_employee/main_frame.fxml"));
       Parent root = loader.load();
       
       Scene logoutScene = new Scene(root);
       logout.setScene(logoutScene);
       logout.show();
       

    }
    @FXML
    void deleteEmployee(ActionEvent event) {

    }

    @FXML
    void addInfo(ActionEvent event) {

    }

    @FXML
    void clearContactFilter(ActionEvent event) {
        
      Object[] arrCheckBox = searchFilterContact.getChildren().toArray();
      
      for(Object temp : arrCheckBox)
          if(temp instanceof JFXCheckBox)
              ((JFXCheckBox)temp).setSelected(false);
        
     ContactFlow.getChildren().clear();
     ContactFlow.getChildren().add(SSNPane1);
    }

    @FXML
    void clearFilter(ActionEvent event) {
       Object arrCheckBox[] = filterPopUpPane.getChildren().toArray();
       
       for(Object temp : arrCheckBox)
           if(temp instanceof JFXCheckBox)
               ((JFXCheckBox)temp).setSelected(false);
       
       flowPane.getChildren().removeAll(FirstNamePane, LastNamePane, MiddleNamePane, HireDatePane, BirthDatePane, GenderPane, SalaryPane, IDCardPane);
                
    }

      private boolean searchFilterContactOpened =false;
    @FXML
    void showContactFilter(ActionEvent event) {
        if(!searchFilterContactOpened)
          searchFilterContact.setVisible(true);
        else searchFilterContact.setVisible(false);
    }
     
    private boolean searchFilterOpened =false;
    @FXML
    void showSearchFilter(ActionEvent event) {
        if(!searchFilterOpened)
            filterPopUpPane.setVisible(true);
        else
            filterPopUpPane.setVisible(false);
        
        searchFilterOpened=!searchFilterOpened;
    }

 
        @FXML
    private TableColumn <Employee,String> passCol;
    
    private ObservableList<Employee> empTableContainer= FXCollections.observableArrayList();
    private ObservableList<Contact> contactTableContainer = FXCollections.observableArrayList();
    private ObservableList<EmpLocation> locTableContainer = FXCollections.observableArrayList();
    
    private void searchAllEmp(){
        empTableContainer.clear();
        
        try {
            con = DriverManager.getConnection(App.ip, App.user, App.password);
            Statement sAll = con.createStatement();
            
            ResultSet rs =  sAll.executeQuery("select SSN, FIRSTNAME, MIDDLENAME, LASTNAME, HIREDATE, BIRTHDATE, GENDER, SALARY, IDCARD, EPASSWORD from EMPLOYEE "
                                             +" where DEPID ="+LoginController.currentUser.substring(1,4));
            
            while(rs.next()){
               long id = rs.getLong(1);
               String firstName = rs.getString(2);
               String middleName = rs.getString (3); 
               String lastName = rs.getString(4);
               String hireDate = rs.getString(5).substring(0,10);
               String birthDate = rs.getString(6).substring(0, 10);
               String gender = rs.getString(7);
               int salary = rs.getInt(8);
               int idCard = rs.getInt(9);
               String password = rs.getString(10);
            
               // public Employee(Long ssn, String firstName, String middleName, String lastName, String hireDate, String birthDate, int age, String gender, int salary, String idCard, String password) {
               empTableContainer.add(new Employee(id, firstName, middleName, lastName, hireDate, birthDate, gender, salary, idCard, password));
            }
              tableView.setItems(empTableContainer);
            SSNCol.setCellValueFactory(new PropertyValueFactory<>("ssn"));
            nameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            mNameCol.setCellValueFactory(new PropertyValueFactory<>("middleName"));
            lNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            hireDateCol.setCellValueFactory(new PropertyValueFactory<>("hireDate"));
            birthDateCol.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
            genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
            SalCol.setCellValueFactory(new PropertyValueFactory<>("salary"));
            idCol.setCellValueFactory(new PropertyValueFactory<>("idCard"));
            passCol.setCellValueFactory(new PropertyValueFactory<>("password"));
            
          
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        SSNCol.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
                              
        SSNCol.setOnEditCommit(e->{
            
            
            ((TextFieldTableCell)e.getSource()).setText("EXCEPTION THROWN");
        });
        
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setOnEditCommit(e->{
         Employee temp = e.getRowValue();
            long key = temp.getSsn();
             
            try {
                con =DriverManager.getConnection(App.ip, App.user, App.password);
                Statement st = con.createStatement();
                
                st.executeUpdate("update EMPLOYEE set FIRSTNAME = '"+e.getNewValue()+ "' where SSN ="+key);
                temp.setFirstName(e.getNewValue());
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
        });
        
        mNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        mNameCol.setOnEditCommit(e->{
        long key = e.getRowValue().getSsn();
        Employee temp = e.getRowValue();
          try {
                con =DriverManager.getConnection(App.ip, App.user, App.password);
                Statement st = con.createStatement();
                
                st.executeUpdate("update EMPLOYEE set MIDDLENAME = '"+e.getNewValue()+ "' where SSN ="+key);
                temp.setMiddleName(e.getNewValue());
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        
        });
        
        lNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        lNameCol.setOnEditCommit(e->{
        long key = e.getRowValue().getSsn();
        Employee temp = e.getRowValue();
          try {
                con =DriverManager.getConnection(App.ip, App.user, App.password);
                Statement st = con.createStatement();
                
                st.executeUpdate("update EMPLOYEE set LASTNAME = '"+e.getNewValue()+ "' where SSN ="+key);
                temp.setLastName(e.getNewValue());
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        
        });
        
        hireDateCol.setCellFactory(TextFieldTableCell.forTableColumn());
        hireDateCol.setOnEditCommit(e->{
        long key = e.getRowValue().getSsn();
         Employee temp = e.getRowValue();
          try {
                con =DriverManager.getConnection(App.ip, App.user, App.password);
                Statement st = con.createStatement();
                
                st.executeUpdate("update EMPLOYEE set HIREDATE = to_date('"+e.getNewValue()+ "', 'YYYY-MM-DD') where SSN ="+key);
                temp.setHireDate(e.getNewValue());
                con.close();
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        
        });
        
         birthDateCol.setCellFactory(TextFieldTableCell.forTableColumn());
        birthDateCol.setOnEditCommit(e->{
        long key = e.getRowValue().getSsn();
            Employee temp = e.getRowValue();
          try {
                con =DriverManager.getConnection(App.ip, App.user, App.password);
                Statement st = con.createStatement();
                
                st.executeUpdate("update EMPLOYEE set BIRTHDATE = to_date('"+e.getNewValue()+ "', 'YYYY-MM-DD') where SSN ="+key);
                temp.setBirthDate(e.getNewValue());
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        
        });
        
        genderCol.setCellFactory(TextFieldTableCell.forTableColumn());
        genderCol.setOnEditCommit(e ->{
                  long key = e.getRowValue().getSsn();
              Employee temp = e.getRowValue();
          try {
                con =DriverManager.getConnection(App.ip, App.user, App.password);
                Statement st = con.createStatement();
                
                st.executeUpdate("update EMPLOYEE set GENDER = '"+e.getNewValue()+ "' where SSN ="+key);
                temp.setGender(e.getNewValue());
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        
           SalCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        SalCol.setOnEditCommit(e ->{
                  long key = e.getRowValue().getSsn();
                  Employee temp = e.getRowValue();
           
          try {
                con =DriverManager.getConnection(App.ip, App.user, App.password);
                Statement st = con.createStatement();
                
                st.executeUpdate("update EMPLOYEE set SALARY = "+e.getNewValue()+ " where SSN ="+key);
                temp.setSalary(e.getNewValue());
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        

        
        
        passCol.setCellFactory(TextFieldTableCell.forTableColumn());
        passCol.setOnEditCommit(e ->{
                  long key = e.getRowValue().getSsn();
                  Employee temp = e.getRowValue();
          try {
                con =DriverManager.getConnection(App.ip, App.user, App.password);
                Statement st = con.createStatement();
                
                st.executeUpdate("update EMPLOYEE set EPASSWORD = '"+e.getNewValue()+ "' where SSN ="+key);
                temp.setPassword(e.getNewValue());
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        
        
        
        
    }
    
    
    @FXML
    private TableView <Contact> contactTable;
    @FXML
    private TableColumn <Contact,Long> numberContactCol;
    @FXML
    private TableColumn <Contact,Long> idContactCol;
    private void searchAllCont(){
        contactTableContainer.clear();
        
        try {
            con = DriverManager.getConnection(App.ip, App.user, App.password);
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select ep.ssn, phonenumber from  EMPLOYEE_PHONENUMBER ep, EMPLOYEE e where ep.ssn = e.ssn and e.depid = "+LoginController.currentUser.substring(1,4));
            
            while(rs.next())
            {
                long idTemp = rs.getLong(1);
                long numberTemp = rs.getLong(2);
                contactTableContainer.add(new Contact(idTemp, numberTemp));
            }
            
            
            
           idContactCol.setCellValueFactory(new PropertyValueFactory<>("id"));
           numberContactCol.setCellValueFactory(new PropertyValueFactory<>("number"));
           
           idContactCol.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
           numberContactCol.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
           
           contactTable.setItems(contactTableContainer);
             
        } catch (SQLException ex) {
          ex.printStackTrace();
        }

        
    }
    @FXML
    private TableView<EmpLocation> locationTable;
    @FXML
    private TableColumn<EmpLocation, Long>idLocationCol;
    @FXML
    private TableColumn<EmpLocation, String>countryCol;
    @FXML
    private TableColumn <EmpLocation, String>cityCol;
    @FXML
    private TableColumn <EmpLocation, String>streetCol;
    private void searchAllLoc(){
        locTableContainer.clear();
             try {
            con = DriverManager.getConnection(App.ip, App.user, App.password);
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select ep.ssn, COUNTRY, CITY, STREET from  EMPLOYEE_LOCATION ep, EMPLOYEE e where ep.ssn = e.ssn and e.depid = "+LoginController.currentUser.substring(1,4));
            
            while(rs.next())
            {
                Long idTemp = rs.getLong(1);
                String country = rs.getString(2);
                String city = rs.getString(3);
                String street = rs.getString(4);
                locTableContainer.add(new EmpLocation(idTemp, street, city, country));
                
            }
            idLocationCol.setCellValueFactory(new PropertyValueFactory<>("id"));
            countryCol.setCellValueFactory(new PropertyValueFactory<>("country"));
            cityCol.setCellValueFactory(new PropertyValueFactory<>("city"));
            streetCol.setCellValueFactory(new PropertyValueFactory<>("street"));
            
            locationTable.setItems(locTableContainer);
    
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList <String> genders = FXCollections.observableArrayList("None", "Female", "Male");
        genderCombo.setItems(genders);
        genderCombo.getSelectionModel().select(0);
        
        tableView.setEditable(true);
        contactTable.setEditable(true);
        locationTable.setEditable(true);
        
        searchAllEmp();
        searchAllCont();
        searchAllLoc();
       
        
        
    }
    
    void visibleContact(boolean state){
        streetPane.setVisible(state);
        cityPane.setVisible(state);
        countryPane.setVisible(state); 
    }
    
    boolean InfoSelected = true;
        @FXML
    void openContactPane(MouseEvent event) {
        phonePane.setVisible(false);
        visibleContact(false);
        lblContact.setStyle("-fx-text-fill: #F8A918");
        lblInfo.setStyle("-fx-text-fill: #aeaeae");
        if(InfoSelected)
        {
        ContactPane.translateXProperty().set(850);
        ContactPane.setVisible(true);
        Timeline t = new Timeline();
        t.getKeyFrames().add(new KeyFrame(Duration.seconds(0.3),
        new KeyValue(ContactPane.translateXProperty(),0),
        new KeyValue(InformationPane.translateXProperty(),-850)));
        t.play();
         t.setOnFinished(e->{
        InfoSelected=false;});
        }
    }
        @FXML
    void openInformationPane(MouseEvent event) {
        
        
      
        if(!InfoSelected)
        {
            InfoSelected=false;
        lblInfo.setStyle("-fx-text-fill: #F8A918");
        lblContact.setStyle("-fx-text-fill: #aeaeae");
        Timeline t = new Timeline();
        t.getKeyFrames().add(new KeyFrame(Duration.seconds(0.3),
        new KeyValue(InformationPane.translateXProperty(),0),
        new KeyValue(ContactPane.translateXProperty(),850)));
        t.play();
        t.setOnFinished(e->{
        InfoSelected=true;});
        }
    }

        @FXML
    private void addEditCV(ActionEvent e) throws URISyntaxException, IOException{
        if(!tableView.getSelectionModel().isEmpty()){
        Employee temp = tableView.getSelectionModel().getSelectedItem();
            
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        File address = new File ("D:\\DataBase Project\\src\\main\\resources\\CVs\\users\\"+ Long.toString(temp.getSsn()) +"_CV.pdf") ;
            
        selectedFile.renameTo(address);
        }
    }

    @FXML
    void showCV(ActionEvent event) {
       if(!tableView.getSelectionModel().isEmpty()){
           Employee temp = tableView.getSelectionModel().getSelectedItem();
            File file; 
           try{
           file = new File (("D:\\DataBase Project\\src\\main\\resources\\CVs\\users\\"+Long.toString(temp.getSsn())+"_CV.pdf") );
           
              if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) 
               Desktop.getDesktop().browse(file.toURI());
           }
           catch(Exception e){
            e.printStackTrace();
   
        }
        
        
       }
    }
}

    

