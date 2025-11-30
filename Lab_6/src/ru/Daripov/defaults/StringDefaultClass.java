package ru.Daripov.defaults;

/**
 * Класс с аннотацией {@link Default} на уровне типа.
 * 
 * <p>Демонстрирует использование аннотации @Default для указания
 * типа по умолчанию для всего класса.
 * 
 * @author Дарипов Александр
 * @see Default
 */
@Default(String.class)
public class StringDefaultClass {
    private String data;
    
    /**
     * Конструктор по умолчанию.
     */
    public StringDefaultClass() {
        this.data = "Default String";
    }
    
    /**
     * Конструктор с параметром.
     * 
     * @param data строковые данные
     */
    public StringDefaultClass(String data) {
        this.data = data;
    }
    
    /**
     * Возвращает строковое представление объекта.
     * 
     * @return строковое представление
     */
    @Override
    public String toString() {
        return "StringDefaultClass{data='" + data + "'}";
    }
}