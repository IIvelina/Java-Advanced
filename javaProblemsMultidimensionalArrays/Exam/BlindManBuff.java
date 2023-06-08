package MultidimensionalArrays;

import java.util.Scanner;

public class BlindManBuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(arr[0]);
        int cols = Integer.parseInt(arr[1]);

        String[][] matrix = new String[rows][cols];
        int myRow = -1;
        int myCol = -1;
        for (int r = 0; r < rows; r++) {
            String[] current = scanner.nextLine().split("\\s+");
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = current[c];

                if (matrix[r][c].equals("B")) {
                    myRow = r;
                    myCol = c;
                }
            }
        }
        String command = scanner.nextLine();

        int touchedOpponents = 0;
        int moves = 0;

        while (!command.equals("Finish")) {

            int oldRow = myRow;
            int oldCol = myCol;

            if (command.equals("up")) {
                myRow--;
            } else if (command.equals("down")) {
                myRow++;
            } else if (command.equals("left")) {
                myCol--;
            } else if (command.equals("right")) {
                myCol++;
            }

            if (myCol < 0 || myCol >= cols || myRow < 0 || myRow >= rows) {
                myRow = oldRow;
                myCol = oldCol;
            } else if (matrix[myRow][myCol].equals("O")) {
                myRow = oldRow;
                myCol = oldCol;
            } else if (matrix[myRow][myCol].equals("P")) {
                touchedOpponents++;
                moves++;
                if (touchedOpponents == 3) {
                    matrix[oldRow][oldCol] = "-";
                    matrix[myRow][myCol] = "B";
                    break;
                } else {
                    matrix[oldRow][oldCol] = "-";
                    matrix[myRow][myCol] = "B";
                }
            } else if (matrix[myRow][myCol].equals("-")) {
                moves++;
                matrix[oldRow][oldCol] = "-";
                matrix[myRow][myCol] = "B";
            }
            command = scanner.nextLine();
        }
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", touchedOpponents, moves);
    }
}
