/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.warehouseManager;

/**
 *
 * @author Bdair
 */
public class Supplier {
    Long supplierID,telephoneNumber,Cost;
    String supplierName,emailAddress, Country,City,Street;
    public Supplier(Long ID,String country, String City, String Street, Long cost){
        this.City=City; this.Country= country; this.Street= Street; this.supplierID= ID; this.Cost=cost;
    }

    public void setCost(Long Cost) {
        this.Cost = Cost;
    }

    public Long getCost() {
        return Cost;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getCountry() {
        return Country;
    }

    public String getCity() {
        return City;
    }

    public String getStreet() {
        return Street;
    }

    public Supplier(Long supplierID, Long telephoneNumber, String supplierName, String emailAddress) {
        this.supplierID = supplierID;
        this.telephoneNumber = telephoneNumber;
        this.supplierName = supplierName;
        this.emailAddress = emailAddress;
    }

    public Long getSupplierID() {
        return supplierID;
    }

    public Long getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setSupplierID(Long supplierID) {
        this.supplierID = supplierID;
    }

    public void setTelephoneNumber(Long telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    
}
