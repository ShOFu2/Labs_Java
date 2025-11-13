package ru.Daripov.utils;
import ru.Daripov.interfaces.Meowable;

//Утилитный класс для мяуканья всех котов
public class MeowingCats {
    public static void makeThemMeow(Meowable[] meowables) {
        System.out.println("=== Начало мяуканья ===");
        for (Meowable meowable: meowables) {
            meowable.meow();
        }
        System.out.print("=== Конец мяуканья ===\n");
    }
}
