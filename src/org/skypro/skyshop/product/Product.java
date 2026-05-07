package org.skypro.skyshop.product;

public abstract class Product {
    private final String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Абстрактный метод — каждый подкласс реализует свою логику цены
    public abstract int getPrice();

    // Абстрактный метод для определения "специального" товара
    public abstract boolean isSpecial();


}
