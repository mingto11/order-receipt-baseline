package org.katas.refactoring;

import java.util.List;

public class Order {
    Customer customer;
    List<LineItem> items;

    public Order(Customer customer, List<LineItem> lineItems) {
        this.customer = customer;
        this.items = lineItems;
    }

    public String getCustomerName() {
        return customer.getName();
    }

    public String getCustomerAddress() {
        return customer.getAddress();
    }

    public double getTotalAmountIncludeTax() {
        return getTotalAmount() + getTotalSalesTax();
    }

    public double getTotalAmount(){
        return items.stream().mapToDouble(LineItem::getTotalAmount).sum();
    }

    public double getTotalSalesTax() {
        return getTotalAmount() * .10;
    }

    public List<LineItem> getLineItems() {
        return items;
    }

    public String getCustomerInformation(){
        StringBuilder customerInformation = new StringBuilder();
        customerInformation.append(getCustomerName())
                .append(getCustomerAddress());
        return customerInformation.toString();
    }
}
