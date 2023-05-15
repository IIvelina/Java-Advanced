package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class task4MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);

        int[][] matrix = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[r] = currentRow;
        }

        int maxValue = Integer.MIN_VALUE;
        int bestStartingRow = 0;
        int bestStartingCol = 0;

        for (int r = 0; r < rows - 2; r++) {
            for (int c = 0; c < cols - 2; c++) {
               /*
                int sumFirstRow = matrix[r][c] + matrix[r][c+1] + matrix[r][c+2];
                int sumSecondRow = matrix[r+1][c] + matrix[r+1][c+1] + matrix[r+1][c+2];
                int sumThirdRow = matrix[r+2][c] + matrix[r+2][c+1] + matrix[r+2][c+2];
                int sum = sumFirstRow + sumSecondRow + sumThirdRow;
                */

                int sum = 0;
                for (int currentRow = r; currentRow < r+3; currentRow++) {
                    for (int currentCol = c; currentCol < c+3; currentCol++) {
                        sum += matrix[currentRow][currentCol];
                    }
                }
                if (sum > maxValue){
                    maxValue = sum;
                    bestStartingRow = r;
                    bestStartingCol = c;
                }
            }
        }
        System.out.println("Sum = " + maxValue);

        for (int r = bestStartingRow; r < bestStartingRow + 3; r++) {
            for (int c = bestStartingCol; c < bestStartingCol + 3; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}
