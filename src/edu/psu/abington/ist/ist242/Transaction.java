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

    ArrayList<Transaction> sList = new ArrayList<Transaction>();


    int sCount = 1;
    private PaymentType paymentType;
    private String transactionId;
    private double commission;
    private double subTotal;
    private double orderTotal;
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

    /*public String getOrderTotal (Order order) {
        Transaction transaction = new Transaction();

        return "Total: $ ";
    }


    public String getTotal (Order order) {
        Transaction transaction = new Transaction();
        transaction.setPaymentType();
        return "Total: $ ";
    }*/

    public Transaction sellCar(){
        Scanner scnr = new Scanner(System.in);
        User salesManager = new User(); // Sales Manager constructor
        Transaction tran = new Transaction(); //Sales transaction constructor
        Customer cust = new Customer(); //Customer constructor
        Inventory car = new Inventory(); //Car constructor
        Main main = new Main();

        System.out.print("Enter transaction ID: ");
        transactionId = Exception.testAlphaNumeric(Exception.getInput());
        tran.setTransactionId(transactionId);
        sList.add(tran);

        System.out.print("Please enter employee ID: ");
        empSalesID = scnr.nextInt();
        salesManager.setUserId(empSalesID);

        System.out.print("Please enter employee name: ");
        sfullName = Exception.testAlpha(Exception.getInput());
        salesManager.setUserName(sfullName);


        System.out.print("Enter the VIN of the Car: ");
        car.vin = scnr.nextInt();
        car.setVin(car.vin);


        System.out.print("Enter the sticker price of car as a double: $"); //TODO: change this into the Order selection
        double subTotal = scnr.nextDouble();
        tran.setSubTotal(subTotal);
        sList.add(tran);

        main.addCustomer();

        tran.setPaymentType();


        System.out.println(" ");
        System.out.println("---- PSU Car Dealership ----");
        System.out.println("     1600 Woodland Road     ");
        System.out.println("     Abington, PA 19001     ");
        System.out.println("        215-555-1212        ");
        System.out.println("     -- SALE RECORD --      ");
        System.out.println(" ");
        System.out.println("Transaction ID: " + tran.getTransactionId());
        System.out.println("Sold to: "); //TODO: need to add a mathod
        System.out.println("Employee ID #: " + salesManager.getUserId());
        System.out.println("Employee Name: " + salesManager.getUserName());
        System.out.println("Car VIN: " + car.getVin());
        System.out.println("Car Sticker Price: " + tran.getSubTotal());
        //System.out.println("Payment Type: " + PaymentType.cash); //TODO: need to change this to reflect user input from above

        System.out.println(" ");

        tran.setTotalPrice(calculateTransaction(tran.getSubTotal(), tax));
        System.out.println("Total price is w/ taxes: $" + getTotalPrice());
        System.out.println("Commission earned: $" + df2.format(tran.setSalesCommission(getTotalPrice())));
        System.out.println(" ");
        System.out.println("-- TRANSACTION RECORDED -- ");

        sList.add(tran);

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































/*public class Transaction {

    //Class Level Variables - Protect the data
    private int transactionId;
    private Order order;
    private PaymentType payment;
    private final double tax = 0.06;

    //Constructor Method
    public Transaction(){}

    public Transaction(int _transactionId, Order _order, PaymentType _pType){
        this.transactionId = _transactionId;
        this.order = _order;
        this.payment = _pType;
    }

    public Transaction(int _transactionId) {
        this.transactionId = _transactionId;
    }


    // get order total ??
    public String getOrderTotal (Order order) {
        Transaction transaction = new Transaction();

        return "Total: $ ";
    }

/*
    public String getTotal (Order order) {
        Transaction transaction = new Transaction();
        transaction.setPaymentType();
        return "Total: $ ";
    }
    */

//Setters and Getters
   /* public int getTransactionId() { return transactionId; }
    public void setTransactionId(int _transactionId) {this.transactionId = _transactionId;}

    public PaymentType selectPayType() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter payment type: ");
        payment = PaymentType.valueOf(input.next().toLowerCase());
        // add if statement for cash payment to calculate change
        return payment;
    }

    public static void listTransactions(ArrayList<Transaction> tList){
        for (Transaction trans: tList){
            System.out.println("Transaction ID: " + trans.getTransactionId());
            //System.out.println("Order:" + trans.getOrder());
            System.out.println("Payment Type: " + trans.getPaymentType());
        }
    }
    public Order getOrder() { return order; }
    public void setOrder(Order _order) {this.order = _order;}

    public PaymentType getPaymentType() { return payment; }
    public void setPaymentType(PaymentType _payment) {this.payment = _payment;}

    public void printReceipt(double _total, PaymentType _payment) {

        System.out.println("Customer Name:");
        System.out.printf("%-10s _ %-10s", "Order         ", "$ ");
        System.out.printf("%.2f\n", _total);

        double total = _total + _total*tax;

        System.out.printf("%-10s _ %-10s", "Tax           ", "$ ");

        System.out.print(" ");

        System.out.printf("%.2f\n", tax*_total);

        System.out.printf("%-10s _ %-10s", "Total w/ tax  ", "$    ");

        System.out.printf("%.2f\n", total);

        //System.out.printf("%-10s _ %-10s\n", "Payment type  ", "    ", _payment);

    }*/

    /*public PaymentType getPaymentType() { return PaymentType; }
    public void setPaymentType(PaymentType _paymentType) {PaymentType = _paymentType;}

}*/
