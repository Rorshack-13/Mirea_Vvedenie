package prac10_to_19.prac14.prac14_2;

public class regexx2 {
    public static void main(String[] args) {
        String regex = "^abcdefghijklmnopqrstuv18340$";

        System.out.println("abcdefghijklmnopqrstuv18340".matches(regex));
        System.out.println("abcdefgsdfdsfdsfds123".matches(regex));
        System.out.println("abcdefgsd".matches(regex));
        System.out.println("".matches(regex));
    }
}
