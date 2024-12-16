public class Solution {
    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            
            int minIndex = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            nums[minIndex] *= multiplier;
        }
        return nums;
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {2, 1, 3, 5, 6};
        int k1 = 5;
        int multiplier1 = 2;
        System.out.println(Arrays.toString(getFinalState(nums1, k1, multiplier1)));

        // Example 2
        int[] nums2 = {1, 2};
        int k2 = 3;
        int multiplier2 = 4;
        System.out.println(Arrays.toString(getFinalState(nums2, k2, multiplier2)));
    }
}