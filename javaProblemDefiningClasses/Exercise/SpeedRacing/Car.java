package SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Car {
    //полета -> характеристики
    private String model;
    private double fuelAmount;
    private double priceFuelPerKm;
    private int distanceTraveled;

    //методи -> действия

    //конструктор -> метод, чрез който ние създаваме обекти от нашия клас
    public Car(String model, double fuelAmount, double priceFuelPerKm){
        //първоначално създава нов празен обект, който има: model, fuelAmount, priceFuelPerKm
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.priceFuelPerKm = priceFuelPerKm;
        this.distanceTraveled = 0;
    }

    public boolean drive (int kmDrive){
        //1.нужното количество за да преминем kmDrive
        double needFuel = kmDrive * this.priceFuelPerKm;
        if (needFuel <= this.fuelAmount){
            //можем да изминем разстоянието
            this.fuelAmount -= needFuel;
            this.distanceTraveled += kmDrive;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
       //дава обекта под формата на текст -> "{Model} {fuelAmount} {distanceTraveled}",
       return  String.format("%s %.2f %d",
               this.model, this.fuelAmount, this.distanceTraveled);
    }


}
