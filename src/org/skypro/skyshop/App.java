package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {

        System.out.println("===ИНТЕРНЕТ-МАГАЗИН===");
        System.out.println("======================");
//создаем товары разных типов
        Product apple = new SimpleProduct("Яблоки", 110);
        Product banana = new SimpleProduct("Бананы", 150);
        DiscountedProduct orange = new DiscountedProduct ("Апельсины",
                200,25);  //скидка 25%
        DiscountedProduct  milk = new DiscountedProduct ("Молоко",
                300,10);
        FixPriceProduct bread = new FixPriceProduct ("Хлеб"); //фикс цена 99
        FixPriceProduct  cheese = new FixPriceProduct ("Сыр");
        Product meat = new SimpleProduct("Мясо", 500);

        ProductBasket basket = new ProductBasket();
        ProductBasket basket2 = new ProductBasket();

        System.out.println("1.Добавление продукта в корзину 1");
        System.out.println("-----------------------------------------------------");
        System.out.println("добавляем яблоки (110 р.)");
        basket.addProduct(apple);
        System.out.println("добавляем бананы (150 р.)");
        basket.addProduct(banana);
        System.out.println("добавляем апельсины (200 р.)");
        basket.addProduct(orange);
        System.out.println("добавляем молоко (300 р.)");
        basket.addProduct(milk);
        System.out.println("добавляем хлеб (50 р.)");
        basket.addProduct(bread);
        System.out.println("добавляем сыр (400 р.)");
        basket.addProduct(cheese);
        System.out.println();

        System.out.println("2.Добавление продукта в заполненную корзину");
        System.out.println("-----------------------------------------------------");
        System.out.println("добавляем сыр (400 р.)");
        basket.addProduct(cheese);
        System.out.println("добавляем мясо (500 р.)");
        basket.addProduct(meat);
        System.out.println();

        System.out.println("3.Печать содержимого корзины с несколькими товарами");
        System.out.println("-----------------------------------------------------");
        System.out.println("Корзина 1:");
        basket.printBasket();

        System.out.println("4.Получение стоимости корзины с несколькими товарами");
        System.out.println("-----------------------------------------------------");
        int totalPrise = basket.getTotalPrice();
        System.out.println("Общая стоимость корзины 1 равна: " + totalPrise);
        System.out.println();

        System.out.println("5.Поиск товара, который есть в корзине");
        System.out.println("-----------------------------------------------------");
        String searchProduct = "Молоко";
        boolean found = basket.availabilityProduct(searchProduct);
        System.out.println("Наличие товара / " + searchProduct + " / в корзине - " + found);
        System.out.println();

        System.out.println("6.Поиск товара, которого нет в корзине");
        System.out.println("-----------------------------------------------------");
        String searchProduct2 = "Мясо";
        found = basket.availabilityProduct(searchProduct2);
        System.out.println("Наличие товара / " + searchProduct + " / в корзине - " + found);
        System.out.println();

        System.out.println("7.Очистка корзины");
        System.out.println("-----------------------------------------------------");
        basket.clearBasket();
        System.out.println("вызываем: basket.clearBasket()");
        System.out.println("Корзина очищена");
        System.out.println();

        System.out.println("8.Печать содержимого пустой корзины");
        System.out.println("-----------------------------------------------------");
        System.out.println("Корзина 2:");
        basket2.printBasket();
        System.out.println();


        System.out.println("9.Получение стоимости пустой корзины");
        System.out.println("-----------------------------------------------------");
        int totalPrise2 = basket2.getTotalPrice();
        System.out.println("Общая стоимость корзины 2 равна: " + totalPrise2);
        System.out.println();

        System.out.println("10.Поиск товара по имени в пустой корзине");
        System.out.println("-----------------------------------------------------");
        found = basket2.availabilityProduct(searchProduct2);
        System.out.println("Наличие товара / " + searchProduct2 + " / в корзине - " + found);
        System.out.println();


    }
}

