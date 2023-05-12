package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class task5_2BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //100/100

        String input = scanner.nextLine();

        ArrayDeque<Character> openBracketsStack = new ArrayDeque<>();

        boolean areBalanced = false;

        for (int index = 0; index < input.length(); index++) {
            char currentBracket = input.charAt(index);

            if (currentBracket == '(' || currentBracket == '[' || currentBracket == '{'){
                openBracketsStack.push(currentBracket);
            }else if (currentBracket == ')' || currentBracket == ']' || currentBracket == '}'){
                if (openBracketsStack.isEmpty()){
                    areBalanced = false;
                    break;
                }
                char lastOpen = openBracketsStack.pop();

                if (currentBracket == '}' && lastOpen == '{'){
                    areBalanced = true;
                }else if (currentBracket == ']' && lastOpen == '['){
                    areBalanced = true;
                }else if (currentBracket == ')' && lastOpen == '('){
                    areBalanced = true;
                }else {
                    areBalanced = false;
                    break;
                }
            }
        }
        if (areBalanced){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
