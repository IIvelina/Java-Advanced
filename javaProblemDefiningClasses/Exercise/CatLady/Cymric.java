package CatLady;

public class Cymric {
//length of their fur in millimeters

    private String name;
    private double furLength;

    public Cymric(String name, double furLength) {
        this.name = name;
        this.furLength = furLength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFurLength() {
        return furLength;
    }

    public void setFurLength(double furLength) {
        this.furLength = furLength;
    }
    @Override
    public String toString() {
        return String.format("Cymric %s %.2f",
                this.name,
                this.furLength);
    }
}
