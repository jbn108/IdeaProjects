package prog;

import java.util.ArrayList;
import java.util.List;

public class PersonsManager {
    List<Person> person;

    public PersonsManager(){
        person = new ArrayList<>();
    }

    public List<Person> getPerson() {
        return person;
    }

    public void addPerson(Person person){
        this.person.add(person);
    }

}
