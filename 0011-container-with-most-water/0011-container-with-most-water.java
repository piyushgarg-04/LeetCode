class Solution {
    public int maxArea(int[] height) {
       int left = 0;                  
        int right = height.length - 1;
        int maxArea = 0;               

        while (left < right) {
            
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            int currentArea = width * h;
            maxArea = Math.max(maxArea, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution.maxArea(height1)); 

        int[] height2 = {1, 1};
        System.out.println(solution.maxArea(height2)); 
    }
}