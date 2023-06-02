package MultidimensionalArrays;

import java.util.Scanner;

public class NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        int myRow = -1;
        int myCol = -1;

        for (int r = 0; r < size; r++) {
            String[] currentRow = scanner.nextLine().split("");
            for (int c = 0; c < size; c++) {
                matrix[r][c] = currentRow[c];

                if (matrix[r][c].equals("S")) {
                    myRow = r;
                    myCol = c;
                }
            }
        }
        //"up", "down", "left" and "right"
        int mine = 0;
        int cruiser = 0;

        boolean isFailed = false;
        while (true){
            String command = scanner.nextLine();

            int oldRow = myRow;
            int oldCol = myCol;

            if (command.equals("up")){
                myRow--;
            }else if (command.equals("down")){
                myRow++;
            }else if (command.equals("left")){
                myCol--;
            }else if (command.equals("right")){
                myCol++;
            }

            if (matrix[myRow][myCol].equals("-")){
                matrix[oldRow][oldCol] = "-";
                matrix[myRow][myCol] = "S";
            }else if (matrix[myRow][myCol].equals("*")){
                mine++;
                if (mine == 3){
                    isFailed = true;
                    //Mission failed, U-9 disappeared! Last known coordinates [{row}, {col}]!
                    matrix[oldRow][oldCol] = "-";
                    matrix[myRow][myCol] = "S";
                    System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", myRow, myCol);
                    printMatrix(size, matrix);
                    return;
                }else {
                    matrix[oldRow][oldCol] = "-";
                    matrix[myRow][myCol] = "S";
                }
            }else if (matrix[myRow][myCol].equals("C")){
                cruiser++;
                if (cruiser < 3){
                    matrix[oldRow][oldCol] = "-";
                    matrix[myRow][myCol] = "S";
                }else {
                    //Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!
                    matrix[oldRow][oldCol] = "-";
                    matrix[myRow][myCol] = "S";
                    System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                    printMatrix(size, matrix);
                    return;
                }
            }
        }
    }

    private static void printMatrix(int size, String[][] matrix) {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}
