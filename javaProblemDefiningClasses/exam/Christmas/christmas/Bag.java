package christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }


    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    //•	count() method– returns the number of presents
    public int count(){
        return data.size();
    }
    //•	add(Present present) method – adds an entity to the data if there is room for it
    public void add(Present present){
        if (data.size() < capacity){
            data.add(present);
        }
    }
    //•	remove(String name) method – removes a present by given name, if such exists,
    //and returns boolean
    public boolean remove(String name){
        for (Present present : data) {
            if (present.getName().equals(name)){
                data.remove(present);
                return true;
            }
        }
        return false;
    }
    //•	heaviestPresent() method – returns the heaviest present
    public Present heaviestPresent() {
        Present heaviest = null;
        double maxWeight = Double.MIN_VALUE;
        for (Present present : data) {
            if (present.getWeight() > maxWeight) {
                maxWeight = present.getWeight();
                heaviest = present;
            }
        }
        return heaviest;
    }
    //•	getPresent(String name) method – returns the present with the given name
    public Present getPresent(String name){
        for (Present present : data) {
            if (present.getName().equals(name)){
                return present;
            }
        }
        return null;
    }
    //•	report() method – returns a string in the following format (print the presents in order of appearance):
    //o	"{color of Bag} bag contains:
    //{Present1}
    //{Present2}
    //(…)"
    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(color).append(" bag contains:\n");
        for (Present present : data) {
            sb.append(present).append("\n");
        }
        return sb.toString();
    }
}
