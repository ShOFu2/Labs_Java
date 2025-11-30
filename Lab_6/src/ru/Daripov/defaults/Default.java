package ru.Daripov.defaults;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация @Default для указания типа или значения по умолчанию.
 * 
 * <p><b>Характеристики аннотации:</b>
 * <ul>
 *   <li>Цель: тип (класс) или поле ({@link ElementType#TYPE}, {@link ElementType#FIELD})</li>
 *   <li>Доступ: во время выполнения ({@link RetentionPolicy#RUNTIME})</li>
 *   <li>Свойства: обязательное свойство value типа Class</li>
 * </ul>
 * 
 * <p><b>Примеры использования:</b>
 * <pre>
 * {@code
 * // На уровне класса
 * @Default(String.class)
 * public class MyClass { }
 * 
 * // На уровне поля
 * public class AnotherClass {
 *     @Default(Integer.class)
 *     private Object value;
 * }
 * }
 * </pre>
 * 
 * @author Дарипов Александр
 * @see DefaultHandler
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Default {
    /**
     * Класс, представляющий тип или значение по умолчанию.
     * 
     * @return класс типа по умолчанию
     */
    Class<?> value();
}