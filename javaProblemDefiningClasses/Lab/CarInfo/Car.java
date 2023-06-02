package CarInfo;

public class Car {
    private String model;
    private String brand;
    private int horsePower;

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void carInfo(String brand, String model, int horsePower){
       System.out.printf("The car is: %s %s - %d HP.%n", brand, model, horsePower);
   }
}
