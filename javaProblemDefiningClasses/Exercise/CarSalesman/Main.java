package CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Engine> engines = new ArrayList<>();

        int enginesCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < enginesCount; i++) {
            //{Model} {Power} {Displacement} {Efficiency}
            //displacements, and efficiency are optional -> може да ги нама
            // {Model} {Power} -> задължителни
            String[] engineData = scanner.nextLine().split("\\s+");
            String model = engineData[0];
            int power = Integer.parseInt(engineData[1]);

            int displacement = 0;
            String efficiency = null;
            if (engineData.length == 4) {
                displacement = Integer.parseInt(engineData[2]);
                efficiency = engineData[3];
            } else if (engineData.length == 3) {
                if (Character.isDigit(engineData[2].charAt(0))) {
                    displacement = Integer.parseInt(engineData[2]);
                } else {
                    efficiency = engineData[2];
                }
            }
            Engine engine = new Engine(model, power, displacement, efficiency);
            engines.add(engine);
        }

        //CARS
        int carsCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < carsCount; i++) {
            //"{Model} {Engine} {Weight} {Color}"
            String[] carData = scanner.nextLine().split("\\s+");
            String carModel = carData[0];
            String carEngine = carData[1]; //модел на двигателя

            //optional - > {Weight} {Color}
            int carWeight = 0;
            String carColor = null;
            if (carData.length == 4) {
                carWeight = Integer.parseInt(carData[2]);
                carColor = carData[3];
            } else if (carData.length == 3) {
                if (Character.isDigit(carData[2].charAt(0))) {
                    carWeight = Integer.parseInt(carData[2]);
                } else {
                    carColor = carData[2];
                }
            }

            //да намеря кой е двигателя от въведените
            //имам списък с налични двигатели -> да намеря двигателя със съответния модел на колата
            Engine carEngineCurrent = null;
            for(Engine engine : engines){
                if (carEngine.equals(engine.getModel())){
                    carEngineCurrent = engine;
                }
            }
            Car car = new Car(carModel, carEngineCurrent, carWeight, carColor);
            System.out.print(car.toString());
        }
    }
}

