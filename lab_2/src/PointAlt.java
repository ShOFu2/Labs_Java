/*
 * Класс, описывающий изменённую сущность Точка
 */
public final class PointAlt {
// Поля
    private int x;
    private int y;

    // Свойства
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    // Конструкторы
    public PointAlt(PointAlt point) {
        setX(point.x);
        setY(point.y);
    }

    public PointAlt(int x, int y) {
        setX(x);
        setY(y);
    }
    
    // Методы
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}