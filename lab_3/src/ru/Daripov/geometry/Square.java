package ru.Daripov.geometry;
/*
 * Класс, описывающий сущность Квадрат
 */

public final class Square {
    // поля
    private Point tLCorner;
    private int side;

    // свойства
    public void setCorner (Point corner) {
        Point cornerCopy = corner;
        this.tLCorner = cornerCopy;
    }

    public void setSide (int side) {
        int sideCopy = side;
        this.side = sideCopy;
    }

    public BreakLine getBreakLine () {
        Point tRCorner = new Point(tLCorner.getX() + side, tLCorner.getY());
        Point bRCorner = new Point(tRCorner.getX(), tRCorner.getY() - side);
        Point bLCorner = new Point(bRCorner.getX() - side, bRCorner.getY());

        Point[] squarePoints = new Point[]{tLCorner, bLCorner, bRCorner, tRCorner};
        BreakLine square = new BreakLine(squarePoints);

        return square;
    }

    // конструкторы
    public Square (Point corner, int side) {
        setCorner(corner);
        setSide(side);
    }

    public Square (int x, int y, int side) {
        setCorner(new Point(x,y));
        setSide(side);
    }

    // методы
    @Override
    public String toString () {
        return "Квадрат в точке " + tLCorner + " со стороной " + side;
    }
}
