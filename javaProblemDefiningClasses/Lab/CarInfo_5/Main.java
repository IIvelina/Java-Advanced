package CarInfo_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Car car;

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String brand = input.split("\\s+")[0];
            String model = input.split("\\s+")[1];
            int hp = Integer.parseInt(input.split("\\s+")[2]);
            car = new Car(brand, model, hp);
            System.out.println(car);
        }
    }
}
