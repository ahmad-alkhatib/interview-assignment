package com.interview.assignment.model;


import com.interview.assignment.interfaces.Discount;
import com.interview.assignment.interfaces.Role;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Customer implements Role {
    LocalDate customerSince;

    public Customer(LocalDate customerSince) {
        this.customerSince = customerSince;
    }

    @Override
    public List<Discount> getDiscounts() {
        // if customer is over 2 years, will get 5% discount
        if (getYears() >= 2) {
            return Arrays.asList(new PercentageDiscount(5), new BillDiscount());
        } else {
            return Collections.singletonList(new BillDiscount());

        }
    }

    public int getYears() {
        Period period = Period.between(this.customerSince, LocalDate.now());
        return period.getYears();
    }
}
