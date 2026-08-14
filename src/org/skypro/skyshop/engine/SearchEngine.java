package org.skypro.skyshop.engine;

import org.skypro.skyshop.search.Searchable;
import java.util.LinkedList;
import java.util.List;


public class SearchEngine {
    // ✅ 1. Меняем массив на LinkedList
    private final LinkedList<Searchable> items = new LinkedList<>();

    // Конструктор оставляем с параметром для совместимости с вашим main,
    // но размер теперь игнорируется, так как список динамический
    public SearchEngine(int capacity) {
        // capacity больше не нужен, список растет сам
    }

    public void add(Searchable item) {
        items.add(item); // ✅ Простое добавление без поиска null-ячеек
    }

    // ✅ 2. Возвращаем List и собираем ВСЕ подходящие результаты (без лимита в 5)
    public List<Searchable> search(String query) {
        List<Searchable> results = new LinkedList<>();
        for (Searchable item : items) {
            if (item.getSearchTerm().contains(query)) {
                results.add(item);
            }
        }
        return results;
    }

    // Метод findBestMatch остается без изменений, он отлично работает с LinkedList
    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = -1;

        for (Searchable item : items) {
            if (item == null) {
                continue;
            }

            String searchTerm = item.getSearchTerm();
            if (searchTerm == null) {
                continue;
            }

            // Подсчёт вхождений
            int count = 0;
            int index = 0;
            int indexOfSubstring = searchTerm.indexOf(search, index);

            while (indexOfSubstring != -1) {
                count++;
                index = indexOfSubstring + search.length();
                indexOfSubstring = searchTerm.indexOf(search, index);
            }

            if (count > maxCount) {
                maxCount = count;
                bestMatch = item;
            }
        }

        // ✅ ВОТ ЭТА ЧАСТЬ КРИТИЧНА:
        if (maxCount <= 0) {
            throw new BestResultNotFound(search); // ← Должна быть эта строка!
        }

        return bestMatch;
    }
}