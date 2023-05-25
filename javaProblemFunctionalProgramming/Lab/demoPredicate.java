package Lab;

import java.util.Scanner;
import java.util.function.Predicate;

public class demoPredicate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Predicate<Integer> връща true or false
        Predicate<Integer> isEven = number -> number % 2 == 0;
        System.out.println(isEven.test(10));
    }
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
