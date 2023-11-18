package HomeWorks.task2;

public class Circle extends Figures implements Perimeter, Square {
    int radius;
    public Circle(int radius, String backgroundColor, String borderColor) {
        super(backgroundColor, borderColor);
        this.radius = radius;
    }


    @Override
    public double square() {
        return Math.round(Math.PI * radius * radius);
    }

    @Override
    public String commonInfo() {
        return "Фигура Круг (Периметр: " + perimeter(radius) + ", площадь: " + square() + ", цвет фона: " + backgroundColor + ", цвет границ: " + borderColor + ")";
    }
}
