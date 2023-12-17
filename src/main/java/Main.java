public class Main {
    public static void main(String[] args) {

        // Создаем коробку и добавляем в нее яблоки:
        Box<Fruit> applesBox = new Box<>();
        applesBox.addFruit(new Apple());
        applesBox.addFruit(new Apple());
        applesBox.addFruit(new Apple());
        System.out.println(applesBox);

        // Создаем коробку и добавляем в нее апельсины:
        Box<Fruit> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        System.out.println(orangeBox);

        // Пробуем добавить в коробку с яблоками апельсины:
        applesBox.addFruit(new Orange());

        //Посчитаем вес коробки с яблоками:
        System.out.println("Вес коробки с яблоками:  " + applesBox.getWeight());

        //Посчитаем вес коробки с апельсинами:
        System.out.println("Вес коробки с апельсинами:  " + orangeBox.getWeight());

        //Сравним вес коробки апельсинов с весом коробки яблок
        if (orangeBox.compare(applesBox)) {
            System.out.println("Коробки равны по весу");
        } else {
            System.out.println("Коробки отличаются по весу");
        }

        // Добавим в коробку с яблоками 1 шт и снова сравним вес коробки апельсинов с весом коробки яблок
        applesBox.addFruit(new Apple());

        if (orangeBox.compare(applesBox)) {
            System.out.println("Коробки равны по весу");
        } else {
            System.out.println("Коробки отличаются по весу");
        }

        //Пробуем пересыпать коробку с яблоками в коробку с апельсинами
        System.out.println(applesBox.transferFruits(orangeBox));

        // Пробуем пересыпать коробку с яблоками в коробку с яблоками:
        Box<Fruit> anotherAppleBox = new Box<>();
        anotherAppleBox.addFruit(new Apple());
        System.out.println(applesBox.transferFruits(anotherAppleBox));
        System.out.println(anotherAppleBox);
        System.out.println(applesBox);

        // Пробуем пересыпать апельсины в освободившуюся из под яблок коробку:
        System.out.println(orangeBox.transferFruits(applesBox));
        System.out.println(applesBox);
        System.out.println(orangeBox);

    }
}
