package prac1_to_9.prac6.prac6_7;

public class tester {
    public static void main(String[] args) {
        Book book1 = new Book("Война и мир", "Лев Толстой", 1869, 4600);
        Printable book2 = new Book("На дне", "Максим Горький", 1902, 416);

        book1.print();
        System.out.println();

        book2.print();
        System.out.println();

        System.out.println(book1.getContent());
        System.out.println();

        System.out.println("Исходное кол-во страниц " + book1.getPageCount());
        book1.setPageCount(1832);
        System.out.println("Измененное кол-во страниц " + book1.getPageCount());


    }
}
