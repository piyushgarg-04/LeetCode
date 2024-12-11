import java.util.*;

public class Solution {
    public int maximumBeauty(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Mark range events
        for (int num : nums) {
            int start = num - k;
            int end = num + k + 1; // Exclusive
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
        }

        // Sweep-line to find the maximum overlap
        int maxBeauty = 0, currentBeauty = 0;
        for (int value : map.values()) {
            currentBeauty += value;
            maxBeauty = Math.max(maxBeauty, currentBeauty);
        }

        return maxBeauty;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {4, 6, 1, 2};
        int k1 = 2;
        System.out.println(solution.maximumBeauty(nums1, k1)); // Output: 3

        // Example 2
        int[] nums2 = {1, 1, 1, 1};
        int k2 = 10;
        System.out.println(solution.maximumBeauty(nums2, k2)); // Output: 4
    }
}
