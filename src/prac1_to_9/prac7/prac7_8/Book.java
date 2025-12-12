package prac1_to_9.prac7.prac7_8;

class Book implements Printable {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public void print() {
        System.out.println("Книга: " + title + " (Автор: " + author + ")");
    }

    public String getTitle() {
        return title;
    }

    public static void printBooks(Printable[] printables) {
        System.out.println("=== СПИСОК КНИГ ===");

        for (Printable printable : printables) {
            if (printable instanceof Book) {
                Book book = (Book) printable;
                System.out.println("Книга: " + book.getTitle());
            }
        }

        System.out.println("===================");
    }
}

class Magazine implements Printable {
    private String name;
    private int issue;

    public Magazine(String name, int issue) {
        this.name = name;
        this.issue = issue;
    }

    @Override
    public void print() {
        System.out.println("Журнал: " + name + " (Выпуск: " + issue + ")");
    }
}

class Newspaper implements Printable {
    private String name;
    private String date;

    public Newspaper(String name, String date) {
        this.name = name;
        this.date = date;
    }

    @Override
    public void print() {
        System.out.println("Газета: " + name + " (Дата: " + date + ")");
    }
}