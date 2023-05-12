package Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class task3_1MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            int command = Integer.parseInt(input[0]);

            if (command == 1) {
                int element = Integer.parseInt(input[1]);
                stack.push(element);
            } else if (command == 2) {
                stack.pop();
            } else if (command == 3) {
                System.out.println(Collections.max(stack));
            }
        }
    }
}

