package ru.Daripov.two;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация @Two для демонстрации работы с двумя свойствами разных типов.
 * 
 * <p><b>Характеристики аннотации:</b>
 * <ul>
 *   <li>Цель: тип (класс) ({@link ElementType#TYPE})</li>
 *   <li>Доступ: во время выполнения ({@link RetentionPolicy#RUNTIME})</li>
 *   <li>Свойства: два обязательных свойства first (String) и second (int)</li>
 * </ul>
 * 
 * <p><b>Пример использования:</b>
 * <pre>
 * {@code
 * // Базовое использование
 * @Two(first = "Hello", second = 42)
 * public class MyClass {
 *     // ...
 * }
 * }
 * </pre>
 * 
 * @author Дарипов Александр
 * @see TwoHandler
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Two {
    /**
     * Строковое свойство аннотации.
     * 
     * @return строковое значение
     */
    String first();
    
    /**
     * Числовое свойство аннотации.
     * 
     * @return целочисленное значение
     */
    int second();
}