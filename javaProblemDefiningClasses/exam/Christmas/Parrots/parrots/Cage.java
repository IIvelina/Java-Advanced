package parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    //•	getName()

    public String getName() {
        return name;
    }
    //•	getCapacity()

    public int getCapacity() {
        return capacity;
    }

    //•	add(Parrot parrot) method - adds an entity to the data if there is room for it
    public void add(Parrot parrot){
        if (this.data.size() < capacity){
            this.data.add(parrot);
        }
    }
    //•	remove(String name) method - removes a parrot by given name, if such exists, and returns boolean
    public boolean remove(String name){
        Parrot parrotToRemove = data.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);
        if (parrotToRemove != null){
            data.remove(parrotToRemove);
            return true;
        }else {
            return false;
        }
    }
    //•	sellParrot(String name) method - sell (set its available property to false without removing it from the collection)
    // the first parrot with the given name, also return the parrot

    public Parrot sellParrot(String name) {
        for (Parrot parrot : data) {
            if (parrot.getName().equals(name)) {
                parrot.setAvailable(false);
                return parrot;
            }
        }
        return null;
    }
    //•	sellParrotBySpecies(String species) method - sells and returns all parrots from that species as a List
    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> soldParrots = new ArrayList<>();
        for (Parrot parrot : data) {
            if (parrot.getSpecies().equals(species)) {
                parrot.setAvailable(false);
                soldParrots.add(parrot);
            }
        }
        return soldParrots;
    }
    //•	count() - returns the number of parrots
    public int count() {
        return data.size();
    }
    //•	report() - returns a String in the following format, including only not sold parrots:
    //o	"Parrots available at {cageName}:
    //{Parrot 1}
    //{Parrot 2}
    //(…)"

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Parrots available at ").append(name).append(":\n");
        for (Parrot parrot : data) {
            if (parrot.isAvailable()) {
                sb.append(parrot.toString()).append("\n");
            }
        }
        return sb.toString();
    }
}
