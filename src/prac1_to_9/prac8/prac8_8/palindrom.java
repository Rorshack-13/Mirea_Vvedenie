package prac1_to_9.prac8.prac8_8;

import java.util.Scanner;

public class palindrom {
    public static boolean isPalindrome(String str, int left, int right) {
        if (left >= right) {
            return true;
        }

        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }

        return isPalindrome(str, left + 1, right - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите слово:");
        String word = scanner.nextLine().toLowerCase();

        if (word.isEmpty()) {
            System.out.println("YES");
        } else {
            boolean result = isPalindrome(word, 0, word.length() - 1);
            System.out.println(result ? "YES" : "NO");
        }

        scanner.close();
    }
}
