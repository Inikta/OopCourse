package ru.academits.batenko.range_main;

import ru.academits.batenko.range.Range;

public class RangeProgram2 {
    public static void main(String[] args) {
        Range range1 = new Range(3.5, 7.3);
        Range range2 = new Range(3.5, 5.3);

        Range intersection = range1.getRangesIntersection(range2);

        if (intersection == null) {
            System.out.println("Отрезки никак не пересекаются.\n");
        } else {
            System.out.printf("Отрезки имеют пересечение: от %.3f до %.3f.\n", intersection.getFrom(), intersection.getTo());
        }

        Range[] union = range1.getRangesUnion(range2);

        if (union.length == 1) {
            System.out.printf("Объединение отрезков: от %.3f и до %.3f.\n", union[0].getFrom(), union[0].getTo());
        } else {
            System.out.printf("Объединение отрезков: от %.3f и до %.3f и от %.3f и до %.3f.\n", union[0].getFrom(), union[0].getTo(), union[1].getFrom(), union[1].getTo());
        }

        Range[] difference = range1.getRangesDifference(range2);

        if (difference.length == 0) {
            System.out.println("Разность отрезков равна 0.\n");
        } else if (difference.length == 1) {
            System.out.printf("Разность отрезков равна отрезку от %.3f и до %.3f.\n\n", difference[0].getFrom(), difference[0].getTo());
        } else {
            System.out.printf("Разность отрезков равна двум отрезкам: от %.3f и до %.3f и от %.3f и до %.3f.\n\n", difference[0].getFrom(), difference[0].getTo(), difference[1].getFrom(), difference[1].getTo());
        }
    }
}