package ru.Daripov.storage;

/**
 * Универсальное хранилище для одного объекта
 */
public final class Storage<T> {
    // Поля
    private final T value;
    private final T alternative;
    
    // Конструкторы
    public Storage(T value, T alternative) {
        this.value = value;
        this.alternative = alternative;
    }
    
    public Storage(T value) {
        this(value, null);
    }
    
    // Свойства
    public T getValue() {
        return value != null ? value : alternative;
    }
    
    // Методы
    @Override
    public String toString() {
        return "Storage{value = " + value + ", alternative = " + alternative + "}";
    }

    public static <T> void printStorage(Storage<T> storage) {
        T value = storage.getValue();
        System.out.println("Извлеченное значение: " + value + " (тип: " + 
                          (value != null ? value.getClass().getSimpleName() : "null") + ")");
    }
}
