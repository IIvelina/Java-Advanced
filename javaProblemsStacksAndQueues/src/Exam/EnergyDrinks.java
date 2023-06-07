package DataStructures;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //last milligrams of caffeinе
        //first energy drink

        ArrayDeque<Integer> stackCaffeinе = new ArrayDeque<>();
        String caffeinе = scanner.nextLine();
        Arrays.stream(caffeinе.split(", "))
                .map(Integer::parseInt)
                .forEach(stackCaffeinе::push);

        ArrayDeque<Integer> queueDrink = new ArrayDeque<>();
        String energyDrink = scanner.nextLine();
        Arrays.stream(energyDrink.split(", "))
                .map(Integer::parseInt)
                .forEach(queueDrink::offer);

        //Stamat can have for the night
        // is 300 milligrams, and his initial is always 0.
        //Стамат може да има за през нощта е 300 милиграма,
        // като началната му стойност винаги е 0.

        int caffeineStamat = 0;
        while (!stackCaffeinе.isEmpty() && !queueDrink.isEmpty()) {
            int caffeineLast = stackCaffeinе.peek();
            int drinkFirst = queueDrink.peek();

            int caffeineInDrink = caffeineLast * drinkFirst;


            if (caffeineStamat + caffeineInDrink <= 300) {
                caffeineStamat += caffeineInDrink;
                stackCaffeinе.pop();
                queueDrink.poll();
                if (caffeineStamat == 300){
                    break;
                }
            } else {
                stackCaffeinе.pop();
                queueDrink.poll();
                queueDrink.offer(drinkFirst);

                if (caffeineStamat >= 30) {
                    caffeineStamat -= 30;
                }
            }
        }
        if (!queueDrink.isEmpty()){
            //Drinks left: { remaining drinks separated by ", " }

            System.out.println("Drinks left: " + queueDrink.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.", caffeineStamat);
    }
}
