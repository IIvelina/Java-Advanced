package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class task2PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);
        int[][]matrix = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(e -> Integer.parseInt(e))
                    .toArray();
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = currentRow[c];
            }
        }
        int num = Integer.parseInt(scanner.nextLine());

        boolean isFound = false;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == num){
                    System.out.println(r + " " + c);
                    isFound = true;
                }
            }
        }
        if (!isFound){
            System.out.println("not found");
        }
    }
}
