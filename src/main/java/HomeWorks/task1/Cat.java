package HomeWorks.task1;

public class Cat extends Animal {
    private final int MAX_RUN_DISTANCE = 200;
    public static int numberOfCats = 0;

    public boolean fullness;
    public int stomachCapacity;

    // конструктор по имени
    public Cat(String name) {
        super(name);
        numberOfCats++;
    }
    //
    public Cat(String name, int stomachCapacity) {
        super(name);
        fullness = false;
        this.stomachCapacity = stomachCapacity;
    }

    @Override
    public void run(int distance) {
        if(distance <= MAX_RUN_DISTANCE) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать больше " + MAX_RUN_DISTANCE + " м.");
        }
    }
    @Override
    public void swim(int distance) {
            System.out.println(name + " не умеет плавать!");
    }

    public void eat(Plate plate) {
        if (stomachCapacity <= plate.getMealQuantity() && !fullness) {
            fullness = true;
            plate.decreaseMeal(stomachCapacity);
        }
    }
}
