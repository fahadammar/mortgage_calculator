package com.rfa;

import java.text.NumberFormat;
import java.util.Scanner;

// In this commit the - Calculating the remaining balance formula is implemented

public class Main {

    // CONSTANTS - Fields
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
	// write your code here

        // we declared it outside of the loop because of the scope of variable - we don't want scope of this till loop
        int principal;
        float annualInterest;
        float monthlyInterest;
        byte years;
        int numberOfPayments;



        // Infinite Loop - Taking the input of the prinicipal
        principal = (int) readNumber("Principal: ", 1000, 1_000_000);


        // Infinite Loop - Taking the input annual interest
        annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30);


        // Infinite Loop - Taking the input years
        years = (byte) readNumber("Perios (Years): ", 1, 30);



        double mortgage = calculateMortgage(principal, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println(); // for the line break
        System.out.println("MORTGAGE");
        System.out.println("---------");
        System.out.print("Monthly Payments: " + mortgageFormatted);

        System.out.println(); // line break - new line
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month<years * MONTHS_IN_YEAR; month++){
            double balance = calculateBalance(principal, annualInterest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }

    }

    // The function for refactoring a reptitive method
    static public double readNumber (String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if(value >= min && value <= max){
                break;
            }

            System.out.println("Please insert the value from " + min + " to " + max +"!!");
        }

        return value;
    }

    /*
    * Calculating the remaining balance - Function defined above the Mortgage function because they are
    * logically related.
    * This makes our code better organized
    * */

    public static double calculateBalance(
            int principal,
            float annualInterest,
            byte years,
            short numberOfPaymentsMade
    ) {
        // Here we need to calculate the monthly interest as well as the total number of payments

        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = years * MONTHS_IN_YEAR;

        double balance = principal
                        * (Math.pow(1+monthlyInterest, numberOfPayments) - Math.pow(1+monthlyInterest, numberOfPaymentsMade))
                        / (Math.pow(1+monthlyInterest, numberOfPayments) -1);

        return balance;
    }

    // The function to calculate mortgage
    static public double calculateMortgage(
            int principal,
            float annualInterest,
            byte years
    ) {
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1+monthlyInterest, numberOfPayments));

        return mortgage;
    }
}

/*
* duplication is bad if we need to modify the code
* if need to implement some logic and we never need to change that logic.
* also in future this logic is needed and not going to change. However, the duplication 2 lines is not bad
* In OOP phase, more good approach is going to be shared.
 */