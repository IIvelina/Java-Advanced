package DataStructures;

import java.util.*;
import java.util.stream.Collectors;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int Gladius = 70;
        int Shamshir = 80;
        int Katana = 90;
        int Sabre = 110;

        Map<String, Integer> map = new HashMap<>();
        map.put("Gladius", 0);
        map.put("Shamshir", 0);
        map.put("Katana", 0);
        map.put("Sabre", 0);

        ArrayDeque<Integer> queueSteel = new ArrayDeque<>();
        String steel = scanner.nextLine();
        Arrays.stream(steel.split(" "))
                .map(Integer::parseInt)
                .forEach(queueSteel::offer);

        ArrayDeque<Integer> stackCarbon = new ArrayDeque<>();
        String carbon = scanner.nextLine();
        Arrays.stream(carbon.split(" "))
                .map(Integer::parseInt)
                .forEach(stackCarbon::push);
        int count = 0;
        while (!stackCarbon.isEmpty() && !queueSteel.isEmpty()) {
            int firstSteelQ = queueSteel.peek();
            int lastCarbonS = stackCarbon.peek();

            int sum = firstSteelQ + lastCarbonS;

            if (sum == Gladius) {
                count++;
                map.put("Gladius", map.get("Gladius") + 1);
                queueSteel.poll();
                stackCarbon.pop();
            } else if (sum == Shamshir) {
                count++;
                map.put("Shamshir", map.get("Shamshir") + 1);
                queueSteel.poll();
                stackCarbon.pop();
            } else if (sum == Katana) {
                count++;
                map.put("Katana", map.get("Katana") + 1);
                queueSteel.poll();
                stackCarbon.pop();
            } else if (sum == Sabre) {
                count++;
                map.put("Sabre", map.get("Sabre") + 1);
                queueSteel.poll();
                stackCarbon.pop();
            } else {
                queueSteel.poll();
                stackCarbon.pop();
                stackCarbon.push(lastCarbonS + 5);
            }


        }
        if (count > 0) {
            System.out.printf("You have forged %d swords.%n", count);
        }else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if (queueSteel.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            System.out.print("Steel left: ");

            System.out.println(queueSteel.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
        if (stackCarbon.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            System.out.print("Carbon left: ");

            System.out.println(stackCarbon.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
        map.entrySet()
                .stream()
                .filter(e -> e.getValue() > 0)
                .sorted((l,r) -> l.getKey().compareTo(r.getKey()))
                .forEach(elm -> System.out.println(elm.getKey() + ": " + elm.getValue()));
    }
}
