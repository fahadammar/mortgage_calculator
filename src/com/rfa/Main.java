package com.rfa;

import java.text.NumberFormat;
import java.util.Scanner;

// In this commit the - Refactoring is done of the repetitive patterns

public class Main {

    public static void main(String[] args) {
	// write your code here

        // we declared it outside of the loop because of the scope of variable - we don't want scope of this till loop
        int principal;
        float annualInterest;
        float monthlyInterest;
        byte years;
        int numberOfPayments;



        // Infinite Loop - Taking the input of the prinicipal
        principal = (int) readNumber("Principal", 1000, 1_000_000);


        // Infinite Loop - Taking the input annual interest
        annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30);


        // Infinite Loop - Taking the input years
        years = (byte) readNumber("Perios (Years): ", 1, 30);
       


        double mortgage = calculateMortgage(principal, annualInterest, years);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage: " + mortgageFormatted);

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

    // The function to calculate mortgage
    static public double calculateMortgage(
            int principal, float annualInterest, byte years )
    {
        // CONSTANTS
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1+monthlyInterest, numberOfPayments));

        return mortgage;
    }
}
