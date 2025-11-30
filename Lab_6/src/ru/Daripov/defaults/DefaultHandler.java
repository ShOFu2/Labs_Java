package ru.Daripov.defaults;

import java.lang.reflect.Field;

/**
 * Обработчик аннотации {@link Default} через Reflection API.
 * 
 * <p>Предоставляет методы для анализа классов и полей, помеченных
 * аннотацией @Default, и извлечения информации о типах по умолчанию.
 * 
 * <p><b>Основные возможности:</b>
 * <ul>
 *   <li>Анализ аннотаций на уровне класса</li>
 *   <li>Анализ аннотаций на уровне полей</li>
 *   <li>Создание экземпляров по умолчанию</li>
 *   <li>Валидация соответствия типов</li>
 * </ul>
 * 
 * @author Дарипов Александр
 * @see Default
 */
public class DefaultHandler {
    
    /**
     * Выводит информацию о классе по умолчанию для указанного класса.
     * 
     * <p>Метод анализирует аннотацию @Default на уровне класса и выводит
     * имя указанного класса по умолчанию.
     * 
     * @param clazz класс для анализа
     * 
     * @example
     * <pre>
     * {@code
     * DefaultHandler.printDefaultClass(StringDefaultClass.class);
     * // Вывод: Класс по умолчанию: java.lang.String
     * }
     * </pre>
     * 
     * @see Default
     */
    public static void printDefaultClass(Class<?> clazz) {
        System.out.println("\nАнализ класса: " + clazz.getSimpleName());
        
        if (clazz.isAnnotationPresent(Default.class)) {
            Default defaultAnnotation = clazz.getAnnotation(Default.class);
            Class<?> defaultClass = defaultAnnotation.value();
            System.out.println("Класс по умолчанию: " + defaultClass.getName());
            System.out.println("   Простое имя: " + defaultClass.getSimpleName());
        } else {
            System.out.println("Класс не содержит аннотацию @Default");
        }
    }
    
    /**
     * Выводит информацию о полях с аннотацией {@link Default} в указанном классе.
     * 
     * <p>Метод анализирует все поля класса и для каждого поля с аннотацией @Default
     * выводит информацию о типе по умолчанию.
     * 
     * @param clazz класс для анализа полей
     * 
     * @example
     * <pre>
     * {@code
     * DefaultHandler.printDefaultFields(FieldDefaultClass.class);
     * // Вывод информации о всех полях с аннотацией @Default
     * }
     * </pre>
     */
    public static void printDefaultFields(Class<?> clazz) {
        System.out.println("\nАнализ полей класса: " + clazz.getSimpleName());
        
        Field[] fields = clazz.getDeclaredFields();
        int annotatedFieldsCount = 0;
        
        for (Field field : fields) {
            if (field.isAnnotationPresent(Default.class)) {
                annotatedFieldsCount++;
                Default defaultAnnotation = field.getAnnotation(Default.class);
                Class<?> defaultClass = defaultAnnotation.value();
                
                System.out.println(" Поле: " + field.getName());
                System.out.println("   Тип поля: " + field.getType().getSimpleName());
                System.out.println("   Тип по умолчанию: " + defaultClass.getSimpleName());
            }
        }
        
        if (annotatedFieldsCount == 0) {
            System.out.println("В классе нет полей с аннотацией @Default");
        } else {
            System.out.println("Всего аннотированных полей: " + annotatedFieldsCount);
        }
    }
    
    /**
     * Создает экземпляр значения по умолчанию для указанного класса.
     * 
     * <p>Пытается создать экземпляр класса по умолчанию, используя конструктор по умолчанию.
     * Если создание невозможно, возвращает null.
     * 
     * @param clazz класс, для которого нужно создать значение по умолчанию
     * @return экземпляр класса по умолчанию или null если создание невозможно
     * 
     * @throws SecurityException если нет доступа к конструктору через Reflection
     */
    public static Object createDefaultInstance(Class<?> clazz) {
        if (clazz.isAnnotationPresent(Default.class)) {
            Default defaultAnnotation = clazz.getAnnotation(Default.class);
            Class<?> defaultClass = defaultAnnotation.value();
            
            try {
                // Пытаемся создать экземпляр используя конструктор по умолчанию
                return defaultClass.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                System.out.println("Не удалось создать экземпляр " + defaultClass.getSimpleName() + 
                                 ": " + e.getMessage());
                return null;
            }
        }
        return null;
    }
    
    /**
     * Выводит полную информацию об аннотациях {@link Default} в классе.
     * 
     * <p>Комплексный анализ, включающий как аннотации на уровне класса,
     * так и аннотации на уровне полей.
     * 
     * @param clazz класс для комплексного анализа
     */
    public static void analyzeClassCompletely(Class<?> clazz) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("АНАЛИЗ КЛАССА: " + clazz.getSimpleName());
        System.out.println("=".repeat(60));
        
        // Анализ аннотации на уровне класса
        printDefaultClass(clazz);
        
        // Анализ аннотаций на уровне полей
        printDefaultFields(clazz);
        
        System.out.println("\nДемонстрация создания экземпляра по умолчанию:");
        // Демонстрация создания экземпляра по умолчанию
        Object defaultInstance = createDefaultInstance(clazz);
        if (defaultInstance != null) {
            System.out.println("Создан экземпляр: " + defaultInstance);
            System.out.println("   Тип: " + defaultInstance.getClass().getSimpleName());
        }

        if (defaultInstance == null) {
            System.out.println(" Для класса " + clazz.getSimpleName() + " не указан тип по умолчанию");
        }

        System.out.println("=" .repeat(60));
    }
}