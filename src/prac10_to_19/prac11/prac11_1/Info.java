package prac10_to_19.prac11.prac11_1;

import java.util.*;
import java.text.SimpleDateFormat;

public class Info {
    public static void main(String[] args) {
        String surname = "Помпаев";

        Date poluchil = new Date(125, 9, 25, 20, 30, 0);

        Date sdacha = new Date();

        SimpleDateFormat dataformat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        System.out.println("=========== Информация ==========");
        System.out.println("Фамилия: " + surname);
        System.out.println("Дата и время получения задания: " + dataformat.format(poluchil));
        System.out.println("Дата и время сдачи задания: " + dataformat.format(sdacha));
    }
}
