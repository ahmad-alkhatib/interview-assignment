package com.interview.assignment.model;

import com.interview.assignment.interfaces.Discount;
import com.interview.assignment.interfaces.Role;

import java.util.Arrays;
import java.util.List;

public class Employee implements Role {
    @Override
    public List<Discount> getDiscounts() {
        return Arrays.asList(new PercentageDiscount(30), new BillDiscount());
    }
}
