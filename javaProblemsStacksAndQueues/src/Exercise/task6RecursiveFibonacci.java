package Exercise;

import java.util.Scanner;

public class task6RecursiveFibonacci {
    public static long[] memory; //създаваме празен масив
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); //5

        //1, 1, 2, 3, 5, 8, 13, 21 ...
        //0, 1, 2, 3, 4, 5

        memory = new long[n + 1];

        if (n == 0) {
            System.out.println(0);
            return;
        }

        long result = fib(n);

        System.out.println(result);
    }

    private static long fib(int n) {
        if (n < 2) {
            return 1;   //докато не стигнем дъното т.е. 1
        }
        if (memory[n] != 0) { // ако масива на позиция n НЕ е празен, връщаме числото
            return memory[n];
        } else {
            //викаме:
            memory[n] = fib(n - 1) + fib(n - 2); // ако числото го няма в паметта, го добавяме
            return memory[n];
        }
    }
}
