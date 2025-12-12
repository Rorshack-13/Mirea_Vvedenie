package prac10_to_19.prac14.prac14_5;

public class regexx5 {

    public static boolean isValidDate(String date) {
        if (!date.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/((19|[2-9][0-9])[0-9]{2})$")) {
            return false;
        }

        String[] parts = date.split("/");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        return isValidDateLogic(day, month, year);
    }

    private static boolean isValidDateLogic(int day, int month, int year) {
        if (year < 1900 || year > 9999) {
            return false;
        }

        if (month < 1 || month > 12) {
            return false;
        }

        int maxDays = getMaxDaysInMonth(month, year);
        return day >= 1 && day <= maxDays;
    }

    private static int getMaxDaysInMonth(int month, int year) {
        switch (month) {
            case 2:
                return isLeapYear(year) ? 29 : 28;
            case 4: case 6: case 9: case 11:
                return 30;
            default:
                return 31;
        }
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        String[] testDates = {
                "29/02/2000", "30/04/2003", "01/01/2003", "29/02/2001", "30-04-2003", "1/1/1899"
        };

        System.out.println("=== Проверка дат ===");
        for (String date : testDates) {
            boolean isValid = isValidDate(date);
            System.out.printf("%-15s : %s%n", date, isValid);
        }
    }
}