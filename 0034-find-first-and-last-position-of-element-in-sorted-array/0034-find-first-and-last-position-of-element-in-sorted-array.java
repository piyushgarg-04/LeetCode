public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);

        return result;
    }

    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int first = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                first = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return first;
    }

    private int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int last = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                last = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return last;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        System.out.println(java.util.Arrays.toString(solution.searchRange(nums1, target1))); 

        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        System.out.println(java.util.Arrays.toString(solution.searchRange(nums2, target2))); 

        int[] nums3 = {};
        int target3 = 0;
        System.out.println(java.util.Arrays.toString(solution.searchRange(nums3, target3))); 
    }
}