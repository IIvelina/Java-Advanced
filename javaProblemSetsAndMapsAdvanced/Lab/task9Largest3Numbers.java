package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class task9Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted(
                        (left, right) ->
                                right.compareTo(left)
                ).limit(3)
                .forEach(e -> System.out.print(e + " "));


    }
}
