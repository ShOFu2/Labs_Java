package ru.Daripov.сat;
import ru.Daripov.interfaces.Meowable;

// Дочерний класс Meowing, реализующий интерфейс MeowInterface
public class Meowing extends Cat implements Meowable{
    
    public Meowing(String name) {
        super(name);
    }

    @Override
    public void meow() {
        super.meow();
    }

    @Override
    public String toString() {
        return "кот: " + super.getName();
    }
}
