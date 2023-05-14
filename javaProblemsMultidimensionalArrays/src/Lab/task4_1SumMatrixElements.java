package Lab;

import java.util.*;

public class task4_1SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int rows = Integer.parseInt(input.split(", ")[0]);
        int cols = Integer.parseInt(input.split(", ")[1]);

        int[][] matrix = new int[rows][cols];

        //int sum = 0;

        for (int row = 0; row < rows; row++) {
            String[] rowOfMatrix = scanner.nextLine().split(", ");

            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(rowOfMatrix[col]);
             //   sum += Integer.parseInt(rowOfMatrix[col]);
            }
        }
        int sum = sumMatrix(matrix);

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
    public static int sumMatrix(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        for (int[] row : matrix) {
            for (int element : row) {
                list.add(element);
            }
        }
        return list.stream().mapToInt(Integer::intValue).sum();
    }
}
