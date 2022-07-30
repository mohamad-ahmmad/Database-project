/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.warehouseManager;

/**
 *
 * @author Bdair
 */
public class Clothes {
    String dressName, dressSize,dressColor, brandName, preview;
    Long dressID, WSPrice, Price, Stock, SupplierID;
    Long Wid;
    public Clothes(Long Wid, Long ID, Long stock){
        this.dressID=ID;
        this.Wid=Wid;
        this.Stock=stock;
    }

    public Long getWid() {
        return Wid;
    }

    public void setWid(Long Wid) {
        this.Wid = Wid;
    }

    public Clothes(String dressName, String dressSize, String dressColor, String brandName, String preview, Long dressID, Long WSPrice, Long Price, Long Stock, Long SupplierID) {
        this.dressName = dressName;
        this.dressSize = dressSize;
        this.dressColor = dressColor;
        this.brandName = brandName;
        this.preview = preview;
        this.dressID = dressID;
        this.WSPrice = WSPrice;
        this.Price = Price;
        this.Stock = Stock;
        this.SupplierID = SupplierID;
    }

    public String getDressName() {
        return dressName;
    }

    public String getDressSize() {
        return dressSize;
    }

    public String getDressColor() {
        return dressColor;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getPreview() {
        return preview;
    }

    public Long getDressID() {
        return dressID;
    }

    public Long getWSPrice() {
        return WSPrice;
    }

    public Long getPrice() {
        return Price;
    }

    public Long getStock() {
        return Stock;
    }

    public Long getSupplierID() {
        return SupplierID;
    }

    public void setDressName(String dressName) {
        this.dressName = dressName;
    }

    public void setDressSize(String dressSize) {
        this.dressSize = dressSize;
    }

    public void setDressColor(String dressColor) {
        this.dressColor = dressColor;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public void setDressID(Long dressID) {
        this.dressID = dressID;
    }

    public void setWSPrice(Long WSPrice) {
        this.WSPrice = WSPrice;
    }

    public void setPrice(Long Price) {
        this.Price = Price;
    }

    public void setStock(Long Stock) {
        this.Stock = Stock;
    }

    public void setSupplierID(Long SupplierID) {
        this.SupplierID = SupplierID;
    }
    
    
}
