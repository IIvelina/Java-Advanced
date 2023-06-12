package DataStructures;

import java.util.*;
import java.util.stream.Collectors;

public class SantaPresentFactory_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int Doll = 150;
        int WoodenTrain = 250;
        int TeddyBear = 300;
        int Bicycle = 400;

        Map<String, Integer> map = new HashMap<>();
        map.put("Doll", 0);
        map.put("Wooden train", 0);
        map.put("Teddy bear", 0);
        map.put("Bicycle", 0);

        ArrayDeque<Integer> stackBoxMaterials = new ArrayDeque<>();
        String boxWithMaterials = scanner.nextLine();
        Arrays.stream(boxWithMaterials.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(stackBoxMaterials::push);

        ArrayDeque<Integer> queueMagicLevel  = new ArrayDeque<>();
        String magicLevelValue = scanner.nextLine();
        Arrays.stream(magicLevelValue.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(queueMagicLevel::offer);

        while (!stackBoxMaterials.isEmpty() && !queueMagicLevel.isEmpty()){
            int last = stackBoxMaterials.peek();
            int first = queueMagicLevel.peek();

            if (last == 0 || first == 0){
                if (last == 0){
                    stackBoxMaterials.pop();
                }
                if (first == 0){
                    queueMagicLevel.poll();
                }
                continue;
            }

            int multiplication = last * first;

            if (multiplication < 0){
                int sum = last + first;
                stackBoxMaterials.pop();
                queueMagicLevel.poll();
                stackBoxMaterials.push(sum);
            }else if (multiplication == Doll){
                map.put("Doll", map.get("Doll") + 1);
                stackBoxMaterials.pop();
                queueMagicLevel.poll();
            }else if (multiplication == WoodenTrain){
                map.put("Wooden train", map.get("Wooden train") + 1);
                stackBoxMaterials.pop();
                queueMagicLevel.poll();
            }else if (multiplication == TeddyBear){
                map.put("Teddy bear", map.get("Teddy bear") + 1);
                stackBoxMaterials.pop();
                queueMagicLevel.poll();
            }else if (multiplication == Bicycle){
                map.put("Bicycle", map.get("Bicycle") + 1);
                stackBoxMaterials.pop();
                queueMagicLevel.poll();
            }else {
                queueMagicLevel.poll();
                stackBoxMaterials.pop();
                stackBoxMaterials.push(last + 15);
            }
        }

        int countDolls = map.get("Doll");
        int countTrains = map.get("Wooden train");
        int countBears = map.get("Teddy bear");
        int countBicycles = map.get("Bicycle");

        if (countDolls >= 1 && countTrains >= 1 ||
                countBears >= 1 && countBicycles >= 1){
            System.out.println("The presents are crafted! Merry Christmas!");
        }else {
            System.out.println("No presents this Christmas!");
        }

        if (!stackBoxMaterials.isEmpty()){
            System.out.println("Materials left: " + stackBoxMaterials.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
        if (!queueMagicLevel.isEmpty()){
            System.out.println("Magic left: " + queueMagicLevel.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }

        map.entrySet().stream()
                .filter(e -> e.getValue() > 0)
                .sorted((l,r) -> l.getKey().compareTo(r.getKey()))
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
