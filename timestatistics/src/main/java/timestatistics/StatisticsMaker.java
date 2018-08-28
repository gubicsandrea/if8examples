package timestatistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatisticsMaker {

    public Statistics makeStatistics(List<String> s) {
        List<Integer> numbers = new ArrayList<>();
        for (String str : s) {
            String[] parts = str.split("\\|");
            int seconds = Integer.parseInt(parts[0]) * 3600
                    + Integer.parseInt(parts[1]) * 60
                    + Integer.parseInt(parts[2]);
            numbers.add(seconds);
        }

        Collections.sort(numbers);
        int range = numbers.get(numbers.size() - 1)
                - numbers.get(0);
        int sum = 0;
        for (int i : numbers) {
            sum += i;
        }
        int average = (int) Math.round((double) sum / numbers.size());
        int median;
        if (numbers.size() % 2 == 0) {
            median = (numbers.get(numbers.size() / 2)
                    + numbers.get(numbers.size() / 2 - 1)) / 2;
        } else {
            median = numbers.get(numbers.size() / 2);
        }

        return new Statistics(format(range), format(average), format(median));
    }

    private String format(int number) {
        int hour = number / 3600;
        int minute = (number % 3600) / 60;
        int seconds = (number % 3600) % 60;

        return hour + "|" + minute + "|" + seconds;
    }
}
