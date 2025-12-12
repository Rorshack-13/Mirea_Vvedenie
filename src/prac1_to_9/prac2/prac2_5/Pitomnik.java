package prac1_to_9.prac2.prac2_5;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

public class Pitomnik {
    private Dog[] dogs;

    public Pitomnik() {
        dogs = new Dog[0];
    }

    public void addDog(Dog dog) {
        Dog[] newArray = Arrays.copyOf(dogs, dogs.length + 1);
        newArray[dogs.length] = dog;
        dogs = newArray;
    }
    public void printAllDogs() {
        if (dogs.length == 0) {
            System.out.println("\n" + "В питомнике нет собак" + "\n");
            return;
        }

        System.out.println("Список собак" + "\n");
        for (int i = 0; i< dogs.length; i++) {
            System.out.println((i+1) + "." + dogs[i].toString());
            dogs[i].perevod();
        }
    }
    public static void main(String[] args) {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        Pitomnik pitomnik = new Pitomnik();
        while (true) {
            System.out.println("\n" + "Выберите действие" + "\n");
            System.out.println("1.Добавить собаку" + "\n");
            System.out.println("2.Показать всех собак" + "\n");
            System.out.println("3.Выйти");

            do {
                try {
                    System.out.println("\n" + "Введите число: ");
                    choice = sc.nextInt();

                    if (choice <= 0 || choice > 3) {
                        System.out.println("Число должно быть > 0 и меньше 3");
                    }
                }
                catch (InputMismatchException e) {
                    System.out.println("Ошибка. Введите целое число");
                    sc.next();
                }
            }while (choice <= 0);

            switch (choice) {
                case 1:
                    Dog newDog = Dog.dobav();
                    pitomnik.addDog(newDog);
                    System.out.println("Собака добавлена");
                    break;
                case 2:
                    pitomnik.printAllDogs();
                    break;
                case 3:
                    System.out.println("До свидания");
                    sc.close();
                    return;
            }
        }
    }
}