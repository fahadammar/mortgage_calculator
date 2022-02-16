package com.rfa;

import java.text.NumberFormat;

/*
* This class is entirely responsible for presentation. There is no calculation here.
* */

public class MortgageReport {


    private final NumberFormat currencyInstance; // This field is created, hence to make the code more clean.
    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currencyInstance = NumberFormat.getCurrencyInstance();
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String mortgageFormatted = currencyInstance.format(mortgage);
        System.out.println(); // for the line break
        System.out.println("MORTGAGE");
        System.out.println("---------");
        System.out.print("Monthly Payments: " + mortgageFormatted);
    }

    // This below method is extracted, the extract method feature in Inellij.
    public void printPaymentSchedule() {
        System.out.println(); // line break - new line
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for(double balance : calculator.getRemainingBalances())
            System.out.println(currencyInstance.format(balance));

    }
}
