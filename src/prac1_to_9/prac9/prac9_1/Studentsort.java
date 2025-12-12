package prac1_to_9.prac9.prac9_1;

class Student {
    private int iDNumber;
    private String name;

    public Student(int iDNumber, String name) {
        this.iDNumber = iDNumber;
        this.name = name;
    }

    public int getIDNumber() {
        return iDNumber;
    }

    public String getName() {
        return name;
    }
}
public class Studentsort {

    public static void insertionSortWithSteps(Student[] students) {

        for (int i = 1; i < students.length; i++) {
            Student current = students[i];
            int j = i - 1;

            while (j >= 0 && students[j].getIDNumber() > current.getIDNumber()) {
                students[j + 1] = students[j];
                j--;
            }
            students[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student(5, "Студент A"),
                new Student(2, "Студент B"),
                new Student(4, "Студент C"),
                new Student(1, "Студент D"),
                new Student(3, "Студент E")
        };

        System.out.println("Исходный массив:");
        for (Student s : students) {
            System.out.println("ID: " + s.getIDNumber() + ", Name: " + s.getName());
        }
        System.out.println();

        insertionSortWithSteps(students);

        System.out.println("Финальный отсортированный массив:");
        for (Student s : students) {
            System.out.println("ID: " + s.getIDNumber() + ", Name: " + s.getName());
        }
    }
}