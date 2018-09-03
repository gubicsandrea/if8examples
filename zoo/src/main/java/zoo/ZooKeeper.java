package zoo;

public class ZooKeeper {

    private String name;

    public ZooKeeper(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
