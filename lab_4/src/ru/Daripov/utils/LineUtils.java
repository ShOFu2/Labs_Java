package ru.Daripov.utils;

import ru.Daripov.geometry.Line;
import ru.Daripov.geometry.Point;
import ru.Daripov.geometry.PointZ;

// Утилитный класс для свдига начала линии на 10 по оси X
public class LineUtils {
     public static <T extends Point> T shiftPointX(T point) {
        T newStart;
        int shift;
        if (point.getX() < 0) {
            shift = -10;
        } else {
            shift = 10;
        }
        if (point instanceof PointZ) {
            PointZ point3D = (PointZ) point;
            newStart = (T) new PointZ(point3D.getX() + shift, point3D.getY(), point3D.getZ());
        } else {
            newStart = (T) new Point(point.getX() + shift, point.getY());
        }
        return newStart;
    }

    public static <T extends Point> void shiftStartX(Line<T> line) {
        T newStart = shiftPointX(line.getStart());
        line.setStart(newStart);
    }
}
