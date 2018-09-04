package zoo;

public class Lion extends Animal implements CanMakeSound, CanMove {

    private static final String SOUND = "roar";


    public Lion(String name, double weight) {
        super(name, weight);
    }

    public Lion(String name, double weight, ZooKeeper keeper) {
        super(name, weight, keeper);
    }

    @Override
    public String makeSound() {
        return "Say " + SOUND;
    }

    @Override
    public void modifyWeight(double weight) {
        super.modifyWeight(weight / 2);
    }


    public void eat(Food food) {
        if (food == Food.MEAT) {
            this.modifyWeight(food.getWeight());
        }
    }

    @Override
    public String move() {
        return "Run";
    }
}
