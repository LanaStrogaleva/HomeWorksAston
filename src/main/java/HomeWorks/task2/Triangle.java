package HomeWorks.task2;

public class Triangle extends Figures implements Perimeter, Square {
    int side1;
    int side2;
    int side3;

    public Triangle(int side1, int side2, int side3, String backgroundColor, String borderColor) {
        super(backgroundColor, borderColor);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double square() {
        double halfPerimeter = (side1 + side2 + side3)/2.0;
        return Math.round(
                Math.sqrt(
                        halfPerimeter
                        * (halfPerimeter - side1)
                        * (halfPerimeter - side2)
                        * (halfPerimeter - side3)
                )
        );
    }

    @Override
    public String commonInfo() {
        return "Фигура Треугольник (Периметр: " + perimeter(side1, side2, side3) + ", площадь: " + square() + ", цвет фона: " + backgroundColor + ", цвет границ: " + borderColor + ")";
    }
}
