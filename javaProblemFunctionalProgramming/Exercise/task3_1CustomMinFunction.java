package Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class task3_1CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> smallNum = arr -> {
            int smallest = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < smallest) {
                    smallest = arr[i];
                }
            }
            return smallest;
        };
        System.out.println(smallNum.apply(arrNumbers));
    }
}
