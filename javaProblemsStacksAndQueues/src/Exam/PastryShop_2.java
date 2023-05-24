package DataStructures;

import java.util.*;
import java.util.stream.Collectors;

public class PastryShop_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int Biscuit = 25;
        int Cake = 50;
        int Pastry = 75;
        int Pie = 100;
        Map<String, Integer> map = new LinkedHashMap<>();
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
                String cooked;
                if (sum == Biscuit){
                    cooked = "Biscuit";
                }else if (sum == Cake){
                    cooked = "Cake";
                }else if (sum == Pastry){
                    cooked = "Pastry";
                }else {
                    cooked = "Pie";
                }
                if (map != null){
                    map.put(cooked, map.get(cooked) + 1);
                }
            }else {
                stackIngredients.push(lastStack + 3);
            }
        }

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

        map.entrySet().forEach(e -> System.out.println((e.getKey() + ": " + e.getValue())));
        /*
        System.out.println("Biscuit: " + (map.getOrDefault("Biscuit", 0)));
        System.out.println("Cake: " + (map.getOrDefault("Cake", 0)));
        System.out.println("Pie: " + (map.getOrDefault("Pie", 0)));
        System.out.println("Pastry: " + (map.getOrDefault("Pastry", 0)));
         */
    }
}

