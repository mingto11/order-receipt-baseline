package org.katas.refactoring;

import java.util.List;

public class Order {

    private Customer customer;
    private List<LineItem> lineItems;

    public Order(Customer customer, List<LineItem> lineItems) {
        this.customer = customer;
        this.lineItems = lineItems;
    }

    public double getTotalAmount(){
        return lineItems.stream()
                .mapToDouble(LineItem::getTotalAmount)
                .sum();
    }

    public double getTotalSalesTax() {
        return getTotalAmount() * .10;
    }

    public double getTotalAmountIncludeTax() {
        return getTotalAmount() + getTotalSalesTax();
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public String getCustomerInformation(){
        return customer.toString();
    }
}
