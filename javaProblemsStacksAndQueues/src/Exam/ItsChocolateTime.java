package DataStructures;

import java.util.*;

public class ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> map = new TreeMap<>();
        map.put("Milk Chocolate", 0);
        map.put("Dark Chocolate", 0);
        map.put("Baking Chocolate", 0);

        ArrayDeque<Double> milkValueQueue = new ArrayDeque<>();
        String milkValue = scanner.nextLine();
        Arrays.stream(milkValue.split("\\s+"))
                .map(Double::parseDouble)
                .forEach(milkValueQueue::offer);

        ArrayDeque<Double> cacaoPowderStack = new ArrayDeque<>();
        String cacaoPowder = scanner.nextLine();
        Arrays.stream(cacaoPowder.split("\\s+"))
                .map(Double::parseDouble)
                .forEach(cacaoPowderStack::push);

        boolean isEquals = false;
        while (!milkValueQueue.isEmpty() && !cacaoPowderStack.isEmpty()) {
            double firstQueue = milkValueQueue.peek();
            double lastStack = cacaoPowderStack.peek();
            double result = lastStack / (lastStack + firstQueue) * 100.0;

            if (result == 30) {
                map.put("Milk Chocolate", map.get("Milk Chocolate") + 1);
                isEquals = true;
            } else if (result == 50) {
                map.put("Dark Chocolate", map.get("Dark Chocolate") + 1);
                isEquals = true;
            } else if (result == 100) {
                map.put("Baking Chocolate", map.get("Baking Chocolate") + 1);
                isEquals = true;
            }
            if (!isEquals) {
                cacaoPowderStack.pop();
                milkValueQueue.poll();
                milkValueQueue.offer(firstQueue + 10);
            } else {
                cacaoPowderStack.pop();
                milkValueQueue.poll();
                isEquals = false;
            }
        }
        int check = map.values().stream().mapToInt(Integer::intValue).min().getAsInt();
        if (check > 0) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        map.entrySet().stream().filter(entry -> entry.getValue() > 0).forEach(entry -> System.out.printf("# %s --> %d%n", entry.getKey(), entry.getValue()));

    }
}
