package prac1_to_9.prac8.prac8_3;

import java.util.Scanner;

public class rangeab {
    public static void printRange(int a, int b) {
        if (a == b) {
            System.out.print(a);
            return;
        }

        if (a < b) {
            System.out.print(a + " ");
            printRange(a + 1, b);
        }

        else {
            System.out.print(a + " ");
            printRange(a - 1, b);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число A:");
        int a = scanner.nextInt();

        System.out.println("Введите число B:");
        int b = scanner.nextInt();

        System.out.println("Числа от " + a + " до " + b + ":");
        printRange(a, b);

        scanner.close();
    }
}