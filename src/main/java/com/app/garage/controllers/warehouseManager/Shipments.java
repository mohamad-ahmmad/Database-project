package com.app.garage.controllers.warehouseManager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Bdair
 */
public class Shipments {
    Long SN, supplierID, shipmentCost;
    String shipmentDate;

    public Shipments(Long SN, Long supplierID, Long shipmentCost, String shipmentDate) {
        this.SN = SN;
        this.supplierID = supplierID;
        this.shipmentCost = shipmentCost;
        this.shipmentDate = shipmentDate;
    }

    public Long getSN() {
        return SN;
    }

    public Long getSupplierID() {
        return supplierID;
    }

    public Long getShipmentCost() {
        return shipmentCost;
    }

    public String getShipmentDate() {
        return shipmentDate;
    }

    public void setSN(Long SN) {
        this.SN = SN;
    }

    public void setSupplierID(Long supplierID) {
        this.supplierID = supplierID;
    }

    public void setShipmentCost(Long shipmentCost) {
        this.shipmentCost = shipmentCost;
    }

    public void setShipmentDate(String shipmentDate) {
        this.shipmentDate = shipmentDate;
    }
    
}
