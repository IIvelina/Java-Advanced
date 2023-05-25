package DataStructures;

import java.util.*;

public class RubberDuckDebuggers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //single task time queue
        //number of tasks stack
        //count how many rubber ducks of each type you’ve given to your programmers

        ArrayDeque<Integer> queueTaskTime = new ArrayDeque<>();
        String singleTaskTime = scanner.nextLine();
        Arrays.stream(singleTaskTime.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(queueTaskTime::offer);

        ArrayDeque<Integer> stackNumberTasks = new ArrayDeque<>();
        String numberOfTasks = scanner.nextLine();
        Arrays.stream(numberOfTasks.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(stackNumberTasks::push);

        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Darth Vader Ducky", 0);
        map.put("Thor Ducky", 0);
        map.put("Big Blue Rubber Ducky", 0);
        map.put("Small Yellow Rubber Ducky", 0);
        boolean isInMap = false;
        while (!queueTaskTime.isEmpty() && !stackNumberTasks.isEmpty()){
            int firstQueue = queueTaskTime.peek();
            int lastStack = stackNumberTasks.peek();
            int multiply = firstQueue * lastStack;

            if (multiply >= 0 && multiply <= 60){
                isInMap = true;
                map.put("Darth Vader Ducky", map.get("Darth Vader Ducky") + 1);
            }else if (multiply >= 61 && multiply <= 120){
                isInMap = true;
                map.put("Thor Ducky", map.get("Thor Ducky") + 1);
            }else if (multiply >= 121 && multiply <= 180){
                isInMap = true;
                map.put("Big Blue Rubber Ducky", map.get("Big Blue Rubber Ducky") + 1);
            }else if (multiply >= 181 && multiply <= 240){
                isInMap = true;
                map.put("Small Yellow Rubber Ducky", map.get("Small Yellow Rubber Ducky") + 1);
            }else {
                isInMap = false;
            }
            if (isInMap){
                queueTaskTime.poll();
                stackNumberTasks.pop();
            }else {
                stackNumberTasks.pop();
                stackNumberTasks.push(lastStack - 2);
                queueTaskTime.poll();
                queueTaskTime.offer(firstQueue);
            }
        }
        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");

        map.entrySet().stream()
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));
    }
}
