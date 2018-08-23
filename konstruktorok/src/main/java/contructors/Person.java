package contructors;

import java.time.LocalDate;

public class Person {
    private static int count;

    private String name;
    private String address;
    private LocalDate birthDay;
    private String job;
    private String workPlace;

    public Person(String name, String address, LocalDate birthDay) {
        if (isEmpty(name) || isEmpty(address)) {
            throw new IllegalArgumentException("Strings cannot be null.");
        }
        if (birthDay == null || birthDay.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Birthday is not valid.");
        }
        this.name = name;
        this.address = address;
        this.birthDay = birthDay;
        count++;
    }

    public Person(String name, String address, LocalDate birthDay, String job, String workPlace) {
        this(name, address, birthDay);
        if (isEmpty(job) || isEmpty(workPlace)) {
            throw new IllegalArgumentException("Strings cannot be null.");
        }
        this.job = job;
        this.workPlace = workPlace;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public String getJob() {
        return job;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    private boolean isEmpty(String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        return false;
    }
}
