package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class task5PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();

        String input = scanner.nextLine();

        while (!input.equals("print")) {


            if (!input.equals("cancel")) {
                queue.offer(input);

            } else {
                if (queue.size() > 1) {
                    String document = queue.poll();
                    System.out.println(("Canceled " + document));
                } else {
                    if (queue.size() == 1) {
                        String document = queue.poll();
                        System.out.println("Canceled " + document);
                    } else {
                        System.out.println("Printer is on standby");
                    }
                }
            }

            input = scanner.nextLine();
        }
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
