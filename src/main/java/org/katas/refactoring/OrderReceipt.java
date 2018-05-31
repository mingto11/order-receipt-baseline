package org.katas.refactoring;

import java.util.List;
import java.util.stream.Collectors;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 * 
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
	}

	public String printReceipt() {
		StringBuilder output = new StringBuilder("======Printing Orders======\n");

		// print customer information
		output.append(constructCustomerInformation(order));

		// prints lineItems information
		output.append(constructItemsInformation(order.getLineItems()))
                .append('\n');

		// prints the state tax
		output.append("Sales Tax")
                .append('\t')
                .append(order.getTotalSalesTax());

        // print total amount
		output.append("Total Amount")
                .append('\t')
                .append(order.getTotalAmountIncludeTax());

		return output.toString();
	}

	private String constructItemsInformation(List<LineItem> lineItems) {
        return lineItems.stream()
                .map(LineItem::toString)
                .collect(Collectors.joining("\n"));
	}

	private String constructCustomerInformation(Order order) {
		return order.getCustomerInformation();
	}

}