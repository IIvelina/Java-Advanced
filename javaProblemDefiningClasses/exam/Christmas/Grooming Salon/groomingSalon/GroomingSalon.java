package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private int capacity;

   private List<Pet> data;



    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    //•	Method add(Pet pet) – adds an entity to the data if there is an empty place in the grooming salon for the pet.
    public void add(Pet pet){
        if (this.data.size() < capacity){
            this.data.add(pet);
        }
    }
    //•	Method remove(String name) – removes the pet by given name, if such exists, and returns boolean.
    public boolean remove(String name){
        for (Pet pet : data){
            if (pet.getName().equals(name)){
                data.remove(pet);
                return true;
            }
        }
        return false;
    }

    //•	Method getPet(String name, String owner) – returns the pet with the given name and owner or null if no such pet exists.
    public Pet getPet(String name, String owner) {
        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }
    //•	Getter getCount – returns the number of pets.
    public int getCount(){
        return data.size();
    }
    //•	getStatistics() – returns a String in the following format:
    //o	" The grooming salon has the following clients:
    //{name} {owner}
    //{name} {owner}
    //   (…)"
    public String getStatistics(){
        StringBuilder builder = new StringBuilder();
        builder.append("The grooming salon has the following clients:").append(System.lineSeparator());
        for (Pet pet : data){
            builder.append(String.format("%s %s", pet.getName(), pet.getOwner())).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }

}
