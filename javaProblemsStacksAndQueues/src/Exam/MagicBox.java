package DataStructures;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBoxQueue = new ArrayDeque<>();
        String first = scanner.nextLine();
        Arrays.stream(first.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(firstBoxQueue::offer);

        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();
        String second = scanner.nextLine();
        Arrays.stream(second.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondBoxStack::push);

        int value = 0;
        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()){
            int firstQueue = firstBoxQueue.peek();
            int lastStack = secondBoxStack.peek();

            if ((firstQueue + lastStack) % 2 == 0){
                value += firstQueue + lastStack;
                firstBoxQueue.poll();
                secondBoxStack.pop();
            }else {
                firstBoxQueue.offer(lastStack);
                secondBoxStack.pop();
            }
        }
        if (firstBoxQueue.isEmpty()){
            System.out.println("First magic box is empty.");
        }
        if (secondBoxStack.isEmpty()){
            System.out.println("Second magic box is empty.");
        }

        if (value >= 90){
            System.out.printf("Wow, your prey was epic! Value: %d", value);
        }else {
            System.out.printf("Poor prey... Value: %d", value);
        }
    }
}
