package frequency;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Frequency {

    // Complete the freqQuery function below.
    public List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> result = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();

        for (List<Integer> innerList : queries) {
            int operationCode = innerList.get(0);
            Integer number = innerList.get(1);
            switch (operationCode) {
                case 1:
                    numbers.add(number);
                    break;
                case 2:
                    numbers.remove(number);
                    break;
                case 3:
                    int exists = findFrequency(numbers, number);
                    result.add(exists);
                    break;
            }
        }
        return result;
    }

    private int findFrequency(List<Integer> numbers, Integer number) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        for (Integer n : uniqueNumbers) {
            int count = 0;
            for (Integer i : numbers) {
                if (i.equals(n)) {
                    count++;
                }
            }
            if (count == number) {
                return 1;
            }
        }
        return 0;
    }

}
