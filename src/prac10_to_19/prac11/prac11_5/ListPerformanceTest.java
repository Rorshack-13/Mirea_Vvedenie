package prac10_to_19.prac11.prac11_5;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListPerformanceTest {
    public static void main(String[] args) {
        int count = 50000;

        System.out.println("ПРОСТОЕ СРАВНЕНИЕ ArrayList vs LinkedList");
        System.out.println("Количество элементов: " + count);
        System.out.println("=========================================");

        System.out.println("\n1. Добавление в конец:");
        long start = System.nanoTime();
        ArrayList<Integer> arr1 = new ArrayList<>();
        for (int i = 0; i < count; i++) arr1.add(i);
        long arrTime = System.nanoTime() - start;

        start = System.nanoTime();
        LinkedList<Integer> link1 = new LinkedList<>();
        for (int i = 0; i < count; i++) link1.add(i);
        long linkTime = System.nanoTime() - start;

        System.out.printf("ArrayList: %,d нс\n", arrTime);
        System.out.printf("LinkedList: %,d нс\n", linkTime);

        System.out.println("\n2. Добавление в начало:");
        start = System.nanoTime();
        ArrayList<Integer> arr2 = new ArrayList<>();
        for (int i = 0; i < 5000; i++) arr2.add(0, i);
        arrTime = System.nanoTime() - start;

        start = System.nanoTime();
        LinkedList<Integer> link2 = new LinkedList<>();
        for (int i = 0; i < 5000; i++) link2.addFirst(i);
        linkTime = System.nanoTime() - start;

        System.out.printf("ArrayList: %,d нс\n", arrTime);
        System.out.printf("LinkedList: %,d нс\n", linkTime);

        System.out.println("\n3. Доступ по индексу:");
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arr1.get(i * 50);
        }
        arrTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            link1.get(i * 50);
        }
        linkTime = System.nanoTime() - start;

        System.out.printf("ArrayList: %,d нс\n", arrTime);
        System.out.printf("LinkedList: %,d нс\n", linkTime);
    }
}