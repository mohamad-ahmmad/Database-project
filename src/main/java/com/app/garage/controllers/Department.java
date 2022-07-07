/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

/**
 *
 * @author Bdair
 */
public class Department {
    private CheckBox check;
    private final SimpleIntegerProperty SSN;
    private final SimpleStringProperty Name;
    private final SimpleStringProperty Address;
    private final SimpleStringProperty Birthdate;
    private final SimpleIntegerProperty Phone;
    public Department(Integer SSN, String name, String Address, String Birthdate, Integer Phone, CheckBox check){
        this.SSN= new SimpleIntegerProperty(SSN);
        this.Name= new SimpleStringProperty(name);
        this.Address= new SimpleStringProperty(Address);
        this.Birthdate= new SimpleStringProperty(Birthdate);
        this.Phone= new SimpleIntegerProperty(Phone);
        this.check = check;
    }
 
    public int getSSN() {
        return SSN.get();
    }

    public String getName() {
        return Name.get();
    }

    public String getAddress() {
        return Address.get();
    }

    public String getBirthdate() {
        return Birthdate.get();
    }

    public int getPhone() {
        return Phone.get();
    }
    
    
}
