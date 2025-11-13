package ru.Daripov.main;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import ru.Daripov.сat.*;
import static ru.Daripov.competition.CompetitionResults.*;
import ru.Daripov.competition.Participant;
import ru.Daripov.fraction.CacheFraction;
import ru.Daripov.geometry.*;
import ru.Daripov.interfaces.Funs;
import ru.Daripov.interfaces.Meowable;
import static ru.Daripov.utils.CheckInput.*;
import static ru.Daripov.utils.LetterCounter.*;
import static ru.Daripov.utils.MeowingCats.*;
import static ru.Daripov.utils.MirrorQueue.*;
import static ru.Daripov.utils.PersonStreamProcessor.*;
import static ru.Daripov.utils.PointStreamProcessor.*;
import static ru.Daripov.utils.SortedListMerger.*;

public class Main {
    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(System.in, "Cp866")) {
            boolean running = true;
            
            while (running) {
                System.out.println("=== МЕНЮ ПРОГРАММЫ ===");
                System.out.println("1. Задание 1.1 - Шаблоны");
                System.out.println("2. Задание 2.1 - Количество мяуканий");
                System.out.println("3. Задание 3.3 - Список");
                System.out.println("4. Задание 4.3 - Мап");
                System.out.println("5. Задание 5.7 - Сет");
                System.out.println("6. Задание 6.2 - Очередь");
                System.out.println("7. Задание 7.1 - Стрим 1");
                System.out.println("8. Задание 7.2 - Стрим 2");
                System.out.println("0. Выход из программы");
                System.out.println("======================");
                
                int choice = checkInt("Выберите задание (0-8): ");
                
                switch (choice) {
                    case 0:
                        System.out.println("Завершение работы программы...");
                        running = false;
                        break;
                    case 1:
                        System.out.println("Задание 1.1");
                        System.out.println("=== ДЕМОНСТРАЦИЯ РАБОТЫ КЛАССА ДРОБЬ ===\n");
        
                        System.out.println("1. СОЗДАНИЕ ДРОБЕЙ:");
                        int[] frac = readNumbers("Введите числитель "+
                        "и знаменатель 1-й дроби(через пробел): ", 2);
                        CacheFraction frac1 = new CacheFraction(frac[0], frac[1]);
                        frac = readNumbers("Введите числитель "+
                        "и знаменатель 2-й дроби(через пробел): ", 2);
                        CacheFraction frac2 = new CacheFraction(frac[0], frac[1]);
                        frac = readNumbers("Введите числитель "+
                        "и знаменатель 3-й дроби(через пробел): ", 2);
                        CacheFraction frac3 = new CacheFraction(frac[0],frac[1]);
                        
                        System.out.println("Дробь 1: " + frac1);
                        System.out.println("Дробь 2: " + frac2);
                        System.out.println("Дробь 3: " + frac3);
                        System.out.println("\nНажмите Enter для продолжения...");
                        in.nextLine();
                        
                        System.out.println("\n2. ИЗМЕНЕНИЕ ДРОБИ И СБРОС КЭША:");
                        System.out.println("Меняем дробь1 на 2/5:");
                        frac1.setValues(2, 5);
                        
                        System.out.println("Первое обращение после изменения:");
                        frac1.getRealValue();
                        System.out.println("Второе обращение после изменения:");
                        frac1.getRealValue();
                        System.out.println("\nНажмите Enter для продолжения...");
                        in.nextLine();
                        
                        System.out.println("\n3. СРАВНЕНИЕ ДРОБЕЙ:");
                        CacheFraction frac4 = new CacheFraction(1, 2);
                        CacheFraction frac5 = new CacheFraction(2, 4);
                        CacheFraction frac6 = new CacheFraction(1, 3);
                        
                        System.out.println("Дробь 1/2: " + frac4);
                        System.out.println("Дробь 2/4: " + frac5);
                        System.out.println("Дробь 1/3: " + frac6);
                        
                        System.out.println("1/2 equals 2/4: " + frac4.equals(frac5));
                        System.out.println("1/2 equals 1/3: " + frac4.equals(frac6));
                        break;
                    
                    case 2:
                        System.out.println("Задание 2.1");
                        System.out.println("=== ДЕМОНСТРАЦИЯ РАБОТЫ КЛАССА КОТ ===\n");
                        System.out.println("1. СОЗДАНИЕ КОТОВ:");
                        System.out.print("Введите имя 1-го кота: ");
                        String catName = in.nextLine();
                        Cat cat1 = new Cat(catName);
                        System.out.print("Введите имя 2-го кота: ");
                        catName = in.nextLine();
                        Cat cat2 = new Cat(catName);
                        System.out.print("Введите имя 3-го кота: ");
                        catName = in.nextLine();
                        Cat cat3 = new Cat(catName);
                        
                        System.out.println(cat1);
                        System.out.println(cat2);
                        System.out.println(cat3);
                        System.out.println("\nНажмите Enter для продолжения...");
                        in.nextLine();

                        System.out.println("2. МЯУКАНЬЕ ОТДЕЛЬНЫХ КОТОВ:");
                        cat1.meow();
                        cat2.meow();
                        cat3.meow();
                        System.out.println("\nНажмите Enter для продолжения...");
                        in.nextLine();

                        System.out.println("3. РАБОТА С ИНТЕРФЕЙСОМ МЯУКАНЬЕ:");
                        int numberOfCats = checkInt("Введите кол-во котов: ");
                        Meowable[] meowings = new Meowable[numberOfCats];
                        for (int i = 0; i < numberOfCats; i++) {
                            System.out.print("Введите имя " + (i+1) + "-го кота: ");
                            catName = in.nextLine();
                            Meowing cat = new Meowing(catName);
                            meowings[i] = cat;
                        }

                        makeThemMeow(meowings);
                        System.out.println("\nНажмите Enter для продолжения...");
                        in.nextLine();

                        System.out.println("=== ДЕМОНСТРАЦИЯ ПОДСЧЁТА КОЛ-ВА МЯУКАНИЙ ===");
                        MeowingWithCounter counter = new MeowingWithCounter("Барсик");

                        Meowable m = counter;
                        Funs.meowsCare(m);
                        System.out.println(counter);
                        break;
                    
                    case 3:
                        System.out.println("Задание 3.3");
                        System.out.println("=== ДЕМОНСТРАЦИЯ РАБОТЫ КЛАССА ВСТАВКИ СПИСКА\n");
                        System.out.println("1. ЦЕЛЫЕ ЧИСЛА");
                        List<Integer> L1 = new ArrayList<>();
                        int n = checkInt("Введите длину первого списка: ");
                        for (int i = 0; i < n; i++) {
                            int number = checkInt("Введите " + (i + 1) + "-й элемент: ");
                            if (!L1.isEmpty()){
                                while (number < (int) L1.get(L1.size() - 1)) {
                                    System.out.println("Ошибка: список должен быть упорядочен");
                                    number = checkInt("Введите ещё раз: ");
                                }
                            }      
                            L1.add(number);
                        }
                        System.out.println();

                        List<Integer> L2 = new ArrayList<>();
                        n = checkInt("Введите длину второго списка: ");
                        for (int i = 0; i < n; i++) {
                            int number = checkInt("Введите " + (i + 1) + "-й элемент: ");
                            if (!L2.isEmpty()){
                                while (number < (int) L2.get(L2.size() - 1)) {
                                    System.out.println("Ошибка: список должен быть упорядочен");
                                    number = checkInt("Введите ещё раз: ");
                                }
                            }      
                            L2.add(number);
                        }
                        
                        System.out.println("До вставки:");
                        System.out.println("L1: " + L1);
                        System.out.println("L2: " + L2);
                        
                        merge(L1, L2);
                        
                        System.out.println("После вставки L2 в L1:");
                        System.out.println("L1: " + L1);
                        System.out.println("Список отсортирован? - " + isSorted(L1));
                        System.out.println("\nНажмите Enter для продолжения...");
                        in.nextLine();

                        System.out.println("2. СТРОКИ");
                        List<String> stringsL1 = new ArrayList<>(Arrays.asList("apple", "banana", "date"));
                        List<String> stringsL2 = new ArrayList<>(Arrays.asList("apricot", "cherry", "grape"));
                        
                        System.out.println("До вставки:");
                        System.out.println("L1: " + stringsL1);
                        System.out.println("L2: " + stringsL2);
                        
                        merge(stringsL1, stringsL2);
                        
                        System.out.println("После вставки L2 в L1:");
                        System.out.println("L1: " + stringsL1);
                        System.out.println("Список отсортирован? - " + isSorted(stringsL1));
                        break;
                        
                    case 4:
                        System.out.println("Задание 4.3");
                        String filename = "competition.txt";
                        System.out.println("=== ДЕМОНСТРАЦИЯ СОРТИРОВКИ МАПА ===");
                        
                        System.out.println("\nИСХОДНЫЕ ДАННЫЕ:");
                        Files.lines(Paths.get(filename)).forEach(line -> System.out.println("  " + line));
                        System.out.println();
                        Map<Integer, List<Participant>> scoreMap = readFromFile(filename);
                        System.out.println("Все баллы в Map: " + scoreMap.keySet());
                        
                        List<Participant> topParticipants = findTopThree(scoreMap);
                        System.out.println("Лучшие участники:");
                        for (Participant p : topParticipants) {
                            System.out.println(p.getLastName() + " " + p.getFirstName() + " - " + p.getTotalScore() + " баллов");
                        }    
                        break;
                    
                    case 5:
                        System.out.println("Задание 5.7");
                        filename = "russian_text.txt";
                        try{
                            System.out.println("=== ДЕМОНСТРАЦИЯ РАБОТЫ КЛАССА ПОДСЧЁТА РАЗЛИЧНЫХ БУКВ ===\n");
                            
                            String testText = "";
                            System.out.println("Выберите из предложенных вариантов:\n1. Ввести текст\n2. Использовать готовый");
                            n = checkInt("Выберите вариант (1-2): ");
                            while (n != 1 && n != 2) {
                                n = checkInt("Выберите из предложенных вариантов:\n" +
                                            "1. Ввести текст\n2. Использовать готовый\n" +
                                            "Выберите вариант (1-2): ");
                            }
                            switch (n) {
                                case 1:
                                    System.out.print("Введите текст: ");
                                    testText = in.nextLine();
                                    break;
                                case 2:
                                    testText = "Съешь же ещё этих мягких французских булок да выпей же чаю";
                                default:
                                    break;
                            }

                            try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
                                    writer.println(testText);
                            }
                            System.out.println("\nТекст в файле: \n" + testText + "\n");
                            int letters = countUniqueLetters(filename);
                            System.out.println("В тексте встречается " + letters + " разных русских букв");
                        } catch (IOException e) {
                            System.err.println("Ошибка при работе с файлом: " + e.getMessage());
                        }
                        break;

                    case 6:
                        System.out.println("Задание 6.2");
                        System.out.println("=== ДЕМОНСТРАЦИЯ РАБОТЫ КЛАССА ЗЕРКАЛА ===\n");
        
                        List<Integer> numbers = new ArrayList<>();
                        n = checkInt("Введите длину списка: ");
                        for (int i = 0; i < n; i++) {
                            int number = checkInt("Введите " + (i + 1) + "-й элемент: ");
                            numbers.add(number);
                        }
                        
                        Queue<Integer> numberQueue = buildMirrorQueue(numbers);
                        System.out.println("Числа: " + numbers + " -> Очередь: " + numberQueue);
                        
                        List<String> strings = Arrays.asList("Abc", "Bcd", "Cde");
                        Queue<String> stringQueue = buildMirrorQueue(strings);
                        System.out.println("Строки: " + strings + " -> Очередь: " + stringQueue);
                        break;
                    
                    case 7:
                        System.out.println("Задание 7.1");
                        System.out.println("=== ДЕМОНСТРАЦИЯ ОБРАБОТКИ СТРИМОМ ===\n");

                        List<Point> testPoints = new ArrayList<>();

                        n = checkInt("Сколько точек создать: ");
                        for (int i = 0; i < n; i++){
                            int[] pointCoords = readNumbers("Введите х у "+ (i+1) + "-й точки(через пробел): ", 2);
                            Point point = new Point (pointCoords[0], pointCoords[1]);
                            testPoints.add(point);
                        }
                        
                        System.out.println("Исходные точки:");
                        testPoints.forEach(point -> System.out.println("  " + point));
                        
                        Polyline resultLine = processPoints(testPoints);
                        
                        System.out.println("\nРезультирующая ломаная:\nБез дубликатов, отсортирована по Х, с положительными Y");
                        System.out.println("  " + resultLine);
                        break;

                    case 8:
                        System.out.println("Задание 7.2");
                        System.out.println("=== ДЕМОНСТРАЦИЯ ОБРАБОТКИ СТРИМОМ ===");
                        filename = "people.txt";
                        String[] testData = {
                            "Вася:5",
                            "Петя:3", 
                            "Аня:5",
                            "маша:2",
                            "КОЛЯ:7",
                            "Сережа:",  // без номера
                            ":10",       // без имени
                            "Оля:3",
                            "иван:5",
                            "Таня:",    // без номера
                            "Гриша:2",
                            "  Витя  :  8  ",  // с пробелами
                            "света:3"
                        };
                        Files.write(Paths.get(filename), Arrays.asList(testData));

                        System.out.println("\nИСХОДНЫЕ ДАННЫЕ:");
                        Files.lines(Paths.get(filename)).forEach(line -> System.out.println("  " + line));
                        
                        Map<Integer, List<String>> result = processFile(filename);
                        
                        System.out.println("\nРЕЗУЛЬТАТ ОБРАБОТКИ:");
                        result.entrySet().stream()
                            .sorted(Map.Entry.comparingByKey())
                            .forEach(entry -> {
                                System.out.println("  " + entry.getKey() + ": " + entry.getValue());
                            });
                        break;

                    default:
                        System.out.println("Ошибка! Выберите число от 0 до 8.");
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
