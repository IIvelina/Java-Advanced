package shelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shelter {
    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    //•	Method add(Animal animal) – adds an entity to the data if there is an empty cell for the animal.
    public void add(Animal animal) {
        if (data.size() < capacity) {
            data.add(animal);
        }
    }

    //•	Method remove(String name) – removes the animal by given name, if such exists, and returns boolean.
    public boolean remove(String name) {
        for (Animal animal : data) {
            if (animal.getName().equals(name)) {
                this.data.remove(animal);
                return true;
            }
        }
        return false;
    }

    //•	Method getAnimal(String name, String caretaker) – returns the animal with the given name and caretaker or null if no such animal exists.
    public Animal getAnimal(String name, String caretaker) {
        return data.stream()
                .filter(a -> a.getName().equals(name) && a.getCaretaker().equals(caretaker))
                .findFirst()
                .orElse(null);
    }

    //•	Method getOldestAnimal() – returns the oldest Animal.
    public Animal getOldestAnimal() {
        return data.stream()
                .max(Comparator.comparingInt(Animal::getAge))
                .orElse(new Animal("", 0, ""));
    }

    //•	Getter getCount – returns the number of animals.
    public int getCount() {
        return data.size();
    }
    //•	getStatistics() – returns a String in the following format:
    //o	"The shelter has the following animals:
    //{name} {caretaker}
    //{name} {caretaker}

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The shelter has the following animals:\n");
        for (Animal animal : data) {
            sb.append(animal.getName()).append(" ").append(animal.getCaretaker()).append("\n");
        }
        return sb.toString();
    }

}
