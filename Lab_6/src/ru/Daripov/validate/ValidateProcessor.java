package ru.Daripov.validate;

import java.lang.annotation.Annotation;

/**
 * Обработчик аннотации {@link Validate} для анализа классов валидации.
 * 
 * <p>Предоставляет методы для анализа аннотаций @Validate и извлечения
 * информации о указанных классах валидации.
 * 
 * <p><b>Основные возможности:</b>
 * <ul>
 *   <li>Анализ аннотаций @Validate на уровне классов</li>
 *   <li>Анализ аннотаций @Validate на уровне аннотаций</li>
 *   <li>Извлечение списка классов валидации</li>
 *   <li>Проверка поддержки определенных типов валидации</li>
 * </ul>
 * 
 * @author Дарипов Александр
 * @see Validate
 */
public class ValidateProcessor {
    
    /**
     * Выводит информацию о классах валидации, указанных в аннотации {@link Validate}.
     * 
     * <p>Метод анализирует аннотацию @Validate на переданном элементе
     * и выводит подробную информацию о всех указанных классах валидации.
     * 
     * @param element элемент для анализа (класс или аннотация)
     * 
     * @example
     * <pre>
     * {@code
     * ValidateProcessor.printValidationClasses(User.class);
     * // Вывод информации о всех классах валидации в классе User
     * }
     * </pre>
     */
    public static void printValidationClasses(Class<?> element) {
        System.out.println("\nАнализ аннотации @Validate для: " + element.getSimpleName());
        
        if (element.isAnnotationPresent(Validate.class)) {
            Validate validateAnnotation = element.getAnnotation(Validate.class);
            Class<?>[] validationClasses = validateAnnotation.value();
            
            System.out.println("Найдены классы валидации:");
            for (int i = 0; i < validationClasses.length; i++) {
                Class<?> validationClass = validationClasses[i];
                System.out.println("   " + (i + 1) + ". " + validationClass.getName());
                System.out.println("      Простое имя: " + validationClass.getSimpleName());
            }
            
            System.out.println("Всего классов валидации: " + validationClasses.length);
        } else {
            System.out.println("Элемент не содержит аннотацию @Validate");
        }
    }
    
    /**
     * Возвращает массив классов валидации из аннотации {@link Validate}.
     * 
     * @param element элемент для анализа
     * @return массив классов валидации или пустой массив если аннотация отсутствует
     */
    public static Class<?>[] getValidationClasses(Class<?> element) {
        if (element.isAnnotationPresent(Validate.class)) {
            Validate validateAnnotation = element.getAnnotation(Validate.class);
            return validateAnnotation.value();
        }
        return new Class<?>[0];
    }
    
    /**
     * Анализирует все аннотации элемента и выводит информацию о найденных аннотациях {@link Validate}.
     * 
     * @param element элемент для комплексного анализа
     */
    public static void analyzeAllValidations(Class<?> element) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("АНАЛИЗ ВАЛИДАЦИЙ: " + element.getSimpleName());
        System.out.println("=".repeat(60));
        
        // Анализ прямой аннотации @Validate
        printValidationClasses(element);
        
        // Анализ всех аннотаций элемента
        System.out.println("\nВсе аннотации элемента:");
        Annotation[] annotations = element.getAnnotations();
        if (annotations.length > 0) {
            for (Annotation annotation : annotations) {
                System.out.println("   - " + annotation.annotationType().getSimpleName());
                
                // Рекурсивный анализ если аннотация сама имеет @Validate
                if (annotation.annotationType().isAnnotationPresent(Validate.class)) {
                    System.out.println("     Содержит @Validate:");
                    Class<?>[] nestedValidations = getValidationClasses(annotation.annotationType());
                    for (Class<?> nestedClass : nestedValidations) {
                        System.out.println("        - " + nestedClass.getSimpleName());
                    }
                }
            }
        } else {
            System.out.println("   Нет аннотаций");
        }
        
        System.out.println("\n" + "=".repeat(60));
    }
}