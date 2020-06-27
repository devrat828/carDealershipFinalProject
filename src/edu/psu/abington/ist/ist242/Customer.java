/*
Project: Car Design
Purpose Details: Car Dealership Application
Course: IST 242
Team 4
Developed: June 14, 2020
Last date Changed: June 21, 2020
Rev: 1
*/
package edu.psu.abington.ist.ist242;
import java.util.*;
public class Customer extends User {

    //Constructor Method
    public Customer(int userId) {
        setUserId(userId);
    }

    //Constructor Method
    public Customer(int userId, String userName, String phone, String address){
        setUserId(userId);
        setUserName(userName);
        setUserPhone(phone);
        setUserAddress(address);
    }

    //Empty Constructor
    public Customer(){}

    /**
    PrintCustomer method
    @context        prints all details in the arraylist of customer
    @param cList    arraylist of customer
    @returns        Nothing
    @version        1.0
    @since          2020-06-26
    @author         Team 4
    */
    public static void printCustomer(ArrayList<Customer> cList){
        for (Customer cust: cList){
            System.out.printf("%-15s | %-15s | %-15s | %-15s\n", cust.getUserId(), cust.getUserName(), cust.getUserPhone(), cust.getUserAddress());
        }
    }


}