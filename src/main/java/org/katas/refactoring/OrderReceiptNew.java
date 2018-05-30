package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceiptNew {
    private Order o;
    StringBuilder receipt = new StringBuilder();

    public OrderReceiptNew(Order o) {
        this.o = o;
    }

    public String printReceipt() {


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
        if (o.getCustomer() != null) {
            receipt.append(o.getCustomer().getName());
            receipt.append(o.getCustomer().getAddress());
        }
    }

    private void printLineItems() {
        for (LineItem lineItem : o.getLineItems()) {
            receipt.append(lineItem.returnLineInfo());
        }

    }

    private double caculateSalesTax(LineItem lineItem) {
        return lineItem.totalAmount() * .10;
    }

    private void printStateTax() {
        double totSalesTx = 0d;
        for (LineItem lineItem : o.getLineItems()) {
            totSalesTx += caculateSalesTax(lineItem);
        }
        receipt.append("Sales Tax").append('\t').append(totSalesTx);
    }

    private void printTotalAmount() {
        double totalAmout = 0d;
        for (LineItem lineItem : o.getLineItems()) {
            totalAmout += lineItem.totalAmount() + caculateSalesTax(lineItem);
        }
        receipt.append("Total Amount").append('\t').append(totalAmout);
    }
}