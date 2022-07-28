/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers.Owner;

/**
 *
 * @author USER-M
 */
public class LogProfit {
    private String name,date;
    private int amount, wsprice,price,totPrice,netprofit;

    public LogProfit(String name, String date, int amount, int wsprice, int price, int totPrice, int netprofit) {
        this.name = name;
        this.date=date;
        this.amount = amount;
        this.wsprice = wsprice;
        this.price = price;
        this.totPrice = totPrice;
        this.netprofit = netprofit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getWsprice() {
        return wsprice;
    }

    public void setWsprice(int wsprice) {
        this.wsprice = wsprice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotPrice() {
        return totPrice;
    }

    public void setTotPrice(int totPrice) {
        this.totPrice = totPrice;
    }

    public int getNetprofit() {
        return netprofit;
    }

    public void setNetprofit(int netprofit) {
        this.netprofit = netprofit;
    }
    
    
    
    
}
