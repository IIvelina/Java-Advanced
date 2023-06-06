package MultidimensionalArrays;

import java.util.Scanner;

public class Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] inputCommands = scanner.nextLine().split(", ");

        String[][]matrix = new String[size][size];

        int pythonRow = -1;
        int pythonCol = -1;
        int foodCount = 0;
        for (int r = 0; r < size; r++) {
            String[] currentRow = scanner.nextLine().split(" ");
            for (int c = 0; c < size; c++) {
                matrix[r][c] = currentRow[c];

                if (matrix[r][c].equals("s")){
                    pythonRow = r;
                    pythonCol = c;
                }
                if (matrix[r][c].equals("f")){
                    foodCount++;
                }
            }
        }

        boolean isEnd = true;
        int pythonLength = 1;

        for (int i = 0; i < inputCommands.length; i++) {
            String command = inputCommands[i];
            int oldRow = pythonRow;
            int oldCol = pythonCol;
            if (command.equals("up")){
                if (pythonRow == 0){
                    pythonRow = size -1;
                }else {
                    pythonRow--;
                }
            }else if (command.equals("down")){
                if (pythonRow == size -1){
                    pythonRow = 0;
                }else {
                    pythonRow++;
                }
            }else if (command.equals("left")){
                if (pythonCol == 0){
                    pythonCol = size -1;
                }else {
                    pythonCol--;
                }
            }else if (command.equals("right")){
                if (pythonCol == size -1){
                    pythonCol = 0;
                }else {
                    pythonCol++;
                }
            }

            if (matrix[pythonRow][pythonCol].equals("e")){
//represents an enemy
                matrix[oldRow][oldCol] = "*";
                isEnd = false;
                System.out.println("You lose! Killed by an enemy!");
                break;
            }else if (matrix[pythonRow][pythonCol].equals("f")){
//this is the food
                pythonLength++;
                matrix[oldRow][oldCol] = "*";
                matrix[pythonRow][pythonCol] = "s";
                if (pythonLength == foodCount + 1){
                    System.out.println("You win! Final python length is " + pythonLength);
                    isEnd = false;
                    break;
                }

            }else if (matrix[pythonRow][pythonCol].equals("*")){
                matrix[oldRow][oldCol] = "*";
                matrix[pythonRow][pythonCol] = "s";
            }
        }
        if (isEnd){
            System.out.printf("You lose! There is still %d food to be eaten.", foodCount - (pythonLength - 1));
        }
    }
}
