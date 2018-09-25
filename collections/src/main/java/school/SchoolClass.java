package school;

import java.util.*;

public class SchoolClass {

    private List<Student> students;

    public SchoolClass(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int searchStudent(Student student) {
        return students.indexOf(student);
    }

    public int getNaturalOrder(Student student) {
        List<Student> result = new ArrayList<>(students);

        result.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        //result.sort((s1, s2) -> (s1.getName().compareTo(s2.getName())));

        return result.indexOf(student);
    }

    public Student getMinStudent() {
        List<Student> result = new ArrayList<>(students);

        result.sort(new StudentComparatorByGradeAndName());
        return result.get(0);
    }

    public Student getMaxStudent() {
        return Collections.max(students, new StudentComparatorByGradeAndName());
    }

    public Map<Integer, List<Student>> collectByGrade() {
        Map<Integer, List<Student>> map = new TreeMap<>();
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            map.putIfAbsent(s.getGrade(), new ArrayList<>());
            map.get(s.getGrade()).add(s);
        }
        return map;
    }

}
