package Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class task1UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> set = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            set.add(input);
        }
        /*
        for (String element : set) {
            System.out.println(element);
        }
         */
       // set.forEach(user -> System.out.println(user));
        set.forEach(System.out::println);
    }
}
