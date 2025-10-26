package ru.Daripov.geometry;
/*
 * Класс, описывающий подвид сущности Точка, который имеет координату z
 */

public final class PointZ extends Point{
    // поля
    private int z;
    
    // свойства
    public void setZ (int z) {
        this.z = z;
    }

    public int getZ (){
        return this.z;
    }

    // конструкторы
    public PointZ () {
        super();
        setZ(0);
    }

    public PointZ (int x, int y, int z) {
        super(x,y);
        this.z = z;
    }

    public PointZ (PointZ point) {
        super(point);
        setZ(point.z);
    }

    public PointZ (Point point) {
        super(point);
        setZ(0);
    }

    public PointZ (Point point, int z) {
        super(point);
        setZ(z);
    }

    public PointZ (int x, int y) {
        super(x,y);
        setZ(0);
    }
    
    // Методы
    @Override
    public String toString () {
        return "{" + getX() + ";" + getY() + ";" + z + "}";
    }
}