package org.katas.refactoring;

import java.util.List;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
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
    StringBuilder receipt = new StringBuilder();

    public String receipt() {


        printHeader();

        printCustomerInfo();

        printLineItems();

        printStateTax();

        printTotalAmount();

        return receipt.toString();
    }

    private void printHeader() {
        receipt.append("======Printing Orders======\n");
    }

    private void printCustomerInfo() {
        if (this.getCustomer() != null) {
            receipt.append(this.getCustomer().getName());
            receipt.append(this.getCustomer().getAddress());
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