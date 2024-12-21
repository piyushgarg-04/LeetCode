class Solution {
    public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> result= new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }
    public void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result){
        if(current.size()==nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        for (int num : nums) {
            if (!current.contains(num)) {
                current.add(num); // Choose
                backtrack(nums, current, result); // Explore
                current.remove(current.size() - 1); // Un-choose
        }
    }
}
    public static void main(String[] args){
        Solution solution = new Solution();
        
        int[] nums1 = {1, 2, 3};
        System.out.println(solution.permute(nums1));
        
        int[] nums2 = {0,1};
        System.out.println(solution.permute(nums2));
        
        int[] nums3 = {};
        System.out.println(solution.permute(nums3));
    }
}
        