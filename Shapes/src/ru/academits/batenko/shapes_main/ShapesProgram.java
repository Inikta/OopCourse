package ru.academits.batenko.shapes_main;

import ru.academits.batenko.shapes.*;

import java.util.Arrays;

public class ShapesProgram {
    public static void main(String[] args) {
        Square square1 = new Square(5.5);
        Square square2 = new Square(8.75);

        Triangle triangle = new Triangle(
                -1.1, 1.1,
                5.7, 5.8,
                1.4, 1.2);

        Rectangle rectangle = new Rectangle(6, 3);

        Circle circle1 = new Circle(6.6);
        Circle circle2 = new Circle(2.22);

        Shape[] shapes = {square1, square2, triangle, rectangle, circle1, circle2};

        Shape largestAreaShape = getTheLargestAreaShape(shapes);
        Shape secondLargestPerimeterShape = getTheSecondLargestPerimeterShape(shapes);

        System.out.println("Фигура с наибольшей площадью:\n" + largestAreaShape.toString());
        System.out.println();
        System.out.println("Фигура со вторым по длине периметром:\n" + secondLargestPerimeterShape.toString());
    }

    public static Shape getTheLargestAreaShape(Shape[] shapes) {
        Arrays.sort(shapes, (o1, o2) -> {
            double area1 = o1.getArea();
            double area2 = o2.getArea();

            return Double.compare(area2, area1);
        });

        return shapes[0];
    }

    public static Shape getTheSecondLargestPerimeterShape(Shape[] shapes) {
        Arrays.sort(shapes, (o1, o2) -> {
            double perimeter1 = o1.getPerimeter();
            double perimeter2 = o2.getPerimeter();

            return Double.compare(perimeter2, perimeter1);
        });

        return shapes[1];
    }
}