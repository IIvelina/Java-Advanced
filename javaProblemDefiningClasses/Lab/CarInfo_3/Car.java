package CarInfo_3;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    public Car(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public String carInfo(String brand, String model, int horsePower){
        StringBuilder sb = new StringBuilder();
        sb.append("The car is: ")
                .append(brand)
                .append(" ")
                .append(model)
                .append(" - ")
                .append(horsePower)
                .append(" HP.")
                .append(System.lineSeparator());
        return sb.toString();
    }

   /* @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.",
                this.brand, this.model, this.horsePower);
    }

    */
}
