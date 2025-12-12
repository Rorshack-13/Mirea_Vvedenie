package prac10_to_19.prac13.prac13_1;

public class StringTask {

    public static void StringTest(String str) {
        System.out.println("1. Исходная строка " + str);

        char LastChar = str.charAt(str.length() - 1);
        System.out.println("1. " + LastChar);

        boolean endstest = str.endsWith("!!!");
        System.out.println("3. Заканчивается на '!!!': " + endstest);

        boolean startstest = str.startsWith("I like");
        System.out.println("4. Начинается с 'I like': " + startstest);

        boolean containsJava = str.contains("Java");
        System.out.println("5. Содержит 'Java': " + containsJava);

        int javaPosition = str.indexOf("Java");
        System.out.println("6. Позиция 'Java': " + javaPosition);

        String replacedString = str.replace('a', 'o');
        System.out.println("7. После замены 'а' на 'о': " + replacedString);

        String upperCaseString = str.toUpperCase();
        System.out.println("8. В верхнем регистре: " + upperCaseString);

        String lowerCaseString = str.toLowerCase();
        System.out.println("9. В нижнем регистре: " + lowerCaseString);

        if (javaPosition != -1) {
            String javaSubstring = str.substring(javaPosition, javaPosition + 4);
            System.out.println("10. Вырезанная подстрока 'Java': '" + javaSubstring + "'");
        } else {
            System.out.println("10. Подстрока 'Java' не найдена");
        }

    }

    public static void main(String[] args) {
        String testString = "I like Java!!!";
        StringTest(testString);

    }
}