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

        testPoints(picture);

        double x = readDouble("x --> ");
        double y = readDouble("y --> ");

        SimpleColor color = picture.getColor(x, y);

        printColorForPoint(x, y, color);
    }
    
    static void testPoints(Picture picture) {
        double[][] point = {{-1, 3, 5, -8, 0, 5}, {2, 3, 5, 6, -6, -5}};
        SimpleColor[] correctResults = {SimpleColor.GREEN, SimpleColor.YELLOW, SimpleColor.ORANGE, SimpleColor.WHITE,
                SimpleColor.GRAY, SimpleColor.BLUE};

        for (int i = 0; i < point[0].length; i++) {
            SimpleColor color = picture.getColor(point[0][i], point[1][i]);
            printColorForPoint(point[0][i], point[1][i], color);
            SimpleColor correctColor = correctResults[i];

            System.out.println(checkResult(color, correctColor));
        }
    }

    static boolean checkResult(SimpleColor color, SimpleColor correctColor) {
        return color == correctColor;
    }

    static double readDouble(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter coordinate %s ", name);
        return scanner.nextDouble();
    }

    static void printColorForPoint(double x, double y, SimpleColor color) {
        System.out.printf("x = %1$.1f; y = %2$.1f is point in "+ color +"\n", x, y);
    }
}
