package ru.Daripov.geometry;
/*
 * Класс, описывающий сущность Точка
 */

public class Point {
    // Поля
    private int x;
    private int y;

    // Свойства
    public final void setX (int x) {
        this.x = x;
    }

    public final void setY (int y) {
        this.y = y;
    }

    public int getX () {
        return this.x;
    }

    public int getY () {
        return this.y;
    }

    // Конструкторы
    public Point () {
        setX(0);
        setY(0);
    }

    public Point (Point point) {
        setX(point.x);
        setY(point.y);
    }

    public Point (PointZ pointZ) {
        setX(pointZ.getX());
        setY(pointZ.getY());
    }

    public Point (int x, int y) {
        setX(x);
        setY(y);
    }

    public Point (int[] xY) {
        setX(xY[0]);
        setY(xY[1]);
    }
    
    // Методы
    @Override
    public String toString () {
        return "{" + x + ";" + y + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Point point = (Point) obj;
        return x == point.x && y == point.y;
    }
}