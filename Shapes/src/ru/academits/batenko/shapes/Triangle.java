package ru.academits.batenko.shapes;

import java.util.Objects;

public class Triangle implements Shape {
    private final double x1;
    private final double y1;

    private final double x2;
    private final double y2;

    private final double x3;
    private final double y3;

    public Triangle(double x1, double y1,
                    double x2, double y2,
                    double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public double getWidth() {
        return Math.max(Math.max(x1, x2), x3) - Math.min(Math.min(x1, x2), x3);
    }

    @Override
    public double getHeight() {
        return Math.max(Math.max(y1, y2), y3) - Math.min(Math.min(y1, y2), y3);
    }

    @Override
    public double getArea() {
        double perimeterHalf = this.getPerimeter() / 2;

        return Math.sqrt(perimeterHalf
                * (perimeterHalf - getSideLength(x1, y1, x2, y2)
                * (perimeterHalf - getSideLength(x2, y2, x3, y3)
                * (perimeterHalf - getSideLength(x3, y3, x1, y1)))));
    }

    @Override
    public double getPerimeter() {
        return getSideLength(x1, y1, x2, y2)
                + getSideLength(x2, y2, x3, y3)
                + getSideLength(x3, y3, x1, y1);
    }

    private double getSideLength(double segmentBeginX, double segmentBeginY,
                                 double segmentEndX, double segmentEndY) {
        return Math.sqrt(Math.pow(segmentEndX - segmentBeginX, 2) + Math.pow(segmentEndY - segmentBeginY, 2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(x1, triangle.x1) == 0 &&
                Double.compare(y1, triangle.y1) == 0 &&
                Double.compare(x2, triangle.x2) == 0 &&
                Double.compare(y2, triangle.y2) == 0 &&
                Double.compare(x3, triangle.x3) == 0 &&
                Double.compare(y3, triangle.y3) == 0;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        hash = prime * hash + Double.hashCode(x1);
        hash = prime * hash + Double.hashCode(y1);
        hash = prime * hash + Double.hashCode(x2);
        hash = prime * hash + Double.hashCode(y2);
        hash = prime * hash + Double.hashCode(x3);
        return prime * hash + Double.hashCode(y3);
    }

    @Override
    public String toString() {
        return "Triangle {\n" +
                "\thash = " + hashCode() + "\n" +
                "\tx1 = " + x1 + "\n" +
                "\ty1 = " + y1 + "\n" +
                "\tx2 = " + x2 + "\n" +
                "\ty2 = " + y2 + "\n" +
                "\tx3 = " + x3 + "\n" +
                "\ty3 = " + y3 +
                "\n}";
    }
}