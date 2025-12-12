package prac1_to_9.prac3.prac3_3;

import java.util.Scanner;

public class valutconverter {
    public static final double EUR_R = 99.82;
    public static final double USD_R = 84.92;

    public static Scanner scanner = new Scanner(System.in);

    public static double convert(double value, String fromC, String toC){
        double usdV = toRUB(value, fromC);
        return fromRUB(usdV, toC);
    }


    private static double toRUB(double value, String valuta) {
        return switch (valuta.toUpperCase()) {
            case "USD" -> value*USD_R;
            case "EUR" -> value*EUR_R;
            case "RUB" -> value;
            default -> value;
        };
    }

    private static double fromRUB(double rubV, String valuta) {
        return switch (valuta.toUpperCase()) {
            case "USD" -> rubV / USD_R;
            case "EUR" -> rubV / EUR_R;
            case "RUB" -> rubV;
            default -> rubV;
        };
    }


    private static String validateCurrency() {
        while (true) {
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("USD") || input.equals("RUB") || input.equals("EUR")) {
                return input;
            }

            System.out.print("Неверная валюта! Введите USD, EUR, RUB: ");
        }
    }



    private static double validDouble() {
        while (true) {
            try {
                Double number = Double.parseDouble(scanner.nextLine());
                if (number >= 0) {
                    return number;
                } else {
                    System.out.print("Число не может быть отрицательным! Введите снова: ");
                }
            } catch (Exception e){
                System.out.print("Это не число! Введите снова: ");
            }
        }
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите сумму: ");
        double value = validDouble();

        System.out.print("Из валюты(USD/EUR/RUB): ");
        String from = validateCurrency();

        System.out.print("В валюту(USD/EUR/RUB): ");
        String to = validateCurrency();

        double result = convert(value, from, to);
        System.out.printf("\nРезультат: %.2f %s = %.2f %s%n",
                value, from.toUpperCase(), result, to.toUpperCase());
    }
}