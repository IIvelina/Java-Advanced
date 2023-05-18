package Lab;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class task2SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input1 = scanner.nextLine();

        Set<String> guests = new TreeSet<>();

        while (!input1.equals("PARTY")){
            guests.add(input1);
            input1 = scanner.nextLine();
        }
        String input2 = scanner.nextLine();
        while (!input2.equals("END")){
            guests.remove(input2);
            input2 = scanner.nextLine();
        }
        System.out.println(guests.size());
        for (String guest : guests) {
            System.out.println(guest);
        }
    }
}
