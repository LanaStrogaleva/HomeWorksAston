package HomeWorks.task2;

public interface Perimeter {
    default int perimeter(int side1, int side2, int side3) {
            return side1 + side2 + side3;
    }

    default int perimeter(int side1, int side2) {
        return (side1+side2)*2;
    }

    default double perimeter(int radius) {
            return Math.round(2 * Math.PI * radius);
    }

}
