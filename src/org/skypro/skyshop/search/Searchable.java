package org.skypro.skyshop.search;

public interface Searchable {

    // Термин для поиска (по нему ищем через contains)
    String getSearchTerm();

    // Тип контента: "PRODUCT" или "ARTICLE"
    String getContentType();

    // Имя Searchable-объекта
    String getName();

    // Строковое представление (default метод)
    default String getStringRepresentation() {
        return getName() + " — " + getContentType();
    }
}