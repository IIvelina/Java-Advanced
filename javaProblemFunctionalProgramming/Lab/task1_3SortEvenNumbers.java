package Lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class task1_3SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. входни данни -> ", "
        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split(", "))
                .map(number -> Integer.parseInt(number))
                .filter(n -> n%2==0)
                .collect(Collectors.toList());


        //2. принтирам само четните числа, като след последното не трябва да има запетая
        //numbers.forEach(n -> System.out.print(n + " "));
        System.out.println(numbers.stream().map(Object::toString)
                .collect(Collectors.joining(", ")));

        //3. сортиране числата в нарастващ ред
        Collections.sort(numbers);

        //4. принтираме отново само четните числа

       // numbers.forEach(n -> System.out.print(n + " "));
        System.out.println(numbers.stream().map(Object::toString)
                .collect(Collectors.joining(", ")));
    }
}

