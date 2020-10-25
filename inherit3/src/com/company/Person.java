package com.company;

public class Person {
    private int id;
    String name;
    String email;

    public Person(int id, String name){
        this.id = id;
        this.name = name;
    }


    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        String r = String.format("%5d%20s%20s", id, name, email);
        return r;
    }
}
