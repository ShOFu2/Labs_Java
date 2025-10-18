package ru.Daripov.geometry;
import ru.Daripov.abstracts.*;

/**
 * Точка с тремя координатами (совместима с существующим PointZ)
 */
public class Point3D extends AbstractPoint {
    // Поле
    private PointZ point;
    
    // Свойства
    public PointZ getPoint() {
        return new PointZ(point);
    }
    
    public void setPoint(PointZ point) {
        this.point = new PointZ(point);
    }
    
    @Override
    public String getCoordinates() {
        return point.toString();
    }
    
    public String getDimensionInfo() {
        return "3D точка";
    }
    
    @Override
    public String getDescription() {
        return String.format("%s %s, цвет: %s, время: %s",
        getDimensionInfo(), getCoordinates(), getColor(), getCreationTime());
    }
    
    // Конструкторы
    public Point3D(PointZ point) {
        super();
        this.point = new PointZ(point);
    }
    
    public Point3D(PointZ point, String color, String creationTime) {
        super(color, creationTime);
        this.point = new PointZ(point);
    }
    
    public Point3D(int x, int y, int z) {
        super();
        this.point = new PointZ(x, y, z);
    }
    
    public Point3D(int x, int y, int z, String color, String creationTime) {
        super(color, creationTime);
        this.point = new PointZ(x, y, z);
    }
}
