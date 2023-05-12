package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class task4MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Integer> bracket = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (symbol == '('){
                bracket.push(i);

            }else if (symbol == ')'){
                int lastOpenIndex = bracket.pop();
                System.out.println(input.substring(lastOpenIndex, i+1));
            }
        }
    }
}
