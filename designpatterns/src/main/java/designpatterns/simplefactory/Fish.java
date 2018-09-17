package designpatterns.simplefactory;

public class Fish implements Animal {
    @Override
    public void eat() {
        System.out.println("I eat worm");
    }
}
