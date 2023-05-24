package DataStructures;

import java.util.*;
import java.util.stream.Collectors;

public class PastryShop_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int Biscuit = 25;
        int Cake = 50;
        int Pastry = 75;
        int Pie = 100;
        Map<String, Integer> map = new HashMap<>();
        map.put("Biscuit", 0);
        map.put("Cake", 0);
        map.put("Pie", 0);
        map.put("Pastry", 0);

        ArrayDeque<Integer> queueLiquids = new ArrayDeque<>();
        String liquids = scanner.nextLine();
        Arrays.stream(liquids.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(queueLiquids::offer);

        ArrayDeque<Integer> stackIngredients = new ArrayDeque<>();
        String ingredients = scanner.nextLine();
        Arrays.stream(ingredients.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(stackIngredients::push);

        while (!queueLiquids.isEmpty() && !stackIngredients.isEmpty()){

            int firstQueue = queueLiquids.poll();
            int lastStack = stackIngredients.pop();

            int sum = firstQueue + lastStack;

            if (sum == Biscuit || sum == Cake
            || sum == Pastry || sum == Pie){
                if (sum == Biscuit){
                    map.put("Biscuit", map.get("Biscuit") + 1);
                }else if (sum == Cake){
                    map.put("Cake", map.get("Cake") + 1);
                }else if (sum == Pastry){
                    map.put("Pastry", map.get("Pastry") + 1);
                }else {
                    map.put("Pie", map.get("Pie") + 1);
                }
            }else {
                stackIngredients.push(lastStack + 3);
            }
        }
        /*
        int check = map.values().stream()
                .mapToInt(Integer::intValue).min().getAsInt();
        if (check > 0){
            System.out.println("Great! You succeeded in cooking all the food!");
        }else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (queueLiquids.isEmpty()){
            System.out.println("Liquids left: none");
        }else {
           // System.out.println("Liquids left: " + queueLiquids.stream().map(String::valueOf).collect(Collectors.joining(", ")));

            String result = queueLiquids.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));

            System.out.print("Liquids left: " + result);
        }
        if (stackIngredients.isEmpty()){
            System.out.println("Ingredients left: none");
        }else {

          //  System.out.println("Ingredients left: " + stackIngredients.stream().map(String::valueOf).collect(Collectors.joining(", ")));

            String result = stackIngredients.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));

            System.out.print("Ingredients left: " + result);
            System.out.println();
        }
        System.out.println("Biscuit: " + (map.getOrDefault("Biscuit", 0)));
        System.out.println("Cake: " + (map.getOrDefault("Cake", 0)));
        System.out.println("Pie: " + (map.getOrDefault("Pie", 0)));
        System.out.println("Pastry: " + (map.getOrDefault("Pastry", 0)));
         */
        int atLeastOnePastryOfType = map.values().stream().mapToInt(Integer::intValue).min().getAsInt();

        if (atLeastOnePastryOfType > 0) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        String remainingLiquids = queueLiquids.isEmpty() ? "none" : queueLiquids.stream().map(String::valueOf).collect(Collectors.joining(", "));

        System.out.println("Liquids left: " + remainingLiquids);


        String remainingIngredients = stackIngredients.isEmpty() ? "none" : stackIngredients.stream().map(String::valueOf).collect(Collectors.joining(", "));

        System.out.println("Ingredients left: " + remainingIngredients);


        //map.entrySet().forEach(e -> System.out.println((e.getKey() + ": " + e.getValue())));

        System.out.println("Biscuit: " + (map.getOrDefault("Biscuit", 0)));
        System.out.println("Cake: " + (map.getOrDefault("Cake", 0)));
        System.out.println("Pie: " + (map.getOrDefault("Pie", 0)));
        System.out.println("Pastry: " + (map.getOrDefault("Pastry", 0)));
    }
}
