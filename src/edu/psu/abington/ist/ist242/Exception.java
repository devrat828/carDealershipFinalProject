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

import java.util.InputMismatchException;
import java.util.Scanner;


public class Exception extends Throwable {


    public static String getInput() {
        Scanner scnr = new Scanner(System.in);
        String input = scnr.nextLine();
        return input;
    }




    public static String testAlpha(String alphaCharacter) {
        try {
            if (alphaCharacter.matches("^[-'A-Za-z.\\s_-]+$")) {
                return alphaCharacter;
            } else {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException notAnAlpha) {
            System.out.println("Invalid input. Please make sure you did not enter integers. Please try again.");
            return testAlpha(getInput());
        }
    }


    public static String testAlphaNumeric(String input) {
        while (true) {
            try {
                if (input.matches("^[a-zA-Z0-9]*$")) {
                    return input;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException notAnInt) {
                System.out.print("Invalid input. You did not enter alphanumeric characters. Please try again: ");
                return testAlphaNumeric(getInput());
            }
        }
    }




    public static String testPhone(String phone) {
        while (true) {
            try {
                if (phone.matches("^[(]+[0-9]+[)]+[\\s]+[0-9]+[-]+[0-9]+$")) {
                    return phone;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException notAnEmail) {
                System.out.print("Invalid input. Please try again: ");
                return testPhone(getInput());
            }
        }
    }


    public static String testDouble(String price) {
        try {
            if (price.matches("\\d+\\.\\d*$")) {
                return price;
            }
            else  {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException notAnAlpha) {
            System.out.println("Invalid input. Input a double. Please try again.");
            return testDouble(getInput());

        }
    }
}

