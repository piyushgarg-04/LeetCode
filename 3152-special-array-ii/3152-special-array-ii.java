public class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        
        int n = nums.length;
        int[] transitions = new int[n];

        for (int i = 1; i < n; i++) {
            transitions[i] = transitions[i - 1] + ((nums[i] % 2) == (nums[i - 1] % 2) ? 1 : 0);
        }
        
        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int from = queries[i][0], to = queries[i][1];
            
            int parityMismatch = transitions[to] - transitions[from];
            result[i] = (parityMismatch == 0);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {3, 4, 1, 2, 6};
        int[][] queries1 = {{0, 4}};
        System.out.println(Arrays.toString(solution.isArraySpecial(nums1, queries1)));

        int[] nums2 = {4, 3, 1, 6};
        int[][] queries2 = {{0, 2}, {2, 3}};
        System.out.println(Arrays.toString(solution.isArraySpecial(nums2, queries2)));
    }
}
