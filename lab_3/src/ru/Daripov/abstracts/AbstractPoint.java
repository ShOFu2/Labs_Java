package ru.Daripov.abstracts;

/**
 * Абстрактный базовый класс для всех точек
 */
public abstract class AbstractPoint {
    // поля
    private String color;
    private String creationTime;
    
    // Абстрактные методы, которые должны реализовать все точки
    public abstract String getCoordinates();
    public abstract String getDescription();
    
    // Свойства
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color != null ? color : "без цвета";
    }
    
    public String getCreationTime() {
        return creationTime;
    }
    
    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime != null ? creationTime : "не указано";
    }

    // Конструкторы
    public AbstractPoint() {
        this.color = "без цвета";
        this.creationTime = "не указано";
    }
    
    public AbstractPoint(String color, String creationTime) {
        this.color = color != null ? color : "без цвета";
        this.creationTime = creationTime != null ? creationTime : "не указано";
    }
    
    // Методы
    @Override
    public String toString() {
        return getDescription();
    }
}