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

public class salesPerson extends User {

    //Constructor Method
    public salesPerson(int userId) {
        setUserId(userId);
    }

    //Empty Constructor Method
    public salesPerson()
    {}

    //Constructor
    public salesPerson(int userId, String userName, String phone, String address){
        setUserId(userId);
        setUserName(userName);
        setUserPhone(phone);
        setUserAddress(address);
    }
    /**
    printSalesPerson method
    @context        prints all details in the arraylist of salesPerson
    @param sList    arraylist of salesPerson
    @returns        Nothing
    @version        1.0
    @since          2020-06-26
     @author        Team 4
    */
    public static void printSalesPerson(ArrayList<salesPerson> sList){
        for (salesPerson sPerson: sList){
            System.out.printf("%-15s | %-15s | %-15s | %-15s\n", sPerson.getUserId(), sPerson.getUserName(), sPerson.getUserPhone(), sPerson.getUserAddress());
        }
    }
}