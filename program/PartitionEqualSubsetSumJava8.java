package program;

import java.util.stream.IntStream;

public class PartitionEqualSubsetSumJava8 {

    public boolean canPartition(int[] nums) {
        // Step 1: Calculate the total sum using streams
        int totalSum = IntStream.of(nums).sum();

        // Step 2: If the total sum is odd, we cannot partition it into two equal subsets
        if (totalSum % 2 != 0) {
            return false;
        }

        // Step 3: Define the target sum, which is half of the total sum
        int targetSum = totalSum / 2;

        // Step 4: Create a boolean DP array to check possible subset sums
        boolean[] dp = new boolean[targetSum + 1];
        dp[0] = true;  // Base case: A sum of 0 is always possible

        IntStream.of(nums).forEach(num -> {
            for (int i = targetSum; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        });

        // Step 7: The result will be in dp[targetSum], which tells if the subset sum is possible
        return dp[targetSum];
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSumJava8 solution = new PartitionEqualSubsetSumJava8();
        int[] nums = {1, 5, 11, 5};  // Example test case
        System.out.println(solution.canPartition(nums));  // Output: true
    }
}
