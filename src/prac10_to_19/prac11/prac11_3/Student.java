package prac10_to_19.prac11.prac11_3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Student {
    private String name;
    private int age;
    private LocalDate birthDate;

    public Student(String name, int age, LocalDate birthDate) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
    }

    public Student(String name, LocalDate birthDate) {
        this(name, 0, birthDate);
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}
    public LocalDate getBirthDate() {return birthDate;}
    public void setBirthDate(LocalDate birthDate) {this.birthDate = birthDate;}


    public String getFormattedBirthDate(DateFormat format) {
        if (birthDate == null) {
            return "Дата рождения не указана";
        }

        DateTimeFormatter formatter;
        switch (format) {
            case SHORT:
                formatter = DateTimeFormatter.ofPattern("dd.MM.yy");
                break;
            case MEDIUM:
                formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                break;
            case FULL:
                formatter = DateTimeFormatter.ofPattern("d MMMM yyyy 'г.'", new Locale("ru"));
                break;
            case ISO:
                formatter = DateTimeFormatter.ISO_LOCAL_DATE;
                break;
            default:
                formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        }

        return birthDate.format(formatter);
    }

    @Override
    public String toString() {
        return String.format("Имя: %s, Возраст: %d, Дата рождения : %s",
                name, age, getFormattedBirthDate(DateFormat.MEDIUM));
    }


    public String toString(DateFormat format) {
        return String.format("Имя: %s, Возраст: %d, Дата рождения : %s",
                name, age, getFormattedBirthDate(format));
    }

    public enum DateFormat {
        SHORT,
        MEDIUM,
        FULL,
        ISO
    }

    public static void main(String[] args) {

        Student student = new Student("Иван Петров", 20, LocalDate.of(2003, 5, 15));

        System.out.println("Короткий формат: " + student.getFormattedBirthDate(Student.DateFormat.SHORT));
        System.out.println("Средний формат: " + student.getFormattedBirthDate(Student.DateFormat.MEDIUM));
        System.out.println("Полный формат: " + student.getFormattedBirthDate(Student.DateFormat.FULL));
        System.out.println("ISO формат: " + student.getFormattedBirthDate(Student.DateFormat.ISO));

        System.out.println("\nСтандартный toString():");
        System.out.println(student.toString());

        System.out.println("\nToString с полным форматом:");
        System.out.println(student.toString(Student.DateFormat.FULL));
    }

}
