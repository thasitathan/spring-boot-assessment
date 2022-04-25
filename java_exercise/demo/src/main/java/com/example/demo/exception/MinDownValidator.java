package com.example.demo.exception;

import com.example.demo.models.Mortgage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class MinDownValidator implements ConstraintValidator<MinDownValidation, Mortgage> {

    public boolean isValid(Mortgage newMortgage, ConstraintValidatorContext cxt) {
        // method verifies if down payment is at least 5% of purchase price
        double minDown = newMortgage.getPurchasePrice() * 0.05;
        if (newMortgage.getDownPayment() < minDown) {
            return false;
        }
        return true;
    }
}

