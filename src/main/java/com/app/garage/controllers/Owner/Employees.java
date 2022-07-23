/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.Owner;

/**
 *
 * @author Bdair
 */
public class Employees {
    Long SSN,IDCard,officeTelephone, phoneNumber;
    String firstName,middleName,lastName,Type,hireDate,birthDate;
    String gender,country,city,street;
    Long Salary;

    public Employees(Long SSN,Long phonenumber){
        this.SSN= SSN;
        this.phoneNumber=phonenumber;
    }
        public Employees(Long SSN,String country, String city, String street){
        this.SSN= SSN;
        this.city=city;
        this.country=country;
        this.street=street;
    }
    public String getCountry(){
    return this.country;
    }
    public String getCity(){
        return this.city;
    }
    public String getStreet(){
        return this.street;
    }
    public void setCountry(String country){
        this.country= country;
    }
    public void setStreet(String street){
    this.street= street;
    }
    public void setCity(String city){
    this.city= city;
    }
    
        
        public Long getSSN() {
        return SSN;
    }
    public Employees(Long SSN, Long IDCard, Long officeTelephone, String firstName, String middleName, String lastName, String Type, String hireDate, String birthDate, String gender, Long Salary) {
        this.SSN = SSN;
        this.IDCard = IDCard;
        this.officeTelephone = officeTelephone;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.Type = Type;
        this.hireDate = hireDate;
        this.birthDate = birthDate;
        this.gender = gender;
        this.Salary = Salary;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }
    void setPhoneNumber(Long phoneNumber){
        this.phoneNumber=phoneNumber;
    }

    public Long getIDCard() {
        return IDCard;
    }

    public Long getOfficeTelephone() {
        return officeTelephone;
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

    public String getType() {
        return Type;
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

    public Long getSalary() {
        return Salary;
    }

    public void setSSN(Long SSN) {
        this.SSN = SSN;
    }

    public void setIDCard(Long IDCard) {
        this.IDCard = IDCard;
    }

    public void setOfficeTelephone(Long officeTelephone) {
        this.officeTelephone = officeTelephone;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSalary(Long Salary) {
        this.Salary = Salary;
    }
    
    
    
    
}
