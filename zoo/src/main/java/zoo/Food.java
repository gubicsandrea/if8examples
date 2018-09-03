package zoo;

public enum Food {
    MEAT(10.0), WHEAT(3.5), BAMBOO(2.7), EUKALIPTUS(1.5);

    private double weight;

    Food(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}
