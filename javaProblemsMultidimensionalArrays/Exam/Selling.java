package MultidimensionalArrays;

import java.util.Scanner;

public class Selling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];

        int myRow = -1;
        int myCol = -1;
        int firstPillarRow = -1;
        int firstPillarCol = -1;
        int secondPillarRow = -1;
        int secondPillarCol = -1;
        boolean firstPillarFound = false;
        for (int r = 0; r < size; r++) {
            String[] input = scanner.nextLine().split("");
            for (int c = 0; c < size; c++) {
                //попълва елементите един по един, а не целия ред
                matrix[r][c] = input[c];

                if (matrix[r][c].equals("S")) {
                    myRow = r;
                    myCol = c;
                }

                if (matrix[r][c].equals("O") && firstPillarFound == false) {
                    firstPillarRow = r;
                    firstPillarCol = c;
                    firstPillarFound = true;
                }
                if (matrix[r][c].equals("O") && firstPillarFound == true) {
                    secondPillarRow = r;
                    secondPillarCol = c;
                }
            }
        }
        int money = 0;
        while (true) {
            String command = scanner.nextLine();
            int oldRow = myRow;
            int oldCol = myCol;

            if (command.equals("up")) {
                myRow--;
            } else if (command.equals("down")) {
                myRow++;
            } else if (command.equals("left")) {
                myCol--;
            } else if (command.equals("right")) {
                myCol++;
            }
            if (myCol < 0 || myCol >= size || myRow < 0 || myRow >= size) {
                matrix[oldRow][oldCol] = "-";
                break;
            }
            if (myCol == firstPillarCol && myRow == firstPillarRow) {
                myRow = secondPillarRow;
                myCol = secondPillarCol;
                matrix[oldRow][oldCol] = "-";
                matrix[firstPillarRow][firstPillarCol] = "-";
                matrix[myRow][myCol] = "O";
            } else if (myCol == secondPillarCol && myRow == secondPillarRow) {
                myRow = firstPillarRow;
                myCol = firstPillarCol;
                matrix[oldRow][oldCol] = "-";
                matrix[secondPillarRow][secondPillarCol] = "-";
                matrix[myRow][myCol] = "O";
            } else if (matrix[myRow][myCol].equals("-")) {
                matrix[oldRow][oldCol] = "-";
                matrix[myRow][myCol] = "S";
            } else {
                money += Integer.parseInt(matrix[myRow][myCol]);
                matrix[oldRow][oldCol] = "-";
                matrix[myRow][myCol] = "S";
            }

            if (money >= 50) {
                break;
            }

        }

        if (money >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        } else {
            System.out.println("Bad news, you are out of the bakery.");
        }
        System.out.println("Money: " + money);
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
        //S -> моята позиция
        //0-9 -> клиенти
        //'О' -> стълбове или са 0 или са 2
        //'-' -> празна позиция
        //ако срещнем клиент взимаме цифрата и става '-'
        //ако стигна стълб се мястя на позицията на другия стълб и 2-та изчезват
        //ако излезне от матрицата приключва програмта
        //ако парите са >= на 50 приключва

    }
}
