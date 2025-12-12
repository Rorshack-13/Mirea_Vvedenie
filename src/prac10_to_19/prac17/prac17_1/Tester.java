package prac10_to_19.prac17.prac17_1;

import java.util.Scanner;

public class Tester {
    private static StudentList cardIndex = new StudentList();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== КАРТОТЕКА СТУДЕНТОВ ===");

        while (true) {
            showMenu();
            int choice = getMenuChoice();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> removeStudent();
                case 3 -> displayAllStudents();
                case 4 -> findStudent();
                case 5 -> clearCardIndex();
                case 6 -> checkEmpty();
                case 7 -> saveToFile();
                case 8 -> loadFromFile();
                case 9 -> displayStatistics();
                case 0 -> {
                    System.out.println("До свидания!");
                    return;
                }
                default -> System.out.println("Неверный выбор! Попробуйте снова.");
            }

            System.out.println("\nНажмите Enter для продолжения...");
            scanner.nextLine();
        }
    }

    private static void showMenu() {
        System.out.println("\n=== МЕНЮ ===");
        System.out.println("1. Добавить студента");
        System.out.println("2. Удалить студента");
        System.out.println("3. Показать всех студентов");
        System.out.println("4. Найти студента");
        System.out.println("5. Очистить картотеку");
        System.out.println("6. Проверить пустоту картотеки");
        System.out.println("7. Сохранить в файл");
        System.out.println("8. Загрузить из файла");
        System.out.println("9. Статистика");
        System.out.println("0. Выход");
        System.out.print("Выберите действие: ");
    }

    private static int getMenuChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Пожалуйста, введите число: ");
            scanner.next();
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    private static void addStudent() {
        System.out.println("\n--- ДОБАВЛЕНИЕ СТУДЕНТА ---");
        Student student = new Student();
        student.readfromconsole(scanner);
        cardIndex.addStudent(student);
    }

    private static void removeStudent() {
        System.out.println("\n--- УДАЛЕНИЕ СТУДЕНТА ---");
        if (cardIndex.isEmpty()) {
            System.out.println("Картотека пуста!");
            return;
        }

        System.out.print("Введите номер студенческого билета для удаления: ");
        String studentId = scanner.nextLine();
        cardIndex.removeStudent(studentId);
    }

    private static void displayAllStudents() {
        System.out.println("\n--- ВСЕ СТУДЕНТЫ ---");
        cardIndex.displayAll();
    }

    private static void findStudent() {
        System.out.println("\n--- ПОИСК СТУДЕНТА ---");
        System.out.print("Введите номер студенческого билета: ");
        String studentId = scanner.nextLine();

        Student student = cardIndex.findStudent(studentId);
        if (student != null) {
            System.out.println("Студент найден:");
            student.display();
        } else {
            System.out.println("Студент с таким номером билета не найден!");
        }
    }

    private static void clearCardIndex() {
        System.out.println("\n--- ОЧИСТКА КАРТОТЕКИ ---");
        System.out.print("Вы уверены? (да/нет): ");
        String confirmation = scanner.nextLine();
        if (confirmation.equalsIgnoreCase("да")) {
            cardIndex.clear();
        } else {
            System.out.println("Очистка отменена.");
        }
    }

    private static void checkEmpty() {
        System.out.println("\n--- ПРОВЕРКА ПУСТОТЫ ---");
        if (cardIndex.isEmpty()) {
            System.out.println("Картотека пуста!");
        } else {
            System.out.println("Картотека содержит " + cardIndex.getCount() + " студентов.");
        }
    }

    private static void saveToFile() {
        System.out.println("\n--- СОХРАНЕНИЕ В ФАЙЛ ---");
        System.out.print("Введите имя файла: ");
        String filename = scanner.nextLine();
        cardIndex.saveToFile(filename);
    }

    private static void loadFromFile() {
        System.out.println("\n--- ЗАГРУЗКА ИЗ ФАЙЛА ---");
        System.out.print("Введите имя файла: ");
        String filename = scanner.nextLine();
        cardIndex.loadFromFile(filename);
    }

    private static void displayStatistics() {
        System.out.println("\n--- СТАТИСТИКА ---");
        System.out.println("Количество студентов в картотеке: " + cardIndex.getCount());
        System.out.println("Картотека " + (cardIndex.isEmpty() ? "пуста" : "не пуста"));
    }
}
