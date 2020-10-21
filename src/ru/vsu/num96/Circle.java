package ru.vsu.num96;

public class Circle {
    //a и b(x, y) - координаты центра окружности
    public double a;
    public double b;
    public double r;

    Circle(double a, double b, double r) {
        this.a = a;
        this.b = b;
        this.r = r;
    }

    boolean isPointInside(double x, double y) {
        return Math.pow(r, 2) > Math.pow((x - a), 2) + Math.pow((y - b), 2);
    }
}
