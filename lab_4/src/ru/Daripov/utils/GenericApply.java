package ru.Daripov.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

// Утилитный класс с обобщенным методом и автовыводом типов
public class GenericApply {
    public static <T, P> List<P> applyToList(List<T> list, Function<T, P> function) {
        List<P> result = new ArrayList<>();
        for (T item : list) {
            result.add(function.apply(item));
        }
        return result;
    }
}
