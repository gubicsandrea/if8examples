package constructors;

import contructors.Person;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PersonTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();


    @Test
    public void createPerson() {
        Person person = new Person("Jack", "Homeless", LocalDate.of(1993, 10, 23));
        assertThat(person.getName(), equalTo("Jack"));
        assertThat(person.getAddress(), equalTo("Homeless"));
        assertThat(person.getBirthDay(), equalTo(LocalDate.of(1993, 10, 23)));
    }

    @Test
    public void isNameNull() {
        //Then
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Strings cannot be null.");

        //When
        new Person(null, "Homeless", LocalDate.of(1993, 10, 23));
    }

}
