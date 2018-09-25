package school;

import java.util.Comparator;

public class StudentComparatorByGradeAndName implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (Integer.compare(o1.getGrade(), o2.getGrade()) == 0) {
            return o1.getName().compareTo(o2.getName());
        } else {
            return Integer.compare(o1.getGrade(), o2.getGrade());
        }
    }
}
