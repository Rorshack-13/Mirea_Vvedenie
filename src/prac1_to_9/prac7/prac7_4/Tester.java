package prac1_to_9.prac7.prac7_4;

public class Tester {
    public static void main(String[] args) {
        MathFunc math = new MathFunc();

        System.out.println("=== Тестирование ===");
        System.out.println("Число PI из интерфейса: " + MathCalculable.PI);
        System.out.println();

        System.out.println("1. Возведение в степень");
        System.out.println("2^3 = " + math.power(2, 3));
        System.out.println("5^2 = " + math.power(5, 2));
        System.out.println("4^0.5 = " + math.power(4, 0.5));
        System.out.println("10^-2 = " + math.power(10, -2));
        System.out.println();

        System.out.println("2. Модуль комплексного числа");
        System.out.println("|3 + 4i| = " + math.complexModulus(3, 4));
        System.out.println("|1 + 1i| = " + math.complexModulus(1, 1));
        System.out.println();

        System.out.println("3. Длина окружности");
        double radius1 = 5.0;
        double length1 = math.circleLength(radius1);
        System.out.printf("Длина окружности с радиусом %.1f = %.2f%n", radius1, length1);

        double radius2 = 10.0;
        double length2 = math.circleLength(radius2);
        System.out.printf("Длина окружности с радиусом %.1f = %.2f%n", radius2, length2);
        System.out.println();

        System.out.println("Полиморфизм");
        MathCalculable calculator = new MathFunc();
        System.out.println("2^4 = " + calculator.power(2, 4));
        System.out.println("|6 + 8i| = " + calculator.complexModulus(6, 8));
    }
}
