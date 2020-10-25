package prog;

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
        return "prog.Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
