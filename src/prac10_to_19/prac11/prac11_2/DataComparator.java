package prac10_to_19.prac11.prac11_2;

import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class DataComparator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Date current = getCurrentDateWithoutTime();


        SimpleDateFormat dataformat = new SimpleDateFormat("dd.MM.yyyy");

        System.out.println("Сравнение дат");
        System.out.println("Текущая дата: " + dataformat.format(current));
        System.out.println();

        try {
            System.out.println("Введите дату в формате ДД.ММ.ГГГГ");
            String input = sc.nextLine();

            SimpleDateFormat inputformat = new SimpleDateFormat("dd.MM.yyyy");
            inputformat.setLenient(false);

            Date vvedenaya = inputformat.parse(input);

            compareDates(current,vvedenaya);
        } catch (ParseException e) {
            System.out.println("Ошибка: Неверный формат даты! Используйте ДД.ММ.ГГГГ");
        } finally {
            sc.close();
        }
    }

    private static Date getCurrentDateWithoutTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    private static void compareDates(Date current, Date vvedenaya) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        System.out.println("Результаты сравнения");
        System.out.println("Текущая дата: " + dateFormat.format(current));
        System.out.println("Введенная дата: " + dateFormat.format(vvedenaya));
        System.out.println();

        int comparison = vvedenaya.compareTo(current);
        if (comparison == 0) {
            System.out.println("Даты равны");
        } else if (comparison < 0) {
            System.out.println("Введенная дата уже прошла");

            long raznica = current.getTime() - vvedenaya.getTime();
            printtimedif(raznica);
        } else {
            System.out.println("Введенная дата в будущем");

            long raznica = vvedenaya.getTime() - current.getTime();
            printtimedif(raznica);
        }
    }

    private static void printtimedif(long diffMillis) {
        long diffSeconds = diffMillis / 1000;
        long diffMinutes = diffSeconds / 60;
        long diffHours = diffMinutes / 60;
        long diffDays = diffHours / 24;
        long diffMonths = diffDays / 30;
        long diffYears = diffDays / 365;

        System.out.println("\n Разница во времени:");
        System.out.printf("   %d лет\n", diffYears);
        System.out.printf("   %d месяцев\n", diffMonths % 12);
        System.out.printf("   %d дней\n", diffDays % 30);
        System.out.printf("   %d часов\n", diffHours % 24);
        System.out.printf("   %d минут\n", diffMinutes % 60);
        System.out.printf("   %d секунд\n", diffSeconds % 60);
    }
}
