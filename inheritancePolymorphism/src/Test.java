import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();

        persons.add(new Person(100, "Jonas", "jbuus9@gmail.com"));
        persons.add(new Person(101, "Johan", "johs@gmail.com"));
        persons.add(new Person(102, "Johnny", "jayjay@gmail.com"));

        System.out.println("ID\t\tName\t\tEmail");
        for (Person person : persons){
            System.out.println(person.getId() + "\t\t" + person.getName() + "\t\t" + person.getEmail());
        }

    }
}
