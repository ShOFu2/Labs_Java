package ru.Daripov.numbers;
import ru.Daripov.interfaces.NumericValue;
/**
 * Десятичная дробь
 */
public class DecimalValue implements NumericValue{
    // Поле
    private final double value;
    
    // Конструктор
    public DecimalValue(double value) {
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
