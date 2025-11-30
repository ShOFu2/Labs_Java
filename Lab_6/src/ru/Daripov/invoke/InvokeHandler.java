package ru.Daripov.invoke;

import java.lang.reflect.Method;

/**
 * Обработчик аннотации {@link Invoke} через Reflection API.
 * 
 * <p>Этот класс автоматически находит и выполняет все методы, помеченные
 * аннотацией {@code @Invoke} в переданном объекте.
 * 
 * <p><b>Особенности работы:</b>
 * <ul>
 *   <li>Обрабатывает методы с любым модификатором доступа (включая private)</li>
 *   <li>Поддерживает методы с параметрами (использует тестовые значения)</li>
 *   <li>Работает со статическими методами</li>
 *   <li>Обрабатывает наследование</li>
 * </ul>
 * 
 * <p><b>Пример использования:</b>
 * <pre>
 * {@code
 * MyClass obj = new MyClass();
 * InvokeHandler.processAnnotations(obj);
 * }
 * </pre>
 * 
 * @author Дарипов Александр
 * @see Invoke
 */

public class InvokeHandler {
    /**
     * Автоматически вызывает все методы, помеченные аннотацией {@link Invoke}.
     * 
     * @param object объект, методы которого нужно обработать
     * @throws SecurityException если нет доступа к методам через Reflection
     */
    public static void processAnnotations(Object object) {
        System.out.println("\nОБРАБОТКА АНОТАЦИЙ @Invoke ДЛЯ КЛАССА: " + 
                          object.getClass().getSimpleName());
        
        // Получаем класс объекта
        Class<?> clazz = object.getClass();
        
        // Получаем все методы класса (включая приватные)
        Method[] methods = clazz.getDeclaredMethods();
        
        int invokedCount = 0;
        
        // Перебираем все методы
        for (Method method : methods) {
            // Проверяем, есть ли у метода аннотация @Invoke
            if (method.isAnnotationPresent(Invoke.class)) {
                System.out.println("\nНайден аннотированный метод: " + method.getName());
                
                try {
                    // Делаем приватные методы доступными
                    method.setAccessible(true);
                    
                    // Вызываем метод в зависимости от его типа
                    if (method.getParameterCount() == 0) {
                        // Метод без параметров
                        method.invoke(object);
                    } else {
                        // Метод с параметрами - передаем тестовые значения
                        Class<?>[] paramTypes = method.getParameterTypes();
                        Object[] params = generateTestParameters(paramTypes);
                        System.out.println("    Параметры: " + java.util.Arrays.toString(params));
                        method.invoke(object, params);
                    }
                    
                    invokedCount++;
                    System.out.println("   Метод успешно вызван");
                    
                } catch (Exception e) {
                    System.out.println("    Ошибка при вызове метода: " + e.getMessage());
                }
            }
        }
        
        System.out.println("\nИТОГО: вызвано " + invokedCount + " аннотированных методов");
    }
    
    /**
     * Генерирует тестовые параметры для методов с параметрами.
     * 
     * @param paramTypes массив классов, представляющих типы параметров
     * @return массив тестовых значений соответствующих типов
     */
    private static Object[] generateTestParameters(Class<?>[] paramTypes) {
        Object[] params = new Object[paramTypes.length];
        
        for (int i = 0; i < paramTypes.length; i++) {
            if (paramTypes[i] == String.class) {
                params[i] = "Тестовое сообщение " + (i + 1) + " ";
            } else if (paramTypes[i] == int.class || paramTypes[i] == Integer.class) {
                params[i] = (i + 1) * 2;
            } else if (paramTypes[i] == double.class || paramTypes[i] == Double.class) {
                params[i] = (i + 1) * 1.5;
            } else if (paramTypes[i] == boolean.class || paramTypes[i] == Boolean.class) {
                params[i] = true;
            } else {
                params[i] = null; // Для неизвестных типов
            }
        }
        
        return params;
    }
    
    /**
     * Обрабатывает статические методы класса, помеченные аннотацией {@link Invoke}.
     * 
     * @param clazz класс, статические методы которого нужно обработать
     */
    public static void processStaticMethods(Class<?> clazz) {
        System.out.println("\nОбработка статических методов класса: " + clazz.getSimpleName());
        
        Method[] methods = clazz.getDeclaredMethods();
        int invokedCount = 0;
        
        for (Method method : methods) {
            if (method.isAnnotationPresent(Invoke.class) && 
                java.lang.reflect.Modifier.isStatic(method.getModifiers())) {
                
                System.out.println("\nНайден статический аннотированный метод: " + method.getName());
                
                try {
                    method.setAccessible(true);
                    method.invoke(null); // null для статических методов
                    invokedCount++;
                    System.out.println("   Статический метод успешно вызван");
                } catch (Exception e) {
                    System.out.println("   Ошибка при вызове статического метода: " + e.getMessage());
                }
            }
        }
        
        System.out.println("Вызвано статических методов: " + invokedCount);
    }
}
