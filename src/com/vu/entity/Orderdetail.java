/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vu.entity;

/**
 *
 * @author UNQ
 */
public class Orderdetail {
    private long id;
    private long orderID;
    private int productID;
    private int quantity;
    private float unitprice;
    private float discount;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(float unitprice) {
        this.unitprice = unitprice;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public Orderdetail() {
    }
    
    public Orderdetail(long id, long orderID, int productID, int quantity, float unitprice, float discount) {
        this.id = id;
        this.orderID = orderID;
        this.productID = productID;
        this.quantity = quantity;
        this.unitprice = unitprice;
        this.discount = discount;
    }
    public Orderdetail( long orderID, int productID, int quantity, float unitprice, float discount){
        this.orderID = orderID;
        this.productID = productID;
        this.quantity = quantity;
        this.unitprice = unitprice;
        this.discount = discount;
    }
    
}
