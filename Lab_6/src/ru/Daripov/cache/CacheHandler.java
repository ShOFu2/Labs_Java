package ru.Daripov.cache;

/**
 * Обработчик аннотации {@link Cache} для анализа кэшируемых областей.
 * 
 * <p>Предоставляет методы для анализа аннотации @Cache и извлечения
 * информации о кэшируемых областях класса.
 * 
 * <p><b>Основные возможности:</b>
 * <ul>
 *   <li>Анализ аннотаций @Cache на уровне классов</li>
 *   <li>Извлечение списка кэшируемых областей</li>
 *   <li>Проверка наличия конкретных областей кэширования</li>
 *   <li>Статистика по кэшируемым областям</li>
 * </ul>
 * 
 * @author Дарипов Александр
 * @see Cache
 */
public class CacheHandler {
    
    /**
     * Выводит список всех кэшируемых областей из аннотации {@link Cache}.
     * 
     * <p>Метод анализирует аннотацию @Cache на переданном классе
     * и выводит список всех кэшируемых областей или сообщение, что список пуст.
     * 
     * @param clazz класс для анализа
     * 
     * @example
     * <pre>
     * {@code
     * CacheHandler.printCacheAreas(UserService.class);
     * // Вывод списка областей кэширования или сообщение о пустом списке
     * }
     * </pre>
     */
    public static void printCacheAreas(Class<?> clazz) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("АНАЛИЗ КЭШИРОВАНИЯ: " + clazz.getSimpleName());
        System.out.println("=".repeat(60));

        System.out.println("\nАнализ аннотации @Cache для: " + clazz.getSimpleName());
        
        if (clazz.isAnnotationPresent(Cache.class)) {
            Cache cacheAnnotation = clazz.getAnnotation(Cache.class);
            String[] cacheAreas = cacheAnnotation.value();
            
            if (cacheAreas.length == 0) {
                System.out.println("Список кэшируемых областей ПУСТ");
                System.out.println("   (используется значение по умолчанию - пустой массив)");
            } else {
                System.out.println("Найдены кэшируемые области:");
                for (int i = 0; i < cacheAreas.length; i++) {
                    System.out.println("   - " + cacheAreas[i]);
                }
                System.out.println("Всего областей: " + cacheAreas.length);
            }
        } else {
            System.out.println("Класс не содержит аннотацию @Cache");
        }

        System.out.println("\n" + "=".repeat(60));
    }
}