package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class task3DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimal = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> binaryNumber = new ArrayDeque<>();

        if (decimal == 0){
            System.out.println(0);
            return;
        }

        while (decimal != 0){

            int binary = decimal % 2;
            binaryNumber.push(binary);

            decimal = decimal / 2;
        }

        while (!binaryNumber.isEmpty()){
            System.out.print(binaryNumber.pop());
        }
    }
}
