package com.example.projektzaliczeniowy;

/** Model zamówienia zapisywanego w SQLite */
public class Order {
    private final String productName;
    private final int quantity;
    private final double price;
    private final String orderTime;

    public Order(String productName, int quantity, double price, String orderTime) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.orderTime = orderTime;
    }

    public String getProductName() { return productName; }
    public int    getQuantity()    { return quantity; }
    public double getPrice()       { return price; }
    public String getOrderTime()   { return orderTime; }
}

