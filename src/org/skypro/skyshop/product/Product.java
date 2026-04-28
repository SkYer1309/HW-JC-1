package org.skypro.skyshop.product;

public class Product {
    private final String name;
    private final int price;

    public String getName() {
        return name;
    }

    public int getCost() {
        return price;
    }

    public Product(String name, int cost) {
        this.name = name;
        this.price = cost;
    }
}
