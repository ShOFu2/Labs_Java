package ru.Daripov.cache;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация @Cache для указания кэшируемых областей класса.
 * 
 * <p><b>Характеристики аннотации:</b>
 * <ul>
 *   <li>Цель: тип (класс) ({@link ElementType#TYPE})</li>
 *   <li>Доступ: во время выполнения ({@link RetentionPolicy#RUNTIME})</li>
 *   <li>Свойства: необязательное свойство value типа String[]</li>
 *   <li>Значение по умолчанию: пустой массив</li>
 * </ul>
 * 
 * <p><b>Примеры использования:</b>
 * <pre>
 * {@code
 * // Без указания областей (пустой кэш)
 * @Cache
 * public class SimpleService {
 *     // ...
 * }
 * 
 * // С одной областью кэширования
 * @Cache("users")
 * public class UserService {
 *     // ...
 * }
 * 
 * // С несколькими областями кэширования
 * @Cache({"users", "profiles", "settings"})
 * public class DataService {
 *     // ...
 * }
 * }
 * </pre>
 * 
 * @author Дарипов Александр
 * @see CacheHandler
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
    /**
     * Массив строк, представляющих кэшируемые области.
     * 
     * @return массив названий кэшируемых областей (по умолчанию пустой массив)
     */
    String[] value() default {};
}