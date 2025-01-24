package topic.core.java.program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

final class ImmutableClass {
    private final String name;
    private final Date birthDate;
    private final List<String> hobbies;

    public ImmutableClass(String name, Date birthDate, List<String> hobbies) {
        this.name = name;
        this.birthDate = new Date(birthDate.getTime());
        this.hobbies = new ArrayList<>(hobbies);
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return new Date(birthDate.getTime());
    }

    public List<String> getHobbies() {
        return Collections.unmodifiableList(hobbies);
    }

    // No setters, so fields cannot be modified
}

public class ImmutableClassDemo {
    public static void main(String[] args) {
        Date birthDate = new Date();
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Reading");
        hobbies.add("Gaming");

        ImmutableClass person = new ImmutableClass("Alice", birthDate, hobbies);

        System.out.println("Name: " + person.getName());
        System.out.println("Birth Date: " + person.getBirthDate());
        System.out.println("Hobbies: " + person.getHobbies());

        // Attempt to modify the Date
        birthDate.setTime(0);
        System.out.println("Birth Date after external modification attempt: " + person.getBirthDate());

        // Attempt to modify the List
        hobbies.add("Swimming");
        System.out.println("Hobbies after external modification attempt: " + person.getHobbies());

        // Attempt to modify the returned list
        List<String> immutableHobbies = person.getHobbies();
        // immutableHobbies.add("Dancing"); // This will throw UnsupportedOperationException
        System.out.println("Hobbies after returned list modification attempt: " + person.getHobbies());
    }
}
