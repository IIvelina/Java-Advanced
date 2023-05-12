package Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class task2_1BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split(" ");

        int N = Integer.parseInt(arr[0]);
        int S = Integer.parseInt(arr[1]);
        int X = Integer.parseInt(arr[2]);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            stack.push(numbers[i]);
        }

        for (int i = 0; i < S; i++) {
            stack.pop();
        }
        if (stack.isEmpty()){
            System.out.println(0);
            return;
        }
        if (stack.contains(X)){
            System.out.println("true");
        }else {
            int min = Integer.MAX_VALUE;

            while (!stack.isEmpty()){
                int current = stack.pop();
                if (min > current){
                    min = current;
                }
            }
            System.out.println(min);
        }
    }
}
