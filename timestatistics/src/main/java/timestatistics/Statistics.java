package timestatistics;

public class Statistics {

    private String range;
    private String average;
    private String median;

    public Statistics(String range, String average, String median) {
        this.range = range;
        this.average = average;
        this.median = median;
    }

    public String getRange() {
        return range;
    }

    public String getAverage() {
        return average;
    }

    public String getMedian() {
        return median;
    }
}
