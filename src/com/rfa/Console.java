package com.rfa;

import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    // METHOD OVERLOADING
    static public double readNumber(String prompt){
        return scanner.nextDouble();
    }

    // The function for refactoring a reptitive method
    static public double readNumber(String prompt, double min, double max) {
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if(value >= min && value <= max){
                break;
            }

            System.out.println("Please insert the value from " + min + " to " + max +"!!");
        }

        return value;
    }
}
