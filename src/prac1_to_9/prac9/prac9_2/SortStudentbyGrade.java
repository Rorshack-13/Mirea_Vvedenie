package prac1_to_9.prac9.prac9_2;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Student {
    private String name;
    private int id;
    private double grade;

    public Student(String name, int id, double grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return String.format("Имя: %s , id = %d, grade = %.2f}",name,id,grade);
    }
}

class Sort implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s2.getGrade(), s1.getGrade());
    }

    public void quiclSort(List<Student> students) {
        if (students == null || students.size() <= 1) {
            return;
        }
        quickSort(students,0,students.size() - 1);
    }

    private void quickSort(List<Student> students, int low, int high) {
        if (low < high) {
            int opornindex = razdel(students, low, high);

            quickSort(students,low,opornindex - 1);
            quickSort(students,opornindex + 1,high);
        }
    }

    private int razdel(List<Student> students, int low, int high) {
        Student oporn = students.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (compare(students.get(j), oporn) < 0) {
                i++;

                swap(students, i, j);
            }
        }
        swap(students, i+1,high);
        return i+1;
    }

    private void swap(List<Student> students, int i, int j) {
        Student temp = students.get(i);
        students.set(i,students.get(j));
        students.set(j,temp);
    }
}

public class SortStudentbyGrade {
    public static void printStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        List<Student> studentsList = new ArrayList<>(Arrays.asList(
                new Student("Student 1", 1, 3.8),
                new Student("Student 2", 2, 4.5),
                new Student("Student 3", 3, 3.2),
                new Student("Student 4", 4, 4.9),
                new Student("Student 5", 5, 4.1),
                new Student("Student 6", 6, 3.9)
        ));

        System.out.println("\nИсходный список:\n");
        printStudents(studentsList);

        Sort gradeComparator = new Sort();
        gradeComparator.quiclSort(studentsList);
        System.out.println("\nОтсортированный список по убыванию:\n");
        printStudents(studentsList);


    }
}