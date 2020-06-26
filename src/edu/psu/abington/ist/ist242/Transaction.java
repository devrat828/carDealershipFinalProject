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

import java.text.DecimalFormat;
import java.util.*;

enum PaymentType {credit, cash, financing}

public class Transaction extends Order {

    ArrayList<Transaction> tList = new ArrayList<Transaction>();


    int sCount = 1;
    private PaymentType paymentType;
    private String transactionId;
    private double commission;
    private double subTotal;
    private double totalPrice;
    private double tax = 1.06;
    private int empSalesID;
    private String sfullName;





    // GETTERS & SETTERS ------------------------------------------------------------------------------
    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public int getEmpSalesID() {
        return empSalesID;
    }

    public void setEmpSalesID(int empSalesID) {
        this.empSalesID = empSalesID;
    }

    public String getSfullName() {
        return sfullName;
    }

    public void setSfullName(String sfullName) {
        this.sfullName = sfullName;
    }



    public Transaction sellCar(ArrayList<salesPerson> sList,ArrayList<Customer> cList, ArrayList<Order> oList, ArrayList<Inventory> iList){
        Scanner scnr = new Scanner(System.in);
        Transaction tran = new Transaction();
        Main main = new Main();



        System.out.print("Enter transaction ID: ");
        transactionId = Exception.testAlphaNumeric(Exception.getInput());
        tran.setTransactionId(transactionId);
        tList.add(tran);

        System.out.println("Please choose a sales person by ID from the list below");
        salesPerson.printSalesPerson(sList);
        System.out.print("Please enter your selection: ");
        int sId = scnr.nextInt();
        boolean checker;
        checker = main.sChecker(sId,sList);
        if(checker == true){
            System.out.println("Sales person found and Verified!");
        }else{
            System.out.println("Sales Person not found!, Please enter in queue.");
            sList.add(main.addSalesPerson());
        }

        System.out.println("Please choose a customer by ID from the list below");
        Customer.printCustomer(cList);
        System.out.print("Please enter your selection: ");
        int cId = scnr.nextInt();
        checker = main.checker(cId, cList);
        if(checker == true){
            System.out.println("Customer found and Verified!");
        }else{
            System.out.println("Customer not found!, Please enter in queue.");
            cList.add(main.addCustomer());
        }

        tran.setPaymentType();


        System.out.println(" ");
        System.out.println("---- PSU Car Dealership ----");
        System.out.println("     1600 Woodland Road     ");
        System.out.println("     Abington, PA 19001     ");
        System.out.println("        215-555-1212        ");
        System.out.println("     -- SALE RECORD --      ");
        System.out.println(" ");
        System.out.println("Transaction ID: " + tran.getTransactionId());
        System.out.println("Sold to: ");
        System.out.printf("%-15s | %-15s | %-15s | %-15s\n", "ID", "Name", "Phone Number", "Address");
        for (Customer customer : cList) {
            if (cId == customer.getUserId()) {
                System.out.printf("%-15s | %-15s | %-15s | %-15s\n", customer.getUserId(), customer.getUserName(), customer.getUserPhone(), customer.getUserAddress());
                break;
            }
        }
        System.out.println("Sales Person: ");
        System.out.printf("%-15s | %-15s | %-15s | %-15s\n", "ID", "Name", "Phone Number", "Address");
        for (salesPerson sPerson : sList){
            if(sId == sPerson.getUserId()) {
                System.out.printf("%-15s | %-15s | %-15s | %-15s\n", sPerson.getUserId(), sPerson.getUserName(), sPerson.getUserPhone(), sPerson.getUserAddress());
            }
        }

        for(Order ord : oList){
            System.out.println("Car VIN ordered: " + ord.getOrder());
            switch(ord.getOrder()){
                case 1: totalPrice += 26899.99; break;
                case 2: totalPrice += 46799.99; break;
                case 3: totalPrice += 39899.99; break;
                case 4: totalPrice += 42699.99; break;
                default : totalPrice = 0;
            }

            }
        System.out.println("Car Sticker Price: " + totalPrice);

        System.out.println(" ");

        tran.setTotalPrice(calculateTransaction(totalPrice, tax));
        System.out.println("Total price is w/ taxes: $" + getTotalPrice());
        System.out.println("Commission earned: $" + df2.format(tran.setSalesCommission(getTotalPrice())));
        System.out.println(" ");
        System.out.println("-- TRANSACTION RECORDED -- ");

        tList.add(tran);

        return tran;
    }

    public PaymentType setPaymentType(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter payment type ( 'cash / 'credit' / 'financing' ): ");
        PaymentType _payment = PaymentType.valueOf(scanner.next().toLowerCase());
        return _payment;
    }

    public double setSalesCommission(double _value) {
        double comm = _value*0.15;
        return comm;
    }

    public void listTransactions(ArrayList<Transaction> sList) { //TODO: fix how to add transaction to the slist from the user input
        for (Transaction tran : sList) {
            System.out.println();
            System.out.println("Transaction ID: " + tran.getTransactionId());
            System.out.println("Subtotal: $" + df2.format(tran.getSubTotal()));
            System.out.println("Total price: $" + df2.format(tran.getTotalPrice()));
            System.out.println("Payment type: " + tran.getPaymentType());
            System.out.println("Commission from sale: $" + df2.format(tran.getCommission()));
        }
    }


    private static DecimalFormat df2 = new DecimalFormat("#.00");

    public double calculateTransaction(double transactionSubtotal, double tax) {
        totalPrice = transactionSubtotal * tax;
        totalPrice = Math.round(totalPrice*100.0)/100.0;
        return totalPrice;
    }

}
