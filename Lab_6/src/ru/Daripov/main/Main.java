package ru.Daripov.main;

import java.util.Scanner;
import ru.Daripov.cache.CacheHandler;
import ru.Daripov.cache.ProductService;
import ru.Daripov.cache.SimpleService;
import ru.Daripov.cache.UserService;
import ru.Daripov.defaults.DefaultHandler;
import ru.Daripov.defaults.FieldDefaultClass;
import ru.Daripov.defaults.StringDefaultClass;
import ru.Daripov.invoke.InvokeClass;
import ru.Daripov.invoke.InvokeHandler;
import ru.Daripov.tostring.Mode;
import ru.Daripov.tostring.Person;
import ru.Daripov.tostring.Product;
import ru.Daripov.tostring.ToString;
import ru.Daripov.tostring.ToStringHandler;
import ru.Daripov.two.ApplicationSettings;
import ru.Daripov.two.DatabaseConfig;
import ru.Daripov.two.TwoHandler;
import static ru.Daripov.utils.CheckInput.*;
import ru.Daripov.validate.ValidateProcessor;

/**
 * Главный класс проекта с интерактивным меню для демонстрации работы с аннотациями.
 * 
 * <p><b>Доступные задания:</b>
 * <ul>
 *   <li><b>Задание 1.1 - Аннотация @Invoke</b> - автоматический вызов методов через Reflection API</li>
 *   <li><b>Задание 1.2 - Аннотация @Default</b> - установка типов по умолчанию для классов и полей</li>
 *   <li><b>Задание 1.3 - Аннотация @ToString</b> - автоматическая генерация метода toString() с настройкой включения/исключения полей</li>
 *   <li><b>Задание 1.4 - Аннотация @Validate</b> - указание типов для валидации объектов</li>
 *   <li><b>Задание 1.5 - Аннотация @Two</b> - работа с двумя обязательными свойствами разных типов</li>
 *   <li><b>Задание 1.6 - Аннотация @Cache</b> - кэширование результатов методов</li>
 * </ul>
 * 
 * <p><b>Технологии:</b>
 * <ul>
 *   <li>Java Annotations - создание и обработка пользовательских аннотаций</li>
 *   <li>Reflection API - анализ и вызов методов во время выполнения</li>
 *   <li>Интерактивное консольное меню - удобный пользовательский интерфейс</li>
 * </ul>
 * 
 * <p><b>Реализованные аннотации:</b>
 * <ul>
 *   <li><b>@Invoke</b> - автоматический вызов методов через Reflection API</li>
 *   <li><b>@Default</b> - указание типов по умолчанию для классов и полей</li>
 *   <li><b>@ToString</b> - автоматическая генерация toString() с настройкой полей</li>
 *   <li><b>@Validate</b> - указание типов для валидации объектов</li>
 *   <li><b>@Two</b> - работа с двумя обязательными свойствами разных типов</li>
 * </ul>
 * 
 * @author Дарипов Александр
 * @see ru.Daripov.invoke.Invoke
 * @see ru.Daripov.invoke.InvokeHandler
 * @see ru.Daripov.defaults.DefaultHandler
 * @see ru.Daripov.tostring.ToStringHandler
 * @see ru.Daripov.validate.ValidateProcessor
 * @see ru.Daripov.two.TwoHandler
 */
public class Main {
    
