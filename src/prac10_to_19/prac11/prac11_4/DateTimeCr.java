package prac10_to_19.prac11.prac11_4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;




public class DateTimeCr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        try {
            System.out.println("Введите дату в формате <Год><Месяц><Число>:");
            System.out.print("Год: ");
            int year = scanner.nextInt();

            System.out.print("Месяц (1-12): ");
            int month = scanner.nextInt();

            System.out.print("Число: ");
            int day = scanner.nextInt();

            System.out.print("Часы (0-23): ");
            int hours = scanner.nextInt();

            System.out.print("Минуты (0-59): ");
            int minutes = scanner.nextInt();

            System.out.println("Через date:");
            createDate(year, month, day, hours, minutes);

            System.out.println();
            System.out.println("Через calendar:");
            createCalendar(year, month, day, hours, minutes);

        } catch (Exception e) {
            System.out.println("Ошибка ввода: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static void createDate(int year, int month, int day, int hours, int minutes) {
        try {
            String dateString = String.format("%04d-%02d-%02d %02d:%02d:00", year, month, day, hours, minutes);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = dateFormat.parse(dateString);

            dateFormat.setLenient(false);

            SimpleDateFormat outputFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            System.out.println("Форматированная дата: " + outputFormat.format(date));

        } catch (ParseException e) {
            System.out.println("Ошибка при создании даты: " + e.getMessage());
        }
    }

    public static void createCalendar(int year, int month, int day, int hours, int minutes) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month - 1, day, hours, minutes, 0); // месяц в Calendar начинается с 0
            calendar.set(Calendar.MILLISECOND, 0);

            Date date = calendar.getTime();

            SimpleDateFormat outputFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            System.out.println("Форматированная дата: " + outputFormat.format(date));

        } catch (Exception e) {
            System.out.println("Ошибка при создании даты: " + e.getMessage());
        }
    }
}