package org.skypro.skyshop.engine;

import org.skypro.skyshop.search.Searchable;

public class SearchEngine {
    private final Searchable[] items;
    private int size;

    public SearchEngine(int capacity) {
        items = new Searchable[capacity];
        size = 0;
    }

    public void add(Searchable item) {
        if (size < items.length) {
            items[size] = item;
            size++;
        }
    }

    public Searchable[] search(String search) {
        Searchable[] results = new Searchable[5];
        int resultIndex = 0;
        for (int i = 0; i < size && resultIndex < 5; i++) {
            Searchable item = items[i];
            if (item != null) {
                String searchTerm = item.getSearchTerm();
                if (searchTerm != null && search.contains(search)) {
                    results[resultIndex] = item;
                    resultIndex++;
                }
            }
        }
        return results;
    }
}
