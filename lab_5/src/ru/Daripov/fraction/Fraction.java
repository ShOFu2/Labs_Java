package ru.Daripov.fraction;
import ru.Daripov.interfaces.FractionInterface;

// Класс, описывающий сущность Дробь
public class Fraction implements FractionInterface {
    // поля
    protected int numerator;
    protected int denominator;

    // Свойства
    @Override
    public double getRealValue() {
        return (double) numerator / denominator;
    }
    
    @Override
    public void setValues(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }

        this.numerator = numerator;
        this.denominator = denominator;

        if (this.denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
        reduceFraction();
    }
    
    public int getNumerator() {
        return numerator;
    }
    
    public int getDenominator() {
        return denominator;
    }

    // Конструктор
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }

        this.numerator = numerator;
        this.denominator = denominator;

        if (this.denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
        reduceFraction();
    }
    
    // Методы
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Fraction fraction = (Fraction) obj;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }
    
    @Override
    public int hashCode() {
        return 31 * numerator + denominator;
    }

    private void reduceFraction() {
        int gcd = findGCD(Math.abs(numerator), Math.abs(denominator));
        if (gcd > 1) {
            numerator /= gcd;
            denominator /= gcd;
        }
    }

    private int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
