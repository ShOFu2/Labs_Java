package ru.Daripov.utils;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

// Утилитный класс для преобразования коллекций
public class GenericCollection {
    public static <T, P> P transform(List<T> sourceList, Supplier<P> collectionSupplier, BiConsumer<P, T> accumulator) {
        P result = collectionSupplier.get();
        for (T item : sourceList) {
            accumulator.accept(result, item);
        }
        return result;
    }
}
