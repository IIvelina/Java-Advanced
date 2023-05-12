package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class task6HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();

        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < input.length; i++) {
            queue.offer(input[i]);
        }

        while (queue.size() > 1){
            for (int i = 1; i < n; i++) { //ако имаме 2 хода 1 път завъртаме децата
                String current = queue.poll();
                queue.offer(current);
            }
            String toRemove = queue.poll();
            System.out.println("Removed " + toRemove);
        }
        System.out.println("Last is " + queue.poll());
    }
}
