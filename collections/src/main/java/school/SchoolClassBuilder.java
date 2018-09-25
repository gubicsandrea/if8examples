package school;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SchoolClassBuilder {
    private Set<Student> studentSet = new HashSet<>();

    public SchoolClassBuilder addStudent(Student student) {
        studentSet.add(student);
        return this;
    }

    public SchoolClass build() {
        return new SchoolClass(new ArrayList<>(studentSet));
    }
}
