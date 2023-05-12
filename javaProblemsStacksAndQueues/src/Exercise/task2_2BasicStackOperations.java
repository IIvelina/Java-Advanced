package Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class task2_2BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*
        String[] commandNumbers = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(commandNumbers[0]);
        int s = Integer.parseInt(commandNumbers[1]);
        int x = Integer.parseInt(commandNumbers[2]);
         */

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int count = 0; count < n; count++) {
            stack.push(scanner.nextInt()); //сканира цяло число, докато не срещне друго цяло число
        }

        for (int i = 0; i < s; i++) {
            stack.pop();
        }
        if (stack.contains(x)){
            System.out.println("true");
        }else {
            if (!stack.isEmpty()){
                System.out.println(Collections.min(stack));
            }else {
                System.out.println(0);
            }
        }
    }
}
