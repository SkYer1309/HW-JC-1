package org.skypro.skyshop.product;

public abstract class Product {
    private final String name;

    //   private final int price;
    public Product(String name) {
        this.name = name;
        //this.price = price;
    }

    public String getName() {
        return name;
    }

    // Абстрактный метод — каждый подкласс реализует свою логику цены
    public abstract int getPrice();

    // return price;
    // Абстрактный метод для определения "специального" товара
    public abstract boolean isSpecial();


}
