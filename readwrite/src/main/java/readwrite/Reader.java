package readwrite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {

    private String input;
    private List<String> output;
    private int number;

    public Reader(String input) {
        if(input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        this.input = input;
    }

    public void feldolgoz() {
        output = new ArrayList<>();
        Scanner scanner = new Scanner(input);
        scanner.useDelimiter(";");
        if(scanner.hasNextInt()) {
            number = scanner.nextInt();
        }
        while(scanner.hasNext()) {
            output.add(scanner.next());
        }
        scanner.close();
    }

    public List<String> getOutput() {
        return output;
    }

    public String getInput() {
        return input;
    }

    public int getNumber() {
        return number;
    }
}
