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

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalAmount() {
        return price * quantity;
    }

    public String toString() {
        StringBuilder results = new StringBuilder();
        return results.append(getDescription())
                .append('\t')
                .append(getPrice())
                .append('\t')
                .append(getQuantity())
                .append('\t')
                .append(getTotalAmount()).toString();
    }
}