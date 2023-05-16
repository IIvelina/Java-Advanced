package Exam;

import java.util.*;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBoxQueue = new ArrayDeque<>();
        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();

        String input1 = scanner.nextLine();

        Arrays.stream(input1.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(firstBoxQueue::offer);

        String input2 = scanner.nextLine();

        Arrays.stream(input2.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondBoxStack::push);

        List<Integer> claimedItems = new ArrayList<>();

        while (true){
            int firstBoxItem = firstBoxQueue.peek();
            int secondBoxItem = secondBoxStack.peek();

            int sum = firstBoxItem + secondBoxItem;

            if (sum % 2 == 0){
                claimedItems.add(sum);
                firstBoxQueue.poll();
                secondBoxStack.pop();
            }else {
                int last = secondBoxStack.pop();
                firstBoxQueue.offer(last);
            }
            if (firstBoxQueue.size() == 0){
                System.out.println("First lootbox is empty");
                break;
            }
            if (secondBoxStack.size() == 0){
                System.out.println("Second lootbox is empty");
                break;
            }
        }

        int sum = 0;
        for (int num : claimedItems) {
            sum += num;
        }

        if (sum >= 100){
            System.out.println("Your loot was epic! Value: " + sum);
        }else {
            System.out.println("Your loot was poor... Value: " + sum);
        }

    }
}
