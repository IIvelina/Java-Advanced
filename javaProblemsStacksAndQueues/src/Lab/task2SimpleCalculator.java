package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class task2SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        String[] input = scanner.nextLine().split(" ");

        for (int i = input.length - 1; i >= 0; i--) {
            if (!input[i].equals("+") && !input[i].equals("-")) {
                int current = Integer.parseInt(input[i]);
                stack.push(current);
            } else {
                continue;
            }
        }

        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("+") && stack.size() > 1){
                int ls1 = stack.pop();
                int ls2 = stack.pop();
                stack.push(ls1 + ls2);
            }else if (input[i].equals("-") && stack.size() > 1){
                int ls1 = stack.pop();
                int ls2 = stack.pop();
                stack.push(ls1 - ls2);
            }else {
                if (stack.size() == 1){
                    System.out.println(stack.peek());
                    return;
                }
                continue;
            }
        }
    }
}
