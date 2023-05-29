package Lab.CarConstructorsTask2;

public class Car {
    private String brand;
    private String model;
    private int horsepower;

    public Car(String brand) {
        this.brand = brand;
        this.model = "unknown";
        this.horsepower = -1;
    }

    public Car(String brand, String model, int horsepower) {
        this(brand);
        this.model = model;
        this.horsepower = horsepower;
    }

    @Override
    public String toString(){
        //The car is: Chevrolet Impala - 390 HP.
        return String.format("The car is: %s %s - %d HP.",
                this.brand, this.model, this.horsepower);
    }
}
