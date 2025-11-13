package ru.Daripov.utils;

import java.util.List;
import java.util.stream.Collectors;
import ru.Daripov.geometry.Point;
import ru.Daripov.geometry.Polyline;

/**
 * Класс с реализацией стрима для сбора в ломаную
 */
public class PointStreamProcessor {
    public static Polyline processPoints(List<Point> points) {
        List<Point> processedPoints = points.stream()
                .distinct()
                .sorted((p1, p2) -> Double.compare(p1.getX(), p2.getX()))
                .map(point -> {
                    int newY = point.getY() < 0 ? -point.getY() : point.getY();
                    return new Point(point.getX(), newY);
                })
                .collect(Collectors.toList());
        return new Polyline(processedPoints);
    }

}
