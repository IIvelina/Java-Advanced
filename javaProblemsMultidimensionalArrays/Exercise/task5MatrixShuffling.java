package Exercise;

import java.util.Scanner;

public class task5MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dimensions = scanner.nextLine();
        int rows = Integer.parseInt(dimensions.split("\\s+")[0]);
        int cols = Integer.parseInt(dimensions.split("\\s+")[1]);

        String[][]matrix = new String[rows][cols];

        //попълваме матрицата с данни от конзолата
        fillMatrix(matrix, scanner);

        String command = scanner.nextLine();
        while (!command.equals("END")){
            //валидиране на команда
            // валидна
            if (validateCommand(command, rows, cols)){
                //щом е валидна има всички компоненти и можем да я извадим
                String[]commandParts = command.split("\\s+");
                int row1 = Integer.parseInt(commandParts[1]);
                int col1 = Integer.parseInt(commandParts[2]);
                int row2 = Integer.parseInt(commandParts[3]);
                int col2 = Integer.parseInt(commandParts[4]);

                //успешно можем да направим размяната
                String firstElement = matrix[row1][col1];
                String secondElement = matrix[row2][col2];

                matrix[row1][col1] = secondElement;
                matrix[row2][col2] = firstElement;

                printMatrix(matrix, rows, cols);

            }
            //невалидна
            else {
                System.out.println("Invalid input!");
            }
            command = scanner.nextLine();
        }

    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int r = 0; r < matrix.length; r++) {
            String[]input = scanner.nextLine().split("\\s+");
            matrix[r] = input;
        }
    }

    private static boolean validateCommand(String command, int rows, int cols){
        //true -> ако командата е валидна
        //false -> ако не е валидна
        //command = "swap row1 col1 rol2 col2"
        String[]commandParts = command.split("\\s+");
        //1. брой на параметрите на командата да са 5
        if (commandParts.length != 5){
            return false;
        }
        //2. започва ли със swap
        if (!commandParts[0].equals("swap")){
            return false;
        }
        //3. дали редовете и колоните дадени в командата ги има в мартицата
        int row1 = Integer.parseInt(commandParts[1]); //>=0 && < бр. редове
        int col1 = Integer.parseInt(commandParts[2]); //>=0 && < бр. колони
        int row2 = Integer.parseInt(commandParts[3]); //>=0 && < бр. редове
        int col2 = Integer.parseInt(commandParts[4]); //>=0 && < бр. колони

        if (row1 < 0 || row1 > rows || row2 < 0 || row2 > rows  ||
                col1 < 0 || col1 > rows ||   col2 < 0 || col2 > rows){
            return false;
        }
        return true;
    }

    private static void printMatrix(String[][]matrix, int rows, int cols){
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }

    }
}
