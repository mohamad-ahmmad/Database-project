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
import com.jfoenix.controls.JFXButton;
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
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
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
import java.sql.PreparedStatement;
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
    private TextField hirePicker, birthPicker;
    
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
    private TableColumn<Employee, String> sectionCol;
    
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
    void deleteEmployeeee(ActionEvent event) {
      Employee temp = tableView.getSelectionModel().getSelectedItem();
      
       try {
           
            con = DriverManager.getConnection(App.ip, App.user, App.password);
            Statement st = con.createStatement();
            
            //st.executeUpdate("update EMPLOYEE set IDCARD = NULL");
                    
            st.executeUpdate("delete from EMPLOYEE where SSN="+temp.getSsn());
            con.close();
            searchAllEmp();
            
            //ps.close();
            
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
       
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
            
            ResultSet rs =  sAll.executeQuery("select e.SSN, FIRSTNAME, MIDDLENAME, LASTNAME, HIREDATE, BIRTHDATE, GENDER, SALARY, IDCARD, EPASSWORD, SECTION from EMPLOYEE e left join ASSISTANT a "
                                             + " ON a.ssn=e.ssn "
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
               String section = rs.getString(11);
               
               // public Employee(Long ssn, String firstName, String middleName, String lastName, String hireDate, String birthDate, int age, String gender, int salary, String idCard, String password) {
               empTableContainer.add(new Employee(id, firstName, section,middleName, lastName, hireDate, birthDate, gender, salary, idCard, password));
            }
              tableView.setItems(empTableContainer);
          
          
            
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
           
           
           numberContactCol.setOnEditCommit(e->{
           
                try {
                    con = DriverManager.getConnection(App.ip, App.user, App.password);
                    Statement update = con.createStatement();
                    update.executeUpdate("update EMPLOYEE_PHONENUMBER set PHONENUMBER ="+e.getNewValue()+" where SSN ="+e.getRowValue().getId());
                    
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
           });
           
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
            
            countryCol.setCellFactory(TextFieldTableCell.forTableColumn());
            countryCol.setOnEditCommit(e->{
            
                try {
                    con = DriverManager.getConnection(App.ip, App.user, App.password);
                    Statement update = con.createStatement();
                    update.executeUpdate("update EMPLOYEE_LOCATION set COUNTRY ='"+e.getNewValue()+"' where SSN="+e.getRowValue().getId());
                            
                    
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                
                
            });
            cityCol.setCellFactory(TextFieldTableCell.forTableColumn());
             cityCol.setOnEditCommit(e->{
            
                try {
                    con = DriverManager.getConnection(App.ip, App.user, App.password);
                    Statement update = con.createStatement();
                    update.executeUpdate("update EMPLOYEE_LOCATION set CITY ='"+e.getNewValue()+"' where SSN="+e.getRowValue().getId());
                            
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                
                
            });
             
               streetCol.setCellFactory(TextFieldTableCell.forTableColumn());
             streetCol.setOnEditCommit(e->{
            
                try {
                    con = DriverManager.getConnection(App.ip, App.user, App.password);
                    Statement update = con.createStatement();
                    update.executeUpdate("update EMPLOYEE_LOCATION set STREET ='"+e.getNewValue()+"' where SSN="+e.getRowValue().getId());
                            
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                
                
            });
            idLocationCol.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
            locationTable.setItems(locTableContainer);
    
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
    }
    @FXML
    private MFXButton deleteEmployee;
    @FXML
    private JFXButton deleteContact;
    @FXML
    private JFXButton deleteLocation;
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
          sectionCol.setCellValueFactory(new PropertyValueFactory<>("section"));
          
          sectionCol.setCellFactory(TextFieldTableCell.forTableColumn());
          sectionCol.setOnEditCommit(e->{
          
            try {
                con = DriverManager.getConnection(App.ip, App.user, App.password);
                Statement st = con.createStatement();
                st.executeUpdate("update ASSISTANT set SECTION ='"+e.getNewValue()+"' where ssn="+e.getRowValue().getSsn());
                
                searchAllEmp();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
              
          });
          
        deleteContact.setDisable(true);
        deleteEmployee.setDisable(true);
        deleteLocation.setDisable(true);
        
        tableView.getSelectionModel().selectedItemProperty().addListener(e->{
           deleteEmployee.setDisable(false);
        });
          contactTable.getSelectionModel().selectedItemProperty().addListener(e->{
          deleteContact.setDisable(false);
        });
          locationTable.getSelectionModel().selectedItemProperty().addListener(e->{
         deleteLocation.setDisable(false);
        });
          
        
        
              
        
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
    //CV EMPLOYEES
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

          Alert s = new Alert(Alert.AlertType.ERROR);
          s.setTitle("NOT FOUND 404");
          s.setContentText("CV doesn't exist,please add a cv.");
          s.show();
               return;
           }
 

         
        }
        
        
       }
    
    @FXML
    private MFXTextField phoneNumberContact;

    @FXML
    private MFXTextField ssnContact;
       
       @FXML
       private void addContact(ActionEvent e){
           
           FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/DepartmentManagerPage/add-contact.fxml"));
           loader.setController(this);
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage temp = new Stage();
            temp.setScene(scene);
            temp.initModality(Modality.APPLICATION_MODAL);
            temp.initStyle(StageStyle.TRANSPARENT);
            temp.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
           
           
       }
       private static final String cssErorr = "-fx-border-color:rgba(255,0,0,0.4)";
       @FXML 
       private void contactDone(ActionEvent e){
           String ssn = ssnContact.getText();
           String phoneNumber = phoneNumberContact.getText();
         if(ssn.length() != 10){
             ssnContact.setStyle(cssErorr);
             return;
         }
         try{
             Long.parseLong(ssn);
            
         }catch(Exception ex){
             ssnContact.setStyle("");
             return;
         }try{
             Long.parseLong(phoneNumber);
         }catch(Exception ex){
             phoneNumberContact.setStyle(cssErorr);
             return;
         }
         
        try {
            con = DriverManager.getConnection(App.ip, App.user, App.password);
            Statement st = con.createStatement();
            
            st.executeUpdate("insert into EMPLOYEE_PHONENUMBER (SSN, PHONENUMBER) values ( "+ssn+", "+phoneNumber+")");
            
            con.close();
        } catch (SQLException ex) {
           ssnContact.setStyle(cssErorr);
           phoneNumberContact.setStyle("");
           ex.printStackTrace();
        }
          ((Stage)((Node)e.getSource()).getScene().getWindow()).close();  
          searchAllCont();
           
       }
       
       @FXML
       private void contactCancel(ActionEvent e){
          ((Stage)((Node)e.getSource()).getScene().getWindow()).close();  
       }
       
       
       @FXML
       private void addLocation(ActionEvent e){
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/DepartmentManagerPage/add-location.fxml"));
           loader.setController(this);
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage temp = new Stage();
            temp.setScene(scene);
            temp.initModality(Modality.APPLICATION_MODAL);
            temp.initStyle(StageStyle.TRANSPARENT);
            temp.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
           
       }
       
       @FXML
       private MFXTextField ssnLocation, country, city, street;
       
       @FXML
       private void locationCancel(ActionEvent e){
           ((Stage)((Node)e.getSource()).getScene().getWindow()).close();  
       }
       @FXML
       private void locationDone(ActionEvent e){
           String ssn = ssnLocation.getText();
           String sCountry = country.getText();
           String sCity = city.getText();
           String sStreet = street.getText();
           
           if(sCountry.isEmpty()){
               country.setStyle(cssErorr);
               return;
           }
           if(sCity.isEmpty()){
               city.setStyle(cssErorr);
               return;
           }
           
        try {
            con = DriverManager.getConnection(App.ip, App.user, App.password);
            Statement st = con.createStatement();
            st.executeUpdate("insert into EMPLOYEE_LOCATION (SSN, COUNTRY, CITY, STREET) values ("+ssn+", '"+sCountry+"', '"+sCity+"', '"+sStreet+"')");
            
            con.close();
        } catch (SQLException ex) {
            ssnLocation.setStyle(cssErorr);
            country.setStyle("");
            city.setStyle("");
            ex.printStackTrace();
        }
        ((Stage)((Node)e.getSource()).getScene().getWindow()).close();  
          searchAllLoc();
       }
       
       
       
       @FXML
       private void deleteLocation(ActionEvent e){
                EmpLocation temp = locationTable.getSelectionModel().getSelectedItem();
           
        try {
            con = DriverManager.getConnection(App.ip, App.user, App.password);
            Statement st = con.createStatement();
            st.executeUpdate("delete from EMPLOYEE_LOCATION where SSN="+temp.getId()+" AND COUNTRY='"+temp.getCountry()+"' AND CITY='"+temp.getCity()+"' AND STREET='"+temp.getStreet()+"' ");
            searchAllLoc();
            con.close();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
       }
       
       @FXML
       private void deleteContact (ActionEvent e){
           Contact temp = contactTable.getSelectionModel().getSelectedItem();
           
        try {
            con = DriverManager.getConnection(App.ip, App.user, App.password);
            Statement st = con.createStatement();
            st.executeUpdate("delete from EMPLOYEE_PHONENUMBER where SSN="+temp.getId()+" AND PHONENUMBER="+temp.getNumber());
            searchAllCont();
            con.close();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
           
           
       }
       
       
       @FXML
       private void searchEmp(ActionEvent e){
           
        try {
            String bgen = (String)genderCombo.getSelectionModel().getSelectedItem();
            String gen = bgen.equals("None")?"":bgen.toLowerCase().substring(0,1);

            con = DriverManager.getConnection(App.ip, App.user, App.password);
            Statement st=con.createStatement();
                ResultSet rs =  st.executeQuery("select e.SSN, FIRSTNAME, MIDDLENAME, LASTNAME, HIREDATE, BIRTHDATE, GENDER, SALARY, IDCARD, EPASSWORD, SECTION from EMPLOYEE e left join ASSISTANT a on e.ssn = a.ssn  "
                                             +" where DEPID ="+LoginController.currentUser.substring(1,4)+" AND SSN LIKE '%"+ssnText.getText()+"%' "
                                             +" AND FIRSTNAME LIKE '%"+firstText.getText()+"%' AND MIDDLENAME LIKE '%"+middleText.getText()+"%' "
                                             +" AND LASTNAME LIKE '%"+lastText.getText()+"%' AND HIREDATE LIKE '%"+hirePicker.getText()+"%' AND BIRTHDATE LIKE '%"+birthPicker.getText()+"%' "
                                             +" AND GENDER LIKE '%"+gen+"%' AND SALARY LIKE '%"+salaryText.getText()+"%' AND IDCARD LIKE '%"+cardText.getText()+"%' "
                                              );
                
                empTableContainer.clear();
                while(rs.next()){
                    Long ssn = rs.getLong(1);
                    String f = rs.getString(2);
                    String m = rs.getString(3);
                    String l = rs.getString(4);
                    String hire= rs.getString(5);
                    String birth= rs.getString(6);
                    String gender = rs.getString(7);
                    int salary = rs.getInt(8);
                    int idcard = rs.getInt(9);
                    String pass = rs.getString(10);
                    String sec = rs.getString(11);
                    empTableContainer.add(new Employee(ssn, f, sec, m, l, hire, birth, gender, salary, idcard, pass ));
                }
                
                tableView.setItems(empTableContainer);
            
            con.close();
            
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
           
       }
       
       @FXML
       TextField ssnContactSearch, phoneField;
       
       @FXML
       private void searchContactLocation(ActionEvent e){
           contactTableContainer.clear();
           locTableContainer.clear();
           
        try {
            con = DriverManager.getConnection(App.ip, App.user, App.password);
            Statement st= con.createStatement();
            
           // ResultSet loc = st.executeQuery("select ");
            ResultSet cont = st.executeQuery("select ep.ssn, phonenumber from  EMPLOYEE_PHONENUMBER ep, EMPLOYEE e where ep.ssn = e.ssn and e.depid = "+LoginController.currentUser.substring(1,4)+" AND e.ssn like '%"+ssnContactSearch.getText()+"%' AND phonenumber like '%"+phoneField.getText()+"%' " );
            while(cont.next()){
                long ssnContact = cont.getLong(1);
                long phoneContact = cont.getLong(2);
               contactTableContainer.add(new Contact(ssnContact, phoneContact));
            }
            
            //while loop for location to preform  prallel searching
            ResultSet loc = st.executeQuery("select el.SSN, el.COUNTRY, el.CITY, el.STREET from EMPLOYEE_LOCATION el, EMPLOYEE e where el.ssn = e.ssn and e.depid = "+LoginController.currentUser.substring(1,4)+" AND el.COUNTRY like '%"+countryField.getText()+"%' AND el.CITY like '%"+cityField.getText()+"%' AND STREET like '%"+streetField.getText()+"%' ");
            
             while(loc.next())
            {
                Long idTemp = loc.getLong(1);
                String country = loc.getString(2);
                String city = loc.getString(3);
                String street = loc.getString(4);
                locTableContainer.add(new EmpLocation(idTemp, street, city, country));
                
            }
            
            locationTable.setItems(locTableContainer);
            contactTable.setItems(contactTableContainer);
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
           
       }
       
 }


    

