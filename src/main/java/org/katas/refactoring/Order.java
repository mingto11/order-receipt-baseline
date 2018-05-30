package org.katas.refactoring;

import java.util.List;

public class Order {

    Customer customer;
    List<LineItem> lineItems;

    public Order(Customer customer,List<LineItem> lineItems) {
        this.customer = customer;
        this.lineItems = lineItems;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }
    StringBuilder receipt = new StringBuilder();

    public String receipt() {
        printHeader();
        printCustomerInfo();
        printLineItems();
        printStateTax();
        printTotalAmount();
        System.out.println(receipt.toString());
        return receipt.toString();
    }

    private void printHeader() {
        receipt.append("======Printing Orders======\n");
    }

    private void printCustomerInfo() {
        if (this.getCustomer() != null) {
            receipt.append(this.getCustomer().getName());
            receipt.append(this.getCustomer().getAddress());
            receipt.append("\n");
        }
    }

    private void printLineItems() {
        for (LineItem lineItem : this.getLineItems()) {
            receipt.append(lineItem.returnLineInfo());
        }

    }

    private double caculateSalesTax(LineItem lineItem) {
        return lineItem.totalAmount() * .10;
    }

    private void printStateTax() {
        double totSalesTx = 0d;
        for (LineItem lineItem : this.getLineItems()) {
            totSalesTx += caculateSalesTax(lineItem);
        }
        receipt.append("Sales Tax").append('\t').append(totSalesTx);
    }

    private void printTotalAmount() {
        double totalAmout = 0d;
        for (LineItem lineItem : this.getLineItems()) {
            totalAmout += lineItem.totalAmount() + caculateSalesTax(lineItem);
        }
        receipt.append("Total Amount").append('\t').append(totalAmout);
    }
}