package program;

import java.util.HashMap;

public class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If the character is already in the map, update the left pointer
            if (charMap.containsKey(currentChar)) {
                left = Math.max(left, charMap.get(currentChar) + 1);
            }

            // Update the last seen index of the current character
            charMap.put(currentChar, right);

            // Calculate the maximum length of substring
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeating solution = new LongestSubstringWithoutRepeating();

        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));  // Output: 3
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));     // Output: 1
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));    // Output: 3
    }
}
