package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class task5_1BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //62/100

        ArrayDeque<Character> stack = new ArrayDeque<>();
        ArrayDeque<Character> queue = new ArrayDeque<>();

       String input = scanner.nextLine();

        for (int i = 0; i < input.length()/2; i++) {
           stack.push(input.charAt(i));
        }
        for (int i = input.length()/2; i < input.length(); i++) {
            queue.offer(input.charAt(i));
        }
        if (stack.isEmpty()){
            System.out.println("NO");
            return;
        }else if (queue.isEmpty()){
            System.out.println("NO");
            return;
        }else {
            while (!stack.isEmpty()) {
                char currentStackEl = stack.pop();
                if (currentStackEl == '(') {
                    currentStackEl = ')';
                } else if (currentStackEl == '[') {
                    currentStackEl = ']';
                } else if (currentStackEl == '{') {
                    currentStackEl = '}';
                }
                char currentQueueEl = queue.poll();
                if (currentQueueEl == currentStackEl) {
                    continue;
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}
