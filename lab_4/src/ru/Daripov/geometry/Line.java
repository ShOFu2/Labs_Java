package ru.Daripov.geometry;

/*
 * Класс, описывающий сущность Линия с поддержкой 2D и 3D точек
 */
public final class Line<T extends Point> implements Cloneable {
    // Поля
    private T start;
    private T end;

    // Свойства
    public void setStart(T start) {
        this.start = start;
    }
    
    public void setEnd(T end) {
        this.end = end;
    }

    public T getStart() {
        return start;
    }
    
    public T getEnd() {
        return end;
    }
    
    public double getLength() {
        double x1 = start.getX();
        double y1 = start.getY();
        double x2 = end.getX();
        double y2 = end.getY();
        
        // Для 3D точек вычисляем расстояние в трехмерном пространстве
        if (start instanceof PointZ && end instanceof PointZ) {
            PointZ start3D = (PointZ) start;
            PointZ end3D = (PointZ) end;
            double z1 = start3D.getZ();
            double z2 = end3D.getZ();
            return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2));
        }
        
        // Для 2D точек вычисляем расстояние на плоскости
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // Конструкторы для 2D точек
    public Line() {
        this.start = (T) new Point(0, 0);
        this.end = (T) new Point(0, 0);
    }
    
    public Line(T start, T end) {
        this.start = start;
        this.end = end;
    }

    public Line(Line<T> line) {
        this.start = line.start;
        this.end = line.end;
    }

    public Line(int x1, int y1, int x2, int y2) {
        this.start = (T) new Point(x1, y1);
        this.end = (T) new Point(x2, y2);
    }

    public Line(T start) {
        this.start = start;
        this.end = (T) new Point(0, 0);
    }

    public Line(int x1, int y1, T end) {
        this.start = (T) new Point(x1, y1);
        this.end = end;
    }

    public Line(T start, int x2, int y2) {
        this.start = start;
        this.end = (T) new Point(x2, y2);
    }

    // Конструкторы для 3D точек
    public Line(PointZ start3D, PointZ end3D) {
        this.start = (T) start3D;
        this.end = (T) end3D;
    }

    public Line(int x1, int y1, int z1, int x2, int y2, int z2) {
        this.start = (T) new PointZ(x1, y1, z1);
        this.end = (T) new PointZ(x2, y2, z2);
    }

    // Методы
    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Line<?> other = (Line<?>) obj;

        return start.equals(other.start) && end.equals(other.end);
    }

    public boolean equalsIgnoreDirection(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Line<?> other = (Line<?>) obj;

        return (start.equals(other.start) && end.equals(other.end)) ||
               (start.equals(other.end) && end.equals(other.start));
    }

    @Override
    public Line<T> clone() {
        try {
            Line<T> cloned = (Line<T>) super.clone();
            // Создаем копии точек с сохранением типа
            if (start instanceof PointZ) {
                cloned.start = (T) new PointZ((PointZ) start);
                cloned.end = (T) new PointZ((PointZ) end);
            } else {
                cloned.start = (T) new Point(start);
                cloned.end = (T) new Point(end);
            }
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Клонирование не поддерживается", e);
        }
    }

    public String getPointType() {
        if (start instanceof PointZ) {
            return "3D";
        } else {
            return "2D";
        }
    }

    public boolean is3D() {
        return start instanceof PointZ;
    }

    public boolean is2D() {
        return start instanceof Point;
    }
}