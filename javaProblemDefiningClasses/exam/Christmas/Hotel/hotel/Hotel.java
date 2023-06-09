package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (this.roster.size() < this.capacity) {
            roster.add(person);
        }
    }

    public boolean remove(String name) {
        return roster.removeIf(p -> p.getName().equals(name));
       /* for (Person currentP : roster) {
            if (currentP.getName().equals(name)) {
                return true;
            }
        }
        return false;

        */
    }

    public Person getPerson(String name, String hometown) {
        /*for (Person currentP : roster) {
            if (currentP.getName().equals(name) &&
                    currentP.getHometown().equals(hometown)) {
                return currentP;
            }
        }
        return null;

         */
        return roster.stream()
                .filter(person -> person.getName().equals(name)
                && person.getHometown().equals(hometown))
                .findFirst()
                .orElse(null);
    }
    public int getCount(){
        return roster.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The people in the hotel %s are:",this.name))
                .append(System.lineSeparator());
        for (Person currentP : roster){
            sb.append(currentP).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
