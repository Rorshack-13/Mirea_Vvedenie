package prac10_to_19.prac18.prac18_4;

import java.util.Scanner;

public class Expection3 {
    public void expectionDemo() {
        Scanner mysc = new Scanner(System.in);
        System.out.print("Enter in integer");
        try {
            String intString = mysc.next();
            int i = Integer.parseInt(intString);
            System.out.println(2/i);
        } catch (ArithmeticException | NumberFormatException e) {
            System.out.println("Error\t" + e.getMessage());
        } finally {
            expectionDemo();
        }

    }

    public static void main(String[] args) {
        Expection3 obj = new Expection3();
        obj.expectionDemo();
    }
}
