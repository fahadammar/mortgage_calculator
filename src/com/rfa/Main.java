package com.rfa;

// In this commit the -After implementing remaining balance formula feature, now REFACTORING is done

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
        principal = (int) Console.readNumber("Principal: ", 1000, 1_000_000);


        // Infinite Loop - Taking the input annual interest
        annualInterest = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);


        // Infinite Loop - Taking the input years
        years = (byte) Console.readNumber("Perios (Years): ", 1, 30);

        var calculator = new MortgageCalculator(principal, annualInterest, years);
        var report = new MortgageReport(calculator);

        report.printMortgage();
        report.printPaymentSchedule();

    }

}

/*
* duplication is bad if we need to modify the code
* if need to implement some logic and we never need to change that logic.
* also in future this logic is needed and not going to change. However, the duplication 2 lines is not bad
* In OOP phase, more good approach is going to be shared.
 */