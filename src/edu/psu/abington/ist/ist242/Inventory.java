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

public class Inventory {

    //Class Level Variables - Protect the data
    public int vin;
    public ArrayList invList;
    public double price;
    public String year;
    public String make;
    public String model;


    //Constructor Method
    public Inventory(int _vin, String _year, String _make, String _model, double _price) {
        this.vin = _vin;
        this.make = _make; // menuItem OR _menuItem
        this.year = _year;
        this.model = _model;
        this.price = _price;
    }

    public Inventory() {

    }


    // SETTERS AND GETTERS --------------------------------------------------------------------------------------------------------------------------------------------------------------
    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }


    public ArrayList getInvList() {
        return invList;
    }

    public void setInvList(ArrayList invList) {
        this.invList = invList;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice(int _vin) {
        this.vin = _vin;
        return price;
    }


    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }


    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    //add method to change menuItem price depending on the size
    public static void listMenu(ArrayList<Inventory> invList) {
        for (Inventory invItem : invList) {
            System.out.printf("%-12s | %-12s | %-12s | %-20s | %-12s\n", invItem.getVin(), invItem.getYear(), invItem.getMake(), invItem.getModel(), "$" + invItem.getPrice());


        }
    }


    public Inventory addInventory() {
        Inventory invt = new Inventory();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Vin Number: ");
        invt.setVin(input.nextInt());
        input.nextLine();
        System.out.print("Enter the Make of Car: ");
        invt.setMake(input.nextLine());
        System.out.print("Enter the Model of Car: ");
        invt.setModel(input.nextLine());
        System.out.print("Enter the year of Car: ");
        invt.setYear(input.nextLine());
        System.out.print("Enter the price of Car: ");
        invt.setPrice(input.nextDouble());
        return invt;
    }

    public static void removeCar(ArrayList<Inventory> invList) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a Vin number to delete the Car: ");
        int vin = input.nextInt();
        for (Inventory inv : invList) {
            if (vin == inv.getVin()) {
                invList.remove(inv);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%-12s | %-12s | %-12s | %-20s | %-12s", vin, year, make, model, "$" + price);
    }
}
