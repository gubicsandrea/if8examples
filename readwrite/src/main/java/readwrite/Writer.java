package readwrite;

import java.util.List;

public class Writer {

    private List<String> input;
    private String output;

    public Writer(List<String> input) {
        if(input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        if(input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty");
        }
        this.input = input;
    }

    public List<String> getInput() {
        return input;
    }

    public String getOutput() {
        return output;
    }

    public void feldolgoz() {
        StringBuilder sb = new StringBuilder();
        for (String str : input) {
            sb.append(str).append(";");
        }
        output = sb.deleteCharAt(sb.length() - 1).toString();
    }
}
