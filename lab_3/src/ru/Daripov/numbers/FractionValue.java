package ru.Daripov.numbers;
import ru.Daripov.interfaces.NumericValue;
/**
 * Обыкновенная дробь
 */
public class FractionValue implements NumericValue {
    // Поля
    private int numerator;
    private int denominator;
    
    // Конструктор
    public FractionValue(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть нулем");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    // Методы
    @Override
    public double toDouble() {
        return (double) numerator / denominator;
    }
    
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
