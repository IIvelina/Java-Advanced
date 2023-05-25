package Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class task3CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[]words = input.split("\\s+");

        List<String> uppercaseWords = new ArrayList<>();

        Predicate<String> isUppercase = word ->
                Character.isUpperCase(word.charAt(0));

        for (String word : words) {
            if (isUppercase.test(word)){
                uppercaseWords.add(word);
            }
        }
        System.out.println(uppercaseWords.size());
        System.out.println(String.join("\n", uppercaseWords));
    }
}
