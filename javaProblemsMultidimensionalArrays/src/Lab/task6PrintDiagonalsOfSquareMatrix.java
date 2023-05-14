package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class task6PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][]matrix = new int[rows][rows];

        for (int r = 0; r < rows; r++) {
            int[]input = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(e -> Integer.parseInt(e))
                    .toArray();

            matrix[r] = input;
        }
        for (int i = 0; i < rows; i++) { //0 //1 //2
            System.out.print(matrix[i][i] + " "); //00 //11 //22
        }
        System.out.println();

        int col = 0;
        for (int i = rows - 1; i >= 0; i--) {
            System.out.print(matrix[i][col] + " ");
            col++;
        }
    }
}
