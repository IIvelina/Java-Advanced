package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet>data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    //•	Method add(Pet pet) – adds an entity to the data if there is an empty cell for the pet.
    public void add(Pet pet){
        if (data.size() < capacity){
            data.add(pet);
        }
    }
    //•	Method remove(String name) – removes the pet by given name, if such exists, and returns boolean.
        public boolean remove(String name){
            for (Pet pet : data) {
                if (pet.getName().equals(name)){
                    data.remove(pet);
                    return true;
                }
            }
            return false;
        }
    //•	Method getPet(String name, String owner) – returns the pet with the given name and owner or null if no such pet exists.
    public Pet getPet(String name, String owner){
        return data.stream()
                .filter(p -> p.getName().equals(name) && p.getOwner().equals(owner))
                .findFirst()
                .orElse(null);
    }
    //•	Method getOldestPet() – returns the oldest Pet.
    public Pet getOldestPet(){
        return data.stream()
                .max((p1,p2) -> Integer.compare(p1.getAge(), p2.getAge()))
                .get();
    }
    //•	Getter getCount – returns the number of pets.
    public int getCount(){
        return data.size();
    }
    //•	getStatistics() – returns a String in the following format:
    //o	"The clinic has the following patients:
    //{name} {owner}
    //   (…)"
    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The clinic has the following patients:").append(System.lineSeparator());
        for (Pet pet : data) {
            sb.append(pet.getName()).append(" ").append(pet.getOwner()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
