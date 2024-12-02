class Solution {
    public int threeSumClosest(int[] nums, int target) {
         Arrays.sort(nums);
        int closestSum = Integer.MAX_VALUE; // Initialize with a large value
        
        // Step 2: Iterate through the array
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1; // Left pointer
            int right = nums.length - 1; // Right pointer
            
            // Step 3: Use two pointers to find the closest sum
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                
                // Update closest sum if current is closer
                if (Math.abs(target - currentSum) < Math.abs(target - closestSum)) {
                    closestSum = currentSum;
                }
                
                // Adjust pointers based on the comparison
                if (currentSum < target) {
                    left++; // Move left pointer to increase the sum
                } else if (currentSum > target) {
                    right--; // Move right pointer to decrease the sum
                } else {
                    // Exact match found
                    return currentSum;
                }
            }
        }
        
        return closestSum;
    }
}