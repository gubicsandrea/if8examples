package school;

import java.time.LocalDate;

public class Student {

    private String name;
    private int grade;
    private LocalDate dob;

    public Student(String name, int grade, LocalDate dob) {
        this.name = name;
        this.grade = grade;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public LocalDate getDob() {
        return dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (grade != student.grade) return false;
        if (!name.equals(student.name)) return false;
        return dob.equals(student.dob);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + grade;
        result = 31 * result + dob.hashCode();
        return result;
    }
}
