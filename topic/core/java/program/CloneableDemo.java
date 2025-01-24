package topic.core.java.program;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Address implements Cloneable {
    private String street;
    private String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Address{" + "street='" + street + '\'' + ", city='" + city + '\'' + '}';
    }
}

class Person implements Cloneable {
    private String name;
    private Date birthDate;
    private List<String> hobbies;
    private Address address;

    public Person(String name, Date birthDate, List<String> hobbies, Address address) {
        this.name = name;
        this.birthDate = birthDate;
        this.hobbies = hobbies;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // Perform deep cloning
        Person cloned = (Person) super.clone();
        cloned.birthDate = new Date(this.birthDate.getTime()); // Deep copy of Date
        cloned.hobbies = new ArrayList<>(this.hobbies); // Deep copy of List
        cloned.address = (Address) this.address.clone(); // Deep copy of Address
        return cloned;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", hobbies=" + hobbies +
                ", address=" + address +
                '}';
    }
}

public class CloneableDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Date birthDate = new Date();
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Reading");
        hobbies.add("Gaming");
        Address address = new Address("123 Elm St", "Springfield");

        Person originalPerson = new Person("John", birthDate, hobbies, address);
        Person clonedPerson = (Person) originalPerson.clone();

        System.out.println("Original Person: " + originalPerson);
        System.out.println("Cloned Person: " + clonedPerson);

        // Modify original objects
        birthDate.setTime(0);
        hobbies.add("Swimming");
        address.setStreet("456 Oak St");

        System.out.println("\nAfter modifying original objects:");
        System.out.println("Original Person: " + originalPerson);
        System.out.println("Cloned Person: " + clonedPerson);
    }
}
