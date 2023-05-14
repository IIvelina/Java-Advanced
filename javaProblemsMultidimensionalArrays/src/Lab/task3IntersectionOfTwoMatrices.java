package Lab;

import java.util.Scanner;

public class task3IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] fistMatrix = new char[rows][cols];
        char[][] secondMatrix = new char[rows][cols];

        for (int r = 0; r < rows; r++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int c = 0; c < cols; c++) {

                String currentString = input[c];
                char symbol = currentString.charAt(0);
                fistMatrix[r][c] = symbol;
            }
        }

        for (int r = 0; r < rows; r++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int c = 0; c < cols; c++) {

                String currentString = input[c];
                char symbol = currentString.charAt(0);
                secondMatrix[r][c] = symbol;
            }
        }
        char[][] thirdMatrix = new char[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (fistMatrix[r][c] != secondMatrix[r][c]){
                    thirdMatrix[r][c] = '*';
                }else {
                    thirdMatrix[r][c] = fistMatrix[r][c];
                }
            }
        }
        for (int r = 0; r < rows; r++) {
            // Loop through each row
            for (int c = 0; c < cols; c++) {
                System.out.print(thirdMatrix[r][c] + " "); // Print the current element
            }
            System.out.println(); // Move to the next line after each row
        }
    }
}
