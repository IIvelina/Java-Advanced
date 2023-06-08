package MultidimensionalArrays;

import java.util.Scanner;

public class Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][]matrix = new String[size][size];
        int myRow = -1;
        int myCol = -1;
        int firstRowM = -1;
        int firstColM = -1;
        int secondRowM = -1;
        int secondColM = -1;
        boolean isFound = false;
        for (int r = 0; r < size; r++) {
            String[]current = scanner.nextLine().split("");
            for (int c = 0; c < size; c++) {
                matrix[r][c] = current[c];

                if (matrix[r][c].equals("A")){
                    myRow = r;
                    myCol = c;
                }
                if (matrix[r][c].equals("M") && isFound == false){
                    isFound = true;
                    firstRowM = r;
                    firstColM = c;
                }
                if (matrix[r][c].equals("M") && isFound == true){
                    secondRowM = r;
                    secondColM = c;
                }
            }
        }
        int coins = 65;
        int findCoins = 0;
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
            }else if (command.equals("right")) {
                myCol++;
            }

            if (myCol < 0 || myCol >= size || myRow < 0 || myRow >= size) {
                matrix[oldRow][oldCol] = "-";
                break;
            }else if (matrix[myRow][myCol].equals("M")){
                if (myRow == firstRowM && myCol == firstColM){
                    matrix[oldRow][oldCol] = "-";
                    matrix[myRow][myCol] = "-";
                    myRow = secondRowM;
                    myCol = secondColM;
                    matrix[myRow][myCol] = "A";
                }else if (myRow == secondRowM && myCol == secondRowM){
                    matrix[oldRow][oldCol] = "-";
                    matrix[myRow][myCol] = "-";
                    myRow = firstRowM;
                    myCol = firstColM;
                    matrix[myRow][myCol] = "A";
                }
            }else if (matrix[myRow][myCol].equals("-")){
                matrix[oldRow][oldCol] = "-";
                matrix[myRow][myCol] = "A";
            }else {
                int gold = Integer.parseInt(matrix[myRow][myCol]);
                findCoins += gold;
                matrix[oldRow][oldCol] = "-";
                matrix[myRow][myCol] = "A";
                if (findCoins >= coins){
                    break;
                }
            }
        }
        if (findCoins >= coins){
            System.out.println("Very nice swords, I will come back for more!");
        }else {
            System.out.println("I do not need more swords!");
        }
        System.out.printf("The king paid %d gold coins.%n", findCoins);

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}
