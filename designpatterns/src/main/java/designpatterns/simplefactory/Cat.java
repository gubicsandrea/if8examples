package designpatterns.simplefactory;

public class Cat implements Animal {

    @Override
    public void eat() {
        System.out.println("I eat mouse");
    }
}
