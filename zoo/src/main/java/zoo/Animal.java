package zoo;

public abstract class Animal {

    private String name;
    private double weight;
    private ZooKeeper keeper;

    public Animal(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public Animal(String name, double weight, ZooKeeper keeper) {
        this(name, weight);
        this.keeper = keeper;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public void modifyWeight(double weight) {
        this.weight += weight;
    }

    public ZooKeeper getKeeper() {
        return keeper;
    }

    public void setKeeper(ZooKeeper keeper) {
        this.keeper = keeper;
    }

    public abstract void eat(Food food);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        return name.equals(animal.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return this.getClass() + "{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
