package prac10_to_19.prac17.prac17_1;

import java.io.*;
import java.util.*;

class StudentList {
    private List<Student> students;

    public StudentList() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Студент добавлен в картотеку!");
    }

    public boolean removeStudent(String studentId) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getStudentId().equals(studentId)) {
                iterator.remove();
                System.out.println("Студент удален из картотеки!");
                return true;
            }
        }
        System.out.println("Студент с таким номером билета не найден!");
        return false;
    }

    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("Картотека пуста!");
            return;
        }

        System.out.println("\n=== КАРТОТЕКА СТУДЕНТОВ ===");
        for (int i = 0; i < students.size(); i++) {
            System.out.println("Студент #" + (i + 1));
            students.get(i).display();
        }
    }

    public void clear() {
        students.clear();
        System.out.println("Картотека очищена!");
    }

    public boolean isEmpty() {
        return students.isEmpty();
    }

    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Student student : students) {
                writer.println(student.getName() + ";" +
                        student.getAge() + ";" +
                        student.getStudentId() + ";" +
                        student.getGroup());
            }
            System.out.println("Данные сохранены в файл: " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении в файл: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            students.clear();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    Student student = new Student(
                            parts[0],
                            Integer.parseInt(parts[1]),
                            parts[2],
                            parts[3]
                    );
                    students.add(student);
                }
            }
            System.out.println("Данные загружены из файла: " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке из файла: " + e.getMessage());
        }
    }

    public Student findStudent(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    public int getCount() {
        return students.size();
    }
}
