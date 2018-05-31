package org.katas.refactoring;

import java.util.ArrayList;
import java.util.List;

public class Order {
    Customer customer;
    List<LineItem> items;

    public Order(Customer customer, ArrayList<LineItem> lineItems) {
        this.customer = customer;
        this.items = lineItems;
    }

    public String getCustomerName() {
        return customer.getName();
    }

    public String getCustomerAddress() {
        return customer.getAddress();
    }

    public double getTotalAmount(){
        double totalAmount = items.stream().mapToDouble(LineItem::getTotalAmount).sum();
        return totalAmount + getTotalSalesTax();
    }

    public double getTotalSalesTax(){
        double totSalesTx = items.stream().mapToDouble(LineItem::getTotalAmount).sum();
        return totSalesTx *.10;
    }

    public List<LineItem> getLineItems() {
        return items;
    }
}
