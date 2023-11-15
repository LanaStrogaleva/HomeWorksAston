package HomeWorks;

public class Employee {
    String fullName;
    String position;
    String email;
    int salary;
    int age;

    public Employee(String fullName, String position, String email, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.salary = salary;
        this.age = age;
    }


    public static void printEmployeeInfo(Employee employee) {
        System.out.println("ФИО: " + employee.fullName);
        System.out.println("Должность: " + employee.position);
        System.out.println("E-mail: " + employee.email);
        System.out.println("Зарплата: " + employee.salary);
        System.out.println("Возраст: " + employee.age);
    }
}
