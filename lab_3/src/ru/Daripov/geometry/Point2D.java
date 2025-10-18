package ru.Daripov.geometry;
import ru.Daripov.abstracts.*;

/**
 * Точка с двумя координатами (совместима с существующим Point)
 */
public class Point2D extends AbstractPoint {
    // Поле
    private Point point;
    
    public Point2D(Point point) {
        super();
        this.point = new Point(point);
    }
    
    // Свойства
    public Point getPoint() {
        return new Point(point);
    }
    
    public void setPoint(Point point) {
        this.point = new Point(point);
    }
    
    @Override
    public String getCoordinates() {
        return point.toString();
    }
    
    public String getDimensionInfo() {
        return "2D точка";
    }
    
    @Override
    public String getDescription() {
        return String.format("%s %s, цвет: %s, время: %s",
            getDimensionInfo(), getCoordinates(), getColor(), getCreationTime());
    }
    
    // Конструкторы
    public Point2D(Point point, String color, String creationTime) {
        super(color, creationTime);
        this.point = new Point(point);
    }
    
    public Point2D(int x, int y) {
        super();
        this.point = new Point(x, y);
    }
    
    public Point2D(int x, int y, String color, String creationTime) {
        super(color, creationTime);
        this.point = new Point(x, y);
    }
}
