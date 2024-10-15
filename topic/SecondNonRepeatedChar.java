package topic;

import java.util.LinkedHashMap;
import java.util.Map;

public class SecondNonRepeatedChar {
    
    public static char findSecondNonRepeatedChar(String str) {
        Map<Character, Integer> freqMap = new LinkedHashMap<>();
        for (char c : str.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        for (char c : str.toCharArray()) {
            if (freqMap.get(c) == 1) {
                count++;
                if (count == 2) {
                    return c;
                }
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        String input = "geeksforgeeks";
        char result = findSecondNonRepeatedChar(input);
        
        if (result != '\0') {
            System.out.println("The second non-repeated character is: " + result);
        } else {
            System.out.println("No second non-repeated character found.");
        }
    }
}
