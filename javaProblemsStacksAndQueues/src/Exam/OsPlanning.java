package DataStructures;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OsPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();
        String tasks = scanner.nextLine();
        Arrays.stream(tasks.split(", "))
                .map(Integer::parseInt)
                .forEach(tasksStack::push);

        ArrayDeque<Integer> threadsQueue = new ArrayDeque<>();
        String threads = scanner.nextLine();
        Arrays.stream(threads.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(threadsQueue::offer);

        int valueTaskToKilled = Integer.parseInt(scanner.nextLine());

        while (!threadsQueue.isEmpty() && !tasksStack.isEmpty()){
                int firstQueueThread = threadsQueue.peek();
                int lastStackTask = tasksStack.peek();

                if (lastStackTask == valueTaskToKilled){
                    // TODO: 6.6.2023 г.
                    break;
                }else {
                    if (firstQueueThread >= lastStackTask){

                        threadsQueue.poll();
                        tasksStack.pop();
                    }else {
                        threadsQueue.poll();
                    }

            }
        }
        System.out.printf("Thread with value %d killed task %d%n", threadsQueue.peek(), valueTaskToKilled);
        if (!threadsQueue.isEmpty()) {
            threadsQueue.stream()
                    .forEach(e -> System.out.print(e + " "));
        }
    }
}
