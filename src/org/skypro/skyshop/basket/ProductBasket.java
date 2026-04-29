package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products;
    private int productCount;

    private Product[] getProducts() {
        return products;
    }

    public ProductBasket() {
        this.products = new Product[5];
        this.productCount = 0;
    }

    //добавление товара в корзину
    public void addProduct(Product product) {
        if (productCount < products.length) {
            products[productCount] = product;
            productCount++;
        } else {
            System.out.println("--> Невозможно добавить продукт");
        }
    }

    //получение общей стоимости
    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < productCount; i++) {
            total += products[i].getPrice();
        }
        return total;
    }

    //содержимое корзины

    public void printBasket() {
        boolean empty = true;
        int specialCount = 0;

        for (Product products : products) {
            if (products != null) {
                // Используем переопределённый toString() каждого товара
                System.out.println(products.toString());
                empty = false;

                // Подсчёт специальных товаров через полиморфный вызов
                if (products.isSpecial()) {
                    specialCount++;
                }
            }
        }

        if (empty) {
            System.out.println("в корзине пусто");
        } else {
            System.out.println("Итого: " + getTotalPrice());
            System.out.println("Специальных товаров: " + specialCount);
        }
    }


    //наличие продукта в корзине
    public boolean availabilityProduct(String productName) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    //очистка корзины
    public void clearBasket() {
        for (int i = 0; i < productCount; i++) {
            products[i] = null;
        }
        productCount = 0;
    }


}
