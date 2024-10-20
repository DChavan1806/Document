package program;

import java.util.*;

public class IsomorphicStrings {
    public static boolean areIsomorphic(String str1, String str2) {
        if(str1.length() != str2.length())
        {
            return false;
        }

        Map<Character, Character> str1Character = new HashMap<>();
        Map<Character, Character> str2Character = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);

            if(str1Character.containsKey(ch1))
            {
                if(str1Character.get(ch1) != ch2)
                {
                    return false;
                }
            }
            else {
                str1Character.put(ch1, ch2);
            }

            if(str2Character.containsKey(ch2))
            {
                if(str2Character.get(ch2) != ch1)
                {
                    return false;
                }
            }
            else {
                str2Character.put(ch2, ch1);
            }

        }

        return true;
    }

    public static void main(String[] args) {
        String str1 = "egg";
        String str2 = "add";
        
        if (areIsomorphic(str1, str2)) {
            System.out.println(str1 + " and " + str2 + " are isomorphic.");
        } else {
            System.out.println(str1 + " and " + str2 + " are not isomorphic.");
        }
    }
}
