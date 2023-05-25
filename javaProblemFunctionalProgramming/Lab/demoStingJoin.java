package Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class demoStingJoin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.asList("Desi", "Ivan", "Hristo", "Milen");

        System.out.println(String.join(", ", names));
        //Desi, Ivan, Hristo, Milen
        //взима всички елементи от списъка и слага разделител м/у елементите


        //numbers
        List<Integer> numbers = Arrays.asList(1,5,8,9,10,34);

        printListWithComa(numbers);
    }

    private static void printListWithComa(List<Integer> nums) {
        List<String> numsAsText = new ArrayList<>();
        for (Integer num : nums) {
            numsAsText.add(String.valueOf(num));
        }
        System.out.println(String.join(", ", numsAsText));
    }
}
