package MultidimensionalArrays;

import java.util.Scanner;

public class Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        String[] commands = scanner.nextLine().split(",");

        fillMatrix(scanner, n, matrix);

        int sapperRow = -1;
        int sapperCol = -1;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                char currentSymbol = matrix[r][c];
                String symbol = String.valueOf(currentSymbol);
                if (symbol.equals("s")){
                    sapperRow = r;
                    sapperCol = c;
                    break;
                }
            }
        }
        int countBomb = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == 'B'){
                    countBomb++;
                }
            }
        }

        int findBombCount = 0;
        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            if (command.equals("up")){
                sapperRow--;
                if (sapperCol < 0 || sapperCol >= n || sapperRow < 0 || sapperRow >= n){
                    sapperRow++;
                }
            }else if (command.equals("down")){
                sapperRow++;
                if (sapperCol < 0 || sapperCol >= n || sapperRow < 0 || sapperRow >= n){
                    sapperRow--;
                }
            }else if (command.equals("left")){
                sapperCol--;
                if (sapperCol < 0 || sapperCol >= n || sapperRow < 0 || sapperRow >= n){
                    sapperCol++;
                }
            }else if (command.equals("right")){
                sapperCol++;
                if (sapperCol < 0 || sapperCol >= n || sapperRow < 0 || sapperRow >= n){
                    sapperCol--;
                }
            }
            if (matrix[sapperRow][sapperCol] == 'e'){
                //end
                System.out.printf("END! %d bombs left on the field", countBomb - findBombCount);
                return;
            }
            if (matrix[sapperRow][sapperCol] == 'B'){
                findBombCount += 1;
                matrix[sapperRow][sapperCol] = '+';
                System.out.println("You found a bomb!");
                if (countBomb == findBombCount){
                    System.out.println("Congratulations! You found all bombs!");
                    return;
                }
            }
        }
        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", countBomb-findBombCount, sapperRow, sapperCol);
    }

    private static void fillMatrix(Scanner scanner, int n, char[][] matrix) {
        for (int r = 0; r < n; r++) {
            String[] rowContent = scanner.nextLine().split("\\s+"); //+ + + B +
            String string = "";
            for (String s : rowContent) {
                string+=s;
            }
            char[] rowSymbols = string.toCharArray(); //['+','+','+','B','+']
            matrix[r] = rowSymbols;
        }
    }
}
