package program;

public class SortColors {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low++, mid++);
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high--);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SortColors sorter = new SortColors();
        int[] nums = {2, 0, 2, 1, 1, 0};  // Example input
        sorter.sortColors(nums);
        System.out.print("Sorted colors: ");
        for (int num : nums) {
            System.out.print(num + " ");  // Output: 0 0 1 1 2 2
        }
    }
}
