package ru.Daripov.сat;
import ru.Daripov.interfaces.Meowable;

// Дочерний класс MeowingWithCounter для подсчета мяуканий
public class MeowingWithCounter extends Cat implements Meowable {
    // Поле
    private int meowCount = 0;

    // Свойства
    public int getMeowCount() {
        return meowCount;
    }

    // Конструктор
    public MeowingWithCounter(String name) {
        super(name);
    }
    
    // Методы
    @Override
    public String toString() {
        return "кот мяукал " + getMeowCount() + " раз";
    }

    @Override
    public void meow() {
        super.meow();
        meowCount++;
    }
}