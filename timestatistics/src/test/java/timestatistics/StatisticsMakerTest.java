package timestatistics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class StatisticsMakerTest {

    @Test
    public void testMakeStatistics() {
        List<String> list = new ArrayList<>();
        list.add("1|15|59");
        list.add("1|47|16");
        list.add("1|17|20");
        list.add("1|32|34");
        list.add("2|17|17");

        Statistics statistics = new StatisticsMaker().makeStatistics(list);

        assertThat(statistics.getRange(), equalTo("1|1|18"));
        assertThat(statistics.getAverage(), equalTo("1|38|5"));
        assertThat(statistics.getMedian(), equalTo("1|32|34"));
    }
}
