package prac1_to_9.prac2.prac2_5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {return name;}
    public int getAge() {return  age;}

    public void setName(String name) { this.name = name;}
    public void setAge(int age) { this.age = age;}


    public void perevod() {
        System.out.print("  В человеческих: " + age * 7 + "\n");
    }

    public static Dog dobav() {
        int age = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите кличку собаки:");
        String name = sc.nextLine();
        do {
            try {
                System.out.println("Введите возраст собаки: ");
                age = sc.nextInt();

                if (age <= 0) {
                    System.out.println("Возраст должен быть >0");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Ошибка. Введите целое число");
                sc.next();
            }
        }while(age <= 0);

        return new Dog(name, age);
    }

    @Override
    public String toString() {
        return "Кличка: " + name + "\n" + "  Возраст: " + age;
    }
}