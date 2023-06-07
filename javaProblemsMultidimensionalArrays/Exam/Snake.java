package MultidimensionalArrays;

import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][]matrix = new String[size][size];

        int myRow = -1;
        int myCol = -1;
        int firstLairRow = -1;
        int firstLairCol = -1;
        int secondLairRow = -1;
        int secondLairCol = -1;
        boolean isFindFirstLair = false;
        for (int r = 0; r < size; r++) {
            String[] currentRow = scanner.nextLine().split("");
            for (int c = 0; c < size; c++) {
                matrix[r][c] = currentRow[c];

                if (matrix[r][c].equals("S")){
                    myRow = r;
                    myCol = c;
                }

                if (matrix[r][c].equals("B") && isFindFirstLair == false){
                    isFindFirstLair = true;
                    firstLairRow = r;
                    firstLairCol = c;
                }
                if (matrix[r][c].equals("B") && isFindFirstLair == true){
                    secondLairRow = r;
                    secondLairCol = c;
                }
            }
        }
        System.out.println();
        //* -food
        //B - lair
        //- - empty positions

        int foodQuantity = 0;
        boolean isFed = false;

        while (true){
            String command = scanner.nextLine();
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

            if (myCol < 0 || myCol >= size || myRow < 0 || myRow >= size) {
                matrix[oldRow][oldCol] = ".";
                break;
            }

            if (matrix[myRow][myCol].equals("B")){
               if (myRow == firstLairRow && myCol == firstLairCol){
                   matrix[oldRow][oldCol] = ".";
                   matrix[myRow][myCol] = ".";
                   myRow = secondLairRow;
                   myCol = secondLairCol;
                   matrix[myRow][myCol] = "S";
               }else if (myRow == secondLairRow && myCol == secondLairCol){
                   matrix[oldRow][oldCol] = ".";
                   matrix[myRow][myCol] = ".";
                   myRow = firstLairRow;
                   myCol = firstLairCol;
                   matrix[myRow][myCol] = "S";
               }
            }else if (matrix[myRow][myCol].equals("*")){
                foodQuantity++;
                matrix[oldRow][oldCol] = ".";
                matrix[myRow][myCol] = "S";
                if (foodQuantity == 10){
                    isFed = true;
                    break;
                }
            }else {
                matrix[oldRow][oldCol] = ".";
                matrix[myRow][myCol] = "S";
            }
        }
        if (isFed){
            System.out.println("You won! You fed the snake.");
        }else {
            System.out.println("Game over!");
        }
        System.out.printf("Food eaten: %d%n", foodQuantity);

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}
