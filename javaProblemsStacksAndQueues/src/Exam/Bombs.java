package DataStructures;

import java.util.*;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //the first bomb effect
        //the last bomb casing

        int daturaBombs = 40;
        int cherryBombs = 60;
        int smokeDecoyBombs = 120;

        Map<String, Integer> map = new HashMap<>();
        map.put("Datura Bombs", 0);
        map.put("Cherry Bombs", 0);
        map.put("Smoke Decoy Bombs", 0);

        ArrayDeque<Integer> queueEffect= new ArrayDeque<>();
        String bombEffect = scanner.nextLine();
        Arrays.stream(bombEffect.split(", "))
                .map(Integer::parseInt)
                .forEach(queueEffect::offer);

        ArrayDeque<Integer> stackCasing = new ArrayDeque<>();
        String bombCasing = scanner.nextLine();
        Arrays.stream(bombCasing.split(", "))
                .map(Integer::parseInt)
                .forEach(stackCasing::push);

        boolean fillBomb = false;
        while (!stackCasing.isEmpty() && !queueEffect.isEmpty()){
            int firstEffect = queueEffect.peek();
            int lastCasing = stackCasing.peek();

            int sum = firstEffect + lastCasing;

            if (sum == daturaBombs){
                map.put("Datura Bombs", map.get("Datura Bombs") + 1);
                queueEffect.poll();
                stackCasing.pop();
            }else if (sum == cherryBombs){
                map.put("Cherry Bombs", map.get("Cherry Bombs") + 1);
                queueEffect.poll();
                stackCasing.pop();
            }else if (sum == smokeDecoyBombs){
                map.put("Smoke Decoy Bombs", map.get("Smoke Decoy Bombs") + 1);
                queueEffect.poll();
                stackCasing.pop();
            }else {
                stackCasing.pop();
                stackCasing.push(lastCasing - 5);
            }
            if ((map.get("Datura Bombs") >= 3) && (map.get("Cherry Bombs") >= 3)
            && (map.get("Smoke Decoy Bombs") >= 3)){
                fillBomb = true;
                break;
            }
        }
        if (fillBomb){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (!queueEffect.isEmpty()){
            System.out.println("Bomb Effects: " + queueEffect.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }else {
            System.out.println("Bomb Effects: empty");
        }
        if (!stackCasing.isEmpty()){
            System.out.println("Bomb Casings: " + stackCasing.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }else {
            System.out.println("Bomb Casings: empty");
        }
        map.entrySet().stream()
              //  .filter(e -> e.getValue() > 0)
                .sorted((l,r) -> l.getKey().compareTo(r.getKey()))
                .forEach(bomb -> System.out.println(bomb.getKey() + ": " + bomb.getValue()));
    }
}
