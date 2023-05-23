package DataStructures;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Трябва да започнете да правите венци, като знаете, че един венец се нуждае от 15 цветя.
        // Вашата цел е да направите поне 5 венчета от цветя.

        ArrayDeque<Integer> stackLilies = new ArrayDeque<>();
        int[] liliesArr = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < liliesArr.length; i++) {
            int currentLilies = liliesArr[i];
            stackLilies.push(currentLilies);
        }

        ArrayDeque<Integer> queueLilies = new ArrayDeque<>();
        int[] rosesArr = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < rosesArr.length; i++) {
            int currentRoses = rosesArr[i];
            queueLilies.offer(currentRoses);
        }

        int wreath = 0;
        int storeSum = 0;
        while (!queueLilies.isEmpty() && !stackLilies.isEmpty()){
            int lastLilies = stackLilies.peek();
            int lastRoses = queueLilies.peek();

            if (lastRoses+lastLilies == 15){
                wreath++;
                stackLilies.pop();
                queueLilies.poll();
            }else if (lastRoses+lastLilies < 15){
                storeSum += lastLilies + lastRoses;
                stackLilies.pop();
                queueLilies.poll();
            }else {
                lastLilies = lastLilies - 2;
                stackLilies.pop();
                stackLilies.push(lastLilies);
            }
        }
        wreath = getWreath(wreath, storeSum);

        printWreath(wreath);
    }
    private static int getWreath(int wreath, int storeSum) {
        if (storeSum / 15 > 0){
            int other = storeSum /15;
            wreath +=other;
            storeSum = storeSum % 15;
        }
        return wreath;
    }
    private static void printWreath(int wreath) {
        if (wreath >= 5){
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreath);
        }else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreath);
        }
    }
}
