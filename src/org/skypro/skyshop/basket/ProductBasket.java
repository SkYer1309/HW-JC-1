package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.*;
import java.util.stream.Collectors;

public class ProductBasket {
    // HashMap: ключ = имя продукта, значение = список продуктов с таким именем
    private final HashMap<String, List<Product>> products = new HashMap<>();

    // Добавление продукта через computeIfAbsent
    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>())
                .add(product);
    }

    // Получение общей стоимости
    // getTotalPrice() через flatMap, mapToInt, sum
    public int getTotalPrice() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    // Печать содержимого корзины
    // printBasket() через flatMap и forEach
    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }

        // Подсчёт специальных товаров вынесен в отдельный метод
        long specialCount = getSpecialCount();

        // Вывод через flatMap и forEach
        products.values().stream()
                .flatMap(Collection::stream)
                .forEach(product -> {
                    System.out.println(product.toString());
                });

        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialCount);
    }

    // Приватный метод подсчёта специальных товаров через filter и count
    private long getSpecialCount() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
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