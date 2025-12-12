package prac1_to_9.prac6.prac6_6;

class Document implements Printable {
    private String name;
    private int pageCount;

    public Document(String name, int pageCount) {
        this.name = name;
        this.pageCount = pageCount;
    }

    @Override
    public void print() {
        System.out.println("=== Информация о документе ===");
        System.out.println("Название: " + name);
        System.out.println("Количество страниц: " + pageCount);
        System.out.println("=".repeat(30));
    }
}
