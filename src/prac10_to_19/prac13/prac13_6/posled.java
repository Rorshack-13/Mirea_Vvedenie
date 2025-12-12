package prac10_to_19.prac13.prac13_6;

import java.io.*;
import java.util.*;

public class posled {
    public static String getLine(String... words) {
        if (words.length == 0) return "";

        List<String> availableWords = new ArrayList<>(Arrays.asList(words));
        StringBuilder result = new StringBuilder(availableWords.remove(0));

        boolean found;
        do {
            found = false;
            char lastChar = Character.toLowerCase(result.charAt(result.length() - 1));

            for (int i = 0; i < availableWords.size(); i++) {
                String word = availableWords.get(i);

                if (!result.toString().contains(word) &&
                        Character.toLowerCase(word.charAt(0)) == lastChar) {

                    result.append(" ").append(word);
                    availableWords.remove(i);
                    found = true;
                    break;
                }
            }
        } while (found && !availableWords.isEmpty());

        return result.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String line = fileReader.readLine();
        fileReader.close();

        String[] words = line.split(" ");

        Set<String> uniqueWords = new LinkedHashSet<>(Arrays.asList(words));
        String[] uniqueWordsArray = uniqueWords.toArray(new String[0]);

        System.out.println(getLine(uniqueWordsArray));
    }
}