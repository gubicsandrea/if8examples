package readwrite;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WriterTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testCreate() {
        //Given

        //When
        Writer writer = new Writer(Arrays.asList("2", "alma", "körte"));
        //Then
        assertThat(writer.getInput(), equalTo(Arrays.asList("2", "alma", "körte")));
        assertThat(writer.getOutput(), equalTo(null));
    }

    @Test
    public void testCreateWithNull() {
        //Given

        //Then
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Input cannot be null");
        //When
        Writer writer = new Writer(null);
    }

    @Test
    public void testCreateWithEmptyList() {
        //Given

        //Then
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Input cannot be empty");
        //When
        Writer writer = new Writer(Arrays.asList());
    }

    @Test
    public void testFeldolgoz() {
        //Given
        Writer writer = new Writer(Arrays.asList("2", "alma", "körte"));
        //When
        writer.feldolgoz();
        //Then
        assertThat(writer.getOutput(), equalTo("2;alma;körte"));
    }
}
