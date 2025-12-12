package prac20_to_28.prac20.prac20_4;

public class Test {
    public static void main(String[] args) {
        Integer[] intArray = {5, 2, 9, 1, 7};
        MinMax<Integer> minMax = new MinMax<>(intArray);
        System.out.println("Минимальный: " + minMax.findMin());
        System.out.println("Максимальный: " + minMax.findMax());

        System.out.println("\nКалькулятор:");
        System.out.println("Сумма: " + Calculator.sum(10, 5.5));
        System.out.println("Умножение: " + Calculator.multiply(3.14, 2));
        System.out.println("Деление: " + Calculator.divide(10.0, 2.5));
        System.out.println("Вычитание: " + Calculator.subtraction(100, 75.5));
    }
}