package ru.academits.batenko.range_main;

import ru.academits.batenko.range.Range;

public class RangeProgram1 {
    public static void main(String[] args) {
        Range range = new Range(5.5, 28.3);

        System.out.printf("Начало отрезка %.3f.\nКонец отрезка: %.3f.\n\n", range.getFrom(), range.getTo());

        System.out.printf("Длина отрезка: %.3f.\n\n", range.getRangeLength());

        double doubleNumber = 7.8;

        if (range.isInside(doubleNumber)) {
            System.out.printf("Число %.3f находится внутри границ отрезка.\n", doubleNumber);
        } else {
            System.out.printf("Число %.3f не находится внутри границ отрезка.\n", doubleNumber);
        }
    }
}