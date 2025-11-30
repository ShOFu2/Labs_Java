package ru.Daripov.two;

/**
 * Обработчик аннотации {@link Two} для извлечения значений свойств.
 * 
 * <p>Предоставляет методы для анализа аннотации @Two и извлечения
 * значений её обязательных свойств first и second.
 * 
 * <p><b>Основные возможности:</b>
 * <ul>
 *   <li>Извлечение значений свойств аннотации</li>
 *   <li>Анализ аннотаций на уровне классов</li>
 *   <li>Валидация наличия аннотации</li>
 *   <li>Форматированный вывод информации</li>
 * </ul>
 * 
 * @author Дарипов Александр
 * @see Two
 */
public class TwoHandler {
    
    /**
     * Выводит значения свойств аннотации {@link Two} для указанного класса.
     * 
     * <p>Метод анализирует аннотацию @Two на переданном классе
     * и выводит значения обоих обязательных свойств.
     * 
     * @param clazz класс для анализа
     * 
     * @example
     * <pre>
     * {@code
     * TwoProcessor.printTwoProperties(DatabaseConfig.class);
     * // Вывод: first: "MySQL Database", second: 3306
     * }
     * </pre>
     */
    public static void printTwoProperties(Class<?> clazz) {
        System.out.println("\nАнализ аннотации @Two для: " + clazz.getSimpleName());
        
        if (clazz.isAnnotationPresent(Two.class)) {
            Two twoAnnotation = clazz.getAnnotation(Two.class);
            String firstValue = twoAnnotation.first();
            int secondValue = twoAnnotation.second();
            
            System.out.println("Найдена аннотация @Two:");
            System.out.println("   first: \"" + firstValue + "\"");
            System.out.println("   second: " + secondValue);
        } else {
            System.out.println("Класс не содержит аннотацию @Two");
        }
    }
    
    /**
     * Выполняет комплексный анализ класса с аннотацией {@link Two}.
     * 
     * @param clazz класс для комплексного анализа
     */
    public static void analyzeClassCompletely(Class<?> clazz) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("АНАЛИЗ КЛАССА: " + clazz.getSimpleName());
        System.out.println("=".repeat(60));
        
        // Анализ аннотации @Two
        printTwoProperties(clazz);
        
        System.out.println("\n" + "=".repeat(60));
    }
}