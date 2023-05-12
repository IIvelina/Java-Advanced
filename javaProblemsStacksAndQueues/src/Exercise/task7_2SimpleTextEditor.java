package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class task7_2SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder();

        ArrayDeque<String> stack = new ArrayDeque<>(); // пазим всяка една промяна на текста

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String command = input.split("\\s+")[0];

            switch (command){
                case "1":
                    String commandText = input.split("\\s+")[1];
                    text.append(commandText);

                    stack.push(text.toString());
                    break;
                case "2":
                    int commandCount = Integer.parseInt(input.split("\\s+")[1]);
                    int startIndex = text.length() - commandCount;
                    text.delete(startIndex, text.length());

                    stack.push(text.toString());
                    break;
                case "3":
                    int index = Integer.parseInt(input.split("\\s+")[1]);
                    System.out.println(text.charAt(index - 1)); //печата елемента на съответния индекс
                    break;
                case "4":
                    if (stack.size() > 1) {
                        //да се върнем към последната дума
                        stack.pop();
                        //правим нашата текуща дума равна на предната
                        text = new StringBuilder(stack.peek());
                    }else {
                        //щом стена е празен:
                        text = new StringBuilder();
                    }
                    break;
            }
        }
    }
}
