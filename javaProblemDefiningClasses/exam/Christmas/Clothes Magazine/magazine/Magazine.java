package magazine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Magazine {
    private String type;
    private int capacity;
    private List<Cloth> data;

    public Magazine(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    //•	Method addCloth(Cloth cloth) – adds an entity to the data if there is room for it
    public void addCloth(Cloth cloth) {
        if (this.data.size() < this.capacity) {
            data.add(cloth);
        }
    }

    //•	Method removeCloth(String color) – removes a cloth by given color, if such exists,
    // and returns boolean (true if it is removed, otherwise – false)

    public boolean removeCloth(String color) {

        Cloth clothToRemove = data.stream()
                .filter(c -> c.getColor().equals(color))
                .findFirst()
                .orElse(null);

        if (clothToRemove != null) {
            data.remove(clothToRemove);
            return true;
        } else {
            return false;
        }
    }

    //•	Method getSmallestCloth() – returns the smallest cloth
    public Cloth getSmallestCloth() {
        return this.data.stream()
                .min((c1, c2) -> Integer.compare(c1.getSize(), c2.getSize()))
                .get();
    }

    //•	Method getCloth(String color) – returns the cloth with the given color
    public Cloth getCloth(String color) {
        for (Cloth cloth : data) {
            if (cloth.getColor().equals(color)) {
                return cloth;
            }
        }
        return null;
    }


    //•	Method getCount – returns the number of clothes

    public int getCount() {
        return data.size();
    }

    //•	Method report() – returns a string in the following format (print the clothes in order of appearance):
    //o	"{type} magazine contains:
    //{Cloth1}
    //{Cloth2}
    //(…)"

    public String report() {
        return String.format("%s magazine contains:%n%s",
                        this.type,
                        data.stream()
                                .map(Cloth::toString)
                                .collect(Collectors.joining(System.lineSeparator())))
                .trim();
    }
}
