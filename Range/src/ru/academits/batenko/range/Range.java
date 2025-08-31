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

    public double getRangeLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public Range getRangesIntersection(Range anotherRange) {
        if (anotherRange.to <= this.from || anotherRange.from >= this.to) {
            return null;
        }

        double intersectionRangeBegin;
        double intersectionRangeEnd;

        intersectionRangeBegin = Math.max(anotherRange.from, this.from);

        intersectionRangeEnd = Math.min(anotherRange.to, this.to);

        return new Range(intersectionRangeBegin, intersectionRangeEnd);
    }

    public Range[] getRangesUnion(Range anotherRange) {
        if (anotherRange.to < this.from || anotherRange.from > this.to) {
            return new Range[]{this, anotherRange};
        }

        double unionRangeBegin = 0;
        double unionRangeEnd = 0;

        if (anotherRange.from <= this.to) {
            unionRangeBegin = Math.min(anotherRange.from, this.from);

            unionRangeEnd = Math.max(anotherRange.to, this.to);
        }

        return new Range[]{new Range(unionRangeBegin, unionRangeEnd)};
    }

    public Range[] getRangesDifference(Range anotherRange) {
        Range[] difference = new Range[2];

        if (anotherRange.to <= this.from || anotherRange.from >= this.to) {
            return new Range[0];
        }

        if (anotherRange.from <= this.from && anotherRange.to >= this.to) {
            return new Range[0];
        }

        Range intersection = this.getRangesIntersection(anotherRange);

        if (this.from < intersection.from) {
            difference[0] = new Range(this.from, intersection.from);
        }

        if (this.to > intersection.to) {
            int index = 0;

            if (difference[0] != null) {
                index++;
            }

            difference[index] = new Range(intersection.to, this.to);
        }

        if (difference[1] == null) {
            return new Range[]{difference[0]};
        } else {
            return difference;
        }
    }
}