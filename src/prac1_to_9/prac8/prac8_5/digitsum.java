package prac1_to_9.prac8.prac8_5;

import java.util.Scanner;

public class digitsum {
    public static int sumOfDigits(int n) {
        if (n < 10) {
            return n;
        }

        return n % 10 + sumOfDigits(n / 10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите натуральное число N:");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Число должно быть натуральным (положительным)!");
        } else {
            int result = sumOfDigits(n);
            System.out.println("Сумма цифр числа " + n + " = " + result);
        }

        scanner.close();
    }
}
