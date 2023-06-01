package SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countCars = Integer.parseInt(scanner.nextLine());

        Map<String, Car> cars = new LinkedHashMap<>();
        //запис: модел на колата -> кола

        for (int i = 0; i < countCars; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            //{Model} {FuelAmount} {FuelCostFor1km}
            String model = data[0];
            double fuelAmount = Double.parseDouble(data[1]);
            double fuelCostFor1km = Double.parseDouble(data[2]);

            Car car = new Car(model, fuelAmount, fuelCostFor1km);
            cars.put(model, car);
        }

        String command = scanner.nextLine();
        while (!command.equals("End")){
            //command = Drive {CarModel} {amountOfKm}

            String carModelToDrive = command.split("\\s+")[1];
            int kmToDrive = Integer.parseInt(command.split("\\s+")[2]);

            //взимам коя кола ще карам
            Car carToDrive = cars.get(carModelToDrive);

            //drive -> false -> горивото не ни стига да изминем пазстоянието
            //drive -> true -> горивото е стигнало и ние сме инминали разстоянието
            if (!carToDrive.drive(kmToDrive)){
                
                System.out.println("Insufficient fuel for the drive");
            }
            command = scanner.nextLine();
        }
        //{Model} {fuelAmount} {distanceTraveled}
        for (Car car : cars.values()) {
            System.out.println(car);
        }
    }
}
