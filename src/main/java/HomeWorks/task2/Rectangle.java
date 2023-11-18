package HomeWorks.task2;

public class Rectangle extends Figures implements Perimeter, Square {
    int side1;
    int side2;

    public Rectangle(int side1, int side2, String backgroundColor, String borderColor) {
        super(backgroundColor, borderColor);
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public double square() {
        return side1 * side2;
    }

    @Override
    public String commonInfo() {
        return "Фигура Прямоугольник (Периметр: " + perimeter(side1, side2) + ", площадь: " + square() + ", цвет фона: " + backgroundColor + ", цвет границ: " + borderColor + ")";
    }
}
