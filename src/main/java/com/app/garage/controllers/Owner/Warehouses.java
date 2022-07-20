/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.Owner;

/**
 *
 * @author Bdair
 */
public class Warehouses {
    Integer WID;
    String WName,Country,City,Street;
    Integer WCapacity;
    Double ManagerID;

    public Warehouses(Integer WID, String WName, String Country, String City, String Street, Integer WCapacity, Double ManagerID) {
        this.WID = WID;
        this.WName = WName;
        this.Country = Country;
        this.City = City;
        this.Street = Street;
        this.WCapacity = WCapacity;
        this.ManagerID = ManagerID;
    }

    public Integer getWID() {
        return WID;
    }

    public String getWName() {
        return WName;
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

    public Integer getWCapacity() {
        return WCapacity;
    }

    public Double getManagerID() {
        return ManagerID;
    }

    public void setWID(Integer WID) {
        this.WID = WID;
    }

    public void setWName(String WName) {
        this.WName = WName;
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

    public void setWCapacity(Integer WCapacity) {
        this.WCapacity = WCapacity;
    }

    public void setManagerID(Double ManagerID) {
        this.ManagerID = ManagerID;
    }
    
    
}
