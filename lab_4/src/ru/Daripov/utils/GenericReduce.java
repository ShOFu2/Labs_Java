package ru.Daripov.utils;

import java.util.List;
import java.util.function.BinaryOperator;

// Утилитный класс с обобщенным методом сокращения
public class GenericReduce {
    public static <T> T reduce(List<T> list, T identity, BinaryOperator<T> accumulator) {
        if (list == null || list.isEmpty()) {
            return identity;
        }
        
        T result = identity;
        for (T item : list) {
            if (item != null) {
                result = accumulator.apply(result, item);
            }
        }
        return result;
    }
}
