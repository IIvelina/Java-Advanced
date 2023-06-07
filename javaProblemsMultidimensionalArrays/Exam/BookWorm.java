package MultidimensionalArrays;

import java.util.Scanner;

public class BookWorm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String initial = scanner.nextLine();
        int size = Integer.parseInt(scanner.nextLine());
        String[][]matrix = new String[size][size];

        int myRow = -1;
        int myCol = -1;

        for (int r = 0; r < size; r++) {
            String[] currentRow = scanner.nextLine().split("");
            for (int c = 0; c < size; c++) {
                matrix[r][c] = currentRow[c];

                if (matrix[r][c].equals("P")){
                    myRow = r;
                    myCol = c;
                }
            }
        }

   String command = scanner.nextLine();

        while (!command.equals("end")){

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
            if (myCol < 0 || myCol >= size || myRow < 0 || myRow >= size) {
                //губи последна буква
                //остава на същата позиция
                if(initial.length() > 1) {
                    initial = initial.substring(0, initial.length() - 1);
                }
                myRow = oldRow;
                myCol = oldCol;
            }else if (matrix[myRow][myCol].equals("-")){
                matrix[oldRow][oldCol] = "-";
                matrix[myRow][myCol] = "P";
            }else {
                String letter = matrix[myRow][myCol];
                initial+=letter;
                matrix[oldRow][oldCol] = "-";
                matrix[myRow][myCol] = "P";
            }
            command = scanner.nextLine();
        }
        System.out.println(initial);
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}
