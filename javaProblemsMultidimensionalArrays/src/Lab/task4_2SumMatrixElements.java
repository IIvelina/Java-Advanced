package Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class task4_2SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split(", ")[0]);
        int cols = Integer.parseInt(input.split(", ")[1]);
        int[][] matrix = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(e -> Integer.parseInt(e))
                    .toArray();

            matrix[r] = currentRow;
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
