package prac10_to_19.prac10;

import java.util.*;

public class SortingStudentsByGPA implements Comparator<Student> {
    private ArrayList<Student> students;
    private int sortField;


    public SortingStudentsByGPA() {
        students = new ArrayList<>();
        sortField = 1;
    }

    @Override
    public int compare(Student s1, Student s2) {
        switch (sortField) {
            case 1: // Сортировка по убыванию GPA
                return Double.compare(s2.getGpa(), s1.getGpa());
            case 2: // Сортировка по имени
                return s2.getName().compareTo(s1.getName());
            case 3: // Сортировка по фамилии
                return s2.getSurname().compareTo(s1.getSurname());
            case 4: // Сортировка по специальности
                int specialityCompare = s2.getSpeciality().compareTo(s1.getSpeciality());
                if (specialityCompare != 0) {
                    return specialityCompare;
                }
                // Если специальности одинаковые, сортируем по фамилии
                return s2.getSurname().compareTo(s1.getSurname());
            case 5: // Сортировка по курсу
                int courseCompare = Integer.compare(s2.getCourse(), s1.getCourse());
                if (courseCompare != 0) {
                    return courseCompare;
                }
                // Если курс одинаковый, сортируем по группе
                return Integer.compare(s2.getGroup(), s1.getGroup());
            case 6: // Сортировка по группе
                int groupCompare = Integer.compare(s2.getGroup(), s1.getGroup());
                if (groupCompare != 0) {
                    return groupCompare;
                }
                // Если группа одинаковая, сортируем по фамилии
                return s2.getSurname().compareTo(s1.getSurname());
            default:
                return Double.compare(s2.getGpa(), s1.getGpa());
        }
    }


    public void setSortField(int field) {
        this.sortField = field;
    }


    //quicksort
    public void quicksort() {
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
        students.add(student);
    }

    public void outArray() {
        if (students.isEmpty()) {
            System.out.println("Список студентов пуст!");
            return;
        }
        for (int i = 0; i<students.size(); i++) {
            System.out.println(students.get(i));
        }
        System.out.println();
    }

    public void mergeLists(SortingStudentsByGPA otherList) {
        this.students.addAll(otherList.students);
    }


    public static void main(String[] args) {
        SortingStudentsByGPA sorted = new SortingStudentsByGPA();

        sorted.outArray();
        System.out.println();

        sorted.setArray(new Student("1", "1", "1", 1,1,1.5));
        sorted.setArray(new Student("2", "2", "2", 2,2,2.7));
        sorted.setArray(new Student("1", "1", "1", 1,1,3.6));

        System.out.println("Список студентов:");
        sorted.outArray();

        System.out.println("Отсортированный по GPA с помощью быстрой сортировки:");
        sorted.quicksort();
        sorted.outArray();

        SortingStudentsByGPA sorted2 = new SortingStudentsByGPA();

        sorted2.setArray(new Student("7", "7", "8", 1,1,4.0));
        sorted2.setArray(new Student("5", "2", "7", 2,2,3.5));
        sorted2.setArray(new Student("3", "2", "1", 7,1,4.7));

        System.out.println("Второй список студентов:");
        sorted2.outArray();

        System.out.println("Отсортированный по GPA с помощью слияния:");
        sorted2.mergeSort();
        sorted2.outArray();

        System.out.println("Отсортированный по курсу с помощью слияния:");
        sorted2.setSortField(5);
        sorted2.mergeSort();
        sorted2.outArray();

        System.out.println("Объединяем два списка студентов");
        sorted2.mergeLists(sorted);
        sorted2.outArray();

        System.out.println("Сортируем объединенный список по GPA");
        sorted2.setSortField(1);
        sorted2.mergeSort();
        sorted2.outArray();

    }
}
