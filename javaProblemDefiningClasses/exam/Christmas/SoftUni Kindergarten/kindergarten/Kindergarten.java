package kindergarten;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kindergarten {
    //•	name: String
    //•	capacity: int
    //•	registry: List<Child>
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    //•	Method	 addChild(Child child) - Adds a child to the registry if there is room for it and returns true.
    // If there is no room for another child, returns false.

    public boolean addChild(Child child){
        if (registry.size() < capacity){
            registry.add(child);
            return true;
        }
        return false;
    }

    //•	Method removeChild(String firstName) - removes a child by a given firstName.
    // If removal is successful, returns true, otherwise, returns false.

    public boolean removeChild(String firstName){
        for (Child child : registry) {
            if (child.getFirstName().equals(firstName)){
                this.registry.remove(child);
                return true;
            }
        }
        return false;
    }

    //•	Getter getChildrenCount - Returns the number of all children registered.

    public int getChildrenCount(){
        return registry.size();
    }

    //•	Method getChild(String firstName) - Returns the child with the given first name.

    public Child getChild(String firstName){
        for (Child child : registry) {
            if (child.getFirstName().equals(firstName)){
                return child;
            }
        }
        return null;
    }

    //•	Method registryReport() – Orders the children by age ascending, then by first name ascending, then by last name ascending, and returns a String in the following format:
    //o	"Registered children in {kindergartenName}:
    //--
    //{child1}
    //--
    //{child2}
    //--
    //(…)
    //--
    //{childn}"


    public String registryReport() {
        StringBuilder report = new StringBuilder();
        report.append("Registered children in ").append(name).append(":\n");
        List<Child> sortedChildren = new ArrayList<>(registry);
        Collections.sort(sortedChildren, Comparator.comparingInt(Child::getAge)
                .thenComparing(Child::getFirstName)
                .thenComparing(Child::getLastName));
        for (Child child : sortedChildren) {
            report.append("--\n").append(child.toString()).append("\n");
        }
        return report.toString();
    }
}
