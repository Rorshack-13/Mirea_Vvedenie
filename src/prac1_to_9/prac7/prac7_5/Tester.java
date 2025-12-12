package prac1_to_9.prac7.prac7_5;

public class Tester {
    public static void main(String[] args){
        RabotaSoStrokoi fer = new Stroki();

        String primer = "Hello, my name is Erdem!";

        System.out.println("Исходная строка: " + primer);

        int count = fer.StringCount(primer);
        System.out.println("а) количество символов: " + count);

        String nechet = fer.StringNechet(primer);
        System.out.println("б) символы в нечетных позициях: " + nechet);

        String invert = fer.Stringinvert(primer);
        System.out.println("в) инвертированная строка: " + invert);
    }
}
