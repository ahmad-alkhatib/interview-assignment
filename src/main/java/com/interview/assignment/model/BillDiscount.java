package com.interview.assignment.model;

import com.interview.assignment.interfaces.Discount;

public class BillDiscount implements Discount {
    @Override
    public double applyDiscount(double totalAmount) {

        double amountAfterDiscount = totalAmount;
        int discount = 0;

        while (amountAfterDiscount >= 100) {
            amountAfterDiscount -= 100;
            discount += 5;
        }

        return discount;
    }
}
