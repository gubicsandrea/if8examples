package designpatterns.simplefactory;

public class Dog implements Animal {

    @Override
    public void eat() {
        System.out.println("I eat bone");
    }
}
