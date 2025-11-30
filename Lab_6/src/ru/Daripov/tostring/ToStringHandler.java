package ru.Daripov.tostring;

import java.lang.reflect.Field;

/**
 * Обработчик аннотации {@link ToString} для генерации строкового представления объектов.
 * 
 * <p>Предоставляет методы для создания строкового представления объектов
 * с учетом аннотаций @ToString на уровне класса и полей.
 * 
 * <p><b>Основные возможности:</b>
 * <ul>
 *   <li>Генерация строкового представления с учетом аннотаций</li>
 *   <li>Обработка аннотаций на уровне класса</li>
 *   <li>Обработка аннотаций на уровне полей</li>
 *   <li>Поддержка различных типов данных</li>
 *   <li>Форматирование вывода</li>
 * </ul>
 * 
 * @author Дарипов Александр
 * @see ToString
 * @see Mode
 */
public class ToStringHandler {
    
    /**
     * Формирует строковое представление объекта, учитывая аннотации {@link ToString}.
     * 
     * <p>Метод анализирует аннотации @ToString на уровне класса и полей,
     * и включает в результат только те поля, где аннотация имеет значение {@link Mode#YES}.
     * 
     * <p><b>Логика работы:</b>
     * <ol>
     *   <li>Проверяет аннотацию @ToString на уровне класса</li>
     *   <li>Если класс не аннотирован, используется режим по умолчанию (YES)</li>
     *   <li>Для каждого поля проверяет аннотацию @ToString</li>
     *   <li>Включает поле только если его режим YES</li>
     *   <li>Форматирует результат в виде "ClassName{field1 = value1, field2 = value2}"</li>
     * </ol>
     * 
     * @param object объект для преобразования в строку
     * @return строковое представление объекта с учетом аннотаций
     * 
     * @throws SecurityException если нет доступа к полям через Reflection
     * 
     * @example
     * <pre>
     * {@code
     * Person person = new Person("John", 25, "john@test.com", "pass123", "key456");
     * String result = ToStringHandler.toString(person);
     * // Результат: Person{name=John, age=25, email=john@test.com}
     * // Поля password и secretKey исключены
     * }
     * </pre>
     */
    public static String toString(Object object) {
        if (object == null) {
            return "null";
        }
        
        Class<?> clazz = object.getClass();
        String result = "";
        
        // Получаем аннотацию на уровне класса
        Mode classMode = getClassToStringMode(clazz);
        
        result += clazz.getSimpleName() + "{";
        
        Field[] fields = clazz.getDeclaredFields();
        boolean firstField = true;
        
        for (Field field : fields) {
            // Определяем режим для поля
            Mode fieldMode = getFieldToStringMode(field, classMode);
            
            if (fieldMode == Mode.YES) {
                try {
                    field.setAccessible(true);
                    Object value = field.get(object);
                    
                    if (!firstField) {
                        result += ", ";
                    }
                    
                    result += field.getName() + " = ";
                    result += formatValue(value);
                    
                    firstField = false;
                    
                } catch (IllegalAccessException e) {
                    result += field.getName() + "=[ACCESS_ERROR]";
                    if (!firstField) {
                        result += ", ";
                    }
                    firstField = false;
                }
            }
        }
        
        result += "}";
        return result;
    }
    
    /**
     * Получает режим {@link ToString} для класса.
     * 
     * @param clazz класс для анализа
     * @return режим обработки класса (по умолчанию YES)
     */
    private static Mode getClassToStringMode(Class<?> clazz) {
        if (clazz.isAnnotationPresent(ToString.class)) {
            ToString toStringAnnotation = clazz.getAnnotation(ToString.class);
            return toStringAnnotation.value();
        }
        return Mode.YES; // Режим по умолчанию
    }
    
    /**
     * Получает режим {@link ToString} для поля.
     * 
     * @param field поле для анализа
     * @param classMode режим класса по умолчанию
     * @return режим обработки поля
     */
    private static Mode getFieldToStringMode(Field field, Mode classMode) {
        if (field.isAnnotationPresent(ToString.class)) {
            ToString toStringAnnotation = field.getAnnotation(ToString.class);
            return toStringAnnotation.value();
        }
        return classMode; // Используем режим класса, если поле не аннотировано
    }
    
    /**
     * Форматирует значение для строкового представления.
     * 
     * @param value значение для форматирования
     * @return отформатированное строковое представление значения
     */
    private static String formatValue(Object value) {
        if (value == null) {
            return "null";
        }
        
        if (value instanceof String || value instanceof Character) {
            return "'" + value + "'";
        }
        
        return value.toString();
    }
    
    /**
     * Анализирует аннотации {@link ToString} в классе и выводит информацию.
     * 
     * @param clazz класс для анализа
     */
    public static void analyzeToStringAnnotations(Class<?> clazz) {
        System.out.println("\nАнализ аннотаций @ToString в классе: " + clazz.getSimpleName());
        
        Mode classMode = getClassToStringMode(clazz);
        System.out.println("   Режим класса: " + classMode);
        
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("   Всего полей: " + fields.length);
        
        int includedFields = 0;
        int excludedFields = 0;
        
        for (Field field : fields) {
            Mode fieldMode = getFieldToStringMode(field, classMode);
            
            if (fieldMode == Mode.YES) {
                includedFields++;
                System.out.println("    " + field.getName() + " - ВКЛЮЧЕНО");
            } else {
                excludedFields++;
                System.out.println("    " + field.getName() + " - ИСКЛЮЧЕНО");
            }
        }
        
        System.out.println("   Итог: " + includedFields + " включено, " + excludedFields + " исключено");
    }
}