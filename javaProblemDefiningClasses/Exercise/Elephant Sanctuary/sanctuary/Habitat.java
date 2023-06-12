package sanctuary;

import java.util.ArrayList;
import java.util.List;

public class Habitat {
    private int capacity;
    List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    //•	Method add(Elephant elephant) – adds an entity to the data if there is an empty space for the elephant.
    public void add(Elephant elephant) {
        if (this.data.size() < capacity) {
            this.data.add(elephant);
        }
    }

    //•	Method remove(String name) – removes the elephant by given name, if such exists, and returns boolean.
    public boolean remove(String name) {
        Elephant elephantToRemove = data.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
        if (elephantToRemove != null) {
            data.remove(elephantToRemove);
            return true;
        } else {
            return false;
        }
    }

    //•	Method getElephant(String retiredFrom) – returns the elephant retired from the given place or null if no such elephant exists.
    public Elephant getElephant(String retiredFrom) {
        return data.stream()
                .filter(e -> e.getRetiredFrom().equals(retiredFrom))
                .findFirst()
                .orElse(null);
    }

    //•	Method getOldestElephant() – returns the oldest Elephant.
    public Elephant getOldestElephant() {
        return this.data.stream()
                .max((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()))
                .get();
    }
    //•	Getter getAllElephants() – returns the number of elephants.
        public int getAllElephants(){
        return data.size();
        }
    //•	getReport() – returns a String in the following format:
    //"Saved elephants in the park:
    //		 {name} came from: {retiredFrom}
    //          {name} came from: {retiredFrom}
    //          (…)"
    public String getReport(){
        StringBuilder sb = new StringBuilder();
        sb.append("Saved elephants in the park:").append(System.lineSeparator());
        for (Elephant elephant : data) {
            sb.append(elephant.getName()).append(" came from: ").append(elephant.getRetiredFrom()).append("\n");
        }
        return sb.toString().trim();
    }
}
