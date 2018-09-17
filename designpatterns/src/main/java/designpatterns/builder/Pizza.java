package designpatterns.builder;

public class Pizza {

    private String crust;
    private String topping;
    private int size;

    public Pizza(String crust, String topping, int size) {
        this.crust = crust;
        this.topping = topping;
        this.size = size;
    }

    public String getCrust() {
        return crust;
    }

    public String getTopping() {
        return topping;
    }

    public int getSize() {
        return size;
    }
}
