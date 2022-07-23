/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.employee;

/** 
 *                    
 * @author USER-M
 */
public class Dress {
    
    private long id;
    private String name;
    private String color;
    private String size;
    private int price;
    private int priceOffer;
    private String brand;
    private String sale;
    private int stock;
     public Dress(long id, String name, String color, String size, int price, int priceOffer, String brand, String sale, int stock){
         this.id=id;
         this.name=name;
         this.color=color;
         this.size=size;
         this.price=price;
         this.priceOffer=priceOffer;
         this.brand=brand;
         this.sale=sale;
         this.stock=stock;
         
     }
    public long getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public String getColor(){
        return color;
    }
    
    public String getSize(){
        return size;
    }
    public int getPrice (){
        return price;
    }
    public int getPriceOffer(){
        return priceOffer;
    }
    
    public String getBrand(){
        return brand;
    }
    public String getSale(){
        return sale;
    }
    
    public int getStock(){
        return stock;
    }
    
    public void setId(long id){
        this.id =id;
    }
    
    public void setName( String name ){
        this.name = name;
    }
    
    public void setColor(String color){
        this.color = color;
    }
    
    public void setSize(String size){
        this.size = size;
    }
    public void setPrice (int price){
        this.price=price;
    }
    public void setPriceOffer(int priceOffer){
        this.priceOffer=priceOffer;
    }
    
    public void setBrand(String brand){
        this.brand = brand;
    }
    public void setSale(String sale){
        this.sale=sale;
    }
    
    public void setStock(int stock){
        this.stock=stock;
    }
    
        
    
}
