package org.katas.refactoring;

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
		StringBuilder output = new StringBuilder();

		output.append("======Printing Orders======\n");

		// print date, bill no, customer name
		output.append(constructCustomerInformation(order));

		// prints lineItems
		output.append(constructItemsInformation(order));

		// prints the state tax
		output.append("Sales Tax").append('\t').append(order.getTotalSalesTax());

        // print total amount
		output.append("Total Amount").append('\t').append(order.getTotalAmount());
		return output.toString();
	}

	private String constructItemsInformation(Order order) {
		StringBuilder itemsInformation = new StringBuilder();
		for (LineItem lineItem : order.getLineItems()) {
			itemsInformation.append(lineItem.getDescription());
			itemsInformation.append('\t');
			itemsInformation.append(lineItem.getPrice());
			itemsInformation.append('\t');
			itemsInformation.append(lineItem.getQuantity());
			itemsInformation.append('\t');
			itemsInformation.append(lineItem.getTotalAmount());
			itemsInformation.append('\n');
		}
		return itemsInformation.toString();
	}

	private String constructCustomerInformation(Order order) {
		StringBuilder customerInformation = new StringBuilder();
		customerInformation.append(order.getCustomerName());
		customerInformation.append(order.getCustomerAddress());
		return customerInformation.toString();
	}

}