package MultidimensionalArrays;

import java.util.Scanner;

public class CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        //въвеждаме данните в мартицата и намираме ние къде се намираме и порталите къде са:
        String[][] matrix = new String[size][size];
        int currentRow = -1;
        int currentCol = -1;
        int firstPortalRow = -1;
        int firstPortalCol = -1;
        int secondPortalRow = -1;
        int secondPortalCol = -1;
        boolean firstPortalFound = false;
        for (int r = 0; r < size; r++) {
            String[] input = scanner.nextLine().split("");
            for (int c = 0; c < size; c++) {
                matrix[r][c] = input[c];

                if (matrix[r][c].equals("S")) {
                    currentRow = r;
                    currentCol = c;
                }

                if (matrix[r][c].equals("P") && firstPortalFound == false) {
                    firstPortalRow = r;
                    firstPortalCol = c;
                    firstPortalFound = true;
                }

                if (matrix[r][c].equals("P") && firstPortalFound == true) {
                    secondPortalRow = r;
                    secondPortalCol = c;

                }
            }
        }
        int money = 0;
        while (money < 50) {

            String command = scanner.nextLine();
            int oldRow = currentRow;
            int oldCol = currentCol;
            if (command.equals("up")){
                currentRow--;
            }else if (command.equals("down")){
                currentRow++;
            }else if (command.equals("left")){
                currentCol--;
            }else if (command.equals("right")){
                currentCol++;
            }

            if (currentCol < 0 || currentCol >= size || currentRow < 0 || currentRow >= size) {
                matrix[oldRow][oldCol] = "-";
                break;
            }
            if (currentCol == firstPortalCol && currentRow == firstPortalRow){
                currentRow = secondPortalRow;
                currentCol = secondPortalCol;
                matrix[oldRow][oldCol] = "-";
                matrix[firstPortalRow][firstPortalCol] = "-";
                matrix[currentRow][currentCol] = "S";
            }else if (currentRow == secondPortalRow && currentCol == secondPortalCol){
                currentRow = firstPortalRow;
                currentCol = firstPortalCol;
                matrix[oldRow][oldCol] = "-";
                matrix[secondPortalRow][secondPortalCol] = "-";
                matrix[currentRow][currentCol] = "S";
            }else if (matrix[currentRow][currentCol].equals("-")){
                //на празна клетка
                matrix[oldRow][oldCol] = "-";
                matrix[currentRow][currentCol] = "S";
            }else {
                money += Integer.parseInt(matrix[currentRow][currentCol]);
                matrix[oldRow][oldCol] = "-";
                matrix[currentRow][currentCol] = "S";
            }

        }
        if (money < 50){
            System.out.println("Bad news! You are out of the pastry shop.");
        }else {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.printf("Money: %d%n", money);
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}