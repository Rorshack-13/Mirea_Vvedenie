package prac1_to_9.prac3.prac3_2;

public class obolochka {
    public static void main(String[] args) {

        Double q = Double.valueOf(2.33);
        Double w = Double.valueOf("12.12");

        System.out.println("1. Объекты типа Double: \n" + q + "\n" + w + "\n");

        String x = "123.34";
        Double dx = Double.parseDouble(x);

        System.out.println("Переобразованная строка x в Double: " + dx + "\n");

        Double num = 12.478634;

        byte bnum = num.byteValue();
        short snum = num.shortValue();
        int inum = num.intValue();
        long lnum = num.longValue();
        float fnum = num.floatValue();
        double dnum = num.doubleValue();
        boolean boolnum = (num != 0);

        System.out.println("Преобразования Double к примитивным типам данных: ");
        System.out.println("byte: " + bnum);
        System.out.println("short: " + snum);
        System.out.println("int: " + inum);
        System.out.println("long: " + lnum);
        System.out.println("float: " + fnum);
        System.out.println("double: " + dnum);
        System.out.println("boolean: " + boolnum + "\n");

        String s = Double.toString(3.1415926);
        System.out.println("5. Преобразование double литерала к строке: ");
        System.out.println("Тип переменной d: " + s.getClass().getSimpleName());
        System.out.println("Значение переменной d: \"" + s + "\"");


    }
}