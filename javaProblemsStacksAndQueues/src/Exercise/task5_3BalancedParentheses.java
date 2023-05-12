package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class task5_3BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //75/100

        ArrayDeque<Character> stack = new ArrayDeque<>();
        ArrayDeque<Character> queue = new ArrayDeque<>();

        String input = scanner.nextLine();

        for (int i = 0; i < input.length()/2; i++) {
            stack.push(input.charAt(i));
        }
        for (int i = input.length()/2; i < input.length(); i++) {
            queue.offer(input.charAt(i));
        }

        if (queue.isEmpty() || stack.isEmpty()){
            System.out.println("No");
            return;
        }else {
            while (!stack.isEmpty()){
                char currentStackBr = stack.pop();
                char currentQueueBr = queue.poll();

                if (currentQueueBr == ')'){
                    currentQueueBr = '(';
                }else if (currentQueueBr == ']'){
                    currentQueueBr = '[';
                }else if (currentQueueBr == '}'){
                    currentQueueBr = '{';
                }

                if (currentStackBr == currentQueueBr){
                    continue;
                }else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}
