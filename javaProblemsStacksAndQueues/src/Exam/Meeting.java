package DataStructures;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //representing males - last
        //representing females - first

        ArrayDeque<Integer> stackMales = new ArrayDeque<>();
        String males = scanner.nextLine();
        Arrays.stream(males.split(" "))
                .map(Integer::parseInt)
                .forEach(stackMales::push);

        ArrayDeque<Integer> queueFemales = new ArrayDeque<>();
        String females = scanner.nextLine();
        Arrays.stream(females.split(" "))
                .map(Integer::parseInt)
                .forEach(queueFemales::offer);


        int matches = 0;

        while (!stackMales.isEmpty() && !queueFemales.isEmpty()) {
            int maleLastS = stackMales.peek();
            int femaleFirstQ = queueFemales.peek();

            if (maleLastS <= 0 || femaleFirstQ <= 0) {
                if (maleLastS <= 0) {
                    stackMales.pop();
                }
                if (femaleFirstQ <= 0) {
                    queueFemales.poll();
                }
                continue;
            }


            if (maleLastS % 25 == 0 || femaleFirstQ % 25 == 0) {
                if (maleLastS % 25 == 0) {
                    if (stackMales.size() >= 2) {
                        stackMales.pop();
                        stackMales.pop();
                    } else {
                        stackMales.pop();
                    }
                }
                if (femaleFirstQ % 25 == 0) {
                    if (queueFemales.size() >= 2) {
                        queueFemales.poll();
                        queueFemales.poll();
                    } else {
                        queueFemales.poll();
                    }
                }
                continue;
            }





            if (maleLastS == femaleFirstQ) {
                stackMales.pop();
                queueFemales.poll();
                matches++;
            } else {
                queueFemales.poll();
                stackMales.pop();
                stackMales.push(maleLastS - 2);
            }
        }
        System.out.printf("Matches: %d%n", matches);

        if (stackMales.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");

            System.out.println(stackMales.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
        if (queueFemales.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");

            System.out.println(queueFemales.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
    }
}
