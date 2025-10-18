package ru.Daripov.numbers;
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

/**
 * Калькулятор возведения в степень
 */
public class PowerCalculator {
    public static double power(String xStr, String yStr) {
        int x = parseInt(xStr);
        int y = parseInt(yStr);
        return pow(x, y);
    }
}