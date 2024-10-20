package program;

import java.util.Arrays;
import java.util.List;

public class UnSupportedEx {
    public static void main(String[] args) {
        String[] cities = {"HYD", "CHE", "BAN", "MUM"};
        List<String> list = Arrays.asList(cities);
        list.add("PUNE"); // This line will throw an UnsupportedOperationException
        System.out.println(list);
    }
}
