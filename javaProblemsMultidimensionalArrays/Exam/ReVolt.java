import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int count = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];
        int myRow = -1;
        int myCol = -1;

        for (int r = 0; r < size; r++) {
            String[] currentRow = scanner.nextLine().split("");
            for (int c = 0; c < size; c++) {
                matrix[r][c] = currentRow[c];

                if (matrix[r][c].equals("f")) {
                    myRow = r;
                    myCol = c;
                }
            }
        }
        String command = scanner.nextLine();
        boolean isWin = false;

      while (count-- > 0){

            int oldRow = myRow;
            int oldCol = myCol;

            if (command.equals("up")) {
                if (myRow == 0) {
                    myRow = size - 1;
                } else {
                    myRow--;
                }
            } else if (command.equals("down")) {
                if (myRow == size - 1) {
                    myRow = 0;
                } else {
                    myRow++;
                }
            } else if (command.equals("left")) {
                if (myCol == 0) {
                    myCol = size - 1;
                } else {
                    myCol--;
                }
            } else if (command.equals("right")) {
                if (myCol == size - 1) {
                    myCol = 0;
                } else {
                    myCol++;
                }
            }

            if (matrix[myRow][myCol].equals("F")) {
                isWin = true;
                if (!matrix[myRow][oldCol].equals("B")) {
                    matrix[oldRow][oldCol] = "-";
                }
                matrix[myRow][myCol] = "f";
                break;
            } else if (matrix[myRow][myCol].equals("B")) {
                matrix[oldRow][oldCol] = "-";
                count++;
                continue;
            } else if (matrix[myRow][myCol].equals("T")) {
                //оставам на същата позиция
                myRow = oldRow;
                myCol = oldCol;
            } else if (matrix[myRow][myCol].equals("-")) {
                if (!matrix[oldRow][oldCol].equals("B")) {
                    matrix[oldRow][oldCol] = "-";
                }
                matrix[myRow][myCol] = "f";
            }
            if (count == 0){
                break;
            }else {
                command = scanner.nextLine();
            }
        }

        if (isWin) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}
