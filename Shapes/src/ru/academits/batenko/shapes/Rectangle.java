package ru.academits.batenko.shapes;

public class Rectangle implements Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) o;

        return Double.compare(width, rectangle.width) == 0 &&
                Double.compare(height, rectangle.height) == 0;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        hash = prime * hash + Double.hashCode(width);
        return prime * hash + Double.hashCode(height);
    }

    @Override
    public String toString() {
        return "Rectangle {\n" +
                "\thash = " + hashCode() + "\n" +
                "\twidth = " + width + "\n" +
                "\theight = " + height +
                "\n}";
    }
}