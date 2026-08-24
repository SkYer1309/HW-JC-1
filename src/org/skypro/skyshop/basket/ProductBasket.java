package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.*;

public class ProductBasket {
    // HashMap: ключ = имя продукта, значение = список продуктов с таким именем
    private final HashMap<String, List<Product>> products = new HashMap<>();

    // Добавление продукта через computeIfAbsent
    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>())
                .add(product);
    }

    // Получение общей стоимости
    public int getTotalPrice() {
        int total = 0;
        for (List<Product> productList : products.values()) {
            for (Product p : productList) {
                total += p.getPrice();
            }
        }
        return total;
    }

    // Печать содержимого корзины
    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }

        int specialCount = 0;
        int total = 0;

        // Перебор всех значений Map через foreach
        for (List<Product> productList : products.values()) {
            for (Product p : productList) {
                System.out.println(p.toString());
                total += p.getPrice();
                if (p.isSpecial()) {
                    specialCount++;
                }
            }
        }
        System.out.println("Итого: " + total);
        System.out.println("Специальных товаров: " + specialCount);
    }

    // Проверка наличия продукта по имени
    public boolean availabilityProduct(String productName) {
        return products.containsKey(productName);
    }

    // Очистка корзины
    public void clearBasket() {
        products.clear();
    }

    // Удаление продуктов по имени через remove по ключу
    public List<Product> removeProductsByName(String name) {
        // Вызов remove по ключу — возвращает список удалённых продуктов (или null)
        List<Product> removed = products.remove(name);
        if (removed == null) {
            return new ArrayList<>(); // Возвращаем пустой список, если продукта не было
        }
        return removed;
    }
}