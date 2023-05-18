package Lab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class task3VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayer = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet<Integer> secondPlayer = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));


        for (int i = 0; i < 50; i++) {
            //check if someone has no cards
            if (firstPlayer.isEmpty()){
                System.out.println("Second player win!");
            }
            if (secondPlayer.isEmpty()){
                System.out.println("First player win!");
            }
            
            //get cards from first pl
            int firstCardFirstPl = firstPlayer.iterator().next();
            //get cards from second pl
            int secondCardFirstPl = secondPlayer.iterator().next();


            firstPlayer.remove(firstCardFirstPl);
            secondPlayer.remove(secondCardFirstPl);

            if (firstCardFirstPl > secondCardFirstPl){
                firstPlayer.add(firstCardFirstPl);
                firstPlayer.add(secondCardFirstPl);
            }else if (secondCardFirstPl > firstCardFirstPl){
                secondPlayer.add(firstCardFirstPl);
                secondPlayer.add(secondCardFirstPl);
            }else {
                firstPlayer.add(firstCardFirstPl);
                secondPlayer.add(secondCardFirstPl);
            }
        }
        int firstPlDecSize = firstPlayer.size();
        int secondPlDecSize = secondPlayer.size();
        if (firstPlDecSize > secondPlDecSize){
            System.out.println("First player win!");
        }else if (secondPlDecSize > firstPlDecSize){
            System.out.println("Second player win!");
        }else {
            System.out.println("Draw!");
        }
    }
  /*  private static Integer getTopValue(LinkedHashSet<Integer> player){
        for (Integer card : player) {
            return card;
        }
        return 0;
    }

   */
}
