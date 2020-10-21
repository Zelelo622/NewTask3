package ru.vsu.num96;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Picture picture = new Picture(
                new Circle(-2, 0, 4),
                new Line(4, -2),
                new Parabola(-1.0 / 8, 5.0 / 4, 7.0 / 8),
                new Parabola(-1.0 / 4, -2, -2),
                new Parabola(1.0 / 8, -3.0 / 4, 25.0 / 8)
        );

        test(picture);

        double x = readDouble("x --> ");
        double y = readDouble("y --> ");

        printColorForPoint(x, y, picture);
    }

    static void test(Picture picture) {
        double[][] point = {{-1, 3, 5, -8, 0, 5}, {2, 3, 5, 6, -6, -5}};

        for (int i = 0; i < 6; i++) {
            printColorForPoint(point[0][i], point[1][i], picture);
        }
    }

    static double readDouble(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter coordinate %s ", name);
        return scanner.nextDouble();
    }

    static void printColorForPoint(double x, double y, Picture picture) {
        System.out.printf("x = %1$.1f; y = %2$.1f is point in " + picture.getColor(x, y) + "\n", x, y);
    }
}
