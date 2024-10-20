package program;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

// City class representing a city with a name and population
class City {
    private String name;        // City name
    private int population;     // City population

    // Constructor to initialize city name and population
    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    // Getter for city name
    public String getName() {
        return name;
    }

    // Getter for city population
    public int getPopulation() {
        return population;
    }
}

// Country class representing a country with a name and a list of cities
class Country {
    private String name;                 // Country name
    private List<City> cities;           // List of cities

    // Constructor to initialize country name
    public Country(String name) {
        this.name = name;
        this.cities = new ArrayList<>(); // Initialize the list of cities
    }

    // Method to add a city to the country
    public void addCity(City city) {
        cities.add(city);
    }

    // Getter for country name
    public String getName() {
        return name;
    }

    // Getter for the list of cities
    public List<City> getCities() {
        return cities;
    }
}

// Main class to demonstrate the functionality
public class HighestPop {
    public static void main(String[] args) {
        // Create instances of Country and City
        Country spain = new Country("Spain");
        spain.addCity(new City("Barcelona", 5520000));
        spain.addCity(new City("Madrid", 6740000));

        Country france = new Country("France");
        france.addCity(new City("Paris", 2148000));
        france.addCity(new City("Marseille", 861635));

        Country usa = new Country("USA");
        usa.addCity(new City("New York", 8419600));
        usa.addCity(new City("Los Angeles", 3980400));

        // Create a list of countries
        List<Country> countries = new ArrayList<>();
        countries.add(spain);
        countries.add(france);
        countries.add(usa);

        List<AbstractMap.SimpleEntry<Country, City>> list = countries.stream()
                .flatMap(country -> country.getCities().stream()
                        .map(city -> new HashMap.SimpleEntry<>(country, city)))
                .collect(Collectors.toList());

        Optional<Country> countryOptional = list.stream()
                .max(Comparator.comparingInt(entry -> entry.getValue().getPopulation()))
                .map(AbstractMap.SimpleEntry::getKey);

        if(countryOptional.isPresent())
        {
            Country country = countryOptional.get();
            Optional<City> city = country.getCities().stream()
                    .max(Comparator.comparingInt(City::getPopulation));
            city.ifPresent(value -> System.out.println(country.getName() + " : " + value.getName()));
        }

        countries.stream()
                .flatMap(country -> country.getCities().stream()
                        .map(city -> new AbstractMap.SimpleEntry<>(country, city)))
                .max(Comparator.comparing(countryCitySimpleEntry -> countryCitySimpleEntry.getValue().getPopulation()))
                .map(AbstractMap.SimpleEntry::getKey).ifPresent(countryWithHighestPop -> countryWithHighestPop.getCities().stream()
                        .max(Comparator.comparingInt(City::getPopulation))
                        .ifPresent(highestCity
                                -> System.out.println(countryWithHighestPop.getName() + " : " + highestCity.getName())));

    }
}
