package Lab.CarConstructorsTask2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Car car;

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[]input = scanner.nextLine().split("\\s+");
            String brand = input[0];
            if (input.length > 1) {
                String model = input[1];
                int hp = Integer.parseInt(input[2]);
                car = new Car(brand, model, hp);
            }else {
                car = new Car(brand);
            }
            System.out.println(car);
        }
    }
}
