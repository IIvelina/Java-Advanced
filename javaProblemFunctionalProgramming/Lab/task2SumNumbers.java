package Lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class task2SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        //брой на числата във въведения списък
        int countNumbers = numbers.size();
        //сума на числата в списъка
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Count = " + countNumbers);
        System.out.println("Sum = " + sum);
    }
}
