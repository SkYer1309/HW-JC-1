package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] products;
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
            total += products[i].getCost();
        }
        return total;
    }

    //содержимое корзины
    public void printBasket() {
        if (productCount == 0) {
            System.out.println("В корзине путо");
            return;
        }
        for (int i = 0; i < productCount; i++) {
            System.out.println(products[i].getName() + ": " + products[i].getCost());
        }
        System.out.println("Итог: " + getTotalPrice());
    }

    //наличие продукта в корзине
    public boolean availabilityProduct(String productName) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().equals(productName)) {
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
