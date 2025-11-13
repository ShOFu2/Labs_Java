package ru.Daripov.interfaces;

// Утилитный класс, который вызывает мяуканье несколько раз
public class Funs {
    public static void meowsCare(Meowable meowable) {
        for (int i = 0; i < 5; i++) {
            meowable.meow();
        }
    }
}