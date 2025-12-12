package prac10_to_19.prac17.prac17_2;

import java.io.*;

class DoublyLinkedList {
    private StudentNode head;
    private StudentNode tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addStudent(Student student) {
        StudentNode newNode = new StudentNode(student);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        size++;
        System.out.println("Студент добавлен в картотеку!");
    }

    public boolean removeStudent(String studentId) {
        if (isEmpty()) {
            System.out.println("Картотека пуста!");
            return false;
        }

        StudentNode current = head;

        while (current != null) {
            if (current.getStudent().getStudentId().equals(studentId)) {
                removeNode(current);
                System.out.println("Студент удален из картотеки!");
                return true;
            }
            current = current.getNext();
        }

        System.out.println("Студент с таким номером билета не найден!");
        return false;
    }

    private void removeNode(StudentNode node) {
        if (node.getPrev() != null) {
            node.getPrev().setNext(node.getNext());
        } else {
            head = node.getNext();
        }

        if (node.getNext() != null) {
            node.getNext().setPrev(node.getPrev());
        } else {
            tail = node.getPrev();
        }

        size--;
    }

    public void displayAll() {
        if (isEmpty()) {
            System.out.println("Картотека пуста!");
            return;
        }

        System.out.println("\n=== КАРТОТЕКА СТУДЕНТОВ ===");
        StudentNode current = head;
        int index = 1;

        while (current != null) {
            System.out.println("Студент #" + index);
            current.getStudent().display();
            current = current.getNext();
            index++;
        }
    }

    public void displayAllReverse() {
        if (isEmpty()) {
            System.out.println("Картотека пуста!");
            return;
        }

        System.out.println("\n=== КАРТОТЕКА СТУДЕНТОВ (ОБРАТНЫЙ ПОРЯДОК) ===");
        StudentNode current = tail;
        int index = size;

        while (current != null) {
            System.out.println("Студент #" + index);
            current.getStudent().display();
            current = current.getPrev();
            index--;
        }
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
        System.out.println("Картотека очищена!");
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            StudentNode current = head;
            while (current != null) {
                Student student = current.getStudent();
                writer.println(student.getName() + ";" +
                        student.getAge() + ";" +
                        student.getStudentId() + ";" +
                        student.getGroup());
                current = current.getNext();
            }
            System.out.println("Данные сохранены в файл: " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении в файл: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            clear();

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
                    addStudent(student);
                }
            }
            System.out.println("Данные загружены из файла: " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке из файла: " + e.getMessage());
        }
    }

    public Student findStudent(String studentId) {
        StudentNode current = head;
        while (current != null) {
            if (current.getStudent().getStudentId().equals(studentId)) {
                return current.getStudent();
            }
            current = current.getNext();
        }
        return null;
    }

    public int getCount() {
        return size;
    }

    public Student getStudentAt(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        StudentNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getStudent();
    }
}