    /**
     * Точка входа в программу. Запускает интерактивное меню для выбора заданий.
     * 
     * <p>Программа демонстрирует различные аспекты работы с аннотациями в Java:
     * <ul>
     *   <li>Создание пользовательских аннотаций</li>
     *   <li>Обработку аннотаций через Reflection API</li>
     *   <li>Практическое применение аннотаций для решения задач</li>
     *   <li>Тестирование функциональности аннотаций с помощью JUnit</li>
     * </ul>
     * 
     * <p><b>Структура программы:</b>
     * <ol>
     *   <li>Задания 1.1-1.6 - реализация различных пользовательских аннотаций</li>
     * </ol>
     * 
     * @param args аргументы командной строки (не используются)
     * @throws Exception может выбрасывать исключения при работе с Reflection API
     */
    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(System.in, "Cp866")) {
            boolean running = true;
            
            while (running) {
                System.out.println("=== МЕНЮ ПРОГРАММЫ ===");
                System.out.println("1. Задание 1.1 - Invoke");
                System.out.println("2. Задание 1.2 - Default");
                System.out.println("3. Задание 1.3 - ToString");
                System.out.println("4. Задание 1.4 - Validate");
                System.out.println("5. Задание 1.5 - Two");
                System.out.println("6. Задание 1.6 - Cache");
                System.out.println("7. Задание 2.1 - JUnit @ToString");
                System.out.println("8. Задание 2.7 - JUnit @Cache и @Invoke");
                System.out.println("0. Выход из программы");
                System.out.println("======================");
                
                int choice = checkInt("Выберите задание (0-8): ");
                
                switch (choice) {
                    case 0:
                        System.out.println("Завершение работы программы...");
                        running = false;
                        break;
                    
                    case 1:
                        demonstrateInvokeAnnotation();
                        break;
                    
                    case 2:
                        demonstrateDefaultAnnotation();
                        break;
                    
                    case 3:
                        demonstrateToStringAnnotation();
                        break;
                    
                    case 4:
                        demonstrateValidateAnnotation();
                        break;
                    
                    case 5:
                        demonstrateTwoAnnotation();
                        break;
                    
                    case 6:
                        demonstrateCacheAnnotation();
                        break;
                    
                    case 7:
                        demonstrateJUnitToString();
                        break;
                    
                    case 8:
                        demonstrateJUnitCacheAndInvoke();
                        break;
                    
                    default:
                        System.out.println("Ошибка! Выберите число от 0 до 8.");
                        break;
                }
                        
                if (running && choice != 0) {
                    System.out.println("\nНажмите Enter для продолжения...");
                    in.nextLine(); // Очищение буфера
                    in.nextLine(); // Ожидание нажатия Enter
                }
            }
        }
        System.out.println("Программа завершена.");
    }
    
    /**
     * Демонстрирует работу аннотации {@link ru.Daripov.invoke.Invoke} - задание 1.1.
     * 
     * <p>Показывает автоматический вызов методов, помеченных аннотацией @Invoke,
     * с использованием Reflection API. Включает обработку:
     * <ul>
     *   <li>Публичных и приватных методов</li>
     *   <li>Статических методов</li>
     *   <li>Методов с параметрами</li>
     *   <li>Различных модификаторов доступа</li>
     * </ul>
     * 
     * @see InvokeHandler#processAnnotations(Object)
     * @see InvokeClass
     */
    private static void demonstrateInvokeAnnotation() {
        System.out.println("Задание 1.1 - Аннотация @Invoke");
        System.out.println("ДЕМОНСТРАЦИЯ АННОТАЦИИ @Invoke");
        System.out.println("=" .repeat(60));
        
        // Создаем экземпляр класса с аннотированными методами
        InvokeClass demoObject = new InvokeClass("DemoClass");
        
        System.out.println("\n АВТОМАТИЧЕСКИЙ ВЫЗОВ АННОТИРОВАННЫХ МЕТОДОВ:");

        
        // Автоматически вызываем все методы с аннотацией @Invoke
        InvokeHandler.processAnnotations(demoObject);
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("ДЕМОНСТРАЦИЯ ЗАВЕРШЕНА");
        System.out.println("=".repeat(60));
    }
    
    /**
     * Демонстрирует работу аннотации {@link ru.Daripov.defaults.Default} - задание 1.2.
     * 
     * <p>Показывает установку типов по умолчанию для классов и полей
     * с использованием пользовательской аннотации @Default.
     * 
     * <p><b>Характеристики аннотации:</b>
     * <ul>
     *   <li>Цель: тип (класс) или поле</li>
     *   <li>Доступ: во время выполнения</li>
     *   <li>Обязательное свойство value типа Class</li>
     * </ul>
     * 
     * <p><b>Демонстрируемые сценарии:</b>
     * <ul>
     *   <li>Анализ аннотаций на уровне класса</li>
     *   <li>Анализ аннотаций на уровне полей</li>
     *   <li>Создание экземпляров по умолчанию</li>
     *   <li>Валидация соответствия типов</li>
     * </ul>
     * 
     * @see DefaultHandler#analyzeClassCompletely(Class)
     * @see StringDefaultClass
     * @see FieldDefaultClass
     */
    private static void demonstrateDefaultAnnotation() {
        System.out.println("Задание 1.2 - Аннотация @Default");
        System.out.println("ДЕМОНСТРАЦИЯ АННОТАЦИИ @Default");
        System.out.println("=".repeat(60));
        
        // Демонстрация работы с классом, аннотированным на уровне типа
        System.out.println("\n1. АНАЛИЗ КЛАССА С АННОТАЦИЕЙ НА УРОВНЕ ТИПА:");
        DefaultHandler.analyzeClassCompletely(StringDefaultClass.class);
        
        // Демонстрация работы с классом, аннотированным на уровне полей
        System.out.println("\n2. АНАЛИЗ КЛАССА С АННОТАЦИЯМИ НА УРОВНЕ ПОЛЕЙ:");
        DefaultHandler.analyzeClassCompletely(FieldDefaultClass.class);
        
        // Демонстрация работы с обычным классом (без аннотаций)
        System.out.println("\n3. АНАЛИЗ ОБЫЧНОГО КЛАССА (БЕЗ АННОТАЦИЙ):");
        DefaultHandler.analyzeClassCompletely(Object.class);
        
        System.out.println("ДЕМОНСТРАЦИЯ ЗАВЕРШЕНА");
        System.out.println("=".repeat(60));
    }
    
    /**
     * Демонстрирует работу аннотации {@link ru.Daripov.tostring.ToString} - задание 1.3.
     * 
     * <p>Показывает автоматическую генерацию строкового представления объектов
     * с использованием пользовательской аннотации @ToString. Демонстрирует:
     * <ul>
     *   <li>Настройку включения/исключения полей через аннотации</li>
     *   <li>Работу аннотации на уровне класса и полей</li>
     *   <li>Форматирование различных типов данных</li>
     *   <li>Сравнение с стандартным методом toString()</li>
     * </ul>
     * 
     * <p><b>Характеристики аннотации:</b>
     * <ul>
     *   <li>Цель: тип (класс) или поле</li>
     *   <li>Доступ: во время выполнения</li>
     *   <li>Свойство value с вариантами YES/NO (по умолчанию YES)</li>
     * </ul>
     * 
     * <p><b>Демонстрируемые сценарии:</b>
     * <ul>
     *   <li>Генерация строкового представления объектов Person и Product</li>
     *   <li>Исключение конфиденциальных полей (пароли, секретные ключи)</li>
     *   <li>Анализ аннотаций в классах</li>
     *   <li>Сравнение с стандартной реализацией toString()</li>
     * </ul>
     * 
     * @see ToStringHandler#toString(Object)
     * @see Person
     * @see Product
     * @see Mode
     */
    private static void demonstrateToStringAnnotation() {
        System.out.println("Задание 1.3 - Аннотация @ToString");
        System.out.println("ДЕМОНСТРАЦИЯ АННОТАЦИИ @ToString");
        System.out.println("=".repeat(60));
        
        // Демонстрация работы с классом Person
        System.out.println("\n1. КЛАСС PERSON:");
        Person person = new Person("Иван Петров", 30, "ivan@mail.com", "secret123", "key789");
        
        ToStringHandler.analyzeToStringAnnotations(Person.class);
        System.out.println("\n   Результат toString():");
        System.out.println("   " + ToStringHandler.toString(person));
        
        // Демонстрация работы с классом Product
        System.out.println("=".repeat(60));
        System.out.println("\n2. КЛАСС PRODUCT:");
        Product product = new Product("Ноутбук", 999.99, 5, true, "INT-LAPTOP-001", "cache_data");
        
        ToStringHandler.analyzeToStringAnnotations(Product.class);
        System.out.println("\n   Результат toString():");
        System.out.println("   " + ToStringHandler.toString(product));
        
        // Демонстрация с пустыми объектами
        System.out.println("\n3. ПУСТЫЕ ОБЪЕКТЫ:");
        Person emptyPerson = new Person();
        System.out.println("   Пустой Person: " + ToStringHandler.toString(emptyPerson));
        
        Product emptyProduct = new Product();
        System.out.println("   Пустой Product: " + ToStringHandler.toString(emptyProduct));
        
        System.out.println("=".repeat(60));
        System.out.println("ДЕМОНСТРАЦИЯ ЗАВЕРШЕНА");
        System.out.println("=".repeat(60));
    }
    
        /**
     * Демонстрирует работу аннотации {@link ru.Daripov.validate.Validate} - задание 1.4.
     * 
     * <p>Показывает указание типов для валидации объектов с использованием
     * пользовательской аннотации @Validate. Демонстрирует:
     * <ul>
     *   <li>Настройку списка классов для валидации</li>
     *   <li>Работу аннотации на уровне классов и аннотаций</li>
     *   <li>Извлечение информации о типах валидации через Reflection API</li>
     * </ul>
     * 
     * <p><b>Характеристики аннотации:</b>
     * <ul>
     *   <li>Цель: тип (класс) или аннотация ({@link java.lang.annotation.ElementType#TYPE}, 
     *        {@link java.lang.annotation.ElementType#ANNOTATION_TYPE})</li>
     *   <li>Доступ: во время выполнения ({@link java.lang.annotation.RetentionPolicy#RUNTIME})</li>
     *   <li>Свойства: обязательное свойство value типа Class[]</li>
     * </ul>
     * 
     * <p><b>Демонстрируемые сценарии:</b>
     * <ul>
     *   <li>Анализ аннотаций @Validate на уровне класса Product</li>
     *   <li>Извлечение списков классов валидации</li>
     *   <li>Проверка поддержки определенных типов валидации</li>
     *   <li>Работа с аннотациями на уровне аннотаций (ToString)</li>
     * </ul>
     * 
     * @see ValidateProcessor#analyzeAllValidations(Class)
     * @see ValidateProcessor#printValidationClasses(Class)
     * @see Product
     */
    private static void demonstrateValidateAnnotation() {
        System.out.println("Задание 1.4 - Аннотация @Validate");
        System.out.println("ДЕМОНСТРАЦИЯ АННОТАЦИИ @Validate");
        System.out.println("=".repeat(60));
        
        // Демонстрация работы с классом Product
        System.out.println("\n1. КЛАСС PRODUCT:");
        ValidateProcessor.analyzeAllValidations(Product.class);
        
        // Демонстрация работы с аннотацией Email
        System.out.println("\n2. АННОТАЦИЯ ToString:");
        ValidateProcessor.analyzeAllValidations(ToString.class);
        
        // Демонстрация работы с обычным классом (без аннотаций)
        System.out.println("\n3. ОБЫЧНЫЙ КЛАСС (БЕЗ @Validate):");
        ValidateProcessor.analyzeAllValidations(Object.class);
        
        System.out.println("ДЕМОНСТРАЦИЯ ЗАВЕРШЕНА");
        System.out.println("=".repeat(60));
    }
    
    /**
     * Демонстрирует работу аннотации {@link ru.Daripov.two.Two} - задание 1.5.
     * 
     * <p>Показывает работу с двумя обязательными свойствами разных типов
     * с использованием пользовательской аннотации @Two. Демонстрирует:
     * <ul>
     *   <li>Объявление аннотации с двумя свойствами разных типов</li>
     *   <li>Использование аннотации для хранения конфигурационных данных</li>
     *   <li>Извлечение значений свойств через Reflection API</li>
     * </ul>
     * 
     * <p><b>Характеристики аннотации:</b>
     * <ul>
     *   <li>Цель: тип (класс) ({@link java.lang.annotation.ElementType#TYPE})</li>
     *   <li>Доступ: во время выполнения ({@link java.lang.annotation.RetentionPolicy#RUNTIME})</li>
     *   <li>Свойства: два обязательных свойства first (String) и second (int)</li>
     * </ul>
     * 
     * <p><b>Демонстрируемые сценарии:</b>
     * <ul>
     *   <li>Конфигурация базы данных с названием и портом</li>
     *   <li>Настройки приложения с режимом работы и портом</li>
     *   <li>Сетевые параметры сервиса с описанием и приоритетом</li>
     * </ul>
     * 
     * @see TwoProcessor#analyzeClassCompletely(Class)
     * @see TwoProcessor#printTwoProperties(Class)
     * @see DatabaseConfig
     * @see ApplicationSettings
     */
    private static void demonstrateTwoAnnotation() {
        System.out.println("Задание 1.5 - Аннотация @Two");
        System.out.println("ДЕМОНСТРАЦИЯ АННОТАЦИИ @Two");
        System.out.println("=".repeat(60));
        
        // Демонстрация работы с классом DatabaseConfig
        System.out.println("\n1. КЛАСС DATABASECONFIG (НАСТРОЙКИ БАЗЫ ДАННЫХ):");
        TwoHandler.analyzeClassCompletely(DatabaseConfig.class);
        
        // Демонстрация работы с классом ApplicationSettings
        System.out.println("\n2. КЛАСС APPLICATIONSETTINGS (НАСТРОЙКИ ПРИЛОЖЕНИЯ):");
        TwoHandler.analyzeClassCompletely(ApplicationSettings.class);
        
        System.out.println("ДЕМОНСТРАЦИЯ ЗАВЕРШЕНА");
        System.out.println("=".repeat(60));
    }
    
    /**
     * Демонстрирует работу аннотации @Cache - задание 1.6.
     * 
     * <p>Показывает кэширование результатов методов,
     * помеченных аннотацией @Cache, для оптимизации производительности.
     */
    private static void demonstrateCacheAnnotation() {
        System.out.println("Задание 1.6 - Аннотация @Cache");
        System.out.println("ДЕМОНСТРАЦИЯ АННОТАЦИИ @Cache");
        System.out.println("=".repeat(60));
        
        // Демонстрация работы с классом UserService
        System.out.println("\n1. КЛАСС USERSERVICE (С НЕСКОЛЬКИМИ ОБЛАСТЯМИ):");
        CacheHandler.printCacheAreas(UserService.class);

        // Демонстрация работы с классом ProductService
        System.out.println("\n2. КЛАСС PRODUCTSERVICE (С РАЗЛИЧНЫМИ ОБЛАСТЯМИ):");
        CacheHandler.printCacheAreas(ProductService.class);
        
        // Демонстрация работы с классом SimpleService (без областей)
        System.out.println("\n3. КЛАСС SIMPLESERVICE (БЕЗ ОБЛАСТЕЙ КЭШИРОВАНИЯ):");
        CacheHandler.printCacheAreas(SimpleService.class);
        
        System.out.println("ДЕМОНСТРАЦИЯ ЗАВЕРШЕНА");
        System.out.println("=".repeat(60));
    }
    
    /**
     * Демонстрирует тестирование аннотации @ToString с помощью JUnit - задание 2.1.
     * 
     * <p>Показывает написание unit-тестов для проверки корректности работы
     * аннотации @ToString с использованием фреймворка JUnit.
     */
    private static void demonstrateJUnitToString() {
        System.out.println("Задание 2.1 - JUnit тестирование @ToString");
        System.out.println("Реализация в процессе...");
        // TODO: Реализовать JUnit тесты для аннотации @ToString
    }
    
    /**
     * Демонстрирует комплексное тестирование аннотаций @Cache и @Invoke с помощью JUnit - задание 2.7.
     * 
     * <p>Показывает написание интеграционных тестов для проверки взаимодействия
     * аннотаций @Cache и @Invoke с использованием фреймворка JUnit.
     */
    private static void demonstrateJUnitCacheAndInvoke() {
        System.out.println("Задание 2.7 - JUnit тестирование @Cache и @Invoke");
        System.out.println("Реализация в процессе...");
        // TODO: Реализовать JUnit тесты для аннотаций @Cache и @Invoke
    }
}