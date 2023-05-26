package Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class task7_2FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> smallestNumberIndex =
                list -> Collections.min(list);

        int smallestIndex = smallestNumberIndex.apply(numbers);

        int index = numbers.lastIndexOf(smallestIndex);
        System.out.println(index);
    }
}
