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

        if (testPoints(picture)) {
            start(picture);
        } else {
            System.out.println("Tests passed incorrectly. The program does not start.");
        }
    }

    private static void start(Picture picture) {
        double x = readDouble("x --> ");
        double y = readDouble("y --> ");

        Point point = new Point(x, y);
        SimpleColor color = picture.getColor(point);

        printColorForPoint(point, color);

    }

    private static boolean testPoints(Picture picture) {
        TestCase[] testCases = {new TestCase(-1, 2, SimpleColor.GREEN), new TestCase(3, 3,
                SimpleColor.YELLOW), new TestCase(5, 5, SimpleColor.ORANGE), new TestCase(-8, 6,
                SimpleColor.WHITE), new TestCase(0, -6, SimpleColor.GRAY), new TestCase(5, -5,
                SimpleColor.BLUE)};

        boolean result = true;
        for (int i = 0; i < testCases.length; i++) {
            TestCase testCase = testCases[i];
            Point point = new Point(testCase.getX(), testCase.getY());
            SimpleColor color = picture.getColor(point);
            SimpleColor correctColor = testCase.getCorrectColor();

            boolean check = checkResult(color, correctColor);
            result = check && result;

            printTest(color, correctColor, point, result);
        }
        return result;
    }

    private static boolean checkResult(SimpleColor color, SimpleColor correctColor) {
        return color == correctColor;
    }

    private static double readDouble(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter coordinate %s ", name);
        return scanner.nextDouble();
    }

    private static void printTest(SimpleColor color, SimpleColor correctColor, Point point, boolean result) {
        System.out.printf("x = %1$.1f; y = %2$.1f is point in " + color + "\nCorrect color --> " + correctColor + "" +
                "\nResult: " + result + "\n", point.x, point.y);
        System.out.println("-------------------");
    }

    private static void printColorForPoint(Point point, SimpleColor color) {
        System.out.printf("x = %1$.1f; y = %2$.1f is point in " + color + "\n", point.x, point.y);
    }
}
