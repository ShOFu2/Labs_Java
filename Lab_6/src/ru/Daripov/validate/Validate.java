package ru.Daripov.validate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация @Validate для указания типов валидации объектов.
 * 
 * <p><b>Характеристики аннотации:</b>
 * <ul>
 *   <li>Цель: тип (класс) или аннотация ({@link ElementType#TYPE}, {@link ElementType#ANNOTATION_TYPE})</li>
 *   <li>Доступ: во время выполнения ({@link RetentionPolicy#RUNTIME})</li>
 *   <li>Свойства: обязательное свойство value типа Class[]</li>
 * </ul>
 * 
 * <p><b>Примеры использования:</b>
 * <pre>
 * {@code
 * // На уровне класса с несколькими валидаторами
 * @Validate({String.class, Integer.class, Date.class})
 * public class User {
 *     private String name;
 *     private Integer age;
 *     private Date birthDate;
 * }
 * 
 * // На уровне аннотации для создания составных валидаторов
 * @Validate({EmailValidator.class, LengthValidator.class})
 * public @interface Email {
 *     String value();
 * }
 * }
 * </pre>
 * 
 * @author Дарипов Александр
 * @see ValidateProcessor
 */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {
    /**
     * Массив классов, представляющих типы для валидации.
     * 
     * @return массив классов-валидаторов
     */
    Class<?>[] value();
}