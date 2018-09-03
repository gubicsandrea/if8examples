package zoo;

import java.util.List;

public class Zoo {

    private List<Location> locations;

    public Zoo(List<Location> locations) {
        this.locations = locations;
    }

    public List<Location> getLocations() {
        return locations;
    }
}
