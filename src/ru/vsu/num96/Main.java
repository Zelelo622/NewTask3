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

        finishProgramToFailedTest(testPoints(picture));

        double x = readDouble("x --> ");
        double y = readDouble("y --> ");

        Point point = new Point(x, y);
        SimpleColor color = picture.getColor(point);

        printColorForPoint(point, color);
    }

    private static boolean testPoints(Picture picture) {
        Point[] point = {new Point(-1, 2), new Point(3, 3), new Point(5, 5),
                new Point(-8, 6), new Point(0, -6), new Point(5, -5)};
        SimpleColor[] correctResults = {SimpleColor.GREEN, SimpleColor.YELLOW, SimpleColor.ORANGE, SimpleColor.WHITE,
                SimpleColor.GRAY, SimpleColor.BLUE};

        boolean result = true;
        for (int i = 0; i < point.length; i++) {
            SimpleColor color = picture.getColor(point[i]);
            SimpleColor correctColor = correctResults[i];

            if (color != correctColor) {
                printTest(color, correctColor, point[i], "INCORRECT");
                result = false;
            } else {
                printTest(color, correctColor, point[i], "CORRECT");
            }
        }
        return result;
    }

    private static void finishProgramToFailedTest(boolean result) {
        if (!result) {
            System.out.println("The tests did not work correctly.");
            System.exit(-1);
        }
    }

    private static double readDouble(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter coordinate %s ", name);
        return scanner.nextDouble();
    }

    private static void printTest(SimpleColor color, SimpleColor correctColor, Point point, String result) {
        System.out.printf("x = %1$.1f; y = %2$.1f is point in " + color + "\nCorrect color --> " + correctColor + "" +
                "\nResult: " + result + "\n", point.x, point.y);
        System.out.println("-------------------");
    }

    private static void printColorForPoint(Point point, SimpleColor color) {
        System.out.printf("x = %1$.1f; y = %2$.1f is point in " + color + "\n", point.x, point.y);
    }
}
