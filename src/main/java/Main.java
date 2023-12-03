import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        //Задание 1
        System.out.println("***************** Задание 1 ******************");

        // Генерируем список случайных целых чисел:
        int[] randomArray = Main.generateRandomIntArray(50, 10);
        System.out.println(Arrays.toString(randomArray));
        // Считаем количество четных чисел
        IntStream intStream = Arrays.stream(randomArray);
        System.out.println(intStream.filter(n -> n % 2 == 0).count());

        // Задание 2
        System.out.println("***************** Задание 2 ******************");
        ArrayList<String> words = new ArrayList<>();
        Collections.addAll(words, "Highload", "High", "Load", "Highload");

        // Сколько раз встречается слово "High"
        System.out.println(words.stream().filter(n -> n.equals("High")).count());

        // Какой элемент в коллекции находится на первом месте. Если пусто, то пусть возвращается 0
        System.out.println(words.stream().findFirst().orElse("0"));

        // Какой элемент в коллекции находится на последнем месте. Если пусто, то пусть возвращается 0
        System.out.println(words.stream().reduce((a, b) -> b).orElse("0"));

        // Задание 3
        System.out.println("***************** Задание 3 ******************");

        Stream<String> elements = Arrays.stream(new String[]{"f10", "f15", "f2", "f4", "f4"});
        System.out.println(Arrays.toString(elements.sorted((a, b) -> {
            int c = parseInt(a.substring(1));
            int d = parseInt(b.substring(1));
            return c - d;
        }).toArray()));

        // Задание 4
        System.out.println("***************** Задание 4 ******************");
        Students students = new Students();
        System.out.println(students.students);

        // Средний возраст студентов мужского пола
        Stream<Students> studentsStream = Stream.of(students);
        studentsStream.forEach(s ->
                System.out.println("Средний возраст: " + s.students.stream().filter(ss -> ss.getGender().equals("MAN")).reduce(0, (a, x) ->
                        a + x.getAge(), Integer::sum) / s.students.size()));

        // Кому из студентов (от 18 до 27 лет) грозит получение повестки:
        System.out.println("Кто получит повестку:");
        Stream<Students> studentsStream1 = Stream.of(students);
        studentsStream1.forEach(s ->
                s.students.stream().filter(ss -> ss.getGender().equals("MAN") &&
                        ss.getAge() > 17 && ss.getAge() < 28).forEach(System.out::println));
        // Задание 5
        System.out.println("***************** Задание 5 ******************");

        String input;
        Scanner in = new Scanner(System.in);
        List<String> stringList = new ArrayList<>();

        do {
            System.out.println("Enter login");
            input = in.nextLine();
            stringList.add(input);
        } while (!input.isEmpty());

        stringList.stream().filter(l -> l.startsWith("f")).forEach(System.out::println);


    }

    // Задание 1
    private static int[] generateRandomIntArray(int max, int length) {
        int[] array = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(max);
        }
        return array;
    }


}





