package Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class task6StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rotations = scanner.nextLine();
        String rotationSting = rotations.split("[()]")[1];
        int rotationNumber = Integer.parseInt(rotationSting);
        int angleOfRations = rotationNumber % 360;

        String input = scanner.nextLine();

        List<String> wordlist = new ArrayList<>();
        int maxLength = Integer.MIN_VALUE;

        while (!input.equals("END")){
            wordlist.add(input);

            if (input.length() > maxLength){
                maxLength = input.length();
            }

            input = scanner.nextLine();
        }
        int rows = wordlist.size();
        int cols = maxLength;
        
        char[][]matrix = new char[rows][cols];

        for (int r = 0; r < rows; r++) {
            String currentWord = wordlist.get(r);
            for (int c = 0; c < cols; c++) {
                if (c < currentWord.length()) {
                    char currentSymbol = currentWord.charAt(c);
                    matrix[r][c] = currentSymbol;
                }else {
                    matrix[r][c] = ' ';
                }
            }
        }
        switch (angleOfRations){
            case 0:
                for (int r = 0; r < rows; r++) {
                    for (int c = 0; c < cols; c++) {
                        System.out.print(matrix[r][c]);
                    }
                    System.out.println();
                }
                break;
            case 90:
                //rows-- cols++
                for (int c = 0; c < cols; c++) {
                    for (int r = rows - 1; r >= 0; r--) {
                        System.out.print(matrix[r][c]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                //от последния ред и от последнат колона
                for (int r = rows-1; r >= 0; r--) {
                    for (int c = cols - 1; c >= 0; c--) {
                        System.out.print(matrix[r][c]);
                    }
                    System.out.println();
                }
                break;
            case 270:
                //отдясно на ляво и отгоре надолу
                for (int c = cols -1; c >= 0; c--) {
                    for (int r = 0; r < rows; r++) {
                        System.out.print(matrix[r][c]);
                    }
                    System.out.println();
                }
                break;
        }
    }
}
