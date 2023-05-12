package Exercise;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Scanner;

public class task7_1SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> stack = new ArrayDeque<>();

        StringBuilder currentText = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            int command = Integer.parseInt(input[0]);
            
            if (command == 1){
                String string = input[1];
                currentText.append(string);

                stack.push(currentText.toString());

            }else if (command == 2){
                int count = Integer.parseInt(input[1]);
                int startIndex = currentText.length() - count;
               // String textForRemove = currentText.substring(startIndex); //to the end
                currentText = currentText.replace(startIndex, startIndex + count, "");
                //currentText.toString().replaceFirst(textForRemove, "");

                stack.push(currentText.toString());

            }else if (command == 3){
                int index = Integer.parseInt(input[1]);
                System.out.println(currentText.charAt(index - 1));

            }else if (command == 4){
                if (stack.size() > 1) {
                    stack.pop();
                    currentText = new StringBuilder(stack.peek());
                }else {
                    currentText = new StringBuilder();
                }

            }
        }
    }
}
