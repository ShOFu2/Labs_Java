package ru.Daripov.сat;

public class Cat{
    // Поля
    private String name; // Имя кота

    // Свойства
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Конструктор
    public Cat(String name) {
        this.name = name;
    }

    //Методы
    @Override
    public String toString() {
        return "кот: " + name;
    }

    public void meow() {
        System.out.println(name + ": мяу!");
    }
}
