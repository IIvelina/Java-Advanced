package Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class task3PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> set = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            List<String> elements = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .collect(Collectors.toList());
            for (int j = 0; j < elements.size(); j++) {
                String currentEl = elements.get(j);
                set.add(currentEl);
            }
        }
        set.forEach(e -> System.out.print(e + " "));
    }
}
