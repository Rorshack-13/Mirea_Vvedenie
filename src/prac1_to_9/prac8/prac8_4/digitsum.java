package prac1_to_9.prac8.prac8_4;

import java.util.Scanner;

public class digitsum {
    public static int countNumbers(int k, int s, int currentSum, int position, boolean isFirstDigit) {
        if (position == k) {
            return (currentSum == s) ? 1 : 0;
        }

        if (currentSum > s) {
            return 0;
        }

        int remainingDigits = k - position;
        if (currentSum + 9 * remainingDigits < s) {
            return 0;
        }

        int count = 0;

        for (int digit = 0; digit <= 9; digit++) {
            if (isFirstDigit && digit == 0) {
                continue;
            }

            count += countNumbers(k, s, currentSum + digit, position + 1, false);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите k (количество цифр):");
        int k = scanner.nextInt();

        System.out.println("Введите s (сумма цифр):");
        int s = scanner.nextInt();

        if (k <= 0 || s < 0) {
            System.out.println("Ошибка: k должно быть натуральным, s неотрицательным");
        } else {
            int result = countNumbers(k, s, 0, 0, true);
            System.out.println("Количество " + k + "-значных чисел с суммой цифр " + s + " = " + result);
        }

        scanner.close();
    }
}