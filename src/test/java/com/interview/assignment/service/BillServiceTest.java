package com.interview.assignment.service;


import com.interview.assignment.interfaces.Role;
import com.interview.assignment.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;


class BillServiceTest {

    @ParameterizedTest(name = "{index}. Customer expectedNetPayable amount is {1} if customer since {0}")
    @MethodSource("getCustomerParams")
    void apply_discount_5_percent_for_customer(LocalDate customerSince, double expectedNetPayable) {
        // Given
        BillItem billItem1 = generateBillItem(BillItem.BillItemType.NON_GROCERY, 100);
        BillItem billItem2 = generateBillItem(BillItem.BillItemType.GROCERY, 100);
        Role role = new Customer(customerSince);

        User user = new User();
        user.setRoles(Collections.singletonList(role));

        Bill bill = new Bill();
        bill.setItems(Arrays.asList(billItem1, billItem2));
        bill.setUser(user);

        // When
        double netPayable = new BillService().applyDiscountAndCalculateNetPayable(bill);

        // Then
        Assertions.assertEquals(expectedNetPayable, netPayable);
    }


    private static Stream<Arguments> getCustomerParams() {
        return Stream.of(
                Arguments.of(LocalDate.of(2018, 10, 10), 185d),
                Arguments.of(LocalDate.of(2020, 10, 10), 190d)
        );
    }

    @Test
    void apply_discount_30_percent_for_employee() {
        // Given
        BillItem billItem = generateBillItem(BillItem.BillItemType.NON_GROCERY, 200);
        Role role = new Employee();

        User user = new User();
        user.setRoles(Collections.singletonList(role));

        Bill bill = new Bill();
        bill.setItems(Collections.singletonList(billItem));
        bill.setUser(user);

        // When
        double netPayable = new BillService().applyDiscountAndCalculateNetPayable(bill);

        // Then
        Assertions.assertEquals(130d, netPayable);
    }

    @Test
    void apply_discount_5_percent_for_affiliate() {
        // Given
        BillItem billItem1 = generateBillItem(BillItem.BillItemType.NON_GROCERY, 100);
        BillItem billItem2 = generateBillItem(BillItem.BillItemType.GROCERY, 100);
        Role role = new Affiliate();

        User user = new User();
        user.setRoles(Collections.singletonList(role));

        Bill bill = new Bill();
        bill.setItems(Arrays.asList(billItem1, billItem2));
        bill.setUser(user);

        // When
        double netPayable = new BillService().applyDiscountAndCalculateNetPayable(bill);

        // Then
        Assertions.assertEquals(185d, netPayable);
    }


    private BillItem generateBillItem(BillItem.BillItemType billItemType, int amount) {
        BillItem billItem = new BillItem();
        billItem.setItemType(billItemType);
        billItem.setAmount(amount);
        return billItem;
    }


}
