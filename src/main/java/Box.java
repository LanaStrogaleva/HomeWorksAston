import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruitList;

    public Box() {
        this.fruitList = new ArrayList<>();
    }

    public void addFruit(T fruit, Integer count) {
        if (this.fruitList.isEmpty() || (this.fruitList.get(0).getClass() == fruit.getClass())) {
            for (int i = 0; i < count; i++) {
                fruitList.add(fruit);
            }
        } else {
            System.out.println("Нельзя смешивать фрукты разных типов");
        }
    }

    public double getWeight() {
        if (this.fruitList.isEmpty()) {
            return 0;
        } else {
            return this.fruitList.get(0).getAvgWeight() * this.fruitList.size();
        }
    }

    public boolean compare(Box<?> another) {
        return Math.abs(this.getWeight() - another.getWeight()) < 0.0001;
    }

    public boolean isTransfer(Box<?> another) {
        if (another.fruitList.isEmpty()) {
            return true;
        }
        if (this.fruitList.isEmpty()) {
            return false;
        }
        return this.fruitList.get(0).getClass() == (another.fruitList.get(0).getClass());

    }

    public String transferFruits(Box<T> fillingBox) {
        String message;
        if (isTransfer(fillingBox)) {
            fillingBox.fruitList.addAll(this.fruitList);
            this.fruitList.clear();
            message = "Фрукты пересыпаны из одной коробки в другую.";
            return message;
        } else {
            message = "Не возможно пересыпать содержимое коробки. Коробки отличаются по типу.";
            return message;
        }
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruits=" + fruitList +
                '}';
    }


}
