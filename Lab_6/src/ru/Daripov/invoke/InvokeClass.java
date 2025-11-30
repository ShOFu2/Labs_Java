package ru.Daripov.invoke;
/**
 * Класс, содержащий методы с аннотацией {@link Invoke} для демонстрации работы.
 * 
 * <p>Содержит различные типы методов для тестирования обработки аннотаций:
 * <ul>
 *   <li>Публичные методы с аннотацией и без</li>
 *   <li>Приватные аннотированные методы</li>
 *   <li>Статические аннотированные методы</li>
 *   <li>Методы с параметрами</li>
 * </ul>
 * 
 * @author Дарипов Александр
 * @see Invoke
 */
public class InvokeClass {
    /** 
     * Имя экземпляра класса для идентификации в выводе
     */
    private String name;
    
    /**
     * Конструктор класса InvokeClass.
     * 
     * @param name имя экземпляра класса для идентификации
     */
    public InvokeClass(String name) {
        this.name = name;
    }
    
     /**
     * Обычный метод без аннотации - не будет вызван автоматически.
     * 
     * <p>Этот метод демонстрирует различие между аннотированными
     * и неаннотированными методами.
     */
    public void normalMethod() {
        System.out.println("Обычный метод класса " + name);
    }
    
    /**
     * Метод с аннотацией {@link Invoke} - будет вызван автоматически.
     * 
     * <p>Этот метод демонстрирует базовый случай использования аннотации
     * для публичного метода без параметров.
     * 
     * @see Invoke
     */
    @Invoke
    public void annotatedMethod1() {
        System.out.println("ВЫЗВАН АННОТИРОВАННЫЙ МЕТОД 1 В КЛАССЕ " + name);
        System.out.println("   Выполняю полезную работу...");
    }
    
    /**
     * Второй метод с аннотацией {@link Invoke}.
     * 
     * <p>Демонстрирует возможность множественного использования
     * аннотации в одном классе.
     * 
     * @see Invoke
     */
    @Invoke
    public void annotatedMethod2() {
        System.out.println("ВЫЗВАН АННОТИРОВАННЫЙ МЕТОД 2 В КЛАССЕ " + name);
        System.out.println("   Делаю что-то важное...");
    }
    
    /**
     * Метод с параметрами, помеченный аннотацией {@link Invoke}.
     * 
     * <p>Демонстрирует обработку методов с параметрами через Reflection API.
     * Обработчик автоматически передаст тестовые значения для параметров.
     * 
     * @param message текстовое сообщение для обработки
     * @param number числовой параметр для повторения сообщения
     * @see InvokeHandler#generateTestParameters(Class[])
     */
    @Invoke
    public void annotatedMethodWithParams(String message, int number) {
        System.out.println("ВЫЗВАН АННОТИРОВАННЫЙ МЕТОД С ПАРАМЕТРАМИ");
        System.out.println("   Сообщение: " + message);
        System.out.println("   Число: " + number);
        System.out.println("   Результат: " + message.repeat(number));
    }
    
    /**
     * Приватный метод с аннотацией {@link Invoke}.
     * 
     * <p>Демонстрирует, что Reflection API может вызывать даже приватные методы,
     * если они помечены аннотацией {@code @Invoke}.
     * 
     * @see Invoke
     * @see java.lang.reflect.Method#setAccessible(boolean)
     */
    @Invoke
    private void privateAnnotatedMethod() {
        System.out.println("ВЫЗВАН ПРИВАТНЫЙ АННОТИРОВАННЫЙ МЕТОД");
        System.out.println("   Секретная операция выполнена!");
    }
    
    /**
     * Статический метод с аннотацией {@link Invoke}.
     * 
     * <p>Демонстрирует обработку статических методов. Для вызова статических
     * методов не требуется экземпляр класса.
     * 
     * @see Invoke
     * @see InvokeHandler#processStaticMethods(Class)
     */
    @Invoke
    public static void staticAnnotatedMethod() {
        System.out.println("ВЫЗВАН СТАТИЧЕСКИЙ АННОТИРОВАННЫЙ МЕТОД");
        System.out.println("   Статическая работа завершена!");
    }
    
    /**
     * Второй обычный метод без аннотации.
     * 
     * <p>Используется для демонстрации различия в обработке аннотированных
     * и неаннотированных методов.
     */
    public void anotherNormalMethod() {
        System.out.println("Еще один обычный метод");
    }
}
