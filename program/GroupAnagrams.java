package program;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Arrays.stream(strs)
                .collect(Collectors.groupingBy(
                       s -> s.chars()
                               .sorted()
                               .mapToObj(c -> String.valueOf((char)c))
                               .collect(Collectors.joining()), Collectors.toList()))
                .values()
                .forEach(System.out::print);


        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String s : strs) {

            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            anagramMap.putIfAbsent(sortedStr, new ArrayList<>());
            anagramMap.get(sortedStr).add(s);
        }
        return new ArrayList<>(anagramMap.values());
    }

    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();
        
        // Example usage
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(strs);
        System.out.println(result);
    }
}
