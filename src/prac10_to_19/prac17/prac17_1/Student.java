package prac10_to_19.prac17.prac17_1;

import java.util.Scanner;

public class Student {
    private String name;
    private int age;
    private String id;
    private String group;

    public Student() {}

    public Student(String name, int age, String id, String group) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.group = group;
    }

    public void readfromconsole(Scanner scanner) {
        System.out.print("Введите имя студента: ");
        this.name = scanner.nextLine();

        System.out.print("Введите возраст: ");
        if (!scanner.hasNextInt()) {
            System.out.print("Пожалуйста введите возраст в виде числа");
            scanner.next();
        }
        this.age=scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введите номер студенческого билета: ");
        this.id = scanner.nextLine();

        System.out.print("Введите группу: ");
        this.group = scanner.nextLine();
    }

    public void display() {
        System.out.println("Имя: " + name);
        System.out.println("Возраст: " + age);
        System.out.println("Студенческий билет: " + id);
        System.out.println("Группа: " + group);
        System.out.println("------------------------");
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getStudentId() { return id; }
    public String getGroup() { return group; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id.equals(student.id);
    }
}
