package program;

public class RotatedSortedArraySearch {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // To avoid overflow

            if (nums[mid] == target) {
                return mid; // Target found
            }

            // Determine which side is sorted
            if (nums[left] <= nums[mid]) { // Left side is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Search on the left side
                } else {
                    left = mid + 1; // Search on the right side
                }
            } else { // Right side is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Search on the right side
                } else {
                    right = mid - 1; // Search on the left side
                }
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        RotatedSortedArraySearch search = new RotatedSortedArraySearch();
        int[] nums = {4, 5, 6, 7, 0, 1, 2}; // Example rotated sorted array
        int target = 0; // Target to search
        int result = search.search(nums, target);
        System.out.println("Index of target " + target + ": " + result); // Output: 4
    }
}
