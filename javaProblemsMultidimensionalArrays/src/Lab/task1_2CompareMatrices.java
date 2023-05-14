package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class task1_2CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputFirstM = scanner.nextLine();
        int rowsFirstM = Integer.parseInt(inputFirstM.split("\\s+")[0]);
        int colsFirstM = Integer.parseInt(inputFirstM.split("\\s+")[1]);
        int[][] firstMatrix = new int[rowsFirstM][colsFirstM];
        for (int r = 0; r < rowsFirstM; r++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(e -> Integer.parseInt(e))
                    .toArray();
            firstMatrix[r] = currentRow;
        }

        String inputSecondM = scanner.nextLine();
        int rowsSecondM = Integer.parseInt(inputSecondM.split("\\s+")[0]);
        int colsSecondM = Integer.parseInt(inputSecondM.split("\\s+")[1]);
        if (rowsFirstM != rowsSecondM || colsFirstM != colsSecondM){
            System.out.println("not equal");
            return;
        }
        int[][]secondMatrix = new int[rowsSecondM][colsSecondM];
        for (int r = 0; r < rowsSecondM; r++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(e -> Integer.parseInt(e))
                    .toArray();
            secondMatrix[r] = currentRow;
        }
        boolean isEqual = true;
        for (int r = 0; r < rowsFirstM; r++) {
            for (int c = 0; c < colsFirstM; c++) {
                if (firstMatrix[r][c] == secondMatrix[r][c]){
                    continue;
                }else {
                    isEqual = false;
                    System.out.println("not equal");
                    return;
                }
            }
        }
        if (isEqual){
            System.out.println("equal");
        }
    }
}
