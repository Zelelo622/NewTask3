package ru.vsu.num96;

public class Line {
    public double k;
    public double b;

    Line(double k, double b) {
        this.k = k;
        this.b = b;
    }

    boolean isPointInside(double x, double y) {
        return y > k * x + b;
    }
}
