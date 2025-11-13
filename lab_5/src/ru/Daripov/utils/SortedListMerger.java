package ru.Daripov.utils;

import java.util.List;

// Утилитный класс для работы с упорядоченными списками
public class SortedListMerger {
    public static <T extends Comparable<T>> void merge(List<T> L1, List<T> L2) {
        for (T element : L2) {
            int i = 0;
            while (i < L1.size() && element.compareTo(L1.get(i)) > 0) {
                i++;
            }
            L1.add(i, element);
        }
    }
    
    public static <T extends Comparable<T>> boolean isSorted(List<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }
}
