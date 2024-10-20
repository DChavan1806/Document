package program;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class UniqueAtWords {
    public static void main(String[] args) {
        String[] str = {
            "This is spring boot @autowired", 
            "I don't remember @correctly", 
            "but it was like this only @qualifier annotation", 
            "@autowired @qualifier"
        };
        
        // Using Streams to find unique words starting with '@'
        Set<String> result = Arrays.stream(str)
            .flatMap(s -> Arrays.stream(s.split(" "))) // Split each string by space
            .filter(word -> word.startsWith("@"))      // Filter words starting with '@'
            .collect(Collectors.toSet());              // Collect them as a Set to ensure uniqueness

        // Print result
        System.out.println(result);
    }
}
