package com.company;

public class Square extends Shape{

    // (x, y) coordinates of start drawing the square :) just for imagination
    private final Point corner;
    private final double size;

    public Square(Point corner, double size, Color color) {
        super(color);
        this.corner = corner;
        this.size = size;
    }

    public Point getCorner() {
        return corner;
    }

    public double size() {
        return size;
    }

    @Override
    public double getArea() {
        return size * size;
    }

    @Override
    public String toString() {
        return "Square{" +
                "corner=" + corner +
                "size=" + size +
                "area=" + getArea() +
                "color=" + getColor() +
                "}";
    }

}
