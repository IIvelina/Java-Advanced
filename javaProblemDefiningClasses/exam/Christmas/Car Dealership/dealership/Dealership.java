package dealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Dealership {
    //•	name: String
    //•	capacity: int
    public String name;
    public int capacity;
    public List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    //•	Method add(Car car) – adds an entity to the data if there is an empty cell for the car.
    public void add(Car car){
        if (data.size() < capacity){
            data.add(car);
        }
    }
    //•	Method buy(String manufacturer, String model) – removes the car by given manufacturer and model, if such exists, and returns boolean.
    public boolean buy(String manufacturer, String model){
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)){
                this.data.remove(car);
                return true;
            }
        }
        return false;
    }
    //•	Method getLatestCar() – returns the latest car (by year) or null if have no cars.
    public Car getLatestCar(){
        return data.stream()
                .max(Comparator.comparingInt(Car::getYear))
                .orElse(null);
    }
    //•	Method getCar(String manufacturer, String model) – returns the car with the given manufacturer and model or null if there is no such car.
    public Car getCar(String manufacturer, String model){
        return data.stream()
                .filter(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model))
                .findFirst()
                .orElse(null);
    }
    //•	Getter getCount() – returns the number of cars.
    public int getCount(){
        return data.size();
    }
    //•	getStatistics() – returns a String in the following format:
    //o	" The cars are in a car dealership {name}:
    //{Car1}
    //{Car2}
    //(…)"

    public String getStatistics(){
        return String.format("The cars are in a car dealership %s:%n%s",
                this.name,
                data.stream()
                        .map(Car::toString)
                        .collect(Collectors.joining(System.lineSeparator())))
                .trim();
    }
}
