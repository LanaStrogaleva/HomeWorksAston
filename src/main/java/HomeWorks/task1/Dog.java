package HomeWorks.task1;

import HomeWorks.task1.Animal;

public class Dog extends Animal {
    private final int MAX_RUN_DISTANCE = 500;
    private final int MAX_SWIM_DISTANCE = 10;
    public static int numberOfDogs = 0;
    public Dog(String name) {
        super(name);
        numberOfDogs++;
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
        if(distance <= MAX_SWIM_DISTANCE) {
            System.out.println(name + " проплыл " + distance + " м." );
        } else {
            System.out.println(name + " не может проплыть больше " + MAX_SWIM_DISTANCE + " м.");
        }
    }
}
