package Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class demoFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        Function<Integer, Integer> func = n -> n + 3;
        numbers.stream().map(func);
        numbers.stream()
                .forEach(n -> System.out.print(n + " "));
         */
        //Function<приема, връща>
        Function<String, Integer> textLength = text -> text.length();

        System.out.println(textLength.apply("Ivelina"));
    }
}
