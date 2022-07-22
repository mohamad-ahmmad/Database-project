package com.app.garage.controllers.employee;

/**
 *
 * @author USER-M
 */
public class Receipt {
    private long id;
    private long dressID, receiptID;
    private String date;
    private int amount;
    
    public Receipt(long id, long rID, long dID, String d, int am){
        this.id=id;
        dressID=dID;
        receiptID=rID;
        date=d;
        amount=am;
    }
    
    public void setAmount(int amount){
        this.amount=amount;
    }
    public void setDate(String date){
        this.date = date;
    }
    public void setDressID(long dressID){
        this.dressID=dressID;
    }
    public void setReceiptID(long receiptID){
        this.receiptID=receiptID;
    }
    
    public String getDate(){
        return date;
    }
    public long getDressID(){
        return dressID;
    }
    public long getReceiptID(){
        return receiptID;    
    }
    public int getAmount(){
        return amount;
    }
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id=id;
    }
    
}
