package DataStructures;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Kat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Long> licensePlateQueue = new ArrayDeque<>();
        String licensePlate = scanner.nextLine();
        Arrays.stream(licensePlate.split(", "))
                .map(Long::parseLong)
                .forEach(licensePlateQueue::offer);

        ArrayDeque<Long> carsStack = new ArrayDeque<>();
        String cars = scanner.nextLine();
        Arrays.stream(cars.split(", "))
                .map(Long::parseLong)
                .forEach(carsStack::push);

        long days = 0;
        long carCountRegistered = 0;

        while (!licensePlateQueue.isEmpty() && !carsStack.isEmpty()) {
            days++;

            long currentLicenseQueue = licensePlateQueue.poll();
            long currentCarsStack =  carsStack.pop();;

            if (currentLicenseQueue > currentCarsStack * 2){
                carCountRegistered += currentCarsStack;
                long numRest = currentLicenseQueue - (currentCarsStack * 2);
                licensePlateQueue.offer(numRest);

            }else if (currentLicenseQueue < currentCarsStack * 2){

                long carRest = currentCarsStack - (currentLicenseQueue / 2);
                carCountRegistered += currentCarsStack - carRest; //10
                carsStack.addLast(carRest);

            }else {

                carCountRegistered += currentCarsStack;

            }
        }
        System.out.printf("%d cars were registered for %d days!%n", carCountRegistered, days);
        if (licensePlateQueue.isEmpty() && carsStack.isEmpty()){
            System.out.println("Good job! There is no queue in front of the KAT!");
        }else if (licensePlateQueue.isEmpty()){
           long  carsWithoutLicense  = carsStack.stream()
                            .mapToLong(Long::longValue)
                                    .sum();
            System.out.printf("%d cars remain without license plates!", carsWithoutLicense);
        }else {
            long  countOfPlates  = licensePlateQueue.stream()
                    .mapToLong(Long::longValue)
                    .sum();
            System.out.printf("%d license plates remain!", countOfPlates);
        }
    }
}
