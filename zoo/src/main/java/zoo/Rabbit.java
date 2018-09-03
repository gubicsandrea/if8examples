package zoo;

public class Rabbit extends Animal {

    public Rabbit(String name, double weight) {
        super(name, weight);
    }

    public Rabbit(String name, double weight, ZooKeeper keeper) {
        super(name, weight, keeper);
    }

    /**
     * @return
     */
    public int hop() {
        return 20;
    }


    public void eat(Food food) {
        if (food == Food.WHEAT) {
            modifyWeight(food.getWeight());
        }
    }
}
