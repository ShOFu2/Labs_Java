/*
 * Класс, описывающий сущность Линия
 */
public final class Line {
    // Поля
    private Point start;
    private Point end;
    private PointAlt startAlt;
    private PointAlt endAlt;

    // Свойства
    public void setStart(Point start) {
        this.start = start;
    }
    
    public void setStart(PointAlt start) {
        this.startAlt = start;
    }
    
    public void setEnd(Point end) {
        this.end = end;
    }

    public void setEnd(PointAlt end) {
        this.endAlt = end;
    }

    public Point getStart() {
        return this.start;
    }

    public PointAlt getStartAlt() {
        return this.startAlt;
    }

    public Point getEnd() {
        return this.end;
    }    

    public PointAlt getEndAlt() {
        return this.endAlt;
    }

    // Конструкторы
    public Line() {
        setStart(new Point(0, 0));
        setEnd(new Point(0, 0));
    }
    
    public Line(Point start, Point end) {
        setStart(start);
        setEnd(end);
    }

    public Line(Line line) {
        setStart(line.start);
        setEnd(line.end);
    }

    public Line(PointAlt start, PointAlt end) {
        setStart(start);
        setEnd(end);
    }

    public Line(int x1, int y1, int x2, int y2) {
        this(new Point(x1,y1), new Point(x2,y2));
    }

    public Line(Point start) {
        this(start,new Point(0,0));
    }

    public Line(int x1, int y1, Point end) {
        this(new Point(x1,y1), end);
    }

    public Line(Point start, int x2, int y2) {
        this(start, new Point(x2,y2));
    }

    // Методы
    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }

    public String toStringAlt() {
        return "Линия от " + startAlt + " до " + endAlt;
    }

    public double getLength() {
        double x1 = this.getStartAlt().getX();
        double y1 = this.getStartAlt().getY();

        double x2 = this.getEndAlt().getX();
        double y2 = this.getEndAlt().getY();

        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1,2));
    }
}