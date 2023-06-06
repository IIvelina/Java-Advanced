package CatLady2;

public class Siamese extends Cat{
    //ear size should be kept
   // private String name;
    private double eraSize;

    public Siamese(String name, double eraSize) {
        super(name);
        this.eraSize = eraSize;
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
                this.getName(),
                this.eraSize);
    }
}

