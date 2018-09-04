package zoo;

public class Parrot extends Animal implements CanMove, CanMakeSound {
    public Parrot(String name, double weight) {
        super(name, weight);
    }

    public Parrot(String name, double weight, ZooKeeper keeper) {
        super(name, weight, keeper);
    }

    @Override
    public void eat(Food food) {
        if (food == Food.WHEAT) {
            modifyWeight(food.getWeight());
        }
    }

    @Override
    public String move() {
        return "I fly";
    }

    @Override
    public String makeSound() {
        return "Gyurrika vagyok";
    }
}
