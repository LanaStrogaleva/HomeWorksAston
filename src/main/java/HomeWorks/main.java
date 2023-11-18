package HomeWorks;

import HomeWorks.task1.Animal;
import HomeWorks.task1.Cat;
import HomeWorks.task1.Dog;
import HomeWorks.task1.Plate;
import HomeWorks.task2.Circle;
import HomeWorks.task2.Rectangle;
import HomeWorks.task2.Triangle;

public class main {
    public static void main(String[] args) {
        // Задание 1

        // создать котов:
        Cat felix = new Cat("Феликс");
        Cat barsik = new Cat("Барсик");

        // создать собак:
        Dog elvin = new Dog("Элвин");
        Dog druzhok = new Dog("Дружок");

        // создать животное:
        Animal cheburashka = new Animal("Чебурашка");

        // коты бегут
        felix.run(50);
        barsik.run(600);
        // коты плывут
        felix.swim(5);
        barsik.swim(10);

        // собаки бегут
        elvin.run(300);
        druzhok.run(900);
        // собаки плывут
        elvin.swim(8);
        druzhok.swim(20);

        // животное бежит
        cheburashka.run(2000);
        // животное плывет
        cheburashka.swim(5000);

        // подсчитали количество созданных котов, собак и животных:
        System.out.println("Создано котов: " + Cat.numberOfCats);
        System.out.println("Создано собак: " + Dog.numberOfDogs);
        System.out.println("Создано животных: " + Animal.numberOfAnimals);

        System.out.println("*****************************************");

        // создать массив котов
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Pushok", 50);
        cats[1] = new Cat("Snezhok", 10);
        cats[2] = new Cat("Barsik", 30);

        // создать тарелку с едой
        Plate plate = new Plate(30);

        // покормить котов из тарелки
        for (Cat cat : cats) {
            cat.eat(plate);
        }

        // вывести информацию о сытости котов
        for (Cat cat : cats) {
            System.out.println(cat.name + " сытость: " + cat.fullness);
        }

        System.out.println("*****************************************");
        // добавить корм в тарелку
        plate.addMeal(70);
        // снова покормить котов из тарелки
        for (Cat cat : cats) {
            cat.eat(plate);
        }

        // вывести информацию о сытости котов
        for (Cat cat : cats) {
            System.out.println(cat.name + " сытость: " + cat.fullness);
        }

        // Задание 2
        System.out.println("************* Задание 2 ************");

        // создать треугольник
        Triangle triangle = new Triangle(3, 5, 7,"красный", "зеленый");
        System.out.println(triangle.commonInfo());
        // создать прямоугольник
        Rectangle rectangle = new Rectangle(2,4,"жёлтый", "голубой");
        System.out.println(rectangle.commonInfo());
        // создать круг
        Circle circle = new Circle(5, "синий", "розовый");
        System.out.println(circle.commonInfo());
    }
}
