public class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = {1, 2, 0};
        System.out.println(solution.firstMissingPositive(nums1)); // Output: 3

        // Test Case 2
        int[] nums2 = {3, 4, -1, 1};
        System.out.println(solution.firstMissingPositive(nums2)); // Output: 2

        // Test Case 3
        int[] nums3 = {7, 8, 9, 11, 12};
        System.out.println(solution.firstMissingPositive(nums3)); // Output: 1
    }
}
