package ru.Daripov.geometry;
/*
 * Класс, описывающий сущность Линия
 */

public final class Line implements Cloneable{
    // Поля
    private Point start;
    private Point end;

    // Свойства
    public void setStart (Point start) {
        this.start = new Point(start);
    }
    
    public void setEnd (Point end) {
        this.end = new Point(end);
    }

    public Point getStart () {
        return new Point(this.start);
    }
    
    public Point getEnd () {
        return new Point(this.end);
    }
    
    public double getLength () {
        double x1 = this.getStart().getX();
        double y1 = this.getStart().getY();

        double x2 = this.getEnd().getX();
        double y2 = this.getEnd().getY();
    
        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1,2));
    }

    // Конструкторы
    public Line () {
        setStart(new Point(0, 0));
        setEnd(new Point(0, 0));
    }
    
    public Line (Point start, Point end) {
        setStart(start);
        setEnd(end);
    }

    public Line (Line line) {
        setStart(line.start);
        setEnd(line.end);
    }

    public Line (int x1, int y1, int x2, int y2) {
        this(new Point(x1,y1), new Point(x2,y2));
    }

    public Line (Point start) {
        this(start,new Point(0,0));
    }

    public Line (int x1, int y1, Point end) {
        this(new Point(x1,y1), end);
    }

    public Line (Point start, int x2, int y2) {
        this(start, new Point(x2,y2));
    }

    // Методы
    @Override
    public String toString () {
        return "Линия от " + start + " до " + end;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Line other = (Line) obj;

        return start.equals(other.start) && end.equals(other.end);
    }

    public boolean equalsIgnoreDirection(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Line other = (Line) obj;

        return (start.equals(other.start) && end.equals(other.end)) ||
               (start.equals(other.end) && end.equals(other.start));
    }

    @Override
    public Line clone() {
         try {
            Line cloned = (Line) super.clone();
            cloned.start = new Point(this.start);
            cloned.end = new Point(this.end);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Клонирование не поддерживается", e);
        }
    }
}