package com.rfa;

/*
* This class is only concerned with the calculation as we refactored the code. This shows that
* this class has only concerned with the calculation of Mortgage. The presentation stuff is moved
* to the Mortgage report class.
* */

public class MortgageCalculator {
    // CONSTANTS - Fields - As they are used in calculation hence they are moved here.
    // The below fields are being made private - applying the abstraction principle.
    // So we are hiding all this implementation details. If we change these implementations in the future
    // the classes that depends upon the MortgageCalculator class are not gonna get broken
    public final static byte MONTHS_IN_YEAR = 12;
    public final static byte PERCENT = 100;
    // In here the encapsulation comes into play. Now this class is going to have the fields and behaviour
    private int principal;
    private float annualInterest;
    private byte years;

    // CALCULATOR
    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    /*
    * Calculating the remaining balance - Function defined above the Mortgage function because they are
    * logically related.
    * This makes our code better organized
    * */
    public double calculateBalance(short numberOfPaymentsMade) {
        // Here we need to calculate the monthly interest as well as the total number of payments

        float monthlyInterest = getMonthlyInterest();
        float numberOfPayments = getNumberOfPayments();

        double balance = principal
                        * (Math.pow(1+monthlyInterest, numberOfPayments) - Math.pow(1+monthlyInterest, numberOfPaymentsMade))
                        / (Math.pow(1+monthlyInterest, numberOfPayments) -1);

        return balance;
    }


    // The function to calculate mortgage
    public double calculateMortgage() {
        float monthlyInterest = getMonthlyInterest();
        float numberOfPayments = getNumberOfPayments();

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1+monthlyInterest, numberOfPayments));

        return mortgage;
    }

    public double[] getRemainingBalances(){
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month< balances.length; month++)
            balances[month -1] = calculateBalance(month);

        return balances;
    }

    private int getNumberOfPayments() {
        return years * MONTHS_IN_YEAR;
    }

    private float getMonthlyInterest() {
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }

    // Here the getYears existed - which is deleted because there is no more dependency of other classes
    // in short no more usage else where. Hence we can safely delete it/
}
