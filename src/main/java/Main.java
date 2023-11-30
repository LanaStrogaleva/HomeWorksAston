import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Задание 1
        String[] array = {"кот", "собака", "рыбка", "хомяк", "попугай", "эублефар", "кот", "черепашка", "рыбка", "рыбка", "хомяк", "улитка"};

        ArrayList<String> list = new ArrayList<>(Arrays.asList(array));

        // Весь список
        System.out.println("Весь список: " + list);
        // Уникальный список
        System.out.println("Уникальный список: " + new HashSet<>(list));

        // Сколько раз встречается каждое слово (Способ 1)
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < list.size(); i++) {
            int count = 1;
            if (map.containsKey(list.get(i))) {
                continue;
            }
            String name = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                if (name.equals(list.get(j))) {
                    count += 1;
                }
            }
            map.put(name, count);
        }

        System.out.println("Сколько раз встречается каждое слово (способ1): " + map);

        // Сколько раз встречается каждое слово (Способ 2)
        LinkedHashMap<String, Integer> map1 = new LinkedHashMap<>();

        for (String l : list) {
            if (map1.containsKey(l)) {
                map1.replace(l, map1.get(l) + 1);
            } else {
                map1.put(l, 1);
            }

        }

        System.out.println("Сколько раз встречается каждое слово (способ2): " + map1);

        System.out.println("**************************************************************************");

        //Задание 2
        PhoneBook phoneBook = new PhoneBook();

        // Добавляем записи в телефонную книгу
        phoneBook.add("Васечкин", "5555555");
        phoneBook.add("Иванов", "1111111");
        phoneBook.add("Петров", "2222222");
        phoneBook.add("Иванов", "4444444");
        phoneBook.add("Сидоров", "4444444");
        phoneBook.add("Иванов", "7777777");

        System.out.println(phoneBook);

        // Получить номера телефонов по фамилии
        String secondName = "Иванов";
        System.out.println("Фамилия  " + secondName + " :"+ phoneBook.get(secondName));

    }


}
