package org.skypro.skyshop.engine;

import org.skypro.skyshop.search.Searchable;

public class SearchEngine {
    // ✅ Массив Searchable, размер передаётся в конструкторе
    private final Searchable[] items;

    public SearchEngine(int capacity) {
        this.items = new Searchable[capacity];
    }

    // ✅ Добавление: ищет первую свободную ячейку (null)
    public void add(Searchable item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                return;
            }
        }
        // Если массив полон — элемент не добавляется (выход за границы предотвращён)
    }

    // ✅ Поиск: возвращает максимум 5 результатов через contains()
    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int foundCount = 0;

        for (Searchable item : items) {
            // ✅ Пропускаем null-элементы
            if (item == null) {
                continue;
            }

            // ✅ Поиск через contains() на getSearchTerm()
            if (item.getSearchTerm().contains(query)) {
                results[foundCount] = item;
                foundCount++;

                // ✅ Ограничиваем результат 5 элементами
                if (foundCount == 5) {
                    break;
                }
            }
        }
        return results;
    }
}