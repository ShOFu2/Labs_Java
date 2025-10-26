package ru.Daripov.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// Утилитный класс с обобщенным методом фильтрации
public class GenericFilter {
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
}
