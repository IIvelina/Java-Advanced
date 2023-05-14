package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class task1_1CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String inputFistM = scanner.nextLine();
        int rowsFirstMatrix = Integer.parseInt(inputFistM.split("\\s+")[0]);
        int colsFirstMatrix = Integer.parseInt(inputFistM.split("\\s+")[1]);
        int[][] firstMatrix = new int[rowsFirstMatrix][colsFirstMatrix];

        for (int r = 0; r < rowsFirstMatrix; r++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(e -> Integer.parseInt(e))
                    .toArray();

            firstMatrix[r] = currentRow;
        }

        String inputSecondM = scanner.nextLine();
        int rowsSecondMatrix = Integer.parseInt(inputSecondM.split("\\s+")[0]);
        int colsSecondMatrix = Integer.parseInt(inputSecondM.split("\\s+")[1]);
        int[][] secondMatrix = new int[rowsSecondMatrix][colsSecondMatrix];

        for (int r = 0; r < rowsSecondMatrix; r++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(e -> Integer.parseInt(e))
                    .toArray();

            secondMatrix[r] = currentRow;
        }

        System.out.println(compareMatrices(firstMatrix, secondMatrix) ? "equal" : "not equal");
/*
        if (compareMatrices(firstMatrix, secondMatrix)) { //if is true
            System.out.println("equal");
        } else { // if si false
            System.out.println("not equal");
        }

 */
    }
    public static boolean compareMatrices(int[][] firstM, int[][] secondM) {
        // Step 1: Check dimensions
        // if rowF != rowS || colF != colS
        if (firstM.length != secondM.length || firstM[0].length != secondM[0].length) {
            return false;
        }

        // Step 2: Iterate through elements
        for (int i = 0; i < firstM.length; i++) {
            for (int j = 0; j < firstM[0].length; j++) {
                // Step 3: Compare elements
                if (firstM[i][j] != secondM[i][j]) {
                    return false;
                }
            }
        }
        // Step 4: All elements are equal
        return true;
    }
}
