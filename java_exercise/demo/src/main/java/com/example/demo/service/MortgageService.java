package com.example.demo.service;

import com.example.demo.models.Mortgage;

public class MortgageService {
    public static double calculateMortgagePayment(Mortgage newMortgage) {
        double p = newMortgage.getPurchasePrice() - newMortgage.getDownPayment();
        double r = (newMortgage.getInterestRate() / 100) / 12;
        int n = newMortgage.getLoanYears() * 12;

        double calc = 1 + r;
        calc = Math.pow(calc, n); // (1+r)^n

        double numerator = r * calc; // r(1+r)^n
        double denominator = calc - 1; // ((1+r)^n)-1

        calc = numerator / denominator;
        calc = p * calc;

        // round value to 2 decimals
        calc = Math.round(calc * 100.0) / 100.0;
        return calc;
    }
}
