package zoo;

public class Main {

    public static void main(String[] args) {
        Lion lion = new Lion("Leo", 150);
        Animal rabbit = new Rabbit("Roger", 10);
        Location location = new Location();
        location.addAnimal(lion, rabbit);
        lion.eat(Food.MEAT);
        if (lion instanceof CanMakeSound) {
            System.out.println(((CanMakeSound) lion).makeSound());
        }
//        System.out.println(location.getAnimals());
//        Animal found = location.findByName("Roger");
//        System.out.println(found);
//        location.remove(new Rabbit("Roger", 5));
//        System.out.println(location.getAnimals());

        //lion.eat(Food.EUKALIPTUS);
        System.out.println(lion);

        Parrot parrot = new Parrot("Gyurrika", 1);
        Animal animal = parrot;
        Object object = parrot;
        CanMove canMove = parrot;
        canMove.move();
        CanMakeSound canMakeSound = parrot;
    }
}
