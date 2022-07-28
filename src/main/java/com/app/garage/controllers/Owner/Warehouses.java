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
    Long WID;
    String WName,Country,City,Street;
    Long WCapacity;
    Long ManagerID;

    public Warehouses(Long WID, String WName, String Country, String City, String Street, Long WCapacity, Long ManagerID) {
        this.WID = WID;
        this.WName = WName;
        this.Country = Country;
        this.City = City;
        this.Street = Street;
        this.WCapacity = WCapacity;
        this.ManagerID = ManagerID;
    }

    public Long getWID() {
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

    public Long getWCapacity() {
        return WCapacity;
    }

    public Long getManagerID() {
        return ManagerID;
    }

    public void setWID(Long WID) {
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

    public void setWCapacity(Long WCapacity) {
        this.WCapacity = WCapacity;
    }

    public void setManagerID(Long ManagerID) {
        this.ManagerID = ManagerID;
    }
    
    
}
