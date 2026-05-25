package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
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

    // Реализация методов интерфейса Searchable на уровне Product
    @Override
    public String getSearchTerm() {
        return name;  // поиск по имени товара
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public abstract String toString();
}
