package enums;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class DaysTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testCreate() {
        //Given
        Days day = Days.THURSDAY;

        //When
        String name = day.getHungarianName();

        //Then
        assertThat(name, equalTo("csütörtök"));
    }

    @Test
    public void testCreate2() {
        //Given
        Days day = Days.MONDAY;

        //When
        String name = day.getHungarianName();

        //Then
        assertThat(name, equalTo("hétfő"));
    }

    @Test
    public void testNext() {

        expectedException.expect(IllegalArgumentException.class);

        Days day = Days.valueOf("dfghjklé");
    }
}
