package ru.Daripov.main;

import ru.Daripov.interfaces.NumericValue;

/**
 * Утилитный класс для работы с числовыми значениями
 */
public class MathUtils {
    public static double sum(NumericValue... values) {
        double result = 0.0;
        for (NumericValue value : values) {
            result += value.toDouble(); // виртуальный вызов
        }
        return result;
    }
    
    // Метод для вывода красивого результа
    public static void calcAndPrint(String expression, NumericValue... values) {
        double result = sum(values);
        System.out.println(expression + " = " + result);
    }
}