package prog;

import prog.Person;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {
    private String initials;
    private double salary;
    List<Person> subjects;


    public Teacher(int id, String name, String initials) {
        super(id, name);
        this.initials = initials;
        subjects = new ArrayList<>();
    }

    public List<Person> getSubjects() {
        return subjects;
    }

    public void addSubject (Person person){
        subjects.add(person);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getInitials() {
        return initials;
    }

    @Override
    public String toString() {
        return "prog.Teacher{" +
                "initials='" + initials + '\'' +
                ", salary=" + salary +
                ", subjects=" + subjects +
                '}';
    }
}
