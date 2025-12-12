package prac10_to_19.prac13.prac13_5;

public class PhoneNumber {
    public static String formatPhoneNumber(String phone) {
        if (phone.startsWith("+") && phone.length() == 12) {
            String code = phone.substring(0, 2); // +76

            String num = phone.substring(2); // 9175655655
            return code + " " + num.substring(0, 3) + " " + num.substring(3, 6) + " " + num.substring(6);
        }
        else if (phone.startsWith("8") && phone.length() == 11) {
            String num = phone.substring(1); // 9175655655
            return "+7 " + num.substring(0, 3) + " " + num.substring(3, 6) + " " + num.substring(6);
        }
        return "Неверный формат";
    }

    public static void main(String[] args) {
        System.out.println(formatPhoneNumber("+79175655655"));
        System.out.println(formatPhoneNumber("89175655655"));
    }
}