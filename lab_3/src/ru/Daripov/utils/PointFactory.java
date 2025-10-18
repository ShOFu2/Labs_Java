package ru.Daripov.utils;
import ru.Daripov.geometry.*;

/**
 * Утилитный класс для создания точек с различными характеристиками
 */
public class PointFactory {
    
    // Создание точек с одной координатой
    public static Point1D create1DPoint(int x, String красный) {
        return new Point1D(x);
    }
    
    public static Point1D create1DPoint(int x, String color, String time) {
        return new Point1D(x, color, time);
    }
    
    // Создание точек с двумя координатами
    public static Point2D create2DPoint(Point point) {
        return new Point2D(point);
    }
    
    public static Point2D create2DPoint(Point point, String color, String time) {
        return new Point2D(point, color, time);
    }
    
    public static Point2D create2DPoint(int x, int y) {
        return new Point2D(x, y);
    }
    
    public static Point2D create2DPoint(int x, int y, String color, String time) {
        return new Point2D(x, y, color, time);
    }
    
    // Создание точек с тремя координатами
    public static Point3D create3DPoint(PointZ point) {
        return new Point3D(point);
    }
    
    public static Point3D create3DPoint(PointZ point, String color, String time) {
        return new Point3D(point, color, time);
    }
    
    public static Point3D create3DPoint(int x, int y, int z) {
        return new Point3D(x, y, z);
    }
    
    public static Point3D create3DPoint(int x, int y, int z, String color, String time) {
        return new Point3D(x, y, z, color, time);
    }
    
    // Создание расширяемых точек
    public static ExtendedPoint createExtendedPoint(Point point) {
        return new ExtendedPoint(point);
    }
    
    public static ExtendedPoint createExtendedPoint(Point point, String color, String time) {
        return new ExtendedPoint(point, color, time);
    }
}
