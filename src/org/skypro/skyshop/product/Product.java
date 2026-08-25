package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;
import java.util.Objects;

public abstract class Product implements Searchable {
    private final String name;

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Название продукта не может быть пустым или состоять только из пробелов");
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public abstract int getPrice();
    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return getName();
    }

    @Override
    public String getType() {
        return "PRODUCT";
    }
    //equals — сравнивает только по name
    @Override
    public boolean equals(Object o) {
        //Проверка на равенство ссылок
        if (this == o) return true;
        //Проверка на null и класс
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        //Сравнение только по name через Objects.equals
        return Objects.equals(name, product.name);
    }

    //hashCode — считается только по name
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
