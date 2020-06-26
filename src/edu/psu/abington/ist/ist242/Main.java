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

public class Main {

    int cCount = 0;
    int sCount = 0;

    public static void main(String[] args) {

        double subTotal;
        double orderTotal = 0;

        // Main object
        Main main = new Main();
        // Customer obj
        Customer cust = new Customer();
        // salesPerson obj
        salesPerson sPerson = new salesPerson();
        // Order obj
        Order or = new Order();
        // Inventory object
        Inventory inv = new Inventory();
        // Transaction object
        Transaction trans = new Transaction();

        // ARRAYLISTS -------------------------------------------------------------------------------------------------------------------------------------------------
        ArrayList<Customer> cList = new ArrayList<>();
        ArrayList<Inventory> iList = new ArrayList<>();
        ArrayList<Order> oList = new ArrayList<>();
        ArrayList<Transaction> tList = new ArrayList<>();
        ArrayList<salesPerson> sList = new ArrayList<>();

        // INVENTORY LIST ---------------------------------------------------------------------------------------------------------------------------------------------
        Inventory inv1 = new Inventory(1, "2020", "Honda", "Civic", 26899.99);
        Inventory inv2 = new Inventory(2, "2021", "Ford", "Explorer", 46799.99);
        Inventory inv3 = new Inventory(3, "2021", "Jeep", "Grand Cherokee", 39899.99);
        Inventory inv4 = new Inventory(4, "2021", "Chevrolet", "Pickup", 42699.99);

        iList.add(inv1);
        iList.add(inv2);
        iList.add(inv3);
        iList.add(inv4);


        System.out.println("---------------------------------------------------------");
        System.out.println("                   Car Dealership                        ");
        System.out.println("                        by:                              ");
        System.out.println("                      Team 4                             ");
        System.out.println("---------------------------------------------------------");

        final char CUST_CODE = '1'; //customer page
        final char PRINT_CUST = '2'; //print cust
        final char INV_CODE = '3'; //inventory page
        //final char SALES_CODE = '4'; //sales person
        final char ORDER_CODE = '4'; //order page
        final char TRANS_CODE = '5'; //transaction page
        final char EXIT_CODE = 'E';
        final char S_CODE = 'S';
        final char SP_CODE = '6';
        char userAction;


        final String PROMPT_ACTION = "\nMAIN MENU: \n1 - Add Customer\n2 - Print Customers\n3 - Inventory Page\n4 - Sell Car\n5 - Transaction Page\nS - Add Employee\n6 - Print Employees\nE - Exit\nPlease Enter your Selection: ";

        userAction = getAction(PROMPT_ACTION);

        while (userAction != EXIT_CODE) {
            switch (userAction) {
                case CUST_CODE: // Customers page
                    cList.add(main.addCustomer());
                    break;
                case PRINT_CUST:
                    System.out.printf("%-15s | %-15s | %-15s | %-15s\n", "ID", "Name", "Phone Number", "Address");
                    Customer.printCustomer(cList);
                    break;
                case S_CODE: // Employee page
                    sList.add(main.addSalesPerson());
                    break;
                case SP_CODE:
                    System.out.printf("%-15s | %-15s | %-15s | %-15s\n", "ID", "Name", "Phone Number", "Address");
                    salesPerson.printSalesPerson(sList);
                    break;
                case INV_CODE: //Inventory Page
                    Scanner input2 = new Scanner(System.in);
                    String answer = "";
                    System.out.print("\nWhat would you like to do: \n[A]dd in inventory\n[B]rowse Inventory\n[D]elete an item from Inventory\nPlease Enter you Selection: ");
                    answer = input2.nextLine().toUpperCase() + " ";
                    char firstChar = answer.charAt(0);
                    switch(firstChar){
                        case 'A':
                            System.out.println("\nPlease Add Car Information Below");
                            iList.add(inv.addInventory());
                            break;
                        case 'B':
                            System.out.println("---------------------------------------------");
                            System.out.println("           Currently in Inventory            ");
                            System.out.println("---------------------------------------------");
                            Inventory.listMenu(iList);
                            break;
                        case 'D':
                            Inventory.removeCar(iList);
                            break;
                    }
                    break;
                case ORDER_CODE: //Order Page
                    // add loop to prompt user to order more items
                    String userInput = "Type 'Y'es to sell a car or type 'N'o to go back to the main menu: "; //TODO: change the naming of this line
                    userAction = getAction(userInput);
                    while (userAction != 'N') {
                        System.out.println("-------------------------------------------------------------------------");
                        System.out.println("                            ORDER - INVENTORY                            ");
                        System.out.println("-------------------------------------------------------------------------");
                        //get input2 menu id
                        Scanner input = new Scanner(System.in); //TODO: delete the cases and input from ilist instead

                        Inventory.listMenu(iList);

                        System.out.println(" ");
                        System.out.print("Enter Car ID: ");
                        int menuId = input.nextInt();

                        oList.add(or.order());
                    }



                    //print order

                    //or.listOrder(oList);
                    break;

                case TRANS_CODE: //Transaction Page
                    Transaction transaction = new Transaction();
                    System.out.println("Your order total is: $ " + orderTotal);
                    transaction.sellCar();
                    //                 System.out.println("Enter payment type: " + trans1.setPaymentType());

                    //doesn't work - needs fixing
                    /*System.out.println("Enter Customer ID: "); //TODO: which customer is buying the vehicle
                    Scanner scnr = new Scanner(System.in);
                    int inputID = scnr.nextInt();*/
                    /*String input_cust = "Type 'N' to add a new customer or 'E' for an existing customer";

                    userAction = getAction(input_cust);
                    if (userAction == 'E') {
                        System.out.println("Your order total is: $ " + orderTotal);//System.out.println(cust.getCustomerName(cust.getCust()) + "Your order total is: $ " + orderTotal);
                        //System.out.println(cust.getCustomerName(inputID) + "Your order total is: $ " + orderTotal);
                    }
                    if (userAction == 'N') {
                        cList.add(cust.addCustomer());
                        cust.getCust();
                    }

                    //TODO: after selecting 'N' or 'E' for new or existing customer it jumps to this line to Enter Payment Type
                    Transaction trans1 = new Transaction(1);
                    tList.add(trans1);
                    //System.out.println("Your order total is: $ " + orderTotal);
                    // trans1.selectPayType();
                    trans1.setPaymentType(trans1.selectPayType());

                    System.out.println("TRANSACTION RECORD");
                    trans1.printReceipt(orderTotal, trans1.getPaymentType());
                    trans1.listTransactions(tList);*/

                    break;
            }
            userAction = getAction(PROMPT_ACTION);
        }
    }

