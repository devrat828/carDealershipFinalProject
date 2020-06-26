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




    public Customer(int userId) {
        setUserId(userId);
    }


    public Customer(){}


    public static void printCustomer(ArrayList<Customer> cList){
        System.out.println("Customer List in the system");
        for (Customer cust: cList){
            System.out.printf("%-15s | %-15s | %-15s | %-15s\n", cust.getUserId(), cust.getUserName(), cust.getUserPhone(), cust.getUserAddress());
        }
    }

}