package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discountPercent;

    public DiscountedProduct(String name, int basePrice, int discountPercent) {
        super(name);
        if (basePrice <= 0) {
            throw new IllegalArgumentException(
                    "Базовая цена должна быть строго больше 0"
            );
        }
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException(
                    "Процент скидки должен быть в диапазоне от 0 до 100 включительно. Получено: " + discountPercent
            );
        }
        this.basePrice = basePrice;
        this.discountPercent = discountPercent;
    }

    @Override
    public int getPrice() {  // ✅ ОБЯЗАТЕЛЬНО! Возвращает int
        return basePrice - (basePrice * discountPercent / 100);
    }

    @Override
    public boolean isSpecial() {  // ✅ ОБЯЗАТЕЛЬНО!
        return true;  // товар со скидкой — специальный
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + discountPercent + "%)";
    }
}