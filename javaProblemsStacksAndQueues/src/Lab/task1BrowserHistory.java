package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class task1BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> history = new ArrayDeque<>();

       String input = scanner.nextLine();

       while (!input.equals("Home")){

           if (!input.equals("back")){
               history.push(input);
               System.out.println(input);
           }else {
               if (history.size() > 1){
                  history.pop();
                   System.out.println(history.peek());
               }else {
                   System.out.println("no previous URLs");
               }
           }

           input = scanner.nextLine();
       }
    }
}
