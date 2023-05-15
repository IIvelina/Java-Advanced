package Lab;

import java.util.Scanner;

public class task7_1FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //само една кралица е с валидна позция, защото по диягоналите няма друга кралица, с
        // която да се бие
        //пускаме 2 фор за да обикаляме матрицата
        //когато срещнем кралица викаме метод, който връща булева стойност
        //този метод ходи във всики възможни посоки
        //и ако срещне някъде по всички възможни страни кралица значи е грешно
        //на първото място, където няма друга кралица печатаме индексите

        String[][] matrix = new String[8][8];

        //четем

        for (int r = 0; r < 8; r++) {
            String[] input = scanner.nextLine().split("\\s+");
            matrix[r] = input;
        }

        //обхождаме

        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
               String currentElement = matrix[r][c];

               if (currentElement.equals("q")){

                   boolean result = isWin(matrix, r, c, currentElement);
                   if (result){
                       System.out.println(r + " " + c);
                       return;
                   }

               }else {
                   continue;
               }
            }
        }
    }

    private static boolean isWin(String[][] matrix, int r, int c, String currentElement) {



        for (int row = r; row <= r; row++) {
            for (int col = c - 1; col >= 0; col--) {
               boolean result = isQueenFound(matrix, row, col, currentElement);
               if (!result){
                   return false;
               }
            }
        }
        for (int row = r; row <= r; row++) {
            for (int col = c+1; col < 8; col++) {
                boolean result = isQueenFound(matrix, row, col, currentElement);
                if (!result){
                    return false;
                }
            }
        }
        for (int col = c; col <= c; col++) {
            for (int row = r - 1; row >= 0; row--) {
                boolean result = isQueenFound(matrix, row, col, currentElement);
                if (!result){
                    return false;
                }
            }
        }
        for (int col = c; col <=c ; col++) {
            for (int row = r+1; row < 8; row++) {
                boolean result = isQueenFound(matrix, row, col, currentElement);
                if (!result){
                    return false;
                }
            }
        }
        for (int row = r+1; row < 8;) {
            int column = 0;
            int lines = 0;
            for (int col = c-1; col >=0 ; col--) {
                boolean result = isQueenFound(matrix, row, col, currentElement);
                row++;
                column = col;
                lines = row;
                if (column == 0 || lines == 7){
                    break;
                }
                if (!result){
                    return false;
                }
            }
            if (column == 0 || lines == 7){
                break;
            }
        }
        for (int row = r-1; row >=0;) {
            int column = 0;
            int lines = 0;
            for (int col = c+1; col < 8; col++) {
                boolean result = isQueenFound(matrix, row, col, currentElement);
                row--;
                column = col;
                lines = row;
                if (column == 7 || lines ==0){
                    break;
                }
                if (!result){
                    return false;
                }
            }
            if (column == 7 || lines ==0){
                break;
            }
        }
        for (int row = r-1; row >=0 ; ) {
            int column = 0;
            int lines = 0;
            for (int col = c-1; col >=0 ; col--) {

                boolean result = isQueenFound(matrix, row, col, currentElement);
                row--;

                column = col;
                lines = row;
                if (column == 0 || lines == 0){
                    break;
                }

                if (!result){
                    return false;
                }
            }
            if (column == 0 || lines == 0){
                break;
            }
        }

        for (int row = r+1; row < 8;) {
            int column = 0;
            int lines = 0;
            for (int col = c+1; col < 8; col++) {
                boolean result = isQueenFound(matrix, row, col, currentElement);
                row++;

                column = col;
                lines = row;
                if (column == 7 || lines == 7){
                    break;
                }
                if (!result){
                    return false;
                }
            }
            if (column == 7 || lines == 7){
                break;
            }
        }
        return true;
    }

    private static boolean isQueenFound(String[][]matrix, int row, int col, String currentElement) {
        if (matrix[row][col].equals(currentElement)){
            return false;
        }
        return true;
    }
}
