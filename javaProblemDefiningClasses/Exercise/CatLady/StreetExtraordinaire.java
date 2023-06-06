package CatLady;

public class StreetExtraordinaire {
//decibels of their meowing during the night
private String name;
private double decibels;

    public StreetExtraordinaire(String name, double decibels) {
        this.name = name;
        this.decibels = decibels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDecibels() {
        return decibels;
    }

    public void setDecibels(double decibels) {
        this.decibels = decibels;
    }

    @Override
    public String toString() {
        return String.format("StreetExtraordinaire %s %.2f",
                this.name,
                this.decibels);
    }
}
