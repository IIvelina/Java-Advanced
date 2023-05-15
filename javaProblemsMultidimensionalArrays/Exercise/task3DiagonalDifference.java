package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class task3DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][]matrix = new int[rows][rows];

        for (int r = 0; r < rows; r++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[r] = currentRow;
        }

        int sumPrimaryDiagonal = 0;

        for (int r = 0; r < rows;) {
            for (int c = 0; c < rows; c++) {
                sumPrimaryDiagonal += matrix[r][c];
                r++;
            }
        }

        int sumSecondaryDiagonal = 0;

        for (int r = 0; r < rows;) {
            for (int c = rows - 1; c >= 0; c--) {
              sumSecondaryDiagonal += matrix[r][c];
                r++;
            }
        }
        System.out.println(Math.abs(sumPrimaryDiagonal - sumSecondaryDiagonal));
    }
}
