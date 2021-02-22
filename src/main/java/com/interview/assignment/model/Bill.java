package com.interview.assignment.model;

import java.util.List;
import java.util.stream.Collectors;

public class Bill {
    private List<BillItem> items;
    private User user;

    public void setItems(List<BillItem> items) {
        this.items = items;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<BillItem> getItems() {
        return items;
    }

    public List<BillItem> getNonGroceryItems() {
        return items.stream().filter(b -> b.getItemType().equals(BillItem.BillItemType.NON_GROCERY)).collect(Collectors.toList());
    }
}
