package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final int price;

    public SimpleProduct(String name, int price) { // int, без throws
        super(name);
        if (price <= 0) { // ✅ ОБЯЗАТЕЛЬНАЯ ПРОВЕРКА
            throw new IllegalArgumentException("Цена продукта должна быть строго больше 0");
        }
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false; //обычный товар
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice();
    }


    @Override
    public String getStringRepresentation() {
        return super.getStringRepresentation();
    }
}
