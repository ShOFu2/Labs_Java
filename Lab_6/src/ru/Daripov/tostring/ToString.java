package ru.Daripov.tostring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import ru.Daripov.validate.Validate;
/**
 * Аннотация @ToString для настройки строкового представления объектов.
 * 
 * <p><b>Характеристики аннотации:</b>
 * <ul>
 *   <li>Цель: тип (класс) или поле ({@link ElementType#TYPE}, {@link ElementType#FIELD})</li>
 *   <li>Доступ: во время выполнения ({@link RetentionPolicy#RUNTIME})</li>
 *   <li>Свойства: необязательное свойство value типа {@link Mode}</li>
 *   <li>Значение по умолчанию: {@link Mode#YES}</li>
 * </ul>
 * 
 * <p><b>Примеры использования:</b>
 * <pre>
 * {@code
 * // На уровне класса - включить все поля по умолчанию
 * @ToString
 * public class Person {
 *     private String name;
 *     private int age;
 *     
 *     // Исключить поле из строкового представления
 *     @ToString(Mode.NO)
 *     private String password;
 * }
 * 
 * // На уровне класса с явным указанием режима
 * @ToString(Mode.YES)
 * public class Product {
 *     // все поля будут включены
 * }
 * }
 * </pre>
 * 
 * @author Дарипов Александр
 * @see ToStringHandler
 * @see Mode
 */
 
@Validate({String.class})
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ToString {
    /**
     * Режим включения/исключения в строковое представление.
     * 
     * @return режим обработки (по умолчанию YES)
     */
    Mode value() default Mode.YES;
}