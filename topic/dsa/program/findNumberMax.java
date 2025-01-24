package topic.dsa.program;

import java.util.Arrays;
import java.util.stream.Stream;

public class findNumberMax {
    public static void main(String[] arg)
    {
        int[] arr = {19, 30, 15, 60};
        System.out.println(Arrays.stream(arr).max().orElse(0));

        Integer[] arr1 = {19, 30, 15, 60};
        System.out.println(Stream.of(arr1).max(Integer::compare).orElse(0));

        System.out.println(Arrays.stream(arr1).max(Integer::compare));

    }
}
