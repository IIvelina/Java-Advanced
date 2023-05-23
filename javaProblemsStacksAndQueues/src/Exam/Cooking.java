package DataStructures;

import java.util.*;

public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int Bread = 25;
        int Cake = 50;
        int Pastry = 75;
        int FruitPie = 100;
        Map<String, Integer> map = new TreeMap<>();
        map.put("Bread", 0);
        map.put("Cake", 0);
        map.put("Pastry", 0);
        map.put("Fruit Pie", 0);

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        String liquids = scanner.nextLine();
        Arrays.stream(liquids.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(liquidsQueue::offer);

        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        String ingredients = scanner.nextLine();
        Arrays.stream(ingredients.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredientsStack::push);

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int firstLiquids = liquidsQueue.peek();
            int lastIngredients = ingredientsStack.peek();
            int sum = firstLiquids + lastIngredients;

            if (sum == 25 || sum == 50 || sum == 75 || sum == 100) {
                if (sum == 25) {
                    map.put("Bread", map.get("Bread") + 1);
                } else if (sum == 50) {
                    map.put("Cake", map.get("Cake") + 1);
                } else if (sum == 75) {
                    map.put("Pastry", map.get("Pastry") + 1);
                } else {
                    map.put("Fruit Pie", map.get("Fruit Pie") + 1);
                }
                liquidsQueue.poll();
                ingredientsStack.pop();
            } else {
                liquidsQueue.poll();
                ingredientsStack.pop();
                ingredientsStack.push(lastIngredients + 3);
            }
        }
        boolean isFull = true;
        for (Integer value : map.values()) {
            if (value < 1) {
                System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
                isFull = false;
                break;
            }
        }
        if (isFull) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }
        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            while (liquidsQueue.size() >= 1) {
                if (liquidsQueue.size() == 1) {
                    System.out.print(liquidsQueue.poll());
                } else {
                    System.out.print(liquidsQueue.poll() + ", ");
                }
            }
            System.out.println();
        }
        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
            while (ingredientsStack.size() >= 1) {
                if (ingredientsStack.size() == 1) {
                    System.out.print(ingredientsStack.pop());
                } else {
                    System.out.print(ingredientsStack.pop() + ", ");
                }
            }
            System.out.println();
        }
        map.entrySet().stream()
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
