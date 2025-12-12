package prac10_to_19.prac14.prac14_4;

import java.util.regex.*;

public class regexx4 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\d(?!\\+)");

        Matcher m1 = pattern.matcher("(1 + 8) – 9 / 4");
        System.out.println("(1 + 8) – 9 / 4: " + m1.find());

        Matcher m2 = pattern.matcher("6 / 5 – 2 * 9");
        System.out.println("6 / 5 – 2 * 9: " + m2.find());

        Matcher m3 = pattern.matcher("1+ 3+ 1+ 3+ 4+");
        System.out.println("1+ 3+ 1+ 3+ 4+: " + m3.find());
    }
}