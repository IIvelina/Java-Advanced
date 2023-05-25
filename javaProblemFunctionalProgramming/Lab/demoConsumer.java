package Lab;
import java.util.function.Consumer;
public class demoConsumer {
    public static void main(String[] args) {
        //Consumer<приема>
        Consumer<String> print = text -> System.out.println(text);
        Consumer<String> print1 = text -> System.out.println(text + ".");
        Consumer<String> print2 = text -> {
            System.out.println(text);
            System.out.println(text + "?");
            text += "Test";
            System.out.println(text + ".");
        };

        print.accept("Today is Tuesday");
        print1.accept("Today is Tuesday");
        print2.accept("Today is Tuesday");
    }
    public static void print(String message){
        System.out.println(message);
    }
}
