package MultidimensionalArrays;

import java.util.Scanner;

public class TheSquirrel_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] arr = scanner.nextLine().split(", ");

        String[][]matrix = new String[size][size];

        int squirrelRow = -1;
        int squirrelCol = -1;

        int trapRow = -1;
        int trapCol = -1;

        for (int r = 0; r < size; r++) {
            String[] inputMatrix = scanner.nextLine().split("");
            for (int c = 0; c < size; c++) {
                matrix[r][c] = inputMatrix[c];

                if (matrix[r][c].equals("s")){
                    squirrelRow = r;
                    squirrelCol = c;
                }

                if (matrix[r][c].equals("t")){
                    trapRow = r;
                    trapCol = c;
                }
            }
        }
        int hazelnuts = 0;

        boolean isTrap = false;
            //You win if the squirrel collects 3 of the hazelnuts
            //The squirrel steps on a trap
            //If the squirrel moves out of the field, the game ends and disappears from the screen.
            for (int i = 0; i < arr.length; i++) {
                String command = arr[i];
                int oldRow = squirrelRow;
                int oldCol = squirrelCol;
                if (command.equals("up")){
                    squirrelRow--;
                }else if (command.equals("down")){
                    squirrelRow++;
                }else if (command.equals("left")){
                    squirrelCol--;
                }else if (command.equals("right")){
                    squirrelCol++;
                }
                if (squirrelCol < 0 || squirrelCol >= size || squirrelRow < 0 || squirrelRow >= size){
                    System.out.println("The squirrel is out of the field.");
                    matrix[oldRow][oldCol] = "*";
                    // matrix[squirrelRow][squirrelCol] = "s";
                    isTrap = true;
                    break;
                }
                if (matrix[squirrelRow][squirrelCol].equals("h")){
                    hazelnuts++;
                    matrix[oldRow][oldCol] = "*";
                    matrix[squirrelRow][squirrelCol] = "s";
                    if (hazelnuts == 3){
                        System.out.println("Good job! You have collected all hazelnuts!");
                        break;
                    }

                }else if (squirrelRow == trapRow && squirrelCol == trapCol){
                    System.out.println("Unfortunately, the squirrel stepped on a trap...");
                    matrix[oldRow][oldCol] = "*";
                    matrix[squirrelRow][squirrelCol] = "*";
                    isTrap = true;
                    break;
                }else if (matrix[squirrelRow][squirrelCol].equals("*")){
                    matrix[oldRow][oldCol] = "*";
                    matrix[squirrelRow][squirrelCol] = "s";
                }
        }
            if (hazelnuts >= 3 || isTrap) {
                System.out.println("Hazelnuts collected: " + hazelnuts);
            }else{
                System.out.println("There are more hazelnuts to collect.");
                System.out.println("Hazelnuts collected: " + hazelnuts);
            }
    }
}
