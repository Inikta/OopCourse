package ru.academits.batenko.main;

import ru.academits.batenko.range.Range;

public class RangeProgram1 {
    public static void main(String[] args) {
        Range range = new Range(5.5, 28.3);

        System.out.printf("Начало отрезка %.3f.", range.getFrom());
        System.out.println();
        System.out.printf("Конец отрезка: %.3f.", range.getTo());
        System.out.println();
        System.out.println();

        System.out.printf("Длина отрезка: %.3f.", range.getLength());
        System.out.println();
        System.out.println();

        double doubleNumber = 7.8;

        if (range.isInside(doubleNumber)) {
            System.out.printf("Число %.3f находится внутри границ отрезка.", doubleNumber);
            System.out.println();
        } else {
            System.out.printf("Число %.3f не находится внутри границ отрезка.", doubleNumber);
            System.out.println();
        }
    }
}