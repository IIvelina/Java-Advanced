package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class task6FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> map = new LinkedHashMap<>();

        while (!input.equals("stop")){
            String email = scanner.nextLine();
            String[] splitEmail = email.split("\\.");
            int index = splitEmail.length - 1;
            String lastEl = splitEmail[index];
            if (lastEl.equals("us") || lastEl.equals("uk") || lastEl.equals("com")){
                input = scanner.nextLine();
                continue;
            }else {
                map.put(input, email);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
