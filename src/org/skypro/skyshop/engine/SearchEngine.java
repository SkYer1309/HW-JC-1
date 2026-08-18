package org.skypro.skyshop.engine;

import org.skypro.skyshop.search.Searchable;
import java.util.LinkedList;
import java.util.List;


public class SearchEngine {
    // ✅ LinkedList вместо массива
    private final LinkedList<Searchable> items = new LinkedList<>();

    // Конструктор без параметров (размер не нужен)
    public SearchEngine() {
    }

    // Для совместимости со старым кодом в main
    public SearchEngine(int capacity) {
    }

    public void add(Searchable item) {
        items.add(item);
    }

    // ✅ Возвращает ВСЕ результаты, без ограничения в 5
    public List<Searchable> search(String query) {
        List<Searchable> results = new LinkedList<>();
        for (Searchable item : items) {
            if (item.getSearchTerm().contains(query)) {
                results.add(item);
            }
        }
        return results;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = -1;

        for (Searchable item : items) {
            String searchTerm = item.getSearchTerm();
            if (searchTerm == null) continue;

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

        if (maxCount <= 0) {
            throw new BestResultNotFound(search);
        }

        return bestMatch;
    }
}