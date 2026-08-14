package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.engine.BestResultNotFound;
import org.skypro.skyshop.engine.SearchEngine;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.Searchable;

import java.util.List; //  Добавлен импорт для List

public class App {
    public static void main(String[] args) {

        System.out.println("===ИНТЕРНЕТ-МАГАЗИН===");
        System.out.println("======================");

        Product apple = new SimpleProduct("Яблоки", 110);
        Product banana = new SimpleProduct("Бананы", 150);
        DiscountedProduct orange = new DiscountedProduct("Апельсины", 200, 25);
        DiscountedProduct milk = new DiscountedProduct("Молоко", 300, 10);
        FixPriceProduct bread = new FixPriceProduct("Хлеб");
        FixPriceProduct cheese = new FixPriceProduct("Сыр");
        Product meat = new SimpleProduct("Мясо", 500);

        ProductBasket basket = new ProductBasket();
        ProductBasket basket2 = new ProductBasket();

        System.out.println("1.Добавление продукта в корзину 1");
        System.out.println("-----------------------------------------------------");
        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(orange);
        basket.addProduct(milk);
        basket.addProduct(bread);
        basket.addProduct(cheese);
        System.out.println();

        // ✅ УДАЛЕНО: Блок "2.Добавление продукта в заполненную корзину" и вывод ошибки

        System.out.println("2.Печать содержимого корзины с несколькими товарами");
        System.out.println("-----------------------------------------------------");
        System.out.println("Корзина 1:");
        basket.printBasket();
        System.out.println();

        System.out.println("3.Получение стоимости корзины с несколькими товарами");
        System.out.println("-----------------------------------------------------");
        int totalPrise = basket.getTotalPrice();
        System.out.println("Общая стоимость корзины 1 равна: " + totalPrise);
        System.out.println();

        System.out.println("4.Поиск товара, который есть в корзине");
        System.out.println("-----------------------------------------------------");
        String searchProduct = "Молоко";
        boolean found = basket.availabilityProduct(searchProduct);
        System.out.println("Наличие товара / " + searchProduct + " / в корзине - " + found);
        System.out.println();

        System.out.println("5.Поиск товара, которого нет в корзине");
        System.out.println("-----------------------------------------------------");
        String searchProduct2 = "Мясо";
        found = basket.availabilityProduct(searchProduct2);
        System.out.println("Наличие товара / " + searchProduct2 + " / в корзине - " + found);
        System.out.println();

        System.out.println("6.Очистка корзины");
        System.out.println("-----------------------------------------------------");
        basket.clearBasket();
        System.out.println("вызываем: basket.clearBasket()");
        System.out.println("Корзина очищена");
        System.out.println();

        System.out.println("7.Печать содержимого пустой корзины");
        System.out.println("-----------------------------------------------------");
        System.out.println("Корзина 2:");
        basket2.printBasket();
        System.out.println();

        System.out.println("8.Получение стоимости пустой корзины");
        System.out.println("-----------------------------------------------------");
        int totalPrise2 = basket2.getTotalPrice();
        System.out.println("Общая стоимость корзины 2 равна: " + totalPrise2);
        System.out.println();

        System.out.println("9.Поиск товара по имени в пустой корзине");
        System.out.println("-----------------------------------------------------");
        found = basket2.availabilityProduct(searchProduct2);
        System.out.println("Наличие товара / " + searchProduct2 + " / в корзине - " + found);
        System.out.println();

        // ==========================================
        // ✅ НОВОЕ: Демонстрация удаления продуктов (п.2 задания)
        // ==========================================
        // Сначала добавим товары для теста (включая дубликат)
        basket.addProduct(apple);
        basket.addProduct(milk);
        basket.addProduct(milk); // Дубликат

        System.out.println("10.Удаление существующего продукта из корзины");
        System.out.println("-----------------------------------------------------");
        List<Product> removed = basket.removeProductsByName("Молоко");
        System.out.println("Удаленные продукты:");
        for (Product p : removed) {
            System.out.println("- " + p.getName() + " (" + p.getPrice() + " р.)");
        }
        System.out.println("Содержимое корзины после удаления:");
        basket.printBasket();
        System.out.println();

        System.out.println("11.Удаление несуществующего продукта из корзины");
        System.out.println("-----------------------------------------------------");
        List<Product> removedEmpty = basket.removeProductsByName("Планшет");
        if (removedEmpty.isEmpty()) { // ✅ Проверка на пустой список
            System.out.println("Список пуст");
        }
        System.out.println("Содержимое корзины:");
        basket.printBasket();
        System.out.println();


        System.out.println("======== РАБОТА ПОИСКА =========");
        SearchEngine searchEngine = new SearchEngine(20);

        searchEngine.add(apple);
        searchEngine.add(banana);
        searchEngine.add(bread);
        searchEngine.add(cheese);
        searchEngine.add(meat);

        SimpleProduct tomatoes = new SimpleProduct("Томаты", 80);
        SimpleProduct butter = new SimpleProduct("Масло", 120);
        DiscountedProduct fish = new DiscountedProduct("Рыба", 300, 15);
        FixPriceProduct pencil = new FixPriceProduct("Карандаш");

        searchEngine.add(tomatoes);
        searchEngine.add(butter);
        searchEngine.add(fish);
        searchEngine.add(pencil);

        Article article1 = new Article("Польза яблок", "Яблоки богаты витаминами");
        Article article2 = new Article("Молочные продукты", "Молоко и молочные продукты содержат кальций");
        Article article3 = new Article("Как выбрать сыр", "Сыр бывает разных сортов: твердый, мягкий");
        Article article4 = new Article("Рыба в рационе", "Рыба богата омега-3 жирными кислотами");


        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);

