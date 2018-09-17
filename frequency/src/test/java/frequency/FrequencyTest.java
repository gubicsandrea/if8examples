package frequency;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class FrequencyTest {

    @Test
    public void test1() {
        String str = "8\n" +
                "1 5\n" +
                "1 6\n" +
                "3 2\n" +
                "1 10\n" +
                "1 10\n" +
                "1 6\n" +
                "2 5\n" +
                "3 2";
        List<List<Integer>> input = readInput(str);
        List<Integer> result = new Frequency().freqQuery(input);

        assertThat(result, equalTo(Arrays.asList(0, 1)));
    }

    @Test
    public void test2() {
        String str = "4\n" +
                "3 4\n" +
                "2 1003\n" +
                "1 16\n" +
                "3 1";
        List<List<Integer>> input = readInput(str);
        List<Integer> result = new Frequency().freqQuery(input);

        assertThat(result, equalTo(Arrays.asList(0, 1)));
    }

    @Test
    public void test3() {
        String str = "10\n" +
                "1 3\n" +
                "2 3\n" +
                "3 2\n" +
                "1 4\n" +
                "1 5\n" +
                "1 5\n" +
                "1 4\n" +
                "3 2\n" +
                "2 4\n" +
                "3 2";
        List<List<Integer>> input = readInput(str);
        List<Integer> result = new Frequency().freqQuery(input);

        assertThat(result, equalTo(Arrays.asList(0, 1, 1)));
    }

    private List<List<Integer>> readInput(String str) {
        Scanner scanner = new Scanner(str);
        List<List<Integer>> inputList = new ArrayList<>();
        int q = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < q; i++) {
            String[] parts = scanner.nextLine().split(" ");
            List<Integer> inner = Arrays.asList(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
            inputList.add(inner);
        }
        scanner.close();
        return inputList;
    }
}
