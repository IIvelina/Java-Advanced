package Lab;

import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = {1, 2 , 3};

        int[][] arr1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8 , 9}
        };

        int[][] array = new int[3][4];
        for (int row = 0; row < array.length; row++)
            for (int col = 0; col < array[0].length; col++)
                array[row][col] = row + col;


        System.out.println();
    }
}
