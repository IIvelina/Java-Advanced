package DataStructures;

import java.util.*;
import java.util.stream.Collectors;

public class ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int Patch = 30;
        int Bandage = 40;
        int MedKit = 100;

        Map<String, Integer> map = new HashMap<>();
        map.put("Patch", 0);
        map.put("Bandage", 0);
        map.put("MedKit", 0);

    //textiles - first
    //medicaments - last

        ArrayDeque<Integer> queueTextiles = new ArrayDeque<>();
        String textiles = scanner.nextLine();
        Arrays.stream(textiles.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(queueTextiles::offer);

        ArrayDeque<Integer> stackMedicaments = new ArrayDeque<>();
        String medicaments = scanner.nextLine();
        Arrays.stream(medicaments.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(stackMedicaments::push);

        while (!queueTextiles.isEmpty() && !stackMedicaments.isEmpty()){
            int textilesQ = queueTextiles.peek();
            int medicamentsS = stackMedicaments.peek();

            int sum = textilesQ + medicamentsS;

            if (sum == Patch){
                map.put("Patch", map.get("Patch") + 1);
                queueTextiles.poll();
                stackMedicaments.pop();
            }else if (sum == Bandage){
                map.put("Bandage", map.get("Bandage") + 1);
                queueTextiles.poll();
                stackMedicaments.pop();
            }else if (sum == MedKit){
                map.put("MedKit", map.get("MedKit") + 1);
                queueTextiles.poll();
                stackMedicaments.pop();
            }else if (sum > MedKit){
                map.put("MedKit", map.get("MedKit") + 1);
                queueTextiles.poll();
                stackMedicaments.pop();
                int remainingResources = sum - MedKit;
                int last = stackMedicaments.pop();
                stackMedicaments.push(remainingResources + last);
            }else {
                queueTextiles.poll();
                stackMedicaments.pop();
                stackMedicaments.push(medicamentsS + 10);
            }
        }
        if (stackMedicaments.isEmpty() && queueTextiles.isEmpty()){
            System.out.println("Textiles and medicaments are both empty.");
        }else {
            if (stackMedicaments.isEmpty()){
                System.out.println("Medicaments are empty.");
            }else if (queueTextiles.isEmpty()){
                System.out.println("Textiles are empty.");
            }
        }
        map.entrySet()
                .stream()
                .filter(e -> e.getValue() > 0)
                .sorted((l,r) -> l.getKey().compareTo(r.getKey()))
                .sorted((k1, k2) -> k2.getValue().compareTo(k1.getValue()))
                .forEach(el -> System.out.println(el.getKey() + " - " + el.getValue()));

        if (!queueTextiles.isEmpty()){
            System.out.println("Textiles left: " + queueTextiles.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
        if (!stackMedicaments.isEmpty()){
            System.out.println("Medicaments left: " + stackMedicaments.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
    }
}
