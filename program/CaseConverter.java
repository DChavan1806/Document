package program;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CaseConverter {

    public static String convertString(String str) {
        if (str.contains("_")) {
            // Convert from snake_case to camelCase
            return snakeToCamel(str);
        } else {
            // Convert from camelCase to snake_case
            return camelToSnake(str);
        }
    }

    // Convert from snake_case to camelCase
    public static String snakeToCamel(String str) {
        String[] parts = str.split("_");
        return parts[0] + Arrays.stream(parts)
            .skip(1)
            .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
            .collect(Collectors.joining());
    }

    // Convert from camelCase to snake_case
    public static String camelToSnake(String str) {
        return str.replaceAll("([a-z])([A-Z]+)", "$1_$2").toLowerCase();
    }

    public static void main(String[] args) {
        // Test examples
        String input1 = "ab_cd";
        String input2 = "thisIsName";

        System.out.println("Converted '" + input1 + "': " + convertString(input1));  // Output: abCd
        System.out.println("Converted '" + input2 + "': " + convertString(input2));  // Output: ab_cd
    }
}
