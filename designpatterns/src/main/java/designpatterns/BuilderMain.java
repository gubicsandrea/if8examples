package designpatterns;

public class BuilderMain {

    public static void main(String[] args) {
        //PizzaBuilder builder = new PizzaBuilder();

        Pizza pizza = new PizzaBuilder()
                .setTopping("Mushroom")
                .setSize(32)
                .setCrust("Thin")
                .build();

        //Pizza pizza = builder.build();
    }
}
