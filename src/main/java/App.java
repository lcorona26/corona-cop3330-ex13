/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Luis Corona
 */
import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App app = new App();
        String principal = app.readPrincipal();
        String interestRate = app.readInterest();
        String years = app.readYears();
        String compound = app.readCompound();
        float calc = app.Calc(principal, interestRate, years, compound);
        app.printOutput(principal, interestRate, years,compound, calc);
    }

    private void printOutput(String principal, String interestRate, String years, String compound, float calc) {
        String message = String.format("$%s invested at %s%% for %s years compounded %s times per year is $%.2f.",
                principal,interestRate, years,compound,calc);
        System.out.print(message);
    }

    private float Calc(String principal, String interestRate, String years, String compound) {
        int principleInt = Integer.parseInt(principal);
        float interestToInt = Float.parseFloat(interestRate) / 100;
        int yearsToInt = Integer.parseInt(years);
        int compoundToInt = Integer.parseInt(compound);
        float a =(1 + (interestToInt/compoundToInt) );
        float b = compoundToInt * yearsToInt;
        float calc = (float) Math.pow(a, b) * (principleInt);
        return calc;

    }

    private String readCompound() {
        System.out.print("What is the number of times the interest is compounded per year? ");
        String compound = in.nextLine();
        return compound;
    }

    private String readPrincipal() {
        System.out.print("What is the principal amount? ");
        String principal = in.nextLine();
        return principal;
    }

    private String readInterest() {
        System.out.print("What is the rate? ");
        String interest = in.nextLine();
        return interest;
    }

    private String readYears() {
        System.out.print("What is the number of years? ");
        String years = in.nextLine();
        return years;
    }
}