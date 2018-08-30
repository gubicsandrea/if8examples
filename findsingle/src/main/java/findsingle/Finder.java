package findsingle;

import java.util.List;

public class Finder {

    public int findSingle(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("List is empty.");
        }
        for (Integer number : numbers) {
            int count = 0;
            for (Integer other : numbers) {
                if (other.equals(number)) {
                    count++;
                }
            }
            if (count == 1) {
                return number;
            }
        }
        throw new IllegalArgumentException("No single element in the list.");
    }
}
