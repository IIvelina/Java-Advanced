package Exercise;

import java.util.Scanner;

public class task1FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int rows = Integer.parseInt(input.split(", ")[0]);
        String pattern = input.split(", ")[1];

        int[][] matrix = new int[rows][rows];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                if (pattern.equals("A")) {
                    printMatrixWithPatternA(matrix, col, row);
                    return;
                } else if (pattern.equals("B")) {
                    printMatrixWithPatternB(matrix, col, row);
                    return;
                }
            }
        }
    }

    private static void printMatrixWithPatternA(int[][] matrix, int col, int row) {
        int count = 1;
        for (int c = 0; c < matrix.length; c++) {
            for (int r = 0; r < matrix.length; r++) {
                matrix[r][c] = count++;
            }
        }
        printMatrix(matrix);
    }

    private static void printMatrixWithPatternB(int[][] matrix, int col, int row) {
        int size = matrix.length;
        int count = 1;
        for (int c = 0; c < matrix.length; c++) {
            if (c % 2 == 0){
                for (int r = 0; r < size; r++) {
                    matrix[r][c] = count;
                    count++;
                }
            }else {
                for (int r = size - 1; r >= 0 ; r--) {
                    matrix[r][c] = count;
                    count++;
                }
            }
        }
        printMatrix(matrix);
    }
    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
