package topic;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamInOne {
    public static void main(String[] args)
    {
        Integer[] integers = {1, 7, 8, 10, 5, 6, 12, 12};
        Map<Boolean, List<Integer>> map = Stream.of(integers)
                .collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println("Even number : " + map.get(true));
        System.out.println("Odd number : " + map.get(false));

        List<Integer> distinctNumber = Stream.of(integers)
                .distinct()
                .toList();
        System.out.println("Distinct Number : " + distinctNumber);

        String sampleString = "geeksforgeeks";
        Map<Character, Long> frequencyOfChar = sampleString.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(),
                                Collectors.counting()));
        System.out.println("Frequency Char :" + frequencyOfChar);

        Map<Integer, Long> frequencyOfElement = Stream.of(integers)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Frequency of Element :" + frequencyOfElement);

        List<Integer> reverseOrder = Stream.of(integers)
                .sorted(Comparator.reverseOrder())
                .distinct()
                .toList();
        System.out.println("Reverse Order :" + reverseOrder);

        String StringWithDelPrePost = Stream.of("ABC", "XYZ")
                .collect(Collectors.joining("-", "Pre-", "-Post"));
        // StringWithDelPrePost = Stream.of("ABC", "XYZ")
                //.collect(Collectors.joining("-"));
        System.out.println("String with - Pre and Post : " + StringWithDelPrePost);

        System.out.println("Divide by 5 :");
        Stream.of(integers).filter(i -> i % 5 ==0).forEach(System.out::println);

        int min = Stream.of(integers).min(Comparator.naturalOrder()).orElse(0);
        System.out.println("Min : "+ min);

        int max = Stream.of(integers).max(Comparator.naturalOrder()).orElse(0);
        System.out.println("Max : "+ max);

    }
}
