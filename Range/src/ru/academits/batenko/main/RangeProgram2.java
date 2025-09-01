package ru.academits.batenko.main;

import ru.academits.batenko.range.Range;

public class RangeProgram2 {
    public static void main(String[] args) {
        Range range1 = new Range(3.5, 7.3);
        Range range2 = new Range(3.5, 5.3);

        Range intersection = range1.getIntersection(range2);

        if (intersection == null) {
            System.out.println("Отрезки никак не пересекаются.");
            System.out.println();
        } else {
            System.out.printf("Отрезки имеют пересечение: от %.3f до %.3f.", intersection.getFrom(), intersection.getTo());
            System.out.println();
        }

        Range[] union = range1.getUnion(range2);

        if (union.length == 1) {
            System.out.printf("Объединение отрезков: от %.3f и до %.3f.", union[0].getFrom(), union[0].getTo());
            System.out.println();
        } else {
            System.out.printf("Объединение отрезков: от %.3f и до %.3f и от %.3f и до %.3f.", union[0].getFrom(), union[0].getTo(), union[1].getFrom(), union[1].getTo());
            System.out.println();
        }

        Range[] difference = range1.getDifference(range2);

        if (difference.length == 0) {
            System.out.println("Разность отрезков равна 0.");
            System.out.println();
            System.out.println();
        } else if (difference.length == 1) {
            System.out.printf("Разность отрезков равна отрезку от %.3f и до %.3f.", difference[0].getFrom(), difference[0].getTo());
            System.out.println();
            System.out.println();
        } else {
            System.out.printf("Разность отрезков равна двум отрезкам: от %.3f и до %.3f и от %.3f и до %.3f.", difference[0].getFrom(), difference[0].getTo(), difference[1].getFrom(), difference[1].getTo());
            System.out.println();
            System.out.println();
        }
    }
}