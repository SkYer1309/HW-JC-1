package org.skypro.skyshop.engine;

import org.skypro.skyshop.search.Searchable;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SearchEngine {
    //Шаг 1: HashSet вместо LinkedList — убирает дубликаты
    private final Set<Searchable> items = new HashSet<>();

    public SearchEngine() {
    }

    public SearchEngine(int capacity) {
    }

    public void add(Searchable item) {
        items.add(item); //Дубликаты автоматически отбрасываются
    }

    //Шаг 2: возвращает TreeSet с кастомным компаратором
    public TreeSet<Searchable> search(String query) {
        //Компаратор: сначала по длине имени (убывание), потом по алфавиту
        Comparator<Searchable> comparator = (s1, s2) -> {
            int lengthCompare = Integer.compare(s2.getName().length(), s1.getName().length());
            if (lengthCompare != 0) {
                return lengthCompare;
            }
            return s1.getName().compareTo(s2.getName());
        };

        TreeSet<Searchable> results = new TreeSet<>(comparator);
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
