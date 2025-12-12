package prac1_to_9.prac3.prac3_1;

import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;

public class randomdouble {
    public static void main(String[] args) {
        ArrayList<Double> test1 = new ArrayList<>();
        ArrayList<Double> test2 = new ArrayList<>();

        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            double rand_int1 = rand.nextDouble(100);
            test1.add(rand_int1);
        }

        System.out.println("Лист test1 до сортировки - " + test1);
        Collections.sort(test1);
        System.out.println("Лист test1 после сортировки - " + test1);



        for (int i = 0; i < 100; i++) {
            Double x = Math.random()*100;
            test2.add(x);
        }

        System.out.println();
        System.out.println("Лист test2 до сортировки - " + test2);
        Collections.sort(test2);
        System.out.println("Лист test2 после сортировки - " + test2);
    }
}