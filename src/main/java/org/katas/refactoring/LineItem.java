package org.katas.refactoring;

public class LineItem {
    private String description;
    private double price;
    private int quantity;

    public LineItem(String description, double price, int quantity) {
        super();
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalAmount() {
        return price * quantity;
    }

    public String toString() {
        StringBuilder results = new StringBuilder();
        return results.append(description)
                .append('\t')
                .append(price)
                .append('\t')
                .append(quantity)
                .append('\t')
                .append(getTotalAmount())
                .toString();
    }
}