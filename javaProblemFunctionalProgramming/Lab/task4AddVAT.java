package Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class task4AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> prices = Arrays.stream(scanner.nextLine()
                .split(", "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        Function<Double, Double> addVAT = price -> price * 1.2;

        Consumer<Double> printPrice = price ->
                System.out.printf("%.2f%n", price);
        System.out.println("Prices with VAT:");
        for (Double price : prices) {
          double priceWithVAT = addVAT.apply(price);
          printPrice.accept(priceWithVAT);
        }
    }
}
