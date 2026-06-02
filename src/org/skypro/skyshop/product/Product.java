package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private final String name;

    public Product(String name) { // Убрать throws
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым или состоять только из пробелов");
        }
        this.name = name;
    }


    // Абстрактный метод — каждый подкласс реализует свою логику цены
    public abstract int getPrice();

    // Абстрактный метод для определения "специального" товара
    public abstract boolean isSpecial();

    // Реализация методов интерфейса Searchable на уровне Product

    @Override
    public String getName() {
        return name;  // поиск по имени товара
    }

    @Override
    public String getSearchTerm() {
        return getName();  // поиск по имени товара
    }

    @Override
    public String getType() {
        return "PRODUCT";
    }
}
