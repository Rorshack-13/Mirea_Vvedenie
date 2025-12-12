package prac1_to_9.prac6.prac6_6;

public class tester {
    public static void main(String[] args){
        Printable book = new Book("Война и мир", "Лев Толстой", 1869, 4600);
        Printable document = new Document("Налоговый отчет", 15);

        book.print();
        System.out.println();
        document.print();

    }
}
