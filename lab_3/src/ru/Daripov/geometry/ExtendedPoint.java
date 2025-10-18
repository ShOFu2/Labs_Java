package ru.Daripov.geometry;
import java.util.HashMap;
import java.util.Map;
import ru.Daripov.abstracts.*;

/**
 * Расширяемая точка с поддержкой дополнительных характеристик
 */
public class ExtendedPoint extends AbstractPoint {
    // Поля
    private Point point; // Базовые координаты
    private final Map<String, String> features; // Дополнительные характеристики
    
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
        return "Расширяемая 2D точка";
    }

    @Override
    public String getDescription() {
        String description = (String.format("%s %s, цвет: %s    время: %s",
            getDimensionInfo(), getCoordinates(), getColor(), getCreationTime()));
        
        // Добавляем дополнительные характеристики
        if (!features.isEmpty()) {
            description += ", дополнительные характеристики:\n ";
            for (Map.Entry<String, String> entry : features.entrySet()) {
                description += (String.format("%s: %s   ", entry.getKey(), entry.getValue()));
            }
        }
        
        return description;
    }
    
    // Конструкторы
    public ExtendedPoint(Point point) {
        super();
        this.point = new Point(point);
        this.features = new HashMap<>();
    }
    
    public ExtendedPoint(Point point, String color, String creationTime) {
        super(color, creationTime);
        this.point = new Point(point);
        this.features = new HashMap<>();
    }
    
    public ExtendedPoint(int x, int y) {
        super();
        this.point = new Point(x, y);
        this.features = new HashMap<>();
    }
    

    
    // Реализация интерфейса FeaturePoint
    public void setFeature(String featureName, String value) {
        features.put(featureName, value);
    }
    
    public String getFeature(String featureName) {
        return features.get(featureName);
    }
    
    public boolean hasFeature(String featureName) {
        return features.containsKey(featureName);
    }
}