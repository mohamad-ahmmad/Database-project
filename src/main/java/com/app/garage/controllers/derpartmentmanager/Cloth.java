/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.derpartmentmanager;

/**
 *
 * @author USER-M
 */
public class Cloth {
   private long dressId;
   private String name, size, color, brandName, history;
   private int whprice, price, stock, salepercentage, warehouseId;

    public Cloth(long dressId, String name, String size, String color, String brandName, String history, int whprice, int price, int stock, int salepercentage, int warehouseId) {
        this.dressId = dressId;
        this.name = name;
        this.size = size;
        this.color = color;
        this.brandName = brandName;
        this.history = history;
        this.whprice = whprice;
        this.price = price;
        this.stock = stock;
        this.salepercentage = salepercentage;
        this.warehouseId = warehouseId;
    }

   
   
    public long getDressId() {
        return dressId;
    }

    public void setDressId(long dressId) {
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

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public int getWhprice() {
        return whprice;
    }

    public void setWhprice(int whprice) {
        this.whprice = whprice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSalepercentage() {
        return salepercentage;
    }

    public void setSalepercentage(int salepercentage) {
        this.salepercentage = salepercentage;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }
   
   
}
