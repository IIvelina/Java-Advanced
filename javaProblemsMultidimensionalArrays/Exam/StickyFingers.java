package MultidimensionalArrays;

import java.util.Scanner;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[]directions = scanner.nextLine().split(",");
        String[][]matrix = new String[size][size];

        int dillingerRow = -1;
        int dillingerCol = -1;

        for (int r = 0; r < size; r++) {
            String[]input = scanner.nextLine().split("\\s+");
            for (int c = 0; c < size; c++) {
                matrix[r][c] = input[c];

                if (matrix[r][c].equals("D")){
                    dillingerRow = r;
                    dillingerCol = c;
                }
            }
        }
        int stolenMoney = 0;
        boolean isCaught = false;
        for (int i = 0; i < directions.length; i++) {
            String command = directions[i];

            int oldRow = dillingerRow;
            int oldCol = dillingerCol;

            if (command.equals("up")){
                dillingerRow--;
            }else if (command.equals("down")){
                dillingerRow++;
            }else if (command.equals("left")){
                dillingerCol--;
            }else if (command.equals("right")){
                dillingerCol++;
            }
            if (dillingerCol < 0 || dillingerCol >= size || dillingerRow < 0 || dillingerRow >= size) {
                System.out.println("You cannot leave the town, there is police outside!");
                dillingerRow = oldRow;
                dillingerCol = oldCol;
            }else if (matrix[dillingerRow][dillingerCol].equals("$")){
                matrix[oldRow][oldCol] = "+";
                matrix[dillingerRow][dillingerCol] = "D";
                int stolen = dillingerRow * dillingerCol;
                System.out.printf("You successfully stole %d$.%n", stolen);
                stolenMoney += stolen;
            }else if (matrix[dillingerRow][dillingerCol].equals("P")){
                isCaught = true;
                matrix[oldRow][oldCol] = "+";
                matrix[dillingerRow][dillingerCol] = "#";
                break;
            }else {
                matrix[oldRow][oldCol] = "+";
                matrix[dillingerRow][dillingerCol] = "D";
            }
        }
        if (!isCaught){
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", stolenMoney);
        }else {
            System.out.printf("You got caught with %d$, and you are going to jail.%n", stolenMoney);
        }
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}
