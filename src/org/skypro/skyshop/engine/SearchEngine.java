package org.skypro.skyshop.engine;

import org.skypro.skyshop.search.Searchable;

import java.util.LinkedList;
import java.util.TreeMap;

public class SearchEngine {
    // LinkedList для хранения всех элементов
    private final LinkedList<Searchable> items = new LinkedList<>();

    public SearchEngine() {
    }

    public SearchEngine(int capacity) {
    }

    public void add(Searchable item) {
        items.add(item);
    }

    // Возвращает TreeMap — отсортированную по ключу (имени)
    public TreeMap<String, Searchable> search(String query) {
        TreeMap<String, Searchable> results = new TreeMap<>();
        for (Searchable item : items) {
            if (item.getSearchTerm().contains(query)) {
                // Ключ = имя, значение = сам объект
                // Если несколько объектов с одинаковым именем — последний перезапишет предыдущий
                results.put(item.getName(), item);
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
