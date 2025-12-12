package prac1_to_9.prac7.prac7_8;

public class Tester {
    public static void main(String[] args) {
        Printable[] printables = {
                new Book("Война и мир", "Лев Толстой"),
                new Magazine("Наука и техника", 15),
                new Book("1984", "Джордж Оруэлл"),
                new Newspaper("Комсомольская правда", "2024-01-15"),
                new Book("Мастер и Маргарита", "Михаил Булгаков"),
                new Magazine("Forbes", 3)
        };

        System.out.println("Все объекты:");

        for (Printable p : printables) {
            p.print();
        }

        System.out.println("\n" + "=".repeat(40) + "\n");

        Book.printBooks(printables);
    }
}
