package school;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class SchoolClassBuilderTest {

    @Test
    public void testAddTwoIdenticalStudents() {
        Student student1 = new Student("Réka", 10, LocalDate.of(2010, 10, 7));
        Student student2 = new Student("Réka", 10, LocalDate.of(2010, 10, 7));

        SchoolClass s = new SchoolClassBuilder().addStudent(student1).addStudent(student2).build();
        assertThat(s.getStudents().size(), equalTo(1));
    }
}
