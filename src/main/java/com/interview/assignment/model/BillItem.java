package com.interview.assignment.model;

public class BillItem {
    private BillItemType itemType;
    private double amount;

    public enum BillItemType {
        GROCERY,
        NON_GROCERY;
    }

    public BillItemType getItemType() {
        return itemType;
    }

    public void setItemType(BillItemType itemType) {
        this.itemType = itemType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
