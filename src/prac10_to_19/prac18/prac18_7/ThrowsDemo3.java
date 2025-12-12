package prac10_to_19.prac18.prac18_7;

import java.util.Scanner;

public class ThrowsDemo3 {
    public void getKey() {
        Scanner myScanner = new Scanner(System.in);
        try {
            String key = myScanner.nextLine();
            printDetails(key);
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        } finally {
            myScanner.close();

        }
    }

    public void printDetails(String key) {
        try {
            String message = getDetails(key);
            System.out.println(message);
        } catch (Exception e) {
            System.out.println("Ошибка при получении деталей: " + e.getMessage());
        }
    }

    private String getDetails(String key) throws Exception {
        if(key == "" || key.equals("1")) {
            throw new Exception("Key set to empty string");
        }
        return "data for " + key;
    }

    public static void main(String[] args) {
        ThrowsDemo3 obj = new ThrowsDemo3();
        obj.getKey();
    }
}
