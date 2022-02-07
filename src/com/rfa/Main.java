package com.rfa;

import java.text.NumberFormat;
import java.util.Scanner;

// In this commit the - This is the 1st Refactor

public class Main {

    public static void main(String[] args) {
	// write your code here

        // we declared it outside of the loop because of the scope of variable - we don't want scope of this till loop
        int principal;
        float annualInterest;
        float monthlyInterest;
        byte years;
        int numberOfPayments;

        Scanner scanner = new Scanner(System.in);

        // Infinite Loop - Taking the input of the prinicipal
        while(true){
            System.out.print("Principal: ");
            principal = scanner.nextInt();

            if(principal >= 1000 && principal <= 1_000_000)
                break;
            else
                System.out.println("Please insert the value ranging from 1000 to 1000000!!");
        }

        // Infinite Loop - Taking the input annual interest
        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();
            if(annualInterest >= 1 && annualInterest <= 30) {

                break;
            }
            System.out.println("Please insert the value that is from 1 to 30!!");
        }

        // Infinite Loop - Taking the input years
        while (true) {
            System.out.print("Period (Years): ");
            years = scanner.nextByte();
            if(years >= 1 && years <= 30) {

                break;
            }
            System.out.println("Please insert the value from 1 to 30!!");
        }


        double mortgage = calculateMortgage(principal, annualInterest, years);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage: " + mortgageFormatted);

    }

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
