package ru.Daripov.geometry;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс Polyline - ломаная линия
 */
public class Polyline {
    private final List<Point> points;

    public Polyline(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    /**
     * Текстовое представление вида "Линия [T1,T2,…,TN]"
     */
    @Override
    public String toString() {
        return "Линия " + points.stream()
            .map(Point -> Point.toString())
            .collect(Collectors.joining(",", "[", "]"));
    }
}
