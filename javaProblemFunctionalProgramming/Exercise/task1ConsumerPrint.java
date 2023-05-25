package Exercise;

import java.util.Scanner;
import java.util.function.Consumer;

public class task1ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        Consumer<String> print = name -> System.out.println(name);

        for (String name : input) {
            print.accept(name);
        }
    }
}
