package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];
        char[][] matrix = new char[rows][cols];
        //слага целия ред, пълним матрицата
        for (int r = 0; r < dimensions[0]; r++) {
            char[] currentRow = scanner.nextLine().replace(" ", "").toCharArray();
            matrix[r] = currentRow;
        }

        //намираме къде сме ние и къде е съкровището
        int myRow = -1;
        int myCol = -1;
        int treasureRow = -1;
        int treasureCol = -1;
        for (int r = 0; r < matrix.length; r++) {
            char[] chars = matrix[r];
            for (int c = 0; c < chars.length; c++) {
                char current = chars[c];

                if (current == 'Y'){
                    myRow = r;
                    myCol = c;
                }

                if (current == 'X'){
                    treasureRow = r;
                    treasureCol = c;
                }
            }
        }

        List<String> commandsAll = new ArrayList<>();
        String command = scanner.nextLine();
        while (!command.equals("Finish")){

           switch (command){
               case "up":
                   if (myRow > 0){
                       char symbol = matrix[--myRow][myCol];
                       if (symbol == 'T'){
                           myRow++;
                       }else {
                           //valid move
                           commandsAll.add(command);
                       }
                   }
                   break;
               case "down":
                   if (myRow < matrix.length - 1){
                       char symbol = matrix[++myRow][myCol];
                       if (symbol == 'T'){
                           myRow--;
                       }else {
                           commandsAll.add(command);
                       }
                   }
                   break;
               case "left":
                   if (myCol > 0){
                       char symbol = matrix[myRow][--myCol];
                       if (symbol == 'T'){
                           myCol++;
                       }else {
                           commandsAll.add(command);
                       }
                   }
                   break;
               case "right":
                   if (myCol < cols - 1){
                       char symbol = matrix[myRow][++myCol];
                       if (symbol == 'T'){
                           myCol--;
                       }else {
                           commandsAll.add(command);
                       }
                   }
                   break;
           }
            command = scanner.nextLine();
        }

        if (myRow == treasureRow && myCol == treasureCol){
            System.out.println("I've found the treasure!");
            System.out.print("The right path is ");
            String moves = String.join(", ", commandsAll);
            System.out.println(moves);
        }else {
            System.out.println("The map is fake!");
        }
    }
}
