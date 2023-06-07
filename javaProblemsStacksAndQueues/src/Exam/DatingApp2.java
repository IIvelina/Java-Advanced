package DataStructures;

import java.util.*;
import java.util.stream.Collectors;

public class DatingApp2 {
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

            if (lastMaleStack <= 0 || firstFemaleQueue <= 0){
                if (lastMaleStack <= 0){
                    malesStack.pop();
                }else {
                    femalesQueue.poll();
                }
                continue;
            }else if (lastMaleStack % 25 == 0 || firstFemaleQueue % 25 == 0){
                if (lastMaleStack % 25 == 0){
                    malesStack.pop();

                }else {
                    femalesQueue.poll();

                }
                continue;
            } else if (lastMaleStack == firstFemaleQueue){
                malesStack.pop();
                femalesQueue.poll();
                matchesCount++;
            }else {
                femalesQueue.poll();
                malesStack.pop();
                malesStack.push(lastMaleStack - 2);
            }
        }

        System.out.println("Matches: " + matchesCount);
        if(malesStack.isEmpty()){
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");
            System.out.print(String.join(", ",malesStack.toString()).replaceAll("\\[","").replaceAll("\\]",""));
            System.out.println();
        }
        if(femalesQueue.isEmpty()){
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");
            System.out.print(String.join(", ",femalesQueue.toString()).replaceAll("\\[","").replaceAll("\\]",""));
            System.out.println();
        }

    }
}