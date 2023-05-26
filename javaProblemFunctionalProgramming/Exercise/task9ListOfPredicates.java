package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class task9ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       // Function<приема, връща> -> apply
       // Consumer<приема> -> void -> accept
       // Supplier<връща> -> get
       // Predicate<приема> -> връща true / false -> test
       // BiFunction<приема1, приема2, връща> -> apply
       // BiConsumer<приема1, приема2> -> void -> accept
       // BiPredicate<приема1, приема2> -> връща true / false -> test

        int n = Integer.parseInt(scanner.nextLine());

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        //отпечатм всички числа от 1 до n, ако се дели на всички числа в списъка

        BiFunction<Integer, List<Integer>, Boolean> isDivisible = ((number, list) -> {
            for (Integer numInList : list) {
                if (number % numInList != 0){
                    return false; //ако има дори едно число, което не дели моето
                }
            }
            return true;
        });
        for (int num = 1; num <=n; num++) {
            if (isDivisible.apply(num, numbers)){
                System.out.print(num + " ");
            }
        }
    }
}
