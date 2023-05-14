package Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class task8WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int[][]matrix = new int[rows][];

        for (int r = 0; r < rows; r++) {
            int[] currentRow = readArray(scanner);
            matrix[r] = currentRow;
        }
        String input = scanner.nextLine();
        int rWrong = Integer.parseInt(input.split("\\s+")[0]);
        int cWrong = Integer.parseInt(input.split("\\s+")[1]);
        
        int wrongNumber = matrix[rWrong][cWrong];

        List<int[]> correctValues = new ArrayList<>();

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == wrongNumber){
                    int correct = getNearBySum(matrix, r, c, wrongNumber);

                    correctValues.add(new int[]{r, c, correct});
                }
            }
        }
        for (int[] correctValue : correctValues) {
           // matrix[correctValue[0]][correctValue [1]] = correctValue[2];
            int row = correctValue[0];
            int col = correctValue[1];
            matrix[row][col] = correctValue[2];
        }
        for (int[] arr : matrix) {
            for (int n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    private static int getNearBySum(int[][] matrix, int r, int c, int valueToReplace) {
        int sum = 0;

        if (isInBounds(matrix,r+1,c) && matrix[r+1][c] != valueToReplace){
            sum += matrix[r+1][c];
        }
        if (isInBounds(matrix, r-1, c) && matrix[r-1][c] != valueToReplace){
            sum += matrix[r-1][c];
        }
        if (isInBounds(matrix, r, c-1) && matrix[r][c-1] != valueToReplace){
            sum += matrix[r][c-1];
        }
        if (isInBounds(matrix, r, c+1) && matrix[r][c+1] != valueToReplace){
            sum += matrix[r][c+1];
        }

        return sum;
    }
 //този метод работи за всяка една мартица и проверява дали даден ред се намира в ред и колона
    private static boolean isInBounds(int[][] matrix, int r, int c) {
        return  r >= 0 && r < matrix.length &&
                c >= 0 && c < matrix[r].length;
    }
    //за да проверим дали е извън рамките
    private static boolean isOutOfBounds(int[][] matrix, int r, int c) {
        return !isInBounds(matrix, r, c);
    }



    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
