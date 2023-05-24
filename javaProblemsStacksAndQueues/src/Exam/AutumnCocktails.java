package DataStructures;

import java.util.*;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int PearSour = 150;
        int TheHarvest = 250;
        int AppleHinny = 300;
        int HighFashion = 400;

        Map<String, Integer> map = new TreeMap<>();
        map.put("Pear Sour", 0);
        map.put("The Harvest", 0);
        map.put("Apple Hinny", 0);
        map.put("High Fashion", 0);

        ArrayDeque<Integer> queueIngredients = new ArrayDeque<>();
        String ingredients = scanner.nextLine();
        Arrays.stream(ingredients.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(queueIngredients::offer);

        ArrayDeque<Integer> stackFreshnessLevel = new ArrayDeque<>();
        String freshnessLevel = scanner.nextLine();
        Arrays.stream(freshnessLevel.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(stackFreshnessLevel::push);

        while (!queueIngredients.isEmpty() && !stackFreshnessLevel.isEmpty()){

            int firstQueue = queueIngredients.peek();
            int lastStack = stackFreshnessLevel.peek();

            if (firstQueue == 0){
                queueIngredients.poll();
                continue;
            }
            int multiplication = firstQueue * lastStack;

            if (multiplication == 150 || multiplication == 250
            || multiplication == 300 || multiplication == 400){
                if (multiplication == 150){
                    map.put("Pear Sour", map.get("Pear Sour") + 1);
                }else if (multiplication == 250){
                    map.put("The Harvest", map.get("The Harvest") + 1);
                }else if (multiplication == 300){
                    map.put("Apple Hinny", map.get("Apple Hinny") + 1);
                }else {
                    map.put("High Fashion", map.get("High Fashion") + 1);
                }
                queueIngredients.poll();
                stackFreshnessLevel.pop();
            }else {
                stackFreshnessLevel.pop();
                queueIngredients.poll();
                queueIngredients.offer(firstQueue + 5);
            }
        }
        int check = map.values().stream().mapToInt(Integer::intValue).min().getAsInt();
        if (check > 0) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (!queueIngredients.isEmpty()) {
            System.out.println("Ingredients left: " + queueIngredients.stream().mapToInt(Integer::intValue).sum());
        }
        map.entrySet().stream().filter(entry -> entry.getValue() > 0).forEach(entry -> System.out.printf("# %s --> %d%n", entry.getKey(), entry.getValue()));
    }
}
