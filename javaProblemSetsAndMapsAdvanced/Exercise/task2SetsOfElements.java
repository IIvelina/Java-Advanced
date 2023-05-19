package Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class task2SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int firstEl = Integer.parseInt(input.split("\\s+")[0]);
        int secondEl = Integer.parseInt(input.split("\\s+")[1]);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < firstEl; i++) {
            int element = Integer.parseInt(scanner.nextLine());
            firstSet.add(element);
        }
        for (int i = 0; i < secondEl; i++) {
            int element = Integer.parseInt(scanner.nextLine());
            secondSet.add(element);
        }
        
        Set<Integer> duplicate = new LinkedHashSet<>();
        for (Integer number : firstSet) {
            if (secondSet.contains(number)){
                duplicate.add(number);
            }
        }
        duplicate.forEach(el -> System.out.print(el + " "));
    }
}
