package ru.Daripov.main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import ru.Daripov.geometry.*;
import ru.Daripov.storage.*;
import static ru.Daripov.storage.Storage.*;
import static ru.Daripov.utils.CheckInput.*;
import static ru.Daripov.utils.GenericApply.*;
import static ru.Daripov.utils.GenericCollection.*;
import static ru.Daripov.utils.GenericFilter.*;
import static ru.Daripov.utils.GenericReduce.*;
import static ru.Daripov.utils.LineUtils.*;

public class Main {
    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(System.in)) {
            boolean running = true;
            
            
            while (running) {
                System.out.println("=== МЕНЮ ПРОГРАММЫ ===");
                System.out.println("1. Задание 1.2 - Без null");
                System.out.println("2. Задание 1.5 - Обобщенная линия");
                System.out.println("3. Задание 2.1 - Сдвинуть линию");
                System.out.println("4. Задание 3.1 - Функция");
                System.out.println("5. Задание 3.2 - Фильтр");
                System.out.println("6. Задание 3.3 - Сокращение");
                System.out.println("7. Задание 3.4 - Коллекционирование");
                System.out.println("0. Выход из программы");
                System.out.println("======================");
                
                int choice = checkInt("Выберите задание (0-7): ");
                
                switch (choice) {
                    case 0:
                        System.out.println("Завершение работы программы...");
                        running = false;
                        break;
                    case 1:
                        System.out.println("Задание 1.2");
                        System.out.println("=== Демонстрация работы Хранилища ===\n");
        
                        // 1. Хранилище чисел с null (альтернатива = 0)
                        System.out.println("1. Хранилище чисел (null -> 0):");
                        Storage<Integer> numberStorage1 = new Storage<>(null, 0);
                        System.out.println("Создано: " + numberStorage1);
                        printStorage(numberStorage1);
                        System.out.println("Нажмите Enter для продолжения...");
                        in.nextLine();
                        
                        // 2. Хранилище чисел с 99 (альтернатива = -1)
                        System.out.println("2. Хранилище чисел (99 -> 99):");
                        Storage<Integer> numberStorage2 = new Storage<>(99, -1);
                        System.out.println("Создано: " + numberStorage2);
                        printStorage(numberStorage2);
                        System.out.println("Нажмите Enter для продолжения...");
                        in.nextLine();
                        
                        // 3. Хранилище строк с null (альтернатива = "default")
                        System.out.println("3. Хранилище строк (null -> 'default'):");
                        Storage<String> stringStorage1 = new Storage<>(null, "default");
                        System.out.println("Создано: " + stringStorage1);
                        printStorage(stringStorage1);
                        System.out.println("Нажмите Enter для продолжения...");
                        in.nextLine();
                        
                        // 4. Хранилище строк с "hello" (альтернатива = "hello world")
                        System.out.println("4. Хранилище строк ('hello' -> 'hello'):");
                        Storage<String> stringStorage2 = new Storage<>("hello", "hello world");
                        System.out.println("Создано: " + stringStorage2);
                        printStorage(stringStorage2);    
                        break;

                    case 2:
                        System.out.println("Задание 1.5");
                        System.out.println("=== Демонстрация работы обобщенной Line ===\n");

                        int[] s3DCoords = readNumbers("Введите x, y, z начала линии (через пробел): ", 3);
                        PointZ start3D = new PointZ(s3DCoords[0], s3DCoords[1], s3DCoords[2]);
                        int[] e3DCoords = readNumbers("Введите x, y, z конца линии (через пробел): ", 3);
                        PointZ end3D = new PointZ(e3DCoords[0], e3DCoords[1], e3DCoords[2]);
                        Line<PointZ> line3D = new Line<>(start3D, end3D);
                        
                        System.out.println("Линия: " + line3D);
                        System.out.println("Тип точек: " + line3D.getPointType());
                        System.out.println("Длина в 3D: " + line3D.getLength());
                        break;
                    
                    case 3:
                        System.out.println("Задание 2.1");
                        System.out.println("=== Демонстрация сдвига линии по оси X ===\n");

                        System.out.println("1. Сдвиг 2D линии:");
                        int[] line1Cooords = readNumbers("Введите XY начала и XY конца линии (через пробел): ", 4);
                        Point start2D = new Point(line1Cooords[0], line1Cooords[1]);
                        Point end2D = new Point(line1Cooords[2], line1Cooords[3]);
                        Line<Point> line1 = new Line<>(start2D, end2D);
                        
                        System.out.println("До сдвига: " + line1);
                        shiftStartX(line1);
                        System.out.println("После сдвига начала по X: " + line1);
                        System.out.println();
                        
                        System.out.println("2. Сдвиг 3D линии:");
                        int[] line2Cooords = readNumbers("Введите XYZ начала и XYZ конца линии (через пробел): ", 6);
                        start3D = new PointZ(line2Cooords[0], line2Cooords[1], line2Cooords[2]);
                        end3D = new PointZ(line2Cooords[3], line2Cooords[4], line2Cooords[5]);
                        Line<Point> line2 = new Line<>(start3D, end3D);
                        
                        System.out.println("До сдвига: " + line2);
                        shiftStartX(line2);
                        System.out.println("После сдвига начала по X: " + line2);
                        break;
                    
                    case 4:
                        System.out.println("Задание 3.1");
                        System.out.println("=== Демонстрация обобщенных методов с автовыводом типов ===\n");

                        System.out.println("1. Строки -> Длины строк:");
                        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
                        System.out.println("Исходный список: " + strings);
                        
                        List<Integer> stringLengths = applyToList(strings, s -> s.length());
                        System.out.println("Результат (длины): " + stringLengths);
                        System.out.println("Нажмите Enter для продолжения...");
                        in.nextLine();

                        System.out.println("2. Числа -> Абсолютные значения:");
                        List<Integer> numbers = Arrays.asList(1, -3, 7);
                        System.out.println("Исходный список: " + numbers);
                        
                        List<Integer> absoluteValues = applyToList(numbers, a -> Math.abs(a));
                        System.out.println("Результат (модули): " + absoluteValues);
                        System.out.println("Нажмите Enter для продолжения...");
                        in.nextLine();

                        System.out.println("3. Массивы -> Максимальные значения:");
                        List<int[]> arrays = new ArrayList<>();
                        int arrayCount = checkPositive("Сколько массивов создать?: "); 
                        for (int i = 0; i < arrayCount; i++) {
                            int N = checkPositive("Введите размер " + (i + 1) + "-го массива: ");
                            int[] arr = readNumbers("Введите значения " + (i + 1) + "-го массива: ", N);
                            arrays.add(arr);
                        }

                        System.out.println("Исходные массивы:");
                        for (int[] arr : arrays) {
                            System.out.println("  " + Arrays.toString(arr));
                        }
                        
                        List<Integer> maxValues = applyToList(arrays, arr -> {
                            int max = arr[0];
                            for (int i = 1; i < arr.length; i++) {
                                if (arr[i] > max) {
                                    max = arr[i];
                                }
                            }
                            return max;
                        });

                        System.out.println("Максимальные значения: " + maxValues);
                        break;
                        
                    case 5:
                        System.out.println("Задание 3.2");
                        System.out.println("=== Демонстрация фильтрации списков ===\n");

                        System.out.println("1. Фильтрация строк (длина >= 3):");
                        strings = Arrays.asList("qwerty", "asdfg", "zx");
                        System.out.println("Исходный список: " + strings);
                        
                        List<String> filteredStrings = filter(strings, s -> s.length() >= 3);
                        System.out.println("После фильтрации: " + filteredStrings);
                        System.out.println("Нажмите Enter для продолжения...");
                        in.nextLine();

                        System.out.println("2. Фильтрация чисел (положительные):");
                        numbers = Arrays.asList(1, -3, 7);
                        System.out.println("Исходный список: " + numbers);
                        
                        List<Integer> positiveNumbers = filter(numbers, n -> n > 0);
                        System.out.println("Только положительные: " + positiveNumbers);
                        
                        List<Integer> negativeNumbers = filter(numbers, n -> n < 0);
                        System.out.println("Только отрицательные: " + negativeNumbers);
                        System.out.println("Нажмите Enter для продолжения...");
                        in.nextLine();

                        System.out.println("3. Фильтрация массивов (без положительных элементов):");
                        arrays = new ArrayList<>();
                        arrayCount = checkPositive("Сколько массивов создать?: "); 
                        for (int i = 0; i < arrayCount; i++) {
                            int N = checkPositive("Введите размер " + (i + 1) + "-го массива: ");
                            int[] arr = readNumbers("Введите значения " + (i + 1) + "-го массива: ", N);
                            arrays.add(arr);
                        }
                        
                        System.out.println("Исходные массивы:");
                        for (int[] arr : arrays) {
                            System.out.println(Arrays.toString(arr));
                        }
                        
                        List<int[]> negativeArrays = filter(arrays, arr -> {
                            for (int num : arr) {
                                if (num > 0) {
                                    return false;
                                }
                            }
                            return true;
                        });
                        
                        System.out.println("Массивы без положительных элементов:");
                        for (int[] arr : negativeArrays) {
                            System.out.println(Arrays.toString(arr));
                        }
                        break;

                    case 6:
                        System.out.println("Задание 3.3");
                        System.out.println("=== Демонстрация сокращения списков ===\n");

                        System.out.println("1. Сокращение строк:");
                        strings = List.of("qwerty", "asdfg", "zx");
                        System.out.println("Исходный список: " + strings);
                        
                        String concatenated = reduce(strings, "", (s1, s2) -> s1 + s2);
                        System.out.println("Результат сокращения: '" + concatenated + "'");
                        System.out.println("Нажмите Enter для продолжения...");
                        in.nextLine();

                        System.out.println("2. Сумма чисел:");
                        numbers = List.of(1, -3, 7);
                        System.out.println("Исходный список: " + numbers);
                        
                        Integer sum = reduce(numbers, 0, (a, b) -> a + b);
                        System.out.println("Сумма: " + sum);
                        System.out.println("Нажмите Enter для продолжения...");
                        in.nextLine();

                        System.out.println("3. Общее количество элементов во вложенных списках:");

                        List<List<Integer>> listOfLists = new ArrayList<>();
                        int listCount = checkPositive("Сколько списков создать?: "); 

                        for (int i = 0; i < listCount; i++) {
                            int N = checkPositive("Введите размер " + (i + 1) + "-го списка: ");
                            int[] arr = readNumbers("Введите значения " + (i + 1) + "-го списка: ", N);

                            List<Integer> list = new ArrayList<>();
                            for(int j : arr) {
                                list.add(j);
                            }
                            
                            listOfLists.add(list);
                        }
                        
                        System.out.println("Исходный список списков: " + listOfLists);
                        
                        List<Integer> sizes = new ArrayList<>();
                        for (List<Integer> list : listOfLists) {
                            sizes.add(list.size());
                        }

                        Integer totalCount = reduce(sizes, 0, (acc, size) -> acc + size);
                        System.out.println("Общее количество элементов: " + totalCount);
                        System.out.println("Нажмите Enter для продолжения...");
                        in.nextLine();

                        System.out.println("4. Работа с пустыми списками:");
                        
                        List<String> emptyStrings = List.of();
                        List<Integer> emptyNumbers = List.of();
                        List<List<Integer>> emptyListOfLists = List.of();
                        
                        String emptyConcat = reduce(emptyStrings, "DEFAULT", (acc, s) -> acc + s);
                        System.out.println("Сокращение пустого списка строк: '" + emptyConcat + "'");
                        
                        Integer emptySum = reduce(emptyNumbers, 0, Integer::sum);
                        System.out.println("Сумма пустого списка чисел: " + emptySum);
                        
                        sizes = new ArrayList<>();
                        for (List<Integer> list : emptyListOfLists) {
                            sizes.add(list.size());
                        }
                        Integer emptyCount = reduce(sizes, -1, (acc, size) -> acc + size);
                        System.out.println("Количество в пустом списке списков: " + emptyCount);
                        System.out.println("Нажмите Enter для продолжения...");
                        in.nextLine();

                        System.out.println("5. Работа со списком содержащим null:");
                        List<String> stringsWithNull = Arrays.asList("hello", null, "world", null);
                        System.out.println("Список с null: " + stringsWithNull);
                        
                        String concatWithNull = reduce(stringsWithNull, "", 
                            (acc, s) -> s != null ? acc + s : acc
                        );
                        System.out.println("Сокращение (null пропущены): '" + concatWithNull + "'");
                        
                        String concatWithNullMarked = reduce(stringsWithNull, "", 
                            (acc, s) -> acc + (s != null ? s : "NULL")
                        );
                        System.out.println("Сокращение (null отмечены): '" + concatWithNullMarked + "'");
                        break;

                    case 7:
                        System.out.println("Задание 3.4");
                        System.out.println("=== Демонстрация универсального преобразования ===\n");

                        System.out.println("1. Разделение чисел на положительные и отрицательные:");
                        numbers = List.of(1, -3, 7);
                        System.out.println("Исходный список: " + numbers);

                        class NumberGroups {
                            List<Integer> positive = new ArrayList<>();
                            List<Integer> negative = new ArrayList<>();
                        }

                        NumberGroups numGroups = transform(
                            numbers,
                            NumberGroups::new,
                            (container, num) -> {
                                if (num > 0) container.positive.add(num);
                                else if (num < 0) container.negative.add(num);
                            }
                        );

                        System.out.println("Положительные: " + numGroups.positive);
                        System.out.println("Отрицательные: " + numGroups.negative);
                        System.out.println("Нажмите Enter для продолжения...");
                        in.nextLine();

                        System.out.println("2. Группировка строк по длине:");
                        strings = List.of("qwerty", "asdfg", "zx", "qw");
                        System.out.println("Исходный список: " + strings);

                        List<List<String>> stringGroups = transform(
                        strings,
                        ArrayList::new,
                        (strGroups, str) -> {
                            boolean found = false;
                            for (List<String> group : strGroups) {
                                if (!group.isEmpty() && group.get(0).length() == str.length()) {
                                    group.add(str);
                                    found = true;
                                    break;
                                }
                            }
                            if (!found) {
                                List<String> newGroup = new ArrayList<>();
                                newGroup.add(str);
                                strGroups.add(newGroup);
                            }
                        });

                        System.out.println("Группы по длине:");
                        for (List<String> group : stringGroups) {
                            if (!group.isEmpty()) {
                                System.out.println("  Длина " + group.get(0).length() + ": " + group);
                            }
                        }
                        System.out.println("Нажмите Enter для продолжения...");
                        in.nextLine();

                        System.out.println("3. Удаление дубликатов:");
                        List<String> stringsWithDuplicates = List.of("qwerty", "asdfg", "qwerty", "qw");
                        System.out.println("Исходный список: " + stringsWithDuplicates);

                        List<String> uniqueStrings = transform(
                        stringsWithDuplicates,
                        ArrayList::new,
                        (result, str) -> {
                            if (!result.contains(str)) {
                                result.add(str);
                            }
                        });

                        System.out.println("Уникальные строки: " + uniqueStrings);
                        break;

                    default:
                        System.out.println("Ошибка! Выберите число от 0 до 7.");
                        break;
                }
                
                if (running && choice    != 0) {
                    System.out.println("\nНажмите Enter для продолжения...");
                    in.nextLine(); // Очищение буфера
                    in.nextLine(); // Ожидание нажатия Enter
                }
            }
        }
        System.out.println("Программа завершена.");
    }
}
