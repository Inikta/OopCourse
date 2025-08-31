package ru.academits.batenko.shapes;

public class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getWidth() {
        return 2 * radius;
    }

    @Override
    public double getHeight() {
        return 2 * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Circle circle = (Circle) o;

        return Double.compare(radius, circle.radius) == 0;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        return prime * hash + Double.hashCode(radius);
    }

    @Override
    public String toString() {
        return "Circle {\n" +
                "\thash = " + hashCode() + "\n" +
                "\tradius = " + radius +
                "\n}";
    }
}