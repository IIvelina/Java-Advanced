package Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class task2KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputNames = scanner.nextLine().split("\\s+");

        Consumer<String> print = name -> System.out.println("Sir " + name);

        Arrays.stream(inputNames).forEach(print);
    }
}
