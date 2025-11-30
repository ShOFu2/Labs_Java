package ru.Daripov.utils;
import java.util.Scanner;

/**
 * Утилитный класс для валидации и обработки пользовательского ввода.
 * 
 * <p>Класс предоставляет статические методы для безопасного чтения и проверки
 * пользовательского ввода различных типов данных. Все методы обрабатывают
 * возможные ошибки ввода и запрашивают повторный ввод до получения корректных данных.
 * 
 * <p><b>Основные возможности:</b>
 * <ul>
 *   <li>Чтение целых чисел с валидацией</li>
 *   <li>Чтение положительных целых чисел</li>
 *   <li>Чтение нескольких чисел из одной строки</li>
 *   <li>Чтение вещественных чисел</li>
 *   <li>Обработка всех распространенных ошибок ввода</li>
 * </ul>
 * 
 * <p><b>Пример использования:</b>
 * <pre>
 * {@code
 * int age = CheckInput.checkPositive("Введите возраст: ");
 * int[] coordinates = CheckInput.readNumbers("Введите координаты x y: ", 2);
 * }
 * </pre>
 * 
 * @author Дарипов Александр
 * @see Scanner
 */
public class CheckInput {
    /** Статический Scanner для чтения ввода из консоли */
    private final static Scanner in = new Scanner(System.in);

    /**
     * Проверяет ввод пользователя и возвращает целое положительное число.
     * 
     * <p>Метод запрашивает ввод до тех пор, пока пользователь не введет
     * корректное целое положительное число (больше нуля).
     * 
     * <p><b>Обрабатываемые ошибки:</b>
     * <ul>
     *   <li>Нечисловой ввод</li>
     *   <li>Отрицательные числа и ноль</li>
     *   <li>Пустой ввод</li>
     * </ul>
     * 
     * @param prompt приглашение для ввода, отображаемое пользователю
     * @return целое положительное число, введенное пользователем
     * 
     * @throws SecurityException если возникает ошибка безопасности при работе с Scanner
     * 
     * @example
     * <pre>
     * {@code
     * int count = CheckInput.checkPositive("Введите количество элементов: ");
     * // Пользователь вводит: "-5" -> "abc" -> "0" -> "10"
     * // Результат: count = 10
     * }
     * </pre>
     * 
     * @see #readNumbers(String, int)
     */
    public static int checkPositive(String prompt) {
        while(true) {
            int[] x = readNumbers(prompt, 1);
            if (x[0] < 0) {
                System.out.println("Ошибка: число должно быть больше нуля");
                continue;
            }
            return x[0];
        }
    }

    /**
     * Проверяет ввод пользователя и возвращает целое число.
     * 
     * <p>Метод запрашивает ввод до тех пор, пока пользователь не введет
     * корректное целое число (может быть отрицательным).
     * 
     * @param prompt приглашение для ввода, отображаемое пользователю
     * @return целое число, введенное пользователем
     * 
     * @example
     * <pre>
     * {@code
     * int temperature = CheckInput.checkInt("Введите температуру: ");
     * // Пользователь вводит: "abc" -> "25.5" -> "-15"
     * // Результат: temperature = -15
     * }
     * </pre>
     * 
     * @see #readNumbers(String, int)
     */
    public static int checkInt(String prompt) {
        return readNumbers(prompt, 1)[0];
    }

    /**
     * Читает и проверяет ввод нескольких целых чисел из одной строки.
     * 
     * <p>Метод ожидает ввод указанного количества целых чисел, разделенных пробелами.
     * Проверяет корректность формата и значений всех чисел.
     * 
     * <p><b>Особенности работы:</b>
     * <ul>
     *   <li>Разделитель - один или несколько пробелов</li>
     *   <li>Проверяет количество введенных чисел</li>
     *   <li>Обрабатывает все возможные ошибки парсинга</li>
     *   <li>Автоматически запрашивает повторный ввод при ошибках</li>
     * </ul>
     * 
     * @param prompt приглашение для ввода, отображаемое пользователю
     * @param expectedCount ожидаемое количество чисел для ввода
     * @return массив целых чисел, введенных пользователем
     * 
     * @throws IllegalArgumentException если expectedCount меньше 1
     * 
     * @example
     * <pre>
     * {@code
     * int[] coords = CheckInput.readNumbers("Введите x y z: ", 3);
     * // Пользователь вводит: "10 20 abc" -> "10 20 30"
     * // Результат: coords = [10, 20, 30]
     * }
     * </pre>
     * 
     * @see Scanner#nextLine()
     * @see Integer#parseInt(String)
     */
    public static int[] readNumbers(String prompt, int expectedCount) {
        if (expectedCount < 1) {
            throw new IllegalArgumentException("expectedCount должен быть больше 0");
        }
        
        while (true) {
            System.out.print(prompt);
            String input = in.nextLine();
            
            if (input.isEmpty()) {
                if (expectedCount != 1) {
                    System.out.println("Ошибка: введите " + expectedCount + " чисел через пробел");
                } else {
                    System.out.println("Ошибка: введите число");
                }
                continue;
            }
            
            String[] parts = input.split("\\s+");
            
            if (parts.length < expectedCount) {
                System.out.println("Ошибка: ожидается " + expectedCount + " чисел, получено " + parts.length);
                continue;
            }
            
            try {
                int[] numbers = new int[expectedCount];
                for (int i = 0; i < expectedCount; i++) {
                    numbers[i] = Integer.parseInt(parts[i]);
                }
                return numbers;
                
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите корректные целые числа");
            }
        }
    }

    /**
     * Читает и проверяет ввод нескольких вещественных чисел из одной строки.
     * 
     * <p>Метод ожидает ввод указанного количества вещественных чисел, разделенных пробелами.
     * Поддерживает как целые, так и дробные числа в формате с запятой.
     * 
     * @param prompt приглашение для ввода, отображаемое пользователю
     * @param expectedCount ожидаемое количество чисел для ввода
     * @return массив вещественных чисел, введенных пользователем
     * 
     * @throws IllegalArgumentException если expectedCount меньше 1
     * 
     * @example
     * <pre>
     * {@code
     * double[] values = CheckInput.readDoubles("Введите значения: ", 2);
     * // Пользователь вводит: "3,14 2,71"
     * // Результат: values = [3,14, 2,71]
     * }
     * </pre>
     * 
     * @see Double#parseDouble(String)
     */
    public static double[] readDoubles(String prompt, int expectedCount) {
        if (expectedCount < 1) {
            throw new IllegalArgumentException("expectedCount должен быть больше 0");
        }
        
        while (true) {
            System.out.print(prompt);
            String input = in.nextLine();
            
            if (input.isEmpty()) {
                System.out.println("Ошибка: введите " + expectedCount + " чисел через пробел");
                continue;
            }
            
            String[] parts = input.split("\\s+");
            
            if (parts.length < expectedCount) {
                System.out.println("Ошибка: ожидается " + expectedCount + " чисел, получено " + parts.length);
                continue;
            }
            
            try {
                double[] numbers = new double[expectedCount];
                for (int i = 0; i < expectedCount; i++) {
                    numbers[i] = Double.parseDouble(parts[i]);
                }
                return numbers;
                
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите корректные целые числа");
            }
        }
    }
}