package zoo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Location {

    private List<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal, Animal... animals) {
        this.animals.add(animal);
        this.animals.addAll(Arrays.asList(animals));
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public Animal findByName(String name) {
        Animal found = null;
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                found = animal;
                break;
            }
        }
        return found;
    }

    public void remove(Animal animal) {
        animals.remove(animal);
    }
}
