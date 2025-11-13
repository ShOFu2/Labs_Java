package ru.Daripov.geometry;

/**
 * Класс Line - линия на плоскости
 */
public class Line {
    // Поля
    private Point start;
    private Point end;

    // Свойства
    public void setStart(Point start) {
        this.start = start;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public Point getStart() {
        return start;
    }
    
    public Point getEnd() {
        return end;
    }
    
    // Конструктор
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    // Методы
    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }
}
