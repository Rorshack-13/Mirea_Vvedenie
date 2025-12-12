package prac1_to_9.prac1;

public class prac1_7 {
    public static long factor(int a) {

        if (a<0) {
            System.out.println("Число должно быть > 0");
        }

        long fact = 1;
        for (int i = 1;i<=a;i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        System.out.printf("Факториал: " + factor(4));
    }
}
