package com.company;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public void test1() {
        List<Person> persons = new ArrayList<>();

        Person jonas = new Person(100, "Jonas");
        Person jonna = new Person(101, "Jonna");
        Person johan = new Person(102, "Johan");

        persons.add(jonas);
        persons.add(jonna);
        persons.add(johan);

        jonas.setEmail("j@jj.com");
        jonna.setEmail("jonna@jj.com");
        johan.setEmail("johan@jj.com");



        System.out.format("%5s%20s%20s%n","ID","Name","Email");
        for (Person person : persons) {
            System.out.println(person);
        }
    }

        public void test2(){
            List<Person> persons = new ArrayList<>();

            Teacher jonas = new Teacher(100, "Jonas", "JJJ");
            Teacher jonna = new Teacher(101, "Jonna", "JJO");
            Teacher johan = new Teacher(102, "Johan", "JJA");

            persons.add(jonas);
            persons.add(jonna);
            persons.add(johan);

            jonas.setEmail("j@jj.com");
            jonna.setEmail("jonna@jj.com");
            johan.setEmail("johan@jj.com");

            jonas.addSubject("Dansk");
            jonas.addSubject("Svensk");
            jonna.addSubject("Græsk");
            jonna.addSubject("Tysk");
            johan.addSubject("Polsk");
            johan.addSubject("Norsk");



            System.out.format("%5s%20s%20s%20s%20s%n","ID","Name","Email","Initials","Main");
            for (Person person : persons) {
                System.out.println(person);
            }
        }


}
