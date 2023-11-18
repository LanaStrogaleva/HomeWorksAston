package HomeWorks.task1;

public class Animal {
    public String name;
    public static int numberOfAnimals = 0;


    public Animal(String name) {
        this.name = name;
        numberOfAnimals++;
    }
    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " м." );
    }

    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " м." );
    }
}
