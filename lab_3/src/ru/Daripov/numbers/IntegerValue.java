package ru.Daripov.numbers;
import ru.Daripov.interfaces.NumericValue;
/**
 * Целое число
 */
public class IntegerValue implements NumericValue {
    // Поле
    private final int value;
    
    // Конструктор
    public IntegerValue(int value) {
        this.value = value;
    }
    
    // Методы
    @Override
    public double toDouble() {
        return value;
    }
    
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}