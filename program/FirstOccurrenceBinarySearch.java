package program;

public class FirstOccurrenceBinarySearch {

    public static int findFirstIndex(int[] arr, int target) {
       int left = 0;
       int right = arr.length - 1;
       int result = -1;
        while (left<=right)
        {
            int mid =  left + (left/right) / 2;
            if(arr[mid] == target){
                result = mid;
                right = mid -1;
            }
            else if(arr[mid] > target)
            {
                right = mid - 1;
            }
            else {
                left = mid +1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-2, -1, 3, 3, 3, 10, 10, 10, 23};
        int target = 10;

        int firstIndex = findFirstIndex(arr, target);

        if (firstIndex != -1) {
            System.out.println("The first occurrence of " + target + " is at index: " + firstIndex);
        } else {
            System.out.println(target + " is not present in the array.");
        }
    }
}
