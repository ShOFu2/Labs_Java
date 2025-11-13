package ru.Daripov.geometry;

import java.util.Objects;

/**
 * Класс Point - точка на плоскости
 */
public class Point {
    // Поля
    private int x;
    private int y;
    
    // Свойства
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    // Конструктор
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Методы
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Integer.compare(point.x, x) == 0 && Integer.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
