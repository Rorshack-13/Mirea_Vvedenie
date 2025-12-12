package prac1_to_9.prac6.prac6_3;

public class Tester {
    public static void main(String[] args) {
        Nameable[] nameables = {
                new Planet("Земля", 6371.0),
                new Planet("Юпитер", 71492.0),
                new Car("Porsche 911 Turbo S", "Porsche", 1922),
                new Car("Audi A1", "Audi", 2010),
                new Animals("Шастя", "Кошка", 6),
                new Animals("Глаша", "Собака", 11),
                new People("Эрдем", "M", 19),
                new People("Вера", "Ж", 18),
                new Book("На дне", "М. Горький", 1902),
                new Book("Мастер и Маргарита", "М. Булгаков", 1940)
        };

        System.out.println("Имена объектов");
        System.out.println("=".repeat(30));

        for (Nameable nameable : nameables) {
            System.out.println("Имя: " + nameable.getName());

            if (nameable instanceof Planet) {
                Planet planet = (Planet) nameable;
                System.out.println("Тип: Планета");
                System.out.println("Радиус: " + planet.getRadius() + " км" );
            } else if (nameable instanceof Car) {
                Car car = (Car) nameable;
                System.out.println("Тип: Машина");
                System.out.println("Марка: " + car.getMark() + "\nГод выпуска: " + car.getGod());
            } else if (nameable instanceof Animals) {
                Animals animals = (Animals) nameable;
                System.out.println("Тип: Животное");
                System.out.println("Вид: " + animals.getVid() + "\nВозраст: " + animals.getAge() + " лет");
            } else if (nameable instanceof People) {
                People people = (People) nameable;
                System.out.println("Тип: Человек");
                System.out.println("Пол: " + people.getPol() + "\nВозраст: " + people.getAge());
            } else if (nameable instanceof Book) {
                Book book = (Book) nameable;
                System.out.println("Тип: Книга");
                System.out.println("Автор: " + book.getAuthor() + "\nГод выпуска: " + book.getGod());
            }

            System.out.println("=".repeat(30));
        }
    }
}
