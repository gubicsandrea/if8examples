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

    //TODO: implement: remove from old location as well
    public void moveAnimal(Animal animal, Location newLocation) {

    }
}
