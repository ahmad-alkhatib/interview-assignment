package com.interview.assignment.model;

import com.interview.assignment.interfaces.Discount;

public class PercentageDiscount implements Discount {

    int percentage = 0;

    PercentageDiscount(int percentage) {
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double totalAmount) {
        //return ; calculate percentage and return;
        return totalAmount * (percentage / 100d);
    }
}
