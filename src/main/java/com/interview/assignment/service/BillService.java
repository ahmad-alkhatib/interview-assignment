package com.interview.assignment.service;

import com.interview.assignment.interfaces.Discount;
import com.interview.assignment.interfaces.Role;
import com.interview.assignment.model.Bill;
import com.interview.assignment.model.BillDiscount;
import com.interview.assignment.model.BillItem;

import java.util.List;

public class BillService {

    public double applyDiscountAndCalculateNetPayable(Bill bill) {
        List<BillItem> allItems = bill.getItems();
        List<BillItem> nonGroceryItems = bill.getNonGroceryItems();

        // calculate totalNonGroceryItemsAmount from bill Items
        double totalNonGroceryItemsAmount = nonGroceryItems.stream().mapToDouble(BillItem::getAmount).sum();
        double totalAllItemsAmount = allItems.stream().mapToDouble(BillItem::getAmount).sum();
        double netPayable = totalAllItemsAmount;

        Role firstRole = bill.getUser().getRoles().get(0);

        for (Discount d : firstRole.getDiscounts()) {
            if (d instanceof BillDiscount)
                netPayable -= d.applyDiscount(totalAllItemsAmount);
            else
                netPayable -= d.applyDiscount(totalNonGroceryItemsAmount);
        }

        return netPayable;
    }

}
