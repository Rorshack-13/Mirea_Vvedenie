package prac1_to_9.prac9.prac9_3;

import java.util.Arrays;
import java.util.List;

import static prac1_to_9.prac9.prac9_3.MergeSortStudents.mergeAndSort;

public class tester {
    public static void main(String[] args) {

        List<Student> list1 = Arrays.asList(
                new Student("Иван Иванов", 101),
                new Student("Петр Петров", 105),
                new Student("Мария Сидорова", 103)
        );

        List<Student> list2 = Arrays.asList(
                new Student("Анна Козлова", 102),
                new Student("Сергей Смирнов", 104),
                new Student("Ольга Новикова", 106)
        );

        List<Student> sortedStudents = mergeAndSort(list1, list2);

        System.out.println("Объединенный отсортированный список студентов:");
        for (Student student : sortedStudents) {
            System.out.println(student);
        }
    }
}