        System.out.println("======== Поиск с разными строками ========");
        System.out.println();
        System.out.println("\n=== Поиск: 'Сыр' ===");
        printSearchResults(searchEngine.search("Сыр"));

        System.out.println("\n=== Поиск: 'Молоко' ===");
        printSearchResults(searchEngine.search("Молоко"));

        System.out.println("\n=== Поиск: 'Рыба' ===");
        printSearchResults(searchEngine.search("Рыба"));

        System.out.println("\n=== Поиск: 'полезны' ===");
        printSearchResults(searchEngine.search("полезны"));

        System.out.println("\n=== Поиск: 'нет такого' ===");
        printSearchResults(searchEngine.search("нет такого"));


        System.out.println("\n======== ПРОВЕРКА ВАЛИДАЦИИ ========");
        try { new SimpleProduct("", 100); } catch (IllegalArgumentException e) { System.out.println("Ошибка: " + e.getMessage()); }
        try { new SimpleProduct(null, 100); } catch (IllegalArgumentException e) { System.out.println("Ошибка: " + e.getMessage()); }
        try { new SimpleProduct("   ", 100); } catch (IllegalArgumentException e) { System.out.println("Ошибка: " + e.getMessage()); }
        try { new SimpleProduct("Товар", 0); } catch (IllegalArgumentException e) { System.out.println("Ошибка: " + e.getMessage()); }
        try { new SimpleProduct("Товар", -50); } catch (IllegalArgumentException e) { System.out.println("Ошибка: " + e.getMessage()); }
        try { new DiscountedProduct("Товар", 0, 20); } catch (IllegalArgumentException e) { System.out.println("Ошибка: " + e.getMessage()); }
        try { new DiscountedProduct("Товар", 100, -10); } catch (IllegalArgumentException e) { System.out.println("Ошибка: " + e.getMessage()); }
        try { new DiscountedProduct("Товар", 100, 150); } catch (IllegalArgumentException e) { System.out.println("Ошибка: " + e.getMessage()); }

        System.out.println("\n======== ПРОВЕРКА findBestMatch ========");
        try {
            Searchable best = searchEngine.findBestMatch("яблоко");
            System.out.println("Найдено: " + best.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Searchable best = searchEngine.findBestMatch("несуществующий_товар_12345");
            System.out.println("Найдено: " + best.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    // ИЗМЕНЕНО: метод теперь принимает List<Searchable> вместо массива Searchable[]
    private static void printSearchResults(List<Searchable> results) {
        if (results.isEmpty()) {
            System.out.println("Ничего не найдено");
            return;
        }
        for (Searchable item : results) {
            System.out.println(item.getStringRepresentation());
        }
    }
}