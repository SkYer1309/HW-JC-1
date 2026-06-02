package org.skypro.skyshop.engine;

import org.skypro.skyshop.search.Searchable; // Импортируем интерфейс
import org.skypro.skyshop.engine.BestResultNotFound; // Импортируем исключение

public class SearchEngine {
    private final Searchable[] items;

    public SearchEngine(int capacity) {
        this.items = new Searchable[capacity];
    }

    public void add(Searchable item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                return;
            }
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int foundCount = 0;

        for (Searchable item : items) {
            if (item == null) continue;
            if (item.getSearchTerm().contains(query)) {
                results[foundCount] = item;
                foundCount++;
                if (foundCount == 5) break;
            }
        }
        return results;
    }

    // ✅ МЕТОД findBestMatch
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