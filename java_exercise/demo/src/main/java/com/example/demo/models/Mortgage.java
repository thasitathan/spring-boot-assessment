package com.example.demo.models;

import com.example.demo.exception.MinDownValidation;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@MinDownValidation
public class Mortgage {
    @NotNull(message = "Down payment must be provided")
    private double downPayment;

    @NotNull(message = "Purchase price must be provided")
    @Positive(message = "Purchase price must be greater than 0")
    private double purchasePrice;

    @NotNull(message = "Interest rate must be provided")
    @Positive(message = "Interest rate must be greater than 0")
    private double interestRate;

    @NotNull(message = "Years of loan must be provided")
    @Max(value = 30, message = "Years of loan must be less than or equal to 30")
    @Positive(message = "Years of loan must be greater than 0")
    private int loanYears;

    @ApiModelProperty(hidden=true)
    private double mortgagePayment;

    public Mortgage(double down, double purchase, double rate, int years) {
        this.downPayment = down;
        this.purchasePrice = purchase;
        this.interestRate = rate;
        this.loanYears = years;
    }

    public double getDownPayment() {
        return this.downPayment;
    }

    public void setDownPayment(double down) {
        this.downPayment = down;
    }

    public double getPurchasePrice() {
        return this.purchasePrice;
    }

    public void setPurchasePrice(double purchase) {
        this.purchasePrice = purchase;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(double rate) {
        this.interestRate = rate;
    }

    public int getLoanYears() {
        return this.loanYears;
    }

    public void setLoanYears(int years) {
        this.loanYears = years;
    }

    public double getMortgagePayment() {
        return this.mortgagePayment;
    }

    public void setMortgagePayment(double payment) {
        this.mortgagePayment = payment;
    }

}
