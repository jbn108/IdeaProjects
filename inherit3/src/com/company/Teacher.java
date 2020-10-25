package com.company;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {
    private String initials;
    private double salary;
    List<String> subjects;

    public Teacher(int id, String name, String initials) {
        super(id, name);
        this.initials = initials;
        subjects = new ArrayList<String>();
    }

    public void addSubject (String subject){
        this.subjects.add(subject);
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
        String r = String.format("%5d%20s%20s%20s%20s",super.getId(),
                super.getName(),super.getEmail(),this.getInitials(),subjects.get(0));
        return r;
    }
}

