package Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class task1ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<String> paring = new LinkedHashSet<>();

        while (!input.equals("END")){

           String[] arr = input.split(", ");
           String command = arr[0];
           String carNumber = arr[1];
            if (command.equals("IN")){
                paring.add(carNumber);
            }else if (command.equals("OUT")){
                paring.remove(carNumber);
            }
            input = scanner.nextLine();
        }
        if (paring.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }
        for (String carNum : paring) {
            System.out.println(carNum);
        }
    }
}
