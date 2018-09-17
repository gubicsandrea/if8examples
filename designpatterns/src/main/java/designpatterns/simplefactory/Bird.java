package designpatterns.simplefactory;

public class Bird implements Animal {

    @Override
    public void eat() {
        System.out.println("I eat seed");
    }
}
