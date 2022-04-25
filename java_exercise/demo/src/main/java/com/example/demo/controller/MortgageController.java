package com.example.demo.controller;

import com.example.demo.models.Mortgage;
import com.example.demo.service.MortgageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class MortgageController {
    @PostMapping("/calculateMortgage")
    public Mortgage getMortgagePayment(@Valid @RequestBody Mortgage newMortgage) {
        double val = MortgageService.calculateMortgagePayment(newMortgage);
        newMortgage.setMortgagePayment((val));
        return newMortgage;
    }
}
