package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    // ✅ 1. Меняем массив на LinkedList (условно-нефиксированны размер)
    private final LinkedList<Product> products = new LinkedList<>();

    // ✅ 2. Добавление без проверок на размер и без вывода "Невозможно добавить продукт"
    public void addProduct(Product product) {
        products.add(product);
    }

    public int getTotalPrice() {
        int total = 0;
        // ✅ Используем улучшенный цикл for-each
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public void printBasket() {
        if (products.isEmpty()) { // Проверка на пустоту через метод списка
            System.out.println("в корзине пусто");
            return;
        }

        int specialCount = 0;
        for (Product product : products) {
            System.out.println(product.toString());
            if (product.isSpecial()) {
                specialCount++;
            }
        }
        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean availabilityProduct(String productName) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        products.clear(); //  Очистка списка одной командой
    }

    //  3. НОВЫЙ МЕТОД: удаление по имени с использованием Iterator
    public List<Product> removeProductsByName(String name) {
        List<Product> removed = new LinkedList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            // Сравниваем имена (можно использовать equals или equalsIgnoreCase)
            if (product.getName().equalsIgnoreCase(name)) {
                removed.add(product);      // Добавляем в список удаленных (учитывает дубликаты)
                iterator.remove();         //Безопасное удаление через Iterator
            }
        }
        return removed; // Если ничего не найдено, вернется пустой список
    }
}