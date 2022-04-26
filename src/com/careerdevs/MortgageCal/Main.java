package com.careerdevs.MortgageCal;


import java.text.NumberFormat;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        int principal = 0;
        float annualInterest = 0;
        byte years = 0;


        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Principal: ");
            principal = scanner.nextInt();
            if(principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println(" value between 1000 and 1000000");
        }

        while(true) {
            System.out.println("Period (Years):");
            years = scanner.nextByte();
            if (years >= 1 && years <= 30)
                break;
            System.out.println("Enter a value between 1 and 30: ");
        }
        double mortgage = calculateMortgage(principal, annualInterest, years);

         String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
         System.out.println("Mortgage: " + mortgageFormatted);

    }
        public static double calculateMortgage(
                int principal,
                float annualInterest,
                byte years) {

            final byte MONTHS_IN_YEARS = 12;
            final byte PERCENT = 100;

            float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEARS;
            short numberOFPayments =(short)(years * MONTHS_IN_YEARS);

            double Mortgage = principal
                    * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOFPayments))
                    / (Math.pow(1 + monthlyInterest, numberOFPayments) -1);
            return Mortgage;

        }
}

//Mortgage Calculator
//Principal:10000 = Mortgage amount
//Annual Interest Rate 03.92 / by 12 = monthly rate get
//Period(Years):30
//Mortgage: $472.81 * 12 = Annual rate

