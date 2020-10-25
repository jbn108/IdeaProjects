package prog;



import java.util.ArrayList;
import java.util.List;

public class Test {

    public void test1() {
        List<Person> persons = new ArrayList<>();

        Person jonas = new Person(100, "Jonas");
        Person jonna = new Person(101, "Jonna");
        Person johan = new Person(102, "Johan");


        persons.add(jonna);
        persons.add(johan);

        jonas.setEmail("j@jj.com");
        jonna.setEmail("jonna@jj.com");
        johan.setEmail("johan@jj.com");

        for (Person person : persons) {
            System.out.println(person);
        }


    }
}
