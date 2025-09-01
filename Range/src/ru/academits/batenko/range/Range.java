package ru.academits.batenko.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public Range getIntersection(Range range) {
        double intersectionFrom = Math.max(range.from, from);
        double intersectionTo = Math.min(range.to, to);

        if (intersectionFrom >= intersectionTo) {
            return null;
        }

        return new Range(intersectionFrom, intersectionTo);
    }

    public Range[] getUnion(Range range) {
        if (range.to < from || range.from > to) {
            return new Range[]{this, range};
        }

        return new Range[]{new Range(Math.min(range.from, from), Math.max(range.to, to))};
    }

    public Range[] getDifference(Range range) {
        if (range.from > from && range.to < to) {
            return new Range[]{new Range(from, range.from), new Range(range.to, to)};
        }

        if (range.from < from && range.to > to) {
            return new Range[]{new Range(range.from, from), new Range(to, range.to)};
        }

        if (range.from < from && range.to == to) {
            return new Range[]{new Range(range.from, from)};
        }

        if (range.from == from && range.to > to) {
            return new Range[]{new Range(to, range.to)};
        }

        if (range.from > from && range.to == to) {
            return new Range[]{new Range(from, range.from)};
        }

        if (range.from == from && range.to < to) {
            return new Range[]{new Range(range.to, to)};
        }

        return new Range[0];
    }
}