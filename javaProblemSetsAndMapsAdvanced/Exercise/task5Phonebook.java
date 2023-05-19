package Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class task5Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> map = new HashMap<>();

        String input1 = scanner.nextLine();

        while (!input1.equals("search")){
            String name = input1.split("-")[0];
            String phone = input1.split("-")[1];

            map.put(name, phone);

            input1 = scanner.nextLine();
        }
        String name = scanner.nextLine();

        while (!name.equals("stop")){
           if (map.containsKey(name)){
               System.out.printf("%s -> %s%n", name, map.get(name));
           }else {
               System.out.printf("Contact %s does not exist.%n", name);
           }
            name = scanner.nextLine();
        }
    }
}
