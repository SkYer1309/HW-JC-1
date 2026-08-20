package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    // LinkedList вместо массива
    private final LinkedList<Product> products = new LinkedList<>();

    // Добавление без проверок на переполнение
    public void addProduct(Product product) {
        products.add(product);
    }

    public int getTotalPrice() {
        int total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }

        int specialCount = 0;
        for (Product p : products) {
            System.out.println(p.toString());
            if (p.isSpecial()) {
                specialCount++;
            }
        }
        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean availabilityProduct(String productName) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        products.clear();
    }

    // удаление через Iterator
    public List<Product> removeProductsByName(String name) {
        List<Product> removed = new LinkedList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equalsIgnoreCase(name)) {
                removed.add(product);
                iterator.remove(); // Безопасное удаление через Iterator
            }
        }
        return removed; // Возвращаем список (может быть пустым)
    }
}
