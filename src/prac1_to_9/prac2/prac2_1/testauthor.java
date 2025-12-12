package prac1_to_9.prac2.prac2_1;

import java.util.Scanner;

public class testauthor {
    public static void main(String[] args) {
        String email;

        author k1 = new author("Erdem", "pompaev@mail.ru", 'M');
        System.out.println(k1.toString());

        System.out.print("Введите почту:");
        Scanner sc = new Scanner(System.in);
        email = sc.next();
        k1.setEmail(email);
        System.out.println(k1.toString());
    }
}
