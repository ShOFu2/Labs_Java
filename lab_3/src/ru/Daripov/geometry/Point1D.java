package ru.Daripov.geometry;
import ru.Daripov.abstracts.*;

/**
 * Точка с одной координатой
 */
public class Point1D extends AbstractPoint {
    // Поле
    private int x;
    
    // Свойства
    public int getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    @Override
    public String getCoordinates() {
        return String.valueOf(x);
    }
    
    public String getDimensionInfo() {
        return "1D точка";
    }
    
    @Override
    public String getDescription() {
        return String.format("%s в координате %s, цвет: %s, время: %s",
        getDimensionInfo(), getCoordinates(), getColor(), getCreationTime());
    }
    
    // Конструкторы
    public Point1D(int x, String color, String creationTime) {
        super(color, creationTime);
        this.x = x;
    }
    
    public Point1D(int x) {
        super();
        this.x = x;
    }
}
