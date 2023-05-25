package Lab;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class demoBiFunctions {
    public static void main(String[] args) {

        //BiFunctions<приема1, приема2, връща> apply
        BiFunction<Integer, Integer, Integer> sumTwoNumbers =
                (first, second) -> first + second;
        int sum = sumTwoNumbers.apply(5,6);
        System.out.println(sumTwoNumbers.apply(5, 6));

        //BiConsumer<приема1, приема2> void    accept
        BiConsumer<String, Integer> printData =
                (name, age) -> System.out.println("I am " + name
                + " I am " + age + " years old.");
        printData.accept("Ivelina", 27);

        //BiPredicate<приема1, приема2> връща true/false  test
        BiPredicate<Integer, Integer> divisible =
                (first, second) -> first % second == 0;
        System.out.println(divisible.test(45, 5));
    }
}
