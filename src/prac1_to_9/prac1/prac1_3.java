package prac1_to_9.prac1;

public class prac1_3 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10};
        int summ = 0;

        System.out.print("Массив: ");
        for (int i = 0; i < a.length;i++) {
            System.out.print(a[i] + " ");
        }

        System.out.print("\n");

        for (int i = 0; i < a.length;i++) {
            summ+=a[i];
        }

        System.out.print("Cумма: " + summ + "\n");

        System.out.print("Среднее арифм. : " + summ/a.length);
    }
}
