package prac10_to_19.prac19.prac19_2;

import java.util.ArrayList;
import java.util.Comparator;

class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}

class sortbyGpa implements Comparator<Student> {
    private ArrayList<Student> students;
    private int sortField;

    public sortbyGpa() {
        students = new ArrayList<>();
        sortField = 1;
    }

    @Override
    public int compare(Student s1, Student s2) {
        switch (sortField) {
            case 1: // Сортировка по убыванию GPA
                return Double.compare(s2.getGPA(), s1.getGPA());
            case 2: // Сортировка по имени
                return s1.getName().compareTo(s2.getName());
            case 3: // Сортировка по фамилии
                return s1.getSurname().compareTo(s2.getSurname());
            case 4: // Сортировка по специальности
                int majorCompare = s1.getMajor().compareTo(s2.getMajor());
                if (majorCompare != 0) {
                    return majorCompare;
                }
                // Если специальности одинаковые, сортируем по фамилии
                return s1.getSurname().compareTo(s2.getSurname());
            case 5: // Сортировка по курсу
                int courseCompare = Integer.compare(s1.getCourse(), s2.getCourse());
                if (courseCompare != 0) {
                    return courseCompare;
                }
                // Если курс одинаковый, сортируем по группе
                return Integer.compare(s1.getGroup(), s2.getGroup());
            case 6: // Сортировка по группе
                int groupCompare = Integer.compare(s1.getGroup(), s2.getGroup());
                if (groupCompare != 0) {
                    return groupCompare;
                }
                // Если группа одинаковая, сортируем по фамилии
                return s1.getSurname().compareTo(s2.getSurname());
            default:
                return Double.compare(s2.getGPA(), s1.getGPA());
        }
    }

    public void setSortField(int field) {
        if (field < 1 || field > 6) {
            System.out.println("Ошибка: неверный номер поля сортировки. Установлено значение по умолчанию (1).");
            this.sortField = 1;
        } else {
            this.sortField = field;
        }
    }

    // Метод для поиска студента по имени и фамилии
    public Student findStudentByName(String name, String surname) throws StudentNotFoundException {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name) && student.getSurname().equalsIgnoreCase(surname)) {
                return student;
            }
        }
        throw new StudentNotFoundException("Студент " + name + " " + surname + " не найден!");
    }

    //quicksort
    public void quicksort() {
        if (students.isEmpty()) {
            System.out.println("Ошибка: список студентов пуст!");
            return;
        }
        quicksort(0, students.size() - 1);
    }

    private void quicksort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quicksort(low, pivotIndex - 1);
            quicksort(pivotIndex + 1, high);
        }
    }

    private int partition(int low, int high) {
        Student pivot = students.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (this.compare(students.get(j), pivot) < 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    private void swap(int i, int j) {
        Student temp = students.get(i);
        students.set(i, students.get(j));
        students.set(j, temp);
    }

    //merge sort
    public void mergeSort() {
        if (students.isEmpty()) {
            System.out.println("Ошибка: список студентов пуст!");
            return;
        }
        mergeSort(0, students.size() - 1);
    }

    private void mergeSort(int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    private void merge(int left, int mid, int right) {
        ArrayList<Student> temp = new ArrayList<>();
        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {
            if (this.compare(students.get(i), students.get(j)) <= 0) {
                temp.add(students.get(i));
                i++;
            } else {
                temp.add(students.get(j));
                j++;
            }
        }

        while (i <= mid) {
            temp.add(students.get(i));
            i++;
        }

        while (j <= right) {
            temp.add(students.get(j));
            j++;
        }

        for (int k = 0; k < temp.size(); k++) {
            students.set(left + k, temp.get(k));
        }
    }

    //set и out (array)
    public void setArray(Student student) {
        if (student == null) {
            System.out.println("Ошибка: попытка добавить null студента!");
            return;
        }
        students.add(student);
    }

    public void outArray() {
        if (students.isEmpty()) {
            System.out.println("Список студентов пуст!");
            return;
        }
        System.out.println("Список студентов:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }
        System.out.println();
    }

    public void mergeLists(sortbyGpa otherList) {
        if (otherList == null) {
            System.out.println("Ошибка: передан null список для объединения!");
            return;
        }
        this.students.addAll(otherList.students);
    }

    public static void main(String[] args) {
        sortbyGpa sorted = new sortbyGpa();


        System.out.println("Тест с пустым списком ");
        sorted.outArray();
        sorted.quicksort();
        sorted.mergeSort();
        System.out.println();

        System.out.println("Добавление студентов ");
        sorted.setArray(new Student("Михаил", "Пупков", "Математика", 2, 101, 4.5));
        sorted.setArray(new Student("Мария", "Смирнова", "Информатика", 1, 102, 4.8));
        sorted.setArray(new Student("Александр", "Солодовченко", "Физика", 3, 103, 4.2));


        sorted.setArray(null);

        sorted.outArray();

        System.out.println("Тестирование поиска");
        try {
            Student found = sorted.findStudentByName("Иван", "Петров");
            System.out.println("Найден студент: " + found);
        } catch (StudentNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Student notFound = sorted.findStudentByName("Несуществующий", "Студент");
            System.out.println("Найден студент: " + notFound);
        } catch (StudentNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println();

        // Тестирование сортировки по разным полям
        System.out.println("Сортировка по GPA (убывание)");
        sorted.setSortField(1);
        sorted.quicksort();
        sorted.outArray();

        System.out.println("Сортировка по имени");
        sorted.setSortField(2);
        sorted.mergeSort();
        sorted.outArray();

        System.out.println("Сортировка по фамилии");
        sorted.setSortField(3);
        sorted.quicksort();
        sorted.outArray();

        System.out.println("Сортировка по специальности");
        sorted.setSortField(4);
        sorted.mergeSort();
        sorted.outArray();


        System.out.println("Тест неверного номера поля");
        sorted.setSortField(10);
        sorted.quicksort();
        sorted.outArray();

        System.out.println("Объединение списков");
        sortbyGpa sorted2 = new sortbyGpa();
        sorted2.setArray(new Student("Виктория", "Мирная", "Химия", 2, 201, 4.9));
        sorted2.setArray(new Student("Глеб", "Поляков", "Биология", 1, 202, 4.6));

        System.out.println("Второй список:");
        sorted2.outArray();

        sorted.mergeLists(sorted2);
        System.out.println("После объединения:");
        sorted.outArray();

        System.out.println("Тест с пустым списком");
        sorted.mergeLists(null);
    }
}