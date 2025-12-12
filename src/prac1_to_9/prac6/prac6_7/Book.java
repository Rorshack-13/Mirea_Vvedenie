package prac1_to_9.prac6.prac6_7;

class Book implements Printable {
    private String name;
    private String author;
    private int year;
    private int pageCount;

    public Book (String name, String author, int year, int pageCount) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.pageCount = pageCount;
    }

    @Override
    public void print() {
        System.out.println("=== Информация о книге ===");
        System.out.println("Название: " + name);
        System.out.println("Автор: " + author);
        System.out.println("Год: " + year);
        System.out.println("Количество страниц: " + pageCount);
        System.out.println("=".repeat(30));
    }

    public String getContent() {
        return "Книга " + name + " автора " + author;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}

    public int getYear() {return year;}
    public void setYear(int year) {this.year = year;}

    public int getPageCount() {return pageCount;}
    public void setPageCount(int pageCount) {this.pageCount = pageCount;}

}
