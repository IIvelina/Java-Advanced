package Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class task2_2SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        //брой на числата във въведения списък
        int countNumbers = numbers.size();
        //сума на числата в списъка
        Function<List<Integer>, Integer> sumElementsInList = list -> {
            int sum = 0;
            for (Integer num : list) {
                sum += num;
            }
            return sum;
        };
        int sumNumbers = sumElementsInList.apply(numbers);

        System.out.println("Count = " + countNumbers);
        System.out.println("Sum = " + sumNumbers);
    }
}
