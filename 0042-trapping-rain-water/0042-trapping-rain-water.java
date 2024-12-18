class Solution {
    public int trap(int[] height) {
       if (height == null || height.length < 3) return 0;
        
        int left = 0, right= height.length-1;
        int leftMax = 0, rightMax=0;
        int waterTrapped = 0;
        
        while(left<right){
            if(height[left]<height[right]){
                if (height[left] >= leftMax) {
                    leftMax = height[left];
            }else{
                    waterTrapped += leftMax - height[left];
                }
                left++;
        }else{
                if (height[right] >= rightMax) {
                    rightMax = height[right];
            }else{
                    waterTrapped += rightMax - height[right];
                }
                right--;
    }
}
        return waterTrapped;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Example 1 Output: " + solution.trap(height1));
        
        int[] height2 = {4,2,0,3,2,5};
        System.out.println("Example 2 Output: " + solution.trap(height2));
    }
}