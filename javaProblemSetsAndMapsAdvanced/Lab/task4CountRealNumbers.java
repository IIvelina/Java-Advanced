package Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class task4CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        LinkedHashMap<Double, Integer> numsByOccurrences = new LinkedHashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            double currentNum = numbers[i];
            if (!numsByOccurrences.containsKey(currentNum)){
                numsByOccurrences.put(currentNum, 1);
            }else {
                int currentOccurrences = numsByOccurrences.get(currentNum);
                currentOccurrences++;
                numsByOccurrences.put(currentNum, currentOccurrences);

            }
        }
        /*
        for (Double number : numsByOccurrences.keySet()) {
            System.out.printf("%.1f -> %d%n", number, numsByOccurrences.get(number));
        }
         */
        for (Map.Entry<Double, Integer> doubleIntegerEntry : numsByOccurrences.entrySet()) {
            System.out.printf("%.1f -> %d%n", doubleIntegerEntry.getKey(), doubleIntegerEntry.getValue());
        }
    }
}
