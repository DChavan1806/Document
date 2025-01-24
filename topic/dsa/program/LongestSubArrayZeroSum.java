package topic.dsa.program;

import java.util.*;

public class LongestSubArrayZeroSum {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(3, 4, 7, 2, -4, -7, -2, -3, 5, 6);
        int longestSubArrayLength = findLongestSubArrayWithZeroSum(integers, 0);
        System.out.println("Length of the longest sub array with zero sum: " + longestSubArrayLength);
    }

    private static int findLongestSubArrayWithZeroSum(List<Integer> integers, int expectedSum ) {
        HashMap<Integer, Integer> someOfNumber = new HashMap<>();
        int maxlen = 0;
        int sumOfEachPostion = 0;
        for (int i=0;i<integers.size();i++)
        {
            sumOfEachPostion = sumOfEachPostion + integers.get(i);
             if(sumOfEachPostion == expectedSum) {
                 maxlen = i + 1;
             }
             //if expected sum  ready present
             if(someOfNumber.containsKey(sumOfEachPostion)) {
                 maxlen = Math.max(maxlen, i - someOfNumber.get(sumOfEachPostion));
             } else {
                 someOfNumber.put(sumOfEachPostion, i);
             }
        }
        return maxlen;
    }
}