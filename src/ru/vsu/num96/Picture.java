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

        if (circle.isPointInside(point) && line.isPointInside(point) && parabola1.isPointInside(point) &&
                parabola2.isPointInside(point) && parabola3.isPointInside(point)) {
            return SimpleColor.GRAY;
        }
        if (circle.isPointInside(point) && line.isPointInside(point) && parabola2.isPointInside(point) &&
                parabola1.isPointInside(point)) {
            return SimpleColor.GREEN;
        }
        if (circle.isPointInside(point) && parabola2.isPointInside(point) && line.isPointInside(point)) {
            return SimpleColor.ORANGE;
        }
        if (circle.isPointInside(point) && line.isPointInside(point) && parabola1.isPointInside(point)) {
            return SimpleColor.GRAY;
        }
        if (circle.isPointInside(point) && line.isPointInside(point)) {
            return SimpleColor.BLUE;
        }
        if (parabola2.isPointInside(point) && circle.isPointInside(point)) {
            return SimpleColor.GRAY;
        }
        if (circle.isPointInside(point)) {
            return SimpleColor.GREEN;
        }
        if (parabola3.isPointInside(point) && parabola1.isPointInside(point)) {
            return SimpleColor.ORANGE;
        }
        if (parabola1.isPointInside(point) && point.getX() > 3) {
            return SimpleColor.ORANGE;
        }
        if (parabola3.isPointInside(point)) {
            return SimpleColor.YELLOW;
        }
        if (line.isPointInside(point) && !parabola1.isPointInside(point)) {
            return SimpleColor.ORANGE;
        }
        if (!line.isPointInside(point) && !parabola2.isPointInside(point)) {
            return SimpleColor.GRAY;
        }
        if (parabola2.isPointInside(point) && point.getX() < 0) {
            return SimpleColor.WHITE;
        }
        return SimpleColor.BLUE;
    }
}
