package org.katas.refactoring;

import java.util.List;

public class Order {
    String nm;
    String addr;
    Customer customer;
    List<LineItem> li;

    public Order(Customer customer,List<LineItem> li) {
        this.customer = customer;
        this.li = li;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public List<LineItem> getLineItems() {
        return li;
    }
}
