
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {


        // Create persons
        Person person1 = new Person("Alice", 30);
        Person person2 = new Person("Bob", 25);

        // Create hobbies
        Hobby hobby1 = new Hobby("Cycling", 3, new ArrayList<>());
        Hobby hobby2 = new Hobby("Swimming", 2, new ArrayList<>());

        // Create addresses and countries
        Country usa = new Country("USA");
        Address address1 = new Address("123 Main St", "New York", usa);
        Address address2 = new Address("456 Elm St", "Los Angeles", usa);

        // Add addresses to hobbies
        hobby1.getAddresses().add(address1);
        hobby2.getAddresses().add(address2);

        // Create a map to associate people with their hobbies
        Map<Person, List<Hobby>> personHobbiesMap = new HashMap<>();
        personHobbiesMap.put(person1, List.of(hobby1, hobby2));
        personHobbiesMap.put(person2, List.of(hobby2));

        // Create a TreeSet with a name comparator
        TreeSet<Person> peopleByName = new TreeSet<>(new NameComparator());
        peopleByName.addAll(personHobbiesMap.keySet());

        // Iterate through the TreeSet and print names and ages
        for (Person person : peopleByName) {
            System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
        }

        // Print hobbies and countries for a specific person
        Person targetPerson = person1;
        List<Hobby> hobbies = personHobbiesMap.get(targetPerson);
        if (hobbies != null) {
            for (Hobby hobby : hobbies) {
                System.out.println("Hobby: " + hobby.getName());
                for (Address address : hobby.getAddresses()) {
                    System.out.println("Country: " + address.getCountry().getName());
                }
            }
        }
    }

}