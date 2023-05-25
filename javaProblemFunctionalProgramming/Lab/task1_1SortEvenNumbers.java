package Lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class task1_1SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //не функционално
        //1. входни данни -> ", "
        //2. принтирам само четните числа
        //3. сортиране числата в нарастващ ред
        //4. принтираме отново само четните числа

        String input = scanner.nextLine();
        String[] splitInput = input.split(", ");
        List<Integer> numbers = new ArrayList<>();
        for (String text : splitInput) {
            numbers.add(Integer.parseInt(text));
        }
       //2. принтирам само четните числа, като след последното не трябва да има запетая
        printEvenNumber(numbers);
        System.out.println();
        //3. сортиране числата в нарастващ ред
        Collections.sort(numbers);

        //4. принтираме отново само четните числа
        for (Integer number : numbers) {
            if (number % 2 == 0){
                System.out.print(number + ", ");
            }
        }
    }

    private static void printEvenNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number % 2 == 0){
                System.out.print(number + ", ");
            }
        }
    }
}
