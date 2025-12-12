package prac20_to_28.prac20.prac20_4;

public class Calculator {

    public static <N1 extends Number, N2 extends Number> double sum(N1 a, N2 b) {
        return a.doubleValue() + b.doubleValue();
    }

    public static <N1 extends Number, N2 extends Number> double multiply(N1 a, N2 b) {
        return a.doubleValue() * b.doubleValue();
    }

    public static <N1 extends Number, N2 extends Number> double divide(N1 a, N2 b) {
        if (b.doubleValue() == 0) {
            throw new ArithmeticException("Деление на ноль!");
        }
        return a.doubleValue() / b.doubleValue();
    }

    public static <N1 extends Number, N2 extends Number> double subtraction(N1 a, N2 b) {
        return a.doubleValue() - b.doubleValue();
    }
}