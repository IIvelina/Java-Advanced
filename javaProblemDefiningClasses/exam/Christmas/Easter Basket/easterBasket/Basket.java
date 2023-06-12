package easterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Basket {
    private String material;
    private int capacity;
    private List<Egg>data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    //•	Method addEgg(Egg egg) – adds an entity to the data if there is room for it
    public void addEgg(Egg egg){
        if (this.data.size() < capacity){
            this.data.add(egg);
        }
    }
    //•	Method removeEgg(string color) – removes an egg by given color,
    // if such exists, and returns boolean (true if it is removed, otherwise – false)
    public boolean removeEgg(String color){
        for (Egg egg : data) {
            if (egg.getColor().equals(color)) {
                data.remove(egg);
                return true;
            }
        }
        return false;
    }
    //•	Method getStrongestEgg()– returns the strongest egg
    public Egg getStrongestEgg(){
        return data.stream()
                .max(Comparator.comparingInt(Egg::getStrength))
                .orElse(null);
    }
    //•	Method getEgg(string color) – returns the egg with the given color
    public Egg getEgg(String color){
        for (Egg egg : data) {
            if (egg.getColor().equals(color)){
                return egg;
            }
        }
        return null;
    }
    //•	Method getCount – returns the number of eggs
    public int getCount(){
        return data.size();
    }
    //•	Method report() – returns a string in the following format (print the eggs in order of appearance):
    //o	"{material} basket contains:
    //{Egg1}
    //{Egg2}
    //(…)"
    public String report(){
        return String.format("%s basket contains:%n%s",
                this.material,
                data.stream()
                        .map(Egg::toString)
                        .collect(Collectors.joining(System.lineSeparator())))
                .trim();
    }
}
