package aquarium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Aquarium {
    private String name;
    private int capacity;
    private int size; //the volume of the pool
    private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    //•	Method add(Fish fish) - add the entity if there isn't a fish with the same name and if there is enough space for it.

    public void add(Fish fish){
       if (this.fishInPool.size() < capacity){
           if (findFishForAdd(fish.getName()) == null) {
               fishInPool.add(fish);
           }
       }
    }

    public Fish findFishForAdd(String name) {
        for (Fish fish : fishInPool) {
            if (fish.getName().equals(name)) {
                return fish;
            }
        }
        return null;
    }

    //•	Method remove(String name) - removes a fish from the pool with the given name,
    // if such exists, and returns a boolean if the deletion is successful.

    public boolean remove(String name){
       Fish fishToRemove = fishInPool.stream()
               .filter(f -> f.getName().equals(name))
               .findFirst()
               .orElse(null);

       if (fishToRemove != null){
           fishInPool.remove(fishToRemove);
           return true;
       }else {
           return false;
       }
    }

    //•	Method findFish(String name) - returns a fish with the given name, it doesn't exist return null.

    public Fish findFish(String name){
        return fishInPool.stream()
                .filter(f -> f.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    //•	Method report() - returns information about the aquarium and the fish inside it in the following format:
    //"Aquarium: {name} ^ Size: {size}
    //{Fish1}
    //{Fish2}
    //…"

    public String report(){
        return String.format("Aquarium: %s ^ Size: %d%n%s",
                this.name,
                this.size,
                fishInPool.stream()
                        .map(Fish::toString)
                        .collect(Collectors.joining(System.lineSeparator())))
                .trim();
    }
}
