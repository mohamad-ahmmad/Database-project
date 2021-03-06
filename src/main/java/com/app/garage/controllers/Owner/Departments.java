/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.Owner;

import java.util.Date;

public class Departments {
    Long DID;
    String DName,Country,City,Street;
    String openingDate;
    Long ManagerID;

    public Departments(Long DID, String DName, String Country, String City, String Street, String openingDate, Long ManagerID) {
        this.DID = DID;
        this.DName = DName;
        this.Country = Country;
        this.City = City;
        this.Street = Street;
        this.openingDate = openingDate;
        this.ManagerID = ManagerID;
    }

    public void setID(Long ID) {
        this.DID = DID;
    }

    public void setDName(String DName) {
        this.DName = DName;
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

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }

    public void setManagerID(Long ManagerID) {
        this.ManagerID = ManagerID;
    }

    public Long getDID() {
        return DID;
    }

    public String getDName() {
        return DName;
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

    public String getOpeningDate() {
        return openingDate;
    }

    public Long getManagerID() {
        return ManagerID;
    }
  
    
}
