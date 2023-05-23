package DataStructures;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stackTulips = new ArrayDeque<>();
        String tulips = scanner.nextLine();
        Arrays.stream(tulips.split(", "))
                .map(Integer::parseInt)
                .forEach(stackTulips::push);

        ArrayDeque<Integer> queueDaffodils = new ArrayDeque<>();
        String daffodils = scanner.nextLine();
        Arrays.stream(daffodils.split(", "))
                .map(Integer::parseInt)
                .forEach(queueDaffodils::offer);

        int bouquets = 0;
        int residue = 0;
        while (!stackTulips.isEmpty() && !queueDaffodils.isEmpty()) {
            int lastTulips = stackTulips.peek();
            int firstDaffodils = queueDaffodils.peek();
            int sum = lastTulips + firstDaffodils;
            if (sum == 15) {
                bouquets++;
                stackTulips.pop();
                queueDaffodils.poll();
            } else if (sum < 15) {
                residue += sum;
                stackTulips.pop();
                queueDaffodils.poll();
            } else {
                stackTulips.pop();
                stackTulips.push(lastTulips - 2);
            }
        }

        if (residue / 15 > 0) {
            int other = residue / 15;
            bouquets += other;
            residue = residue % 15;
        }
        if (bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquets);
        }
    }
}
