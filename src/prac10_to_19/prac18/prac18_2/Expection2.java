package prac10_to_19.prac18.prac18_2;

import java.util.Scanner;

public class Expection2 {
    public void expectionDemo() {
        Scanner mysc = new Scanner(System.in);
        System.out.print("Enter in integer");
        try {
            String intString = mysc.next();
            int i = Integer.parseInt(intString);
            System.out.println(2/i);
        } catch (ArithmeticException | NumberFormatException e) {
            System.out.println("Error  " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        Expection2 obj = new Expection2();
        obj.expectionDemo();
    }
}

//Qwerty - NumberFormatException
//0 - ArithmeticException
//1.2 - NumberFormatException
//1 - все нормально
