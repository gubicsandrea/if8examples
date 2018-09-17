package designpatterns.simplefactory;

public class AnimalFactory {

    public Animal create(String str) {
        switch (str) {
            case "dog":
                return new Dog();
            case "cat":
                return new Cat();
            case "bird":
                return new Bird();
            case "fish":
                return new Fish();
            default:
                throw new IllegalArgumentException("No such animal exists");
        }
    }
}
