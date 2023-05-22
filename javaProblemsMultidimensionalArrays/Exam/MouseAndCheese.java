package MultidimensionalArrays;

import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];
        int mouseRow = -1;//ред на мишката
        int mouseCol = -1;//колона мишка
        int countCheese = 0;

        fillMatrix(scanner, n, matrix);

        //намираме къде е текущато състояние на мишката
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                char currentSymbol = matrix[r][c];
                if (currentSymbol == 'M'){
                    mouseRow = r;
                    mouseCol = c;
                }
            }
        }

        String direction = scanner.nextLine();
        while (!direction.equals("end")){

            //direction -> up down left right
            matrix[mouseRow][mouseCol] = '-';
            switch (direction){
                case "up":
                    //намаляме реда с 1
                    mouseRow--;
                    break;
                case "down":
                    //увеличаваме реда с 1
                    mouseRow++;
                    break;
                case "left":
                    //намаляваме колоната с 1
                    mouseCol--;
                    break;
                case "right":
                    //увеличаваме колоната с 1
                    mouseCol++;
                    break;
            }
            //преди да преместим мишката проверяваме дали границите са валидни
            if (mouseCol < 0 || mouseCol >= n || mouseRow < 0 || mouseRow >= n){
                System.out.println("Where is the mouse?");
                break;
            }else {
                //трябва да проверим мястото на което ще отиде мишката
                if (matrix[mouseRow][mouseCol] == 'c'){
                    //имаме сиренце
                    countCheese++;
                }else if(matrix[mouseRow][mouseCol] == 'B'){
                    //имаме бонус
                    //ако получим бонус не поставяме мишката
                    //поставяме я на следващия ход
                    continue;
                }
                matrix[mouseRow][mouseCol] = 'M';
            }
            direction = scanner.nextLine();
        }
        if (countCheese >= 5){
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", countCheese);
        }else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - countCheese);
        }
        printMatrix(n, matrix);
    }

    private static void printMatrix(int n, char[][] matrix) {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, int n, char[][] matrix) {
        for (int r = 0; r < n; r++) {
            String rowContent = scanner.nextLine(); //M--
            char[] rowSymbols = rowContent.toCharArray(); //['M','-','-']
            matrix[r] = rowSymbols;
        }
    }
}
