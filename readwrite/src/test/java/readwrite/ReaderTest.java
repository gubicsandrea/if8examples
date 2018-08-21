package readwrite;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReaderTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testCreate() {
        //Given

        //When
        Reader reader = new Reader("2;alma;körte");
        //Then
        assertThat(reader.getInput(), equalTo("2;alma;körte"));
        assertThat(reader.getOutput(), equalTo(null));
    }

    @Test
    public void testCreateWithNull() {
        //Given

        //Then
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Input cannot be null");
        //When
        Reader reader = new Reader(null);
    }

    @Test
    public void testFeldolgoz() {
        //Given
        Reader reader = new Reader("2;alma;körte");
        //When
        reader.feldolgoz();
        //Then
        assertThat(reader.getOutput(), equalTo(Arrays.asList("alma","körte")));
        assertThat(reader.getNumber(), is(2));
    }
}
