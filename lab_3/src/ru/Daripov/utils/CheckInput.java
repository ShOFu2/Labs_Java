package ru.Daripov.utils;
/*
 * Утилитный класс, содержащий методы для проверки пользовательского ввода
*/

import java.util.Scanner;

public class CheckInput {
    private final static Scanner in = new Scanner(System.in);

    // Метод, проверяющий ввод пользователя и возвращающий целое положительное
    public static int checkPositive (String prompt) {
        while(true){
        int[] x = readNumbers(prompt,1);
        if (x[0] < 0) {
            System.out.println("Ошибка: число должно быть больше нуля");
            continue;
        }
        return x[0];
        }
    }

    // Метод, проверяющий ввод пользователя и возвращающий целое
    public static int checkInt (String prompt) {
        return readNumbers(prompt, 1)[0];
    }

    public static int[] readNumbers(String prompt, int expectedCount) {
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

    public static double[] readDoubles(String prompt, int expectedCount) {
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