    // METHOD TO GET USER CHOICE FOR MENU --------------------------------------------------------------------
    public static char getAction(String prompt) {
        Scanner scnr = new Scanner(System.in);
        String answer = "";
        System.out.print(prompt);
        answer = scnr.nextLine().toUpperCase() + " ";
        char firstChar = answer.charAt(0);
        return firstChar;
    }

    // ADD A NEW CUSTOMER METHOD --------------------------------------------------------------------------------------------------------------------------------------------------
    public Customer addCustomer() {
        System.out.println("\nPlease Add Customer Information Below: ");
        Customer cust = new Customer(cCount++);
        Scanner scnr = new Scanner(System.in);
        System.out.print("Please Enter your Name: ");
        String name = (Exception.testAlpha(Exception.getInput()));
        cust.setUserName(name);
        System.out.print("Please Enter your Address: ");
        cust.setUserAddress(scnr.nextLine());
        System.out.print("Please Enter Customer Phone number, please use this format (XXX) XXX-XXXX: ");
        String phone = (Exception.testPhone(Exception.getInput()));
        cust.setUserPhone(phone);
        cust.setUserId(cCount);
        return cust;
    }

    // ADD A NEW SALESPERSON METHOD -------------------------------------------------------------------------------------------------------------------------------------------------
    public salesPerson addSalesPerson() {
        System.out.println("\nPlease Add Sales Person Information Below: ");
        salesPerson sPerson = new salesPerson(sCount++);
        Scanner scnr = new Scanner(System.in);
        System.out.print("Please Enter your Name: ");
        String name = (Exception.testAlpha(Exception.getInput()));
        sPerson.setUserName(name);
        System.out.print("Please Enter your Address: ");
        sPerson.setUserAddress(scnr.nextLine());
        System.out.print("Please Enter Sales Person Phone number, please use this format (XXX) XXX-XXXX: ");
        String phone = (Exception.testPhone(Exception.getInput()));
        sPerson.setUserPhone(phone);
        sPerson.setUserId(sCount);
        return sPerson;
    }

    public boolean checker(int a, ArrayList<Customer> cList) {
        Iterator itr = cList.iterator();
        boolean result = false;
        // while(!result) {
        while(itr.hasNext()) {
            Customer cust = (Customer) itr.next();
            if(cust.getUserId() == a){
                result = true;
                break;
            }else{
                result = false;
            }
        }
        return result;
    }


}