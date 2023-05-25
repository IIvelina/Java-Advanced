package Lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class task1_2SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. входни данни -> ", "
        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split(", "))
                        .map(number -> Integer.parseInt(number))
                        .collect(Collectors.toList());
 /*
        //2. принтирам само четните числа
        // правим нов списък, в който държим само четните числа
        List<Integer> evenNumbers = numbers.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
 */

        //модифицияраме стария списък:
        numbers = numbers.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());


        //2. принтирам само четните числа, като след последното не трябва да има запетая
        numbers.forEach(n -> System.out.print(n + " "));

        //3. сортиране числата в нарастващ ред
        Collections.sort(numbers);

        //4. принтираме отново само четните числа
        System.out.println();
        numbers.forEach(n -> System.out.print(n + " "));
    }
}
