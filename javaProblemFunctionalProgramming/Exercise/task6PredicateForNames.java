package Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class task6PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[]names = scanner.nextLine().split("\\s+");

        Predicate<String> checkLength = name -> name.length() <= n;

        Arrays.stream(names).filter(checkLength)
                .forEach(System.out::println);
    }
}
