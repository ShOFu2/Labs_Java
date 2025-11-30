package ru.Daripov.invoke;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация @Invoke для автоматического вызова методов через Reflection API.
 * 
 * <p><b>Характеристики аннотации:</b>
 * <ul>
 *   <li>Цель: только методы ({@link ElementType#METHOD})</li>
 *   <li>Доступ: во время выполнения ({@link RetentionPolicy#RUNTIME})</li>
 *   <li>Свойства: отсутствуют</li>
 * </ul>
 * 
 * @author Дарипов Александр
 * @see InvokeHandler
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Invoke {
    // Аннотация не имеет свойств
}