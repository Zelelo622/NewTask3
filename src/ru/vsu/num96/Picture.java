package ru.vsu.num96;

public class Picture {
    private final Circle circle;
    private final Line line;
    private final Parabola parabola1;
    private final Parabola parabola2;
    private final Parabola parabola3;

    public Picture(Circle circle, Line line, Parabola parabola1, Parabola parabola2, Parabola parabola3) {
        this.circle = circle;
        this.line = line;
        this.parabola1 = parabola1;
        this.parabola2 = parabola2;
        this.parabola3 = parabola3;
    }

    public SimpleColor getColor(Point point) {
        double x = point.x;
        double y = point.y;
        //---------------------------------ОКРУЖНОСТЬ-----------------------------
        //верхний (маленький)
        if (circle.isPointInside(x, y) && line.isPointInside(x, y) && parabola1.isPointInside(x, y) &&
                parabola2.isPointInside(x, y) && parabola3.isPointInside(x, y)) {
            return SimpleColor.GRAY;
        }
        //верхний
        if (circle.isPointInside(x, y) && line.isPointInside(x, y) && parabola2.isPointInside(x, y) &&
                parabola1.isPointInside(x, y)) {
            return SimpleColor.GREEN;
        }
        if (circle.isPointInside(x, y) && parabola2.isPointInside(x, y) && line.isPointInside(x, y)) {
            return SimpleColor.ORANGE;
        }
        //левый
        if (circle.isPointInside(x, y) && line.isPointInside(x, y) && parabola1.isPointInside(x, y)) {
            return SimpleColor.GRAY;
        }
        if (circle.isPointInside(x, y) && line.isPointInside(x, y)) {
            return SimpleColor.BLUE;
        }
        //правая
        if (parabola2.isPointInside(x, y) && circle.isPointInside(x, y)) {
            return SimpleColor.GRAY;
        }
        //нижний
        if (circle.isPointInside(x, y)) {
            return SimpleColor.GREEN;
        }
        //-------------------------------------------------------------------------
        //Верхняя часть(обширная)
        if (parabola3.isPointInside(x, y) && parabola1.isPointInside(x, y)) {
            return SimpleColor.ORANGE;
        }
        if (parabola1.isPointInside(x, y) && x > 3) {
            return SimpleColor.ORANGE;
        }
        if (parabola3.isPointInside(x, y)) {
            return SimpleColor.YELLOW;
        }
        if (line.isPointInside(x, y) && !parabola1.isPointInside(x, y)) {
            return SimpleColor.ORANGE;
        }
        if (!line.isPointInside(x, y) && !parabola2.isPointInside(x, y)) {
            return SimpleColor.GRAY;
        }
        if (parabola2.isPointInside(x, y) && x < 0) {
            return SimpleColor.WHITE;
        }
        return SimpleColor.BLUE;
    }
}
