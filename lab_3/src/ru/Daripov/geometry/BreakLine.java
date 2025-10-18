package ru.Daripov.geometry;
/*
 * Класс, описывающий сущность Ломаная
 */

import java.util.Arrays;

public final class BreakLine {
    // поля
    private Point[] points;
    
    // свойства
    public void setPoints (Point[] pointsArray) {
        Point[] pointsCopy = pointsArray;
        this.points = pointsCopy;
    }
    
    public Point[] getPoints () {
        Point[] pointsCopy = this.points;
        return pointsCopy;
    }

    public double getLineLength (Point start, Point end) {
        double x1 = start.getX();
        double y1 = start.getY();

        double x2 = end.getX();
        double y2 = end.getY();
    
        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1,2));
    }

    public double getLength () {
        double length = 0;
        if (points.length == 1) {
            System.out.println("Ошибка: в линии всего одна точка");
            return length;
        } else {
            for (int i = 0; i < this.points.length - 1; i++) {
                length += getLineLength(this.points[i], this.points[i+1]);
            }
            return length;
        }
    }

    // конструкторы
    public BreakLine () {
        Point p1 = new Point(0,0);
        Point p2 = new Point(1,0);
        Point p3 = new Point(0,1);
        Point[] pAll = new Point[]{p1,p2,p3};
        setPoints(pAll);
    }

    public BreakLine (Point[] pointsArray) {
        Point[] pointsCopy = pointsArray;
        setPoints(pointsCopy);
    }

    // методы
    @Override
    public String toString () {
        String result = "Линия ";
        result += Arrays.toString(points);
        return result; 
    }

    public void addPoint (Point point) {
        Point[] newPoints = Arrays.copyOf(this.points, this.points.length + 1);
        newPoints[newPoints.length - 1] = point;
        this.points = newPoints;
    }

    public void addPoints (Point[] pointsArray) {
        Point[] newPoints = Arrays.copyOf(this.points, this.points.length + pointsArray.length);
        System.arraycopy(pointsArray, 0, newPoints, this.points.length, pointsArray.length);
        this.points = newPoints;
    }
}
