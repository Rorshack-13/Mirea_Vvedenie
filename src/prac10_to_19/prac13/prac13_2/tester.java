package prac10_to_19.prac13.prac13_2;

public class tester {
    public static void main(String[] args) {
        Person[] persons = {
                new Person("Иванов", "Иван", "Иванович"),
                new Person("Петров", "Петр"),
                new Person("Сидоров"),
                new Person("Кузнецов", null, "Сергеевич"),
                new Person("", "Анна", "Владимировна"),
                new Person("Смирнов", "", "Петрович")
        };

        for (Person person : persons) {
            System.out.println("Результат: '" + person.getFullName() + "'");
        }
    }
}