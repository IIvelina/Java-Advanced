package DataStructures;

import java.util.*;
import java.util.stream.Collectors;

public class ClimbThePeaks_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //quantities of the daily portions of food - last - хранителни запаси
        //quantities of the daily stamina - first - дневна издръжливост

        ArrayDeque<Integer> stackPortionsFood = new ArrayDeque<>();
        String portionsFood = scanner.nextLine();
        Arrays.stream(portionsFood.split(", "))
                .map(Integer::parseInt)
                .forEach(stackPortionsFood::push);

        ArrayDeque<Integer> queueDailyStamina = new ArrayDeque<>();
        String dailyStamina = scanner.nextLine();
        Arrays.stream(dailyStamina.split(", "))
                .map(Integer::parseInt)
                .forEach(queueDailyStamina::offer);

        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Vihren", 80);
        map.put("Kutelo", 90);
        map.put("Banski Suhodol", 100);
        map.put("Polezhan", 60);
        map.put("Kamenitza", 70);

        List<String> mountainPeaks = new ArrayList<>();

        while (!map.isEmpty() && !stackPortionsFood.isEmpty() && !queueDailyStamina.isEmpty()){
            Map.Entry<String, Integer> entry = map.entrySet().iterator().next();
            String currentKeyMap = entry.getKey();
            int currentValueMap = entry.getValue();

            int currentQueue = queueDailyStamina.peek();
            int currentStack = stackPortionsFood.peek();
            int sum = currentQueue + currentStack;

            if (sum >= currentValueMap){
                mountainPeaks.add(currentKeyMap);
                queueDailyStamina.poll();
                stackPortionsFood.pop();
                map.remove(currentKeyMap);
            }else {
                queueDailyStamina.poll();
                stackPortionsFood.pop();
            }
        }
        if (map.isEmpty()) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }

        if (!mountainPeaks.isEmpty()) {
            System.out.println("Conquered peaks:");
            System.out.println(mountainPeaks.stream().map(String::valueOf).collect(Collectors.joining(System.lineSeparator())));
        }
    }
}
