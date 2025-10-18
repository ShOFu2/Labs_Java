package ru.Daripov.main;
import java.util.Arrays;
import java.util.Scanner;
import ru.Daripov.geometry.*;
import ru.Daripov.interfaces.NumericValue;
import ru.Daripov.numbers.*;
import ru.Daripov.utils.*;
import static ru.Daripov.utils.CheckInput.*;

public class Main {
    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(System.in)) {
            boolean running = true;
            
            
            while (running) {
                System.out.println("=== МЕНЮ ПРОГРАММЫ ===");
                System.out.println("1. Задание 1.6 - Отдельные линии");
                System.out.println("2. Задание 1.12 - Квадрат");
                System.out.println("3. Задание 2.1 - Неизменяемый массив");
                System.out.println("4. Задание 3.5 - Трехмерная точка");
                System.out.println("5. Задание 4.5 - Точки");
                System.out.println("6. Задание 5.1 - Сложение");
                System.out.println("7. Задание 6.3 - Сравнение линий");
                System.out.println("8. Задание 7.1 - Навести порядок");
                System.out.println("9. Задание 7.2 - Главный метод");
                System.out.println("10. Задание 7.3 - Возведение в степень");
                System.out.println("11. Задание 8.5 - Клонирование линии");
                System.out.println("0. Выход из программы");
                System.out.println("======================");
                
                int choice = checkInt("Выберите задание (0-11): ");
                
                switch (choice) {
                    case 0:
                        System.out.println("Завершение работы программы...");
                        running = false;
                        break;

                    case 1:
                        System.out.println("\nЗадание 1.6");
                        System.out.println("Две любые линии не могут ссылаться на один и тот же объект точки.\n" +
                                            "У Линии можно изменить координаты начала или конца\n" +
                                            "У Линии можно запросить координаты начала или конца");

                        System.out.println("\n=== Демонстрация работы класса Line ===");

                        System.out.println("1. Создание исходных объектов:");
                        int[] p1Coords = readNumbers("Введите x и y точки p1 (через пробел): ", 2);
                        Point p1 = new Point(p1Coords[0], p1Coords[1]);
                        int[] p2Coords = readNumbers("Введите x и y точки p2 (через пробел): ", 2);
                        Point p2 = new Point(p2Coords[0], p2Coords[1]);
                        Line line1 = new Line(p1, p2);
                        System.out.println("Точка p1: " + p1);
                        System.out.println("Точка p2: " + p2);
                        System.out.println("line1: " + line1);
                        System.out.println("Нажмите Enter для продолжения...");
                        in.nextLine();

                        System.out.println("\n2. Демонстрация независимости точек:");
                        Line line2 = new Line(line1);
                        System.out.println("line2 (копия line1): " + line2);
                        
                        int[] newP1Coords = readNumbers("Введите новые x и y точки p1 (через пробел): ", 2);
                        p1.setX(newP1Coords[0]);
                        p1.setY(newP1Coords[1]);
                        System.out.println("После изменения исходной точки p1:");
                        System.out.println("Точка p1: " + p1);
                        System.out.println("line1: " + line1);
                        System.out.println("line2: " + line2);
                        System.out.println("Линии не изменились, так как используют копии точек");
                        System.out.println("Нажмите Enter для продолжения...");
                        in.nextLine();
                        
                        System.out.println("\n3. Изменение координат линии:");
                        System.out.println("Исходная line1: " + line1);
                        
                        int[] newLine1Start = readNumbers("Введите x и y нового начала line1 (через пробел): ", 2);
                        Point newStart = new Point(newLine1Start[0], newLine1Start[1]);
                        line1.setStart(newStart);
                        System.out.println("После установки нового начала:");
                        System.out.println("line1: " + line1);
                        System.out.println("line2: " + line2);
                        System.out.println("line1 изменилась, line2 осталась прежней");
                        System.out.println("Нажмите Enter для продолжения...");
                        in.nextLine();
                        
                        System.out.println("\n4. Получение координат линии:");
                        Point startCopy = line1.getStart();
                        Point endCopy = line1.getEnd();
                        System.out.println("Копия начала line1: " + startCopy);
                        System.out.println("Копия конца line2: " + endCopy);
                        break;

                    case 2:
                        System.out.println("Задание 1.12");
                        System.out.println("1. Создать Квадрат в точке {5;3} со стороной 23\n" +
                                            "2. Присвоить в ссылку типа Ломаная результат вызова метода получения Ломаной у ранее\n" +
                                            "созданного квадрата\n" +
                                            "3. Вывести на экран общую длину полученной Ломаной\n" +
                                            "4. Сдвинуть последнюю Точку Ломаной в позицию {15,25}\n" +
                                            "5. Снова вывести на экран длину Ломаной\n");
                        
                        Square square = new Square(new Point(5,3), 23);
                        System.out.println("1. " + square);

                        BreakLine squareLine = square.getBreakLine();
                        System.out.println("2. Полученная линия: " + squareLine);
                        System.out.println("3. Длина полученной линии: " + squareLine.getLength());

                        Point[] squareLinePoints = squareLine.getPoints();

                        Point squareLineLastPoint = squareLinePoints[squareLinePoints.length - 1];
                        squareLineLastPoint.setX(15);
                        squareLineLastPoint.setY(25);

                        squareLinePoints[squareLinePoints.length - 1] = squareLineLastPoint;
                        squareLine.setPoints(squareLinePoints);
                        System.out.println("4. Полученная линия: " + squareLine);

                        System.out.println("5. Длина полученной линии: " + (int) squareLine.getLength());
                        break;

                    case 3:
                        System.out.println("Задание 2.1");
                        System.out.println("=== Демонстрация ImmutableList ===\n");

                        // 1. Инициализация разными способами
                        System.out.println("1. Инициализация списков:");
                        int arraySize = checkPositive("Введите размер массива: ");
                        while (arraySize == 0) {
                            System.out.println("Пожалуйста введите другое число для более наглядной " +
                                            "демонстрации: ");
                            arraySize = checkPositive("Введите размер массива: ");
                        }

                        int[] array = readNumbers("Введите значения массива: ", (int) arraySize);

                        System.out.print("\nПолученный массив: ");
                        System.out.println(Arrays.toString(array));

                        ImmutableList list1 = new ImmutableList(array);
                        System.out.println("list1 (из массива): " + list1);

                        ImmutableList list2 = new ImmutableList(4, 5, 6, 7);
                        System.out.println("list2 (из перечня): " + list2);
                        
                        ImmutableList list3 = new ImmutableList(list1);
                        System.out.println("list3 (копия list1): " + list3);
                        
                        ImmutableList emptyList = new ImmutableList();
                        System.out.println("emptyList (пустой): " + emptyList);

                        System.out.println("Нажмите Enter для продолжения...");
                        in.nextLine();
                        
                        // 2. Получение значений
                        System.out.println("\n2. Получение значений:");
                        int[] listChoice = readNumbers("Выберите список для примера:\n" + "1. list1: " + list1 +
                                            "\n2. list2: " + list2 + "\n",1);
                        while (listChoice[0] != 1 && listChoice[0] != 2) {
                            listChoice = readNumbers("Ошибка! Выберите число от 0 до 2.\n",1);
                        }

                        switch (listChoice[0]) {
                            case 1:
                                int[] listIndex = readNumbers("Введите индекс желаемого числа (0 - " + 
                                                                    (list1.length() - 1) + "): ",1);
                                while (listIndex[0] < 0 || listIndex[0] >= list1.length()) {
                                    System.out.println("Ошибка: Позиция " + listIndex[0] + " выходит за границы списка [0, "
                                                        + (list1.length() - 1) + "]");
                                    listIndex = readNumbers("Попробуйте ещё раз: ",1);
                                }
                                System.out.println("Полученное значение: " + list1.get(listIndex[0]));
                                break;

                            case 2:
                                listIndex = readNumbers("Введите индекс желаемого числа (0 - " + 
                                                                    (list2.length() - 1) + "): ",1);
                                while (listIndex[0] < 0 || listIndex[0] >= list2.length()) {
                                    System.out.println("Ошибка: Позиция " + listIndex[0] + " выходит за границы списка [0, "
                                                        + (list2.length() - 1) + "]");
                                    listIndex = readNumbers("Попробуйте ещё раз: ",1);
                                }
                                System.out.println("Полученное значение: " + list2.get(listIndex[0]));
                                break;

                            default:
                                break;
                        }

                        System.out.println("Нажмите Enter для продолжения...");
                        in.nextLine();
                        
                        // 3. Замена значений
                        System.out.println("\n3. Замена значений:");
                        System.out.println("Исходный list2: " + list2);

                        int[] listIndex = readNumbers("Введите индекс числа для замены (0 - " + 
                                                                (list2.length() - 1) + "): ",1);
                        while (listIndex[0] < 0 || listIndex[0] >= list2.length()) {
                                    System.out.println("Позиция " + listIndex[0] + " выходит за границы списка [0, "
                                                        + (list2.length() - 1) + "]");
                                    listIndex = readNumbers("Попробуйте ещё раз: ", 1);
                        }

                        int[] newIndexNum = readNumbers("Введите новое значение: ", 1);

                        ImmutableList list2Modified = list2.set(listIndex[0] ,newIndexNum[0]);
                        System.out.println("Новый список после list2.set(" + listIndex[0] + ", " +
                                            newIndexNum[0] + "): " + list2Modified);

                        System.out.println("Нажмите Enter для продолжения...");
                        in.nextLine();
                        
                        // 4. Проверка на пустоту и размер
                        System.out.println("\n4. Проверка размера и пустоты:");
                        System.out.println("list1.isEmpty() = " + list1.isEmpty());
                        System.out.println("list1.length() = " + list1.length());
                        System.out.println("emptyList.isEmpty() = " + emptyList.isEmpty());
                        System.out.println("emptyList.length() = " + emptyList.length());

                        System.out.println("Нажмите Enter для продолжения...");
                        in.nextLine();
                        
                        // 5. Получение массива
                        System.out.println("\n5. Получение массива:");
                        int[] arrayFromList = list1.toArray();
                        System.out.println("Массив из list1: " + Arrays.toString(arrayFromList));

                        System.out.println("Нажмите Enter для продолжения...");
                        in.nextLine();

                        // 6. Демонстрация неизменяемости
                        System.out.println("\n6. Демонстрация неизменяемости:");
                        System.out.println("Исходный массив list1: " + Arrays.toString(array));
                        array[0] = 999; // Изменяем исходный массив
                        System.out.println("После изменения исходного массива (array[0] = 999):");
                        System.out.println("Исходный массив: " + Arrays.toString(array));
                        System.out.println("list1 (созданный из массива): " + list1);
                        System.out.println("list1 не изменился благодаря защитному копированию!");
                        break;
                    
                    case 4:
                        System.out.println("Задание 4");
                        System.out.println("Создание подвида сущности Точка");
                        System.out.println("=== Демонстрация работы PointZ ===\n");

                        // 1. Создание точек разными способами
                        System.out.println("1. Создание точек:");
                        
                        PointZ pZ1 = new PointZ(); // (0,0,0)
                        System.out.println("PointZ1() = " + pZ1);
                        int[] pZ2coords = readNumbers("Введите x, y, z координаты точки (через пробел): ", 3);
                        PointZ pZ2 = new PointZ(pZ2coords[0], pZ2coords[1], pZ2coords[2]);
                        System.out.println("PointZ2(" + pZ2coords[0] + "," + pZ2coords[1] + "," + pZ2coords[2] + "): " + pZ2);
                        
                        PointZ pZ3 = new PointZ(pZ2); // Копия pZ2
                        System.out.println("PointZ3(копия PointZ2) = " + pZ3);
                        System.out.println("Нажмите Enter для продолжения...");
                        in.nextLine();
                        
                        int[] basePointCoords = readNumbers("Введите x, y координаты точки" +
                                                                 " (через пробел): ", 2);
                        Point basePoint = new Point(basePointCoords[0], basePointCoords[1]);
                        PointZ pZ4 = new PointZ(basePoint);
                        System.out.println("PointZ4(Point(" + basePointCoords[0] + "," + basePointCoords[1] + ")): " + pZ4);
                        
                        PointZ pZ5 = new PointZ(basePoint, 7);
                        System.out.println("PointZ5(Point(" + basePointCoords[0] + "," + basePointCoords[1] + "), 7) = " + pZ5);
                        break;
                    
                    case 5:
                        System.out.println("Задание 4.5");
                        System.out.println("Создание сущностей, позволяющих создавать Точки с " +
                                            "разным набором координат и характеристиками");
                        System.out.println("=== Демонстрация иерархии точек ===");
        
                        // Пример 1: Точка в координате, ___ цвета
                        System.out.println("1. Точка с одной координатой и цветом:");
                        int[] point1X = readNumbers("Введите координату одномерной точки: ", 1);
                        System.out.print("Введите цвет: ");
                        String point1Color = in.nextLine();
                        Point1D point1 = PointFactory.create1DPoint(point1X[0], point1Color, "не указано");
                        System.out.println(point1.getDescription());
                        System.out.println("Нажмите Enter для продолжения...");
                        in.nextLine();
                        
                        // Пример 2: Точка в координате {_,_,_} в ___
                        System.out.println("2. 3D точка со временем:");
                        int[] point2Coords = readNumbers("Введите x, y, z" +
                                                        " точки (через пробел): ", 3);
                        System.out.print("Введите время: ");
                        String point2Time = in.nextLine();
                        Point3D point2 = PointFactory.create3DPoint(point2Coords[0], point2Coords[1], point2Coords[2],
                                                                    "без цвета", point2Time);
                        System.out.println(point2.getDescription());
                        System.out.println("Нажмите Enter для продолжения...");
                        in.nextLine();
                        
                        // Пример 3: Точка в координате {7,7} в 15:35, желтого цвета
                        System.out.println("3. 2D точка с цветом и временем:");
                        int[] point3Coords = readNumbers("Введите x, y точки (через пробел): ", 2);
                        System.out.print("Введите цвет: ");
                        String point3Color = in.nextLine();
                        System.out.print("Введите время: ");
                        String point3Time = in.nextLine();
                        Point2D point3 = PointFactory.create2DPoint(point3Coords[0], point3Coords[1], point3Color, point3Time);
                        System.out.println(point3.getDescription());
                        System.out.println("Нажмите Enter для продолжения...");
                        in.nextLine();
                        
                        // Пример 4: Использование существующих Point и PointZ
                        System.out.println("4. Совместимость с существующими классами:");
                        Point existingPoint = new Point(10, 20);
                        PointZ existingPointZ = new PointZ(1, 2, 3);
                        
                        Point2D adaptedPoint = PointFactory.create2DPoint(existingPoint, "синий", "12:00");
                        Point3D adaptedPointZ = PointFactory.create3DPoint(existingPointZ, "зеленый", "13:30");
                        
                        System.out.println(adaptedPoint.getDescription());
                        System.out.println(adaptedPointZ.getDescription());
                        System.out.println("Нажмите Enter для продолжения...");
                        in.nextLine();
                        
                        // Пример 5: Расширяемая точка с дополнительными характеристиками
                        System.out.println("5. Расширяемая точка:");
                        ExtendedPoint extendedPoint = PointFactory.createExtendedPoint(new Point(5, 5), "оранжевый", "14:00");
                        int addons = checkInt("Введите желаемое кол-во доп. характеристик: ");
                        for (int i = 0; i < addons; i++) {
                            System.out.print("Введите НАЗВАНИЕ " + (i+1) + "-й характеристики: ");
                            String name = in.nextLine();
                            System.out.print("Введите ЗНАЧЕНИЕ " + (i+1) + "-й характеристики: ");
                            String value = in.nextLine();
                            System.out.println();
                            extendedPoint.setFeature(name, value);
                        }
                        System.out.println(extendedPoint.getDescription());
                        System.out.println("Нажмите Enter для продолжения...");
                        in.nextLine();
                        
                        // Пример 6: Изменение характеристик
                        System.out.println("6. Изменение характеристик:");
                        Point2D dynamicPoint = PointFactory.create2DPoint(0, 0);
                        System.out.println("Исходная: " + dynamicPoint.getDescription());
                        
                        dynamicPoint.setColor("фиолетовый");
                        dynamicPoint.setCreationTime("16:45");
                        System.out.println("После изменений: " + dynamicPoint.getDescription());
                        break;

                    case 6:
                        System.out.println("Задание 5.1");
                        
                        System.out.println("=== ВЫЧИСЛЕНИЕ СУММ С ПОЛИМОРФИЗМОМ ===\n");
        
                        System.out.println("1. Вычисление: 2 + 3/5 + 2.3");
                        NumericValue[] expr1 = {
                            new IntegerValue(2),
                            new FractionValue(3, 5),
                            new DecimalValue(2.3)
                        };
                        MathUtils.calcAndPrint("2 + 3/5 + 2.3", expr1);
                        
                        System.out.println("\n2. Вычисление: 3.6 + 49/12 + 3 + 3/2");
                        NumericValue[] expr2 = {
                            new DecimalValue(3.6),
                            new FractionValue(49, 12),
                            new IntegerValue(3),
                            new FractionValue(3, 2)
                        };
                        MathUtils.calcAndPrint("3.6 + 49/12 + 3 + 3/2", expr2);
                        
                        System.out.println("\n3. Вычисление: 1/3 + 1");
                        NumericValue[] expr3 = {
                            new FractionValue(1, 3),
                            new IntegerValue(1)
                        };
                        MathUtils.calcAndPrint("1/3 + 1", expr3);
                        System.out.println("Нажмите Enter для продолжения...");
                        in.nextLine();
                        
                        System.out.println("\n=== ДЕМОНСТРАЦИЯ ПОЛИМОРФИЗМА ===");
                        NumericValue[] values = {
                            new IntegerValue(5),
                            new DecimalValue(2.75),
                            new FractionValue(1, 4),
                            new IntegerValue(10),
                            new FractionValue(3, 2)
                        };
                        
                        System.out.println("Массив значений:");
                        for (NumericValue value : values) {
                            System.out.println("  " + value + " = " + value.toDouble());
                        }
                        
                        double total = MathUtils.sum(values);
                        System.out.println("\nСумма всех значений: " + total);
                        
                        System.out.println("\nТипы объектов:");
                        for (NumericValue value : values) {
                            System.out.println("  " + value + " -> " + value.getClass().getSimpleName());
                        }
                        break;

                    case 7:
                        System.out.println("\nЗадание 6.3");
                        System.out.println("Сравнение линий");

                        Point start1 = new Point(readNumbers("Введите x, y начала line1 (через пробел): ", 2));
                        Point end1 = new Point(readNumbers("Введите x, y конца line1 (через пробел): ", 2));
                        Line newLine1 = new Line(start1, end1);

                        Point start2 = new Point(readNumbers("Введите x, y начала line2 (через пробел): ", 2));
                        Point end2 = new Point(readNumbers("Введите x, y конца line2 (через пробел): ", 2));
                        Line newLine2 = new Line(start2, end2);

                        System.out.println("\n=== Сравнение линий ===");
                        System.out.println("line1: " + newLine1);
                        System.out.println("line2: " + newLine2);
                        
                        System.out.println("\n=== Сравнение с учетом направления ===");
                        System.out.println("line1.equals(line2): " + newLine1.equals(newLine2));
                        System.out.println("\n=== Сравнение без учета направления ===");
                        System.out.println("line1.equalsIgnoreDirection(line2): " + newLine1.equalsIgnoreDirection(newLine2));
                        break;

                    case 8:
                        System.out.println("Задание 7.1");
                        System.out.println("Классы разложены по пакетам в соответствии с их логикой");
                        break;

                    case 9:
                        System.out.println("Задание 7.2");
                        System.out.println("Клас для подсчёта расположен в одном пакете с Main");

                        System.out.println("=== ДЕМОНСТРАЦИЯ КЛАССА СЛОЖЕНИЯ ЧИСЛОВЫХ ЗНАЧЕНИЙ ===\n");
                        
                        boolean ex9 = true;
                        NumericValue[] newExpr = new NumericValue[0];

                        while(ex9) {
                            System.out.println("Выберите тип числа, которое хотите создать:\n" + 
                                                "1. Целое\n" + 
                                                "2. Дробь\n" + 
                                                "3. Вещественное\n" + 
                                                "4. Закончить ввод");
                            int type = checkInt("Введите число (1-4): ");
                            switch (type) {
                                case 1:
                                    newExpr = Arrays.copyOf(newExpr, newExpr.length + 1);
                                    newExpr[newExpr.length-1] = new IntegerValue(checkInt("Введите значение числа: "));
                                    System.out.println();
                                    break;
                                case 2:
                                    newExpr = Arrays.copyOf(newExpr, newExpr.length + 1);
                                    int num = checkInt("Введите числитель: ");
                                    int den = checkInt("Введите знаменатель: ");
                                    while (den == 0){
                                        System.out.println("Ошибка: знаменатель не может быть равен нулю!");
                                        den = checkInt("Попробуйте ещё раз: ");
                                    }
                                    newExpr[newExpr.length-1] = new FractionValue(num, den);
                                    System.out.println();
                                    break;
                                case 3:
                                    newExpr = Arrays.copyOf(newExpr, newExpr.length + 1);
                                    System.out.print("Введите значение числа: ");
                                    newExpr[newExpr.length-1] = new DecimalValue(in.nextDouble());
                                    System.out.println();
                                    break;
                                case 4:
                                    ex9 = false;
                                    break;
                                default:
                                    break;
                            }
                        }

                        String expr = "";
                        for (int i = 0; i < newExpr.length; i++) {
                            if (i == newExpr.length - 1) {
                                expr += newExpr[i];
                            } else {
                            expr += newExpr[i] + " + ";
                            }
                        }

                        if("".equals(expr)) {
                            System.out.println("Ошибка: ничего не введено!");
                        } else {
                        System.out.println("Вычисление: " + expr);
                        MathUtils.calcAndPrint(expr, newExpr);
                        }
                        break;

                    case 10:
                        System.out.println("Задание 7.3");
                        System.out.println("=== Возведение в степень ===");

                        try {
                            System.out.print("Введите основание: ");
                            String number = in.nextLine();
                            System.out.print("Введите степень: ");
                            String power = in.nextLine();
                            double result = PowerCalculator.power(number, power);

                            System.out.println(number + " в степени " + power + " = " + (int) result);    
                        } catch (Exception e) {
                            System.out.println("Ошибка: " + e.getMessage());
                        }
                        break;
                    
                    case 11:
                        System.out.println("Задание 8.5");
                        System.out.println("=== Демонстрация клонирования линии ===\n");

                        int[] startXY = readNumbers("Введите x, y начала линии (через пробел): ", 2);
                        Point start = new Point(startXY[0], startXY[1]);
                        int[] endXY = readNumbers("Введите x, y конца линии (через пробел): ", 2);
                        Point end = new Point(endXY[0], endXY[1]);
                        Line originalLine = new Line(start, end);
                        
                        System.out.println("Оригинальная линия: " + originalLine);
                        System.out.println("Длина: " + originalLine.getLength());
                        System.out.println();

                        Line clonedLine = originalLine.clone();
                        
                        System.out.println("Клонированная линия: " + clonedLine);
                        System.out.println("Длина: " + clonedLine.getLength());
                        System.out.println();

                        System.out.println("=== Проверка различий ===");
                        System.out.println("originalLine == clonedLine: " + (originalLine == clonedLine));
                        System.out.println("originalLine.equals(clonedLine): " + originalLine.equals(clonedLine));
                        System.out.println();

                        System.out.println("=== Проверка глубокого копирования ===");
                        System.out.println("originalLine.getStart() == clonedLine.getStart(): " + 
                            (originalLine.getStart() == clonedLine.getStart()));
                        System.out.println("originalLine.getEnd() == clonedLine.getEnd(): " + 
                            (originalLine.getEnd() == clonedLine.getEnd()));
                        System.out.println();

                        System.out.println("=== Демонстрация независимости ===");
                        
                        startXY = readNumbers("Введите новые x, y начала линии (через пробел): ", 2);
                        originalLine.setStart(new Point(startXY[0], startXY[1]));
                        System.out.println("После изменения оригинала:");
                        System.out.println("Оригинальная линия: " + originalLine);
                        System.out.println("Клонированная линия: " + clonedLine);
                        System.out.println("Они все еще равны? " + originalLine.equals(clonedLine));
                        System.out.println();
                        break;

                    default:
                        System.out.println("Ошибка! Выберите число от 0 до 11.");
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
