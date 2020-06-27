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

    int cCount = 2;
    int sCount = 2;

    public static void main(String[] args) {



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

        Customer cus1 = new Customer(1,"Sam Ronalds", "(717) 429-1234", "1234 Demo 1 Street, mechanicsburg Pa, 17050");
        Customer cus2 = new Customer(2,"Will Parker", "(717) 323-4234", "1235 Demo 2 Street, enola Pa, 17025");

        cList.add(cus1);
        cList.add(cus2);

        salesPerson sP1 = new salesPerson(1, "Jack Donald", "(717) 379-2323", "1236 Demo 3 Street, Harrisburg Pa, 17012");
        salesPerson sP2 = new salesPerson(2, "Chris Evans", "(715) 353-2334", "1237 Demo 4 Street, Middletown Pa, 17143");

        sList.add(sP1);
        sList.add(sP2);


        System.out.println("---------------------------------------------------------");
        System.out.println("                   Car Dealership                        ");
        System.out.println("                        by:                              ");
        System.out.println("                      Team 4                             ");
        System.out.println("---------------------------------------------------------");

        final char CUST_CODE = '1'; //customer page
        final char PRINT_CUST = '2'; //print cust
        final char INV_CODE = '5'; //inventory page
        final char ORDER_CODE = '6'; //order page
        final char TRANS_CODE = '7'; //transaction page
        final char EXIT_CODE = 'E';
        final char S_CODE = '3';
        final char SP_CODE = '4';
        char userAction;


        final String PROMPT_ACTION = "\nMAIN MENU: \n1 - Add Customer\n2 - Print Customers\n3 - Add Employee\n4 - Print Employees\n5 - Inventory Page\n6 - Sell Car\n7 - Transaction Page\nE - Exit\nPlease Enter your Selection: ";

        userAction = getAction(PROMPT_ACTION);

        while (userAction != EXIT_CODE) {
            switch (userAction) {
                case CUST_CODE: // Customers page
                    cList.add(main.addCustomer());
                    break;
                case PRINT_CUST:
                    System.out.println("List of Customers");
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

                        System.out.println("-------------------------------------------------------------------------");
                        System.out.println("                            ORDER - INVENTORY                            ");
                        System.out.println("-------------------------------------------------------------------------");

                        int i = 0;
                        boolean flag = true;
                        int cust_ans_id;
                        Order order = new Order(i++);
                        Scanner scnr = new Scanner(System.in);
                        System.out.print("Please enter your Customer ID: ");
                        cust_ans_id = scnr.nextInt();
                        boolean checker;
                        checker = main.checker(cust_ans_id,cList);
                        if(checker == true){
                            System.out.println("Customer found and Verified!");
                        }else{
                            System.out.println("Customer not found!, Please enter in queue.");
                            cList.add(main.addCustomer());
                        }

                        System.out.print("How many cars would you like to Order?: ");
                        int ord_num = scnr.nextInt();
                        scnr.nextLine();
                        System.out.println("What would you like to order, we currently have: ");
                        Inventory.listMenu(iList);
                        while(i <= ord_num) {
                            oList.add(main.addOrder());
                            i++;
                        }

                        break;

                case TRANS_CODE: //Transaction Page
                    Transaction transaction = new Transaction();
                    transaction.sellCar(sList,cList,oList);
                    break;
            }
            userAction = getAction(PROMPT_ACTION);
        }
    }

    // METHOD TO GET USER CHOICE FOR MENU --------------------------------------------------------------------
    /**
    getAction method
    @context        Prompt the user for menu
    @param prompt   Char variable
    @returns        user's action
    @version        1.0
    @since          2020-06-26
     @author        Team 4
    */
    public static char getAction(String prompt) {
        Scanner scnr = new Scanner(System.in);
        String answer = "";
        System.out.print(prompt);
        answer = scnr.nextLine().toUpperCase() + " ";
        char firstChar = answer.charAt(0);
        return firstChar;
    }

    // ADD A NEW CUSTOMER METHOD --------------------------------------------------------------------------------------------------------------------------------------------------
    /**
     addCustomer method
     @context        Add Customers into the system
     @paramnun
     @returns        customers
     @version        1.0
     @since          2020-06-26
     @author        Team 4
     */
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
    /**
     addSalesPerson method
     @context        Add employees into the system
     @paramnun
     @returns        sales person
     @version        1.0
     @since          2020-06-26
     @author         Team 4
     */
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

    /**
     checker method
     @context        Checks if the customer is in the system
     @param a        customer ID
     @param cList    customer ArrayList
     @returns        boolean true or false if the customer is in the list or not
     @version        1.0
     @since          2020-06-26
     @author         Team 4
     */
    public boolean checker(int a, ArrayList<Customer> cList) {
        Iterator itr = cList.iterator();
        boolean result = false;
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

    /**
     addOrder method
     @context        Add orders to order list
     @paramnun
     @returns        orders
     @version        1.0
     @since          2020-06-26
     @author         Team 4
     */
    public Order addOrder(){
        Order ord = new Order();
        Scanner scnr = new Scanner(System.in);
        System.out.print("Please Enter VIN number to order: ");
        ord.setOrder(scnr.nextInt());
        return ord;
    }

    /**
     sChecker method
     @context        Checks if the salesPerson is in the system
     @param a        salesPerson ID
     @param sList    salesPerson ArrayList
     @returns        boolean true or false if the salesPerson is in the list or not
     @version        1.0
     @since          2020-06-26
     @author         Team 4
     */
    public boolean sChecker(int a, ArrayList<salesPerson> sList) {
        Iterator itr = sList.iterator();
        boolean result = false;
        // while(!result) {
        while(itr.hasNext()) {
            salesPerson sPerson = (salesPerson) itr.next();
            if(sPerson.getUserId() == a){
                result = true;
                break;
            }else{
                result = false;
            }
        }
        return result;
    }


}