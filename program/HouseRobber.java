package program;

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prev1 = 0, prev2 = 0;

        for (int num : nums) {
            int temp = prev1;
            prev1 = Math.max(prev1, prev2 + num);
            prev2 = temp;
        }

        return prev1;
    }

    public static void main(String[] args) {
        HouseRobber robber = new HouseRobber();
        int[] nums = {2, 10, 7, 9, 3, 1};  // Example input
        int maxRobbedAmount = robber.rob(nums);
        System.out.println("Maximum amount robbed: " + maxRobbedAmount);  // Output: 12
    }
}
