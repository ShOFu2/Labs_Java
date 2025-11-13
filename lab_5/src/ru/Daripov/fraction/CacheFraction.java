package ru.Daripov.fraction;

public class CacheFraction extends Fraction {
    // Кэш для вещественного значения
    private Double realValueCache = null;
    
    // Свойства
    @Override
    public double getRealValue() {
        if (realValueCache == null) {
            realValueCache = super.getRealValue();
            System.out.println("Выполнено вычисление! Значение: " + realValueCache);
        } else {
            System.out.println("Использован кэш! Значение: " + realValueCache);
        }
        return realValueCache;
    }
    
    @Override
    public void setValues(int numerator, int denominator) {
        super.setValues(numerator, denominator);
        
        realValueCache = null;
    }
    
    // Конструктор
    public CacheFraction(int numerator, int denominator) {
        super(numerator, denominator);
    }
    
    // Методы
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
    
    @Override
    public int hashCode() {
        return 31 * numerator + denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return Integer.compare(fraction.numerator, numerator) == 0
         && Integer.compare(fraction.denominator, denominator) == 0;
    }
}
