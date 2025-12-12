package prac20_to_28.prac21.prac21_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Converter {

    public static <T> List<T> convertArrayToList(T[] array) {
        List<T> list = new ArrayList<>();

        for (T element : array) {
            list.add(element);
        }

        return list;
    }

    public static List<?> convertArrayToListWildcard(Object[] array) {
        return Arrays.asList(array);
    }

    public static void main(String[] args) {
        String[] stringArray = {"Java", "Generics", "Wildcards", "Collections"};
        List<String> stringList = convertArrayToList(stringArray);
        System.out.println("Список строк: " + stringList);

        Integer[] intArray = {1, 2, 3, 4, 5};
        List<Integer> intList = convertArrayToList(intArray);
        System.out.println("Список чисел: " + intList);

        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        List<?> doubleList = convertArrayToListWildcard(doubleArray);
        System.out.println("Список дробных чисел: " + doubleList);

        List<?> wildcardList = convertArrayToListWildcard(stringArray);
        System.out.println("Список через wildcard: " + wildcardList);
    }
}