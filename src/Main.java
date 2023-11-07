import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Person ion = new Person("Ion", 25);
        Person maria = new Person("Maria", 25);

        Hobby hobby1 = new Hobby("Tennis", 3, new ArrayList<>());
        Hobby hobby2 = new Hobby("Swimming", 2, new ArrayList<>());

        Country ro = new Country("Romania");
        Address address1 = new Address("Frigului", "Bucharest", ro);
        Address address2 = new Address("Calea Victoriei", "Bucharest", ro);

        hobby1.getAddresses().add(address1);
        hobby2.getAddresses().add(address2);

        Map<Person, List<Hobby>> personHobbiesMap = new HashMap<>();
        personHobbiesMap.put(ion, List.of(hobby1, hobby2));
        personHobbiesMap.put(maria, List.of(hobby2));

        TreeSet<Person> peopleByName = new TreeSet<>(new NameComparator().thenComparing(new AgeComparator()));
        peopleByName.addAll(personHobbiesMap.keySet());

        for (Person person : peopleByName) {
            System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
        }

        List<Hobby> hobbies = personHobbiesMap.get(ion);
        for (Hobby hobby : hobbies) {
            System.out.println("Hobby: " + hobby.getName());
                for (Address address : hobby.getAddresses()) {
                    System.out.println("Country: " + address.getCountry().getName());
                }
            }
    }
}