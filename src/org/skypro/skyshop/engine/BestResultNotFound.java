package org.skypro.skyshop.engine;

public class BestResultNotFound extends Exception {
    public BestResultNotFound(String search) {
        super("Не найдено подходящего результата для поискового запроса: " + search);
    }
}