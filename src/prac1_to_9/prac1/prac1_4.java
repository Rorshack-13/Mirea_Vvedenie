package prac1_to_9.prac1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class prac1_4 {
    public static void main(String[] args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print("Введите количество элементов в массиве: ");
                n = sc.nextInt();

                if (n <= 0) {
                    System.out.println("размер должен быть > 0");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Ошибка. Введите целое число");
                sc.next();
            }
        } while (n <= 0);

        int[] a = new int[n];

        System.out.println("Введите эл массива; ");
        int i = 0;

        do {
            try {
                a[i] = sc.nextInt();
                i++;
            }
            catch (InputMismatchException e) {
                System.out.println("Ошибка. Введите целое число");
                sc.next();
            }
        } while (i<n);

        i = 0;
        int sum = 0;
        int max = a[0];
        int min = a[0];
        System.out.print("Массив");
        while (i<n) {
            System.out.print(a[i] + " ");
            sum+=a[i];
            if (max < a[i]) {
                max = a[i];
            }
            if (min > a[i]) {
                min = a[i];
            }
            i++;

        }
        System.out.println();
        System.out.println("Сумма: " + sum);
        System.out.println("макс: " + max);
        System.out.println("мин: " + min);
    }
}