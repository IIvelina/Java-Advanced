package Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class task4CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> map = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            if (!map.containsKey(current)){
                map.put(current, 1);
            }else {
                int occurrences = map.get(current);
                occurrences++;
                map.put(current, occurrences);
               // map.put(current, map.get(current) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.printf("%c: ", entry.getKey());
            System.out.printf("%d time/s%n", entry.getValue());
        }
    }
}
