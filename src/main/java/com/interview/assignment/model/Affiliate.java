package com.interview.assignment.model;

import com.interview.assignment.interfaces.Discount;
import com.interview.assignment.interfaces.Role;

import java.util.Arrays;
import java.util.List;

public class Affiliate implements Role {
    @Override
    public List<Discount> getDiscounts() {
        return Arrays.asList(new PercentageDiscount(5), new BillDiscount());
    }
}
