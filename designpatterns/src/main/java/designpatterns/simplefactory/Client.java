package designpatterns.simplefactory;

public class Client {

    public static void main(String[] args) {
        AnimalFactory factory = new AnimalFactory();

        Animal animal = factory.create("fish");
        animal.eat();
    }
}
