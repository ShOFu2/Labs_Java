/*
 * Класс, содержащий методы для проверки пользовательского ввода
*/

import java.util.Scanner;

public class CheckInput {
    private final Scanner in = new Scanner(System.in);

    // Метод, проверяющий ввод пользователя и возвращающий целое положительное
    public int checkPositive() {
        int x;
        float tryX = in.nextFloat();
        while (tryX % 1 != 0 || tryX < 0) {
            if (tryX % 1 != 0) {
                System.out.println("Ошибка: число должно быть целочисленным");
                System.out.print("Попробуйте ещё раз: ");
                tryX = in.nextFloat();
            }
            if (tryX <= 0) {
                System.out.println("Ошибка: число должно быть больше нуля");
                System.out.print("Попробуйте ещё раз: ");
                tryX = in.nextFloat();
            }
        }
        x = (int) tryX;
        return x;
    }

    // Метод, проверяющий ввод пользователя и возвращающий целое
    public int checkInt() {
        int x;
        float tryX = in.nextFloat();
        while (tryX % 1 != 0) {
            if (tryX % 1 != 0) {
                System.out.println("Ошибка: число должно быть целочисленным");
                System.out.print("Попробуйте ещё раз: ");
                tryX = in.nextFloat();
            }
        }
        x = (int) tryX;
        return x;
    }
}