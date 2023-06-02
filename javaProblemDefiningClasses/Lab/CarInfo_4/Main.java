package CarInfo_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> carsList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[]data = scanner.nextLine().split("\\s+");
            String brand = data[0];
            String model = data[1];
            int hp = Integer.parseInt(data[2]);

            Car car = new Car();
            car.setBrand(brand);
            car.setModel(model);
            car.setHorsePower(hp);

            carsList.add(car);
        }
        carsList.forEach(car -> System.out.println(car.carInfo()));
    }
}
