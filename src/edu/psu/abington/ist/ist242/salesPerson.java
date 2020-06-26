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

    public salesPerson(int userId) {
        setUserId(userId);
    }

    public salesPerson()
    {}
    public static void printSalesPerson(ArrayList<salesPerson> sList){
        for (salesPerson sPerson: sList){
            System.out.printf("%-15s | %-15s | %-15s | %-15s\n", sPerson.getUserId(), sPerson.getUserName(), sPerson.getUserPhone(), sPerson.getUserAddress());
        }
    }
}