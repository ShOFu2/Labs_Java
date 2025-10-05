/*
 * Основной класс, демонстрирующий работу классов
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        CheckInput check = new CheckInput();
        try (Scanner in = new Scanner(System.in)) {
            int choice;
            boolean running = true;
            
            
            while (running) {
                System.out.println("=== МЕНЮ ПРОГРАММЫ ===");
                System.out.println("1. Задание 1 - Точка координат");
                System.out.println("2. Задание 2 - Прямая");
                System.out.println("3. Задание 3 - Студент");
                System.out.println("4. Задание 4.1 - Создаем Точку");
                System.out.println("5. Задание 4.2 - Создаем Линию");
                System.out.println("6. Задание 5 - Длина Линии");
                System.out.println("0. Выход из программы");
                System.out.println("======================");
                System.out.print("Выберите задание (0-6): ");
                
                choice = check.checkInt();
                
                switch (choice) {
                    case 0:
                        System.out.println("Завершение работы программы...");
                        running = false;
                        break;

                    case 1:
                        System.out.println("\nЗадание 1");
                        System.out.println("Создать три точки и вывести их координаты на экран");

                        System.out.print("Введите х и y первой точки (через пробел): ");
                        int x1 = check.checkInt();
                        int y1 = check.checkInt();
                        Point point1 = new Point(x1,y1);
                        System.out.println(point1);

                        System.out.print("Введите х и y второй точки (через пробел): ");
                        int x2 = check.checkInt();
                        int y2 = check.checkInt();
                        Point point2 = new Point(x2,y2);
                        System.out.println(point2);

                        System.out.print("Введите х и y третьей точки (через пробел): ");
                        int x3 = check.checkInt();
                        int y3 = check.checkInt();
                        Point point3 = new Point(x3,y3);
                        System.out.println(point3);

                        System.out.println("\nПервая точка:");
                        System.out.println(point1);
                        System.out.println("Вторая точка:");
                        System.out.println(point2);
                        System.out.println("Третья точка:");
                        System.out.println(point3);
                        break;

                    case 2:
                        System.out.println("\nЗадание 2");
                        Line line1 = new Line(1,3,23,8);
                        System.out.println("Линия 1: " + line1);
                        Line line2 = new Line(5,10,25,10);
                        System.out.println("Линия 2: " + line2);
                        Line line3 = new Line(line1.getStart(),line2.getEnd());
                        System.out.print("Линия 3: " + line3 + " - начинается там же где и 1-я линия");
                        System.out.println(", кончается там же где и 2-я");

                        System.out.println("\nВведите новые координаты первой линии:");
                        System.out.print("Введите координаты НАЧАЛА 1-й линии (через пробел): ");
                        x1 = check.checkInt();
                        y1 = check.checkInt();
                        System.out.print("Введите координаты КОНЦА 1-й линии (через пробел): ");
                        x2 = check.checkInt();
                        y2 = check.checkInt();
                        line1 = new Line(x1,y1,x2,y2);

                        System.out.println("\nВведите новые координаты второй линии:");
                        System.out.print("Введите координаты НАЧАЛА 2-й линии (через пробел): ");
                        x1 = check.checkInt();
                        y1 = check.checkInt();
                        System.out.print("Введите координаты КОНЦА 2-й линии (через пробел): ");
                        x2 = check.checkInt();
                        y2 = check.checkInt();
                        line2 = new Line(x1,y1,x2,y2);

                        line3 = new Line(line1.getStart(),line2.getEnd());

                        System.out.println("\nНовые координаты линий:");
                        System.out.println("Линия 1: " + line1);
                        System.out.println("Линия 2: " + line2);
                        System.out.println("Линия 3: " + line3);

                        System.out.print("\nВведите координаты КОНЦА 1-й линии (через пробел): ");
                        x2 = check.checkInt();
                        y2 = check.checkInt();
                        line1 = new Line(line1.getStart(),x2,y2);

                        System.out.println("\nНовые координаты линий: ");
                        System.out.println("Линия 1: " + line1);
                        System.out.println("Линия 2: " + line2);
                        System.out.println("Линия 3: " + line3);
                        System.out.println("Координаты третьей линии не изменились");
                        break;

                    case 3:
                        System.out.println("\nЗадание 3");
                        int[] vasyaMarks = new int[]{3,4,5};
                        Student vasya = new Student("Вася", vasyaMarks);
                        System.out.println(vasya);
                        Student petya = new Student("Петя", vasya.getMarks());
                        System.out.println(petya);
                        
                        vasya.getMarks()[0] = 5;
                        System.out.println("\nПервая оценка Пети заменена на 5:");
                        System.out.println(vasya);
                        System.out.println(petya);

                        System.out.println("\nОбъяснение результата:");
                        System.out.println("Оба студента имеют одинаковые оценки, потому что");
                        System.out.println("метод getMarks() возвращает ссылку на тот же массив,");
                        System.out.println("который используется обоими студентами. Это называется");
                        System.out.println("поверхностным копированием.");

                        int[] andreyMarks = Arrays.copyOf(vasya.getMarks(), vasya.getMarks().length);
                        Student andrey = new Student("Андрей", andreyMarks);

                        // Проверяем, что изменения Васи не влияют на Андрея
                        System.out.println("\nПроверка глубокого копирования:");
                        vasya.getMarks()[1] = 2; // Изменяем вторую оценку Васи
        
                        System.out.println("После изменения второй оценки Васи:");
                        System.out.println(vasya);
                        System.out.println(andrey);
                        System.out.println("Изменения Васи не затронули Андрея");
                        break;

                    case 4:
                        System.out.println("\nЗадание 4.1");
                        System.out.println("Точки можно создать только задав обе координаты");
                        PointAlt point1Alt = new PointAlt(3,5);
                        PointAlt point2Alt = new PointAlt(25,6);
                        PointAlt point3Alt = new PointAlt(7,8);

                        System.out.println("\nПервая точка:");
                        System.out.println(point1Alt);
                        
                        System.out.println("Вторая точка:");
                        System.out.println(point2Alt);
                        
                        System.out.println("Третья точка:");
                        System.out.println(point3Alt);
                        break;

                    case 5:
                        System.out.println("\nЗадание 4.2");
                        PointAlt start1 = new PointAlt(1,3);
                        PointAlt end1 = new PointAlt(23,8);
                        Line line1Alt = new Line(start1,end1);
                        System.out.println("Линия 1: " + line1Alt.toStringAlt());

                        PointAlt start2 = new PointAlt(5,10);
                        PointAlt end2 = new PointAlt(25,10);
                        Line line2Alt = new Line(start2,end2);
                        System.out.println("Линия 2: " + line2Alt.toStringAlt());

                        Line line3Alt = new Line(line1Alt.getStartAlt(),line2Alt.getEndAlt());
                        System.out.print("Линия 3: " + line3Alt.toStringAlt() + " - начинается там же где и 1-я линия");
                        System.out.println(", кончается там же где и 2-я");
                        break;

                    case 6:
                        System.out.println("\nЗадание 5");
                        PointAlt startAlt = new PointAlt(1,1);
                        PointAlt endAlt = new PointAlt(10,15);

                        Line line = new Line(startAlt,endAlt);
                        System.out.println("Создана линия: " + line.toStringAlt());

                        System.out.println("Введите '1' чтобы узнать длину линии, любую цифру чтобы продолжить ");
                        float yesNo = in.nextFloat();
                        if (yesNo == 1) {
                            System.out.println("Длина линии: " + (int) line.getLength());
                        }
                        break;

                    default:
                        System.out.println("Ошибка! Выберите число от 0 до 6.");
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
}