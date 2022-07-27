/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.derpartmentmanager;

/**
 *
 * @author USER-M
 */
public class Warehouse {
    
    private Long dressId;
    private String name, size, color, brandName;
    private int stock, warehouseId, wprice, price;

    public Warehouse(Long dressId, String name, String size, String color, String brandName, int stock, int warehouseId, int wPrice, int price) {
        this.dressId = dressId;
        this.name = name;
        this.size = size;
        this.color = color;
        this.brandName = brandName;
        this.stock = stock;
        this.warehouseId = warehouseId;
        this.wprice = wPrice;
        this.price = price;
    }

    
    
    
    public Long getDressId() {
        return dressId;
    }

    public void setDressId(Long dressId) {
        this.dressId = dressId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public int getWprice() {
        return wprice;
    }

    public void setWprice(int wPrice) {
        this.wprice = wPrice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
    
}
