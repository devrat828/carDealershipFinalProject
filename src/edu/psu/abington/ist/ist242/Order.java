/*
Project: Car Dealership
Purpose Details:
Course: IST 242
Team: 4
Date Developed:
Last Date Changed:
Rev: 1
*/

package edu.psu.abington.ist.ist242;

import java.util.*;


public class Order {

    int cCount = 0;

    //Class Level Variables - Protect the data
    private Customer cust;
    private Inventory menu;
    private int orderId, menuID;
    private int order;
    private int custID, quantity;
    private double price;
    private double totalPrice;



    // CONSTRUCTOR METHOD -----------------------------------------------------------------------------------------------
    public Order() {
    }
    public Order order() {
        Order or = new Order(cCount++);
        return or;
    }
    public Order(int _orderId) {
        this.orderId = _orderId;
    }
    public Order(int _orderId, double _totalPrice) {
        this.orderId = _orderId;
        this.price = _totalPrice;
    }


    // GETTERS AND SETTERS ---------------------------------------------------------------------------------------------

    public int getorderId() {
        return orderId;
    }
    public void setorderId(int _orderId) {
        this.orderId = _orderId;
    }
    public int getID (int _menuID) {
        return menuID;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder(){
        return order;
    }

}
