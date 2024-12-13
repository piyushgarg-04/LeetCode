import java.util.PriorityQueue;
import java.util.Comparator;

public class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        boolean[] marked = new boolean[n]; // To track marked elements
        
        // Priority queue to store elements as (value, index) and sort by value, then index
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));
        
        // Add all elements with their indices to the priority queue
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        
        long score = 0; // Use long to handle large sums

        // Process the queue
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int value = current[0];
            int index = current[1];

            // If the current element is already marked, skip it
            if (marked[index]) continue;

            // Add the value to the score
            score += value;

            // Mark the current element and its adjacent elements
            marked[index] = true;
            if (index > 0 && !marked[index - 1]) marked[index - 1] = true; // Mark left neighbor if not already marked
            if (index < n - 1 && !marked[index + 1]) marked[index + 1] = true; // Mark right neighbor if not already marked
        }

        return score;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {2, 1, 3, 4, 5, 2};
        System.out.println(solution.findScore(nums1)); // Output: 7

        // Example 2
        int[] nums2 = {2, 3, 5, 1, 3, 2};
        System.out.println(solution.findScore(nums2)); // Output: 5

        // Custom Test Case
        int[] nums3 = {503815, 822615, 981789, 848204, 184352, 129026, 445421, 449385, 163666};
        System.out.println(solution.findScore(nums3));
    }
}
