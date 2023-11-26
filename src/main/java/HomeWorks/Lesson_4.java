package HomeWorks;

public class Lesson_4 {
    public static void main(String[] args) {
        // Задание 1

        Employee[] emplArray = new Employee[5];
        emplArray[0] = new Employee("Petrova Anna Ivanovna", "QA Engineer", "anna@mail.ru", 50000, 35);
        emplArray[1] = new Employee("Ivanov Viktor Semenovich", "AQA Engineer", "vikt@mail.ru", 70000, 41);
        emplArray[2] = new Employee("Levina Elena Petrovna", "Designer", "anna@mail.ru", 47000, 27);
        emplArray[3] = new Employee("Sidorov Egor Ivanovich", "JAVA Developer", "anna@mail.ru", 66000, 45);
        emplArray[4] = new Employee("Timofeeva Irina Ivanovna", "Product Manager", "anna@mail.ru", 55000, 32);

        for (Employee employee : emplArray) {
            if (employee.age > 40) {
                Employee.printEmployeeInfo(employee);
            }
        }
        System.out.println("***********************************************************************************");

        // Задание 2

        Park.Attraction carousel = new Park().new Attraction("Карусель", "с 10.00 до 16.00", 600);
        System.out.println("Название атракциона: " + carousel.name);
        System.out.println("Время работы: " + carousel.workTime);
        System.out.println("Цена: " + carousel.price);
    }

}
