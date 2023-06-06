package CatLady;

public class Siamese {
//ear size should be kept
    private String name;
    private double eraSize;

    public Siamese(String name, double eraSize) {
        this.name = name;
        this.eraSize = eraSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getEraSize() {
        return eraSize;
    }

    public void setEraSize(double eraSize) {
        this.eraSize = eraSize;
    }
    @Override
    public String toString() {
        return String.format("Siamese %s %.2f",
                this.name,
                this.eraSize);
    }
}
