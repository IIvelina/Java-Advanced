package DataStructures;

import java.util.*;
import java.util.stream.Collectors;

public class DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //males - last
        //females - first

        ArrayDeque<Integer> malesStack = new ArrayDeque<>();
        String males = scanner.nextLine();
        Arrays.stream(males.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(malesStack::push);

        ArrayDeque<Integer> femalesQueue = new ArrayDeque<>();
        String females = scanner.nextLine();
        Arrays.stream(females.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(femalesQueue::offer);

        int matchesCount = 0;

        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()){
            int lastMaleStack = malesStack.peek();
            int firstFemaleQueue = femalesQueue.peek();


            if (lastMaleStack <= 0) {
                malesStack.pop();
                continue;
            } else if (lastMaleStack % 25 == 0) {
                malesStack.pop();
                malesStack.pop();
                continue;
            }
            if (firstFemaleQueue <= 0) {
                femalesQueue.poll();
                continue;
            } else if (firstFemaleQueue % 25 == 0) {
                femalesQueue.poll();
                femalesQueue.poll();
                continue;
            }

            if (lastMaleStack == firstFemaleQueue){
                malesStack.pop();
                femalesQueue.poll();
                matchesCount++;
            }else {
                femalesQueue.poll();
                malesStack.pop();
                malesStack.push(lastMaleStack - 2);
            }
        }


        /*System.out.printf("Matches: %d%n", matchesCount);

        if(!femalesQueue.isEmpty()){
            System.out.println("Males left: none");
            System.out.print("Females left: ");
            String result = femalesQueue.stream()
                    .map(it -> it.toString())
                    .collect(Collectors.joining(", "));
            System.out.println(result);
        }else if (!malesStack.isEmpty()){
            System.out.print("Males left: ");
            String result = malesStack.stream()
                    .map(it -> it.toString())
                    .collect(Collectors.joining(", "));
            System.out.println(result);
            System.out.println("Females left: none");
        }

         */

        /*System.out.println("Matches: " + matchesCount);
        if (malesStack.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");
            System.out.println(malesStack.toString().replaceAll("\\[", "").
                    replaceAll("]", ""));
        }
        if (femalesQueue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");
            System.out.println(femalesQueue.toString().replaceAll("\\[", "").
                    replaceAll("]", ""));
        }

         */
        System.out.println("Matches: " + matchesCount);
        if (malesStack.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");

            System.out.println(malesStack.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
        if (femalesQueue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");

            System.out.println(femalesQueue.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
    }
}