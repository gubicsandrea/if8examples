package designpatterns;

public class PizzaBuilder {
    private String crust;
    private String topping;
    private int size;

    public PizzaBuilder setCrust(String crust) {
        if (crust == null || crust.trim().isEmpty()) {
            throw new IllegalArgumentException("blabla");
        }
        this.crust = crust;
        return this;
    }

    public PizzaBuilder setTopping(String topping) {
        this.topping = topping;
        return this;
    }

    public PizzaBuilder setSize(int size) {
        this.size = size;
        return this;
    }

    public Pizza build() {
        if (crust != null && topping != null && size >= 24) {
            return new Pizza(crust, topping, size);
        }
        throw new IllegalStateException();
    }
}
