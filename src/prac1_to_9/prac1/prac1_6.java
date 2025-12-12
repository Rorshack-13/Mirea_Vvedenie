package prac1_to_9.prac1;

public class prac1_6 {
    public static void main(String[] args) {
        System.out.println("первые 10 чисел гармоническог ряда");

        double har = 0.0;

        for (int i = 1; i <=10; i++) {
            har += 1.0/i;
            System.out.printf("H(%d) = %.2f%n", i , har);
        }
    }
}
