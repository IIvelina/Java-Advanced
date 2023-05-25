package Lab;

import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;

public class demoSupplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //този метод може да се замени със Supplier
        //не приема нищо
        //Supplier<връща>
        Supplier<Integer> random = () -> new Random().nextInt(51);
        System.out.println(random.get());
    }
    public static int genRandomInt(){ //целта на метода е да върне произволно цело число
        Random rnd = new Random();
        return rnd.nextInt(51);
    }
}
