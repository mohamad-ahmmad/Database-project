/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.derpartmentmanager;

import javafx.beans.property.LongProperty;

/**
 *
 * @author USER-M
 */
public class Employee {
 
    private long ssn;
    private String firstName;
    private String middleName;
    private String lastName;
    private String hireDate;
    private String birthDate;
    private String section;
    private String gender;
    private int salary;
    private int idCard;
    private String password;


    public Employee(long ssn, String firstName, String section, String middleName, String lastNamel, String hireDate, String birthDate, String gender, int salary, int idCard, String password) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastNamel;
        this.hireDate = hireDate;
        this.birthDate = birthDate;
        this.section=section;
        this.gender = gender;
        this.salary = salary;
        this.idCard = idCard;
        this.password = password;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
    
    public void setSsn(long ssn){
        this.ssn=ssn;
    }
      public void setFirstName(String first){
        firstName = first;
    }
      public void setGender(String gen){
          gender=gen;
      }
      public void setMiddleName(String middle){
          middleName = middle;
      }
      public void setLastName(String last){
          lastName=last;
      }
      public void setHireDate (String date){
          hireDate = date;
      }
      public void setBirthDate (String date) {
          birthDate = date ;
      }

      public void setSalary( int s){
          salary = s;
      }
      public void setIdCard (int id){
          idCard=id;
      }
     
      public void setPassword(String pass){
          password = pass;
      }

    public long getSsn() {
        return ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHireDate() {
        return hireDate;
    }

    public String getBirthDate() {
        return birthDate;
    }



    public String getGender() {
        return gender;
    }

    public int getSalary() {
        return salary;
    }

    public int getIdCard() {
        return idCard;
    }

    public String getPassword() {
        return password;
    }
      
      
      
      
}
   // public Employee(Long ssn, String firstName, String middleName, String lastName, String hireDate, String birthDate, int age, String gender, int salary, String idCard, String password) {