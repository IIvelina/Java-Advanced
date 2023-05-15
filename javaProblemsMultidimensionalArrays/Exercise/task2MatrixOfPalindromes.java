package Exercise;

import java.util.Scanner;

public class task2MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);

        String[][]matrix = new String[rows][cols];

        char firstSymbol = 'a';
        char secondSymbol = 'a';
        char thirdSymbol = 'a';

        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {
                // 97 97 97
                // 97 98 97

                String output = String.valueOf(firstSymbol) + String.valueOf(secondSymbol) + String.valueOf(thirdSymbol);

                matrix[r][c] = output;
                secondSymbol++;
            }
            firstSymbol++;
            secondSymbol = firstSymbol;
            thirdSymbol++;
        }
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }
}
