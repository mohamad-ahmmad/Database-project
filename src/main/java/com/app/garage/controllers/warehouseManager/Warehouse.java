/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.warehouseManager;

/**
 *
 * @author Bdair
 */
public class Warehouse {
    Long ID,Capacity,ManagerID;

    public void setManagerID(Long ManagerID) {
        this.ManagerID = ManagerID;
    }

    public Long getManagerID() {
        return ManagerID;
    }
    String Name,Country,City,Street;

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setCapacity(Long Capacity) {
        this.Capacity = Capacity;
    }

    public void setName(String Name) {
        this.Name = Name;
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

    public Long getID() {
        return ID;
    }

    public Long getCapacity() {
        return Capacity;
    }

    public String getName() {
        return Name;
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

    public Warehouse(Long ID, Long Capacity, String Name, String Country, String City, String Street, Long m) {
        this.ID = ID;
        this.Capacity = Capacity;
        this.Name = Name;
        this.Country = Country;
        this.City = City;
        this.Street = Street;
        this.ManagerID=m;
    }
    
}
